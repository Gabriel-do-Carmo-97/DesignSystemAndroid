package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcZapNavDestination
import br.com.wgc.ds_templates.screens.zap.detail.WgcZapPropertyDetailTemplate
import br.com.wgc.ds_templates.screens.zap.favorites.WgcZapFavoritesTemplate
import br.com.wgc.ds_templates.screens.zap.fipezap.WgcZapFipeZapCalculatorTemplate
import br.com.wgc.ds_templates.screens.zap.home.WgcZapHomeTemplate
import br.com.wgc.ds_templates.screens.zap.model.ZapMockData
import br.com.wgc.ds_templates.screens.zap.model.ZapPropertyModel
import br.com.wgc.ds_templates.screens.zap.profile.WgcZapProfileTemplate

/**
 * Telas disponíveis no ecossistema do Zap Imóveis.
 */
enum class WgcZapScreen {
    Home,
    Detail,
    FipeZap,
    Favorites,
    Profile
}

/**
 * Fábrica Universal do Zap Imóveis (WgcZapFactory).
 *
 * Provê alternância imediata entre as 5 telas oficiais do Zap Imóveis
 * com defaults prontos para produção e slots de customização granular.
 */
@Composable
fun WgcZapFactory(
    modifier: Modifier = Modifier,
    screen: WgcZapScreen = WgcZapScreen.Home,
    selectedProperty: ZapPropertyModel = ZapMockData.sampleProperties.first(),
    onNavigateToScreen: (WgcZapScreen) -> Unit = {},
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
        WgcZapScreen.Home -> {
            WgcZapHomeTemplate(
                properties = ZapMockData.sampleProperties,
                onPropertyClick = { prop ->
                    onPropertySelect(prop)
                    onNavigateToScreen(WgcZapScreen.Detail)
                },
                onFipeBannerClick = { onNavigateToScreen(WgcZapScreen.FipeZap) },
                currentNavDestination = WgcZapNavDestination.SEARCH,
                onNavSelect = { destination ->
                    when (destination) {
                        WgcZapNavDestination.SEARCH -> onNavigateToScreen(WgcZapScreen.Home)
                        WgcZapNavDestination.FAVORITES -> onNavigateToScreen(WgcZapScreen.Favorites)
                        WgcZapNavDestination.ALERTS -> onNavigateToScreen(WgcZapScreen.Favorites)
                        WgcZapNavDestination.FIPEZAP -> onNavigateToScreen(WgcZapScreen.FipeZap)
                        WgcZapNavDestination.PROFILE -> onNavigateToScreen(WgcZapScreen.Profile)
                    }
                },
                modifier = modifier
            )
        }

        WgcZapScreen.Detail -> {
            WgcZapPropertyDetailTemplate(
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcZapScreen.Home) },
                modifier = modifier
            )
        }

        WgcZapScreen.FipeZap -> {
            WgcZapFipeZapCalculatorTemplate(
                onBackClick = { onNavigateToScreen(WgcZapScreen.Home) },
                modifier = modifier
            )
        }

        WgcZapScreen.Favorites -> {
            WgcZapFavoritesTemplate(
                onPropertyClick = { prop ->
                    onPropertySelect(prop)
                    onNavigateToScreen(WgcZapScreen.Detail)
                },
                modifier = modifier
            )
        }

        WgcZapScreen.Profile -> {
            WgcZapProfileTemplate(
                onMyPropertiesClick = { onNavigateToScreen(WgcZapScreen.Home) },
                onFipeConsultingClick = { onNavigateToScreen(WgcZapScreen.FipeZap) },
                modifier = modifier
            )
        }
    }
}
