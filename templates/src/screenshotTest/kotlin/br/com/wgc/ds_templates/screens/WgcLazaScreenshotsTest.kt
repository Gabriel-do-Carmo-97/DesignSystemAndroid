package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcBoutiqueFactory
import br.com.wgc.ds_templates.factories.WgcBoutiqueScreen
import com.android.tools.screenshot.PreviewTest

class WgcLazaScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Intro Screen")
    @Composable
    private fun LazaIntroScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Intro)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Sign In Screen")
    @Composable
    private fun LazaSignInScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.SignIn)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Email Sign In Screen")
    @Composable
    private fun LazaEmailSignInScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.EmailSignIn)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Home Screen")
    @Composable
    private fun LazaHomeScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Home)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Product Detail Screen")
    @Composable
    private fun LazaProductDetailScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.ProductDetail)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Cart Screen")
    @Composable
    private fun LazaCartScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Cart)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Order Confirmed Screen")
    @Composable
    private fun LazaOrderConfirmedScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.OrderConfirmed)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Wishlist Screen")
    @Composable
    private fun LazaWishlistScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Wishlist)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Reviews Screen")
    @Composable
    private fun LazaReviewsScreenPreview() {
        WgcBoutiqueFactory(screen = WgcBoutiqueScreen.Reviews)
    }
}
