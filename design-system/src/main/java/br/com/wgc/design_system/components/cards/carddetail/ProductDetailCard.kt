package br.com.wgc.design_system.components.cards.carddetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.R
import br.com.wgc.design_system.commons.toBrazilianCurrency
import coil3.compose.AsyncImage
import java.math.BigDecimal

@Composable
fun ProductDetailCard(
    modifier: Modifier = Modifier, productDetailModel: ProductDetailModel, elevation: Dp = 4.dp
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Column {
            AsyncImage(
                model = productDetailModel.image,
                contentDescription = productDetailModel.imageDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 100.dp),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
            ) {
                Text(text = productDetailModel.name)
                Text(text = productDetailModel.price.toBrazilianCurrency())
            }
            productDetailModel.description?.let {
                Text(
                    text = productDetailModel.description,
                    modifier = Modifier.padding(16.dp),
                    maxLines = if (expanded) Int.MAX_VALUE else 2,
                    overflow = if (expanded) TextOverflow.Visible else TextOverflow.Ellipsis
                )
            }
        }
    }
}


@Preview(showBackground = true, name = "Only Component")
@Composable
private fun ProductDetailCardPreview() = ProductDetailCard(
    productDetailModel = ProductDetailModel(
        image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg",
        imageDescription = "Imagem do produto",
        name = "Nome do produto",
        price = BigDecimal(149.99),
        description = "Descrição do produto"
    )
)


@Preview(showSystemUi = true, showBackground = true, name = "Component and SystemUi")
@Composable
private fun ProductDetailCardPreview2() = ProductDetailCard(
    productDetailModel = ProductDetailModel(
        image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg",
        imageDescription = "Imagem do produto",
        name = "Nome do produto",
        price = BigDecimal(149.99),
        description = "Descrição do produto"
    )
)