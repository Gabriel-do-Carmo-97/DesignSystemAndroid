@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.fab

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Ação individual de um Speed Dial FAB.
 */
data class WgcSpeedDialAction(
    val id: String,
    val label: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)
