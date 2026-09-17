package br.com.wgc.ds_templates.screens.megastore.product

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.buttons.WgcButtonVariant
import br.com.wgc.design_system.components.chip.WgcSizeSelectorChip
import br.com.wgc.ds_templates.screens.megastore.model.ShoppeProductItem
import coil3.compose.AsyncImage

/**
 * Telas 33 a 41: Detalhes do Produto, Variações de Cor/Tamanho e Avaliações Shoppe.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcShoppeProductDetailsScreenTemplate(
    modifier: Modifier = Modifier,
    product: ShoppeProductItem = ShoppeProductItem("1", "Pastel Long Sleeve", "Clothing", "$34.00", "$45.00", 25, 4.8f),
    onBackClick: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
    onBuyNowClick: () -> Unit = {}
) {
    var selectedSizeIndex by remember { mutableIntStateOf(1) }
    var selectedColorIndex by remember { mutableIntStateOf(0) }
    var isFavorite by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = Color(WgcCoreDsColors.megaStoreDark))
                    }
                },
                actions = {
                    IconButton(onClick = { isFavorite = !isFavorite }) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorito",
                            tint = if (isFavorite) Color(WgcCoreDsColors.red500) else Color(WgcCoreDsColors.megaStoreDark)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Share, contentDescription = "Compartilhar", tint = Color(WgcCoreDsColors.megaStoreDark))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
                ) {
                    WgcButton(
                        text = "Add to Cart",
                        variant = WgcButtonVariant.Outlined,
                        onClick = onAddToCartClick,
                        modifier = Modifier.weight(1f)
                    )
                    WgcButton(
                        text = "Buy Now",
                        onClick = onBuyNowClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // 1. Hero Product Image with Discount Badge
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(Color(WgcCoreDsColors.megaStoreBackground))
            ) {
                AsyncImage(
                    model = product.imageUrl,
                    contentDescription = product.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )

                if (product.discountPercent != null && product.discountPercent > 0) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.md.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs.dp))
                            .background(Color(WgcCoreDsColors.megaStorePrimary))
                            .padding(horizontal = WgcCoreDsSpacing.sm.dp, vertical = WgcCoreDsSpacing.xxs.dp)
                    ) {
                        Text(
                            text = "-${product.discountPercent}% OFF",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            // 2. Info Content
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
                Text(
                    text = product.category.uppercase(),
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(WgcCoreDsColors.megaStoreSecondaryText)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))

                Text(
                    text = product.title,
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Black),
                    color = Color(WgcCoreDsColors.megaStoreDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = product.price,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Black),
                        color = Color(WgcCoreDsColors.megaStorePrimary)
                    )
                    if (!product.originalPrice.isNullOrBlank()) {
                        Spacer(modifier = Modifier.size(WgcCoreDsSpacing.sm.dp))
                        Text(
                            text = product.originalPrice,
                            style = MaterialTheme.typography.bodyLarge.copy(textDecoration = TextDecoration.LineThrough),
                            color = Color(WgcCoreDsColors.megaStoreSecondaryText)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(Icons.Default.Star, contentDescription = null, tint = Color(WgcCoreDsColors.megaStoreGold), modifier = Modifier.size(16.dp))
                    Text(text = " ${product.rating} (${product.reviewCount} reviews)", fontSize = 12.sp, color = Color(WgcCoreDsColors.megaStoreDark))
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

                // Color Variations
                Text(text = "Color", fontWeight = FontWeight.Bold, color = Color(WgcCoreDsColors.megaStoreDark))
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)) {
                    product.colorsHex.forEachIndexed { index, hex ->
                        val color = Color(android.graphics.Color.parseColor(hex))
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .border(
                                    width = if (selectedColorIndex == index) 2.5.dp else 1.dp,
                                    color = if (selectedColorIndex == index) Color(WgcCoreDsColors.megaStorePrimary) else Color.Transparent,
                                    shape = CircleShape
                                )
                                .padding(3.dp)
                                .clip(CircleShape)
                                .background(color)
                                .clickable { selectedColorIndex = index }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

                // Size Variations
                Text(text = "Size", fontWeight = FontWeight.Bold, color = Color(WgcCoreDsColors.megaStoreDark))
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)) {
                    product.sizes.forEachIndexed { index, size ->
                        WgcSizeSelectorChip(
                            size = size,
                            isSelected = selectedSizeIndex == index,
                            onClick = { selectedSizeIndex = index }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

                Text(text = "Description", fontWeight = FontWeight.Bold, color = Color(WgcCoreDsColors.megaStoreDark))
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.megaStoreSecondaryText)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeProductDetailsScreenTemplatePreview() {
    MaterialTheme {
        WgcShoppeProductDetailsScreenTemplate()
    }
}
