package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Destinos de navegação oficiais do ecossistema PropertyRental.
 */
enum class WgcPropertyRentalNavItem(
    val title: String,
    val icon: ImageVector
) {
    Explore("Explorar", Icons.Default.Search),
    Favorites("Favoritos", Icons.Default.FavoriteBorder),
    Visits("Visitas", Icons.Default.CalendarToday),
    Messages("Mensagens", Icons.Default.ChatBubbleOutline),
    Profile("Perfil", Icons.Default.Person)
}
