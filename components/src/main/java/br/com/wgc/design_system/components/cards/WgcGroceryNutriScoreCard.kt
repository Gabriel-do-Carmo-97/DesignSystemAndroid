package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import java.util.Locale

/**
 * Card educativo e de incentivo do sistema internacional "Nutri-Score" Supermercado.
 *
 * Exibe a régua oficial de cores e letras de A a E, destacando a nota do produto
 * e bonificação de moedas do Meu Supermercado por hábitos saudáveis.
 */
@Composable
fun WgcGroceryNutriScoreCard(
    currentScore: String,
    modifier: Modifier = Modifier,
    explanation: String = "Classificação nutricional simplificada aprovada por autoridades de saúde pública.",
    bonusCoins: Int = 50,
    onClick: () -> Unit = {}
) {
    val scores = listOf(
        Pair("A", Color(WgcCoreDsColors.green2)),
        Pair("B", Color(WgcCoreDsColors.green24)),
        Pair("C", Color(WgcCoreDsColors.yellow9)),
        Pair("D", Color(WgcCoreDsColors.orange11)),
        Pair("E", Color(WgcCoreDsColors.orange12))
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.white)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = WgcCoreDsElevation.LEVEL1.dp
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.S1.dp,
            color = Color(WgcCoreDsColors.blueLight4)
        )
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.SM12.dp)
        ) {
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
                        imageVector = Icons.Default.Eco,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.green2),
                        modifier = Modifier.size(WgcCoreDsSize.S20.dp)
                    )
                    Text(
                        text = "PROGRAMA ACT FOR FOOD • NUTRI-SCORE",
                        color = Color(WgcCoreDsColors.blueDark14),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Black
                    )
                }

                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Mais informações",
                    tint = Color(WgcCoreDsColors.gray5),
                    modifier = Modifier.size(WgcCoreDsSize.S18.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            // Régua Nutri-Score (A a E)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                    .background(Color(WgcCoreDsColors.blueLight30))
                    .padding(WgcCoreDsSpacing.XS8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                scores.forEach { (letter, color) ->
                    val isSelected = letter.equals(currentScore, ignoreCase = true)
                    Box(
                        modifier = Modifier
                            .size(if (isSelected) WgcCoreDsSize.S36.dp else WgcCoreDsSize.S28.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                            .background(if (isSelected) color else color.copy(alpha = 0.35f))
                            .border(
                                width = if (isSelected) WgcCoreDsSize.S2.dp else WgcCoreDsSize.S0.dp,
                                color = if (isSelected) Color.White else Color.Transparent,
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = letter,
                            color = Color.White,
                            style = if (isSelected) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            Text(
                text = explanation,
                color = Color(WgcCoreDsColors.gray5),
                style = MaterialTheme.typography.bodySmall
            )

            if (bonusCoins > 0 && currentScore.uppercase(Locale.ROOT) in listOf("A", "B")) {
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp)
                ) {
                    Text(
                        text = "⭐ Escolha saudável:",
                        color = Color(WgcCoreDsColors.green2),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "+$bonusCoins Moedas no Meu Supermercado",
                        color = Color(WgcCoreDsColors.blueDark32),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(name = "Nutri-Score Card - Grade A", showBackground = true)
@Composable
private fun WgcSupermercadoNutriScoreCardPreview() {
    WgcGroceryNutriScoreCard(currentScore = "A")
}
