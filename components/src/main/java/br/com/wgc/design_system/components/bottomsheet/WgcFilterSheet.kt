@file:Suppress("MatchingDeclarationName", "MagicNumber", "LongMethod")
package br.com.wgc.design_system.components.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Modelo de dados para opções de filtro por categoria.
 */
data class WgcFilterCategoryOption(
    val id: String,
    val label: String
)

/**
 * Folha inferior (Bottom Sheet) especializada para filtragem multidimensional.
 *
 * @param isVisible Se a folha está visível
 * @param onDismiss Callback para fechar a folha
 * @param categories Lista de opções de categorias para filtragem
 * @param selectedCategoryIds Conjunto de categorias atualmente selecionadas
 * @param onCategoryToggle Callback acionado ao alternar seleção de categoria
 * @param priceRange Intervalo atual de preço selecionado
 * @param priceBounds Limites mínimo e máximo permitidos de preço
 * @param onPriceRangeChange Callback acionado ao alterar faixa de preço
 * @param onClearFilters Callback acionado ao limpar todos os filtros
 * @param onApplyFilters Callback acionado ao clicar em Aplicar Filtros
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun WgcFilterSheet(
    isVisible: Boolean,
    onDismiss: () -> Unit,
    categories: List<WgcFilterCategoryOption> = emptyList(),
    selectedCategoryIds: Set<String> = emptySet(),
    onCategoryToggle: (String) -> Unit = {},
    priceRange: ClosedFloatingPointRange<Float> = 0f..500f,
    priceBounds: ClosedFloatingPointRange<Float> = 0f..1000f,
    onPriceRangeChange: (ClosedFloatingPointRange<Float>) -> Unit = {},
    onClearFilters: () -> Unit = {},
    onApplyFilters: () -> Unit = {}
) {
    if (!isVisible) return

    val activeCount = selectedCategoryIds.size + (if (priceRange != priceBounds) 1 else 0)

    WgcStandardBottomSheet(
        onDismissRequest = onDismiss,
        title = "Filtros Avançados",
        subtitle = if (activeCount > 0) "$activeCount filtro(s) ativo(s)" else "Selecione critérios de busca",
        actionsSlot = {
            WgcSecondaryClassicButton(
                modifier = Modifier.weight(1f),
                textButton = "Limpar",
                onClick = onClearFilters
            )
            WgcClassicButton(
                modifier = Modifier.weight(1f),
                textButton = "Aplicar ($activeCount)",
                onClick = {
                    onApplyFilters()
                    onDismiss()
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // 1. Categorias
            if (categories.isNotEmpty()) {
                Text(
                    text = "Categorias",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    categories.forEach { cat ->
                        val isSelected = cat.id in selectedCategoryIds
                        WgcChip(
                            label = cat.label,
                            selected = isSelected,
                            onClick = { onCategoryToggle(cat.id) }
                        )
                    }
                }
            }

            // 2. Faixa de Preço
            Text(
                text = "Faixa de Preço: R$ ${priceRange.start.toInt()} - R$ ${priceRange.endInclusive.toInt()}",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )

            RangeSlider(
                value = priceRange,
                onValueChange = onPriceRangeChange,
                valueRange = priceBounds,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.primary,
                    activeTrackColor = MaterialTheme.colorScheme.primary
                )
            )

            Spacer(Modifier.height(WgcCoreDsSpacing.xs8.dp))
        }
    }
}

@Preview(name = "WgcFilterSheet - Preview", showBackground = true)
@Composable
private fun WgcFilterSheetPreview() {
    MaterialTheme {
        WgcFilterSheet(
            isVisible = true,
            onDismiss = {},
            categories = listOf(
                WgcFilterCategoryOption("1", "Roupas"),
                WgcFilterCategoryOption("2", "Calçados"),
                WgcFilterCategoryOption("3", "Acessórios"),
                WgcFilterCategoryOption("4", "Eletrônicos")
            ),
            selectedCategoryIds = setOf("1", "3"),
            priceRange = 50f..300f
        )
    }
}
