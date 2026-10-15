package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Card de produto minimalista do ecossistema Tassel (WgcCuratedProductCard).
 * Apresenta recipiente clean com cantos arredondados, botão de bookmark/favoritar flutuante,
 * identificador da marca, título e preço.
 */
@Composable
fun WgcCuratedProductCard(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    brand: String? = null,
    imageUrl: String? = null,
    isBookmarked: Boolean = false,
    onBookmarkClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(WgcCoreDsSize.S160.dp)
            .clickable(onClick = onClick)
    ) {
        // Container da Imagem com cantos suaves
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(WgcCoreDsSize.S180.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                .background(Color(WgcCoreDsColors.blueLight26))
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
                        .background(Color(WgcCoreDsColors.blueLight29)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title.take(2).uppercase(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(WgcCoreDsColors.blue37),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Botão de Bookmark flutuante
            IconButton(
                onClick = onBookmarkClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(WgcCoreDsSpacing.XS8.dp)
                    .size(WgcCoreDsSize.S32.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.9f))
            ) {
                Icon(
                    imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                    contentDescription = if (isBookmarked) "Remover dos salvos" else "Salvar produto",
                    tint = if (isBookmarked) Color(WgcCoreDsColors.blue37) else Color(WgcCoreDsColors.gray10),
                    modifier = Modifier.size(WgcCoreDsSize.S18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

        if (!brand.isNullOrEmpty()) {
            Text(
                text = brand.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = Color(WgcCoreDsColors.gray10),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXXS2.dp))
        }

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color(WgcCoreDsColors.grayDark9),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

        Text(
            text = price,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.grayDark9)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselProductCardPreview() {
    WgcCuratedProductCard(
        title = "Bershka Mom Jeans",
        price = "$34",
        brand = "Bershka",
        isBookmarked = false
    )
}
