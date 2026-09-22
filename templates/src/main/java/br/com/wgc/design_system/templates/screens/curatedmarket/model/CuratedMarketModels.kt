package br.com.wgc.design_system.templates.screens.curatedmarket.model

data class TasselProduct(
    val id: String,
    val title: String,
    val brand: String = "Bershka",
    val price: String,
    val priceValue: Double,
    val imageUrl: String? = null,
    val galleryImages: List<String> = emptyList(),
    val colorOptions: List<String> = listOf("Blue", "Black", "Light Blue"),
    val sizeOptions: List<String> = listOf("26 - XS", "28 - S", "30 - M", "32 - L"),
    val details: String = "High-waist mom fit jeans with classic five pockets and rigid cotton construction.",
    val description: String = "Crafted from 100% sustainable organic cotton. Designed with a timeless tapered leg and vintage washed finish.",
    val isBookmarked: Boolean = false
)

data class TasselCollectionItem(
    val id: String,
    val title: String,
    val type: String = "category"
)

data class TasselStore(
    val id: String,
    val name: String,
    val category: String = "Fashion & Apparel",
    val followers: String = "124k Followers",
    val logoUrl: String? = null,
    val coverImageUrl: String? = null
)

data class TasselOrder(
    val id: String,
    val statusText: String = "Your package is on it's way",
    val arrivalEstimate: String = "Arrival estimate: April 15",
    val currentStep: Int = 2,
    val totalSteps: Int = 4,
    val product: TasselProduct,
    val selectedDetails: String = "28 - S | Blue | ID:0706502"
)

data class TasselUserProfile(
    val name: String = "Ava Johnson",
    val handle: String = "@avajohnson",
    val avatarUrl: String? = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=200",
    val followingCount: Int = 10,
    val savedCount: Int = 24,
    val ordersCount: Int = 3
)

object CuratedMarketMockData {
    val profile = TasselUserProfile()

    val products = listOf(
        TasselProduct(
            id = "tassel-1",
            title = "Bershka Mom Jeans",
            brand = "Bershka",
            price = "$34",
            priceValue = 34.0,
            imageUrl = "https://images.unsplash.com/photo-1541099649105-f69ad21f3246?w=600",
            galleryImages = listOf(
                "https://images.unsplash.com/photo-1541099649105-f69ad21f3246?w=600",
                "https://images.unsplash.com/photo-1582552938357-32b906df40cb?w=600",
                "https://images.unsplash.com/photo-1576995853123-5a10305d93c0?w=600"
            ),
            colorOptions = listOf("Blue", "Black", "Indigo"),
            sizeOptions = listOf("26 - XS", "28 - S", "30 - M", "32 - L"),
            details = "High-waist mom fit jeans with classic five pockets and rigid cotton construction.",
            description = "Crafted from 100% sustainable organic cotton. Designed with a timeless tapered leg and vintage washed finish.",
            isBookmarked = false
        ),
        TasselProduct(
            id = "tassel-2",
            title = "Oversized Denim Trucker Jacket",
            brand = "Pull&Bear",
            price = "$59",
            priceValue = 59.0,
            imageUrl = "https://images.unsplash.com/photo-1576995853123-5a10305d93c0?w=600",
            galleryImages = listOf(
                "https://images.unsplash.com/photo-1576995853123-5a10305d93c0?w=600",
                "https://images.unsplash.com/photo-1541099649105-f69ad21f3246?w=600"
            ),
            colorOptions = listOf("Vintage Blue", "Washed Grey"),
            sizeOptions = listOf("S", "M", "L"),
            details = "Drop shoulder denim jacket with silver hardware and welt pockets.",
            description = "Relaxed streetwear fit cut from heavy durable twill denim.",
            isBookmarked = true
        ),
        TasselProduct(
            id = "tassel-3",
            title = "Minimal Ribbed Crop Tank",
            brand = "Curated Brand",
            price = "$18",
            priceValue = 18.0,
            imageUrl = "https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?w=600",
            colorOptions = listOf("White", "Stone", "Sage"),
            sizeOptions = listOf("XS", "S", "M", "L"),
            isBookmarked = false
        ),
        TasselProduct(
            id = "tassel-4",
            title = "Pleated Wide-Leg Linen Trousers",
            brand = "Mango",
            price = "$68",
            priceValue = 68.0,
            imageUrl = "https://images.unsplash.com/photo-1509631179647-0177331693ae?w=600",
            colorOptions = listOf("Ecru", "Khaki", "Navy"),
            sizeOptions = listOf("28", "30", "32"),
            isBookmarked = true
        ),
        TasselProduct(
            id = "tassel-5",
            title = "Leather Chunky Platform Loafers",
            brand = "Stradivarius",
            price = "$75",
            priceValue = 75.0,
            imageUrl = "https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=600",
            colorOptions = listOf("Black Gloss", "Burgundy"),
            sizeOptions = listOf("36", "37", "38", "39", "40"),
            isBookmarked = false
        )
    )

    val collections = listOf(
        TasselCollectionItem(id = "col-sale", title = "On sale", type = "sale"),
        TasselCollectionItem(id = "col-new", title = "New in", type = "new_in"),
        TasselCollectionItem(id = "col-clothing", title = "Clothing", type = "category"),
        TasselCollectionItem(id = "col-shoes", title = "Shoes", type = "category"),
        TasselCollectionItem(id = "col-bags", title = "Bags", type = "category"),
        TasselCollectionItem(id = "col-accessories", title = "Accessories", type = "category")
    )

    val stores = listOf(
        TasselStore(
            id = "store-bershka",
            name = "Bershka",
            category = "Denim & Streetwear",
            followers = "1.2M Followers",
            coverImageUrl = "https://images.unsplash.com/photo-1441986300917-64674bd600d8?w=600"
        ),
        TasselStore(
            id = "store-curated",
            name = "Curated Brand",
            category = "Modern Essentials",
            followers = "3.8M Followers",
            coverImageUrl = "https://images.unsplash.com/photo-1441984904996-e0b6ba687e04?w=600"
        ),
        TasselStore(
            id = "store-pullbear",
            name = "Pull&Bear",
            category = "Casual Youthwear",
            followers = "980k Followers",
            coverImageUrl = "https://images.unsplash.com/photo-1472851294608-062f824d29cc?w=600"
        )
    )

    val currentOrder = TasselOrder(
        id = "0706502",
        statusText = "Your package is on it's way",
        arrivalEstimate = "Arrival estimate: April 15",
        currentStep = 2,
        totalSteps = 4,
        product = products[0],
        selectedDetails = "28 - S | Blue | ID:0706502"
    )
}
