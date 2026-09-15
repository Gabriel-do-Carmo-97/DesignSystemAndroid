package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab
import br.com.wgc.ds_templates.screens.drogaraia.home.WgcDrogaRaiaHomeTemplate
import br.com.wgc.ds_templates.screens.drogaraia.model.DrogaRaiaMockData
import br.com.wgc.ds_templates.screens.drogaraia.model.DrogaRaiaProduct
import br.com.wgc.ds_templates.screens.drogaraia.model.DrogaRaiaUserProfile

enum class WgcDrogaRaiaScreen {
    HOME,
    PRESCRIPTIONS,
    SUBSCRIPTION,
    CART,
    PROFILE
}

@Composable
fun WgcDrogaRaiaFactory(
    modifier: Modifier = Modifier,
    screen: WgcDrogaRaiaScreen = WgcDrogaRaiaScreen.HOME,
    userProfile: DrogaRaiaUserProfile = DrogaRaiaMockData.defaultUser,
    products: List<DrogaRaiaProduct> = DrogaRaiaMockData.sampleProducts,
    activeTab: DrogaRaiaNavTab = DrogaRaiaNavTab.HOME,
    onTabSelected: (DrogaRaiaNavTab) -> Unit = {},
    onProductClick: (DrogaRaiaProduct) -> Unit = {},
    onUploadPrescription: () -> Unit = {},
    onTalkToPharmacist: () -> Unit = {}
) {
    when (screen) {
        WgcDrogaRaiaScreen.HOME,
        WgcDrogaRaiaScreen.PRESCRIPTIONS,
        WgcDrogaRaiaScreen.SUBSCRIPTION,
        WgcDrogaRaiaScreen.CART,
        WgcDrogaRaiaScreen.PROFILE -> {
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
    }
}
