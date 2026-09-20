package br.com.wgc.design_system.templates.screens.curatedmarket.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.components.navigation.WgcCuratedBottomNav
import br.com.wgc.design_system.templates.screens.curatedmarket.model.CuratedMarketMockData
import br.com.wgc.design_system.templates.screens.curatedmarket.model.TasselUserProfile

/**
 * Tela de perfil do usuário oficial do ecossistema Tassel (WgcTasselProfileTemplate).
 * Apresenta foto circular de avatar, nome e handle, pílula de contas seguidas,
 * botão roxo de configurações rápidas e lista de opções da conta.
 */
@Composable
fun WgcTasselProfileTemplate(
    modifier: Modifier = Modifier,
    profile: TasselUserProfile = CuratedMarketMockData.profile,
    selectedNavIndex: Int = 3, // Profile
    onBackClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onFollowingClick: () -> Unit = {},
    onOrdersClick: () -> Unit = {},
    onSavedItemsClick: () -> Unit = {},
    onNavItemSelected: (Int) -> Unit = {},
    customHeaderSlot: (@Composable () -> Unit)? = null,
    customMenuSlot: (@Composable () -> Unit)? = null,
    customBottomNavSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomNavSlot != null) {
                customBottomNavSlot()
            } else {
                WgcCuratedBottomNav(
                    selectedIndex = selectedNavIndex,
                    onItemSelected = onNavItemSelected
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = WgcCoreDsSpacing.md16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s40.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.curatedMarketSurface))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.curatedMarketDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Profile",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.curatedMarketDark)
                )

                Spacer(modifier = Modifier.weight(1f))

                // Balanceador
                Spacer(modifier = Modifier.size(WgcCoreDsSize.s40.dp))
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Profile Header
            if (customHeaderSlot != null) {
                customHeaderSlot()
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Avatar Circular
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s80.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.curatedMarketSurface)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (!profile.avatarUrl.isNullOrEmpty()) {
                            AsyncImageDefault(
                                image = profile.avatarUrl,
                                contentDescription = profile.name,
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            Text(
                                text = profile.name.take(2).uppercase(),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.curatedMarketPrimary)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Text(
                        text = profile.name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.curatedMarketDark)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))

                    Text(
                        text = profile.handle,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.curatedMarketSecondaryText)
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                    // Linha de Ações: Pílula Following + Botão Roxo Settings
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        // Pílula Following
                        Box(
                            modifier = Modifier
                                .height(WgcCoreDsSize.s40.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .border(
                                    width = WgcCoreDsSpacing.xxxs2.dp,
                                    color = Color(WgcCoreDsColors.curatedMarketBorder),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable(onClick = onFollowingClick)
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${profile.followingCount} Following",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(WgcCoreDsColors.curatedMarketDark)
                            )
                        }

                        // Botão Quadrado Roxo com Settings
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s40.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.curatedMarketPrimary))
                                .clickable(onClick = onSettingsClick),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Configurações",
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            // Menu de Opções
            if (customMenuSlot != null) {
                customMenuSlot()
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    TasselProfileMenuItem(
                        icon = Icons.Outlined.ShoppingBag,
                        title = "My Orders",
                        badge = "${profile.ordersCount}",
                        onClick = onOrdersClick
                    )

                    TasselProfileMenuItem(
                        icon = Icons.Outlined.BookmarkBorder,
                        title = "Saved Items",
                        badge = "${profile.savedCount}",
                        onClick = onSavedItemsClick
                    )

                    TasselProfileMenuItem(
                        icon = Icons.Default.LocationOn,
                        title = "Delivery Addresses",
                        onClick = {}
                    )

                    TasselProfileMenuItem(
                        icon = Icons.Default.CreditCard,
                        title = "Payment Methods",
                        onClick = {}
                    )

                    TasselProfileMenuItem(
                        icon = Icons.Default.NotificationsNone,
                        title = "Notifications",
                        onClick = {}
                    )

                    TasselProfileMenuItem(
                        icon = Icons.Default.HelpOutline,
                        title = "Help & Support",
                        onClick = {}
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Composable
private fun TasselProfileMenuItem(
    icon: ImageVector,
    title: String,
    badge: String? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(Color(WgcCoreDsColors.curatedMarketSurface))
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.sm12.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = Color(WgcCoreDsColors.curatedMarketDark),
            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
        )

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = Color(WgcCoreDsColors.curatedMarketDark),
            modifier = Modifier.weight(1f)
        )

        if (!badge.isNullOrEmpty()) {
            Text(
                text = badge,
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.curatedMarketSecondaryText),
                modifier = Modifier.padding(end = WgcCoreDsSpacing.xs8.dp)
            )
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.curatedMarketSecondaryText),
            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselProfileTemplatePreview() {
    WgcTasselProfileTemplate()
}
