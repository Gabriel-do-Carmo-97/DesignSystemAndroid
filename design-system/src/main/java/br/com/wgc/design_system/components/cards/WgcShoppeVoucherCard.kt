package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
 * Card Oficial de Cupom / Voucher do Shoppe (WgcShoppeVoucherCard).
 */
@Composable
fun WgcShoppeVoucherCard(
    modifier: Modifier = Modifier,
    discountTitle: String = "$15 OFF",
    minSpend: String = "Min. Spend $80",
    expiryDate: String = "Valid till 30 Sep",
    isCollected: Boolean = false,
    onCollectClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs.dp))
                            .background(Color(WgcCoreDsColors.shoppePrimaryLight))
                            .padding(horizontal = WgcCoreDsSpacing.xs.dp, vertical = WgcCoreDsSpacing.xxs.dp)
                    ) {
                        Text(
                            text = "VOUCHER",
                            color = Color(WgcCoreDsColors.shoppePrimary),
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.padding(start = WgcCoreDsSpacing.xs.dp))
                    Text(
                        text = discountTitle,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Black),
                        color = Color(WgcCoreDsColors.shoppeDark)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))

                Text(
                    text = minSpend,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.shoppeSecondaryText)
                )

                Text(
                    text = expiryDate,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(WgcCoreDsColors.shoppeGold),
                    fontWeight = FontWeight.SemiBold
                )
            }

            TextButton(
                onClick = onCollectClick,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = if (isCollected) Color(WgcCoreDsColors.shoppeBackground) else Color(WgcCoreDsColors.shoppePrimary),
                    contentColor = if (isCollected) Color(WgcCoreDsColors.shoppeSecondaryText) else Color.White
                ),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular.dp),
                enabled = !isCollected
            ) {
                Text(
                    text = if (isCollected) "Collected" else "Collect",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeVoucherCardPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            WgcShoppeVoucherCard()
        }
    }
}
