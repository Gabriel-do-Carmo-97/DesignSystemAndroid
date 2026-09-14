package br.com.wgc.ds_templates.screens.shoppe.profile

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Straighten
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.cards.WgcShoppeOrderStatusRow

/**
 * Telas 77 a 101: Perfil, Configurações de Conta, Cartões e Região do Shoppe.
 */
@Composable
fun WgcShoppeProfileScreenTemplate(
    modifier: Modifier = Modifier,
    userName: String = "Gabriel Carmo",
    userEmail: String = "gabriel.carmo@wgc.com.br",
    onOrderSectionClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onVouchersClick: () -> Unit = {},
    onShippingAddressClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.shoppeBackground)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // 1. User Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                WgcAvatar(
                    initials = "GC",
                    size = 64.dp
                )

                Spacer(modifier = Modifier.size(WgcCoreDsSpacing.md.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = userName,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Black),
                        color = Color(WgcCoreDsColors.shoppeDark)
                    )
                    Text(
                        text = userEmail,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.shoppeSecondaryText)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // 2. Order Status Row (To Pay, To Receive, To Review, etc.)
            WgcShoppeOrderStatusRow()

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // 3. Settings & Options Group
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column {
                    ProfileOptionItem(icon = Icons.Default.LocationOn, title = "Shipping Address", onClick = onShippingAddressClick)
                    ProfileOptionItem(icon = Icons.Default.CreditCard, title = "Payment Methods & Cards", onClick = {})
                    ProfileOptionItem(icon = Icons.Default.Straighten, title = "Sizes Guide (US, EU, UK)", onClick = {})
                    ProfileOptionItem(icon = Icons.Default.Language, title = "Language (English)", onClick = {})
                    ProfileOptionItem(icon = Icons.Default.MonetizationOn, title = "Currency (USD $)", onClick = {})
                    ProfileOptionItem(icon = Icons.Default.Notifications, title = "Notification Settings", onClick = onSettingsClick)
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
        }
    }
}

@Composable
private fun ProfileOptionItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.shoppePrimaryLight)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = title, tint = Color(WgcCoreDsColors.shoppePrimary), modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.size(WgcCoreDsSpacing.sm.dp))
            Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Color(WgcCoreDsColors.shoppeDark))
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.shoppeSecondaryText),
            modifier = Modifier.size(14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeProfileScreenTemplatePreview() {
    MaterialTheme {
        WgcShoppeProfileScreenTemplate()
    }
}
