package br.com.wgc.ds_templates.screens.clickbus

import br.com.wgc.ds_templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

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
fun WgcClickBusSearchTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.clickbusGreen)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Passagens Rodoviárias • ClickBus", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
                Text("São Paulo (Tietê) ➔ Rio de Janeiro (Novo Rio)", color = Color.White.copy(alpha = 0.9f))
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(ClickBusMockData.sampleTrips) { trip ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Row(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Text(trip.company, fontWeight = FontWeight.Bold)
                            Text("${trip.departureTime} ➔ ${trip.arrivalTime}", color = Color.DarkGray)
                            Text(trip.seatType, color = Color(WgcCoreDsColors.clickbusGreen), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        }
                        Text("R$ ${"%,.2f".format(trip.price)}", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcClickBusSeatsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Seleção de Poltronas", modifier = modifier)

@Composable
fun WgcClickBusTicketsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Meus Bilhetes de Embarque", modifier = modifier)

@Composable
fun WgcClickBusCheckoutTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Checkout & Pagamento Seguro", modifier = modifier)

@Composable
fun WgcClickBusProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil de Passageiro", modifier = modifier)
