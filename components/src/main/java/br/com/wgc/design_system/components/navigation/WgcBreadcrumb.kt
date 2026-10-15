@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews

/**
 * Item de trilha de navegação (Breadcrumb).
 */
data class WgcBreadcrumbItem(
    val id: String,
    val title: String
)

/**
 * WgcBreadcrumb
 *
 * Trilha hierárquica de navegação corporativa para páginas e telas com múltiplos níveis de profundidade.
 */
@Composable
fun WgcBreadcrumb(
    items: List<WgcBreadcrumbItem>,
    onItemClick: (WgcBreadcrumbItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(vertical = WgcCoreDsSpacing.XS.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEachIndexed { index, item ->
            val isLast = index == items.lastIndex
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = if (isLast) FontWeight.Bold else FontWeight.Normal,
                color = if (isLast) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.primary,
                modifier = if (!isLast) Modifier.clickable { onItemClick(item) } else Modifier
            )
            if (!isLast) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.XXS.dp)
                )
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcBreadcrumbPreview() {
    MaterialTheme {
        WgcBreadcrumb(
            items = listOf(
                WgcBreadcrumbItem(id = "1", title = "Início"),
                WgcBreadcrumbItem(id = "2", title = "Eletrônicos"),
                WgcBreadcrumbItem(id = "3", title = "Smartphones")
            ),
            onItemClick = {}
        )
    }
}
