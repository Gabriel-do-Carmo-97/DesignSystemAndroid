package br.com.wgc.design_system.core.remote

/**
 * Valores de tokens recebidos de uma configuração remota antes da aplicação.
 *
 * Exemplo: `WgcRemoteTokensPayload("#FF2196F3", "#FFFFFFFF", "#FFFAFAFA", 16f, 8f)`.
 * Quando usar: escolha esta API quando transportar valores de tokens remotos antes de aplicá-los.
 */
data class WgcRemoteTokensPayload(
    val primaryColorHex: String,
    val secondaryColorHex: String,
    val backgroundColorHex: String,
    val baseSpacingDp: Float,
    val baseRadiusDp: Float
)
