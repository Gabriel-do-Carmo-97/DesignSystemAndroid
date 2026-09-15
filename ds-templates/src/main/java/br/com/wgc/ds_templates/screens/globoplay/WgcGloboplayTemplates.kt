package br.com.wgc.ds_templates.screens.globoplay

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
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcGloboplayHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.globoplayOrange)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("globoplay • Ao Vivo e Sob Demanda", fontWeight = FontWeight.ExtraBold, fontSize = WgcCoreDsFontSize.h3.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(GloboplayMockData.sampleContent) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.title, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.body1.sp)
                        Text("${item.category} • ${item.channel}", color = Color.Gray, fontSize = WgcCoreDsFontSize.caption.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcGloboplayLiveTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Agora na TV • Canais Globosat ao Vivo", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcGloboplayNovelasTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Catálogo de Novelas & Séries", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcGloboplayChannelsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Telecine, Premiere & Combate", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcGloboplayProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Perfil Conta Globo", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}
