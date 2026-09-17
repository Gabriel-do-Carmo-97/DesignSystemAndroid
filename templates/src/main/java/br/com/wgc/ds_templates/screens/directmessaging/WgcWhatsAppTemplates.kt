package br.com.wgc.ds_templates.screens.directmessaging

import br.com.wgc.ds_templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcWhatsAppChatsTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.directMessagingGreen)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Mensagens Diretas", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(WhatsAppMockData.sampleChats) { chat ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Row(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column {
                            Text(chat.name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text(chat.lastMessage, color = Color.Gray, fontSize = 14.sp)
                        }
                        Text(chat.time, color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcWhatsAppStatusTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Atualizações de Status", modifier = modifier)

@Composable
fun WgcWhatsAppCallsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Chamadas de Voz & Vídeo", modifier = modifier)

@Composable
fun WgcWhatsAppCommunitiesTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Comunidades & Avisos Oficiais", modifier = modifier)

@Composable
fun WgcWhatsAppSettingsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Configurações & Privacidade", modifier = modifier)
