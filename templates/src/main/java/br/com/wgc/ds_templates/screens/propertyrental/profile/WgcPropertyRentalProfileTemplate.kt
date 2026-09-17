package br.com.wgc.ds_templates.screens.propertyrental.profile

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
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.VerifiedUser
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
import br.com.wgc.design_system.components.navigation.WgcPropertyRentalBottomNav
import br.com.wgc.design_system.components.navigation.WgcPropertyRentalNavItem

/**
 * Template da Tela de Perfil e Gestão do Usuário Property Rental:
 * - Cabeçalho do inquilino com avatar, nome e selo de verificação de crédito
 * - Atalhos rápidos para Visitas agendadas, Propostas e Contratos ativos
 * - Menu de documentos, alertas de imóveis e suporte ao cliente
 */
@Composable
fun WgcPropertyRentalProfileTemplate(
    modifier: Modifier = Modifier,
    userName: String = "Gabriel do Carmo",
    userEmail: String = "gabriel@wgc.com.br",
    isVerified: Boolean = true,
    scheduledVisitsCount: Int = 1,
    proposalsCount: Int = 0,
    contractsCount: Int = 0,
    onMyVisitsClick: () -> Unit = {},
    onMyProposalsClick: () -> Unit = {},
    onMyContractsClick: () -> Unit = {},
    onDocumentsClick: () -> Unit = {},
    onAlertsClick: () -> Unit = {},
    onHelpClick: () -> Unit = {},
    selectedNavItem: WgcPropertyRentalNavItem = WgcPropertyRentalNavItem.Profile,
    onNavItemSelect: (WgcPropertyRentalNavItem) -> Unit = {},
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (topBarSlot != null) {
                topBarSlot()
            } else {
                ProfileTopBar()
            }
        },
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
                WgcPropertyRentalBottomNav(
                    selectedItem = selectedNavItem,
                    onItemSelected = onNavItemSelect,
                    visitsBadgeCount = scheduledVisitsCount
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
            // Header do Usuário
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyRentalSurface))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s60.dp)
                                    .clip(CircleShape)
                                    .background(Color(WgcCoreDsColors.propertyRentalPrimary)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = userName.take(1),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.propertyRentalYellow)
                                )
                            }

                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                            Column {
                                Text(
                                    text = userName,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.propertyRentalDark)
                                )
                                Text(
                                    text = userEmail,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(WgcCoreDsColors.propertyRentalSecondaryText)
                                )
                            }
                        }

                        if (isVerified) {
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(Color(WgcCoreDsColors.propertyRentalGreenLight))
                                    .padding(
                                        horizontal = WgcCoreDsSpacing.sm12.dp,
                                        vertical = WgcCoreDsSpacing.xxs4.dp
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.VerifiedUser,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.propertyRentalGreen),
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                                Text(
                                    text = "Crédito Pré-aprovado • Aluguel sem fiador",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.propertyRentalGreen)
                                )
                            }
                        }
                    }
                }
            }

            // Atalhos: Visitas, Propostas, Contratos
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    ProfileShortcutCard(
                        modifier = Modifier.weight(1f),
                        title = "Visitas",
                        subtitle = "$scheduledVisitsCount agendada",
                        icon = Icons.Default.CalendarToday,
                        onClick = onMyVisitsClick
                    )
                    ProfileShortcutCard(
                        modifier = Modifier.weight(1f),
                        title = "Propostas",
                        subtitle = "$proposalsCount ativas",
                        icon = Icons.Default.Receipt,
                        onClick = onMyProposalsClick
                    )
                    ProfileShortcutCard(
                        modifier = Modifier.weight(1f),
                        title = "Contratos",
                        subtitle = "$contractsCount ativos",
                        icon = Icons.Default.Description,
                        onClick = onMyContractsClick
                    )
                }
            }

            // Lista de Opções e Configurações
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyRentalSurface))
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        ProfileMenuItem(
                            icon = Icons.Default.Description,
                            title = "Documentos e Renda",
                            subtitle = "Comprovantes enviados para análise rápida",
                            onClick = onDocumentsClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyRentalBorder))
                        ProfileMenuItem(
                            icon = Icons.Default.NotificationsNone,
                            title = "Alertas de Imóveis",
                            subtitle = "Receba novidades nos seus bairros favoritos",
                            onClick = onAlertsClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyRentalBorder))
                        ProfileMenuItem(
                            icon = Icons.Default.Info,
                            title = "Central de Ajuda",
                            subtitle = "Perguntas frequentes e suporte via chat",
                            onClick = onHelpClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyRentalBorder))
                        ProfileMenuItem(
                            icon = Icons.Default.Info,
                            title = "Sobre o Property Rental",
                            subtitle = "Termos, políticas de privacidade e versão",
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfileTopBar() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.propertyRentalSurface),
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
                text = "Meu Perfil",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.propertyRentalDark)
            )
        }
    }
}

@Composable
private fun ProfileShortcutCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyRentalSurface))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.sm12.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.propertyRentalPrimary),
                modifier = Modifier.size(WgcCoreDsSize.s22.dp)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.propertyRentalDark)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = Color(WgcCoreDsColors.propertyRentalSecondaryText)
            )
        }
    }
}

@Composable
private fun ProfileMenuItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
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
            tint = Color(WgcCoreDsColors.propertyRentalPrimary),
            modifier = Modifier.size(WgcCoreDsSize.s22.dp)
        )
        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(WgcCoreDsColors.propertyRentalDark)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.propertyRentalSecondaryText)
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.propertyRentalSecondaryText),
            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyRentalProfileTemplatePreview() {
    WgcPropertyRentalProfileTemplate()
}
