package br.com.wgc.design_system.components.rating

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import java.util.Locale

/**
 * Barra de avaliação interativa com suporte a frações de meia estrela (0.5f) e nota textual.
 */
@Composable
fun WgcInteractiveRatingBar(
    rating: Float,
    onRatingChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    maxStars: Int = 5,
    showScoreText: Boolean = true,
    isReadOnly: Boolean = false
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs6.dp)
    ) {
        for (i in 1..maxStars) {
            val starIndex = i.toFloat()
            val isFull = rating >= starIndex
            val isHalf = rating >= (starIndex - 0.5f) && !isFull

            val icon = when {
                isFull -> Icons.Filled.Star
                isHalf -> Icons.AutoMirrored.Filled.StarHalf
                else -> Icons.Outlined.StarOutline
            }

            Icon(
                imageVector = icon,
                contentDescription = "Estrela $i",
                tint = if (isFull || isHalf) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant,
                modifier = Modifier
                    .size(28.dp)
                    .clickable(enabled = !isReadOnly) {
                        val newRating = if (rating == starIndex) starIndex - 0.5f else starIndex
                        onRatingChange(newRating.coerceAtLeast(0.5f))
                    }
            )
        }

        if (showScoreText) {
            Text(
                text = String.format(Locale.ROOT, "%.1f", rating),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
