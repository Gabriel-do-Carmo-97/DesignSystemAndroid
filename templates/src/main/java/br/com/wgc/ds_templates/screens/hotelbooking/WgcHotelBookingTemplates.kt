package br.com.wgc.ds_templates.screens.hotelbooking

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
fun WgcHotelBookingSearchTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.hotelBookingBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Reserva de Hotel • Genius Nível 2", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(HotelBookingMockData.sampleHotels) { hotel ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                        Text(hotel.name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("${hotel.city} • Nota ${hotel.score} (${hotel.reviewsCount} avaliações)", color = Color.Gray, fontSize = 14.sp)
                        Text(hotel.geniusDiscount, color = Color(WgcCoreDsColors.hotelBookingYellow), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(hotel.price)}", fontWeight = FontWeight.ExtraBold, color = Color.Black)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcHotelBookingGeniusTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Programa Genius • Benefícios Vitalícios", modifier = modifier)

@Composable
fun WgcHotelBookingWishlistTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Lista de Desejos & Hotéis Salvos", modifier = modifier)

@Composable
fun WgcHotelBookingReservationsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Confirmações de Reserva & Voucher", modifier = modifier)

@Composable
fun WgcHotelBookingProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Reserva de Hotel", modifier = modifier)
