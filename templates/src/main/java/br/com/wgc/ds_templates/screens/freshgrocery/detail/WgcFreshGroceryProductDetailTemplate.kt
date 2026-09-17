package br.com.wgc.ds_templates.screens.freshgrocery.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.ds_templates.screens.freshgrocery.model.FreshGroceryMockData
import br.com.wgc.ds_templates.screens.freshgrocery.model.ShopperProduct

/**
 * Tela de Detalhes do Produto Shopper:
 * - TopBar com botão voltar e botão favoritar
 * - Área de imagem grande com tag de desconto
 * - Título, avaliação (estrelas), preço
 * - Seletor de cores e tamanhos
 * - Descrição e avaliações
 * - Barra fixa inferior com botão "Add to Cart" em verde esmeralda
 */
@Composable
fun WgcShopperProductDetailTemplate(
    product: ShopperProduct = FreshGroceryMockData.products[0],
    selectedColor: String = "Green",
    selectedSize: String = "M",
    onColorSelect: (String) -> Unit = {},
    onSizeSelect: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
    gallerySlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val colors = listOf("Green", "Black", "White", "Navy")
    val sizes = listOf("S", "M", "L", "XL")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shadowElevation = WgcCoreDsElevation.level3.dp,
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .navigationBarsPadding()
                            .padding(
                                horizontal = WgcCoreDsSpacing.lg24.dp,
                                vertical = WgcCoreDsSpacing.md16.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Total Price",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                            )
                            Text(
                                text = product.price,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.megaStorerDark)
                            )
                        }

                        Button(
                            onClick = onAddToCartClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(WgcCoreDsColors.megaStorerPrimary),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                            modifier = Modifier
                                .height(WgcCoreDsSize.s48.dp)
                                .width(WgcCoreDsSize.s180.dp)
                        ) {
                            Text(
                                text = "Add to Cart",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.xs8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(WgcCoreDsColors.megaStorerDark)
                    )
                }

                Text(
                    text = "Detail Product",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.megaStorerDark)
                )

                IconButton(onClick = onFavoriteToggle) {
                    Icon(
                        imageVector = if (product.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (product.isFavorite) Color(WgcCoreDsColors.megaStorerAccent) else Color(WgcCoreDsColors.megaStorerDark)
                    )
                }
            }

            // Galeria / Imagem Grande
            if (gallerySlot != null) {
                gallerySlot()
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s280.dp)
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                        .background(Color(WgcCoreDsColors.megaStorerSurface)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "👕",
                        style = MaterialTheme.typography.displayLarge
                    )

                    if (product.discountPercent != null) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(WgcCoreDsSpacing.md16.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(Color(WgcCoreDsColors.megaStorerAccent))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.sm12.dp,
                                    vertical = WgcCoreDsSpacing.xxs4.dp
                                )
                        ) {
                            Text(
                                text = product.discountPercent,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Informações do Produto
            Column(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.lg24.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.title,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.megaStorerDark),
                        modifier = Modifier.weight(1f)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.megaStorerGold),
                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                        )
                        Text(
                            text = product.rating,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.megaStorerDark)
                        )
                        Text(
                            text = "(${product.reviewCount})",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                // Cores
                Text(
                    text = "Select Color",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.megaStorerDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
                    colors.forEach { c ->
                        val isSelected = c == selectedColor
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.megaStorerPrimary)
                                    else Color(WgcCoreDsColors.megaStorerSurface)
                                )
                                .clickable { onColorSelect(c) }
                                .padding(
                                    horizontal = WgcCoreDsSpacing.md16.dp,
                                    vertical = WgcCoreDsSpacing.xs8.dp
                                )
                        ) {
                            Text(
                                text = c,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) Color.White else Color(WgcCoreDsColors.megaStorerDark)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                // Tamanhos
                Text(
                    text = "Select Size",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.megaStorerDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
                    sizes.forEach { s ->
                        val isSelected = s == selectedSize
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s40.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.megaStorerPrimary)
                                    else Color(WgcCoreDsColors.megaStorerSurface)
                                )
                                .clickable { onSizeSelect(s) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = s,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) Color.White else Color(WgcCoreDsColors.megaStorerDark)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                // Descrição
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.megaStorerDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.megaStorerSecondaryText)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopperProductDetailTemplatePreview() {
    WgcShopperProductDetailTemplate()
}
