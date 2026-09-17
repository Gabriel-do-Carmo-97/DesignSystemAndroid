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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
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
        Pair("A", Color(WgcCoreDsColors.groceryNutriScoreA)),
        Pair("B", Color(WgcCoreDsColors.groceryNutriScoreB)),
        Pair("C", Color(WgcCoreDsColors.groceryNutriScoreC)),
        Pair("D", Color(WgcCoreDsColors.groceryNutriScoreD)),
        Pair("E", Color(WgcCoreDsColors.groceryNutriScoreE))
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.grocerySurface)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = WgcCoreDsElevation.level1.dp
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.groceryBorder)
        )
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Eco,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.groceryNutriScoreA),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                    Text(
                        text = "PROGRAMA ACT FOR FOOD • NUTRI-SCORE",
                        color = Color(WgcCoreDsColors.groceryBlueDark),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Black
                    )
                }

                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Mais informações",
                    tint = Color(WgcCoreDsColors.groceryTextSecondary),
                    modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Régua Nutri-Score (A a E)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                    .background(Color(WgcCoreDsColors.groceryBackground))
                    .padding(WgcCoreDsSpacing.xs8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                scores.forEach { (letter, color) ->
                    val isSelected = letter.equals(currentScore, ignoreCase = true)
                    Box(
                        modifier = Modifier
                            .size(if (isSelected) WgcCoreDsSize.s36.dp else WgcCoreDsSize.s28.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(if (isSelected) color else color.copy(alpha = 0.35f))
                            .border(
                                width = if (isSelected) WgcCoreDsSize.s2.dp else WgcCoreDsSize.s0.dp,
                                color = if (isSelected) Color.White else Color.Transparent,
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
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

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = explanation,
                color = Color(WgcCoreDsColors.groceryTextSecondary),
                style = MaterialTheme.typography.bodySmall
            )

            if (bonusCoins > 0 && currentScore.uppercase(Locale.ROOT) in listOf("A", "B")) {
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Text(
                        text = "⭐ Escolha saudável:",
                        color = Color(WgcCoreDsColors.groceryNutriScoreA),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "+$bonusCoins Moedas no Meu Supermercado",
                        color = Color(WgcCoreDsColors.groceryBlue),
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
