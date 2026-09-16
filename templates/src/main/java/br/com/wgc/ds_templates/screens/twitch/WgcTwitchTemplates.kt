package br.com.wgc.ds_templates.screens.twitch

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
fun WgcTwitchLiveTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.twitchPurple)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Twitch • Ao Vivo Agora", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(TwitchMockData.sampleLive) { stream ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF1F1F23))) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(stream.streamer, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("${stream.game} • 🔴 ${stream.viewers} espectadores", color = Color.LightGray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcTwitchBrowseTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Explorar Categorias & Games", modifier = modifier)

@Composable
fun WgcTwitchChatTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Chat da Transmissão & Emotes WGC", modifier = modifier)

@Composable
fun WgcTwitchSubsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Inscrições Prime & Bits", modifier = modifier)

@Composable
fun WgcTwitchProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Painel de Criador de Conteúdo", modifier = modifier)
