package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcBeautyFactory
import br.com.wgc.ds_templates.factories.WgcBeautyScreen
import br.com.wgc.ds_templates.factories.WgcFashionFactory
import br.com.wgc.ds_templates.factories.WgcFashionScreen
import br.com.wgc.ds_templates.factories.WgcFastFoodFactory
import br.com.wgc.ds_templates.factories.WgcFastFoodScreen
import br.com.wgc.ds_templates.factories.WgcGamesFactory
import br.com.wgc.ds_templates.factories.WgcGamesScreen
import br.com.wgc.ds_templates.factories.WgcGovFactory
import br.com.wgc.ds_templates.factories.WgcGovScreen
import br.com.wgc.ds_templates.factories.WgcHomeDecorFactory
import br.com.wgc.ds_templates.factories.WgcHomeDecorScreen
import br.com.wgc.ds_templates.factories.WgcLogisticsFactory
import br.com.wgc.ds_templates.factories.WgcLogisticsScreen
import br.com.wgc.ds_templates.factories.WgcNewsFactory
import br.com.wgc.ds_templates.factories.WgcNewsScreen
import br.com.wgc.ds_templates.factories.WgcPetShopFactory
import br.com.wgc.ds_templates.factories.WgcPetShopScreen
import br.com.wgc.ds_templates.factories.WgcProductivityFactory
import br.com.wgc.ds_templates.factories.WgcProductivityScreen

class WgcServicesScreenshotsTest {

    @Preview(name = "Games - Store Screen", showBackground = true)
    @Composable
    fun gamesScreenPreview() {
        WgcGamesFactory(screen = WgcGamesScreen.STORE)
    }

    @Preview(name = "Produtividade - Docs Screen", showBackground = true)
    @Composable
    fun productivityScreenPreview() {
        WgcProductivityFactory(screen = WgcProductivityScreen.DOCS)
    }

    @Preview(name = "Fast Food - Burger Screen", showBackground = true)
    @Composable
    fun fastFoodScreenPreview() {
        WgcFastFoodFactory(screen = WgcFastFoodScreen.BURGER)
    }

    @Preview(name = "Logística - Express Screen", showBackground = true)
    @Composable
    fun logisticsScreenPreview() {
        WgcLogisticsFactory(screen = WgcLogisticsScreen.EXPRESS)
    }

    @Preview(name = "Moda - Department Screen", showBackground = true)
    @Composable
    fun fashionScreenPreview() {
        WgcFashionFactory(screen = WgcFashionScreen.DEPARTMENT)
    }

    @Preview(name = "Beleza - Fragrance Screen", showBackground = true)
    @Composable
    fun beautyScreenPreview() {
        WgcBeautyFactory(screen = WgcBeautyScreen.FRAGRANCE)
    }

    @Preview(name = "Pet Shop - Care Screen", showBackground = true)
    @Composable
    fun petShopScreenPreview() {
        WgcPetShopFactory(screen = WgcPetShopScreen.CARE)
    }

    @Preview(name = "Casa & Decoração - Home Improvement Screen", showBackground = true)
    @Composable
    fun homeDecorScreenPreview() {
        WgcHomeDecorFactory(screen = WgcHomeDecorScreen.LEROY_MERLIN)
    }

    @Preview(name = "Notícias - G1 Screen", showBackground = true)
    @Composable
    fun newsScreenPreview() {
        WgcNewsFactory(screen = WgcNewsScreen.G1)
    }

    @Preview(name = "Governo - Gov.br Screen", showBackground = true)
    @Composable
    fun govScreenPreview() {
        WgcGovFactory(screen = WgcGovScreen.GOV_BR)
    }
}
