@file:Suppress("LongMethod")

package br.com.wgc.design_system.components.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Fábrica universal de BottomSheets com sensible defaults e slots opcionais.
 */
object WgcBottomSheetFactory {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Standard(
        title: String,
        onDismissRequest: () -> Unit,
        modifier: Modifier = Modifier,
        sheetState: SheetState = rememberModalBottomSheetState(),
        actionSlot: (@Composable () -> Unit)? = null,
        content: @Composable () -> Unit
    ) {
        WgcBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = WgcCoreDsSpacing.md.dp,
                        end = WgcCoreDsSpacing.md.dp,
                        bottom = WgcCoreDsSpacing.xl.dp
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = WgcCoreDsSpacing.md.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    actionSlot?.invoke()
                }
                content()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Confirmation(
        title: String,
        message: String,
        confirmLabel: String = "Confirmar",
        dismissLabel: String = "Cancelar",
        onConfirm: () -> Unit,
        onDismissRequest: () -> Unit,
        modifier: Modifier = Modifier,
        sheetState: SheetState = rememberModalBottomSheetState()
    ) {
        Standard(
            title = title,
            onDismissRequest = onDismissRequest,
            modifier = modifier,
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
            ) {
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
                ) {
                    WgcClassicButton(
                        text = dismissLabel,
                        onClick = onDismissRequest,
                        modifier = Modifier.weight(1f)
                    )
                    WgcClassicButton(
                        text = confirmLabel,
                        onClick = {
                            onConfirm()
                            onDismissRequest()
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}
