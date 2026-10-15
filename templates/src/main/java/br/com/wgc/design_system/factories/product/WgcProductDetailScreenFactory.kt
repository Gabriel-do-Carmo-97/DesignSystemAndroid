package br.com.wgc.design_system.factories.product

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.screens.apparel.product.WgcClotheeProductDetailTemplate
import br.com.wgc.design_system.templates.screens.boutique.product.WgcLazaProductDetailTemplate
import br.com.wgc.design_system.templates.screens.product.FakeProductDetailViewModel
import br.com.wgc.design_system.templates.screens.product.WgcProductDetailTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Detalhes do Produto (WgcProductDetailScreenFactory).
 */
@Composable
fun WgcProductDetailScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcProductDetailVariant = WgcProductDetailVariant.STANDARD,
    onBackClick: () -> Unit = {}
) {
    when (variant) {
        WgcProductDetailVariant.APPAREL -> WgcClotheeProductDetailTemplate(
            modifier = modifier,
            onBackClick = onBackClick
        )
        WgcProductDetailVariant.BOUTIQUE -> WgcLazaProductDetailTemplate(
            modifier = modifier,
            onBackClick = onBackClick
        )
        WgcProductDetailVariant.STANDARD -> WgcProductDetailTemplate(
            modifier = modifier,
            viewModel = FakeProductDetailViewModel(),
            onBackClick = onBackClick
        )
    }
}

@Preview(name = "WgcProductDetailScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcProductDetailScreenFactoryPreview() {
    WgcTheme {
        WgcProductDetailScreenFactory()
    }
}
