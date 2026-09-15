package br.com.wgc.ds_templates.screens.indrive

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcInDriveNegotiateTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.indriveGreen)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("inDrive • Você decide o preço", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color.White)
                Text("Sua oferta: R$ 20,00", color = Color.White.copy(alpha = 0.9f))
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            item { Text("Motoristas oferecendo lances:", fontWeight = FontWeight.Bold, fontSize = 14.sp) }
            items(InDriveMockData.sampleOffers) { offer ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Row(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Text(offer.driverName, fontWeight = FontWeight.Bold)
                            Text("${offer.carModel} • ⭐ ${offer.rating}", color = Color.Gray, fontSize = 14.sp)
                            Text(offer.distance, color = Color.DarkGray, fontSize = 14.sp)
                        }
                        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(WgcCoreDsColors.indriveGreen)), shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)) {
                            Text("Aceitar R$ ${"%,.2f".format(offer.proposedPrice)}", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WgcInDriveIntercityTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
            Text("Viagens Interurbanas", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text("Viaje de uma cidade para outra pelo preço que você negociar.", color = Color.Gray)
        }
    }
}

@Composable
fun WgcInDriveBidsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Histórico de Lances & Negociações", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcInDriveRatingsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Minhas Avaliações e Confiança", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

@Composable
fun WgcInDriveProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Perfil do Usuário inDrive", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}
