package br.com.wgc.ds_templates.screens.discord

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
fun WgcDiscordServersTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(0xFF313338),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.discordBlurple)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Discord", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(DiscordMockData.sampleServers) { srv ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF2B2D31))) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(srv.name, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("${srv.channelsCount} canais • 🟢 ${srv.activeUsers} online", color = Color.Gray, fontSize = 14.sp.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcDiscordVoiceTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color(0xFF313338)) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Canais de Voz & Screen Share", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcDiscordDirectTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color(0xFF313338)) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Mensagens Diretas (DMs)", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcDiscordExploreTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color(0xFF313338)) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Descubra Servidores Públicos", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcDiscordProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color(0xFF313338)) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Perfil Discord Nitro", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}
