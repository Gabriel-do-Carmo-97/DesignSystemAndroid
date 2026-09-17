package br.com.wgc.ds_templates.screens.coursemarketplace

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
fun WgcUdemyExploreTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.courseMarketplacePurple)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Marketplace de Cursos • Especialização Online", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(CourseMarketplaceMockData.sampleCourses) { course ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                        Text(course.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("${course.instructor} • ⭐ ${course.rating}", color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(course.price)}", fontWeight = FontWeight.ExtraBold, color = Color.Black)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcUdemyCourseDetailTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Conteúdo do Curso & Módulos", modifier = modifier)

@Composable
fun WgcUdemyMyCoursesTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Meus Cursos Matriculados", modifier = modifier)

@Composable
fun WgcUdemyReviewsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Avaliações e Perguntas ao Instrutor", modifier = modifier)

@Composable
fun WgcUdemyProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil do Estudante & Métodos de Pagamento", modifier = modifier)
