package br.com.wgc.design_system.components.cards.carddetail

import java.math.BigDecimal

data class ProductDetailModel(
    val image: String,
    val imageDescription: String,
    val name: String,
    val description: String? = null,
    val price: BigDecimal
) {
}