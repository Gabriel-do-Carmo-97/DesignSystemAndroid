package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.PharmacyNavTab
import br.com.wgc.design_system.templates.screens.pharmacychain.home.WgcDrogaRaiaHomeTemplate
import br.com.wgc.design_system.templates.screens.pharmacychain.model.PharmacyMockData
import br.com.wgc.design_system.templates.screens.pharmacychain.model.PharmacyProduct
import br.com.wgc.design_system.templates.screens.pharmacychain.model.PharmacyUserProfile

enum class WgcPharmacyChainScreen {
    HOME,
    PRESCRIPTIONS,
    SUBSCRIPTION,
    CART,
    PROFILE
}

@Composable
fun WgcPharmacyChainFactory(
    modifier: Modifier = Modifier,
    screen: WgcPharmacyChainScreen = WgcPharmacyChainScreen.HOME,
    userProfile: PharmacyUserProfile = PharmacyMockData.defaultUser,
    products: List<PharmacyProduct> = PharmacyMockData.sampleProducts,
    activeTab: PharmacyNavTab = PharmacyNavTab.HOME,
    onTabSelected: (PharmacyNavTab) -> Unit = {},
    onProductClick: (PharmacyProduct) -> Unit = {},
    onUploadPrescription: () -> Unit = {},
    onTalkToPharmacist: () -> Unit = {}
) {
    when (screen) {
        WgcPharmacyChainScreen.HOME -> {
            WgcDrogaRaiaHomeTemplate(
                modifier = modifier,
                userProfile = userProfile,
                products = products,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onProductClick = onProductClick,
                onUploadPrescription = onUploadPrescription,
                onTalkToPharmacist = onTalkToPharmacist
            )
        }
        WgcPharmacyChainScreen.PRESCRIPTIONS -> {
            br.com.wgc.design_system.templates.screens.pharmacychain.prescriptions.WgcDrogaRaiaPrescriptionTemplate(
                modifier = modifier,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onUploadClick = onUploadPrescription,
                onConsultPharmacist = onTalkToPharmacist
            )
        }
        WgcPharmacyChainScreen.SUBSCRIPTION -> {
            br.com.wgc.design_system.templates.screens.pharmacychain.subscription.WgcDrogaRaiaSubscriptionTemplate(
                modifier = modifier,
                activeTab = activeTab,
                onTabSelected = onTabSelected
            )
        }
        WgcPharmacyChainScreen.CART -> {
            br.com.wgc.design_system.templates.screens.pharmacychain.cart.WgcDrogaRaiaCartTemplate(
                modifier = modifier,
                activeTab = activeTab,
                onTabSelected = onTabSelected
            )
        }
        WgcPharmacyChainScreen.PROFILE -> {
            br.com.wgc.design_system.templates.screens.pharmacychain.profile.WgcDrogaRaiaProfileTemplate(
                modifier = modifier,
                userProfile = userProfile,
                activeTab = activeTab,
                onTabSelected = onTabSelected
            )
        }
    }
}
