package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcClotheeFactory
import br.com.wgc.ds_templates.factories.WgcClotheeScreen
import com.android.tools.screenshot.PreviewTest

class WgcClotheeScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Home Screen")
    @Composable
    private fun ClotheeHomeScreenPreview() {
        WgcClotheeFactory(screen = WgcClotheeScreen.Home)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Sign In Screen")
    @Composable
    private fun ClotheeSignInScreenPreview() {
        WgcClotheeFactory(screen = WgcClotheeScreen.SignIn)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Product Detail Screen")
    @Composable
    private fun ClotheeProductDetailScreenPreview() {
        WgcClotheeFactory(screen = WgcClotheeScreen.ProductDetail)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Cart Screen")
    @Composable
    private fun ClotheeCartScreenPreview() {
        WgcClotheeFactory(screen = WgcClotheeScreen.Cart)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Order Placed Screen")
    @Composable
    private fun ClotheeOrderPlacedScreenPreview() {
        WgcClotheeFactory(screen = WgcClotheeScreen.OrderPlaced)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Track Order Screen")
    @Composable
    private fun ClotheeTrackOrderScreenPreview() {
        WgcClotheeFactory(screen = WgcClotheeScreen.TrackOrder)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Settings Screen")
    @Composable
    private fun ClotheeSettingsScreenPreview() {
        WgcClotheeFactory(screen = WgcClotheeScreen.Settings)
    }
}
