package br.com.wgc.design_system.components.feedback

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Componente de classificação por estrelas (WgcRatingBar).
 * Exibe de 1 a 5 estrelas proporcionais com texto opcional de nota e quantidade de avaliações.
 */
@Composable
fun WgcRatingBar(
    modifier: Modifier = Modifier,
    rating: Float = 4.5f,
    maxStars: Int = 5,
    reviewCount: Int? = null,
    starColor: Color = Color(WgcCoreDsColors.trendFashionGold),
    showRatingText: Boolean = true
) {
    val clampedRating = rating.coerceIn(0f, maxStars.toFloat())
    val description = "Avaliação $clampedRating de $maxStars estrelas" +
        (reviewCount?.let { " com $it avaliações" } ?: "")

    Row(
        modifier = modifier.semantics {
            contentDescription = description
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..maxStars) {
            val starIcon = when {
                clampedRating >= i -> Icons.Filled.Star
                clampedRating >= i - 0.5f -> Icons.AutoMirrored.Filled.StarHalf
                else -> Icons.Outlined.StarOutline
            }
            Icon(
                imageVector = starIcon,
                contentDescription = null,
                tint = starColor,
                modifier = Modifier.size(16.dp)
            )
            if (i < maxStars) {
                Spacer(modifier = Modifier.width(2.dp))
            }
        }

        if (showRatingText) {
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs.dp))
            Text(
                text = String.format("%.1f", clampedRating),
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        if (reviewCount != null) {
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs.dp))
            Text(
                text = "($reviewCount)",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.textSecondary)
            )
        }
    }
}

@Preview(name = "Rating Bar Preview", showBackground = true)
@Composable
private fun WgcRatingBarPreview() {
    Row(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
        WgcRatingBar(
            rating = 4.5f,
            reviewCount = 56890
        )
    }
}
