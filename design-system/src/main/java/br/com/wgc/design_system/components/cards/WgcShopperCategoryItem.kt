package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Átomo / Molécula WgcShopperCategoryItem:
 * Pílula / ícone circular suave de categoria com ícone centralizado e título abaixo.
 * Suporta modo "More" com cor primária verde destacada.
 */
@Composable
fun WgcShopperCategoryItem(
    title: String,
    icon: ImageVector = Icons.Default.Add,
    isHighlighted: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val bgColor = if (isHighlighted) {
        Color(WgcCoreDsColors.shopperPrimary)
    } else {
        Color(WgcCoreDsColors.shopperSurface)
    }

    val iconColor = if (isHighlighted) {
        Color.White
    } else {
        Color(WgcCoreDsColors.shopperPrimary)
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.xxs4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(WgcCoreDsSize.s48.dp)
                .clip(CircleShape)
                .background(bgColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = iconColor,
                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isHighlighted) FontWeight.Bold else FontWeight.Medium,
            color = if (isHighlighted) Color(WgcCoreDsColors.shopperPrimary) else Color(WgcCoreDsColors.shopperDark),
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopperCategoryItemPreview() {
    WgcShopperCategoryItem(
        title = "Dress",
        isHighlighted = false
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcShopperCategoryItemHighlightedPreview() {
    WgcShopperCategoryItem(
        title = "More",
        isHighlighted = true
    )
}
