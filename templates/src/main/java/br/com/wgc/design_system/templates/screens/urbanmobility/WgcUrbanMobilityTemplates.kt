package br.com.wgc.design_system.templates.screens.urbanmobility

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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcRideShareCard

@Composable
fun WgcUrbanMobilityRideRequestTemplate(
    onConfirmRide: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedRideId by remember { mutableStateOf("1") }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.urbanMobilityYellow)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Para onde vamos?", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color.Black)
                Text("Av. Brigadeiro Faria Lima, 3477", fontSize = 14.sp, color = Color.Black.copy(alpha = 0.8f))
            }
        },
        bottomBar = {
            Surface(modifier = Modifier.fillMaxWidth(), shadowElevation = WgcCoreDsSize.s8.dp) {
                Button(
                    onClick = onConfirmRide,
                    modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(WgcCoreDsColors.urbanMobilityYellow)),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                ) {
                    Text("Confirmar Corrida", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            items(UrbanMobilityMockData.sampleRides) { ride ->
                WgcRideShareCard(
                    name = ride.name,
                    eta = ride.eta,
                    price = ride.price,
                    discount = ride.discount,
                    isSelected = ride.id == selectedRideId,
                    onClick = { selectedRideId = ride.id }
                )
            }
        }
    }
}

@Composable
fun WgcUrbanMobilityPayTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), topBar = {
        Surface(color = Color(WgcCoreDsColors.urbanMobilityYellow)) {
            Row(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Carteira de Mobilidade • Digital", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
            }
        }
    }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                    Text("Saldo com rendimento diário", color = Color.Gray, fontSize = 14.sp)
                    Text("R$ 1.450,20", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color.Black)
                    Text("+ R$ 0,72 rendeu hoje", color = Color(WgcCoreDsColors.premiumGrocerySuccessGreen), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
fun WgcUrbanMobilityHistoryTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            item { Text("Minhas Corridas Recentes", fontWeight = FontWeight.Bold, fontSize = 14.sp) }
            items(UrbanMobilityMockData.sampleHistory) { trip ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(trip.destination, fontWeight = FontWeight.Bold)
                            Text("R$ ${"%,.2f".format(trip.price)}", fontWeight = FontWeight.Bold)
                        }
                        Text("${trip.date} • ${trip.driver}", color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcUrbanMobilityCouponsTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
            Text("Meus Cupons & Descontos", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text("15% OFF em até 3 corridas de Mobilidade", fontWeight = FontWeight.Bold, color = Color(WgcCoreDsColors.urbanMobilityYellow))
                    Text("Válido até domingo para pagamentos na carteira", fontSize = 14.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun WgcUrbanMobilityProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
            Text("Meu Perfil • Passageiro", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                    Text("Passageiro Frequente", fontWeight = FontWeight.Bold)
                    Text("Nota como passageiro: ⭐ 4.96", color = Color.DarkGray)
                    Text("Membro desde 2021", color = Color.Gray, fontSize = 14.sp)
                }
            }
        }
    }
}
