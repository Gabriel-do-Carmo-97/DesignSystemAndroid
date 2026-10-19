package br.com.wgc.design_system.factories.verticals.gadgetshop.templates.product

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.model.GadgetShopMockData
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.model.NexkartProduct

/**
 * Tela oficial de Detalhes do Produto do ecossistema Nexkart (WgcNexkartProductDetailTemplate).
 * Apresenta carrossel com indicadores de dots, título, preço em azul, botão flutuante com contagem de likes (308),
 * métricas (Ratings, Sold, Free Shipping), especificações da categoria, seletor de tamanhos e barra inferior com chat e CTA.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcNexkartProductDetailTemplate(
    modifier: Modifier = Modifier,
    product: NexkartProduct = GadgetShopMockData.products[0],
    isFavorite: Boolean = product.isFavorite,
    selectedSize: String = "42",
    onFavoriteClick: () -> Unit = {},
    onSizeSelected: (String) -> Unit = {},
    onAddToCart: () -> Unit = {},
    onChatClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(WgcCoreDsColors.blueDark6)
                        )
                    }
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(end = WgcCoreDsSpacing.sm12.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                            .background(Color(WgcCoreDsColors.blueLight38))
                            .clickable(onClick = onFavoriteClick)
                            .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favoritar",
                            tint = if (isFavorite) Color(WgcCoreDsColors.pink5) else Color(WgcCoreDsColors.blue41),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = product.reviewCount.toString(),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.blueDark6)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
                Surface(
                    color = Color.White,
                    shadowElevation = 8.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        // Botão de Chat / Mensagem
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                                .border(1.dp, Color(WgcCoreDsColors.blueLight14), RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                                .clickable(onClick = onChatClick),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ChatBubbleOutline,
                                contentDescription = "Falar com vendedor",
                                tint = Color(WgcCoreDsColors.blueDark6),
                                modifier = Modifier.size(22.dp)
                            )
                        }

                        // Botão "Add to Cart" com seta azul
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                                .background(Color(WgcCoreDsColors.blue39))
                                .clickable(onClick = onAddToCart),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Add to Cart",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
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
                .verticalScroll(scrollState)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp)
        ) {
            // 1. Galeria de Fotos Central com fundo suave
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                    .background(Color(WgcCoreDsColors.blueLight38)),
                contentAlignment = Alignment.Center
            ) {
                if (!product.imageUrl.isNullOrEmpty()) {
                    AsyncImageDefault(
                        image = product.imageUrl,
                        contentDescription = product.title,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Text(
                        text = product.title.take(2).uppercase(),
                        style = MaterialTheme.typography.displayMedium,
                        color = Color(WgcCoreDsColors.blue39),
                        fontWeight = FontWeight.Bold
                    )
                }

                // Indicadores de Dots de Galeria
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = WgcCoreDsSpacing.sm12.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.blue39))
                    )
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.blueLight14))
                    )
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.blueLight14))
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // 2. Título do Produto & Preço
            Text(
                text = product.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.blueDark6)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            Text(
                text = product.price,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.blue39)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // 3. Grid com Métricas: Ratings, Sold, Free Shipping
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                    .background(Color(WgcCoreDsColors.blueLight38))
                    .padding(vertical = WgcCoreDsSpacing.sm12.dp, horizontal = WgcCoreDsSpacing.md16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ratings
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.orange23),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "${product.rating} Ratings",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(WgcCoreDsColors.blueDark6)
                    )
                }

                // Sold count
                Text(
                    text = "${product.soldCount} Sold",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.blue41)
                )

                // Free shipping badge
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocalShipping,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.green21),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "Free Shipping",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        color = Color(WgcCoreDsColors.green21)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // 4. Seção Product Details
            Text(
                text = "Product Details",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.blueDark6)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Category",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.blue41)
                )
                Text(
                    text = product.category,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.blueDark6)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = product.description,
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.blue41),
                lineHeight = MaterialTheme.typography.bodySmall.lineHeight
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // 5. Seletor de Tamanho
            Text(
                text = "Select Size",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.blueDark6)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            val sizes = listOf("40", "41", "42", "43", "44")
            Row(
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                sizes.forEach { size ->
                    val isSelected = selectedSize == size
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                            .background(
                                if (isSelected) Color(WgcCoreDsColors.blue39) else Color(WgcCoreDsColors.blueLight38)
                            )
                            .clickable { onSizeSelected(size) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = size,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else Color(WgcCoreDsColors.blueDark6)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxl40.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartProductDetailTemplatePreview() {
    WgcNexkartProductDetailTemplate()
}
