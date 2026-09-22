package br.com.wgc.design_system.commons

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

private const val DEFAULT_MAX_WIDTH = 1920
private const val DEFAULT_MAX_HEIGHT = 1080
private const val DEFAULT_QUALITY = 80

/**
 * Contrato de interface para compressão e redimensionamento assíncrono de imagens no Design System WGC.
 */
interface ImageCompressor {
    /**
     * Redimensiona e comprime um [Bitmap] em memória para um array de bytes.
     *
     * @param bitmap Bitmap de origem a ser comprimido.
     * @param maxWidth Largura máxima permitida em pixels.
     * @param maxHeight Altura máxima permitida em pixels.
     * @param quality Nível de qualidade entre 0 e 100.
     * @param format Formato de compressão (padrão: JPEG).
     * @return Array de bytes comprimido.
     */
    suspend fun compressBitmap(
        bitmap: Bitmap,
        maxWidth: Int = DEFAULT_MAX_WIDTH,
        maxHeight: Int = DEFAULT_MAX_HEIGHT,
        quality: Int = DEFAULT_QUALITY,
        format: Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG,
    ): ByteArray

    /**
     * Lê, comprime e grava um arquivo de imagem no caminho de destino.
     *
     * @param sourceFile Arquivo de origem original.
     * @param destinationFile Arquivo de destino gravado.
     * @param maxWidth Largura máxima em pixels.
     * @param maxHeight Altura máxima em pixels.
     * @param quality Nível de qualidade entre 0 e 100.
     * @param format Formato de compressão.
     * @return O arquivo [destinationFile] gravado.
     */
    suspend fun compressFile(
        sourceFile: File,
        destinationFile: File,
        maxWidth: Int = DEFAULT_MAX_WIDTH,
        maxHeight: Int = DEFAULT_MAX_HEIGHT,
        quality: Int = DEFAULT_QUALITY,
        format: Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG,
    ): File
}

/**
 * Implementação padrão de [ImageCompressor] baseada em Kotlin Coroutines.
 */
class DefaultImageCompressor(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ImageCompressor {
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

        return Bitmap.createScaledBitmap(bitmap, finalWidth, finalHeight, true)
    }
}
