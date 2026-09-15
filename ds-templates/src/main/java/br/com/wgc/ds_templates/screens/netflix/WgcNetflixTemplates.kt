package br.com.wgc.ds_templates.screens.netflix

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
fun WgcNetflixHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.Black,
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color.Black).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("NETFLIX", fontWeight = FontWeight.ExtraBold, fontSize = WgcCoreDsFontSize.h2.sp, color = Color(WgcCoreDsColors.netflixRed))
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
            item { Text("Top 10 Séries Hoje no Brasil", color = Color.White, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp) }
            items(NetflixMockData.sampleTop10) { show ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs4.dp)) {
                        Text(show.title, fontWeight = FontWeight.Bold, color = Color.White, fontSize = WgcCoreDsFontSize.body1.sp)
                        Text("${show.matchPercentage} • ${show.maturity} • ${show.genre}", color = Color(0xFF46D369), fontSize = WgcCoreDsFontSize.caption.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcNetflixTrailerTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color.Black) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Player & Previews de Séries", color = Color.White, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcNetflixMyListTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color.Black) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Minha Lista & Títulos Salvos", color = Color.White, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcNetflixNewsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color.Black) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Novidades & Em Breve", color = Color.White, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcNetflixProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = Color.Black) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Quem está assistindo? • Perfis", color = Color.White, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}
