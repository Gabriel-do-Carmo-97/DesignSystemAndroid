package br.com.wgc.ds_templates.screens.nexkart.profile

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
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcNexkartBottomNav

/**
 * Tela de Perfil e Configurações oficial do ecossistema Nexkart (WgcNexkartProfileTemplate).
 * Apresenta avatar do usuário, dados cadastrais, atalhos de navegação para pedidos, lista de desejos, cartões e encerramento de sessão.
 */
@Composable
fun WgcNexkartProfileTemplate(
    modifier: Modifier = Modifier,
    userName: String = "Gabriel do Carmo",
    userEmail: String = "gabriel.desenvolvedor.97@gmail.com",
    onOrdersClick: () -> Unit = {},
    onWishlistClick: () -> Unit = {},
    onPaymentCardsClick: () -> Unit = {},
    onAddressesClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onSignOutClick: () -> Unit = {},
    onNavItemSelected: (Int) -> Unit = {},
    bottomNavSlot: (@Composable () -> Unit)? = null
) {
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (bottomNavSlot != null) {
                bottomNavSlot()
            } else {
                WgcNexkartBottomNav(
                    selectedIndex = 3,
                    cartItemCount = 3,
                    onItemSelected = onNavItemSelected
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.lg24.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
        ) {
            // 1. Cabeçalho do Perfil (Avatar + Nome + Email)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                    .background(Color(WgcCoreDsColors.nexkartSurface))
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.nexkartPrimary)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Avatar",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                Column {
                    Text(
                        text = userName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.nexkartDark)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                    Text(
                        text = userEmail,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.nexkartSecondaryText)
                    )
                }
            }

            // 2. Menu de Atalhos
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                    .background(Color(WgcCoreDsColors.nexkartSurface))
                    .padding(vertical = WgcCoreDsSpacing.xs8.dp)
            ) {
                ProfileMenuItem(
                    icon = Icons.Default.ShoppingBag,
                    title = "My Orders",
                    onClick = onOrdersClick
                )
                ProfileMenuItem(
                    icon = Icons.Default.Favorite,
                    title = "Saved Wishlist",
                    onClick = onWishlistClick
                )
                ProfileMenuItem(
                    icon = Icons.Default.CreditCard,
                    title = "Payment Cards",
                    onClick = onPaymentCardsClick
                )
                ProfileMenuItem(
                    icon = Icons.Default.LocationOn,
                    title = "Delivery Addresses",
                    onClick = onAddressesClick
                )
                ProfileMenuItem(
                    icon = Icons.Default.Settings,
                    title = "Settings",
                    onClick = onSettingsClick
                )
                ProfileMenuItem(
                    icon = Icons.AutoMirrored.Filled.Logout,
                    title = "Sign Out",
                    isDestructive = true,
                    onClick = onSignOutClick
                )
            }
        }
    }
}

@Composable
private fun ProfileMenuItem(
    icon: ImageVector,
    title: String,
    isDestructive: Boolean = false,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.md16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (isDestructive) Color(WgcCoreDsColors.nexkartAccentPink) else Color(WgcCoreDsColors.nexkartPrimary),
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = if (isDestructive) Color(WgcCoreDsColors.nexkartAccentPink) else Color(WgcCoreDsColors.nexkartDark)
            )
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.nexkartSecondaryText),
            modifier = Modifier.size(14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartProfileTemplatePreview() {
    WgcNexkartProfileTemplate()
}
