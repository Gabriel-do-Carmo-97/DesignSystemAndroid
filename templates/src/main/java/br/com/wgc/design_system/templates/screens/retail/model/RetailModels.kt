package br.com.wgc.design_system.templates.screens.retail.model

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.components.tracking.WgcKutukuStepStatus

data class KutukuProduct(
    val id: String,
    val title: String,
    val subtitle: String,
    val price: String,
    val imageUrl: String? = null,
    val rating: Float = 4.8f,
    val reviewCount: Int = 320,
    val isFavorite: Boolean = false,
    val description: String = "Premium handcrafted luxury product crafted with finest materials and tailored for everyday elegance.",
    val availableColors: List<Color> = listOf(
        Color(WgcCoreDsColors.productTan),
        Color(WgcCoreDsColors.retailDark),
        Color(WgcCoreDsColors.productTeal),
        Color(WgcCoreDsColors.productGreen)
    ),
    val inStock: Boolean = true
)

data class KutukuCategoryItem(
    val id: String,
    val title: String,
    val productCountText: String,
    val imageUrl: String? = null,
    val isImageOnLeft: Boolean = false
)

data class KutukuCartItem(
    val id: String,
    val title: String,
    val colorVariant: String,
    val price: String,
    val priceValue: Double,
    val quantity: Int = 1,
    val isSelected: Boolean = true,
    val imageUrl: String? = null
)

data class KutukuTrackingStep(
    val title: String,
    val subtitle: String,
    val time: String,
    val status: WgcKutukuStepStatus
)

data class KutukuMessageItem(
    val id: String,
    val senderName: String,
    val lastMessage: String,
    val timeAgo: String,
    val unreadCount: Int = 0,
    val avatarUrl: String? = null
)

data class KutukuActivityUser(
    val name: String,
    val avatarUrl: String? = null
)

object RetailMockData {
    val sampleProducts = listOf(
        KutukuProduct(
            id = "1",
            title = "The Mirac Jiz",
            subtitle = "Lisa Robber",
            price = "$195.00",
            imageUrl = "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=500"
        ),
        KutukuProduct(
            id = "2",
            title = "Meriza Kiles",
            subtitle = "Gazuna Resika",
            price = "$143.45",
            imageUrl = "https://images.unsplash.com/photo-1590874103328-eac38a683ce7?w=500",
            isFavorite = true
        ),
        KutukuProduct(
            id = "3",
            title = "Box Bag Linar 1883",
            subtitle = "Upbox Bag",
            price = "$35.25",
            imageUrl = "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=500"
        ),
        KutukuProduct(
            id = "4",
            title = "Box Headphone 234",
            subtitle = "Upbox Bag",
            price = "$66.00",
            imageUrl = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500"
        )
    )

    val sampleCategories = listOf(
        KutukuCategoryItem(
            id = "cat_1",
            title = "New Arrivals",
            productCountText = "208 Product",
            imageUrl = "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?w=500",
            isImageOnLeft = false
        ),
        KutukuCategoryItem(
            id = "cat_2",
            title = "Clothes",
            productCountText = "358 Product",
            imageUrl = "https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?w=500",
            isImageOnLeft = true
        ),
        KutukuCategoryItem(
            id = "cat_3",
            title = "Bags",
            productCountText = "160 Product",
            imageUrl = "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=500",
            isImageOnLeft = false
        ),
        KutukuCategoryItem(
            id = "cat_4",
            title = "Shoese",
            productCountText = "230 Product",
            imageUrl = "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=500",
            isImageOnLeft = true
        ),
        KutukuCategoryItem(
            id = "cat_5",
            title = "Electronics",
            productCountText = "172 Product",
            imageUrl = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500",
            isImageOnLeft = false
        )
    )

    val sampleCartItems = listOf(
        KutukuCartItem(
            id = "cart_1",
            title = "Bix Bag Limited Edition 229",
            colorVariant = "Berown",
            price = "$67.00",
            priceValue = 67.00,
            quantity = 1,
            isSelected = true,
            imageUrl = "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=500"
        ),
        KutukuCartItem(
            id = "cart_2",
            title = "Box Headphone 132",
            colorVariant = "Berown",
            price = "$26.00",
            priceValue = 26.00,
            quantity = 1,
            isSelected = true,
            imageUrl = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500"
        ),
        KutukuCartItem(
            id = "cart_3",
            title = "BoxHeadphone 345",
            colorVariant = "Berown",
            price = "$32.00",
            priceValue = 32.00,
            quantity = 1,
            isSelected = true,
            imageUrl = "https://images.unsplash.com/photo-1484704849700-f032a568e944?w=500"
        )
    )

    val sampleTrackingSteps = listOf(
        KutukuTrackingStep(
            title = "Upbox Bag",
            subtitle = "Shop",
            time = "02:50 PM",
            status = WgcKutukuStepStatus.COMPLETED
        ),
        KutukuTrackingStep(
            title = "On the way",
            subtitle = "Delivery",
            time = "03:20 PM",
            status = WgcKutukuStepStatus.IN_PROGRESS
        ),
        KutukuTrackingStep(
            title = "5482 Adobe Falls Rd #15San Diego,...",
            subtitle = "Houser",
            time = "03:45 PM",
            status = WgcKutukuStepStatus.PENDING
        )
    )

    val sampleActivities = listOf(
        KutukuActivityUser(name = "Kristine", avatarUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=150"),
        KutukuActivityUser(name = "Kay", avatarUrl = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=150"),
        KutukuActivityUser(name = "Cheryl", avatarUrl = "https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=150"),
        KutukuActivityUser(name = "Jeen", avatarUrl = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=150")
    )

    val sampleMessages = listOf(
        KutukuMessageItem(
            id = "msg_1",
            senderName = "Jhone Endrue",
            lastMessage = "Hello hw are you? I am going to market. Do you want shopping?",
            timeAgo = "23 min",
            unreadCount = 2,
            avatarUrl = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=150"
        ),
        KutukuMessageItem(
            id = "msg_2",
            senderName = "Jihane Luande",
            lastMessage = "We are on the runways at the military hangar, there is a plane in it.",
            timeAgo = "40 min",
            unreadCount = 1,
            avatarUrl = "https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=150"
        ),
        KutukuMessageItem(
            id = "msg_3",
            senderName = "Broman Alexander",
            lastMessage = "I received my new watch that I ordered from Amazon.",
            timeAgo = "1 hr",
            unreadCount = 0,
            avatarUrl = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=150"
        ),
        KutukuMessageItem(
            id = "msg_4",
            senderName = "Zack Jr",
            lastMessage = "I just arrived in front of the school. I'm waiting for you hurry up!",
            timeAgo = "1 hr",
            unreadCount = 0,
            avatarUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=150"
        )
    )
}
