package br.com.wgc.ds_templates.screens.quickshop.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Tela de Onboarding ShopEase:
 * - Curva de fundo laranja sunset superior com título "eCommerce Shop"
 * - Ilustração de compra / entrega rápida
 * - Indicadores de página (dots)
 * - Botão "Next" / "Get Started"
 */
@Composable
fun WgcShopEaseOnboardingTemplate(
    currentStep: Int = 1,
    title: String = "Purchase Online",
    description: String = "Order clothes, shoes and accessories effortlessly with live tracking.",
    onNextClick: () -> Unit = {},
    illustrationSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .navigationBarsPadding()
    ) {
        // Curva Superior Sunset Orange
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(
                    RoundedCornerShape(
                        bottomStart = WgcCoreDsBorderRadius.display45.dp,
                        bottomEnd = WgcCoreDsBorderRadius.display45.dp
                    )
                )
                .background(Color(WgcCoreDsColors.quickShopPrimary))
                .padding(WgcCoreDsSpacing.lg24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "eCommerce Shop",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                if (illustrationSlot != null) {
                    illustrationSlot()
                } else {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s140.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (currentStep == 1) Icons.Default.ShoppingBag else Icons.Default.LocalShipping,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(WgcCoreDsSize.s72.dp)
                        )
                    }
                }
            }
        }

        // Conteúdo Inferior: Título, Texto explicativo, Dots e Botão
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.quickShopDark),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.quickShopSecondaryText),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Indicadores de Paginação (Dots)
            Row(
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 1..3) {
                    val isActive = i == currentStep
                    Box(
                        modifier = Modifier
                            .size(
                                width = if (isActive) WgcCoreDsSize.s24.dp else WgcCoreDsSize.s8.dp,
                                height = WgcCoreDsSize.s8.dp
                            )
                            .clip(CircleShape)
                            .background(
                                if (isActive) Color(WgcCoreDsColors.quickShopPrimary)
                                else Color(WgcCoreDsColors.quickShopBorder)
                            )
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.quickShopPrimary),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
            ) {
                Text(
                    text = if (currentStep == 3) "Get Started" else "Next",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopEaseOnboardingTemplatePreview() {
    WgcShopEaseOnboardingTemplate()
}
