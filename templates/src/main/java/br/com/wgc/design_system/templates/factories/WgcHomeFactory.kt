package br.com.wgc.design_system.templates.factories

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
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcCardFactory
import br.com.wgc.design_system.components.cards.WgcCardType
import br.com.wgc.design_system.components.fields.WgcFieldFactory
import br.com.wgc.design_system.components.fields.WgcFieldType
import br.com.wgc.design_system.components.navigation.WgcAddressHeaderBar
import br.com.wgc.design_system.components.navigation.WgcMenuFactory
import br.com.wgc.design_system.components.navigation.WgcMenuType
import br.com.wgc.design_system.templates.brand.WgcBrand
import br.com.wgc.design_system.templates.screens.home.ecommerce.EcommerceHomeScreenTemplate
import br.com.wgc.design_system.templates.screens.home.ecommerce.FakeEcommerceHomeViewModel
import br.com.wgc.design_system.templates.screens.fooddelivery.FakeFoodDeliveryHomeViewModel
import br.com.wgc.design_system.templates.screens.fooddelivery.WgcFoodDeliveryHomeScreenTemplate
import br.com.wgc.design_system.templates.screens.marketplacescreen.FakeMarketplaceHomeViewModel
import br.com.wgc.design_system.templates.screens.marketplacescreen.WgcMarketplaceHomeScreenTemplate
import br.com.wgc.design_system.templates.screens.quickfooddelivery.FakeQuickFoodDeliveryHomeViewModel
import br.com.wgc.design_system.templates.screens.quickfooddelivery.WgcQuickFoodDeliveryHomeScreenTemplate

/**
 * Fábrica Universal de Telas Home (WgcHomeFactory).
 * Permite instanciar telas Home completas simplesmente escolhendo o [brand],
 * além de permitir substituição cirúrgica de [topBarSlot], [bottomNavSlot],
 * [floatingActionSlot], [bannerSlot] e [contentSlot].
 */
@Composable
fun WgcHomeFactory(
    modifier: Modifier = Modifier,
    brand: WgcBrand = WgcBrand.FoodDelivery,
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
            WgcBrand.FoodDelivery -> WgcFoodDeliveryHomeScreenTemplate(FakeFoodDeliveryHomeViewModel())
            WgcBrand.Marketplace -> WgcMarketplaceHomeScreenTemplate(FakeMarketplaceHomeViewModel())
            WgcBrand.QuickFoodDelivery -> WgcQuickFoodDeliveryHomeScreenTemplate(FakeQuickFoodDeliveryHomeViewModel())
            WgcBrand.RideHailing,
            WgcBrand.DealMarketplace,
            WgcBrand.GlobalMarketplace,
            WgcBrand.ClockAuth,
            WgcBrand.WaveAuth,
            WgcBrand.SplitAuth -> EcommerceHomeScreenTemplate(FakeEcommerceHomeViewModel())
            WgcBrand.TrendFashion -> br.com.wgc.design_system.templates.screens.trendfashion.home.WgcStylishHomeScreenTemplate()
            WgcBrand.MegaStore -> br.com.wgc.design_system.templates.screens.megastore.home.WgcShoppeHomeScreenTemplate()
            WgcBrand.Retail -> br.com.wgc.design_system.templates.screens.retail.home.WgcKutukuHomeScreen()
            WgcBrand.Apparel -> br.com.wgc.design_system.templates.screens.apparel.home.WgcClotheeHomeTemplate()
            WgcBrand.Boutique -> br.com.wgc.design_system.templates.screens.boutique.home.WgcLazaHomeTemplate()
            WgcBrand.CuratedMarket -> br.com.wgc.design_system.templates.screens.curatedmarket.market.WgcTasselMarketTemplate()
            WgcBrand.FreshGrocery -> br.com.wgc.design_system.templates.screens.freshgrocery.home.WgcFreshGroceryHomeTemplate()
            WgcBrand.GadgetShop -> br.com.wgc.design_system.templates.screens.gadgetshop.home.WgcNexkartHomeTemplate()
            WgcBrand.QuickShop -> br.com.wgc.design_system.templates.screens.quickshop.home.WgcShopEaseHomeTemplate()
            WgcBrand.PersonalFinance -> br.com.wgc.design_system.templates.screens.personalfinance.dashboard.WgcOrganizzeDashboardTemplate()
            WgcBrand.PropertyRental -> br.com.wgc.design_system.templates.screens.propertyrental.home.WgcPropertyRentalHomeTemplate()
            WgcBrand.PropertyListing -> br.com.wgc.design_system.templates.screens.propertylisting.home.WgcPropertyListingHomeTemplate()
            WgcBrand.PropertyClassifieds -> br.com.wgc.design_system.templates.screens.propertyclassifieds.home.WgcZapHomeTemplate()
            WgcBrand.GymFitness -> WgcGymFitnessFactory.Screen(WgcGymFitnessScreen.Home)
            WgcBrand.CorporateWellness -> WgcCorporateWellnessFactory.Screen(WgcCorporateWellnessScreen.Home)
            WgcBrand.GuidedTraining -> WgcGuidedTrainingFactory(screen = WgcGuidedTrainingScreen.HOME)
            WgcBrand.Hypermarket -> WgcHypermarketFactory(screen = WgcHypermarketScreen.HOME)
            WgcBrand.PremiumGrocery -> WgcPremiumGroceryFactory(screen = WgcPremiumGroceryScreen.HOME)
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
                val isEcommerceOrDelivery = brand in setOf<WgcBrand>(
                    WgcBrand.DealMarketplace,
                    WgcBrand.Marketplace,
                    WgcBrand.GlobalMarketplace,
                    WgcBrand.FoodDelivery,
                    WgcBrand.QuickFoodDelivery,
                    WgcBrand.MegaStore
                )
                if (isEcommerceOrDelivery) {
                    WgcMenuFactory(
                        type = WgcMenuType.ProminentCenter,
                        items = br.com.wgc.design_system.components.navigation.defaultWgcProminentMenuItems()
                    )
                } else {
                    WgcMenuFactory(type = WgcMenuType.ClassicBottomBar)
                }
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
                .background(Color(WgcCoreDsColors.foodDeliveryBgGray))
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

@Preview(name = "WgcHomeFactory - Default Food Delivery", showBackground = true)
@Composable
private fun WgcHomeFactoryDefaultPreview() {
    WgcHomeFactory()
}

@Preview(name = "WgcHomeFactory - Marketplace", showBackground = true)
@Composable
private fun WgcHomeFactoryMLPreview() {
    WgcHomeFactory(brand = WgcBrand.Marketplace)
}
