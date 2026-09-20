package br.com.wgc.design_system.components.colorpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Ponto de entrada corporativo unificado (Factory) para seleção de cores.
 *
 * Provê alternância entre modos de apresentação ([WgcColorPickerPresentation.DIALOG] ou
 * [WgcColorPickerPresentation.BOTTOM_SHEET]), múltiplos estilos de gatilho ([WgcColorPickerTriggerType]),
 * suporte a slots customizáveis e paletas corporativas rápidas baseadas no SSOT do Design System.
 */
@Suppress("LongMethod")
@Composable
fun WgcColorPicker(
    selectedColor: Color,
    onColorSelected: (Color) -> Unit,
    modifier: Modifier = Modifier,
    presentation: WgcColorPickerPresentation = WgcColorPickerPresentation.DIALOG,
    triggerType: WgcColorPickerTriggerType = WgcColorPickerTriggerType.BADGE,
    title: String = "Selecionar Cor",
    confirmButtonText: String = "Confirmar",
    cancelButtonText: String = "Cancelar",
    quickPalette: List<Color> = WgcColorPickerDefaults.quickPalette,
    trigger: (@Composable (onClick: () -> Unit) -> Unit)? = null
) {
    var isPickerOpen by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        if (trigger != null) {
            trigger { isPickerOpen = true }
        } else {
            when (triggerType) {
                WgcColorPickerTriggerType.ICON -> {
                    IconButton(onClick = { isPickerOpen = true }) {
                        Icon(
                            imageVector = Icons.Default.Palette,
                            contentDescription = title,
                            tint = selectedColor,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
                WgcColorPickerTriggerType.BADGE -> {
                    Surface(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .clickable { isPickerOpen = true },
                        shape = CircleShape,
                        color = selectedColor,
                        shadowElevation = 2.dp
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .border(
                                    width = 2.dp,
                                    color = MaterialTheme.colorScheme.outlineVariant,
                                    shape = CircleShape
                                )
                        )
                    }
                }
            }
        }

        if (isPickerOpen) {
            when (presentation) {
                WgcColorPickerPresentation.DIALOG -> {
                    WgcColorPickerDialog(
                        isOpen = isPickerOpen,
                        initialColor = selectedColor,
                        onDismiss = { isPickerOpen = false },
                        onColorConfirmed = { newColor ->
                            onColorSelected(newColor)
                            isPickerOpen = false
                        },
                        title = title,
                        confirmButtonText = confirmButtonText,
                        cancelButtonText = cancelButtonText,
                        quickPalette = quickPalette
                    )
                }
                WgcColorPickerPresentation.BOTTOM_SHEET -> {
                    WgcColorPickerBottomSheet(
                        isOpen = isPickerOpen,
                        initialColor = selectedColor,
                        onDismiss = { isPickerOpen = false },
                        onColorConfirmed = { newColor ->
                            onColorSelected(newColor)
                            isPickerOpen = false
                        },
                        title = title,
                        confirmButtonText = confirmButtonText,
                        cancelButtonText = cancelButtonText,
                        quickPalette = quickPalette
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------
// PREVIEWS CORPORATIVOS MULTI-DEVICE E MULTI-STATUS
// -------------------------------------------------------------------------

@WgcDevicePreviews
@Preview(name = "Badge Trigger - Default", showBackground = true)
@Composable
private fun WgcColorPickerBadgePreview() {
    MaterialTheme {
        Row(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            WgcColorPicker(
                selectedColor = Color(WgcCoreDsColors.blue500),
                onColorSelected = {},
                triggerType = WgcColorPickerTriggerType.BADGE
            )
            Spacer(Modifier.width(WgcCoreDsSpacing.sm12.dp))
            Column {
                Text("Cor Ativa", style = MaterialTheme.typography.labelSmall)
                Text("#2196F3", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
            }
        }
    }
}

@WgcDevicePreviews
@Preview(name = "Icon Trigger - Default", showBackground = true)
@Composable
private fun WgcColorPickerIconPreview() {
    MaterialTheme {
        Row(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            WgcColorPicker(
                selectedColor = Color(WgcCoreDsColors.foodDeliveryRed),
                onColorSelected = {},
                triggerType = WgcColorPickerTriggerType.ICON
            )
            Spacer(Modifier.width(WgcCoreDsSpacing.sm12.dp))
            Text("Toque no ícone para escolher", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
