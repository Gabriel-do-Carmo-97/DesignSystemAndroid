package br.com.wgc.ds_templates.screens.boutique.model

data class LazaProduct(
    val id: String,
    val title: String,
    val price: String,
    val priceValue: Double,
    val brand: String = "Nike",
    val category: String = "Men's Printed Pullover Hoodie",
    val description: String = "The Nike Throwback Pullover Hoodie is made from premium French terry fabric that blends a performance feel with casual everyday style.",
    val imageUrl: String? = null,
    val galleryImages: List<String> = emptyList(),
    val rating: Float = 4.8f,
    val reviewCount: Int = 110,
    val isFavorite: Boolean = false,
    val availableSizes: List<String> = listOf("S", "M", "L", "XL", "2XL")
)

data class LazaBrandItem(
    val id: String,
    val name: String,
    val logoUrl: String? = null
)

data class LazaCartItem(
    val id: String,
    val product: LazaProduct,
    val size: String = "M",
    val quantity: Int = 1,
    val taxInfo: String = "(-$4.00 Tax)"
) {
    val totalPrice: Double
        get() = product.priceValue * quantity
}

data class LazaReview(
    val id: String,
    val authorName: String,
    val rating: Float = 5.0f,
    val date: String = "13 Sep, 2026",
    val comment: String,
    val avatarUrl: String? = null
)

data class LazaAddress(
    val id: String,
    val name: String,
    val country: String = "United States",
    val city: String = "Chhatak, Sunamgonj 12/8AB",
    val phoneNumber: String = "+880 1453-987-992",
    val isDefault: Boolean = true
)

data class LazaPaymentCard(
    val id: String,
    val cardHolder: String,
    val cardNumber: String,
    val expDate: String,
    val cardType: String = "Visa"
)

object BoutiqueMockData {
    val brands = listOf(
        LazaBrandItem(
            id = "brand-adidas",
            name = "Adidas",
            logoUrl = "https://images.unsplash.com/photo-1518002171953-a080ee817e1f?w=100"
        ),
        LazaBrandItem(
            id = "brand-nike",
            name = "Nike",
            logoUrl = "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=100"
        ),
        LazaBrandItem(
            id = "brand-puma",
            name = "Puma",
            logoUrl = "https://images.unsplash.com/photo-1608231387042-66d1773070a5?w=100"
        ),
        LazaBrandItem(
            id = "brand-fila",
            name = "Fila",
            logoUrl = "https://images.unsplash.com/photo-1556905055-8f358a7a47b2?w=100"
        )
    )

    val products = listOf(
        LazaProduct(
            id = "laza-1",
            title = "Nike Sportswear Club Fleece",
            price = "$99",
            priceValue = 99.0,
            brand = "Nike",
            category = "Men's Printed Pullover Hoodie",
            description = "The Nike Throwback Pullover Hoodie is made from premium French terry fabric that blends a performance feel with casual everyday style.",
            imageUrl = "https://images.unsplash.com/photo-1556905055-8f358a7a47b2?w=600",
            galleryImages = listOf(
                "https://images.unsplash.com/photo-1556905055-8f358a7a47b2?w=600",
                "https://images.unsplash.com/photo-1548883354-7622d03aca27?w=600",
                "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?w=600"
            ),
            rating = 4.8f,
            reviewCount = 110,
            isFavorite = false
        ),
        LazaProduct(
            id = "laza-2",
            title = "Trail Running Jacket Nike Windrunner",
            price = "$130",
            priceValue = 130.0,
            brand = "Nike",
            category = "Water-Repellent Running Jacket",
            description = "Lightweight weather protection engineered with ventilated storm vents and packable utility pockets.",
            imageUrl = "https://images.unsplash.com/photo-1548883354-7622d03aca27?w=600",
            galleryImages = listOf(
                "https://images.unsplash.com/photo-1548883354-7622d03aca27?w=600",
                "https://images.unsplash.com/photo-1556905055-8f358a7a47b2?w=600"
            ),
            rating = 4.9f,
            reviewCount = 84,
            isFavorite = true
        ),
        LazaProduct(
            id = "laza-3",
            title = "Training Top Nike Sport Clash",
            price = "$45",
            priceValue = 45.0,
            brand = "Nike",
            category = "Dri-FIT Breathable Athletic Tee",
            description = "Dri-FIT technology moves sweat away from your skin for quicker evaporation, helping you stay dry and comfortable.",
            imageUrl = "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?w=600",
            rating = 4.7f,
            reviewCount = 92,
            isFavorite = false
        ),
        LazaProduct(
            id = "laza-4",
            title = "Puma Classic Suede Streetwear",
            price = "$85",
            priceValue = 85.0,
            brand = "Puma",
            category = "Heritage Low Top Sneaker",
            description = "Iconic silhouette featuring rich suede upper and signature Puma Formstrip detailing.",
            imageUrl = "https://images.unsplash.com/photo-1608231387042-66d1773070a5?w=600",
            rating = 4.6f,
            reviewCount = 64,
            isFavorite = false
        ),
        LazaProduct(
            id = "laza-5",
            title = "Adidas Originals Trefoil Crew",
            price = "$75",
            priceValue = 75.0,
            brand = "Adidas",
            category = "Casual Everyday Sweatshirt",
            description = "Soft French terry construction with bold Trefoil chest graphic and ribbed cuffs.",
            imageUrl = "https://images.unsplash.com/photo-1518002171953-a080ee817e1f?w=600",
            rating = 4.8f,
            reviewCount = 142,
            isFavorite = true
        )
    )

    val cartItems = listOf(
        LazaCartItem(
            id = "lcart-1",
            product = products[0],
            size = "L",
            quantity = 1,
            taxInfo = "(-$4.00 Tax)"
        ),
        LazaCartItem(
            id = "lcart-2",
            product = products[1],
            size = "M",
            quantity = 1,
            taxInfo = "(-$5.50 Tax)"
        )
    )

    val reviews = listOf(
        LazaReview(
            id = "lrev-1",
            authorName = "Ronald Richards",
            rating = 4.8f,
            date = "13 Sep, 2026",
            comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque malesuada eget vitae amet...",
            avatarUrl = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=200"
        ),
        LazaReview(
            id = "lrev-2",
            authorName = "Jenny Wilson",
            rating = 5.0f,
            date = "10 Sep, 2026",
            comment = "Great fit and quality fabric. Would definitely buy again in different colors!",
            avatarUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=200"
        )
    )

    val defaultAddress = LazaAddress(
        id = "laddr-1",
        name = "Mradul S.",
        country = "United States",
        city = "Chhatak, Sunamgonj 12/8AB",
        phoneNumber = "+880 1453-987-992",
        isDefault = true
    )

    val defaultCard = LazaPaymentCard(
        id = "lcard-1",
        cardHolder = "Mradul Sahu",
        cardNumber = "Visa Classic **** 7690",
        expDate = "05/28",
        cardType = "Visa"
    )
}
