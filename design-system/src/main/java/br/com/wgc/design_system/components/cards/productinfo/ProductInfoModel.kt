package br.com.wgc.design_system.components.cards.productinfo

import androidx.annotation.DrawableRes

data class ProductInfoModel(
    @field:DrawableRes val image: Int,
    val imageDescription: String,
    val description: String,
)