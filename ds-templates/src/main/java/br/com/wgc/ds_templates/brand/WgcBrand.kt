package br.com.wgc.ds_templates.brand

import androidx.compose.ui.graphics.Color

/**
 * Marcas suportadas pelo ecossistema de templates do WGC Design System.
 */
enum class WgcBrand(
    val brandName: String,
    val brandLogoText: String,
    val primaryColor: Color
) {
    IFood(
        brandName = "iFood",
        brandLogoText = "iF",
        primaryColor = Color(0xFFEA1D2C)
    ),
    Uber(
        brandName = "Uber",
        brandLogoText = "Uber",
        primaryColor = Color(0xFF000000)
    ),
    MercadoLivre(
        brandName = "Mercado Livre",
        brandLogoText = "ML",
        primaryColor = Color(0xFFFFE600)
    ),
    NineNineFood(
        brandName = "99Food",
        brandLogoText = "99",
        primaryColor = Color(0xFFFF5722)
    ),
    Shopee(
        brandName = "Shopee",
        brandLogoText = "Shopee",
        primaryColor = Color(0xFFEE4D2D)
    ),
    AliExpress(
        brandName = "AliExpress",
        brandLogoText = "Ali",
        primaryColor = Color(0xFFFF4747)
    )
}
