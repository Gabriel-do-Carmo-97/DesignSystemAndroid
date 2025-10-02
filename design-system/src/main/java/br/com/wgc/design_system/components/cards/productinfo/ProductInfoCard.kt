package br.com.wgc.design_system.components.cards.productinfo

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


@Composable
fun ProductInfoCard(
    modifier: Modifier = Modifier,
    model: ProductInfoModel
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
private fun CardDegradedHorizontalDescriptionPreview() = ProductInfoCard(
    model = ProductInfoModel(
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
        imageDescription = LoremIpsum(5).values.first(),
        description = LoremIpsum(100).values.first()
    )
)


@Preview(showBackground = true, showSystemUi = true, name = "Component and SystemUi")
@Composable
private fun ProductItemPrev2() = ProductInfoCard(
    model = ProductInfoModel(
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
        imageDescription = LoremIpsum(5).values.first(),
        description = LoremIpsum(100).values.first()
    )
)
