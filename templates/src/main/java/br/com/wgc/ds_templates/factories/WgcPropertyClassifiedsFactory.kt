package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcZapNavDestination
import br.com.wgc.ds_templates.screens.propertyclassifieds.detail.WgcZapPropertyDetailTemplate
import br.com.wgc.ds_templates.screens.propertyclassifieds.favorites.WgcZapFavoritesTemplate
import br.com.wgc.ds_templates.screens.propertyclassifieds.fipezap.WgcZapFipeZapCalculatorTemplate
import br.com.wgc.ds_templates.screens.propertyclassifieds.home.WgcZapHomeTemplate
import br.com.wgc.ds_templates.screens.propertyclassifieds.model.PropertyClassifiedsMockData
import br.com.wgc.ds_templates.screens.propertyclassifieds.model.ZapPropertyModel
import br.com.wgc.ds_templates.screens.propertyclassifieds.profile.WgcZapProfileTemplate

/**
 * Telas disponíveis no ecossistema do Zap Imóveis.
 */
enum class WgcPropertyClassifiedsScreen {
    Home,
    Detail,
    FipeZap,
    Favorites,
    Profile
}

/**
 * Fábrica Universal do Zap Imóveis (WgcPropertyClassifiedsFactory).
 *
 * Provê alternância imediata entre as 5 telas oficiais do Zap Imóveis
 * com defaults prontos para produção e slots de customização granular.
 */
@Composable
fun WgcPropertyClassifiedsFactory(
    modifier: Modifier = Modifier,
    screen: WgcPropertyClassifiedsScreen = WgcPropertyClassifiedsScreen.Home,
    selectedProperty: ZapPropertyModel = PropertyClassifiedsMockData.sampleProperties.first(),
    onNavigateToScreen: (WgcPropertyClassifiedsScreen) -> Unit = {},
    onPropertySelect: (ZapPropertyModel) -> Unit = {},
    slotTopBar: (@Composable () -> Unit)? = null,
    slotBottomBar: (@Composable () -> Unit)? = null,
    slotContent: (@Composable () -> Unit)? = null
) {
    if (slotContent != null) {
        slotContent()
        return
    }

    when (screen) {
        WgcPropertyClassifiedsScreen.Home -> {
            WgcZapHomeTemplate(
                properties = PropertyClassifiedsMockData.sampleProperties,
                onPropertyClick = { prop ->
                    onPropertySelect(prop)
                    onNavigateToScreen(WgcPropertyClassifiedsScreen.Detail)
                },
                onFipeBannerClick = { onNavigateToScreen(WgcPropertyClassifiedsScreen.FipeZap) },
                currentNavDestination = WgcZapNavDestination.SEARCH,
                onNavSelect = { destination ->
                    when (destination) {
                        WgcZapNavDestination.SEARCH -> onNavigateToScreen(WgcPropertyClassifiedsScreen.Home)
                        WgcZapNavDestination.FAVORITES -> onNavigateToScreen(WgcPropertyClassifiedsScreen.Favorites)
                        WgcZapNavDestination.ALERTS -> onNavigateToScreen(WgcPropertyClassifiedsScreen.Favorites)
                        WgcZapNavDestination.FIPEZAP -> onNavigateToScreen(WgcPropertyClassifiedsScreen.FipeZap)
                        WgcZapNavDestination.PROFILE -> onNavigateToScreen(WgcPropertyClassifiedsScreen.Profile)
                    }
                },
                modifier = modifier
            )
        }

        WgcPropertyClassifiedsScreen.Detail -> {
            WgcZapPropertyDetailTemplate(
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcPropertyClassifiedsScreen.Home) },
                modifier = modifier
            )
        }

        WgcPropertyClassifiedsScreen.FipeZap -> {
            WgcZapFipeZapCalculatorTemplate(
                onBackClick = { onNavigateToScreen(WgcPropertyClassifiedsScreen.Home) },
                modifier = modifier
            )
        }

        WgcPropertyClassifiedsScreen.Favorites -> {
            WgcZapFavoritesTemplate(
                onPropertyClick = { prop ->
                    onPropertySelect(prop)
                    onNavigateToScreen(WgcPropertyClassifiedsScreen.Detail)
                },
                modifier = modifier
            )
        }

        WgcPropertyClassifiedsScreen.Profile -> {
            WgcZapProfileTemplate(
                onMyPropertiesClick = { onNavigateToScreen(WgcPropertyClassifiedsScreen.Home) },
                onFipeConsultingClick = { onNavigateToScreen(WgcPropertyClassifiedsScreen.FipeZap) },
                modifier = modifier
            )
        }
    }
}
