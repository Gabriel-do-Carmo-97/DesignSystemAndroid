package br.com.wgc.ds_templates.screens.sephora

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
fun WgcSephoraHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.sephoraBlack)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("SEPHORA • Exclusividades & Makes", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(SephoraMockData.sampleProducts) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.brand, fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 14.sp.sp)
                        Text(item.name, fontWeight = FontWeight.Bold)
                        Text("+${item.pointsReward} Beauty Club pts", color = Color(0xFFE91E63), fontWeight = FontWeight.SemiBold, fontSize = 14.sp.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcSephoraClubTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Beauty Club • Resgate de Miniaturas de Luxo", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcSephoraTutorialsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Tutoriais de Maquiagem & Reviews Reais", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcSephoraBagTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Sacola Sephora • Escolha até 3 Amostras Grátis", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcSephoraProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Perfil Beauty Pass & Histórico", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}
