package br.com.wgc.design_system.commons.image.impl

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.graphics.scale
import br.com.wgc.design_system.commons.image.contract.ImageCompressor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

/**
 * Implementação de [ImageCompressor] que executa escala/compactação nos dispatchers configurados.
 *
 * Use como implementação padrão para otimizar imagens sem bloquear a thread chamadora; os valores
 * padrão executam processamento em `Dispatchers.Default` e leitura/escrita em `Dispatchers.IO`.
 * Os dispatchers podem ser substituídos, por exemplo, em testes.
 *
 * ```kotlin
 * val bytes = DefaultImageCompressor().compressBitmap(bitmap)
 * ```
 *
 * @param defaultDispatcher Dispatcher usado para escala e compactação.
 * @param ioDispatcher Dispatcher usado para leitura e gravação de arquivos.
 */
class DefaultImageCompressor(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ImageCompressor {
    /**
     * Devolve a imagem codificada após limitar suas dimensões máximas.
     *
     * @param bitmap Imagem de origem; não é reciclada por este método.
     * @param maxWidth Largura máxima resultante em pixels.
     * @param maxHeight Altura máxima resultante em pixels.
     * @param quality Qualidade de codificação entre 0 e 100.
     * @param format Formato de saída.
     */
    override suspend fun compressBitmap(
        bitmap: Bitmap,
        maxWidth: Int,
        maxHeight: Int,
        quality: Int,
        format: Bitmap.CompressFormat,
    ): ByteArray =
        withContext(defaultDispatcher) {
            val scaledBitmap = scaleBitmapIfNeeded(bitmap, maxWidth, maxHeight)
            ByteArrayOutputStream().use { stream ->
                scaledBitmap.compress(format, quality, stream)
                if (scaledBitmap != bitmap) {
                    scaledBitmap.recycle()
                }
                stream.toByteArray()
            }
        }

    /**
     * Comprime uma imagem de arquivo e grava seus bytes no arquivo de destino.
     *
     * @param sourceFile Arquivo de imagem de origem decodificável pelo Android.
     * @param destinationFile Caminho onde gravar a imagem comprimida.
     * @param maxWidth Largura máxima resultante em pixels.
     * @param maxHeight Altura máxima resultante em pixels.
     * @param quality Qualidade de codificação entre 0 e 100.
     * @param format Formato de saída.
     * @return O mesmo arquivo de destino depois da gravação.
     * @throws IllegalStateException se a origem não puder ser decodificada.
     */
    override suspend fun compressFile(
        sourceFile: File,
        destinationFile: File,
        maxWidth: Int,
        maxHeight: Int,
        quality: Int,
        format: Bitmap.CompressFormat,
    ): File =
        withContext(ioDispatcher) {
            val bitmap =
                BitmapFactory.decodeFile(sourceFile.absolutePath)
                    ?: error("Unable to decode source image file: ${sourceFile.path}")

            val compressedBytes = compressBitmap(bitmap, maxWidth, maxHeight, quality, format)
            bitmap.recycle()

            FileOutputStream(destinationFile).use { output ->
                output.write(compressedBytes)
                output.flush()
            }
            destinationFile
        }

    private fun scaleBitmapIfNeeded(
        bitmap: Bitmap,
        maxWidth: Int,
        maxHeight: Int,
    ): Bitmap {
        val width = bitmap.width
        val height = bitmap.height

        if (width <= maxWidth && height <= maxHeight) {
            return bitmap
        }

        val ratioBitmap = width.toFloat() / height.toFloat()
        val ratioMax = maxWidth.toFloat() / maxHeight.toFloat()

        var finalWidth = maxWidth
        var finalHeight = maxHeight

        if (ratioMax > ratioBitmap) {
            finalWidth = (maxHeight.toFloat() * ratioBitmap).toInt()
        } else {
            finalHeight = (maxWidth.toFloat() / ratioBitmap).toInt()
        }

        return bitmap.scale(finalWidth, finalHeight)
    }
}
