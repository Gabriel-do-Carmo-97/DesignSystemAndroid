package br.com.wgc.ds_templates.screens.petz

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
fun WgcPetzHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.petzYellow)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Petz • Seu Pet Shop Completo", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(PetzMockData.sampleProducts) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.title, fontWeight = FontWeight.Bold)
                        Text(item.category, color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.SemiBold)
                        Text("Com Assinatura Petz: R$ ${"%,.2f".format(item.subscriptionPrice)}", color = Color(WgcCoreDsColors.petzBlue), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcPetzSubscriptionTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Assinatura Petz • 10% OFF em Todas as Entregas", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcPetzClinicTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Centro Veterinário Seres & Banho/Tosa", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcPetzCartTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Carrinho de Compras Petz", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcPetzProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Perfil dos Meus Pets (Bob & Luna)", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}
