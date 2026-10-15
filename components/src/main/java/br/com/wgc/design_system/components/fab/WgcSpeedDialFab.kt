@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.fab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.previews.multi.theme.ThemePreviews
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Ação individual de um Speed Dial FAB.
 */
data class WgcSpeedDialAction(
    val id: String,
    val label: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

/**
 * WgcSpeedDialFab
 *
 * Floating Action Button corporativo com menu vertical expansível de ações rápidas.
 */
@Composable
fun WgcSpeedDialFab(
    isOpen: Boolean,
    onToggle: () -> Unit,
    actions: List<WgcSpeedDialAction>,
    modifier: Modifier = Modifier
) {
    val rotation by animateFloatAsState(
        targetValue = if (isOpen) 45f else 0f,
        label = "fab_rotation"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM.dp)
    ) {
        AnimatedVisibility(
            visible = isOpen,
            enter = slideInVertically { it } + fadeIn(),
            exit = slideOutVertically { it } + fadeOut()
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM.dp)
            ) {
                actions.forEach { action ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS.dp)
                    ) {
                        Text(
                            text = action.label,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        SmallFloatingActionButton(
                            onClick = {
                                action.onClick()
                                onToggle()
                            },
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        ) {
                            Icon(imageVector = action.icon, contentDescription = action.label)
                        }
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = onToggle,
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = if (isOpen) "Fechar menu de ações" else "Abrir menu de ações",
                modifier = Modifier.rotate(rotation)
            )
        }
    }
}

@ThemePreviews
@Composable
private fun WgcSpeedDialFabPreview() {
    WgcTheme {
        Box(
            modifier = Modifier.padding(16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            WgcSpeedDialFab(
                isOpen = true,
                onToggle = {},
                actions = listOf(
                    WgcSpeedDialAction(
                        id = "1",
                        label = "Criar novo",
                        icon = Icons.Default.Add,
                        onClick = {}
                    ),
                    WgcSpeedDialAction(
                        id = "2",
                        label = "Compartilhar",
                        icon = Icons.Default.Add,
                        onClick = {}
                    )
                )
            )
        }
    }
}
