package br.com.wgc.design_system.templates.screens.homeimprovement

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
fun WgcLeroyMerlinHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.homeImprovementGreen)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Casa, Construção & Reforma", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(LeroyMerlinMockData.sampleItems) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.title, fontWeight = FontWeight.Bold)
                        Text(item.department, color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.homeImprovementGreen))
                    }
                }
            }
        }
    }
}

@Composable
fun WgcLeroyMerlinClubeTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Clube Casa & Você", modifier = modifier)

@Composable
fun WgcLeroyMerlinCalculatorTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Calculadora de Materiais & Tinta", modifier = modifier)

@Composable
fun WgcLeroyMerlinCartTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Carrinho & Agendamento de Entrega de Obra", modifier = modifier)

@Composable
fun WgcLeroyMerlinProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Minha Conta & Projetos de Reforma", modifier = modifier)
