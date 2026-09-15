package br.com.wgc.ds_templates.screens.nubank

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
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcNubankAccountCard
import br.com.wgc.design_system.components.cards.WgcNubankCreditCard
import br.com.wgc.design_system.components.cards.WgcNubankPixActionItem

@Composable
fun WgcNubankHomeTemplate(
    onPixClick: () -> Unit = {},
    onPayClick: () -> Unit = {},
    onTransferClick: () -> Unit = {},
    onDepositClick: () -> Unit = {},
    onCreditCardClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.gray50),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.nubankPrimary))
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
                Text("Olá, Gabriel", color = Color.White, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
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
                WgcNubankAccountCard(balance = 5420.75)
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    WgcNubankPixActionItem(Icons.Default.QrCode, "Área Pix", onPixClick)
                    WgcNubankPixActionItem(Icons.Default.BarcodeReader, "Pagar", onPayClick)
                    WgcNubankPixActionItem(Icons.Default.ArrowUpward, "Transferir", onTransferClick)
                    WgcNubankPixActionItem(Icons.Default.ArrowDownward, "Depositar", onDepositClick)
                    WgcNubankPixActionItem(Icons.Default.PhoneAndroid, "Recarga", {})
                    WgcNubankPixActionItem(Icons.Default.MonetizationOn, "Cobrar", {})
                }
            }

            item {
                WgcNubankCreditCard(
                    currentInvoice = NubankMockData.sampleCard.currentInvoice,
                    availableLimit = NubankMockData.sampleCard.availableLimit,
                    dueDate = NubankMockData.sampleCard.dueDate,
                    onPayInvoiceClick = onCreditCardClick
                )
            }
        }
    }
}
