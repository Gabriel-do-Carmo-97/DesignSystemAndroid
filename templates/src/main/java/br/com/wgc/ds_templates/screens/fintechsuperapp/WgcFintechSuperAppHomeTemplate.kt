package br.com.wgc.ds_templates.screens.fintechsuperapp

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcFintechSuperAppActionItem
import br.com.wgc.design_system.components.cards.WgcInterCashbackBanner

@Composable
fun WgcInterHomeTemplate(
    onShopClick: () -> Unit = {},
    onInvestClick: () -> Unit = {},
    onCardClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.fintechOrange))
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Fintech Super App", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
                        Icon(Icons.Default.Notifications, contentDescription = null, tint = Color.White)
                        Icon(Icons.Default.AccountCircle, contentDescription = null, tint = Color.White)
                    }
                }
                Spacer(Modifier.height(WgcCoreDsSpacing.sm12.dp))
                Text("Saldo em conta", color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
                Text("R$ 12.890,40", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    WgcFintechSuperAppActionItem(Icons.Default.QrCode, "Pix", {})
                    WgcFintechSuperAppActionItem(Icons.Default.ShoppingBag, "Shopping", onShopClick)
                    WgcFintechSuperAppActionItem(Icons.Default.TrendingUp, "Investir", onInvestClick)
                    WgcFintechSuperAppActionItem(Icons.Default.CreditCard, "Cartões", onCardClick)
                    WgcFintechSuperAppActionItem(Icons.Default.Flight, "Passagens", {})
                }
            }

            item {
                Text("Destaques do Shopping", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }

            item {
                WgcInterCashbackBanner(
                    storeName = "Loja de Tecnologia Oficial",
                    cashback = "10% Cashback",
                    description = "Compre iPhones e MacBooks com cashback direto na conta",
                    onShopClick = onShopClick
                )
            }
        }
    }
}
