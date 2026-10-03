@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.templates.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Item de menu da tela de perfil.
 */
data class WgcProfileMenuItem(
    val id: String,
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

/**
 * Estado da tela de visão geral de perfil.
 */
data class WgcUserProfileOverviewUiState(
    val userName: String = "Gabriel do Carmo",
    val userEmail: String = "gabriel.carmo@wgc.com.br",
    val userInitials: String = "GC"
)

/**
 * Template corporativo de visão geral do perfil do usuário.
 */
@Composable
fun WgcUserProfileOverviewTemplate(
    uiState: WgcUserProfileOverviewUiState,
    onEditProfileClick: () -> Unit,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val menuItems = listOf(
        WgcProfileMenuItem("orders", "Meus Pedidos", Icons.Default.ShoppingBag, {}),
        WgcProfileMenuItem("cards", "Formas de Pagamento", Icons.Default.CreditCard, {}),
        WgcProfileMenuItem("notifications", "Notificações", Icons.Default.Notifications, {}),
        WgcProfileMenuItem("security", "Segurança e Biometria", Icons.Default.Security, {})
    )

    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg.dp)
        ) {
            // Header com avatar e dados
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = uiState.userInitials,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = uiState.userName,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = uiState.userEmail,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar Perfil",
                        modifier = Modifier.clickable(onClick = onEditProfileClick),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // Menu de opções
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    menuItems.forEach { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(onClick = item.onClick)
                                .padding(WgcCoreDsSpacing.md.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(imageVector = item.icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Text(text = item.title, style = MaterialTheme.typography.bodyMedium)
                            }
                            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
                        }
                    }
                }
            }

            // Botão Sair
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onLogoutClick)
                    .padding(WgcCoreDsSpacing.md.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = null, tint = MaterialTheme.colorScheme.error)
                Text(
                    text = "Sair da Conta",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
