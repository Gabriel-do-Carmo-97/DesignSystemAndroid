package br.com.wgc.ds_templates.screens.zap.fipezap

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import br.com.wgc.ds_templates.screens.zap.model.ZapFipeNeighborhoodMetric
import br.com.wgc.ds_templates.screens.zap.model.ZapMockData

/**
 * Template da Tela de Inteligência Imobiliária: Índice FipeZAP.
 */
@Composable
fun WgcZapFipeZapCalculatorTemplate(
    neighborhoods: List<ZapFipeNeighborhoodMetric> = ZapMockData.fipeTopNeighborhoods,
    onBackClick: () -> Unit = {},
    onNeighborhoodClick: (ZapFipeNeighborhoodMetric) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedNeighborhood by remember { mutableStateOf(neighborhoods.first()) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.zapSurface))
                    .padding(
                        horizontal = WgcCoreDsSpacing.sm12.dp,
                        vertical = WgcCoreDsSpacing.xs8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.zapDark)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = "Índice FipeZAP",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.zapPrimary)
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.md16.dp
            )
        ) {
            // Card de Destaque Geral do Mercado (Média SP)
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.zapPrimary)),
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
                            Text(
                                text = "São Paulo • Média Geral",
                                style = MaterialTheme.typography.labelMedium,
                                color = Color.White.copy(alpha = 0.85f)
                            )
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(Color(WgcCoreDsColors.zapFipeGreen))
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.xs8.dp,
                                        vertical = WgcCoreDsSpacing.xxs4.dp
                                    )
                            ) {
                                Text(
                                    text = "+5,8% em 12 meses",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                        Text(
                            text = "R$ 10.980",
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                        Text(
                            text = "Preço médio do metro quadrado de venda",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.75f)
                        )

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                        HorizontalDivider(color = Color.White.copy(alpha = 0.2f))
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "Rentabilidade Locatícia",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.75f)
                                )
                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                                Text(
                                    text = "5,45% a.a.",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    text = "Variação do Aluguel",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.75f)
                                )
                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                                Text(
                                    text = "+11,2% em 12m",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.zapOrange)
                                )
                            }
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp)) }

            // Seção Bairros Mais Valorizados
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ranking de Bairros em São Paulo",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.zapDark)
                    )
                    Text(
                        text = "Venda m²",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.zapSecondaryText)
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp)) }

            items(neighborhoods) { metric ->
                val isSelected = metric == selectedNeighborhood
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = WgcCoreDsSpacing.xxs4.dp)
                        .clickable {
                            selectedNeighborhood = metric
                            onNeighborhoodClick(metric)
                        },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isSelected) {
                            Color(WgcCoreDsColors.zapBlueLight)
                        } else {
                            Color(WgcCoreDsColors.zapSurface)
                        }
                    ),
                    border = if (isSelected) {
                        androidx.compose.foundation.BorderStroke(
                            width = WgcCoreDsSpacing.xxxs2.dp,
                            color = Color(WgcCoreDsColors.zapBlue)
                        )
                    } else null,
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = metric.neighborhood,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.zapDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.TrendingUp,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.zapFipeGreen),
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                                Text(
                                    text = metric.variation12m,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(WgcCoreDsColors.zapFipeGreen)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                Text(
                                    text = "• Aluguel: ${metric.rentalYieldAnnual}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(WgcCoreDsColors.zapSecondaryText)
                                )
                            }
                        }

                        Text(
                            text = metric.averageM2Price,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(WgcCoreDsColors.zapPrimary)
                        )
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp)) }

            // Caixa Explicativa da Metodologia FipeZAP
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.zapSurface))
                        .border(
                            width = WgcCoreDsSpacing.xxxs2.dp,
                            color = Color(WgcCoreDsColors.zapBorder),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                        )
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(verticalAlignment = Alignment.Top) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.zapBlue),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
                        Column {
                            Text(
                                text = "Como funciona o Índice FipeZAP?",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.zapDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = "Desenvolvido em parceria entre a FIPE (Fundação Instituto de Pesquisas Econômicas) " +
                                    "e o Zap Imóveis, o índice analisa milhões de anúncios ativos para calcular a " +
                                    "precificação real do mercado brasileiro com rigor estatístico.",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.zapSecondaryText)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "WgcZapFipeZapCalculatorTemplate - Default", showBackground = true)
@Composable
private fun WgcZapFipeZapCalculatorTemplatePreview() {
    MaterialTheme {
        WgcZapFipeZapCalculatorTemplate()
    }
}
