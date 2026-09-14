package br.com.wgc.ds_templates.screens.stylish.model

/**
 * Modelos de dados para o ecossistema Stylish eCommerce UI Kit.
 */
data class StylishProductItem(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val price: String,
    val originalPrice: String? = null,
    val discountPercent: Int? = null,
    val imageUrl: String? = null,
    val rating: Float = 4.5f,
    val reviewCount: Int = 56890,
    val isFavorite: Boolean = false,
    val category: String = "Fashion"
)

data class StylishCartItem(
    val id: String,
    val product: StylishProductItem,
    val selectedSize: String = "7 UK",
    val selectedColor: String = "Black/Red",
    val quantity: Int = 1
)

data class StylishCategoryItem(
    val id: String,
    val name: String,
    val iconUrl: String? = null,
    val isSelected: Boolean = false
)

data class StylishBannerItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val discountBadge: String,
    val bannerImageUrl: String? = null
)

data class StylishUserProfile(
    val fullName: String = "Abhiraj Sisodiya",
    val email: String = "abhiraj@example.com",
    val avatarUrl: String? = null,
    val pincode: String = "450116",
    val address: String = "44/3 Ashok Nagar",
    val city: String = "Indore",
    val state: String = "Madhya Pradesh",
    val country: String = "India",
    val bankAccountNumber: String = "204356XXXXXXX",
    val accountHolderName: String = "Abhiraj Sisodiya",
    val ifscCode: String = "SBIN00428"
)

data class StylishPaymentOption(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val isSelected: Boolean = false
)
