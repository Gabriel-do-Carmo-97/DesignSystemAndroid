@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.feedback

import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning

/**
 * Variantes semânticas para o [WgcSnackbar].
 */
enum class WgcSnackbarVariant {
    Default,
    Success,
    Error,
    Warning,
    Info
}
