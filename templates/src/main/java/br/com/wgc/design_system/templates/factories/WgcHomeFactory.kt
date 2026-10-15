package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.home.WgcHomeScreenFactory
import br.com.wgc.design_system.factories.home.WgcHomeVariant
import br.com.wgc.design_system.templates.brand.WgcBrand
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas Home (WgcHomeFactory).
 */
@Deprecated(
    message = "Utilize WgcHomeScreenFactory diretamente",
    replaceWith = ReplaceWith("WgcHomeScreenFactory(modifier, variant)")
)
@Composable
fun WgcHomeFactory(
    modifier: Modifier = Modifier,
    brand: WgcBrand = WgcBrand.FoodDelivery,
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomNavSlot: (@Composable () -> Unit)? = null,
    bannerSlot: (@Composable () -> Unit)? = null,
    contentSlot: (@Composable () -> Unit)? = null
) {
    val homeVariant = when (brand) {
        WgcBrand.FintechNeobank, WgcBrand.FintechSuperApp, WgcBrand.FintechCarbon -> WgcHomeVariant.FINTECH
        WgcBrand.GymFitness, WgcBrand.GuidedTraining -> WgcHomeVariant.FITNESS
        WgcBrand.VideoStream, WgcBrand.AudioStream -> WgcHomeVariant.STREAMING
        else -> WgcHomeVariant.ECOMMERCE
    }

    WgcHomeScreenFactory(
        modifier = modifier,
        variant = homeVariant,
        topBarSlot = topBarSlot,
        bottomNavSlot = bottomNavSlot,
        bannersSlot = bannerSlot,
        contentSlot = contentSlot
    )
}

@Preview(name = "WgcHomeFactory Preview", showBackground = true)
@Composable
private fun WgcHomeFactoryPreview() {
    WgcTheme {
        WgcHomeFactory()
    }
}
