package br.com.wgc.design_system.templates.screens.techeducation

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
fun WgcAluraHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.techEducationBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Tech Education • Cursos de Tecnologia", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(TechEducationMockData.sampleCourses) { course ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                        Text(course.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("${course.track} • ${course.durationHours}h • Progresso: ${course.progressPercent}%", color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcAluraPlayerTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Player de Videoaula & Transcrição", modifier = modifier)

@Composable
fun WgcAluraCareerTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Minha Carreira Tech & Formações", modifier = modifier)

@Composable
fun WgcAluraForumTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Fórum & Dúvidas dos Alunos", modifier = modifier)

@Composable
fun WgcAluraProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil & Certificados", modifier = modifier)
