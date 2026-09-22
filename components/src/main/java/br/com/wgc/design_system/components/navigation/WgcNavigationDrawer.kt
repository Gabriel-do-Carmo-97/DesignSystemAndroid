package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * Modelo de item de navegação para o WgcNavigationDrawer.
 */
data class WgcDrawerItem(
    val id: String,
    val label: String,
    val icon: ImageVector? = null,
    val badgeCount: Int? = null,
    val isSelected: Boolean = false,
    val isEnabled: Boolean = true
)

/**
 * WgcModalNavigationDrawer
 *
 * Drawer modal corporativo seguindo diretrizes do Material 3 e tokens WGC.
 *
 * @param items Lista de itens do menu lateral.
 * @param onItemClick Callback acionado ao selecionar um item.
 * @param modifier Modificador de layout.
 * @param drawerState Estado de abertura/fechamento do Drawer.
 * @param gesturesEnabled Define se o gesto de arrasto abre/fecha o drawer.
 * @param header Slot opcional para cabeçalho do menu (avatar, nome de usuário, etc.).
 * @param footer Slot opcional para rodapé (versão do app, botão de logout, etc.).
 * @param content Conteúdo principal da tela sobreposto pelo drawer.
 */
@Composable
fun WgcModalNavigationDrawer(
    items: List<WgcDrawerItem>,
    onItemClick: (WgcDrawerItem) -> Unit,
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    gesturesEnabled: Boolean = true,
    header: (@Composable () -> Unit)? = null,
    footer: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = gesturesEnabled,
        modifier = modifier,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(
                    topEnd = WgcCoreDsBorderRadius.xl16.dp,
                    bottomEnd = WgcCoreDsBorderRadius.xl16.dp
                ),
                drawerContainerColor = MaterialTheme.colorScheme.surface,
                drawerContentColor = MaterialTheme.colorScheme.onSurface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    if (header != null) {
                        header()
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        items.forEach { item ->
                            WgcNavigationDrawerItem(
                                item = item,
                                onClick = { onItemClick(item) }
                            )
                        }
                    }

                    if (footer != null) {
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                        footer()
                    }
                }
            }
        },
        content = content
    )
}

/**
 * Item individual estilizado para o Drawer de navegação.
 */
@Composable
fun WgcNavigationDrawerItem(
    item: WgcDrawerItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationDrawerItem(
        label = {
            Text(
                text = item.label,
                style = MaterialTheme.typography.labelLarge
            )
        },
        selected = item.isSelected,
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        icon = item.icon?.let { icon ->
            {
                Icon(
                    imageVector = icon,
                    contentDescription = item.label
                )
            }
        },
        badge = if (item.badgeCount != null && item.badgeCount > 0) {
            {
                Badge(
                    containerColor = MaterialTheme.colorScheme.error,
                    contentColor = MaterialTheme.colorScheme.onError
                ) {
                    Text(
                        text = if (item.badgeCount > 99) "99+" else item.badgeCount.toString(),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        } else null,
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unselectedContainerColor = MaterialTheme.colorScheme.surface,
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedTextColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

@WgcComponentPreviews
@Composable
private fun WgcModalNavigationDrawerPreview() {
    val sampleItems = listOf(
        WgcDrawerItem(id = "home", label = "Início", icon = Icons.Default.Home, isSelected = true),
        WgcDrawerItem(id = "notif", label = "Notificações", icon = Icons.Default.Notifications, badgeCount = 5),
        WgcDrawerItem(id = "profile", label = "Minha Conta", icon = Icons.Default.AccountCircle),
        WgcDrawerItem(id = "settings", label = "Configurações", icon = Icons.Default.Settings)
    )

    MaterialTheme {
        ModalDrawerSheet(
            drawerShape = RoundedCornerShape(
                topEnd = WgcCoreDsBorderRadius.xl16.dp,
                bottomEnd = WgcCoreDsBorderRadius.xl16.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                Text(
                    text = "Menu WGC",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = WgcCoreDsSpacing.md16.dp)
                )

                sampleItems.forEach { item ->
                    WgcNavigationDrawerItem(
                        item = item,
                        onClick = {}
                    )
                }
            }
        }
    }
}
