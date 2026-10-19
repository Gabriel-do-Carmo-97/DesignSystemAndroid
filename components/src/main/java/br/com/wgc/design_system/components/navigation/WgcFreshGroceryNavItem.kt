package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class WgcFreshGroceryNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    Home("Home", Icons.Filled.Home, Icons.Outlined.Home),
    Wishlist("Wishlist", Icons.Filled.Favorite, Icons.Outlined.FavoriteBorder),
    Notification("Alerts", Icons.Filled.Notifications, Icons.Outlined.Notifications),
    Profile("Profile", Icons.Filled.Person, Icons.Outlined.Person)
}
