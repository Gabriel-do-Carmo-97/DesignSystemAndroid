package br.com.wgc.ds_templates.screens.shopease.detail

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
import br.com.wgc.ds_templates.screens.shopease.model.ShopEaseMockData
import br.com.wgc.ds_templates.screens.shopease.model.ShopEaseProduct

/**
 * Tela de Detalhes do Produto ShopEase:
 * - Área de imagem superior com badge de desconto e botão de wishlist
 * - Título, avaliação (estrelas), preço
 * - Seletores de tamanho e quantidade
 * - Botões de ação "Buy now" e "Add to cart"
 */
@Composable
fun WgcShopEaseProductDetailTemplate(
    product: ShopEaseProduct = ShopEaseMockData.products[0],
    selectedSize: String = "42",
    onSizeSelect: (String) -> Unit = {},
    selectedQuantity: Int = 1,
    onBackClick: () -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
    onBuyNowClick: () -> Unit = {},
    gallerySlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val sizes = listOf("39", "40", "41", "42", "43")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
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
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    // Botão Buy Now (Contorno / Sunset)
                    Button(
                        onClick = onBuyNowClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(WgcCoreDsSize.s48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.shopEasePrimaryLight)),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                    ) {
                        Text(
                            text = "Buy now",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Botão Add to Cart (Sunset Orange Sólido)
                    Button(
                        onClick = onAddToCartClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(WgcCoreDsSize.s48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.shopEasePrimary),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                    ) {
                        Text(
                            text = "Add to cart",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold
                        )
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
            // Imagem de Destaque com Fundo Pastel e TopBar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s280.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = WgcCoreDsBorderRadius.xxl24.dp,
                            bottomEnd = WgcCoreDsBorderRadius.xxl24.dp
                        )
                    )
                    .background(product.backgroundColor)
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                // TopBar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(WgcCoreDsSize.s40.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(WgcCoreDsColors.shopEaseDark)
                        )
                    }

                    IconButton(
                        onClick = onFavoriteToggle,
                        modifier = Modifier
                            .size(WgcCoreDsSize.s40.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {
                        Icon(
                            imageVector = if (product.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (product.isFavorite) Color.Red else Color(WgcCoreDsColors.shopEaseDark)
                        )
                    }
                }

                // Ícone ou Ilustração
                Box(
                    modifier = Modifier.align(Alignment.Center),
                    contentAlignment = Alignment.Center
                ) {
                    if (gallerySlot != null) {
                        gallerySlot()
                    } else {
                        Text(
                            text = "👟",
                            style = MaterialTheme.typography.displayLarge
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

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
                        color = Color(WgcCoreDsColors.shopEaseDark),
                        modifier = Modifier.weight(1f)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.shopEasePrimary),
                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                        )
                        Text(
                            text = product.rating,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.shopEaseDark)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = product.price,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(WgcCoreDsColors.shopEasePrimaryDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                // Seletor de Tamanhos
                Text(
                    text = "Select Size",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.shopEaseDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
                    sizes.forEach { size ->
                        val isSelected = size == selectedSize
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s40.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.shopEasePrimary)
                                    else Color(WgcCoreDsColors.shopEaseSurface)
                                )
                                .clickable { onSizeSelect(size) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = size,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) Color.White else Color(WgcCoreDsColors.shopEaseDark)
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
                    color = Color(WgcCoreDsColors.shopEaseDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.shopEaseSecondaryText)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopEaseProductDetailTemplatePreview() {
    WgcShopEaseProductDetailTemplate()
}
