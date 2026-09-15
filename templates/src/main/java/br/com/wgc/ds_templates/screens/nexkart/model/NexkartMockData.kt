package br.com.wgc.ds_templates.screens.nexkart.model

import androidx.compose.ui.graphics.Color
import br.com.wgc.core_ds.WgcCoreDsColors

/**
 * Modelo de produto do ecossistema Nexkart.
 */
data class NexkartProduct(
    val id: String,
    val title: String,
    val price: String,
    val originalPrice: String? = null,
    val rating: Double = 4.8,
    val reviewCount: Int = 308,
    val category: String = "Lifestyle",
    val description: String = "Premium quality design with comfortable sole and breathable material.",
    val imageUrl: String? = null,
    val tag: String? = null,
    val isFavorite: Boolean = false,
    val soldCount: Int = 63
)

/**
 * Modelo de categoria do ecossistema Nexkart.
 */
data class NexkartCategory(
    val id: String,
    val name: String,
    val color: Color
)

/**
 * Item de carrinho Nexkart.
 */
data class NexkartCartItem(
    val product: NexkartProduct,
    val quantity: Int = 1,
    val size: String = "42"
)

/**
 * Mock data oficial do kit Nexkart Figma Community.
 */
object NexkartMockData {
    val categories = listOf(
        NexkartCategory("1", "Beauty", Color(WgcCoreDsColors.nexkartCatBeauty)),
        NexkartCategory("2", "Gadgets", Color(WgcCoreDsColors.nexkartCatGadgets)),
        NexkartCategory("3", "Games", Color(WgcCoreDsColors.nexkartCatGames)),
        NexkartCategory("4", "Cine", Color(WgcCoreDsColors.nexkartCatCine)),
        NexkartCategory("5", "Fashion", Color(WgcCoreDsColors.nexkartCatFashion))
    )

    val products = listOf(
        NexkartProduct(
            id = "nk-1",
            title = "Nike Air Max 95 Premium",
            price = "USD 180.00",
            originalPrice = "USD 220.00",
            rating = 4.8,
            reviewCount = 308,
            category = "Men's Shoes / Lifestyle",
            description = "Taking inspiration from the human body and '90s track aesthetics, the Nike Air Max 95 mixes unbelievable comfort with head-turning style.",
            tag = "Featured",
            isFavorite = true,
            soldCount = 63
        ),
        NexkartProduct(
            id = "nk-2",
            title = "Samsung Galaxy S10",
            price = "USD 860.00",
            originalPrice = "USD 1000.00",
            rating = 4.9,
            reviewCount = 52,
            category = "Gadgets / Smartphones",
            description = "Cinematic Infinity Display, pro-grade camera and Wireless PowerShare.",
            tag = "-40%",
            isFavorite = false,
            soldCount = 120
        ),
        NexkartProduct(
            id = "nk-3",
            title = "Xiaomi Mi Airdots",
            price = "USD 31.00",
            originalPrice = "USD 50.00",
            rating = 4.6,
            reviewCount = 94,
            category = "Gadgets / Audio",
            description = "True wireless bluetooth headset with stereo sound and long battery life.",
            tag = "Hot",
            isFavorite = false,
            soldCount = 450
        ),
        NexkartProduct(
            id = "nk-4",
            title = "Stone Plants",
            price = "USD 16.00",
            originalPrice = "USD 20.00",
            rating = 4.7,
            reviewCount = 28,
            category = "Home / Deco",
            description = "Natural succulent stone plant pot for office desk and indoor spaces.",
            tag = null,
            isFavorite = false,
            soldCount = 80
        ),
        NexkartProduct(
            id = "nk-5",
            title = "Xiaomi Running Shoes for Men",
            price = "USD 60.00",
            originalPrice = "USD 85.00",
            rating = 4.7,
            reviewCount = 38,
            category = "Sport Shoes",
            description = "Ultra lightweight breathable running sneakers with shock absorption.",
            tag = "Sale",
            isFavorite = false,
            soldCount = 98
        ),
        NexkartProduct(
            id = "nk-6",
            title = "Nike Air Zoom Vomero 14",
            price = "USD 90.00",
            originalPrice = "USD 130.00",
            rating = 4.9,
            reviewCount = 64,
            category = "Sport Shoes",
            description = "Responsive cushioning and full-length Zoom Air unit for smooth strides.",
            tag = "Featured",
            isFavorite = true,
            soldCount = 150
        )
    )

    val topProducts = listOf(
        NexkartProduct(
            id = "top-1",
            title = "Scent Tray",
            price = "USD 68.00",
            description = "Minimalist organizer tray to capture the falling ash from incense sticks.",
            category = "Home / Living"
        ),
        NexkartProduct(
            id = "top-2",
            title = "Fidget Spinner Pro",
            price = "USD 12.00",
            description = "Precision metal hybrid ceramic bearings with ultra smooth spin.",
            category = "Games / Toys"
        )
    )

    val initialCart = listOf(
        NexkartCartItem(products[0], quantity = 1, size = "42"),
        NexkartCartItem(products[2], quantity = 2, size = "Standard"),
        NexkartCartItem(products[4], quantity = 1, size = "41")
    )
}
