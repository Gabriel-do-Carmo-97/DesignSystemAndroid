@file:Suppress("MagicNumber")

package br.com.wgc.design_system.core

/**
 * Tokens de superfícies elevadas para Dark Mode calibrado (Elevated Dark Surface Levels 0 a 5).
 * Em modo escuro, a elevação é representada pelo acréscimo de luminosidade/tint sobre a superfície base.
 */
data class WgcElevatedSurfaceTokens(
    val level0: Int = 0xFF121212.toInt(),
    val level1: Int = 0xFF1E1E1E.toInt(),
    val level2: Int = 0xFF232323.toInt(),
    val level3: Int = 0xFF282828.toInt(),
    val level4: Int = 0xFF2C2C2C.toInt(),
    val level5: Int = 0xFF333333.toInt()
) {
    companion object {
        val DefaultDark = WgcElevatedSurfaceTokens()

        /**
         * Mescla a cor de tint sobre a cor base com uma dada opacidade alpha (0.0f a 1.0f).
         */
        fun blendSurfaceWithTint(baseColor: Int, tintColor: Int, alpha: Float): Int {
            val a = (255 * alpha).toInt().coerceIn(0, 255)
            val invA = 255 - a
            val r = (((tintColor shr 16) and 0xFF) * a + ((baseColor shr 16) and 0xFF) * invA) / 255
            val g = (((tintColor shr 8) and 0xFF) * a + ((baseColor shr 8) and 0xFF) * invA) / 255
            val b = ((tintColor and 0xFF) * a + (baseColor and 0xFF) * invA) / 255
            return (0xFF shl 24) or (r shl 16) or (g shl 8) or b
        }
    }
}
