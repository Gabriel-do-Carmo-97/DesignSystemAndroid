package br.com.wgc.ds_templates.screens.nexkart.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Tela de Pedido Confirmado / Sucesso oficial do ecossistema Nexkart (WgcNexkartOrderSuccessTemplate).
 * Apresenta ilustração circular de sucesso, código do pedido, previsão de entrega e CTAs de rastreamento e retorno à Home.
 */
@Composable
fun WgcNexkartOrderSuccessTemplate(
    modifier: Modifier = Modifier,
    orderId: String = "#NK-849204",
    deliveryEstimate: String = "Estimated Delivery: March 18 - March 22",
    onTrackOrderClick: () -> Unit = {},
    onContinueShoppingClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))

            // Ícone circular de sucesso
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.nexkartPrimaryLight)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.nexkartPrimary)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Sucesso",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            Text(
                text = "Order Confirmed!",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.nexkartDark),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = "Your order $orderId has been placed successfully.\nWe sent you a confirmation email.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.nexkartSecondaryText),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                    .background(Color(WgcCoreDsColors.nexkartSurface))
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
            ) {
                Text(
                    text = deliveryEstimate,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.nexkartPrimary)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // CTAs
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                // Botão "Track Order"
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                        .background(Color(WgcCoreDsColors.nexkartPrimary))
                        .clickable(onClick = onTrackOrderClick),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Track Order",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Botão secundário "Continue Shopping"
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                        .border(1.dp, Color(WgcCoreDsColors.nexkartBorder), RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                        .clickable(onClick = onContinueShoppingClick),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Continue Shopping",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(WgcCoreDsColors.nexkartDark),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartOrderSuccessTemplatePreview() {
    WgcNexkartOrderSuccessTemplate()
}
