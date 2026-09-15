package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.burgerking.*

enum class WgcBurgerKingScreen {
    MENU,
    CLUBE,
    COUPONS,
    BAG,
    PROFILE
}

@Composable
fun WgcBurgerKingFactory(
    screen: WgcBurgerKingScreen = WgcBurgerKingScreen.MENU,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcBurgerKingScreen.MENU -> WgcBurgerKingMenuTemplate(modifier = modifier)
        WgcBurgerKingScreen.CLUBE -> WgcBurgerKingClubeTemplate(modifier = modifier)
        WgcBurgerKingScreen.COUPONS -> WgcBurgerKingCouponsTemplate(modifier = modifier)
        WgcBurgerKingScreen.BAG -> WgcBurgerKingBagTemplate(modifier = modifier)
        WgcBurgerKingScreen.PROFILE -> WgcBurgerKingProfileTemplate(modifier = modifier)
    }
}
