package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.flamefastfood.*

enum class WgcFlameFastFoodScreen {
    MENU,
    CLUBE,
    COUPONS,
    BAG,
    PROFILE
}

@Composable
fun WgcFlameFastFoodFactory(
    screen: WgcFlameFastFoodScreen = WgcFlameFastFoodScreen.MENU,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcFlameFastFoodScreen.MENU -> WgcBurgerKingMenuTemplate(modifier = modifier)
        WgcFlameFastFoodScreen.CLUBE -> WgcBurgerKingClubeTemplate(modifier = modifier)
        WgcFlameFastFoodScreen.COUPONS -> WgcBurgerKingCouponsTemplate(modifier = modifier)
        WgcFlameFastFoodScreen.BAG -> WgcBurgerKingBagTemplate(modifier = modifier)
        WgcFlameFastFoodScreen.PROFILE -> WgcBurgerKingProfileTemplate(modifier = modifier)
    }
}
