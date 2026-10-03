package br.com.wgc.design_system.core

/**
 * Parser e carregador de tokens remotos (JSON) recebidos de CDN ou backend corporativo.
 */
object WgcRemoteTokensLoader {

    data class RemoteTokensPayload(
        val primaryColorHex: String,
        val secondaryColorHex: String,
        val backgroundColorHex: String,
        val baseSpacingDp: Float,
        val baseRadiusDp: Float
    )

    /**
     * Interpreta cor no formato hexadecimal (#RRGGBB ou #AARRGGBB) para inteiro ARGB de 32 bits.
     */
    fun parseColorHex(hex: String): Int {
        val cleanHex = hex.trim().removePrefix("#")
        return when (cleanHex.length) {
            6 -> (0xFF shl 24) or cleanHex.toInt(16)
            8 -> cleanHex.toLong(16).toInt()
            else -> 0xFF000000.toInt()
        }
    }
}
