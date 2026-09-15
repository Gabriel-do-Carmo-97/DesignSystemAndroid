package br.com.wgc.design_system.components.sections.items.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    isSelected: Boolean = false,
    onItemSelected: () -> Unit
) {
    val borderModifier = if (isSelected) {
        Modifier.border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary,
        ).background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
            .padding(all = 8.dp)

    } else {
        Modifier
    }

    Column(
        modifier = modifier
            .clickable(onClick = onItemSelected)
            .then(borderModifier)
            .widthIn(min = 32.dp, max = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = model.image,
            contentDescription = "Categoria ${model.name}",
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(shape = CircleShape),
            error = painterResource(id = R.drawable.baseline_add_box_24)
        )
        Text(
            text = model.name,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            maxLines = 1,
            fontSize = 12.sp,
            color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Unspecified
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
        ),
        isSelected = false,
        onItemSelected = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ItemSectionCircleCategoryPreview2() {
    ItemSectionCircleCategory(
        model = ItemSectionCircleCategoryModel(
            image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
            name = "Pizza"
        ),
        isSelected = true,
        onItemSelected = {}
    )
}