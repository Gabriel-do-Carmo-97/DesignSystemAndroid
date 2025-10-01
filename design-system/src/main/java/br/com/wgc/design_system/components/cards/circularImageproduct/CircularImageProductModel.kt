package br.com.wgc.design_system.components.cards.circularImageproduct

import androidx.annotation.DrawableRes
import br.com.wgc.design_system.R
import java.math.BigDecimal

data class CircularImageProductModel(
    val title: String,
    val description: String = "",
    val price: BigDecimal,
    @field:DrawableRes val image: Int = R.drawable.ic_launcher_background
)
