package br.com.wgc.design_system.components.sections

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductSectionHorizontal(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            "Promoções",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(
                400
            )
        )
        Row(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 16.dp
                )
                .fillMaxWidth()
                .horizontalScroll(state = rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
//            CardDegradedAndCircleImage()
//            CardDegradedAndCircleImage()
//            CardDegradedAndCircleImage()
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true, name = "Only Component", widthDp = 1000)
@Composable
private fun ProductSectionHorizontalPreview() = ProductSectionHorizontal()

@Preview(showBackground = true, showSystemUi = true, name = "Component and SystemUi")
@Composable
private fun ProductSectionHorizontalPreview2() = ProductSectionHorizontal()
