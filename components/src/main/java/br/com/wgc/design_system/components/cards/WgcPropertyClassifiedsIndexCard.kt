package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.TrendingUp
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Componente do Índice FipeZAP.
 *
 * Apresenta a análise de preço do m² do imóvel em comparação com a média
 * apurada pela Fipe para o bairro, com régua gráfica de posicionamento de mercado.
 */
@Composable
fun WgcPropertyClassifiedsIndexCard(
    neighborhood: String,
    propertyM2Price: String,
    neighborhoodAverageM2Price: String,
    status: WgcZapFipeStatus,
    historicalVariation12m: String = "+5,8%",
    insightText: String = "Este imóvel está com valor por m² atrativo em relação à média apurada pela Fipe.",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyClassifiedsSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            // Cabeçalho FipeZAP
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.propertyClassifiedsPrimary))
                            .padding(
                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Text(
                            text = "Índice FipeZAP",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = neighborhood,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                    )
                }

                // Variação 12m
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.TrendingUp,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.propertyClassifiedsFipeGreen),
                        modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "$historicalVariation12m em 12m",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsFipeGreen)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Comparativo de Valores
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Valor deste imóvel",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = propertyM2Price,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsPrimary)
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Média do m² no bairro",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = neighborhoodAverageM2Price,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Régua Visual do Índice FipeZAP (Verde - Azul - Laranja)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s8.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)
            ) {
                // Abaixo da média (Verde)
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(WgcCoreDsSize.s8.dp)
                        .background(
                            if (status == WgcZapFipeStatus.BELOW_AVERAGE) {
                                Color(WgcCoreDsColors.propertyClassifiedsFipeGreen)
                            } else {
                                Color(WgcCoreDsColors.propertyClassifiedsFipeGreen).copy(alpha = 0.35f)
                            }
                        )
                )
                // Na média (Azul)
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(WgcCoreDsSize.s8.dp)
                        .background(
                            if (status == WgcZapFipeStatus.ON_AVERAGE) {
                                Color(WgcCoreDsColors.propertyClassifiedsBlue)
                            } else {
                                Color(WgcCoreDsColors.propertyClassifiedsBlue).copy(alpha = 0.35f)
                            }
                        )
                )
                // Acima da média (Laranja)
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(WgcCoreDsSize.s8.dp)
                        .background(
                            if (status == WgcZapFipeStatus.ABOVE_AVERAGE) {
                                Color(WgcCoreDsColors.propertyClassifiedsOrange)
                            } else {
                                Color(WgcCoreDsColors.propertyClassifiedsOrange).copy(alpha = 0.35f)
                            }
                        )
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            // Legenda da Régua
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Abaixo",
                    style = MaterialTheme.typography.labelSmall,
                    color = if (status == WgcZapFipeStatus.BELOW_AVERAGE) {
                        Color(WgcCoreDsColors.propertyClassifiedsFipeGreen)
                    } else {
                        Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                    },
                    fontWeight = if (status == WgcZapFipeStatus.BELOW_AVERAGE) FontWeight.Bold else FontWeight.Normal
                )
                Text(
                    text = "Na Média",
                    style = MaterialTheme.typography.labelSmall,
                    color = if (status == WgcZapFipeStatus.ON_AVERAGE) {
                        Color(WgcCoreDsColors.propertyClassifiedsBlue)
                    } else {
                        Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                    },
                    fontWeight = if (status == WgcZapFipeStatus.ON_AVERAGE) FontWeight.Bold else FontWeight.Normal
                )
                Text(
                    text = "Acima",
                    style = MaterialTheme.typography.labelSmall,
                    color = if (status == WgcZapFipeStatus.ABOVE_AVERAGE) {
                        Color(WgcCoreDsColors.propertyClassifiedsOrange)
                    } else {
                        Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                    },
                    fontWeight = if (status == WgcZapFipeStatus.ABOVE_AVERAGE) FontWeight.Bold else FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Caixa de Insight
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.propertyClassifiedsBackground))
                    .padding(WgcCoreDsSpacing.xs8.dp)
            ) {
                Row(verticalAlignment = Alignment.Top) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.propertyClassifiedsBlue),
                        modifier = Modifier
                            .size(WgcCoreDsSize.s16.dp)
                            .padding(top = WgcCoreDsSpacing.xxxs2.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = insightText,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                    )
                }
            }
        }
    }
}

@Preview(name = "WgcPropertyClassifiedsIndexCard - Below Average", showBackground = true)
@Composable
private fun WgcZapFipeMeterCardPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            WgcPropertyClassifiedsIndexCard(
                neighborhood = "Pinheiros, SP",
                propertyM2Price = "R$ 11.200/m²",
                neighborhoodAverageM2Price = "R$ 13.450/m²",
                status = WgcZapFipeStatus.BELOW_AVERAGE,
                historicalVariation12m = "+6,2%",
                insightText = "Excelente oportunidade: valor 16% abaixo da média praticada em Pinheiros."
            )
        }
    }
}
