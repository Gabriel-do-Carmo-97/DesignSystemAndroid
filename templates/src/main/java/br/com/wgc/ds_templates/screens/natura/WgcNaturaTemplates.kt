package br.com.wgc.ds_templates.screens.natura

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
fun WgcNaturaHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.naturaOrange)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Natura • Bem Estar Bem", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(NaturaMockData.sampleProducts) { prod ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(prod.name, fontWeight = FontWeight.Bold)
                        Text("${prod.line} ${if (prod.refillAvailable) "• ♻️ Refil Disponível" else ""}", color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(prod.price)}", fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcNaturaConsultantTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Espaço da Consultora Natura", modifier = modifier)

@Composable
fun WgcNaturaRefillsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Refis & Sustentabilidade Amazônia", modifier = modifier)

@Composable
fun WgcNaturaBagTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Sacola de Compras Natura", modifier = modifier)

@Composable
fun WgcNaturaProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Meu Perfil Natura & Pontos", modifier = modifier)
