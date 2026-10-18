package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.EventRepeat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.ui.graphics.vector.ImageVector

enum class PharmacyNavTab(val title: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    PRESCRIPTIONS("Receitas", Icons.Default.Description),
    SUBSCRIPTION("Assinatura", Icons.Default.EventRepeat),
    CART("Sacola", Icons.Default.ShoppingBag),
    PROFILE("Meu Perfil", Icons.Default.Person)
}
