package br.com.wgc.design_system.components.sections.items.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemSectionCategory(
    modifier: Modifier = Modifier,
    name: String,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.secondary
    }

    val borderModifier = if (isSelected) {
        Modifier.border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(100))
    } else {
        Modifier
    }
    Text(
        modifier = modifier
            .clickable(onClick = onItemSelected)
            .then(borderModifier)
            .clip(RoundedCornerShape(100))
            .background(backgroundColor)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        text = name,
        maxLines = 1,
        color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
}


@Preview(showBackground = true)
@Composable
private fun ItemSectionCategoryPrev() {
    ItemSectionCategory(
        name = "Comida",
        isSelected = false,
        onItemSelected = {}
    )
}