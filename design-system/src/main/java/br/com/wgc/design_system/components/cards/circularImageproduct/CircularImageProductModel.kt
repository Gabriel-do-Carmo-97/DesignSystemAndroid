package br.com.wgc.design_system.components.cards.circularImageproduct

import java.math.BigDecimal

data class CircularImageProductModel(
    val title: String,
    val description: String = "",
    val price: BigDecimal,
    val image: String
)
