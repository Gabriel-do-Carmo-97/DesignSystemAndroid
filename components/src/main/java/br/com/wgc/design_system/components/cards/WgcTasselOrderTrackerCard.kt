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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Card de rastreamento de pedido do Tassel (WgcTasselOrderTrackerCard).
 * Exibe linha de progresso com steps interconectados, estimativa de entrega,
 * resumo do item comprado e botões de ação secundária ("More info", "Cancel order").
 */
@Composable
fun WgcTasselOrderTrackerCard(
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
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
            .background(Color.White)
            .border(
                width = WgcCoreDsSpacing.xxxs2.dp,
                color = Color(WgcCoreDsColors.tasselSurface),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp)
            )
            .padding(WgcCoreDsSpacing.lg24.dp)
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
                        .size(WgcCoreDsSize.s12.dp)
                        .clip(CircleShape)
                        .background(
                            if (isCompleted) Color(WgcCoreDsColors.tasselPrimary)
                            else Color(WgcCoreDsColors.tasselBorder)
                        )
                )

                // Linha conector entre os pontos
                if (step < totalSteps - 1) {
                    val lineActive = step < currentStep
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(WgcCoreDsSpacing.xxxs2.dp)
                            .background(
                                if (lineActive) Color(WgcCoreDsColors.tasselPrimary)
                                else Color(WgcCoreDsColors.tasselBorder)
                            )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

        // Status & Estimativa de Chegada
        Text(
            text = statusText,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.tasselDark)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

        Text(
            text = arrivalEstimate,
            style = MaterialTheme.typography.bodySmall,
            color = Color(WgcCoreDsColors.tasselSecondaryText)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

        // Resumo do Produto Comprado
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                .background(Color(WgcCoreDsColors.tasselSurface))
                .padding(WgcCoreDsSpacing.sm12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s48.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
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
                        color = Color(WgcCoreDsColors.tasselPrimary),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = productTitle,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.tasselDark)
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                Text(
                    text = productDetails,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(WgcCoreDsColors.tasselSecondaryText)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

        // Botões de Ação
        OutlinedButton(
            onClick = onMoreInfoClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(WgcCoreDsSize.s48.dp),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
        ) {
            Text(
                text = "More info",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(WgcCoreDsColors.tasselDark)
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

        Button(
            onClick = onCancelOrderClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(WgcCoreDsSize.s48.dp),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(WgcCoreDsColors.tasselSurface))
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
    WgcTasselOrderTrackerCard()
}
