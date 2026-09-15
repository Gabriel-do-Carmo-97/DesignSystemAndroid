package br.com.wgc.ds_templates.screens.duolingo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun WgcDuolingoPathTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.duolingoGreen)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Duolingo • Inglês", fontWeight = FontWeight.ExtraBold, fontSize = WgcCoreDsFontSize.h3.sp, color = Color.White)
                Text("🔥 42 dias de ofensiva • 💎 1.250 gemas", color = Color.White.copy(alpha = 0.9f))
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(DuolingoMockData.sampleLessons) { lesson ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Row(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Text(lesson.title, fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.body1.sp)
                            Text("Nível ${lesson.level} • +${lesson.xp} XP", color = Color.Gray, fontSize = WgcCoreDsFontSize.caption.sp)
                        }
                        Icon(
                            if (lesson.isCompleted) Icons.Default.CheckCircle else Icons.Default.Lock,
                            contentDescription = null,
                            tint = if (lesson.isCompleted) Color(WgcCoreDsColors.duolingoGreen) else Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun WgcDuolingoPronounceTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Desafio de Pronúncia & Escuta", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcDuolingoLeaguesTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Divisão Diamante • Ligas Semanais", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcDuolingoShopTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Loja de Gemas & Bloqueio de Ofensiva", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}

@Composable
fun WgcDuolingoProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Perfil do Estudante & Conquistas", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
        }
    }
}
