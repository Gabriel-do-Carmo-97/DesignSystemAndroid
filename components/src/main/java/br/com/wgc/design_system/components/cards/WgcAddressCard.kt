package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card de exibição e edição de endereço de entrega (WgcAddressCard).
 */
@Composable
fun WgcAddressCard(
    modifier: Modifier = Modifier,
    title: String = "Delivery Address",
    address: String = "216 St Paul's Rd, London N1 2LL, UK",
    contactPhone: String? = "+44-784232",
    onChangeClick: () -> Unit
) {
    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp)
    val borderColor = Color(WgcCoreDsColors.trendFashionBorderGray).copy(alpha = 0.3f)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        border = BorderStroke(1.dp, borderColor),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Row(modifier = Modifier.weight(1f)) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.trendFashionPink),
                    modifier = Modifier
                        .size(24.dp)
                        .padding(top = 2.dp)
                )
                Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xs.dp))
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                        color = Color(WgcCoreDsColors.trendFashionDark)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
                    Text(
                        text = address,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.textSecondary)
                    )
                    if (contactPhone != null) {
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
                        Text(
                            text = "Contact: $contactPhone",
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                            color = Color(WgcCoreDsColors.trendFashionDark)
                        )
                    }
                }
            }

            IconButton(onClick = onChangeClick) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Editar endereço",
                    tint = Color(WgcCoreDsColors.trendFashionPink),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Preview(name = "Address Card Preview", showBackground = true)
@Composable
private fun WgcAddressCardPreview() {
    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
        WgcAddressCard(
            onChangeClick = {}
        )
    }
}
