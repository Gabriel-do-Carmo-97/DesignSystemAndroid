package br.com.wgc.design_system.templates.screens.broadcaststreaming

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
fun WgcGloboplayHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.broadcastStreamingOrange)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("globoplay • Ao Vivo e Sob Demanda", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(BroadcastStreamingMockData.sampleContent) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("${item.category} • ${item.channel}", color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcGloboplayLiveTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Agora na TV • Canais Globosat ao Vivo", modifier = modifier)

@Composable
fun WgcGloboplayNovelasTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Catálogo de Novelas & Séries", modifier = modifier)

@Composable
fun WgcGloboplayChannelsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Telecine, Premiere & Combate", modifier = modifier)

@Composable
fun WgcGloboplayProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Conta Globo", modifier = modifier)
