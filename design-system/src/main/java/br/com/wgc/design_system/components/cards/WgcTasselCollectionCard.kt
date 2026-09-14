package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card de coleção/categoria oficial do Tassel (WgcTasselCollectionCard).
 * Exibe blocos pastéis e minimalistas com cantos arredondados (ex: "On sale", "New in", "Clothing", "Shoes").
 */
@Composable
fun WgcTasselCollectionCard(
    modifier: Modifier = Modifier,
    title: String,
    backgroundColor: Color = Color(WgcCoreDsColors.tasselSurface),
    textColor: Color = Color(WgcCoreDsColors.tasselDark),
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(WgcCoreDsSize.s88.dp)
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.md16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselCollectionCardSalePreview() {
    WgcTasselCollectionCard(
        title = "On sale",
        backgroundColor = Color(WgcCoreDsColors.tasselSalePink),
        textColor = Color(WgcCoreDsColors.tasselSalePinkText)
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselCollectionCardNewInPreview() {
    WgcTasselCollectionCard(
        title = "New in",
        backgroundColor = Color(WgcCoreDsColors.tasselNewInPurple),
        textColor = Color(WgcCoreDsColors.tasselNewInPurpleText)
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselCollectionCardCategoryPreview() {
    WgcTasselCollectionCard(
        title = "Clothing"
    )
}
