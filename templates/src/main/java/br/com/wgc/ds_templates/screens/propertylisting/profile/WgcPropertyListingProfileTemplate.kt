package br.com.wgc.ds_templates.screens.propertylisting.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.AddBusiness
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import br.com.wgc.design_system.components.navigation.WgcPropertyListingBottomNav
import br.com.wgc.design_system.components.navigation.WgcPropertyListingNavItem

/**
 * Template de Perfil e Menu Geral do Property Listing:
 * - Cabeçalho do usuário
 * - Card de destaque "Anuncie seu Imóvel" (Laranja PropertyListing)
 * - Atalhos de Mensagens com Imobiliárias, Alertas, Simulador de Financiamento e Segurança
 */
@Composable
fun WgcPropertyListingProfileTemplate(
    modifier: Modifier = Modifier,
    userName: String = "Gabriel do Carmo",
    userEmail: String = "gabriel@wgc.com.br",
    unreadMessagesCount: Int = 2,
    savedPropertiesCount: Int = 3,
    onAdvertisePropertyClick: () -> Unit = {},
    onMessagesClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
    onAlertsClick: () -> Unit = {},
    onFinancingClick: () -> Unit = {},
    onHelpClick: () -> Unit = {},
    selectedNavItem: WgcPropertyListingNavItem = WgcPropertyListingNavItem.Profile,
    onNavItemSelect: (WgcPropertyListingNavItem) -> Unit = {},
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (topBarSlot != null) {
                topBarSlot()
            } else {
                PropertyListingProfileTopBar()
            }
        },
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
                WgcPropertyListingBottomNav(
                    selectedItem = selectedNavItem,
                    onItemSelected = onNavItemSelect,
                    messagesBadgeCount = unreadMessagesCount
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.md16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header Usuário
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyListingSurface))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s60.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.propertyListingPrimary)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = userName.take(1),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                        Column {
                            Text(
                                text = userName,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.propertyListingDark)
                            )
                            Text(
                                text = userEmail,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.propertyListingSecondaryText)
                            )
                        }
                    }
                }
            }

            // Banner Anunciar Imóvel (Laranja PropertyListing)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = onAdvertisePropertyClick),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyListingOrange))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s44.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.AddBusiness,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Quer vender ou alugar?",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = "Anuncie no maior portal imobiliário do país",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White.copy(alpha = 0.9f)
                            )
                        }

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                    }
                }
            }

            // Menu de Atividades
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyListingSurface))
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        PropertyListingProfileMenuItem(
                            icon = Icons.Default.ChatBubbleOutline,
                            title = "Mensagens e Conversas",
                            subtitle = "$unreadMessagesCount contatos recentes",
                            badgeText = if (unreadMessagesCount > 0) "$unreadMessagesCount novas" else null,
                            onClick = onMessagesClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyListingBorder))
                        PropertyListingProfileMenuItem(
                            icon = Icons.Default.FavoriteBorder,
                            title = "Imóveis Salvos",
                            subtitle = "$savedPropertiesCount imóveis favoritados",
                            onClick = onFavoritesClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyListingBorder))
                        PropertyListingProfileMenuItem(
                            icon = Icons.Default.NotificationsNone,
                            title = "Alertas de Busca",
                            subtitle = "Receba novidades dos seus bairros favoritos",
                            onClick = onAlertsClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyListingBorder))
                        PropertyListingProfileMenuItem(
                            icon = Icons.Default.Calculate,
                            title = "Simulador de Financiamento",
                            subtitle = "Calcule parcelas e taxas de juros",
                            onClick = onFinancingClick
                        )
                    }
                }
            }

            // Menu Suporte e Segurança
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyListingSurface))
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        PropertyListingProfileMenuItem(
                            icon = Icons.Default.Security,
                            title = "Dicas de Segurança",
                            subtitle = "Como negociar imóveis com total tranquilidade",
                            onClick = {}
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyListingBorder))
                        PropertyListingProfileMenuItem(
                            icon = Icons.Default.Info,
                            title = "Central de Ajuda & FAQ",
                            subtitle = "Tire suas dúvidas sobre o portal",
                            onClick = onHelpClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyListingBorder))
                        PropertyListingProfileMenuItem(
                            icon = Icons.Default.Info,
                            title = "Sobre o Property Listing",
                            subtitle = "Termos, privacidade e versão",
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PropertyListingProfileTopBar() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.propertyListingSurface),
        shadowElevation = WgcCoreDsSpacing.xxs4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.md16.dp
                )
        ) {
            Text(
                text = "Menu do Usuário",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.propertyListingDark)
            )
        }
    }
}

@Composable
private fun PropertyListingProfileMenuItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    badgeText: String? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.md16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.propertyListingPrimary),
            modifier = Modifier.size(WgcCoreDsSize.s22.dp)
        )
        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.propertyListingDark)
                )
                if (badgeText != null) {
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color(WgcCoreDsColors.propertyListingOrangeLight))
                            .padding(
                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Text(
                            text = badgeText,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.propertyListingOrangeDark)
                        )
                    }
                }
            }
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.propertyListingSecondaryText)
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.propertyListingSecondaryText),
            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyListingProfileTemplatePreview() {
    WgcPropertyListingProfileTemplate()
}
