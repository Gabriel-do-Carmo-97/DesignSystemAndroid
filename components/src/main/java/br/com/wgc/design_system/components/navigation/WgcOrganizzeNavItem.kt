package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.ui.graphics.vector.ImageVector

enum class WgcOrganizzeNavItem(
    val title: String,
    val icon: ImageVector
) {
    Dashboard("Visão Geral", Icons.Default.Home),
    Transactions("Lançamentos", Icons.AutoMirrored.Filled.List),
    Reports("Relatórios", Icons.Default.PieChart),
    Cards("Cartões", Icons.Default.CreditCard)
}
