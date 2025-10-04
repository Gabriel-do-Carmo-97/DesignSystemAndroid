package br.com.wgc.design_system.components.sections.items.product

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import java.math.BigDecimal

data class ItemSectionCardModel(
    val name : String,
    val image: String,
    val description: String = LoremIpsum(30).values.first(),
    val price: BigDecimal,
    val imageDescription: String = ""
)