package br.com.wgc.ds_templates.screens.organizze.reports

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.ds_templates.screens.organizze.model.OrganizzeCategoryItem
import br.com.wgc.ds_templates.screens.organizze.model.OrganizzeMockData

/**
 * Template de Relatórios e Orçamento Mensal do Organizze.
 */
@Composable
fun WgcOrganizzeReportsTemplate(
    modifier: Modifier = Modifier,
    monthLabel: String = "Maio 2026",
    totalExpenses: String = "R$ 3.450,00",
    categories: List<OrganizzeCategoryItem> = OrganizzeMockData.categories.take(6),
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Header TopBar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.organizzePrimary))
                    .padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.sm12.dp
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Relatórios & Orçamento",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = monthLabel,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.85f)
                        )
                    }

                    Box(modifier = Modifier.size(WgcCoreDsSpacing.xxl40.dp))
                }
            }

            // Card Resumo de Gastos com Gráfico Simulado
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.xxs4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Total de Despesas no Mês",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.organizzeSecondaryText)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = totalExpenses,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(WgcCoreDsColors.organizzeExpenseRed)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                    // Representação Visual de Rosca / Gráfico Central
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s140.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.organizzePrimaryLight)),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s96.dp)
                                .clip(CircleShape)
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.PieChart,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.organizzePrimary),
                                modifier = Modifier.size(WgcCoreDsSpacing.xl32.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
                    Text(
                        text = "Alimentação e Moradia representam 65% dos gastos",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.organizzeSecondaryText)
                    )
                }
            }

            // Seção: Divisão por Categorias
            Text(
                text = "Despesas por Categoria",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.organizzeDark),
                modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                categories.forEach { cat ->
                    CategoryBudgetRow(category = cat)
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Composable
private fun CategoryBudgetRow(category: OrganizzeCategoryItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.none0.dp)
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSpacing.xl32.dp)
                            .clip(CircleShape)
                            .background(Color(category.color).copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = category.icon,
                            contentDescription = category.name,
                            tint = Color(category.color),
                            modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
                    Text(
                        text = category.name,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.organizzeDark)
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = category.spentAmount,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.organizzeDark)
                    )
                    Text(
                        text = "de ${category.budgetLimit}",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(WgcCoreDsColors.organizzeSecondaryText)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Barra de Progresso do Orçamento
            LinearProgressIndicator(
                progress = { category.progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSpacing.xs8.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)),
                color = if (category.progress >= 1.0f) Color(WgcCoreDsColors.organizzeExpenseRed) else Color(category.color),
                trackColor = Color(WgcCoreDsColors.organizzeBorder),
                strokeCap = StrokeCap.Round
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeReportsTemplatePreview() {
    WgcOrganizzeReportsTemplate()
}
