package br.com.wgc.design_system.templates.screens.freshgrocery.model

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

data class FreshGroceryCategory(
    val id: String,
    val name: String,
    val icon: ImageVector,
    val isHighlighted: Boolean = false
)

data class FreshGroceryProductItem(
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

data class FreshGroceryFlashDeal(
    val title: String = "Flash Deal",
    val countdown: String = "08:21:30",
    val products: List<FreshGroceryProductItem>
)

data class FreshGroceryCartItem(
    val product: FreshGroceryProductItem,
    var quantity: Int = 1,
    val selectedColor: String = "Green",
    val selectedSize: String = "M"
)

object FreshGroceryMockData {
    val categories = listOf(
        FreshGroceryCategory("1", "Blouse", Icons.Default.Checkroom),
        FreshGroceryCategory("2", "Uniform", Icons.Default.LocalMall),
        FreshGroceryCategory("3", "Skirt", Icons.Default.ShoppingBag),
        FreshGroceryCategory("4", "Jacket", Icons.Default.Checkroom),
        FreshGroceryCategory("5", "Pants", Icons.Default.FitnessCenter),
        FreshGroceryCategory("6", "Dress", Icons.Default.Spa),
        FreshGroceryCategory("7", "Hoodie", Icons.Default.Checkroom),
        FreshGroceryCategory("8", "T-Shirt", Icons.Default.Face),
        FreshGroceryCategory("9", "Suit App", Icons.Default.Watch),
        FreshGroceryCategory("10", "More", Icons.Default.Add, isHighlighted = true)
    )

    val products = listOf(
        FreshGroceryProductItem(
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
        FreshGroceryProductItem(
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
        FreshGroceryProductItem(
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
        FreshGroceryProductItem(
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
        FreshGroceryProductItem(
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
        FreshGroceryProductItem(
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
