package br.com.wgc.design_system.components.sections.items.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.R
import coil3.compose.AsyncImage
import java.math.BigDecimal


@Composable
fun ItemSectionHorizontalCard(
    modifier: Modifier = Modifier,
    model: ItemSectionCardModel
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = modifier
                .widthIn(min = 350.dp, max = 400.dp)
                .height(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = modifier
                    .width(imageSize)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF6200EE),
                                Color(0xFF03DAC5)
                            )
                        )
                    )
                    .fillMaxHeight()
            ) {
                AsyncImage(
                    model = model.image,
                    contentDescription = model.imageDescription,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(imageSize)
                        .offset(x = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.Center),
                    error = painterResource(id = R.drawable.baseline_add_box_24)
                )
            }
            Spacer(modifier = Modifier.width(imageSize / 2))
            Text(
                modifier = Modifier.padding(16.dp),
                text = model.description,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true, name = "Only Component")
@Composable
private fun CardDegradedHorizontalDescriptionPreview() = ItemSectionHorizontalCard(
    model = ItemSectionCardModel(
        name = LoremIpsum(5).values.first(),
        description = "",
        price = BigDecimal(149.99),
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
    )
)


@Preview(showBackground = true, showSystemUi = true, name = "Component and SystemUi")
@Composable
private fun ProductItemPrev2() = ItemSectionHorizontalCard(
    model = ItemSectionCardModel(
        name = LoremIpsum(5).values.first(),
        description = "",
        price = BigDecimal(149.99),
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
    )
)
