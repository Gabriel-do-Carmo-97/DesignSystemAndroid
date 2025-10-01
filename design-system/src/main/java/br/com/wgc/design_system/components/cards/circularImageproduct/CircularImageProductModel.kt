package br.com.wgc.design_system.components.cards.circularImageproduct

import androidx.annotation.DrawableRes
import br.com.wgc.design_system.R

data class CircularImageProductModel(
    val title: String,
    val description: String = "",
    val price: String,
    @field:DrawableRes val image: Int = R.drawable.ic_launcher_background
)
