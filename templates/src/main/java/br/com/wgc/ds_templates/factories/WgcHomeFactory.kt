package br.com.wgc.ds_templates.factories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcCardFactory
import br.com.wgc.design_system.components.cards.WgcCardType
import br.com.wgc.design_system.components.fields.WgcFieldFactory
import br.com.wgc.design_system.components.fields.WgcFieldType
import br.com.wgc.design_system.components.navigation.WgcAddressHeaderBar
import br.com.wgc.design_system.components.navigation.WgcMenuFactory
import br.com.wgc.design_system.components.navigation.WgcMenuType
import br.com.wgc.ds_templates.brand.WgcBrand
import br.com.wgc.ds_templates.screens.home.ecommerce.EcommerceHomeScreenTemplate
import br.com.wgc.ds_templates.screens.home.ecommerce.FakeEcommerceHomeViewModel
import br.com.wgc.ds_templates.screens.ifood.FakeIFoodHomeViewModel
import br.com.wgc.ds_templates.screens.ifood.IFoodHomeScreenTemplate
import br.com.wgc.ds_templates.screens.mercadolivre.FakeMercadoLivreHomeViewModel
import br.com.wgc.ds_templates.screens.mercadolivre.MercadoLivreHomeScreenTemplate
import br.com.wgc.ds_templates.screens.nineninefood.FakeNineNineFoodHomeViewModel
import br.com.wgc.ds_templates.screens.nineninefood.NineNineFoodHomeScreenTemplate

/**
 * Fábrica Universal de Telas Home (WgcHomeFactory).
 * Permite instanciar telas Home completas simplesmente escolhendo o [brand],
 * além de permitir substituição cirúrgica de [topBarSlot], [bottomNavSlot],
 * [floatingActionSlot], [bannerSlot] e [contentSlot].
 */
@Composable
fun WgcHomeFactory(
    modifier: Modifier = Modifier,
    brand: WgcBrand = WgcBrand.IFood,
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomNavSlot: (@Composable () -> Unit)? = null,
    floatingActionSlot: (@Composable () -> Unit)? = null,
    bannerSlot: (@Composable () -> Unit)? = null,
    contentSlot: (@Composable () -> Unit)? = null
) {
    val hasCustomSlots = topBarSlot != null || bottomNavSlot != null ||
        floatingActionSlot != null || bannerSlot != null || contentSlot != null

    if (!hasCustomSlots) {
        when (brand) {
            WgcBrand.IFood -> IFoodHomeScreenTemplate(FakeIFoodHomeViewModel())
            WgcBrand.MercadoLivre -> MercadoLivreHomeScreenTemplate(FakeMercadoLivreHomeViewModel())
            WgcBrand.NineNineFood -> NineNineFoodHomeScreenTemplate(FakeNineNineFoodHomeViewModel())
            WgcBrand.Uber,
            WgcBrand.Shopee,
            WgcBrand.AliExpress,
            WgcBrand.Klok,
            WgcBrand.CleanWave,
            WgcBrand.SplitCard -> EcommerceHomeScreenTemplate(FakeEcommerceHomeViewModel())
            WgcBrand.Stylish -> br.com.wgc.ds_templates.screens.stylish.home.WgcStylishHomeScreenTemplate()
            WgcBrand.Shoppe -> br.com.wgc.ds_templates.screens.shoppe.home.WgcShoppeHomeScreenTemplate()
            WgcBrand.Kutuku -> br.com.wgc.ds_templates.screens.kutuku.home.WgcKutukuHomeScreen()
            WgcBrand.Clothee -> br.com.wgc.ds_templates.screens.clothee.home.WgcClotheeHomeTemplate()
            WgcBrand.Laza -> br.com.wgc.ds_templates.screens.laza.home.WgcLazaHomeTemplate()
            WgcBrand.Tassel -> br.com.wgc.ds_templates.screens.tassel.market.WgcTasselMarketTemplate()
            WgcBrand.Shopper -> br.com.wgc.ds_templates.screens.shopper.home.WgcShopperHomeTemplate()
            WgcBrand.Nexkart -> br.com.wgc.ds_templates.screens.nexkart.home.WgcNexkartHomeTemplate()
            WgcBrand.ShopEase -> br.com.wgc.ds_templates.screens.shopease.home.WgcShopEaseHomeTemplate()
            WgcBrand.Organizze -> br.com.wgc.ds_templates.screens.organizze.dashboard.WgcOrganizzeDashboardTemplate()
            WgcBrand.QuintoAndar -> br.com.wgc.ds_templates.screens.quintoandar.home.WgcQuintoAndarHomeTemplate()
            WgcBrand.VivaReal -> br.com.wgc.ds_templates.screens.vivareal.home.WgcVivaRealHomeTemplate()
            WgcBrand.Zap -> br.com.wgc.ds_templates.screens.zap.home.WgcZapHomeTemplate()
            WgcBrand.SmartFit -> WgcSmartFitFactory.Screen(WgcSmartFitScreen.Home)
            WgcBrand.Wellhub -> WgcWellhubFactory.Screen(WgcWellhubScreen.Home)
            WgcBrand.NikeTrainingClub -> WgcNtcFactory(screen = WgcNtcScreen.HOME)
            WgcBrand.ClubeExtra -> WgcExtraFactory(screen = WgcExtraScreen.HOME)
            WgcBrand.PaoDeAcucar -> WgcPdaFactory(screen = WgcPdaScreen.HOME)
            else -> EcommerceHomeScreenTemplate(FakeEcommerceHomeViewModel())
        }
        return
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (topBarSlot != null) {
                topBarSlot()
            } else {
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 2.dp
                ) {
                    WgcAddressHeaderBar(
                        address = "Endereço Principal - ${brand.brandName}",
                        searchQuery = "",
                        onAddressClick = {},
                        onSearchQueryChange = {}
                    )
                }
            }
        },
        bottomBar = {
            if (bottomNavSlot != null) {
                bottomNavSlot()
            } else {
                WgcMenuFactory(type = WgcMenuType.ClassicBottomBar)
            }
        },
        floatingActionButton = {
            floatingActionSlot?.invoke()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF7F7F7))
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            bannerSlot?.invoke()

            if (contentSlot != null) {
                contentSlot()
            } else {
                // Conteúdo padrão sensato com cards e filtros do ecossistema
                WgcFieldFactory(
                    type = WgcFieldType.Search,
                    placeholderText = "Buscar no ${brand.brandName}..."
                )

                WgcCardFactory(
                    type = WgcCardType.ProductDetail,
                    title = "Destaque do Dia no ${brand.brandName}",
                    subtitle = "Oferta especial com entrega expressa",
                    price = "R$ 49,90",
                    badgeText = "Super Oferta"
                )

                WgcCardFactory(
                    type = WgcCardType.StatusCard,
                    title = "Último Pedido em Andamento",
                    subtitle = "Entregador a caminho da sua residência",
                    badgeText = "Chegada em 12 min"
                )
            }
        }
    }
}

@Preview(name = "WgcHomeFactory - Default iFood", showBackground = true)
@Composable
private fun WgcHomeFactoryDefaultPreview() {
    WgcHomeFactory()
}

@Preview(name = "WgcHomeFactory - MercadoLivre", showBackground = true)
@Composable
private fun WgcHomeFactoryMLPreview() {
    WgcHomeFactory(brand = WgcBrand.MercadoLivre)
}
