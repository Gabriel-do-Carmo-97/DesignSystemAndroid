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

        return bitmap.scale(finalWidth, finalHeight)
    }
}
