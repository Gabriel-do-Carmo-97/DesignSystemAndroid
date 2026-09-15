package br.com.wgc.ds_templates.screens.shopease.profile

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
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcShopEaseBottomNav
import br.com.wgc.design_system.components.navigation.WgcShopEaseNavItem

/**
 * Tela de Perfil do ShopEase:
 * - Header curvo peach/sunset com avatar do usuário ("Tesshan Geeth")
 * - Formulário / detalhes de conta
 * - Links de navegação (Address, Payment, Orders, Offers)
 */
@Composable
fun WgcShopEaseProfileTemplate(
    userName: String = "Tesshan Geeth",
    userEmail: String = "tesshan.geeth@example.com",
    selectedNav: WgcShopEaseNavItem = WgcShopEaseNavItem.Profile,
    onNavSelect: (WgcShopEaseNavItem) -> Unit = {},
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
                WgcShopEaseBottomNav(
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
            // Header Peach / Sunset
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = WgcCoreDsBorderRadius.display45.dp,
                            bottomEnd = WgcCoreDsBorderRadius.display45.dp
                        )
                    )
                    .background(Color(WgcCoreDsColors.shopEasePeachBg))
                    .padding(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.xl32.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s80.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.shopEasePrimary)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Avatar",
                            tint = Color.White,
                            modifier = Modifier.size(WgcCoreDsSize.s48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Text(
                        text = userName,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.shopEaseDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                    Text(
                        text = userEmail,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.shopEaseSecondaryText)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Itens de Menu
            Column(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.lg24.dp)) {
                Text(
                    text = "My Account",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.shopEaseDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                ProfileRow(Icons.Default.LocationOn, "Shipping Address")
                ProfileRow(Icons.Default.CreditCard, "Payment Methods")
                ProfileRow(Icons.Default.LocalOffer, "My Offers & Vouchers")
                ProfileRow(Icons.Default.Notifications, "Notifications")
                ProfileRow(Icons.Default.HelpOutline, "Help & Support")
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Composable
private fun ProfileRow(icon: ImageVector, title: String, onClick: () -> Unit = {}) {
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
                .background(Color(WgcCoreDsColors.shopEasePrimaryLight)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.shopEasePrimaryDark),
                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
            )
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = Color(WgcCoreDsColors.shopEaseDark),
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.shopEaseSecondaryText),
            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
        )
    }
    HorizontalDivider(color = Color(WgcCoreDsColors.shopEaseBorder))
}

@Preview(showBackground = true)
@Composable
private fun WgcShopEaseProfileTemplatePreview() {
    WgcShopEaseProfileTemplate()
}
