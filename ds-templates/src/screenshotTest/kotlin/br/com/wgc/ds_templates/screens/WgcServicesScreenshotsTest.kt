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

    @Preview(name = "Games - Steam Screen", showBackground = true)
    @Composable
    fun gamesScreenPreview() {
        WgcGamesFactory(screen = WgcGamesScreen.STEAM)
    }

    @Preview(name = "Produtividade - Notion Screen", showBackground = true)
    @Composable
    fun productivityScreenPreview() {
        WgcProductivityFactory(screen = WgcProductivityScreen.NOTION)
    }

    @Preview(name = "Fast Food - McDonald's Screen", showBackground = true)
    @Composable
    fun fastFoodScreenPreview() {
        WgcFastFoodFactory(screen = WgcFastFoodScreen.MCDONALDS)
    }

    @Preview(name = "Logística - Loggi Screen", showBackground = true)
    @Composable
    fun logisticsScreenPreview() {
        WgcLogisticsFactory(screen = WgcLogisticsScreen.LOGGI)
    }

    @Preview(name = "Moda - Renner Screen", showBackground = true)
    @Composable
    fun fashionScreenPreview() {
        WgcFashionFactory(screen = WgcFashionScreen.RENNER)
    }

    @Preview(name = "Beleza - O Boticário Screen", showBackground = true)
    @Composable
    fun beautyScreenPreview() {
        WgcBeautyFactory(screen = WgcBeautyScreen.BOTICARIO)
    }

    @Preview(name = "Pet Shop - Petz Screen", showBackground = true)
    @Composable
    fun petShopScreenPreview() {
        WgcPetShopFactory(screen = WgcPetShopScreen.PETZ)
    }

    @Preview(name = "Casa & Decoração - Leroy Merlin Screen", showBackground = true)
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
