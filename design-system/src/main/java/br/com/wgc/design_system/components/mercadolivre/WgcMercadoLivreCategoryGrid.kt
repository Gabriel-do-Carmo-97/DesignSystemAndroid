package br.com.wgc.design_system.components.mercadolivre

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

data class WgcMercadoLivreCategoryItem(
    val id: String,
    val name: String,
    val emoji: String,
    val backgroundColor: Color = Color.White
)

/**
 * Carrossel de Categorias Circulares do Mercado Livre (WgcMercadoLivreCategoryGrid).
 */
@Composable
fun WgcMercadoLivreCategoryGrid(
    modifier: Modifier = Modifier,
    categories: List<WgcMercadoLivreCategoryItem> = listOf(
        WgcMercadoLivreCategoryItem("1", "Ofertas", "⚡", Color(0xFFFFF9C4)),
        WgcMercadoLivreCategoryItem("2", "Mercado", "🛒", Color(0xFFE3F2FD)),
        WgcMercadoLivreCategoryItem("3", "Meli+", "⭐", Color(0xFFE8EAF6)),
        WgcMercadoLivreCategoryItem("4", "Moda", "👕", Color(0xFFF3E5F5)),
        WgcMercadoLivreCategoryItem("5", "Veículos", "🚗", Color(0xFFE0F2F1))
    ),
    onCategoryClick: (WgcMercadoLivreCategoryItem) -> Unit = {}
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
                        .size(56.dp)
                        .clip(CircleShape),
                    color = category.backgroundColor,
                    shape = CircleShape,
                    shadowElevation = 2.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = category.emoji,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                Text(
                    text = category.name,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF333333)
                )
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcMercadoLivreCategoryGridPreview() {
    MaterialTheme {
        WgcMercadoLivreCategoryGrid()
    }
}
