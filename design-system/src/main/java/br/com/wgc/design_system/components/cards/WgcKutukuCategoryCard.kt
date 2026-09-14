package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Card horizontal de categoria Kutuku (WgcKutukuCategoryCard).
 * Exibe título, contagem de produtos e foto com suporte a layout invertido (imagem à esquerda ou direita).
 */
@Composable
fun WgcKutukuCategoryCard(
    modifier: Modifier = Modifier,
    title: String,
    productCountText: String,
    imageUrl: String? = null,
    isImageOnLeft: Boolean = false,
    backgroundColor: Color = Color(WgcCoreDsColors.kutukuBackground),
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isImageOnLeft) {
            CategoryCardImage(
                imageUrl = imageUrl,
                title = title,
                modifier = Modifier
                    .width(140.dp)
                    .fillMaxHeight()
            )
            CategoryCardText(
                title = title,
                productCountText = productCountText,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = WgcCoreDsSpacing.md.dp),
                horizontalAlignment = Alignment.Start
            )
        } else {
            CategoryCardText(
                title = title,
                productCountText = productCountText,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = WgcCoreDsSpacing.md.dp),
                horizontalAlignment = Alignment.Start
            )
            CategoryCardImage(
                imageUrl = imageUrl,
                title = title,
                modifier = Modifier
                    .width(140.dp)
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
private fun CategoryCardText(
    title: String,
    productCountText: String,
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = horizontalAlignment
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.kutukuDark)
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs.dp))
        Text(
            text = productCountText,
            style = MaterialTheme.typography.bodySmall,
            color = Color(WgcCoreDsColors.kutukuSecondaryText)
        )
    }
}

@Composable
private fun CategoryCardImage(
    imageUrl: String?,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (!imageUrl.isNullOrEmpty()) {
            AsyncImageDefault(
                image = imageUrl,
                contentDescription = title,
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(WgcCoreDsColors.kutukuPrimaryLight).copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title.take(1).uppercase(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.kutukuPrimary)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuCategoryCardPreview() {
    WgcKutukuCategoryCard(
        title = "New Arrivals",
        productCountText = "208 Product",
        isImageOnLeft = false
    )
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuCategoryCardInvertedPreview() {
    WgcKutukuCategoryCard(
        title = "Clothes",
        productCountText = "358 Product",
        isImageOnLeft = true
    )
}
