package br.com.wgc.ds_templates.screens.netflix

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
fun WgcNetflixHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.Black,
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color.Black).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("NETFLIX", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color(WgcCoreDsColors.netflixRed))
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
            item { Text("Top 10 Séries Hoje no Brasil", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp) }
            items(NetflixMockData.sampleTop10) { show ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                        Text(show.title, fontWeight = FontWeight.Bold, color = Color.White, fontSize = 14.sp)
                        Text("${show.matchPercentage} • ${show.maturity} • ${show.genre}", color = Color(0xFF46D369), fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcNetflixTrailerTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Player & Previews de Séries", modifier = modifier)

@Composable
fun WgcNetflixMyListTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Minha Lista & Títulos Salvos", modifier = modifier)

@Composable
fun WgcNetflixNewsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Novidades & Em Breve", modifier = modifier)

@Composable
fun WgcNetflixProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Quem está assistindo? • Perfis", modifier = modifier)
