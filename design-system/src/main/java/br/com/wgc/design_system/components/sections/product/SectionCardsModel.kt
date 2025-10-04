package br.com.wgc.design_system.components.sections.product

import br.com.wgc.design_system.components.sections.items.product.ItemSectionCardModel
import br.com.wgc.design_system.components.sections.type.ItemSectionType

data class SectionCardsModel(
    val title: String,
    val items: List<ItemSectionCardModel>,
    val itemType: ItemSectionType
)
