package br.com.wgc.design_system.components.colorpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Modal centralizado de seleção de cores baseado em Roda Cromática interativa.
 */
@Suppress("LongMethod")
@Composable
fun WgcColorPickerDialog(
    isOpen: Boolean,
    initialColor: Color,
    onDismiss: () -> Unit,
    onColorConfirmed: (Color) -> Unit,
    modifier: Modifier = Modifier,
    title: String = "Selecionar Cor",
    confirmButtonText: String = "Confirmar",
    cancelButtonText: String = "Cancelar",
    quickPalette: List<Color> = WgcColorPickerDefaults.quickPalette
) {
    if (!isOpen) return

    val (initH, initS, initV) = remember(initialColor) { WgcColorPickerUtils.colorToHsv(initialColor) }
    var hue by remember(initialColor) { mutableFloatStateOf(initH) }
    var saturation by remember(initialColor) { mutableFloatStateOf(initS) }
    var value by remember(initialColor) { mutableFloatStateOf(initV) }

    val currentColor = remember(hue, saturation, value) {
        WgcColorPickerUtils.hsvToColor(hue, saturation, value)
    }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                // 1. Título do Diálogo
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                // 2. Roda Cromática interativa
                WgcColorWheel(
                    hue = hue,
                    saturation = saturation,
                    value = value,
                    onHsvChange = { newH, newS, newV ->
                        hue = newH
                        saturation = newS
                        value = newV
                    },
                    wheelSize = 200.dp
                )

                // 3. Paleta Rápida SSOT
                if (quickPalette.isNotEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = "Paleta Rápida",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            items(quickPalette) { paletteColor ->
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(paletteColor)
                                        .border(
                                            width = if (paletteColor == currentColor) 2.dp else 1.dp,
                                            color = if (paletteColor == currentColor) MaterialTheme.colorScheme.primary else Color.LightGray,
                                            shape = CircleShape
                                        )
                                        .clickable {
                                            val (h, s, v) = WgcColorPickerUtils.colorToHsv(paletteColor)
                                            hue = h
                                            saturation = s
                                            value = v
                                        }
                                )
                            }
                        }
                    }
                }

                // 4. Prévia da Cor Selecionada & Código HEX
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(WgcCoreDsSpacing.sm12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(currentColor)
                                .border(1.dp, Color.LightGray, RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        )
                        Column {
                            Text(
                                text = "Cor Selecionada",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = WgcColorPickerUtils.colorToHex(currentColor),
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }

                // 5. Botões de Ação
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        WgcSecondaryClassicButton(
                            textButton = cancelButtonText,
                            onClick = onDismiss
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        WgcClassicButton(
                            textButton = confirmButtonText,
                            onClick = {
                                onColorConfirmed(currentColor)
                                onDismiss()
                            }
                        )
                    }
                }
            }
        }
    }
}
