package br.com.wgc.ds_templates.screens.grocery.flyer

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.navigation.GroceryNavTab
import br.com.wgc.design_system.components.navigation.WgcGroceryBottomNav
import br.com.wgc.ds_templates.screens.grocery.model.SupermercadoFlyerOffer
import br.com.wgc.ds_templates.screens.grocery.model.GroceryMockData

@Composable
fun WgcSupermercadoFlyerTemplate(
    modifier: Modifier = Modifier,
    offers: List<SupermercadoFlyerOffer> = GroceryMockData.sampleFlyerOffers,
    storeName: String = "Hipermercado Pinheiros",
    validity: String = "Válido até 18/09/2026",
    activeTab: GroceryNavTab = GroceryNavTab.FLYER,
    onTabSelected: (GroceryNavTab) -> Unit = {},
    onAddToCart: (SupermercadoFlyerOffer) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            WgcGroceryBottomNav(
                selectedTab = activeTab,
                onTabSelected = onTabSelected,
                cartBadgeCount = 3
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.md16.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            item(span = { GridItemSpan(2) }) {
                FlyerHeaderBanner(storeName = storeName, validity = validity)
            }

            items(offers) { offer ->
                FlyerOfferGridItem(
                    offer = offer,
                    onAddToCart = { onAddToCart(offer) }
                )
            }
        }
    }
}

@Composable
private fun FlyerHeaderBanner(
    storeName: String,
    validity: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.groceryRed)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.LocalOffer,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.groceryYellow),
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                Text(
                    text = "TABLOIDE DIGITAL SUPERMERCADO",
                    color = Color(WgcCoreDsColors.grocerySurface),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.grocerySurface).copy(alpha = 0.8f),
                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                Text(
                    text = storeName,
                    color = Color(WgcCoreDsColors.grocerySurface),
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            Text(
                text = validity,
                color = Color(WgcCoreDsColors.groceryYellow),
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun FlyerOfferGridItem(
    offer: SupermercadoFlyerOffer,
    onAddToCart: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.grocerySurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.sm12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s100.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.groceryPlaceholder)),
                contentAlignment = Alignment.TopEnd
            ) {
                Box(
                    modifier = Modifier
                        .padding(WgcCoreDsSpacing.xs8.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.groceryRed))
                        .padding(
                            horizontal = WgcCoreDsSpacing.xs8.dp,
                            vertical = WgcCoreDsSpacing.xxs4.dp
                        )
                ) {
                    Text(
                        text = offer.discountBadge,
                        color = Color(WgcCoreDsColors.grocerySurface),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = offer.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.groceryTextPrimary),
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            Text(
                text = "De R$ " + String.format("%.2f", offer.originalPrice),
                fontSize = 10.sp,
                color = Color(WgcCoreDsColors.groceryTextSecondary),
                textDecoration = TextDecoration.LineThrough
            )

            Text(
                text = "R$ " + String.format("%.2f", offer.promoPrice),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.groceryRed)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            WgcClassicButton(
                textButton = "Adicionar",
                onClick = onAddToCart,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSupermercadoFlyerTemplatePreview() {
    WgcSupermercadoFlyerTemplate()
}
