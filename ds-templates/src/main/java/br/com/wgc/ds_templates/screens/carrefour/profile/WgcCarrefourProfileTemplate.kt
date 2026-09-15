package br.com.wgc.ds_templates.screens.carrefour.profile

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.CarrefourNavTab
import br.com.wgc.design_system.components.navigation.WgcCarrefourBottomNav
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourMockData
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourUserProfile

@Composable
fun WgcCarrefourProfileTemplate(
    modifier: Modifier = Modifier,
    userProfile: CarrefourUserProfile = CarrefourMockData.sampleUserProfile,
    activeTab: CarrefourNavTab = CarrefourNavTab.MEU_CARREFOUR,
    onTabSelected: (CarrefourNavTab) -> Unit = {},
    onMenuItemClick: (String) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.carrefourBackground),
        bottomBar = {
            WgcCarrefourBottomNav(
                selectedTab = activeTab,
                onTabSelected = onTabSelected,
                cartBadgeCount = 3
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.xl32.dp)
        ) {
            // Header Perfil
            item {
                ProfileHeaderSection(userProfile = userProfile)
            }

            // QR Code para Identificação no Caixa
            item {
                CashierIdentificationCard(cpf = userProfile.cpf)
            }

            // Cartão Carrefour Resumo
            item {
                CardSummarySection(userProfile = userProfile)
            }

            // Menus de Configurações
            item {
                ProfileMenuOptions(onMenuItemClick = onMenuItemClick)
            }
        }
    }
}

@Composable
private fun ProfileHeaderSection(userProfile: CarrefourUserProfile) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(WgcCoreDsColors.carrefourBlue))
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.lg24.dp
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s64.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.carrefourSurface)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.carrefourBlue),
                    modifier = Modifier.size(WgcCoreDsSize.s36.dp)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

            Column {
                Text(
                    text = userProfile.name,
                    fontSize = 16.sp.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.carrefourSurface)
                )
                Text(
                    text = "Cliente " + userProfile.membershipLevel,
                    fontSize = 12.sp.sp,
                    color = Color(WgcCoreDsColors.carrefourYellow),
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = userProfile.email,
                    fontSize = 10.sp.sp,
                    color = Color(WgcCoreDsColors.carrefourSurface).copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Composable
private fun CashierIdentificationCard(cpf: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.md16.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.carrefourSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Identifique-se no Caixa para Descontos",
                fontSize = 12.sp.sp,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.carrefourTextPrimary)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Icon(
                imageVector = Icons.Default.QrCode,
                contentDescription = "QR Code",
                tint = Color(WgcCoreDsColors.carrefourBlue),
                modifier = Modifier.size(WgcCoreDsSize.s100.dp)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = "CPF: $cpf",
                fontSize = 12.sp.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(WgcCoreDsColors.carrefourTextSecondary)
            )
        }
    }
}

@Composable
private fun CardSummarySection(userProfile: CarrefourUserProfile) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.carrefourSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CreditCard,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.carrefourBlue),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Cartão Carrefour",
                        fontSize = 14.sp.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.carrefourTextPrimary)
                    )
                }

                Text(
                    text = "•••• " + userProfile.cardLastDigits,
                    fontSize = 12.sp.sp,
                    color = Color(WgcCoreDsColors.carrefourTextSecondary)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Limite Disponível",
                        fontSize = 10.sp.sp,
                        color = Color(WgcCoreDsColors.carrefourTextSecondary)
                    )
                    Text(
                        text = "R$ " + String.format("%.2f", userProfile.availableLimit),
                        fontSize = 14.sp.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.carrefourBlue)
                    )
                }

                Column {
                    Text(
                        text = "Fatura Aberta",
                        fontSize = 10.sp.sp,
                        color = Color(WgcCoreDsColors.carrefourTextSecondary)
                    )
                    Text(
                        text = "R$ " + String.format("%.2f", userProfile.invoiceAmount),
                        fontSize = 14.sp.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.carrefourRed)
                    )
                }
            }
        }
    }
}

@Composable
private fun ProfileMenuOptions(onMenuItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.md16.dp
            ),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.carrefourSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            ProfileMenuItem(
                icon = Icons.Default.History,
                title = "Meus Pedidos e Notas Fiscais",
                onClick = { onMenuItemClick("pedidos") }
            )
            HorizontalDivider(color = Color(WgcCoreDsColors.carrefourBorder))

            ProfileMenuItem(
                icon = Icons.Default.MonetizationOn,
                title = "Extrato de Moedas Meu Carrefour",
                onClick = { onMenuItemClick("moedas") }
            )
            HorizontalDivider(color = Color(WgcCoreDsColors.carrefourBorder))

            ProfileMenuItem(
                icon = Icons.Default.LocationOn,
                title = "Endereços de Entrega",
                onClick = { onMenuItemClick("enderecos") }
            )
            HorizontalDivider(color = Color(WgcCoreDsColors.carrefourBorder))

            ProfileMenuItem(
                icon = Icons.Default.NotificationsNone,
                title = "Notificações & Promoções",
                onClick = { onMenuItemClick("notificacoes") }
            )
            HorizontalDivider(color = Color(WgcCoreDsColors.carrefourBorder))

            ProfileMenuItem(
                icon = Icons.Default.HelpOutline,
                title = "Ajuda e Atendimento SAC",
                onClick = { onMenuItemClick("ajuda") }
            )
        }
    }
}

@Composable
private fun ProfileMenuItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.md16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.carrefourBlue),
            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
        )
        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
        Text(
            text = title,
            fontSize = 12.sp.sp,
            fontWeight = FontWeight.Medium,
            color = Color(WgcCoreDsColors.carrefourTextPrimary),
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.carrefourTextSecondary),
            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcCarrefourProfileTemplatePreview() {
    WgcCarrefourProfileTemplate()
}
