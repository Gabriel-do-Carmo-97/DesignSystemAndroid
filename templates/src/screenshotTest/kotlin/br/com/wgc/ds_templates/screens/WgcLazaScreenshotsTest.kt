package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcLazaFactory
import br.com.wgc.ds_templates.factories.WgcLazaScreen
import com.android.tools.screenshot.PreviewTest

class WgcLazaScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Intro Screen")
    @Composable
    private fun LazaIntroScreenPreview() {
        WgcLazaFactory(screen = WgcLazaScreen.Intro)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Sign In Screen")
    @Composable
    private fun LazaSignInScreenPreview() {
        WgcLazaFactory(screen = WgcLazaScreen.SignIn)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Email Sign In Screen")
    @Composable
    private fun LazaEmailSignInScreenPreview() {
        WgcLazaFactory(screen = WgcLazaScreen.EmailSignIn)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Home Screen")
    @Composable
    private fun LazaHomeScreenPreview() {
        WgcLazaFactory(screen = WgcLazaScreen.Home)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Product Detail Screen")
    @Composable
    private fun LazaProductDetailScreenPreview() {
        WgcLazaFactory(screen = WgcLazaScreen.ProductDetail)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Cart Screen")
    @Composable
    private fun LazaCartScreenPreview() {
        WgcLazaFactory(screen = WgcLazaScreen.Cart)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Order Confirmed Screen")
    @Composable
    private fun LazaOrderConfirmedScreenPreview() {
        WgcLazaFactory(screen = WgcLazaScreen.OrderConfirmed)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Wishlist Screen")
    @Composable
    private fun LazaWishlistScreenPreview() {
        WgcLazaFactory(screen = WgcLazaScreen.Wishlist)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Laza Reviews Screen")
    @Composable
    private fun LazaReviewsScreenPreview() {
        WgcLazaFactory(screen = WgcLazaScreen.Reviews)
    }
}
