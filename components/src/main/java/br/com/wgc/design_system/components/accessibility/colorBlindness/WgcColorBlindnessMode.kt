@file:Suppress("MagicNumber")

package br.com.wgc.design_system.components.accessibility.colorBlindness

/**
 * Tipos de deficiência visual de cor (Daltonismo) para teste e simulação.
 */
enum class WgcColorBlindnessMode {
    NONE,
    PROTANOPIA, // Ausência de receptores vermelhos
    DEUTERANOPIA, // Ausência de receptores verdes
    TRITANOPIA // Ausência de receptores azuis
}
