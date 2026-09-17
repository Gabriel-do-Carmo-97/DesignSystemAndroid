package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcApparelFactory
import br.com.wgc.ds_templates.factories.WgcApparelScreen
import com.android.tools.screenshot.PreviewTest

class WgcClotheeScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Home Screen")
    @Composable
    private fun ClotheeHomeScreenPreview() {
        WgcApparelFactory(screen = WgcApparelScreen.Home)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Sign In Screen")
    @Composable
    private fun ClotheeSignInScreenPreview() {
        WgcApparelFactory(screen = WgcApparelScreen.SignIn)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Product Detail Screen")
    @Composable
    private fun ClotheeProductDetailScreenPreview() {
        WgcApparelFactory(screen = WgcApparelScreen.ProductDetail)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Cart Screen")
    @Composable
    private fun ClotheeCartScreenPreview() {
        WgcApparelFactory(screen = WgcApparelScreen.Cart)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Order Placed Screen")
    @Composable
    private fun ClotheeOrderPlacedScreenPreview() {
        WgcApparelFactory(screen = WgcApparelScreen.OrderPlaced)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Track Order Screen")
    @Composable
    private fun ClotheeTrackOrderScreenPreview() {
        WgcApparelFactory(screen = WgcApparelScreen.TrackOrder)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Clothee Settings Screen")
    @Composable
    private fun ClotheeSettingsScreenPreview() {
        WgcApparelFactory(screen = WgcApparelScreen.Settings)
    }
}
