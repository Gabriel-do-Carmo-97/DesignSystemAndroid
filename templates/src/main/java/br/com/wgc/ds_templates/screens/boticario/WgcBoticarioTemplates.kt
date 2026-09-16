package br.com.wgc.ds_templates.screens.boticario

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
fun WgcBoticarioHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.boticarioGreen)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("O Boticário • Perfumaria & Cuidados", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(BoticarioMockData.sampleProducts) { prod ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(prod.name, fontWeight = FontWeight.Bold)
                        Text(prod.line, color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(prod.price)}", fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.boticarioGreen))
                    }
                }
            }
        }
    }
}

@Composable
fun WgcBoticarioClubeTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Clube Viva O Boticário • Resgate de Prêmios", modifier = modifier)

@Composable
fun WgcBoticarioDiagTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Diagnóstico Facial & Dicas de Skincare", modifier = modifier)

@Composable
fun WgcBoticarioBagTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Sacola de Beleza • Amostras Grátis", modifier = modifier)

@Composable
fun WgcBoticarioProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Meu Perfil Viva O Boticário", modifier = modifier)
