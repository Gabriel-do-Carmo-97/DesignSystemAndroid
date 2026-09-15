package br.com.wgc.ds_templates.screens.twitch

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
fun WgcTwitchLiveTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(0xFF0E0E10),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.twitchPurple)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Twitch • Ao Vivo Agora", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(TwitchMockData.sampleLive) { stream ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF1F1F23))) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(stream.streamer, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("${stream.game} • 🔴 ${stream.viewers} espectadores", color = Color.LightGray, fontSize = 14.sp.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcTwitchBrowseTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color(0xFF0E0E10)) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Explorar Categorias & Games", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcTwitchChatTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color(0xFF0E0E10)) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Chat da Transmissão & Emotes WGC", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcTwitchSubsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color(0xFF0E0E10)) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Inscrições Prime & Bits", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcTwitchProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color(0xFF0E0E10)) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Painel de Criador de Conteúdo", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}
