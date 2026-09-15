package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.booking.*

enum class WgcBookingScreen {
    SEARCH,
    GENIUS,
    WISHLIST,
    RESERVATIONS,
    PROFILE
}

@Composable
fun WgcBookingFactory(
    screen: WgcBookingScreen = WgcBookingScreen.SEARCH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcBookingScreen.SEARCH -> WgcBookingSearchTemplate(modifier = modifier)
        WgcBookingScreen.GENIUS -> WgcBookingGeniusTemplate(modifier = modifier)
        WgcBookingScreen.WISHLIST -> WgcBookingWishlistTemplate(modifier = modifier)
        WgcBookingScreen.RESERVATIONS -> WgcBookingReservationsTemplate(modifier = modifier)
        WgcBookingScreen.PROFILE -> WgcBookingProfileTemplate(modifier = modifier)
    }
}
