package br.com.wgc.design_system.components.sections.items.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.R
import br.com.wgc.design_system.commons.toBrazilianCurrency
import coil3.compose.AsyncImage
import java.math.BigDecimal

@Composable
fun ItemSectionCard(
    modifier: Modifier = Modifier,
    model: ItemSectionCardModel
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = modifier
                .heightIn(min = 250.dp, max = 260.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF6200EE),
                                Color(0xFF03DAC5)
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = model.image,
                    contentDescription = "Imagem do produto",
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    error = painterResource(id = R.drawable.baseline_add_box_24)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = model.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = model.price.toBrazilianCurrency(),
                    fontSize = 14.sp,
                    maxLines = 1,
                    modifier = Modifier.padding(top = 8.dp),
                    fontWeight = FontWeight(400)
                )
            }
            if (model.description.isNotBlank()){
                Text(
                    text = model.description,
                    Modifier
                        .background(Color(0xFF6200EE))
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp,
                            top = 8.dp
                        ),
                    color = Color.White,
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Only Component")
@Composable
private fun SectionDescriptionItemCardPrev() = ItemSectionCard(
    model = ItemSectionCardModel(
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
        name = LoremIpsum(5).values.first(),
        price = BigDecimal(149.99),
        description = LoremIpsum(100).values.first()
    )
)


@Preview(showBackground = true, showSystemUi = true, name = "Component and SystemUi")
@Composable
private fun SectionDescriptionItemCardPrev2() = ItemSectionCard(
    model = ItemSectionCardModel(
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
        name = LoremIpsum(5).values.first(),
        price = BigDecimal(149.99),
        description = LoremIpsum(100).values.first()
    )
)
