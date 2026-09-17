package br.com.wgc.ds_templates.screens.gadgetshop.product

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import br.com.wgc.design_system.components.cards.WgcGadgetShopProductCard
import br.com.wgc.ds_templates.screens.gadgetshop.model.GadgetShopMockData
import br.com.wgc.ds_templates.screens.gadgetshop.model.NexkartProduct

/**
 * Tela de Listagem e Busca com Filtros oficial do ecossistema Nexkart (WgcNexkartProductListTemplate).
 * Apresenta TopAppBar em azul royal com o nome da categoria ("Sport Shoes"), sub-barra de ordenação
 * ("Sort By: Popularity") e botão de filtros, e grade de 2 colunas de produtos.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcNexkartProductListTemplate(
    modifier: Modifier = Modifier,
    categoryTitle: String = "Sport Shoes",
    sortBy: String = "Popularity",
    products: List<NexkartProduct> = GadgetShopMockData.products,
    onProductClick: (NexkartProduct) -> Unit = {},
    onFilterClick: () -> Unit = {},
    onSortClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = WgcCoreDsSpacing.sm12.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                            .background(Color.White.copy(alpha = 0.2f))
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = categoryTitle,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Opções",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(WgcCoreDsColors.gadgetShopPrimary)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Sub-barra de Ordenação e Filtro
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ordenação
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = onSortClick)
                ) {
                    Text(
                        text = "Sort By: ",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.gadgetShopSecondaryText)
                    )
                    Text(
                        text = sortBy,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.gadgetShopDark)
                    )
                }

                // Botão de Filtro
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .clickable(onClick = onFilterClick)
                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = "Filtrar",
                        tint = Color(WgcCoreDsColors.gadgetShopDark),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "Filter",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(WgcCoreDsColors.gadgetShopDark)
                    )
                }
            }

            // Grade de 2 colunas com produtos
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                items(products) { product ->
                    WgcGadgetShopProductCard(
                        modifier = Modifier.fillMaxWidth(),
                        title = product.title,
                        price = product.price,
                        originalPrice = product.originalPrice,
                        rating = product.rating,
                        reviewCount = product.reviewCount,
                        tag = product.tag,
                        imageUrl = product.imageUrl,
                        isFavorite = product.isFavorite,
                        onClick = { onProductClick(product) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartProductListTemplatePreview() {
    WgcNexkartProductListTemplate()
}
