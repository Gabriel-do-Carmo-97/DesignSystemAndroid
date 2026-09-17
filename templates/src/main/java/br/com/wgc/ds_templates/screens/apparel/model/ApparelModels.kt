package br.com.wgc.ds_templates.screens.apparel.model

import androidx.compose.ui.graphics.Color
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.design_system.components.tracking.WgcClotheeStepState
import br.com.wgc.design_system.components.tracking.WgcClotheeTimelineStep

data class ClotheeProduct(
    val id: String,
    val title: String,
    val price: String,
    val priceValue: Double,
    val originalPrice: String? = null,
    val category: String,
    val gender: String = "Men",
    val imageUrl: String? = null,
    val rating: Float = 4.5f,
    val reviewCount: Int = 120,
    val isFavorite: Boolean = false,
    val description: String = "Built for life and made to last, this sportswear piece features breathable, durable organic cotton fleece with ribbed trims and an athletic silhouette.",
    val availableSizes: List<String> = listOf("S", "M", "L", "XL", "2XL"),
    val availableColors: List<ClotheeColorOption> = listOf(
        ClotheeColorOption("Lemon", Color(0xFFF9E79F)),
        ClotheeColorOption("Purple", Color(0xFF8E6CEF)),
        ClotheeColorOption("Charcoal", Color(0xFF272727)),
        ClotheeColorOption("White", Color(0xFFFFFFFF))
    )
)

data class ClotheeColorOption(
    val name: String,
    val color: Color
)

data class ClotheeCategory(
    val id: String,
    val name: String,
    val itemCount: Int = 45,
    val imageUrl: String? = null
)

data class ClotheeCartItem(
    val id: String,
    val product: ClotheeProduct,
    val size: String = "M",
    val colorName: String = "Lemon",
    val quantity: Int = 1
) {
    val totalPrice: Double
        get() = product.priceValue * quantity
}

data class ClotheeReview(
    val id: String,
    val authorName: String,
    val rating: Int = 5,
    val date: String = "12d ago",
    val comment: String,
    val avatarUrl: String? = null
)

data class ClotheeAddress(
    val id: String,
    val street: String,
    val cityStateZip: String,
    val phoneNumber: String,
    val isDefault: Boolean = true
)

object ApparelMockData {
    val categories = listOf(
        ClotheeCategory(
            id = "cat-hoodies",
            name = "Hoodies",
            itemCount = 84,
            imageUrl = "https://images.unsplash.com/photo-1556905055-8f358a7a47b2?w=300"
        ),
        ClotheeCategory(
            id = "cat-shorts",
            name = "Shorts",
            itemCount = 52,
            imageUrl = "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=300"
        ),
        ClotheeCategory(
            id = "cat-shoes",
            name = "Shoes",
            itemCount = 112,
            imageUrl = "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=300"
        ),
        ClotheeCategory(
            id = "cat-bag",
            name = "Bag",
            itemCount = 38,
            imageUrl = "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=300"
        ),
        ClotheeCategory(
            id = "cat-accessories",
            name = "Accessories",
            itemCount = 64,
            imageUrl = "https://images.unsplash.com/photo-1576871337622-98d48d1cf531?w=300"
        )
    )

    val products = listOf(
        ClotheeProduct(
            id = "clothee-1",
            title = "Men's Harrington Jacket",
            price = "$148.00",
            priceValue = 148.00,
            originalPrice = "$198.00",
            category = "Jackets",
            gender = "Men",
            imageUrl = "https://images.unsplash.com/photo-1548883354-7622d03aca27?w=600",
            rating = 4.8f,
            reviewCount = 248,
            isFavorite = false
        ),
        ClotheeProduct(
            id = "clothee-2",
            title = "Cotton Fleece Hoodie",
            price = "$84.00",
            priceValue = 84.00,
            originalPrice = "$110.00",
            category = "Hoodies",
            gender = "Men",
            imageUrl = "https://images.unsplash.com/photo-1556905055-8f358a7a47b2?w=600",
            rating = 4.9f,
            reviewCount = 512,
            isFavorite = true
        ),
        ClotheeProduct(
            id = "clothee-3",
            title = "Max90 Heritage Graphic Tee",
            price = "$45.00",
            priceValue = 45.00,
            category = "T-Shirts",
            gender = "Men",
            imageUrl = "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?w=600",
            rating = 4.6f,
            reviewCount = 94,
            isFavorite = false
        ),
        ClotheeProduct(
            id = "clothee-4",
            title = "Pro Dri-FIT Track Pants",
            price = "$78.00",
            priceValue = 78.00,
            originalPrice = "$95.00",
            category = "Pants",
            gender = "Men",
            imageUrl = "https://images.unsplash.com/photo-1552902865-b72c031ac5ea?w=600",
            rating = 4.7f,
            reviewCount = 180,
            isFavorite = false
        ),
        ClotheeProduct(
            id = "clothee-5",
            title = "Air Stride Running Sneaker",
            price = "$135.00",
            priceValue = 135.00,
            category = "Shoes",
            gender = "Men",
            imageUrl = "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=600",
            rating = 4.9f,
            reviewCount = 310,
            isFavorite = true
        ),
        ClotheeProduct(
            id = "clothee-6",
            title = "Essential Utility Crossbody Bag",
            price = "$52.00",
            priceValue = 52.00,
            category = "Bag",
            gender = "Men",
            imageUrl = "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=600",
            rating = 4.5f,
            reviewCount = 76,
            isFavorite = false
        )
    )

    val cartItems = listOf(
        ClotheeCartItem(
            id = "cart-1",
            product = products[0],
            size = "M",
            colorName = "Lemon",
            quantity = 1
        ),
        ClotheeCartItem(
            id = "cart-2",
            product = products[1],
            size = "L",
            colorName = "Purple",
            quantity = 2
        )
    )

    val reviews = listOf(
        ClotheeReview(
            id = "rev-1",
            authorName = "Alex Robertson",
            rating = 5,
            date = "2 days ago",
            comment = "Exceptional quality fabric and fits true to size. The fleece lining is remarkably soft and holds warmth without feeling bulky.",
            avatarUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=200"
        ),
        ClotheeReview(
            id = "rev-2",
            authorName = "Marcus Silva",
            rating = 4,
            date = "1 week ago",
            comment = "Great streetwear silhouette. Clean stitching and the purple brand accent pops nicely.",
            avatarUrl = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=200"
        )
    )

    val defaultAddress = ClotheeAddress(
        id = "addr-1",
        street = "2715 Ash Dr. San Jose, South Dakota 83475",
        cityStateZip = "San Jose, SD 83475",
        phoneNumber = "(+1) 408 555-0128",
        isDefault = true
    )

    val trackingSteps = listOf(
        WgcClotheeTimelineStep(
            title = "Order Placed",
            subtitle = "28 May 2026, 10:30 AM",
            state = WgcClotheeStepState.COMPLETED
        ),
        WgcClotheeTimelineStep(
            title = "Order Confirmed",
            subtitle = "28 May 2026, 11:00 AM",
            state = WgcClotheeStepState.COMPLETED
        ),
        WgcClotheeTimelineStep(
            title = "Order Shipped",
            subtitle = "29 May 2026, 08:15 AM",
            state = WgcClotheeStepState.IN_PROGRESS
        ),
        WgcClotheeTimelineStep(
            title = "Delivered",
            subtitle = "Estimated 31 May 2026",
            state = WgcClotheeStepState.PENDING
        )
    )
}
