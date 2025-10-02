package br.com.wgc.design_system.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import br.com.wgc.design_system.components.cards.circularImageproduct.CircularImageProductDescriptionCard
import br.com.wgc.design_system.components.cards.circularImageproduct.CircularImageProductModel
import java.math.BigDecimal

@Composable
fun ProductCircularImageDescriptionSection(
    modifier: Modifier = Modifier,
    title: String,
    producs: List<CircularImageProductModel>
) {
    Column(modifier = modifier) {
        Text(
            title,
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
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(producs.size) { index ->
                CircularImageProductDescriptionCard(model = producs[index])
            }
        }

    }
}

@Preview(showBackground = true, name = "Only Component", widthDp = 1000)
@Composable
private fun ProductSectionHorizontalPreview() = ProductCircularImageDescriptionSection(
    title = "Promocoes",
    producs = listOf(
        CircularImageProductModel(
            title = "Chocolate",
            price = BigDecimal("3.99"),
            image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg"
        ),
        CircularImageProductModel(
            title = "Sorvete",
            price = BigDecimal("5.99"),
            image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg"
        ),
        CircularImageProductModel(
            title = "Bolo",
            price = BigDecimal("11.99"),
            image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg"
        )
    )
)

//
@Preview(showBackground = true, showSystemUi = true, name = "Component and SystemUi")
@Composable
private fun ProductSectionHorizontalPreview2() = ProductCircularImageDescriptionSection(
    title = "Promocoes",
    producs = listOf(
        CircularImageProductModel(
            title = "Chocolate",
            price = BigDecimal("3.99"),
            image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg"
        ),
        CircularImageProductModel(
            title = "Sorvete",
            price = BigDecimal("5.99"),
            image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg"
        ),
        CircularImageProductModel(
            title = "Bolo",
            price = BigDecimal("11.99"),
            image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg"
        )
    )
)
