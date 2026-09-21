@file:Suppress("LongMethod", "CyclomaticComplexMethod", "TooManyFunctions", "UnusedPrivateMember")

package br.com.wgc.design_system.templates.screens.statement

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.automirrored.filled.ReceiptLong
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Item individual de transação no extrato financeiro.
 */
data class WgcStatementTransactionItem(
    val id: String,
    val title: String,
    val category: String,
    val amount: String,
    val date: String,
    val isCredit: Boolean,
    val iconType: String = "pix"
)

/**
 * Estado da interface do Extrato Financeiro corporativo.
 */
data class WgcFinancialStatementUiState(
    val userName: String = "Gabriel",
    val accountBalance: String = "R$ 15.820,45",
    val monthlyIncome: String = "R$ 8.500,00",
    val monthlyExpense: String = "R$ 3.120,50",
    val isBalanceVisible: Boolean = true,
    val selectedPeriod: String = "Últimos 30 dias",
    val periods: List<String> = listOf("Hoje", "7 dias", "15 dias", "Últimos 30 dias"),
    val selectedCategory: String = "Todos",
    val categories: List<String> = listOf("Todos", "Entradas", "Saídas", "PIX", "Cartão", "Boletos"),
    val transactions: List<WgcStatementTransactionItem> = listOf(
        WgcStatementTransactionItem(
            id = "tx_1",
            title = "Transferência Recebida - Maria Silva",
            category = "PIX",
            amount = "+ R$ 1.250,00",
            date = "Hoje, 14:32",
            isCredit = true,
            iconType = "pix"
        ),
        WgcStatementTransactionItem(
            id = "tx_2",
            title = "Supermercado Pão de Açúcar",
            category = "Cartão de Débito",
            amount = "- R$ 384,90",
            date = "Hoje, 11:15",
            isCredit = false,
            iconType = "card"
        ),
        WgcStatementTransactionItem(
            id = "tx_3",
            title = "Pagamento Boleto Condomínio",
            category = "Boletos",
            amount = "- R$ 850,00",
            date = "Ontem, 09:40",
            isCredit = false,
            iconType = "bill"
        ),
        WgcStatementTransactionItem(
            id = "tx_4",
            title = "Salário Mensal - Tech Corp",
            category = "Transferência",
            amount = "+ R$ 7.250,00",
            date = "05/09/2026, 08:00",
            isCredit = true,
            iconType = "transfer"
        ),
        WgcStatementTransactionItem(
            id = "tx_5",
            title = "Posto Shell Combustível",
            category = "Cartão de Crédito",
            amount = "- R$ 220,00",
            date = "04/09/2026, 17:50",
            isCredit = false,
            iconType = "card"
        )
    ),
    val isLoading: Boolean = false
)

/**
 * ViewModel base para a tela de Extrato Financeiro.
 */
abstract class BaseFinancialStatementViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcFinancialStatementUiState>
    abstract fun onToggleBalanceVisibility()
    abstract fun onPeriodSelected(period: String)
    abstract fun onCategorySelected(category: String)
    abstract fun onTransactionClick(transaction: WgcStatementTransactionItem)
    abstract fun onExportStatementClick()
}

/**
 * Implementação Fake para Preview e Testes.
 */
class FakeFinancialStatementViewModel(
    initialState: WgcFinancialStatementUiState = WgcFinancialStatementUiState()
) : BaseFinancialStatementViewModel() {
    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<WgcFinancialStatementUiState> = _uiState.asStateFlow()

    override fun onToggleBalanceVisibility() {
        _uiState.value = _uiState.value.copy(isBalanceVisible = !_uiState.value.isBalanceVisible)
    }

    override fun onPeriodSelected(period: String) {
        _uiState.value = _uiState.value.copy(selectedPeriod = period)
    }

    override fun onCategorySelected(category: String) {
        _uiState.value = _uiState.value.copy(selectedCategory = category)
    }

    override fun onTransactionClick(transaction: WgcStatementTransactionItem) = Unit
    override fun onExportStatementClick() = Unit
}

/**
 * Template Oficial de Extrato Financeiro corporativo do Design System WGC.
 *
 * Expõe decomposição completa através de slots e defaults sensatos de produção.
 */
@Composable
fun WgcFinancialStatementTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseFinancialStatementViewModel = remember { FakeFinancialStatementViewModel() },
    headerSlot: (@Composable () -> Unit)? = null,
    balanceCardSlot: (@Composable () -> Unit)? = null,
    filterSlot: (@Composable () -> Unit)? = null,
    transactionItemSlot: (@Composable (WgcStatementTransactionItem) -> Unit)? = null,
    emptyStateSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {}
) {
    val state by viewModel.uiState.collectAsState()

    WgcFinancialStatementContent(
        modifier = modifier,
        state = state,
        headerSlot = headerSlot,
        balanceCardSlot = balanceCardSlot,
        filterSlot = filterSlot,
        transactionItemSlot = transactionItemSlot,
        emptyStateSlot = emptyStateSlot,
        onBackClick = onBackClick,
        onToggleBalance = { viewModel.onToggleBalanceVisibility() },
        onPeriodSelected = { viewModel.onPeriodSelected(it) },
        onCategorySelected = { viewModel.onCategorySelected(it) },
        onTransactionClick = { viewModel.onTransactionClick(it) },
        onExportClick = { viewModel.onExportStatementClick() }
    )
}

/**
 * Conteúdo puramente visual e desacoplado do Extrato Financeiro (Stateless).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcFinancialStatementContent(
    modifier: Modifier = Modifier,
    state: WgcFinancialStatementUiState,
    headerSlot: (@Composable () -> Unit)? = null,
    balanceCardSlot: (@Composable () -> Unit)? = null,
    filterSlot: (@Composable () -> Unit)? = null,
    transactionItemSlot: (@Composable (WgcStatementTransactionItem) -> Unit)? = null,
    emptyStateSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {},
    onToggleBalance: () -> Unit = {},
    onPeriodSelected: (String) -> Unit = {},
    onCategorySelected: (String) -> Unit = {},
    onTransactionClick: (WgcStatementTransactionItem) -> Unit = {},
    onExportClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            headerSlot?.invoke() ?: TopAppBar(
                title = {
                    Text(
                        text = "Extrato da Conta",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onExportClick) {
                        Icon(
                            imageVector = Icons.Default.FileDownload,
                            contentDescription = "Exportar extrato"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { padding ->
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.xl32.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                // 1. Card de Saldo e Resumo
                item {
                    balanceCardSlot?.invoke() ?: WgcStatementBalanceCard(
                        state = state,
                        onToggleBalance = onToggleBalance
                    )
                }

                // 2. Filtros de Período e Categoria
                item {
                    filterSlot?.invoke() ?: WgcStatementFilters(
                        state = state,
                        onPeriodSelected = onPeriodSelected,
                        onCategorySelected = onCategorySelected
                    )
                }

                // 3. Cabeçalho de Transações
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Lançamentos",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${state.transactions.size} transações",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // 4. Lista de Transações
                if (state.transactions.isEmpty()) {
                    item {
                        emptyStateSlot?.invoke() ?: WgcStatementEmptyState()
                    }
                } else {
                    items(state.transactions, key = { it.id }) { tx ->
                        transactionItemSlot?.invoke(tx) ?: WgcStatementTransactionRow(
                            item = tx,
                            isBalanceVisible = state.isBalanceVisible,
                            onClick = { onTransactionClick(tx) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun WgcStatementBalanceCard(
    state: WgcFinancialStatementUiState,
    onToggleBalance: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Saldo Disponível",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                )
                IconButton(
                    onClick = onToggleBalance,
                    modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                ) {
                    Icon(
                        imageVector = if (state.isBalanceVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Ocultar ou exibir saldo",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Text(
                text = if (state.isBalanceVisible) state.accountBalance else "••••••••",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            HorizontalDivider(
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.2f),
                thickness = br.com.wgc.design_system.core.WgcCoreDsSize.s1.dp
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                    )
                    Column {
                        Text(
                            text = "Entradas",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                        )
                        Text(
                            text = if (state.isBalanceVisible) state.monthlyIncome else "••••",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.TrendingDown,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                    )
                    Column {
                        Text(
                            text = "Saídas",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                        )
                        Text(
                            text = if (state.isBalanceVisible) state.monthlyExpense else "••••",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun WgcStatementFilters(
    state: WgcFinancialStatementUiState,
    onPeriodSelected: (String) -> Unit,
    onCategorySelected: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        // Filtro de Períodos
        LazyRow(
            contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            items(state.periods) { period ->
                FilterChip(
                    selected = state.selectedPeriod == period,
                    onClick = { onPeriodSelected(period) },
                    label = { Text(period, fontSize = 12.sp) },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                )
            }
        }

        // Filtro de Categorias
        LazyRow(
            contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            items(state.categories) { category ->
                FilterChip(
                    selected = state.selectedCategory == category,
                    onClick = { onCategorySelected(category) },
                    label = { Text(category, fontSize = 12.sp) },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                )
            }
        }
    }
}

@Composable
private fun WgcStatementTransactionRow(
    item: WgcStatementTransactionItem,
    isBalanceVisible: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(br.com.wgc.design_system.core.WgcCoreDsSize.s44.dp)
                    .clip(CircleShape)
                    .background(
                        if (item.isCredit) MaterialTheme.colorScheme.primaryContainer
                        else MaterialTheme.colorScheme.surfaceVariant
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = resolveTransactionIcon(item.iconType),
                    contentDescription = null,
                    tint = if (item.isCredit) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Text(
                    text = "${item.category} • ${item.date}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = if (isBalanceVisible) item.amount else "••••",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = if (item.isCredit) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun WgcStatementEmptyState() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.xl32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ReceiptLong,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
            modifier = Modifier.size(br.com.wgc.design_system.core.WgcCoreDsSize.s56.dp)
        )
        Spacer(Modifier.height(WgcCoreDsSpacing.sm12.dp))
        Text(
            text = "Nenhuma transação encontrada",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(WgcCoreDsSpacing.xxs4.dp))
        Text(
            text = "Não há lançamentos para o período ou categoria selecionados.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

private fun resolveTransactionIcon(iconType: String): ImageVector {
    return when (iconType.lowercase()) {
        "pix" -> Icons.Default.QrCode
        "card" -> Icons.Default.CreditCard
        "bill" -> Icons.AutoMirrored.Filled.ReceiptLong
        "transfer" -> Icons.Default.SwapHoriz
        else -> Icons.Default.Payments
    }
}

@WgcDevicePreviews
@Composable
private fun WgcFinancialStatementTemplatePreview() {
    MaterialTheme {
        WgcFinancialStatementContent(
            state = WgcFinancialStatementUiState()
        )
    }
}
