package br.com.wgc.ds_templates.screens.organizze.dashboard

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
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
import br.com.wgc.design_system.components.cards.WgcOrganizzeBalanceCard
import br.com.wgc.design_system.components.cards.WgcOrganizzeCreditCardRow
import br.com.wgc.design_system.components.cards.WgcOrganizzeSpeedDialSheet
import br.com.wgc.design_system.components.cards.WgcOrganizzeTransactionItem
import br.com.wgc.design_system.components.navigation.WgcOrganizzeBottomNav
import br.com.wgc.design_system.components.navigation.WgcOrganizzeNavItem
import br.com.wgc.ds_templates.screens.organizze.model.OrganizzeAccount
import br.com.wgc.ds_templates.screens.organizze.model.OrganizzeCreditCard
import br.com.wgc.ds_templates.screens.organizze.model.OrganizzeMockData
import br.com.wgc.ds_templates.screens.organizze.model.OrganizzeTransactionItemModel

/**
 * Template principal de Dashboard / Visão Geral do Organizze.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcOrganizzeDashboardTemplate(
    modifier: Modifier = Modifier,
    userName: String = "Gabriel",
    monthLabel: String = "Maio 2026",
    balance: String = "R$ 14.850,00",
    income: String = "R$ 8.200,00",
    expense: String = "R$ 3.450,00",
    accounts: List<OrganizzeAccount> = OrganizzeMockData.accounts,
    creditCards: List<OrganizzeCreditCard> = OrganizzeMockData.creditCards,
    recentTransactions: List<OrganizzeTransactionItemModel> = OrganizzeMockData.recentTransactions,
    onPreviousMonthClick: () -> Unit = {},
    onNextMonthClick: () -> Unit = {},
    onAccountClick: (OrganizzeAccount) -> Unit = {},
    onCreditCardClick: (OrganizzeCreditCard) -> Unit = {},
    onTransactionClick: (OrganizzeTransactionItemModel) -> Unit = {},
    onViewAllTransactionsClick: () -> Unit = {},
    onViewAllCardsClick: () -> Unit = {},
    onNewExpenseClick: () -> Unit = {},
    onNewIncomeClick: () -> Unit = {},
    onNewTransferClick: () -> Unit = {},
    onBottomNavItemSelected: (WgcOrganizzeNavItem) -> Unit = {}
) {
    var isBalanceVisible by remember { mutableStateOf(true) }
    var showSpeedDial by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            WgcOrganizzeBottomNav(
                selectedItem = WgcOrganizzeNavItem.Dashboard,
                onItemSelected = onBottomNavItemSelected,
                onAddClick = { showSpeedDial = true }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Header: Saudação e Ações do Perfil
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSpacing.xxl40.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.organizzePrimaryLight)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Perfil",
                            tint = Color(WgcCoreDsColors.organizzePrimary),
                            modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
                    Column {
                        Text(
                            text = "Olá, $userName 👋",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.organizzeDark)
                        )
                        Text(
                            text = "Suas finanças em dia",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.organizzeSecondaryText)
                        )
                    }
                }

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                        .size(WgcCoreDsSpacing.xxl40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.NotificationsNone,
                        contentDescription = "Notificações",
                        tint = Color(WgcCoreDsColors.organizzeDark),
                        modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                    )
                }
            }

            // Card Principal de Saldo & Comparativo
            Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
                WgcOrganizzeBalanceCard(
                    monthLabel = monthLabel,
                    balance = balance,
                    isBalanceVisible = isBalanceVisible,
                    income = income,
                    expense = expense,
                    onPreviousMonthClick = onPreviousMonthClick,
                    onNextMonthClick = onNextMonthClick,
                    onToggleBalanceVisibility = { isBalanceVisible = !isBalanceVisible }
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Seção: Minhas Contas
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Minhas contas",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.organizzeDark)
                )
                Text(
                    text = "${accounts.size} contas",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.organizzeSecondaryText)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Carrossel Horizontal de Contas
            LazyRow(
                contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                items(accounts) { account ->
                    AccountCardItem(
                        account = account,
                        isBalanceVisible = isBalanceVisible,
                        onClick = { onAccountClick(account) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Seção: Cartões de Crédito
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cartões de crédito",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.organizzeDark)
                )
                TextButton(onClick = onViewAllCardsClick) {
                    Text(
                        text = "Ver todos",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(WgcCoreDsColors.organizzePrimary),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                creditCards.take(2).forEach { card ->
                    WgcOrganizzeCreditCardRow(
                        bankName = card.name,
                        lastDigits = card.lastDigits,
                        currentInvoice = if (isBalanceVisible) card.currentInvoice else "R$ •••",
                        availableLimit = if (isBalanceVisible) card.availableLimit else "R$ •••",
                        totalLimit = card.totalLimit,
                        closingDate = card.closingDate,
                        accentColor = Color(card.color),
                        usageProgress = card.usageProgress,
                        onClick = { onCreditCardClick(card) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Seção: Últimos Lançamentos
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Últimos lançamentos",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.organizzeDark)
                )
                TextButton(onClick = onViewAllTransactionsClick) {
                    Text(
                        text = "Ver extrato",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(WgcCoreDsColors.organizzePrimary),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                recentTransactions.forEach { tx ->
                    WgcOrganizzeTransactionItem(
                        title = tx.title,
                        category = tx.category,
                        account = tx.accountOrCard,
                        amount = if (isBalanceVisible) tx.amount else "•••",
                        type = tx.type,
                        categoryIcon = tx.icon,
                        categoryColor = Color(tx.color),
                        isPaid = tx.isPaid,
                        onClick = { onTransactionClick(tx) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSize.s56.dp))
        }

        // Bottom Sheet para Speed Dial (Nova Despesa / Receita / Transferência)
        if (showSpeedDial) {
            ModalBottomSheet(
                onDismissRequest = { showSpeedDial = false },
                sheetState = sheetState,
                containerColor = Color.Transparent
            ) {
                WgcOrganizzeSpeedDialSheet(
                    onNewExpenseClick = {
                        showSpeedDial = false
                        onNewExpenseClick()
                    },
                    onNewIncomeClick = {
                        showSpeedDial = false
                        onNewIncomeClick()
                    },
                    onNewTransferClick = {
                        showSpeedDial = false
                        onNewTransferClick()
                    }
                )
            }
        }
    }
}

@Composable
private fun AccountCardItem(
    account: OrganizzeAccount,
    isBalanceVisible: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(WgcCoreDsSize.s160.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.xxs4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSpacing.xl32.dp)
                    .clip(CircleShape)
                    .background(Color(account.color).copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBalance,
                    contentDescription = null,
                    tint = Color(account.color),
                    modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Text(
                text = account.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.organizzeDark)
            )

            Text(
                text = account.type,
                style = MaterialTheme.typography.labelSmall,
                color = Color(WgcCoreDsColors.organizzeSecondaryText)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = if (isBalanceVisible) account.balance else "R$ •••",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.ExtraBold,
                color = Color(WgcCoreDsColors.organizzeDark)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeDashboardTemplatePreview() {
    WgcOrganizzeDashboardTemplate()
}
