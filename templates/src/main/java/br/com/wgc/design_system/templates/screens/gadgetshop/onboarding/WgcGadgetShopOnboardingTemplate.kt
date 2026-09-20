package br.com.wgc.design_system.templates.screens.gadgetshop.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MarkEmailRead
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Tela de Onboarding / Walkthrough oficial do ecossistema Nexkart (WgcNexkartOnboardingTemplate).
 * Apresenta barra de progresso no topo, ilustração da garrafa de desejos/notificações da lista de desejos,
 * título em negrito, mensagem de proposta de valor e botão "Next".
 */
@Composable
fun WgcNexkartOnboardingTemplate(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit = {},
    customIllustrationSlot: (@Composable () -> Unit)? = null,
    customActionSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.md16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Barra de Progresso no Topo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = WgcCoreDsSpacing.xs8.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs2.dp))
                        .background(Color(WgcCoreDsColors.gadgetShopPrimary))
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs2.dp))
                        .background(Color(WgcCoreDsColors.gadgetShopBorder))
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs2.dp))
                        .background(Color(WgcCoreDsColors.gadgetShopBorder))
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            // Ilustração Central (Garrafa com mensagem ou Wishlist Notification)
            if (customIllustrationSlot != null) {
                customIllustrationSlot()
            } else {
                Box(
                    modifier = Modifier
                        .size(240.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.gadgetShopPrimaryLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.MarkEmailRead,
                            contentDescription = "Notificação de Wishlist",
                            tint = Color(WgcCoreDsColors.gadgetShopPrimary),
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                        Text(
                            text = "Nexkart Wishlist",
                            style = MaterialTheme.typography.labelLarge,
                            color = Color(WgcCoreDsColors.gadgetShopPrimary),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Textos informativos
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                Text(
                    text = "Wishing for an item but it is\ntoo expensive?",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.gadgetShopDark),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "You will be notified of promotions for\nproducts in your wishlist.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.gadgetShopSecondaryText),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Botão "Next"
            if (customActionSlot != null) {
                customActionSlot()
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                        .border(
                            width = 1.dp,
                            color = Color(WgcCoreDsColors.gadgetShopPrimary),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp)
                        )
                        .clickable(onClick = onNextClick),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Next",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(WgcCoreDsColors.gadgetShopPrimary),
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
private fun WgcNexkartOnboardingTemplatePreview() {
    WgcNexkartOnboardingTemplate()
}
