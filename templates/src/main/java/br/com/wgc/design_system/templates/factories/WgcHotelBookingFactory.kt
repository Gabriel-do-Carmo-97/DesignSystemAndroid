package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.hotelbooking.*

enum class WgcHotelBookingScreen {
    SEARCH,
    GENIUS,
    WISHLIST,
    RESERVATIONS,
    PROFILE
}

@Composable
fun WgcHotelBookingFactory(
    screen: WgcHotelBookingScreen = WgcHotelBookingScreen.SEARCH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcHotelBookingScreen.SEARCH -> WgcHotelBookingSearchTemplate(modifier = modifier)
        WgcHotelBookingScreen.GENIUS -> WgcHotelBookingGeniusTemplate(modifier = modifier)
        WgcHotelBookingScreen.WISHLIST -> WgcHotelBookingWishlistTemplate(modifier = modifier)
        WgcHotelBookingScreen.RESERVATIONS -> WgcHotelBookingReservationsTemplate(modifier = modifier)
        WgcHotelBookingScreen.PROFILE -> WgcHotelBookingProfileTemplate(modifier = modifier)
    }
}
