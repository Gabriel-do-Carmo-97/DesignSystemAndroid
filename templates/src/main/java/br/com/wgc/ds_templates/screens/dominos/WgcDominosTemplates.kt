package br.com.wgc.ds_templates.screens.dominos

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
fun WgcDominosBuildTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.dominosBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Domino's Pizza • Monte sua Pizza", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(DominosMockData.samplePizzas) { pizza ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(pizza.name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text(pizza.ingredients, color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(pizza.price)}", fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.dominosRed))
                    }
                }
            }
        }
    }
}

@Composable
fun WgcDominosTrackerTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Pizza Tracker • Acompanhe o Forno e a Entrega", modifier = modifier)

@Composable
fun WgcDominosOffersTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Ofertas 2 por 1 • Terça em Dobro", modifier = modifier)

@Composable
fun WgcDominosCartTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Carrinho de Pedidos Domino's", modifier = modifier)

@Composable
fun WgcDominosProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Domino's & Endereços de Entrega", modifier = modifier)
