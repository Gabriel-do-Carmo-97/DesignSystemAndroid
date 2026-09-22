package br.com.wgc.design_system.components.sections

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
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

data class WgcCircularCategoryItem(
    val id: String,
    val name: String,
    val initials: String,
    val backgroundColor: Color = Color(WgcCoreDsColors.grey100)
)

/**
 * Carrossel de Categorias Circulares Descritivo (WgcCircularCategoryRow).
 */
@Composable
fun WgcCircularCategoryRow(
    modifier: Modifier = Modifier,
    categories: List<WgcCircularCategoryItem> = listOf(
        WgcCircularCategoryItem("1", "Alimentos", "🍔", Color(WgcCoreDsColors.carePharmacyRedLight)),
        WgcCircularCategoryItem("2", "Mercado", "🛒", Color(WgcCoreDsColors.quickShopCardBlue)),
        WgcCircularCategoryItem("3", "Farmácia", "💊", Color(WgcCoreDsColors.premiumGroceryGreenLight)),
        WgcCircularCategoryItem("4", "Bebidas", "🍾", Color(WgcCoreDsColors.quickShopCardOrange)),
        WgcCircularCategoryItem("5", "Pet", "🐶", Color(WgcCoreDsColors.quickShopCardPurple))
    ),
    onCategoryClick: (WgcCircularCategoryItem) -> Unit = {}
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
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
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
private fun WgcCircularCategoryRowPreview() {
    MaterialTheme {
        WgcCircularCategoryRow()
    }
}
