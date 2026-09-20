package br.com.wgc.design_system.templates.screens.fintechneobank

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcFinancialBalanceCard
import br.com.wgc.design_system.components.cards.WgcFintechCreditCard
import br.com.wgc.design_system.components.cards.WgcFintechPixActionItem

@Composable
fun WgcNeobankHomeTemplate(
    onPixClick: () -> Unit = {},
    onPayClick: () -> Unit = {},
    onTransferClick: () -> Unit = {},
    onDepositClick: () -> Unit = {},
    onCreditCardClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.fintechPurple))
                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s44.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White)
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
                        Icon(Icons.Default.Visibility, contentDescription = "Ocultar", tint = Color.White)
                        Icon(Icons.Default.HelpOutline, contentDescription = "Ajuda", tint = Color.White)
                        Icon(Icons.Default.MailOutline, contentDescription = "Mensagens", tint = Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                Text("Olá, Gabriel", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcFinancialBalanceCard(balance = 5420.75)
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    WgcFintechPixActionItem(Icons.Default.QrCode, "Área Pix", onPixClick)
                    WgcFintechPixActionItem(Icons.Default.Receipt, "Pagar", onPayClick)
                    WgcFintechPixActionItem(Icons.Default.ArrowUpward, "Transferir", onTransferClick)
                    WgcFintechPixActionItem(Icons.Default.ArrowDownward, "Depositar", onDepositClick)
                    WgcFintechPixActionItem(Icons.Default.PhoneAndroid, "Recarga", {})
                    WgcFintechPixActionItem(Icons.Default.MonetizationOn, "Cobrar", {})
                }
            }

            item {
                WgcFintechCreditCard(
                    currentInvoice = FintechNeobankMockData.sampleCard.currentInvoice,
                    availableLimit = FintechNeobankMockData.sampleCard.availableLimit,
                    dueDate = FintechNeobankMockData.sampleCard.dueDate,
                    onPayInvoiceClick = onCreditCardClick
                )
            }
        }
    }
}
