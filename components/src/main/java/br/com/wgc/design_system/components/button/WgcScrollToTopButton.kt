package br.com.wgc.design_system.components.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import androidx.compose.foundation.layout.Box
import br.com.wgc.design_system.commons.previews.multi.theme.ThemePreviews
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Botão flutuante para retorno rápido ao topo de listas com animação de fade in/out.
 */
@Composable
fun WgcScrollToTopButton(
    visible: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut(),
        modifier = modifier
    ) {
        FloatingActionButton(
            onClick = onClick,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Voltar ao topo"
            )
        }
    }
}

@ThemePreviews
@Composable
private fun WgcScrollToTopButtonPreview() {
    WgcTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            WgcScrollToTopButton(visible = true, onClick = {})
        }
    }
}
