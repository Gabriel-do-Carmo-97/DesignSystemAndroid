package br.com.wgc.design_system.templates.screens.personalfinance.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.components.cards.WgcOrganizzeTransactionType

data class OrganizzeAccount(
    val id: String,
    val name: String,
    val type: String,
    val balance: String,
    val color: Int
)

data class OrganizzeCreditCard(
    val id: String,
    val name: String,
    val lastDigits: String,
    val currentInvoice: String,
    val availableLimit: String,
    val totalLimit: String,
    val closingDate: String,
    val dueDate: String,
    val color: Int,
    val usageProgress: Float
)

data class OrganizzeCategoryItem(
    val id: String,
    val name: String,
    val icon: ImageVector,
    val color: Int,
    val budgetLimit: String = "R$ 1.000,00",
    val spentAmount: String = "R$ 650,00",
    val progress: Float = 0.65f
)

data class OrganizzeTransactionItemModel(
    val id: String,
    val title: String,
    val category: String,
    val accountOrCard: String,
    val amount: String,
    val type: WgcOrganizzeTransactionType,
    val date: String,
    val isPaid: Boolean,
    val icon: ImageVector,
    val color: Int
)

object PersonalFinanceMockData {
    val accounts = listOf(
        OrganizzeAccount(
            id = "1",
            name = "NuConta",
            type = "Conta Corrente",
            balance = "R$ 9.420,00",
            color = WgcCoreDsColors.personalFinanceCardPurple
        ),
        OrganizzeAccount(
            id = "2",
            name = "Itaú Uniclass",
            type = "Conta Salário",
            balance = "R$ 4.880,00",
            color = WgcCoreDsColors.personalFinanceCardNavy
        ),
        OrganizzeAccount(
            id = "3",
            name = "Carteira Física",
            type = "Dinheiro em Espécie",
            balance = "R$ 550,00",
            color = WgcCoreDsColors.personalFinancePrimary
        )
    )

    val creditCards = listOf(
        OrganizzeCreditCard(
            id = "c1",
            name = "Neobank Ultravioleta",
            lastDigits = "•••• 8421",
            currentInvoice = "R$ 1.840,50",
            availableLimit = "R$ 8.159,50",
            totalLimit = "R$ 10.000,00",
            closingDate = "Fecha em 24/05",
            dueDate = "Vence em 03/06",
            color = WgcCoreDsColors.personalFinanceCardPurple,
            usageProgress = 0.184f
        ),
        OrganizzeCreditCard(
            id = "c2",
            name = "Itaú Click Visa",
            lastDigits = "•••• 1943",
            currentInvoice = "R$ 1.250,00",
            availableLimit = "R$ 3.750,00",
            totalLimit = "R$ 5.000,00",
            closingDate = "Fecha em 18/05",
            dueDate = "Vence em 25/05",
            color = WgcCoreDsColors.personalFinanceCardNavy,
            usageProgress = 0.25f
        ),
        OrganizzeCreditCard(
            id = "c3",
            name = "SuperApp Bank Black",
            lastDigits = "•••• 5520",
            currentInvoice = "R$ 359,50",
            availableLimit = "R$ 14.640,50",
            totalLimit = "R$ 15.000,00",
            closingDate = "Fecha em 28/05",
            dueDate = "Vence em 05/06",
            color = WgcCoreDsColors.personalFinanceCardOrange,
            usageProgress = 0.024f
        )
    )

    val categories = listOf(
        OrganizzeCategoryItem("cat1", "Alimentação", Icons.Default.Fastfood, WgcCoreDsColors.quickShopPrimary, "R$ 1.500,00", "R$ 1.120,00", 0.74f),
        OrganizzeCategoryItem("cat2", "Transporte", Icons.Default.DirectionsCar, WgcCoreDsColors.personalFinanceTransferBlue, "R$ 800,00", "R$ 540,00", 0.67f),
        OrganizzeCategoryItem("cat3", "Moradia", Icons.Default.Home, WgcCoreDsColors.personalFinanceWarningYellow, "R$ 2.200,00", "R$ 2.200,00", 1.0f),
        OrganizzeCategoryItem("cat4", "Saúde", Icons.Default.LocalHospital, WgcCoreDsColors.personalFinanceExpenseRed, "R$ 600,00", "R$ 280,00", 0.46f),
        OrganizzeCategoryItem("cat5", "Compras", Icons.Default.ShoppingBag, WgcCoreDsColors.personalFinanceCardPurple, "R$ 900,00", "R$ 680,00", 0.75f),
        OrganizzeCategoryItem("cat6", "Educação", Icons.Default.School, WgcCoreDsColors.personalFinancePrimaryDark, "R$ 500,00", "R$ 350,00", 0.70f),
        OrganizzeCategoryItem("cat7", "Salário", Icons.Default.Payments, WgcCoreDsColors.personalFinanceIncomeGreen),
        OrganizzeCategoryItem("cat8", "Investimentos", Icons.Default.Work, WgcCoreDsColors.personalFinancePrimary)
    )

    val recentTransactions = listOf(
        OrganizzeTransactionItemModel(
            id = "t1",
            title = "Supermercado Gourmet",
            category = "Alimentação",
            accountOrCard = "Neobank Ultravioleta",
            amount = "R$ 324,80",
            type = WgcOrganizzeTransactionType.Expense,
            date = "Hoje",
            isPaid = true,
            icon = Icons.Default.Fastfood,
            color = WgcCoreDsColors.quickShopPrimary
        ),
        OrganizzeTransactionItemModel(
            id = "t2",
            title = "Salário Mensal Tech Corp",
            category = "Salário",
            accountOrCard = "Itaú Uniclass",
            amount = "R$ 8.200,00",
            type = WgcOrganizzeTransactionType.Income,
            date = "Ontem",
            isPaid = true,
            icon = Icons.Default.Payments,
            color = WgcCoreDsColors.personalFinanceIncomeGreen
        ),
        OrganizzeTransactionItemModel(
            id = "t3",
            title = "Posto Shell Gasolina",
            category = "Transporte",
            accountOrCard = "NuConta",
            amount = "R$ 180,00",
            type = WgcOrganizzeTransactionType.Expense,
            date = "Ontem",
            isPaid = true,
            icon = Icons.Default.DirectionsCar,
            color = WgcCoreDsColors.personalFinanceTransferBlue
        ),
        OrganizzeTransactionItemModel(
            id = "t4",
            title = "Farmácia Cuidados",
            category = "Saúde",
            accountOrCard = "Itaú Click Visa",
            amount = "R$ 94,50",
            type = WgcOrganizzeTransactionType.Expense,
            date = "12 de Maio",
            isPaid = true,
            icon = Icons.Default.LocalHospital,
            color = WgcCoreDsColors.personalFinanceExpenseRed
        ),
        OrganizzeTransactionItemModel(
            id = "t5",
            title = "Transferência para NuConta",
            category = "Transferência",
            accountOrCard = "Itaú -> Neobank",
            amount = "R$ 1.500,00",
            type = WgcOrganizzeTransactionType.Transfer,
            date = "10 de Maio",
            isPaid = true,
            icon = Icons.Default.Payments,
            color = WgcCoreDsColors.personalFinanceTransferBlue
        )
    )
}
