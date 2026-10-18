package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Destinos da barra de navegação do Zap Imóveis.
 */
enum class WgcZapNavDestination(val label: String, val icon: ImageVector) {
    SEARCH("Buscar", Icons.Default.Search),
    FAVORITES("Favoritos", Icons.Default.Favorite),
    ALERTS("Alertas", Icons.Default.Notifications),
    FIPEZAP("FipeZAP", Icons.Default.Analytics),
    PROFILE("Perfil", Icons.Default.Person)
}
