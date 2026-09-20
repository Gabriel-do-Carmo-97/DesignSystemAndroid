package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcBoutiqueFactory
import br.com.wgc.design_system.templates.factories.WgcBoutiqueScreen
import com.android.tools.screenshot.PreviewTest

class WgcBoutiqueScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Boutique Intro Screen")
    @Composable
    private fun BoutiqueIntroScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Intro)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Boutique Sign In Screen")
    @Composable
    private fun BoutiqueSignInScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.SignIn)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Boutique Email Sign In Screen")
    @Composable
    private fun BoutiqueEmailSignInScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.EmailSignIn)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Boutique Home Screen")
    @Composable
    private fun BoutiqueHomeScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Home)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Boutique Product Detail Screen")
    @Composable
    private fun BoutiqueProductDetailScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.ProductDetail)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Boutique Cart Screen")
    @Composable
    private fun BoutiqueCartScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Cart)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Boutique Order Confirmed Screen")
    @Composable
    private fun BoutiqueOrderConfirmedScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.OrderConfirmed)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Boutique Wishlist Screen")
    @Composable
    private fun BoutiqueWishlistScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Wishlist)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Boutique Reviews Screen")
    @Composable
    private fun BoutiqueReviewsScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Reviews)
    }
}
