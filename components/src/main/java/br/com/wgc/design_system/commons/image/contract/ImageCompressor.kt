package br.com.wgc.design_system.commons.image.contract

import android.graphics.Bitmap
import br.com.wgc.design_system.commons.constants.ComponentsConstants
import java.io.File

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
        maxWidth: Int = ComponentsConstants.Image.DEFAULT_MAX_WIDTH,
        maxHeight: Int = ComponentsConstants.Image.DEFAULT_MAX_HEIGHT,
        quality: Int = ComponentsConstants.Image.DEFAULT_QUALITY,
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
        maxWidth: Int = ComponentsConstants.Image.DEFAULT_MAX_WIDTH,
        maxHeight: Int = ComponentsConstants.Image.DEFAULT_MAX_HEIGHT,
        quality: Int = ComponentsConstants.Image.DEFAULT_QUALITY,
        format: Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG,
    ): File
}
