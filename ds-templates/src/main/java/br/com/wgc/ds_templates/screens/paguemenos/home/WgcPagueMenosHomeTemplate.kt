package br.com.wgc.ds_templates.screens.paguemenos.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.cards.WgcPagueMenosConvenioCard
import br.com.wgc.ds_templates.screens.paguemenos.model.PagueMenosMockData
import br.com.wgc.ds_templates.screens.paguemenos.model.PagueMenosOffer

@Composable
fun WgcPagueMenosHomeTemplate(
    modifier: Modifier = Modifier,
    offers: List<PagueMenosOffer> = PagueMenosMockData.sampleOffers,
    onOfferClick: (PagueMenosOffer) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                PagueMenosBanner()
            }

            item {
                WgcPagueMenosConvenioCard(
                    convenioName = "Bradesco Saúde / Orizon",
                    cardNumberMasked = "9874 **** **** 1029",
                    discountPercentage = 45
                )
            }

            item {
                Text(
                    text = "Destaques Sempre Bem",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pagueMenosTextPrimary)
                )
            }

            items(offers) { offer ->
                PagueMenosOfferRow(offer = offer, onBuy = { onOfferClick(offer) })
            }
        }
    }
}

@Composable
private fun PagueMenosBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(WgcCoreDsColors.pagueMenosGreen), RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
            .padding(WgcCoreDsSpacing.md16.dp)
    ) {
        Column {
            Text(
                text = "Pague Menos • Sempre Bem",
                color = Color(WgcCoreDsColors.pagueMenosSurface),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Economia de verdade em medicamentos e cosméticos",
                color = Color(WgcCoreDsColors.pagueMenosSurface).copy(alpha = 0.85f),
                fontSize = 10.sp
            )
        }
    }
}

@Composable
private fun PagueMenosOfferRow(offer: PagueMenosOffer, onBuy: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.pagueMenosSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${offer.discountPercent}% OFF",
                    fontSize = 9.sp,
                    color = Color(WgcCoreDsColors.pagueMenosGreen),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = offer.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pagueMenosTextPrimary)
                )
                Text(
                    text = offer.brand,
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.pagueMenosTextSecondary)
                )
                Text(
                    text = "R$ " + String.format("%.2f", offer.price),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pagueMenosBlue)
                )
            }

            WgcClassicButton(
                textButton = "Comprar",
                onClick = onBuy
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPagueMenosHomeTemplatePreview() {
    WgcPagueMenosHomeTemplate()
}
