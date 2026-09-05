package br.com.wgc.design_system.components.nineninefood

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

data class WgcNineNineCategoryItem(
    val id: String,
    val name: String,
    val emoji: String,
    val backgroundColor: Color = Color(0xFFE1E8F0)
)

/**
 * Carrossel de Categorias Circulares da 99Food (WgcNineNineCategoryGrid).
 */
@Composable
fun WgcNineNineCategoryGrid(
    modifier: Modifier = Modifier,
    categories: List<WgcNineNineCategoryItem> = listOf(
        WgcNineNineCategoryItem("1", "Entrega 15m", "⚡", Color(0xFF0B2545)),
        WgcNineNineCategoryItem("2", "Restaurantes", "🍕", Color(0xFFE3F2FD)),
        WgcNineNineCategoryItem("3", "Cupons", "🎟️", Color(0xFFFFF8E1)),
        WgcNineNineCategoryItem("4", "Mercado", "🛒", Color(0xFFE8F5E9)),
        WgcNineNineCategoryItem("5", "Bebidas", "🥤", Color(0xFFF3E5F5))
    ),
    onCategoryClick: (WgcNineNineCategoryItem) -> Unit = {}
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        items(categories, key = { it.id }) { category ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { onCategoryClick(category) }
            ) {
                Surface(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape),
                    color = category.backgroundColor,
                    shape = CircleShape
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = category.emoji,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                Text(
                    text = category.name,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcNineNineCategoryGridPreview() {
    MaterialTheme {
        WgcNineNineCategoryGrid()
    }
}
