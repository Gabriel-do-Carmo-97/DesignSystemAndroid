package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Abas de navegação do Corporate Wellness (Wellness Network).
 */
enum class WgcCorporateWellnessNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    EXPLORE("Academias", Icons.Default.Search),
    CHECKIN("Check-in", Icons.Default.CheckCircle),
    WELLNESS("Bem-estar", Icons.Default.Spa),
    PROFILE("Perfil", Icons.Default.Person)
}
