package br.com.wgc.ds_templates.screens.quickshop.model

import androidx.compose.ui.graphics.Color
import br.com.wgc.core_ds.WgcCoreDsColors

data class ShopEaseProduct(
    val id: String,
    val title: String,
    val category: String,
    val price: String,
    val originalPrice: String? = null,
    val discountBadge: String? = "20% off",
    val backgroundColor: Color = Color(WgcCoreDsColors.quickShopCardRed),
    val rating: String = "4.9",
    val description: String = "Super comfortable, high-performance running sneakers featuring responsive cushioning and breathable mesh.",
    val isFavorite: Boolean = false
)

data class ShopEaseCartItem(
    val product: ShopEaseProduct,
    var quantity: Int = 1,
    val selectedSize: String = "42",
    val selectedColor: String = "Red"
)

data class ShopEaseOrderItem(
    val orderId: String,
    val items: List<ShopEaseCartItem>,
    val subtotal: String,
    val deliveryFee: String,
    val total: String,
    val paymentMethod: String = "MasterCard **** 4321"
)

object ShopEaseMockData {
    val products = listOf(
        ShopEaseProduct(
            id = "se1",
            title = "Red Velocity Runner",
            category = "Shoes",
            price = "$35.00",
            originalPrice = "$50.00",
            discountBadge = "30% off",
            backgroundColor = Color(WgcCoreDsColors.quickShopCardRed),
            isFavorite = true
        ),
        ShopEaseProduct(
            id = "se2",
            title = "Aero Grey Athletic",
            category = "Shoes",
            price = "$42.00",
            originalPrice = "$60.00",
            discountBadge = "25% off",
            backgroundColor = Color(WgcCoreDsColors.quickShopCardPurple),
            isFavorite = false
        ),
        ShopEaseProduct(
            id = "se3",
            title = "Black Urban Tee",
            category = "Clothes",
            price = "$22.00",
            originalPrice = "$30.00",
            discountBadge = "15% off",
            backgroundColor = Color(WgcCoreDsColors.quickShopCardGreen),
            isFavorite = true
        ),
        ShopEaseProduct(
            id = "se4",
            title = "Smart Ultrasonic Wristwatch",
            category = "Accessories",
            price = "$120.00",
            originalPrice = "$150.00",
            discountBadge = "20% off",
            backgroundColor = Color(WgcCoreDsColors.quickShopCardBlue),
            isFavorite = false
        ),
        ShopEaseProduct(
            id = "se5",
            title = "Midnight Black Sneaker",
            category = "Shoes",
            price = "$48.00",
            originalPrice = "$65.00",
            discountBadge = "25% off",
            backgroundColor = Color(WgcCoreDsColors.quickShopCardOrange),
            isFavorite = true
        ),
        ShopEaseProduct(
            id = "se6",
            title = "Crimson Pulse Trainer",
            category = "Shoes",
            price = "$39.00",
            originalPrice = "$55.00",
            discountBadge = "30% off",
            backgroundColor = Color(WgcCoreDsColors.quickShopCardRed),
            isFavorite = false
        )
    )

    val cartItems = listOf(
        ShopEaseCartItem(products[0], quantity = 1, selectedSize = "42", selectedColor = "Red"),
        ShopEaseCartItem(products[1], quantity = 2, selectedSize = "41", selectedColor = "Grey")
    )
}
