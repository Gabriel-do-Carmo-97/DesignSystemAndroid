@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.filter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcFilterOption(
    val id: String,
    val label: String,
    val isSelected: Boolean = false
)

/**
 * Barra flutuante animada de filtros rápidos com chips horizontais.
 */
@Composable
fun WgcFloatingFilterBar(
    filters: List<WgcFilterOption>,
    onFilterToggle: (WgcFilterOption) -> Unit,
    modifier: Modifier = Modifier,
    isVisible: Boolean = true
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier
                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm8.dp)
                .shadow(
                    elevation = 6.dp,
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                ),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = WgcCoreDsSpacing.sm8.dp, vertical = WgcCoreDsSpacing.xxs4.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                filters.forEach { filter ->
                    FilterChip(
                        selected = filter.isSelected,
                        onClick = { onFilterToggle(filter) },
                        label = { Text(text = filter.label) }
                    )
                }
            }
        }
    }
}
