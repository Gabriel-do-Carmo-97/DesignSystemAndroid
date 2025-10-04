package br.com.wgc.design_system.components.sections.category

import br.com.wgc.design_system.components.sections.items.category.ItemSectionCircleCategoryModel
import br.com.wgc.design_system.components.sections.type.ItemSectionCategory

data class SectionCategoryModel(
    val title: String,
    val items: List<ItemSectionCircleCategoryModel>,
    val itemType: ItemSectionCategory
)