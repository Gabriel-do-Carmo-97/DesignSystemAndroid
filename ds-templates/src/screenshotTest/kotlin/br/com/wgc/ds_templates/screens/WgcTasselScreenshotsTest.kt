package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcTasselFactory
import br.com.wgc.ds_templates.factories.WgcTasselScreen
import com.android.tools.screenshot.PreviewTest

class WgcTasselScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Market Screen")
    @Composable
    private fun TasselMarketScreenPreview() {
        WgcTasselFactory(screen = WgcTasselScreen.Market)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Featured Screen")
    @Composable
    private fun TasselFeaturedScreenPreview() {
        WgcTasselFactory(screen = WgcTasselScreen.Featured)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Product Detail Screen")
    @Composable
    private fun TasselProductDetailScreenPreview() {
        WgcTasselFactory(screen = WgcTasselScreen.ProductDetail)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Order Tracking Screen")
    @Composable
    private fun TasselOrderTrackingScreenPreview() {
        WgcTasselFactory(screen = WgcTasselScreen.OrderTracking)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Profile Screen")
    @Composable
    private fun TasselProfileScreenPreview() {
        WgcTasselFactory(screen = WgcTasselScreen.Profile)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Tassel Cart Screen")
    @Composable
    private fun TasselCartScreenPreview() {
        WgcTasselFactory(screen = WgcTasselScreen.Cart)
    }
}
