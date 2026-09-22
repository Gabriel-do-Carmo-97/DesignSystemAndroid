package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.burgerfastfood.*

enum class WgcBurgerFastFoodScreen {
    MENU,
    CUPONS,
    LOYALTY,
    CART,
    PROFILE
}

@Composable
fun WgcBurgerFastFoodFactory(
    screen: WgcBurgerFastFoodScreen = WgcBurgerFastFoodScreen.MENU,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcBurgerFastFoodScreen.MENU -> WgcBurgerFastFoodMenuTemplate(modifier = modifier)
        WgcBurgerFastFoodScreen.CUPONS -> WgcBurgerFastFoodCuponsTemplate(modifier = modifier)
        WgcBurgerFastFoodScreen.LOYALTY -> WgcBurgerFastFoodLoyaltyTemplate(modifier = modifier)
        WgcBurgerFastFoodScreen.CART -> WgcBurgerFastFoodCartTemplate(modifier = modifier)
        WgcBurgerFastFoodScreen.PROFILE -> WgcBurgerFastFoodProfileTemplate(modifier = modifier)
    }
}
