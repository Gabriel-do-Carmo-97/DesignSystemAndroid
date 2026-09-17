package br.com.wgc.ds_templates.screens.retail.product

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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ShoppingBag
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.components.stepper.WgcRetailQuantityStepper
import br.com.wgc.ds_templates.screens.retail.model.RetailMockData
import br.com.wgc.ds_templates.screens.retail.model.KutukuProduct

/**
 * Tela de Detalhes do Produto oficial do Kutuku (WgcKutukuProductDetailScreen).
 */
@Composable
fun WgcKutukuProductDetailScreen(
    modifier: Modifier = Modifier,
    product: KutukuProduct = RetailMockData.sampleProducts[2],
    onBackClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onAddToCartClick: (KutukuProduct, Int, Color) -> Unit = { _, _, _ -> }
) {
    var quantity by remember { mutableIntStateOf(3) }
    var selectedColorIndex by remember { mutableIntStateOf(0) }
    var isDescriptionExpanded by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            Surface(
                color = Color(WgcCoreDsColors.retailSurface),
                tonalElevation = 8.dp,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg.dp, vertical = WgcCoreDsSpacing.md.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.price,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailDark)
                    )

                    Button(
                        onClick = {
                            val color = product.availableColors.getOrElse(selectedColorIndex) { Color.Black }
                            onAddToCartClick(product, quantity, color)
                        },
                        modifier = Modifier
                            .height(56.dp)
                            .width(180.dp),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.retailPrimary)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingBag,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Add to Cart",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
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
                .background(Color(WgcCoreDsColors.retailBackground))
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.retailDark)
                    )
                }

                Text(
                    text = "Detail Product",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.retailDark)
                )

                IconButton(onClick = onCartClick) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = "Carrinho",
                        tint = Color(WgcCoreDsColors.retailDark)
                    )
                }
            }

            // Imagem Principal
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(Color(WgcCoreDsColors.retailBackground)),
                contentAlignment = Alignment.Center
            ) {
                if (!product.imageUrl.isNullOrEmpty()) {
                    AsyncImageDefault(
                        image = product.imageUrl,
                        contentDescription = product.title,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.retailPrimaryLight),
                        modifier = Modifier.size(120.dp)
                    )
                }
            }

            // Painel Branco Curvado
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = WgcCoreDsBorderRadius.xxl.dp,
                    topEnd = WgcCoreDsBorderRadius.xxl.dp
                ),
                color = Color(WgcCoreDsColors.retailSurface)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.lg.dp)
                ) {
                    // Título e Stepper
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = product.title,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.retailDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.retailGold),
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxxs.dp))
                                Text(
                                    text = "${product.rating} ",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.retailDark)
                                )
                                Text(
                                    text = "(${product.reviewCount} Review)",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(WgcCoreDsColors.retailSecondaryText)
                                )
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            WgcRetailQuantityStepper(
                                count = quantity,
                                onCountChange = { quantity = it }
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs.dp))
                            Text(
                                text = "Avaliable in stok",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.retailDark),
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

                    // Seleção de Cores
                    Text(
                        text = "Color",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailDark)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        product.availableColors.forEachIndexed { index, color ->
                            val isSelected = selectedColorIndex == index
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .clickable { selectedColorIndex = index },
                                contentAlignment = Alignment.Center
                            ) {
                                if (isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "Selecionado",
                                        tint = Color.White,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

                    // Descrição
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailDark)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
                    Text(
                        text = if (isDescriptionExpanded) {
                            "${product.description} Handcrafted with premium genuine materials, water-resistant coating, robust zippers, and interior compartments designed for modern tech and everyday carry."
                        } else {
                            "${product.description.take(120)}..."
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.retailSecondaryText),
                        lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
                    )
                    Text(
                        text = if (isDescriptionExpanded) "Read Less" else "Read More",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailPrimary),
                        modifier = Modifier
                            .clickable { isDescriptionExpanded = !isDescriptionExpanded }
                            .padding(top = WgcCoreDsSpacing.xxs.dp)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuProductDetailScreenPreview() {
    WgcKutukuProductDetailScreen()
}
