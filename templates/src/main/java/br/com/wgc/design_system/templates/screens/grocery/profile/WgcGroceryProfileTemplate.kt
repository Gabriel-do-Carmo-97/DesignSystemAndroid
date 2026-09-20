package br.com.wgc.design_system.templates.screens.grocery.profile

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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.GroceryNavTab
import br.com.wgc.design_system.components.navigation.WgcGroceryBottomNav
import br.com.wgc.design_system.templates.screens.grocery.model.GroceryMockData
import br.com.wgc.design_system.templates.screens.grocery.model.SupermercadoUserProfile

@Composable
fun WgcSupermercadoProfileTemplate(
    modifier: Modifier = Modifier,
    userProfile: SupermercadoUserProfile = GroceryMockData.sampleUserProfile,
    activeTab: GroceryNavTab = GroceryNavTab.LOYALTY,
    onTabSelected: (GroceryNavTab) -> Unit = {},
    onMenuItemClick: (String) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            WgcGroceryBottomNav(
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

            // Cartão Supermercado Resumo
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
private fun ProfileHeaderSection(userProfile: SupermercadoUserProfile) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(WgcCoreDsColors.groceryBlue))
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
                    .background(Color(WgcCoreDsColors.grocerySurface)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.groceryBlue),
                    modifier = Modifier.size(WgcCoreDsSize.s36.dp)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

            Column {
                Text(
                    text = userProfile.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.grocerySurface)
                )
                Text(
                    text = "Cliente " + userProfile.membershipLevel,
                    fontSize = 12.sp,
                    color = Color(WgcCoreDsColors.groceryYellow),
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = userProfile.email,
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.grocerySurface).copy(alpha = 0.8f)
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
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.grocerySurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Identifique-se no Caixa para Descontos",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.groceryTextPrimary)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Icon(
                imageVector = Icons.Default.QrCode,
                contentDescription = "QR Code",
                tint = Color(WgcCoreDsColors.groceryBlue),
                modifier = Modifier.size(WgcCoreDsSize.s100.dp)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = "CPF: $cpf",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(WgcCoreDsColors.groceryTextSecondary)
            )
        }
    }
}

@Composable
private fun CardSummarySection(userProfile: SupermercadoUserProfile) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.grocerySurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
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
                        tint = Color(WgcCoreDsColors.groceryBlue),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Cartão Supermercado",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.groceryTextPrimary)
                    )
                }

                Text(
                    text = "•••• " + userProfile.cardLastDigits,
                    fontSize = 12.sp,
                    color = Color(WgcCoreDsColors.groceryTextSecondary)
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
                        fontSize = 10.sp,
                        color = Color(WgcCoreDsColors.groceryTextSecondary)
                    )
                    Text(
                        text = "R$ " + String.format("%.2f", userProfile.availableLimit),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.groceryBlue)
                    )
                }

                Column {
                    Text(
                        text = "Fatura Aberta",
                        fontSize = 10.sp,
                        color = Color(WgcCoreDsColors.groceryTextSecondary)
                    )
                    Text(
                        text = "R$ " + String.format("%.2f", userProfile.invoiceAmount),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.groceryRed)
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
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.grocerySurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            ProfileMenuItem(
                icon = Icons.Default.History,
                title = "Meus Pedidos e Notas Fiscais",
                onClick = { onMenuItemClick("pedidos") }
            )
            HorizontalDivider(color = Color(WgcCoreDsColors.groceryBorder))

            ProfileMenuItem(
                icon = Icons.Default.MonetizationOn,
                title = "Extrato de Moedas Meu Supermercado",
                onClick = { onMenuItemClick("moedas") }
            )
            HorizontalDivider(color = Color(WgcCoreDsColors.groceryBorder))

            ProfileMenuItem(
                icon = Icons.Default.LocationOn,
                title = "Endereços de Entrega",
                onClick = { onMenuItemClick("enderecos") }
            )
            HorizontalDivider(color = Color(WgcCoreDsColors.groceryBorder))

            ProfileMenuItem(
                icon = Icons.Default.NotificationsNone,
                title = "Notificações & Promoções",
                onClick = { onMenuItemClick("notificacoes") }
            )
            HorizontalDivider(color = Color(WgcCoreDsColors.groceryBorder))

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
            tint = Color(WgcCoreDsColors.groceryBlue),
            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
        )
        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(WgcCoreDsColors.groceryTextPrimary),
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.groceryTextSecondary),
            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSupermercadoProfileTemplatePreview() {
    WgcSupermercadoProfileTemplate()
}
