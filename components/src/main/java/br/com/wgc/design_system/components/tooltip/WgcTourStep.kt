@file:Suppress("LongMethod", "MatchingDeclarationName")

package br.com.wgc.design_system.components.tooltip

/**
 * Modelo de passo para tours interativos guiados (Walkthrough).
 */
data class WgcTourStep(
    val stepIndex: Int,
    val title: String,
    val description: String,
    val totalSteps: Int
)
