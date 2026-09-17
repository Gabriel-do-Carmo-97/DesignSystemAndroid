package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Banner Oficial de Promoção Relâmpago com Contagem Regressiva do Shoppe (WgcMegaStoreFlashSaleBanner).
 */
@Composable
fun WgcMegaStoreFlashSaleBanner(
    modifier: Modifier = Modifier,
    title: String = "Flash Sale",
    discountTag: String = "Up to 50% Off",
    hours: String = "02",
    minutes: String = "15",
    seconds: String = "45"
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.megaStorePrimary)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Black),
                    color = Color(WgcCoreDsColors.white)
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
                Text(
                    text = discountTag,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.megaStorePrimaryLight)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FlashTimeBox(hours)
                Text(text = ":", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                FlashTimeBox(minutes)
                Text(text = ":", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                FlashTimeBox(seconds)
            }
        }
    }
}

@Composable
private fun FlashTimeBox(time: String) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs.dp))
            .background(Color.White.copy(alpha = 0.2f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = time,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeFlashSaleBannerPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            WgcMegaStoreFlashSaleBanner()
        }
    }
}
