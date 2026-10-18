package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Destinos oficiais de navegação do PropertyListing.
 */
enum class WgcPropertyListingNavItem(
    val title: String,
    val icon: ImageVector
) {
    Search("Buscar", Icons.Default.Search),
    Favorites("Favoritos", Icons.Default.FavoriteBorder),
    Messages("Mensagens", Icons.Default.ChatBubbleOutline),
    Profile("Menu", Icons.Default.Person)
}
