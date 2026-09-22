package br.com.wgc.design_system.templates.screens.languagelearning

import br.com.wgc.design_system.templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

@Composable
fun WgcDuolingoPathTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.languageLearningGreen)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Idiomas • Inglês", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color.White)
                Text("🔥 42 dias de ofensiva • 💎 1.250 gemas", color = Color.White.copy(alpha = 0.9f))
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(LanguageLearningMockData.sampleLessons) { lesson ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Row(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Text(lesson.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text("Nível ${lesson.level} • +${lesson.xp} XP", color = Color.Gray, fontSize = 14.sp)
                        }
                        Icon(
                            if (lesson.isCompleted) Icons.Default.CheckCircle else Icons.Default.Lock,
                            contentDescription = null,
                            tint = if (lesson.isCompleted) Color(WgcCoreDsColors.languageLearningGreen) else Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun WgcDuolingoPronounceTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Desafio de Pronúncia & Escuta", modifier = modifier)

@Composable
fun WgcDuolingoLeaguesTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Divisão Diamante • Ligas Semanais", modifier = modifier)

@Composable
fun WgcDuolingoShopTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Loja de Gemas & Bloqueio de Ofensiva", modifier = modifier)

@Composable
fun WgcDuolingoProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil do Estudante & Conquistas", modifier = modifier)
