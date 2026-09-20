package br.com.wgc.design_system.components.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Bottom Sheet padronizado do Design System (WgcStandardBottomSheet).
 * Fornece cabeçalho estruturado, botão de fechar, slot de ações e tokens corporativos de estilo.
 *
 * @param onDismissRequest Ação disparada ao fechar ou dispensar a folha
 * @param modifier Modificador de layout
 * @param title Título exibido no cabeçalho
 * @param subtitle Subtítulo ou texto descritivo opcional
 * @param showCloseButton Define se o botão de fechar (X) é exibido no topo
 * @param sheetState Estado do BottomSheet (expandido, recolhido)
 * @param dragHandle Slot customizável para o indicador de arraste (padrão M3 por default)
 * @param actionsSlot Slot opcional para botões de ação fixos na base
 * @param content Conteúdo principal da folha
 */
@OptIn(ExperimentalMaterial3Api::class)
@Suppress("LongParameterList", "LongMethod")
@Composable
fun WgcStandardBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: String? = null,
    subtitle: String? = null,
    showCloseButton: Boolean = true,
    sheetState: SheetState = rememberModalBottomSheetState(),
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    actionsSlot: (@Composable RowScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        shape = RoundedCornerShape(
            topStart = WgcCoreDsBorderRadius.xl.dp,
            topEnd = WgcCoreDsBorderRadius.xl.dp
        ),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = WgcCoreDsElevation.level8.dp,
        dragHandle = dragHandle
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = WgcCoreDsSpacing.lg.dp,
                    end = WgcCoreDsSpacing.lg.dp,
                    bottom = WgcCoreDsSpacing.lg.dp
                )
        ) {
            if (title != null || showCloseButton) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        if (title != null) {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        if (subtitle != null) {
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
                            Text(
                                text = subtitle,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    if (showCloseButton) {
                        IconButton(onClick = onDismissRequest) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Fechar folha inferior",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
            }

            content()

            if (actionsSlot != null) {
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp),
                    content = actionsSlot
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Standard Bottom Sheet Content Preview", showBackground = true)
@Composable
private fun WgcStandardBottomSheetPreview() {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.lg.dp)
        ) {
            Text(
                text = "Título de Exemplo",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
            Text(
                text = "Conteúdo demonstrativo renderizado dentro do container padronizado.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
