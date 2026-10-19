@file:Suppress("MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.snackbar

/**
 * Modelo de dados para mensagens de Toast flutuantes corporativas.
 */
data class WgcToastMessage(
    val id: Long = System.currentTimeMillis(),
    val message: String,
    val variant: WgcSnackbarVariant = WgcSnackbarVariant.Default,
    val durationMs: Long = 3500L
)
