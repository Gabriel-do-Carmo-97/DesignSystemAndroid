package br.com.wgc.design_system.templates.screens.audiostreaming

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
fun WgcAudioStreamHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.hardwareNinjaBlack)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Boa tarde", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            item { Text("Tocadas recentemente", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp) }
            items(AudioStreamMockData.sampleTracks) { track ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp), colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.fintechCarbonBorder))) {
                    Row(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column {
                            Text(track.title, fontWeight = FontWeight.Bold, color = Color.White)
                            Text(track.artist, color = Color.LightGray, fontSize = 14.sp)
                        }
                        Text(track.duration, color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcAudioStreamSearchTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Buscar Músicas, Podcasts & Playlists", modifier = modifier)

@Composable
fun WgcAudioStreamLibraryTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Sua Biblioteca & Playlists Curtidas", modifier = modifier)

@Composable
fun WgcAudioStreamPlayerTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Player em Reprodução • Letras em Tempo Real", modifier = modifier)

@Composable
fun WgcAudioStreamProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Áudio Streaming Premium Familiar", modifier = modifier)
