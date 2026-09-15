package br.com.wgc.ds_templates.screens.carrefour.flyer

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
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.navigation.CarrefourNavTab
import br.com.wgc.design_system.components.navigation.WgcCarrefourBottomNav
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourFlyerOffer
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourMockData

@Composable
fun WgcCarrefourFlyerTemplate(
    modifier: Modifier = Modifier,
    offers: List<CarrefourFlyerOffer> = CarrefourMockData.sampleFlyerOffers,
    storeName: String = "Hipermercado Pinheiros",
    validity: String = "Válido até 18/09/2026",
    activeTab: CarrefourNavTab = CarrefourNavTab.FLYER,
    onTabSelected: (CarrefourNavTab) -> Unit = {},
    onAddToCart: (CarrefourFlyerOffer) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.carrefourBackground),
        bottomBar = {
            WgcCarrefourBottomNav(
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
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.carrefourRed)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
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
                    tint = Color(WgcCoreDsColors.carrefourYellow),
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                Text(
                    text = "TABLOIDE DIGITAL CARREFOUR",
                    color = Color(WgcCoreDsColors.carrefourSurface),
                    fontSize = WgcCoreDsFontSize.md16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.carrefourSurface).copy(alpha = 0.8f),
                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                Text(
                    text = storeName,
                    color = Color(WgcCoreDsColors.carrefourSurface),
                    fontSize = WgcCoreDsFontSize.sm14.sp
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            Text(
                text = validity,
                color = Color(WgcCoreDsColors.carrefourYellow),
                fontSize = WgcCoreDsFontSize.xs12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun FlyerOfferGridItem(
    offer: CarrefourFlyerOffer,
    onAddToCart: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.carrefourSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
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
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm8.dp))
                    .background(Color(WgcCoreDsColors.carrefourPlaceholder)),
                contentAlignment = Alignment.TopEnd
            ) {
                Box(
                    modifier = Modifier
                        .padding(WgcCoreDsSpacing.xs8.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs4.dp))
                        .background(Color(WgcCoreDsColors.carrefourRed))
                        .padding(
                            horizontal = WgcCoreDsSpacing.xs8.dp,
                            vertical = WgcCoreDsSpacing.xxs4.dp
                        )
                ) {
                    Text(
                        text = offer.discountBadge,
                        color = Color(WgcCoreDsColors.carrefourSurface),
                        fontSize = WgcCoreDsFontSize.xs12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = offer.title,
                fontSize = WgcCoreDsFontSize.sm14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.carrefourTextPrimary),
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            Text(
                text = "De R$ " + String.format("%.2f", offer.originalPrice),
                fontSize = WgcCoreDsFontSize.xs12.sp,
                color = Color(WgcCoreDsColors.carrefourTextSecondary),
                textDecoration = TextDecoration.LineThrough
            )

            Text(
                text = "R$ " + String.format("%.2f", offer.promoPrice),
                fontSize = WgcCoreDsFontSize.lg18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.carrefourRed)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            WgcClassicButton(
                text = "Adicionar",
                onClick = onAddToCart,
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AddShoppingCart,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.carrefourSurface),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                },
                containerColor = Color(WgcCoreDsColors.carrefourBlue),
                contentColor = Color(WgcCoreDsColors.carrefourSurface)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcCarrefourFlyerTemplatePreview() {
    WgcCarrefourFlyerTemplate()
}
