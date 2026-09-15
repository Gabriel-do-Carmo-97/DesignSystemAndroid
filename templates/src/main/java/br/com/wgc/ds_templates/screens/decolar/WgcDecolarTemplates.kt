package br.com.wgc.ds_templates.screens.decolar

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
fun WgcDecolarPackagesTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.decolarBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Decolar • Pacotes & Voos", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(DecolarMockData.samplePackages) { pkg ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                        Text(pkg.destination, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("${pkg.nights} noites • Voo + Hospedagem", color = Color.Gray)
                        Text("R$ ${"%,.2f".format(pkg.price)} por pessoa", fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.decolarPurple))
                    }
                }
            }
        }
    }
}

@Composable
fun WgcDecolarHotelsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Hotéis & Pousadas Exclusivas", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcDecolarPassportTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Passaporte Decolar • Meus Pontos", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcDecolarTripsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Minhas Viagens Agendadas", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcDecolarProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Perfil do Viajante", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}
