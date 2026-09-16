package br.com.wgc.design_system.components.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

data class WgcSquareCategoryItem(
    val id: String,
    val name: String,
    val emoji: String,
    val backgroundColor: Color = Color(0xFFF5F5F5)
)

/**
 * Grade de Departamentos e Categorias em Grade 4 Colunas (WgcDepartmentCategoryGrid).
 */
@Composable
fun WgcDepartmentCategoryGrid(
    modifier: Modifier = Modifier,
    categories: List<WgcSquareCategoryItem> = listOf(
        WgcSquareCategoryItem("1", "Tecnologia", "📱"),
        WgcSquareCategoryItem("2", "Eletro", "🔌"),
        WgcSquareCategoryItem("3", "Moda", "👕"),
        WgcSquareCategoryItem("4", "Casa", "🏠"),
        WgcSquareCategoryItem("5", "Beleza", "💄"),
        WgcSquareCategoryItem("6", "Esportes", "⚽"),
        WgcSquareCategoryItem("7", "Mercado", "🛒"),
        WgcSquareCategoryItem("8", "Mais", "➕")
    ),
    onCategoryClick: (WgcSquareCategoryItem) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp),
        contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
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
                    shape = CircleShape
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = category.emoji, style = MaterialTheme.typography.titleMedium)
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcDepartmentCategoryGridPreview() {
    MaterialTheme {
        WgcDepartmentCategoryGrid()
    }
}
