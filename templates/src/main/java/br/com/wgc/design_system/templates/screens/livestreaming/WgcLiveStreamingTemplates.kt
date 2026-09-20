package br.com.wgc.design_system.templates.screens.livestreaming

import br.com.wgc.design_system.templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

@Composable
fun WgcLiveStreamingLiveTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.liveStreamingPurple)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Transmissões • Ao Vivo Agora", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(LiveStreamingMockData.sampleLive) { stream ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.liveStreamingDarkCard))) {
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
fun WgcLiveStreamingBrowseTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Explorar Categorias & Transmissões", modifier = modifier)

@Composable
fun WgcLiveStreamingChatTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Chat da Transmissão & Emotes WGC", modifier = modifier)

@Composable
fun WgcLiveStreamingSubsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Inscrições & Apoios da Comunidade", modifier = modifier)

@Composable
fun WgcLiveStreamingProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Painel de Criador de Conteúdo", modifier = modifier)
