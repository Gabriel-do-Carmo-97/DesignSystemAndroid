package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Pílula de seleção de marca oficial do Laza (WgcBrandPill).
 * Apresenta ícone/logo sobre container branco e texto em negrito sobre superfície cinza suave (#F5F6FA).
 */
@Composable
fun WgcBrandPill(
    modifier: Modifier = Modifier,
    brandName: String,
    logoUrl: String? = null,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(
                if (isSelected) Color(WgcCoreDsColors.boutiquePrimaryLight)
                else Color(WgcCoreDsColors.boutiqueSurface)
            )
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.xs8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Caixa interna branca do logo
        Box(
            modifier = Modifier
                .size(WgcCoreDsSize.s40.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            if (!logoUrl.isNullOrEmpty()) {
                AsyncImageDefault(
                    image = logoUrl,
                    contentDescription = brandName,
                    modifier = Modifier.fillMaxSize().padding(WgcCoreDsSpacing.xxs4.dp)
                )
            } else {
                Text(
                    text = brandName.take(2).uppercase(),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) Color(WgcCoreDsColors.boutiquePrimary) else Color(WgcCoreDsColors.boutiqueDark)
                )
            }
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

        Text(
            text = brandName,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) Color(WgcCoreDsColors.boutiquePrimary) else Color(WgcCoreDsColors.boutiqueDark),
            modifier = Modifier.padding(end = WgcCoreDsSpacing.sm12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaBrandPillPreview() {
    WgcBrandPill(
        brandName = "Nike",
        isSelected = true
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaBrandPillUnselectedPreview() {
    WgcBrandPill(
        brandName = "Adidas",
        isSelected = false
    )
}
