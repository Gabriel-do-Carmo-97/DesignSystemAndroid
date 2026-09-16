package br.com.wgc.ds_templates.screens.cobasi

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
fun WgcCobasiHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.cobasiBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Cobasi • O Shopping do seu Animal", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(CobasiMockData.sampleItems) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.title, fontWeight = FontWeight.Bold)
                        Text(item.category, color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcCobasiAmigoTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Amigo Cobasi • Fidelidade & Descontos", modifier = modifier)

@Composable
fun WgcCobasiProgramadaTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Compra Programada Cobasi", modifier = modifier)

@Composable
fun WgcCobasiCartTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Carrinho de Compras Cobasi", modifier = modifier)

@Composable
fun WgcCobasiProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Carteira de Vacinação & Perfil do Pet", modifier = modifier)
