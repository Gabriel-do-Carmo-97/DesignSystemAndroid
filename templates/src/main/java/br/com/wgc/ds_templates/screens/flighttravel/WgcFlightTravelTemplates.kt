package br.com.wgc.ds_templates.screens.flighttravel

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
fun WgcDecolarPackagesTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.flightTravelBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Decolar • Pacotes & Voos", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(FlightTravelMockData.samplePackages) { pkg ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                        Text(pkg.destination, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("${pkg.nights} noites • Voo + Hospedagem", color = Color.Gray)
                        Text("R$ ${"%,.2f".format(pkg.price)} por pessoa", fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.flightTravelPurple))
                    }
                }
            }
        }
    }
}

@Composable
fun WgcDecolarHotelsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Hotéis & Pousadas Exclusivas", modifier = modifier)

@Composable
fun WgcDecolarPassportTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Passaporte Decolar • Meus Pontos", modifier = modifier)

@Composable
fun WgcDecolarTripsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Minhas Viagens Agendadas", modifier = modifier)

@Composable
fun WgcDecolarProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil do Viajante", modifier = modifier)
