package br.com.wgc.design_system.components.sections.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.components.sections.items.category.ItemSectionCategory
import br.com.wgc.design_system.components.sections.items.category.ItemSectionCircleCategory
import br.com.wgc.design_system.components.sections.type.ItemSectionCategory
import br.com.wgc.design_system.mock.MockData

@Composable
fun SectionCategories(
    modifier: Modifier = Modifier,
    sectionModel: SectionCategoryModel
) {
    var selectedItemName by rememberSaveable { mutableStateOf<String?>(null) }
    Column(modifier = modifier) {
        Text(
            sectionModel.title,
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(start = 16.dp)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(
                items = sectionModel.items,
                key = { item -> item.name }
            ) { currentItem ->
                val isSelected = selectedItemName == currentItem.name
                when (sectionModel.itemType) {
                    ItemSectionCategory.CIRCLE -> ItemSectionCircleCategory(
                        model = currentItem,
                        isSelected = isSelected,
                        onItemSelected = {
                            selectedItemName = currentItem.name
                        }
                    )

                    ItemSectionCategory.HORIZONTAL -> ItemSectionCategory(
                        modifier = Modifier.padding(vertical = 8.dp),
                        name = currentItem.name,
                        isSelected = isSelected,
                        onItemSelected = {
                            selectedItemName = currentItem.name
                        }
                    )
                }
            }

        }
    }
}

    @Preview(showBackground = true, name = "WITH CIRCLE", widthDp = 500)
    @Composable
    private fun ProductSectionHorizontalPreview() = SectionCategories(
        sectionModel = SectionCategoryModel(
            title = "Promocoes",
            items = MockData.listItemSectionCircleCategoryModel,
            itemType = ItemSectionCategory.CIRCLE
        )
    )

    @Preview(showBackground = true, name = "WITH RETANCLE DEFAULT TITLE", widthDp = 500)
    @Composable
    private fun ProductSectionHorizontalPreview2() = SectionCategories(
        sectionModel = SectionCategoryModel(
            items = MockData.listItemSectionCircleCategoryModel,
            itemType = ItemSectionCategory.HORIZONTAL
        )
    )

