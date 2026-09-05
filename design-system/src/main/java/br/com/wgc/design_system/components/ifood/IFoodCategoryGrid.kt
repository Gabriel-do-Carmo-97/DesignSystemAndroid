package br.com.wgc.design_system.components.ifood

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

data class IFoodCategoryItem(
    val id: String,
    val name: String,
    val initials: String,
    val backgroundColor: Color = Color(0xFFF2F2F2)
)

/**
 * Carrossel de Categorias Circulares do iFood (Restaurantes, Mercado, Farmácia, Bebidas, Pet, etc.)
 */
@Composable
fun IFoodCategoryGrid(
    modifier: Modifier = Modifier,
    categories: List<IFoodCategoryItem> = listOf(
        IFoodCategoryItem("1", "Restaurantes", "🍔", Color(0xFFFDE8EA)),
        IFoodCategoryItem("2", "Mercado", "🛒", Color(0xFFE3F2FD)),
        IFoodCategoryItem("3", "Farmácia", "💊", Color(0xFFE8F5E9)),
        IFoodCategoryItem("4", "Bebidas", "🍾", Color(0xFFFFF3E0)),
        IFoodCategoryItem("5", "Pet", "🐶", Color(0xFFF3E5F5))
    ),
    onCategoryClick: (IFoodCategoryItem) -> Unit = {}
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
                        Text(text = category.initials, style = MaterialTheme.typography.titleLarge)
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
private fun IFoodCategoryGridPreview() {
    MaterialTheme {
        IFoodCategoryGrid()
    }
}
