package br.com.wgc.ds_templates.screens.uol

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
fun WgcUolHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.uolYellow)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("UOL • O Melhor Conteúdo", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(UolMockData.sampleNews) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.author, color = Color.Gray, fontSize = 14.sp)
                        Text(item.headline, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcUolEconomyTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("UOL Economia & Cotações em Tempo Real", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcUolSportsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("UOL Esporte • Placar ao Vivo", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcUolOpinionTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Colunistas & Opinião UOL", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcUolProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Conta UOL & Clube UOL", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}
