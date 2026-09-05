package br.com.wgc.design_system.previews

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.alert.AlertType
import br.com.wgc.design_system.components.alert.WgcAlert
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.buttons.ClassicButton
import br.com.wgc.design_system.components.buttons.WgcIconButton
import br.com.wgc.design_system.components.buttons.WgcSegmentedButton
import br.com.wgc.design_system.components.buttons.secondarybutton.SecondaryClassicButton
import br.com.wgc.design_system.components.checkbox.CheckboxDefaults
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.inputs.WgcSlider
import br.com.wgc.design_system.components.inputs.WgcSwitch
import br.com.wgc.design_system.components.list.WgcListItem
import br.com.wgc.design_system.components.radio.WgcRadioButton

/**
 * Galeria Centralizada de Previews de Todos os Componentes do Design System.
 * Permite visualizar á tomos, moléculas e seus estados em um único local no Android Studio.
 */
@Composable
fun DesignSystemGalleryScreen(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(true) }
    var radioState by remember { mutableStateOf(true) }
    var chipState by remember { mutableStateOf(true) }
    var checkboxState by remember { mutableStateOf(false) }
    var sliderValue by remember { mutableStateOf(0.5f) }
    var segmentIndex by remember { mutableStateOf(0) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
        ) {
            Text(
                text = "🎨 WGC Design System Gallery",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )

            // --- SEÇÃO DE BOTÕES ---
            GallerySection(title = "1. Botões & Ações") {
                ClassicButton(textButton = "Botão Primário", onClick = {})
                ClassicButton(textButton = "Botão Carregando", isLoading = true, onClick = {})
                ClassicButton(textButton = "Botão Desabilitado", isEnabled = false, onClick = {})
                SecondaryClassicButton(textButton = "Botão Secundário", onClick = {})
                
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    WgcIconButton(onClick = {}, icon = Icons.Default.Star, contentDescription = "Favorito")
                }

                WgcSegmentedButton(
                    options = listOf("Opção 1", "Opção 2", "Opção 3"),
                    selectedIndex = segmentIndex,
                    onOptionSelected = { segmentIndex = it }
                )
            }

            // --- SEÇÃO DE INPUTS E SELEÇÃO ---
            GallerySection(title = "2. Entradas & Seleção") {
                CheckboxDefaults(
                    label = "Checkbox Padrão",
                    checked = checkboxState,
                    onCheckedChange = { checkboxState = it }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Interruptor (Switch)")
                    WgcSwitch(checked = switchState, onCheckedChange = { switchState = it })
                }

                WgcRadioButton(
                    selected = radioState,
                    label = "Botão de Rádio Selecionado",
                    onClick = { radioState = !radioState }
                )

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    WgcChip(label = "Filtro Ativo", selected = chipState, onClick = { chipState = !chipState })
                    WgcChip(label = "Filtro Inativo", selected = false, onClick = {})
                }

                Text(text = "Slider: ${(sliderValue * 100).toInt()}%")
                WgcSlider(value = sliderValue, onValueChange = { sliderValue = it })
            }

            // --- SEÇÃO DE FEEDBACK & CONTAINERS ---
            GallerySection(title = "3. Feedback & Listas") {
                WgcAlert(title = "Sucesso", message = "Operação executada com êxito.", type = AlertType.SUCCESS)
                WgcAlert(title = "Atenção", message = "Verifique os dados informados.", type = AlertType.WARNING)

                WgcListItem(
                    headlineText = "Item de Lista Principal",
                    supportingText = "Texto de suporte explicativo do item",
                    leadingContent = { WgcAvatar(initials = "WG") }
                )
            }
        }
    }
}

@Composable
fun GallerySection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary
            )
            HorizontalDivider()
            content()
        }
    }
}

@WgcComponentPreviews
@Composable
private fun DesignSystemGalleryPreview() {
    MaterialTheme {
        DesignSystemGalleryScreen()
    }
}
