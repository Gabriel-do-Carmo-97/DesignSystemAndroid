package br.com.wgc.ds_templates.screens.drogasil.home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import br.com.wgc.design_system.components.cards.WgcDrogasilLoyaltyCard
import br.com.wgc.ds_templates.screens.drogasil.model.DrogasilMockData
import br.com.wgc.ds_templates.screens.drogasil.model.DrogasilOffer

@Composable
fun WgcDrogasilHomeTemplate(
    modifier: Modifier = Modifier,
    offers: List<DrogasilOffer> = DrogasilMockData.sampleOffers,
    onOfferClick: (DrogasilOffer) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.drogasilBackground)
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                DrogasilHeader()
            }

            item {
                WgcDrogasilLoyaltyCard(
                    userName = "Mariana Alves",
                    cpfMasked = "123.***.***-00",
                    pointsBalance = 420
                )
            }

            item {
                Text(
                    text = "Ofertas Vizinhas da Semana",
                    fontSize = 16.sp.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogasilTextPrimary)
                )
            }

            items(offers) { offer ->
                DrogasilOfferCard(offer = offer, onBuy = { onOfferClick(offer) })
            }
        }
    }
}

@Composable
private fun DrogasilHeader() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(WgcCoreDsColors.drogasilRed), RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Column {
                Text(
                    text = "Drogasil • Sua Farmácia Vizinha",
                    color = Color(WgcCoreDsColors.drogasilSurface),
                    fontSize = 14.sp.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Entrega grátis e expressa pelo farmacêutico vizinho",
                    color = Color(WgcCoreDsColors.drogasilSurface).copy(alpha = 0.85f),
                    fontSize = 10.sp.sp
                )
            }
        }
    }
}

@Composable
private fun DrogasilOfferCard(offer: DrogasilOffer, onBuy: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.drogasilSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = offer.discountTag,
                    fontSize = 9.sp.sp,
                    color = Color(WgcCoreDsColors.drogasilRed),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = offer.title,
                    fontSize = 12.sp.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogasilTextPrimary)
                )
                Text(
                    text = offer.laboratory,
                    fontSize = 10.sp.sp,
                    color = Color(WgcCoreDsColors.drogasilTextSecondary)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (offer.originalPrice != null) {
                        Text(
                            text = "R$ " + String.format("%.2f", offer.originalPrice),
                            fontSize = 10.sp.sp,
                            color = Color(WgcCoreDsColors.drogasilTextSecondary),
                            textDecoration = TextDecoration.LineThrough
                        )
                        Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xs8.dp))
                    }
                    Text(
                        text = "R$ " + String.format("%.2f", offer.price),
                        fontSize = 14.sp.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.drogasilRed)
                    )
                }
            }

            WgcClassicButton(
                text = "Comprar",
                onClick = onBuy,
                containerColor = Color(WgcCoreDsColors.drogasilRed),
                contentColor = Color(WgcCoreDsColors.drogasilSurface)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogasilHomeTemplatePreview() {
    WgcDrogasilHomeTemplate()
}
