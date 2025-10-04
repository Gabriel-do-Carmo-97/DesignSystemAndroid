package br.com.wgc.design_system.components.sections.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.components.sections.items.category.ItemSectionCircleCategory
import br.com.wgc.design_system.components.sections.items.category.ItemSectionCircleCategoryModel
import br.com.wgc.design_system.components.sections.type.ItemSectionCategory

@Composable
fun SectionCategories(
    modifier: Modifier = Modifier,
    sectionModel: SectionCategoryModel
) {
    Column(modifier = modifier) {
        Text(
            sectionModel.title,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(
                400
            )
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(sectionModel.items.size) { index ->
                when (sectionModel.itemType) {
                    ItemSectionCategory.CIRCLE -> ItemSectionCircleCategory(
                        model = sectionModel.items[index]
                    )
                    ItemSectionCategory.HORIZONTAL -> Unit
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
        items = listOf(
            ItemSectionCircleCategoryModel(
                name = "Hamburguer",
                image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
            ),
            ItemSectionCircleCategoryModel(
                name = "Hamburguer",
                image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
            ),
            ItemSectionCircleCategoryModel(
                name = "Hamburguer",
                image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
            ),
            ItemSectionCircleCategoryModel(
                name = "Hamburguer",
                image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
            )
        ),
        itemType = ItemSectionCategory.CIRCLE
    )
)

