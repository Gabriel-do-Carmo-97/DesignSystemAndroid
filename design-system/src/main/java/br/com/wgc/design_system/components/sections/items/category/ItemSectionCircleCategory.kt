package br.com.wgc.design_system.components.sections.items.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.R
import coil3.compose.AsyncImage

@Composable
fun ItemSectionCircleCategory(
    modifier: Modifier = Modifier,
    model: ItemSectionCircleCategoryModel,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = model.image,
            contentDescription = "Imagem do produto",
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(shape = CircleShape),
            error = painterResource(id = R.drawable.baseline_add_box_24)
        )
        Text(
            text = model.name,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp),
            fontWeight = FontWeight.Bold,

        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemSectionCircleCategoryPreview() {
    ItemSectionCircleCategory(
        model = ItemSectionCircleCategoryModel(
            image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
            name = "Pizza"
        )
    )
}