package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Card da Campanha de Fidelidade "Juntou Ganhou" do Clube Extra.
 *
 * Apresenta a contagem de selos digitais colecionáveis, progresso
 * rumo ao brinde/panela desejado e regras para o próximo selo.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcExtraStampsLoyaltyCard(
    currentStamps: Int,
    targetStamps: Int,
    rewardName: String,
    amountToNextStamp: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onSeeCatalogClick: () -> Unit = {}
) {
    val progress = (currentStamps.toFloat() / targetStamps.toFloat()).coerceIn(0f, 1f)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.S1.dp,
            color = Color(WgcCoreDsColors.orange19).copy(alpha = 0.3f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.MD16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM12.dp)
        ) {
            // Header: Selos + Tag Juntou Ganhou
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Stars,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.orange19),
                        modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                    )
                    Text(
                        text = "JUNTOU & GANHOU",
                        color = Color(WgcCoreDsColors.orange19),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 0.5.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp))
                        .background(Color(WgcCoreDsColors.orangeLight5))
                        .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
                ) {
                    Text(
                        text = "$currentStamps / $targetStamps SELOS",
                        color = Color(WgcCoreDsColors.orange19),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Título do Prêmio Escolhido
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXXS2.dp)) {
                Text(
                    text = "Prêmio Alvo: $rewardName",
                    color = Color(WgcCoreDsColors.grayDark7),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Faltam apenas ${targetStamps - currentStamps} selos para você resgatar com desconto total.",
                    color = Color(WgcCoreDsColors.blue27),
                    fontSize = 12.sp
                )
            }

            // Barra de Progresso
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp)) {
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.S8.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp)),
                    color = Color(WgcCoreDsColors.orange19),
                    trackColor = Color(WgcCoreDsColors.orangeLight5)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "A cada R$ 20 em compras = 1 selo",
                        color = Color(WgcCoreDsColors.blue27),
                        fontSize = 11.sp
                    )
                    Text(
                        text = "Faltam $amountToNextStamp para +1 selo",
                        color = Color(WgcCoreDsColors.orange19),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Ação de Ver Catálogo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSeeCatalogClick() }
                    .padding(top = WgcCoreDsSpacing.XXS4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ver todos os prêmios da campanha",
                    color = Color(WgcCoreDsColors.blueDark34),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.blueDark34),
                    modifier = Modifier.size(WgcCoreDsSize.S14.dp)
                )
            }
        }
    }
}

@Preview(name = "Clube Extra Stamps Loyalty Card - Preview", showBackground = true)
@Composable
fun WgcExtraStampsLoyaltyCardPreview() {
    WgcExtraStampsLoyaltyCard(
        currentStamps = 18,
        targetStamps = 30,
        rewardName = "Panela Wok Antiaderente Royal VKB 28cm",
        amountToNextStamp = "R$ 11,50"
    )
}
