package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Card de rastreamento de pedido do Tassel (WgcCuratedOrderTrackerCard).
 * Exibe linha de progresso com steps interconectados, estimativa de entrega,
 * resumo do item comprado e botões de ação secundária ("More info", "Cancel order").
 */
@Composable
fun WgcCuratedOrderTrackerCard(
    modifier: Modifier = Modifier,
    statusText: String = "Your package is on it's way",
    arrivalEstimate: String = "Arrival estimate: April 15",
    currentStep: Int = 2,
    totalSteps: Int = 4,
    productTitle: String = "Bershka Mom Jeans",
    productDetails: String = "28 - S | Blue | ID:0706502",
    productImageUrl: String? = null,
    onMoreInfoClick: () -> Unit = {},
    onCancelOrderClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp))
            .background(Color.White)
            .border(
                width = WgcCoreDsSpacing.XXXS2.dp,
                color = Color(WgcCoreDsColors.blueLight26),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp)
            )
            .padding(WgcCoreDsSpacing.LG24.dp)
    ) {
        // Linha de Progresso / Stepper
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            for (step in 0 until totalSteps) {
                val isCompleted = step <= currentStep

                // Ponto do Stepper
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.S12.dp)
                        .clip(CircleShape)
                        .background(
                            if (isCompleted) Color(WgcCoreDsColors.blue37)
                            else Color(WgcCoreDsColors.blueLight5)
                        )
                )

                // Linha conector entre os pontos
                if (step < totalSteps - 1) {
                    val lineActive = step < currentStep
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(WgcCoreDsSpacing.XXXS2.dp)
                            .background(
                                if (lineActive) Color(WgcCoreDsColors.blue37)
                                else Color(WgcCoreDsColors.blueLight5)
                            )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.LG24.dp))

        // Status & Estimativa de Chegada
        Text(
            text = statusText,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.grayDark9)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

        Text(
            text = arrivalEstimate,
            style = MaterialTheme.typography.bodySmall,
            color = Color(WgcCoreDsColors.gray10)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.LG24.dp))

        // Resumo do Produto Comprado
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                .background(Color(WgcCoreDsColors.blueLight26))
                .padding(WgcCoreDsSpacing.SM12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.S48.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                if (!productImageUrl.isNullOrEmpty()) {
                    AsyncImageDefault(
                        image = productImageUrl,
                        contentDescription = productTitle,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Text(
                        text = productTitle.take(2).uppercase(),
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(WgcCoreDsColors.blue37),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.SM12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = productTitle,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.grayDark9)
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXXS2.dp))
                Text(
                    text = productDetails,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(WgcCoreDsColors.gray10)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.LG24.dp))

        // Botões de Ação
        OutlinedButton(
            onClick = onMoreInfoClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(WgcCoreDsSize.S48.dp),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp)
        ) {
            Text(
                text = "More info",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(WgcCoreDsColors.grayDark9)
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

        Button(
            onClick = onCancelOrderClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(WgcCoreDsSize.S48.dp),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(WgcCoreDsColors.blueLight26))
        ) {
            Text(
                text = "Cancel order",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselOrderTrackerCardPreview() {
    WgcCuratedOrderTrackerCard()
}
