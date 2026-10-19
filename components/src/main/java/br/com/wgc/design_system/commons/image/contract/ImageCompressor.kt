package br.com.wgc.design_system.commons.image.contract

import android.graphics.Bitmap
import br.com.wgc.design_system.commons.constants.ComponentsConstants
import java.io.File

/**
 * Contrato para redimensionar e comprimir bitmaps de forma assíncrona, em memória ou a partir de arquivo.
 *
 * Use para reduzir dimensões e tamanho de imagens antes de armazená-las ou enviá-las; injete uma
 * implementação, como [br.com.wgc.design_system.commons.image.impl.DefaultImageCompressor].
 */
interface ImageCompressor {
    /**
     * Redimensiona, se necessário, e codifica um [Bitmap] como bytes no formato escolhido.
     *
     * Use quando a imagem já está carregada e o resultado precisa ser enviado ou mantido em memória.
     * Os limites são dimensões máximas e a proporção é preservada pela implementação padrão.
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
     * Lê um arquivo de imagem, redimensiona/comprime seu bitmap e grava o resultado no destino.
     *
     * Use para gerar uma versão otimizada em disco. A implementação padrão falha se não conseguir
     * decodificar a origem.
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
