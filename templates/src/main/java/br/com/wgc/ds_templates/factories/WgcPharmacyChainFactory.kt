package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab
import br.com.wgc.ds_templates.screens.pharmacychain.home.WgcDrogaRaiaHomeTemplate
import br.com.wgc.ds_templates.screens.pharmacychain.model.DrogaRaiaMockData
import br.com.wgc.ds_templates.screens.pharmacychain.model.DrogaRaiaProduct
import br.com.wgc.ds_templates.screens.pharmacychain.model.DrogaRaiaUserProfile

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
    userProfile: DrogaRaiaUserProfile = DrogaRaiaMockData.defaultUser,
    products: List<DrogaRaiaProduct> = DrogaRaiaMockData.sampleProducts,
    activeTab: DrogaRaiaNavTab = DrogaRaiaNavTab.HOME,
    onTabSelected: (DrogaRaiaNavTab) -> Unit = {},
    onProductClick: (DrogaRaiaProduct) -> Unit = {},
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
            br.com.wgc.ds_templates.screens.pharmacychain.prescriptions.WgcDrogaRaiaPrescriptionTemplate(
                modifier = modifier,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onUploadClick = onUploadPrescription,
                onConsultPharmacist = onTalkToPharmacist
            )
        }
        WgcPharmacyChainScreen.SUBSCRIPTION -> {
            br.com.wgc.ds_templates.screens.pharmacychain.subscription.WgcDrogaRaiaSubscriptionTemplate(
                modifier = modifier,
                activeTab = activeTab,
                onTabSelected = onTabSelected
            )
        }
        WgcPharmacyChainScreen.CART -> {
            br.com.wgc.ds_templates.screens.pharmacychain.cart.WgcDrogaRaiaCartTemplate(
                modifier = modifier,
                activeTab = activeTab,
                onTabSelected = onTabSelected
            )
        }
        WgcPharmacyChainScreen.PROFILE -> {
            br.com.wgc.ds_templates.screens.pharmacychain.profile.WgcDrogaRaiaProfileTemplate(
                modifier = modifier,
                userProfile = userProfile,
                activeTab = activeTab,
                onTabSelected = onTabSelected
            )
        }
    }
}
