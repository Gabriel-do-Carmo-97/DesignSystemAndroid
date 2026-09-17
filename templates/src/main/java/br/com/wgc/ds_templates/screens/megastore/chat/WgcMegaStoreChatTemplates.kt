package br.com.wgc.ds_templates.screens.megastore.chat

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcMegaStoreVoucherCard
import br.com.wgc.ds_templates.screens.megastore.model.ShoppeChatMessage
import br.com.wgc.ds_templates.screens.megastore.model.ShoppeVoucherItem

/**
 * Telas 65 a 76: Atendimento ao Cliente / Chat Oficial do Shoppe.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcShoppeChatScreenTemplate(
    modifier: Modifier = Modifier,
    messages: List<ShoppeChatMessage> = listOf(
        ShoppeChatMessage("1", "Support Agent", "Hello! How can I assist your order today?", "10:00 AM", isFromUser = false),
        ShoppeChatMessage("2", "You", "Hi! I wanted to check if there are any vouchers available.", "10:02 AM", isFromUser = true),
        ShoppeChatMessage(
            "3",
            "Support Agent",
            "Sure! Here is an exclusive $20 OFF voucher for your next order:",
            "10:03 AM",
            isFromUser = false,
            attachedVoucher = ShoppeVoucherItem("v1", "$20 OFF", "Min. Spend $100", "Valid till today", false)
        )
    ),
    onBackClick: () -> Unit = {},
    onSendMessage: (String) -> Unit = {}
) {
    var inputText by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.megaStorePrimaryLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.SupportAgent, contentDescription = null, tint = Color(WgcCoreDsColors.megaStorePrimary))
                        }
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm.dp))
                        Column {
                            Text("Shoppe Support", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text("Online Agent", fontSize = 11.sp, color = Color(WgcCoreDsColors.megaStoreSecondaryText))
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(WgcCoreDsSpacing.sm.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
                ) {
                    OutlinedTextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        placeholder = { Text("Type your message...") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                    )
                    IconButton(
                        onClick = {
                            if (inputText.isNotBlank()) {
                                onSendMessage(inputText)
                                inputText = ""
                            }
                        },
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.megaStorePrimary))
                    ) {
                        Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Enviar", tint = Color.White)
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
        ) {
            items(messages) { msg ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = if (msg.isFromUser) Alignment.End else Alignment.Start
                ) {
                    Box(
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(
                                    topStart = 16.dp,
                                    topEnd = 16.dp,
                                    bottomStart = if (msg.isFromUser) 16.dp else 2.dp,
                                    bottomEnd = if (msg.isFromUser) 2.dp else 16.dp
                                )
                            )
                            .background(
                                if (msg.isFromUser) Color(WgcCoreDsColors.megaStorePrimary) else Color.White
                            )
                            .padding(WgcCoreDsSpacing.md.dp)
                    ) {
                        Text(
                            text = msg.text,
                            color = if (msg.isFromUser) Color.White else Color(WgcCoreDsColors.megaStoreDark),
                            fontSize = 14.sp
                        )
                    }

                    if (msg.attachedVoucher != null) {
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
                        WgcMegaStoreVoucherCard(
                            discountTitle = msg.attachedVoucher.discountTitle,
                            minSpend = msg.attachedVoucher.minSpend,
                            expiryDate = msg.attachedVoucher.expiryDate
                        )
                    }

                    Text(
                        text = msg.timestamp,
                        fontSize = 10.sp,
                        color = Color(WgcCoreDsColors.megaStoreSecondaryText),
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeChatScreenTemplatePreview() {
    MaterialTheme {
        WgcShoppeChatScreenTemplate()
    }
}
