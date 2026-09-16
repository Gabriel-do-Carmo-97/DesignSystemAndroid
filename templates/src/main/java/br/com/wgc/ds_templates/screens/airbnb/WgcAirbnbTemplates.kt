package br.com.wgc.ds_templates.screens.airbnb

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
fun WgcAirbnbExploreTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.airbnbCoral)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Airbnb • Explore Acomodações Únicas", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(AirbnbMockData.sampleStays) { stay ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                        Text(stay.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("${stay.location} • ⭐ ${stay.rating}", color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(stay.pricePerNight)} por noite", fontWeight = FontWeight.ExtraBold, color = Color.Black)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcAirbnbDetailsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Detalhes & Comodidades da Estadia", modifier = modifier)

@Composable
fun WgcAirbnbMessagesTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Mensagens com Anfitriões", modifier = modifier)

@Composable
fun WgcAirbnbTripsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Minhas Viagens & Check-in", modifier = modifier)

@Composable
fun WgcAirbnbProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Airbnb • Modo Anfitrião", modifier = modifier)
