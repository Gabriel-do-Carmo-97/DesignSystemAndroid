package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcCuratedMarketFactory
import br.com.wgc.ds_templates.factories.WgcCuratedMarketScreen
import com.android.tools.screenshot.PreviewTest

class WgcTasselScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Market Screen")
    @Composable
    private fun TasselMarketScreenPreview() {
        WgcCuratedMarketFactory(screen = WgcCuratedMarketScreen.Market)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Featured Screen")
    @Composable
    private fun TasselFeaturedScreenPreview() {
        WgcCuratedMarketFactory(screen = WgcCuratedMarketScreen.Featured)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Product Detail Screen")
    @Composable
    private fun TasselProductDetailScreenPreview() {
        WgcCuratedMarketFactory(screen = WgcCuratedMarketScreen.ProductDetail)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Order Tracking Screen")
    @Composable
    private fun TasselOrderTrackingScreenPreview() {
        WgcCuratedMarketFactory(screen = WgcCuratedMarketScreen.OrderTracking)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Profile Screen")
    @Composable
    private fun TasselProfileScreenPreview() {
        WgcCuratedMarketFactory(screen = WgcCuratedMarketScreen.Profile)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Cart Screen")
    @Composable
    private fun TasselCartScreenPreview() {
        WgcCuratedMarketFactory(screen = WgcCuratedMarketScreen.Cart)
    }
}
