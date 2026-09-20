package br.com.wgc.design_system.templates.screens.freshgrocery.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcFreshGroceryBottomNav
import br.com.wgc.design_system.components.navigation.WgcFreshGroceryNavItem

/**
 * Tela de Perfil do Fresh Grocery:
 * - Card de usuário com avatar, nome ("Alex Turner") e e-mail
 * - Estatísticas rápidas (Pedidos, Cupons, Pontos)
 * - Menu de configurações e opções de conta
 */
@Composable
fun WgcFreshGroceryProfileTemplate(
    userName: String = "Alex Turner",
    userEmail: String = "alex.turner@example.com",
    selectedNav: WgcFreshGroceryNavItem = WgcFreshGroceryNavItem.Profile,
    onNavSelect: (WgcFreshGroceryNavItem) -> Unit = {},
    bottomNavSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (bottomNavSlot != null) {
                bottomNavSlot()
            } else {
                WgcFreshGroceryBottomNav(
                    selectedItem = selectedNav,
                    onItemSelected = onNavSelect
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = WgcCoreDsBorderRadius.xxl24.dp,
                            bottomEnd = WgcCoreDsBorderRadius.xxl24.dp
                        )
                    )
                    .background(Color(WgcCoreDsColors.megaStorerPrimary))
                    .padding(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.lg24.dp
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s64.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Avatar",
                            tint = Color(WgcCoreDsColors.megaStorerPrimary),
                            modifier = Modifier.size(WgcCoreDsSize.s36.dp)
                        )
                    }

                    Column {
                        Text(
                            text = userName,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                        Text(
                            text = userEmail,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Estatísticas
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ProfileStatItem("Orders", "12")
                ProfileStatItem("Vouchers", "5")
                ProfileStatItem("Points", "340")
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Itens de Menu
            Column(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.lg24.dp)) {
                Text(
                    text = "Account Settings",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.megaStorerDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                ProfileMenuItem(Icons.Default.LocationOn, "Shipping Addresses")
                ProfileMenuItem(Icons.Default.CreditCard, "Payment Methods")
                ProfileMenuItem(Icons.Default.Notifications, "Notifications")
                ProfileMenuItem(Icons.Default.Security, "Privacy & Security")
                ProfileMenuItem(Icons.AutoMirrored.Filled.HelpOutline, "Help & Support")
            }
        }
    }
}

@Composable
private fun ProfileStatItem(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(Color(WgcCoreDsColors.megaStorerSurface))
            .padding(
                horizontal = WgcCoreDsSpacing.lg24.dp,
                vertical = WgcCoreDsSpacing.md16.dp
            )
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.megaStorerPrimary)
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color(WgcCoreDsColors.megaStorerSecondaryText)
        )
    }
}

@Composable
private fun ProfileMenuItem(icon: ImageVector, title: String, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = WgcCoreDsSpacing.md16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(WgcCoreDsSize.s40.dp)
                .clip(CircleShape)
                .background(Color(WgcCoreDsColors.megaStorerSurface)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.megaStorerPrimary),
                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
            )
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = Color(WgcCoreDsColors.megaStorerDark),
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.megaStorerSecondaryText),
            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
        )
    }
    HorizontalDivider(color = Color(WgcCoreDsColors.megaStorerBorder))
}

@Preview(showBackground = true)
@Composable
private fun WgcFreshGroceryProfileTemplatePreview() {
    WgcFreshGroceryProfileTemplate()
}
