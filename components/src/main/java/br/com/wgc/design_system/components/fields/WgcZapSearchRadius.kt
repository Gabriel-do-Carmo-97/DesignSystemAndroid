package br.com.wgc.design_system.components.fields

/**
 * Raio geográfico de busca do Zap Imóveis.
 */
enum class WgcZapSearchRadius(val label: String) {
    EXACT("Exato"),
    RADIUS_2KM("+2 km"),
    RADIUS_5KM("+5 km"),
    RADIUS_10KM("+10 km")
}
