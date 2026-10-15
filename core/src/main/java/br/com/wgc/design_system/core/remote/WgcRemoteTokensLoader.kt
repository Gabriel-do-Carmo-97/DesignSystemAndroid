package br.com.wgc.design_system.core.remote

/**
 * Parser e carregador de tokens remotos (JSON) recebidos de CDN ou backend corporativo.
 * Exemplo: `WgcRemoteTokensLoader.parseColorHex("#2196F3")`.
 * Quando usar: escolha esta API quando interpretar tokens recebidos de uma fonte remota.
 */
object WgcRemoteTokensLoader {

    /**
     * Interpreta cor no formato hexadecimal (#RRGGBB ou #AARRGGBB) para inteiro ARGB de 32 bits.
     */
    @Suppress("MagicNumber")
    fun parseColorHex(hex: String): Int {
        val cleanHex = hex.trim().removePrefix("#")
        return when (cleanHex.length) {
            6 -> (0xFF shl 24) or cleanHex.toInt(16)
            8 -> cleanHex.toLong(16).toInt()
            else -> 0xFF000000.toInt()
        }
    }
}
