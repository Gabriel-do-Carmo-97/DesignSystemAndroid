package br.com.wgc.ds_templates.screens.personalfinance.transactions

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPersonalFinanceTransactionItem
import br.com.wgc.design_system.components.cards.WgcOrganizzeTransactionType
import br.com.wgc.ds_templates.screens.personalfinance.model.PersonalFinanceMockData
import br.com.wgc.ds_templates.screens.personalfinance.model.OrganizzeTransactionItemModel

enum class TransactionFilter {
    All,
    Expenses,
    Incomes
}

/**
 * Template de Extrato e Lançamentos do Organizze.
 */
@Composable
fun WgcOrganizzeTransactionsTemplate(
    modifier: Modifier = Modifier,
    monthLabel: String = "Maio 2026",
    totalMonthBalance: String = "+ R$ 4.750,00",
    transactions: List<OrganizzeTransactionItemModel> = PersonalFinanceMockData.recentTransactions,
    onBackClick: () -> Unit = {},
    onTransactionClick: (OrganizzeTransactionItemModel) -> Unit = {},
    onNewTransactionClick: () -> Unit = {}
) {
    var selectedFilter by remember { mutableStateOf(TransactionFilter.All) }
    var searchQuery by remember { mutableStateOf("") }

    val filteredTransactions = transactions.filter { tx ->
        val matchesFilter = when (selectedFilter) {
            TransactionFilter.All -> true
            TransactionFilter.Expenses -> tx.type == WgcOrganizzeTransactionType.Expense
            TransactionFilter.Incomes -> tx.type == WgcOrganizzeTransactionType.Income
        }
        val matchesSearch = tx.title.contains(searchQuery, ignoreCase = true) ||
                tx.category.contains(searchQuery, ignoreCase = true)
        matchesFilter && matchesSearch
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNewTransactionClick,
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Novo lançamento")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // TopBar Verde Organizze
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

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Extrato",
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

            // Barra de Filtros e Busca
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                // Campo de Busca
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Buscar lançamentos ou categorias...") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.personalFinanceSecondaryText)
                        )
                    },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(WgcCoreDsColors.personalFinancePrimary),
                        unfocusedBorderColor = Color(WgcCoreDsColors.personalFinanceBorder),
                        focusedContainerColor = Color(WgcCoreDsColors.personalFinanceBackground),
                        unfocusedContainerColor = Color(WgcCoreDsColors.personalFinanceBackground)
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                // Tabs de Filtro (Todos, Despesas, Receitas)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    FilterChipPill(
                        label = "Todos",
                        isSelected = selectedFilter == TransactionFilter.All,
                        onClick = { selectedFilter = TransactionFilter.All }
                    )
                    FilterChipPill(
                        label = "Despesas",
                        isSelected = selectedFilter == TransactionFilter.Expenses,
                        onClick = { selectedFilter = TransactionFilter.Expenses }
                    )
                    FilterChipPill(
                        label = "Receitas",
                        isSelected = selectedFilter == TransactionFilter.Incomes,
                        onClick = { selectedFilter = TransactionFilter.Incomes }
                    )
                }
            }

            // Totalizador do Período
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.sm12.dp
                    ),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.none0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Resultado no mês",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = Color(WgcCoreDsColors.personalFinanceSecondaryText)
                    )
                    Text(
                        text = totalMonthBalance,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(WgcCoreDsColors.personalFinanceIncomeGreen)
                    )
                }
            }

            // Lista de Lançamentos
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                items(filteredTransactions) { tx ->
                    WgcPersonalFinanceTransactionItem(
                        title = tx.title,
                        category = tx.category,
                        account = tx.accountOrCard,
                        amount = tx.amount,
                        type = tx.type,
                        categoryIcon = tx.icon,
                        categoryColor = Color(tx.color),
                        isPaid = tx.isPaid,
                        onClick = { onTransactionClick(tx) }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(WgcCoreDsSize.s64.dp))
                }
            }
        }
    }
}

@Composable
private fun FilterChipPill(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val bgColor = if (isSelected) Color(WgcCoreDsColors.personalFinancePrimary) else Color(WgcCoreDsColors.personalFinanceBackground)
    val textColor = if (isSelected) Color.White else Color(WgcCoreDsColors.personalFinanceDark)

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.display45.dp))
            .background(bgColor)
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.xs8.dp
            )
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeTransactionsTemplatePreview() {
    WgcOrganizzeTransactionsTemplate()
}
