package br.com.wgc.design_system.components.sections.items.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemSectionCategory(
    modifier: Modifier = Modifier,
    name: String,
) {
    Text(
        modifier = modifier
            .background(Color.Red, shape = CircleShape)
            .padding(4.dp),
        text = name,
        maxLines = 1,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
}

@Preview(showBackground = true)
@Composable
private fun ItemSectionCategoryPrev() {
    ItemSectionCategory(
        name = "Comida"
    )
}