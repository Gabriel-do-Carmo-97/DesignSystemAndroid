package br.com.wgc.ds_templates.screens.shopper.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalMall
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Watch
import androidx.compose.ui.graphics.vector.ImageVector

data class ShopperCategory(
    val id: String,
    val name: String,
    val icon: ImageVector,
    val isHighlighted: Boolean = false
)

data class ShopperProduct(
    val id: String,
    val title: String,
    val category: String,
    val price: String,
    val originalPrice: String? = null,
    val discountPercent: String? = null,
    val rating: String = "4.8",
    val reviewCount: Int = 120,
    val description: String = "Made with high-quality breathable fabric designed for everyday comfort and modern style.",
    val isFavorite: Boolean = false
)

data class ShopperFlashDeal(
    val title: String = "Flash Deal",
    val countdown: String = "08:21:30",
    val products: List<ShopperProduct>
)

data class ShopperCartItem(
    val product: ShopperProduct,
    var quantity: Int = 1,
    val selectedColor: String = "Green",
    val selectedSize: String = "M"
)

object ShopperMockData {
    val categories = listOf(
        ShopperCategory("1", "Blouse", Icons.Default.Checkroom),
        ShopperCategory("2", "Uniform", Icons.Default.LocalMall),
        ShopperCategory("3", "Skirt", Icons.Default.ShoppingBag),
        ShopperCategory("4", "Jacket", Icons.Default.Checkroom),
        ShopperCategory("5", "Pants", Icons.Default.FitnessCenter),
        ShopperCategory("6", "Dress", Icons.Default.Spa),
        ShopperCategory("7", "Hoodie", Icons.Default.Checkroom),
        ShopperCategory("8", "T-Shirt", Icons.Default.Face),
        ShopperCategory("9", "Suit App", Icons.Default.Watch),
        ShopperCategory("10", "More", Icons.Default.Add, isHighlighted = true)
    )

    val products = listOf(
        ShopperProduct(
            id = "sp1",
            title = "Oversized Cotton Tee",
            category = "T-Shirt",
            price = "$24.00",
            originalPrice = "$35.00",
            discountPercent = "-31%",
            rating = "4.9",
            reviewCount = 248,
            isFavorite = true
        ),
        ShopperProduct(
            id = "sp2",
            title = "Casual Streetwear Hoodie",
            category = "Hoodie",
            price = "$45.00",
            originalPrice = "$60.00",
            discountPercent = "-25%",
            rating = "4.8",
            reviewCount = 180,
            isFavorite = false
        ),
        ShopperProduct(
            id = "sp3",
            title = "Slim Fit Cargo Pants",
            category = "Pants",
            price = "$38.00",
            originalPrice = "$48.00",
            discountPercent = "-20%",
            rating = "4.7",
            reviewCount = 95,
            isFavorite = true
        ),
        ShopperProduct(
            id = "sp4",
            title = "Classic Bomber Jacket",
            category = "Jacket",
            price = "$68.00",
            originalPrice = "$89.00",
            discountPercent = "-23%",
            rating = "4.9",
            reviewCount = 310,
            isFavorite = false
        ),
        ShopperProduct(
            id = "sp5",
            title = "Minimalist Linen Blouse",
            category = "Blouse",
            price = "$29.00",
            originalPrice = "$40.00",
            discountPercent = "-27%",
            rating = "4.6",
            reviewCount = 74,
            isFavorite = false
        ),
        ShopperProduct(
            id = "sp6",
            title = "Pleated Midi Skirt",
            category = "Skirt",
            price = "$32.00",
            originalPrice = "$45.00",
            discountPercent = "-28%",
            rating = "4.8",
            reviewCount = 112,
            isFavorite = true
        )
    )
}
