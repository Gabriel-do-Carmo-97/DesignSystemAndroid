@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.table

/**
 * Plano comparativo.
 */
data class WgcPricingPlan(
    val id: String,
    val name: String,
    val price: String,
    val isHighlighted: Boolean = false,
    val features: List<WgcPlanFeature>,
    val buttonLabel: String = "Escolher Plano"
)
