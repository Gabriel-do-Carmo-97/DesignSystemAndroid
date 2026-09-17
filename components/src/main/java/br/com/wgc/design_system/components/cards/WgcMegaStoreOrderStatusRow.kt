package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Item de status de pedido do Shoppe.
 */
data class ShoppeOrderStatusItem(
    val title: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
    val onClick: () -> Unit = {}
)

/**
 * Linha de Status de Pedido Oficial do Shoppe (WgcMegaStoreOrderStatusRow).
 * Apresenta as 5 seções principais: To Pay, To Receive, To Review, My Activity e Vouchers.
 */
@Composable
fun WgcMegaStoreOrderStatusRow(
    modifier: Modifier = Modifier,
    items: List<ShoppeOrderStatusItem> = listOf(
        ShoppeOrderStatusItem("To Pay", Icons.Default.AccountBalanceWallet, badgeCount = 1),
        ShoppeOrderStatusItem("To Receive", Icons.Default.LocalShipping, badgeCount = 2),
        ShoppeOrderStatusItem("To Review", Icons.Default.RateReview, badgeCount = 0),
        ShoppeOrderStatusItem("My Activity", Icons.Default.Timeline, badgeCount = 0),
        ShoppeOrderStatusItem("Vouchers", Icons.Default.ConfirmationNumber, badgeCount = 5)
    )
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
                .padding(vertical = WgcCoreDsSpacing.md.dp, horizontal = WgcCoreDsSpacing.xs.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .clickable(onClick = item.onClick)
                        .padding(WgcCoreDsSpacing.xxs.dp)
                ) {
                    Box {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = Color(WgcCoreDsColors.megaStoreDark),
                            modifier = Modifier.size(26.dp)
                        )
                        if (item.badgeCount > 0) {
                            Box(
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .size(16.dp)
                                    .clip(CircleShape)
                                    .background(Color(WgcCoreDsColors.megaStorePrimary)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item.badgeCount.toString(),
                                    color = Color(WgcCoreDsColors.white),
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

                    Text(
                        text = item.title,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(WgcCoreDsColors.megaStoreDark)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeOrderStatusRowPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            WgcMegaStoreOrderStatusRow()
        }
    }
}
