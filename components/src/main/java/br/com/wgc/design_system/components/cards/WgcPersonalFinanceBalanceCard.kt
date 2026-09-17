package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card de Saldo e Visão Geral Mensal do Organizze.
 * Exibe o seletor de mês, saldo consolidado com toggle de visibilidade e
 * os blocos comparativos de Receitas e Despesas.
 */
@Composable
fun WgcPersonalFinanceBalanceCard(
    modifier: Modifier = Modifier,
    monthLabel: String = "Maio 2026",
    balance: String = "R$ 14.850,00",
    isBalanceVisible: Boolean = true,
    income: String = "R$ 8.200,00",
    expense: String = "R$ 3.450,00",
    onPreviousMonthClick: () -> Unit = {},
    onNextMonthClick: () -> Unit = {},
    onToggleBalanceVisibility: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.personalFinancePrimary)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.xxs4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            // Seletor de Mês
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onPreviousMonthClick,
                    modifier = Modifier.size(WgcCoreDsSpacing.xl32.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Mês anterior",
                        tint = Color.White.copy(alpha = 0.9f),
                        modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                    )
                }

                Text(
                    text = monthLabel,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                IconButton(
                    onClick = onNextMonthClick,
                    modifier = Modifier.size(WgcCoreDsSpacing.xl32.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Próximo mês",
                        tint = Color.White.copy(alpha = 0.9f),
                        modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Linha do Saldo Consolidado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Saldo em contas",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = if (isBalanceVisible) balance else "R$ ••••••",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }

                IconButton(
                    onClick = onToggleBalanceVisibility,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.15f))
                        .size(WgcCoreDsSpacing.xxl40.dp)
                ) {
                    Icon(
                        imageVector = if (isBalanceVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (isBalanceVisible) "Ocultar saldo" else "Mostrar saldo",
                        tint = Color.White,
                        modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Cards de Receita e Despesa
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                // Bloco de Receitas
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                        .background(Color.White.copy(alpha = 0.15f))
                        .padding(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSpacing.xl32.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.personalFinanceIncomeGreen)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowUpward,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                        Column {
                            Text(
                                text = "Receitas",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.White.copy(alpha = 0.85f)
                            )
                            Text(
                                text = if (isBalanceVisible) income else "R$ •••",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }

                // Bloco de Despesas
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                        .background(Color.White.copy(alpha = 0.15f))
                        .padding(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSpacing.xl32.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.personalFinanceExpenseRed)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDownward,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                        Column {
                            Text(
                                text = "Despesas",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.White.copy(alpha = 0.85f)
                            )
                            Text(
                                text = if (isBalanceVisible) expense else "R$ •••",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeBalanceCardPreview() {
    WgcPersonalFinanceBalanceCard(
        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)
    )
}
