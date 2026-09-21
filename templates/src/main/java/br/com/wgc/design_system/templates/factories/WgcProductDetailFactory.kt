@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.apparel.product.WgcClotheeProductDetailTemplate
import br.com.wgc.design_system.templates.screens.boutique.product.WgcLazaProductDetailTemplate
import br.com.wgc.design_system.templates.screens.product.BaseProductDetailViewModel
import br.com.wgc.design_system.templates.screens.product.FakeProductDetailViewModel
import br.com.wgc.design_system.templates.screens.product.WgcProductDetailTemplate

/**
 * Variantes de Detalhes do Produto suportadas pela [WgcProductDetailFactory].
 */
enum class WgcProductDetailType {
    STANDARD,
    APPAREL,
    BOUTIQUE
}

/**
 * Fábrica Universal de Telas de Detalhes do Produto (WgcProductDetailFactory).
 *
 * Fornece ponto de entrada unificado para telas de produto (PDP) no Design System WGC.
 */
@Composable
fun WgcProductDetailFactory(
    modifier: Modifier = Modifier,
    type: WgcProductDetailType = WgcProductDetailType.STANDARD,
    viewModel: BaseProductDetailViewModel = FakeProductDetailViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    gallerySlot: (@Composable () -> Unit)? = null,
    priceSlot: (@Composable () -> Unit)? = null,
    variantsSlot: (@Composable () -> Unit)? = null,
    detailsSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {}
) {
    val hasCustomSlots = headerSlot != null || gallerySlot != null ||
        priceSlot != null || variantsSlot != null || detailsSlot != null || bottomBarSlot != null

    if (!hasCustomSlots) {
        when (type) {
            WgcProductDetailType.APPAREL -> {
                WgcClotheeProductDetailTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick
                )
                return
            }
            WgcProductDetailType.BOUTIQUE -> {
                WgcLazaProductDetailTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick
                )
                return
            }
            WgcProductDetailType.STANDARD -> Unit
        }
    }

    WgcProductDetailTemplate(
        modifier = modifier,
        viewModel = viewModel,
        headerSlot = headerSlot,
        gallerySlot = gallerySlot,
        priceSlot = priceSlot,
        variantsSlot = variantsSlot,
        detailsSlot = detailsSlot,
        bottomBarSlot = bottomBarSlot,
        onBackClick = onBackClick
    )
}
