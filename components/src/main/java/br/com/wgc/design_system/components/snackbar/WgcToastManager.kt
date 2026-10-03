@file:Suppress("MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.snackbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.delay

/**
 * Modelo de dados para mensagens de Toast flutuantes corporativas.
 */
data class WgcToastMessage(
    val id: Long = System.currentTimeMillis(),
    val message: String,
    val variant: WgcSnackbarVariant = WgcSnackbarVariant.Default,
    val durationMs: Long = 3500L
)

/**
 * Componente Toast flutuante com auto-dismiss animado.
 */
@Composable
fun WgcToastHost(
    toast: WgcToastMessage?,
    onDismiss: (WgcToastMessage) -> Unit,
    modifier: Modifier = Modifier
) {
    var visible by remember(toast?.id) { mutableStateOf(toast != null) }

    LaunchedEffect(toast?.id) {
        if (toast != null) {
            visible = true
            delay(toast.durationMs)
            visible = false
            delay(300L)
            onDismiss(toast)
        } else {
            visible = false
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.md.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        AnimatedVisibility(
            visible = visible && toast != null,
            enter = slideInVertically { -it } + fadeIn(),
            exit = slideOutVertically { -it } + fadeOut()
        ) {
            toast?.let {
                WgcSnackbar(
                    message = it.message,
                    variant = it.variant,
                    withDismissAction = true,
                    onDismissClick = {
                        visible = false
                        onDismiss(it)
                    }
                )
            }
        }
    }
}
