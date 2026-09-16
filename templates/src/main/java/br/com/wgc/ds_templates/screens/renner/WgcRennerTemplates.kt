package br.com.wgc.ds_templates.screens.renner

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
fun WgcRennerHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.rennerRed)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Lojas Renner • Coleção Primavera-Verão", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(RennerMockData.sampleProducts) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.title, fontWeight = FontWeight.Bold)
                        Text(item.category, color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.rennerRed))
                    }
                }
            }
        }
    }
}

@Composable
fun WgcRennerCollectionsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Coleções & Tendências de Moda", modifier = modifier)

@Composable
fun WgcRennerCardTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Cartão Renner & Benefícios Meu Estilo", modifier = modifier)

@Composable
fun WgcRennerBagTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Sacola de Compras Renner", modifier = modifier)

@Composable
fun WgcRennerProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil do Cliente & Meus Pedidos", modifier = modifier)
