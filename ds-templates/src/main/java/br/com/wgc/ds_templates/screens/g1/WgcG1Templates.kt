package br.com.wgc.ds_templates.screens.g1

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
fun WgcG1HomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.g1Red)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("g1 • O Portal de Notícias da Globo", fontWeight = FontWeight.ExtraBold, fontSize = WgcCoreDsFontSize.h3.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(G1MockData.sampleNews) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.section, color = Color(WgcCoreDsColors.g1Red), fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.caption.sp)
                        Text(item.headline, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.body1.sp)
                        Text(item.publishedAgo, color = Color.Gray, fontSize = WgcCoreDsFontSize.caption.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcG1CategoriesTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Categorias: Economia, Política, Tecnologia, Saúde", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcG1FactCheckTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Fato ou Boato • Verificação de Notícias Falsas", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcG1VideosTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Vídeos & Podcasts g1 (O Assunto)", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcG1ProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Notícias Salvas & Notificações de Plantão", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}
