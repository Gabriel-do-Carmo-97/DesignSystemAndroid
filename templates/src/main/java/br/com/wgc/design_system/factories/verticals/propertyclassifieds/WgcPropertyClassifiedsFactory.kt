package br.com.wgc.design_system.factories.verticals.propertyclassifieds

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcZapNavDestination
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.detail.WgcZapPropertyDetailTemplate
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.favorites.WgcZapFavoritesTemplate
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.fipezap.WgcZapFipeZapCalculatorTemplate
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.home.WgcZapHomeTemplate
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.model.PropertyClassifiedsMockData
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.model.ZapPropertyModel
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.profile.WgcZapProfileTemplate

/**
 * Telas disponÃ­veis no ecossistema do Zap ImÃ³veis.
 */
enum class WgcPropertyClassifiedsScreen {
    Home,
    Detail,
    FipeZap,
    Favorites,
    Profile
}

/**
 * FÃ¡brica Universal do Zap ImÃ³veis (WgcPropertyClassifiedsFactory).
 *
 * ProvÃª alternÃ¢ncia imediata entre as 5 telas oficiais do Zap ImÃ³veis
 * com defaults prontos para produÃ§Ã£o e slots de customizaÃ§Ã£o granular.
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
