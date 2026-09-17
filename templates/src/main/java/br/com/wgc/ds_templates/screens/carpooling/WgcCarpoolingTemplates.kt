package br.com.wgc.ds_templates.screens.carpooling

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
fun WgcCarpoolingSearchTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.carpoolingBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Caronas Compartilhadas", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(CarpoolingMockData.sampleRides) { ride ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text("${ride.origin} ➔ ${ride.destination}", fontWeight = FontWeight.Bold)
                        Text("Condutor: ${ride.driver} • Partida: ${ride.departureTime}", color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(ride.price)}", fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.carpoolingBlue))
                    }
                }
            }
        }
    }
}

@Composable
fun WgcCarpoolingOfferTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Oferecer Carona", modifier = modifier)

@Composable
fun WgcCarpoolingBookingsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Minhas Reservas & Chat com o Motorista", modifier = modifier)

@Composable
fun WgcCarpoolingAlertsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Alertas de Trajetos & Novas Vagas", modifier = modifier)

@Composable
fun WgcCarpoolingProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil do Membro & Avaliações", modifier = modifier)
