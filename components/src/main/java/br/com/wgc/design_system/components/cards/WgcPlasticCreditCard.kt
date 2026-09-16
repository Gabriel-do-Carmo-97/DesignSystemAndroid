package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcPlasticCreditCard(
    holderName: String,
    cardLastDigits: String,
    atomosPoints: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.fintechSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CreditCard,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.fintechYellow),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                    Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "C6 Carbon Mastercard Black",
                        color = Color(WgcCoreDsColors.fintechTextPrimary),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text = "•••• $cardLastDigits",
                    color = Color(WgcCoreDsColors.fintechTextSecondary),
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = "Titular",
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.fintechTextSecondary)
                    )
                    Text(
                        text = holderName.uppercase(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.fintechTextPrimary)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Diamond,
                        contentDescription = "Pontos Átomos",
                        tint = Color(WgcCoreDsColors.fintechYellow),
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                    Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "$atomosPoints Átomos",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.fintechYellow)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPlasticCreditCardPreview() {
    WgcPlasticCreditCard(
        holderName = "Lucas Ferreira",
        cardLastDigits = "8832",
        atomosPoints = 14250
    )
}

@Composable
fun WgcPlasticCreditCard(
    cardHolder: String,
    invoiceAmount: Double,
    modifier: Modifier = Modifier
) {
    WgcPlasticCreditCard(
        holderName = cardHolder,
        cardLastDigits = "7412",
        atomosPoints = (invoiceAmount * 2.5).toInt(),
        modifier = modifier
    )
}
