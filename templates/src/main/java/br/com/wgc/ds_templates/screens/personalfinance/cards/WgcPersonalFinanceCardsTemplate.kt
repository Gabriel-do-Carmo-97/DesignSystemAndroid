package br.com.wgc.ds_templates.screens.personalfinance.cards

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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPersonalFinanceCreditCardRow
import br.com.wgc.ds_templates.screens.personalfinance.model.OrganizzeCreditCard
import br.com.wgc.ds_templates.screens.personalfinance.model.PersonalFinanceMockData

/**
 * Template de Gerenciamento e Faturas de Cartões de Crédito do Organizze.
 */
@Composable
fun WgcOrganizzeCardsTemplate(
    modifier: Modifier = Modifier,
    totalInvoices: String = "R$ 3.450,00",
    totalLimitAvailable: String = "R$ 26.550,00",
    creditCards: List<OrganizzeCreditCard> = PersonalFinanceMockData.creditCards,
    onBackClick: () -> Unit = {},
    onCardClick: (OrganizzeCreditCard) -> Unit = {},
    onAddCardClick: () -> Unit = {},
    onPayInvoiceClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddCardClick,
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Adicionar Cartão")
            }
        }
    ) { paddingValues ->
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
                    .background(Color(WgcCoreDsColors.personalFinancePrimary))
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

                    Text(
                        text = "Cartões de Crédito",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Box(modifier = Modifier.size(WgcCoreDsSpacing.xxl40.dp))
                }
            }

            // Card Resumo Consolidado de Faturas
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
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Total de Faturas Abertas",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.personalFinanceSecondaryText)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = totalInvoices,
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(WgcCoreDsColors.personalFinanceExpenseRed)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSpacing.xxl40.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.personalFinancePrimaryLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.CreditCard,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.personalFinancePrimary),
                                modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Text(
                        text = "Limite total disponível: $totalLimitAvailable",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.personalFinancePrimary),
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                    Button(
                        onClick = onPayInvoiceClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s44.dp),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.personalFinancePrimary)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Payment,
                            contentDescription = null,
                            modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                        Text(
                            text = "Pagar Faturas do Mês",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Lista de Cartões
            Text(
                text = "Seus Cartões Cadastrados",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.personalFinanceDark),
                modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                creditCards.forEach { card ->
                    WgcPersonalFinanceCreditCardRow(
                        bankName = card.name,
                        lastDigits = card.lastDigits,
                        currentInvoice = card.currentInvoice,
                        availableLimit = card.availableLimit,
                        totalLimit = card.totalLimit,
                        closingDate = "${card.closingDate} • ${card.dueDate}",
                        accentColor = Color(card.color),
                        usageProgress = card.usageProgress,
                        onClick = { onCardClick(card) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSize.s64.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeCardsTemplatePreview() {
    WgcOrganizzeCardsTemplate()
}
