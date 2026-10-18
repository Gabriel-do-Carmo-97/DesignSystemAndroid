@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.privacy

/**
 * Preferências de consentimento LGPD / GDPR.
 */
data class WgcPrivacyPreferences(
    val analyticsAccepted: Boolean = false,
    val marketingAccepted: Boolean = false,
)
