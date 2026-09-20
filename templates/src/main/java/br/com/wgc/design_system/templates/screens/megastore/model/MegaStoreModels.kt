package br.com.wgc.design_system.templates.screens.megastore.model

/**
 * Modelo de Produto para a loja Shoppe.
 */
data class ShoppeProductItem(
    val id: String,
    val title: String,
    val category: String = "Clothing",
    val price: String = "$34.00",
    val originalPrice: String? = "$45.00",
    val discountPercent: Int? = 25,
    val rating: Float = 4.8f,
    val reviewCount: Int = 124,
    val imageUrl: String = "https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?w=600",
    val description: String = "Soft organic cotton, premium tailored finish suitable for daily casual wear.",
    val sizes: List<String> = listOf("S", "M", "L", "XL"),
    val colorsHex: List<String> = listOf("#004CFF", "#202020", "#DFE9FF", "#F1B11C")
)

/**
 * Categoria de moda Shoppe.
 */
data class ShoppeCategoryItem(
    val id: String,
    val name: String,
    val itemCount: Int = 120
)

/**
 * Item de Story de moda.
 */
data class ShoppeStoryItem(
    val id: String,
    val name: String,
    val imageUrl: String,
    val isLive: Boolean = false,
    val hasUnseen: Boolean = true
)

/**
 * Item no Carrinho de Compras Shoppe.
 */
data class ShoppeCartItem(
    val id: String,
    val product: ShoppeProductItem,
    val selectedColor: String = "#004CFF",
    val selectedSize: String = "M",
    val quantity: Int = 1
)

/**
 * Cupom / Voucher Shoppe.
 */
data class ShoppeVoucherItem(
    val id: String,
    val discountTitle: String,
    val minSpend: String,
    val expiryDate: String,
    val isCollected: Boolean = false
)

/**
 * Mensagem de Chat do Atendimento ao Cliente Shoppe.
 */
data class ShoppeChatMessage(
    val id: String,
    val senderName: String,
    val text: String,
    val timestamp: String,
    val isFromUser: Boolean,
    val attachedVoucher: ShoppeVoucherItem? = null
)
