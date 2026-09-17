package br.com.wgc.design_system.components.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Pílula de categoria do ecossistema Nexkart (WgcGadgetShopCategoryPill).
 * Apresenta fundo pastel característico (Beauty, Gadgets, Games, Cine, Fashion),
 * rótulo legível em negrito e suporte a seleção.
 */
@Composable
fun WgcGadgetShopCategoryPill(
    modifier: Modifier = Modifier,
    title: String,
    backgroundColor: Color = Color(WgcCoreDsColors.gadgetShopCatBeauty),
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
            .background(
                if (isSelected) Color(WgcCoreDsColors.gadgetShopPrimary) else backgroundColor
            )
            .clickable(onClick = onClick)
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = if (isSelected) Color.White else Color(WgcCoreDsColors.gadgetShopDark)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartCategoryPillPreview() {
    Row {
        WgcGadgetShopCategoryPill(
            title = "Beauty",
            backgroundColor = Color(WgcCoreDsColors.gadgetShopCatBeauty),
            isSelected = false
        )
        Spacer(modifier = Modifier.width(8.dp))
        WgcGadgetShopCategoryPill(
            title = "Gadgets",
            backgroundColor = Color(WgcCoreDsColors.gadgetShopCatGadgets),
            isSelected = true
        )
    }
}
