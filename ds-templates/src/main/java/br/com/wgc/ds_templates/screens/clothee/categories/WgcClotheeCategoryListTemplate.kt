package br.com.wgc.ds_templates.screens.clothee.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.ds_templates.screens.clothee.model.ClotheeCategory
import br.com.wgc.ds_templates.screens.clothee.model.ClotheeMockData

/**
 * Tela de lista de categorias do Clothee (WgcClotheeCategoryListTemplate).
 * Apresenta lista vertical de cards arredondados (#F4F4F4) com imagem à esquerda e nome da categoria.
 */
@Composable
fun WgcClotheeCategoryListTemplate(
    modifier: Modifier = Modifier,
    categories: List<ClotheeCategory> = ClotheeMockData.categories,
    onCategoryClick: (ClotheeCategory) -> Unit = {},
    onBackClick: () -> Unit = {},
    customHeaderSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (customHeaderSlot != null) {
                customHeaderSlot()
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.clotheeSurface))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(WgcCoreDsColors.clotheeDark)
                        )
                    }

                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                    Text(
                        text = "Shop by Categories",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.clotheeDark)
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    horizontal = WgcCoreDsSpacing.lg24.dp,
                    vertical = WgcCoreDsSpacing.sm12.dp
                ),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                items(categories) { category ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.clotheeSurface))
                            .clickable { onCategoryClick(category) }
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            if (!category.imageUrl.isNullOrEmpty()) {
                                AsyncImageDefault(
                                    image = category.imageUrl,
                                    contentDescription = category.name,
                                    modifier = Modifier.fillMaxSize()
                                )
                            } else {
                                Text(
                                    text = category.name.take(2).uppercase(),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.clotheePrimary)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = category.name,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(WgcCoreDsColors.clotheeDark)
                            )
                            Text(
                                text = "${category.itemCount} Items",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.clotheeSecondaryText)
                            )
                        }

                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Ver categoria",
                            tint = Color(WgcCoreDsColors.clotheeSecondaryText)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeCategoryListTemplatePreview() {
    WgcClotheeCategoryListTemplate()
}
