package br.com.wgc.ds_templates.screens.exame

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
fun WgcExameHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.exameBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("EXAME • Negócios, Economia & ESG", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(ExameMockData.sampleArticles) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.category, color = Color(WgcCoreDsColors.exameBlue), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text(item.title, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcExameInvestTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Exame Invest • Cotações, FIIs & Análises", modifier = modifier)

@Composable
fun WgcExameEsgTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "ESG & Sustentabilidade Corporativa", modifier = modifier)

@Composable
fun WgcExameMagazineTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Edição Digital da Revista EXAME", modifier = modifier)

@Composable
fun WgcExameProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil de Assinante Exame Pro", modifier = modifier)
