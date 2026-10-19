package br.com.wgc.design_system.components.cards

/**
 * Nível de plano mínimo exigido pelo Corporate Wellness / Wellness Network.
 */
enum class WgcCorporateWellnessPlanTier(val label: String, val colorHex: Long) {
    STARTER("Starter", 0xFF4B5563),
    BASIC("Basic", 0xFF0284C7),
    SILVER("Silver", 0xFF6B7280),
    GOLD("Gold", 0xFFD97706),
    PLATINUM("Platinum", 0xFF6366F1),
    DIAMOND("Diamond", 0xFF059669)
}
