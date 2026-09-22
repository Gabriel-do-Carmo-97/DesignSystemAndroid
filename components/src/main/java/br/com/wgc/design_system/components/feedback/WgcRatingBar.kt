package br.com.wgc.design_system.components.feedback

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Componente corporativo de classificação por estrelas (WgcRatingBar).
 * Suporta modo estático de leitura e modo interativo com State Hoisting.
 *
 * @param modifier Modificador de layout
 * @param rating Nota atual (de 0 até [maxStars])
 * @param maxStars Quantidade total de estrelas (padrão 5)
 * @param reviewCount Quantidade opcional de avaliações exibida entre parênteses
 * @param starColor Cor das estrelas preenchidas
 * @param showRatingText Define se a nota textual é exibida
 * @param isInteractive Se verdadeiro, permite selecionar estrelas por clique
 * @param onRatingChange Callback invocado quando uma nova nota é selecionada
 * @param starSize Tamanho de cada ícone de estrela
 * @param starSpacing Espaçamento entre cada estrela
 */
@Suppress("LongParameterList", "LongMethod")
@Composable
fun WgcRatingBar(
    modifier: Modifier = Modifier,
    rating: Float = 4.5f,
    maxStars: Int = 5,
    reviewCount: Int? = null,
    starColor: Color = Color(WgcCoreDsColors.trendFashionGold),
    showRatingText: Boolean = true,
    isInteractive: Boolean = false,
    onRatingChange: ((Float) -> Unit)? = null,
    starSize: Dp = WgcCoreDsSpacing.md.dp,
    starSpacing: Dp = WgcCoreDsSpacing.xxs.dp
) {
    val clampedRating = rating.coerceIn(0f, maxStars.toFloat())
    val description = "Avaliação $clampedRating de $maxStars estrelas" +
        (reviewCount?.let { " com $it avaliações" } ?: "")

    Row(
        modifier = modifier.semantics {
            contentDescription = description
            if (isInteractive) {
                role = Role.RadioButton
            }
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..maxStars) {
            val starIcon = when {
                clampedRating >= i -> Icons.Filled.Star
                clampedRating >= i - 0.5f -> Icons.AutoMirrored.Filled.StarHalf
                else -> Icons.Outlined.StarOutline
            }
            val interactionSource = remember { MutableInteractionSource() }
            val starModifier = if (isInteractive && onRatingChange != null) {
                Modifier
                    .size(starSize)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = ripple(bounded = false, radius = starSize),
                        role = Role.Button
                    ) {
                        onRatingChange(i.toFloat())
                    }
            } else {
                Modifier.size(starSize)
            }

            Icon(
                imageVector = starIcon,
                contentDescription = if (isInteractive) "Selecionar $i estrelas" else null,
                tint = starColor,
                modifier = starModifier
            )
            if (i < maxStars) {
                Spacer(modifier = Modifier.width(starSpacing))
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

@Preview(name = "Rating Bar ReadOnly", showBackground = true)
@Composable
private fun WgcRatingBarPreview() {
    Row(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
        WgcRatingBar(
            rating = 4.5f,
            reviewCount = 56890
        )
    }
}

@Preview(name = "Rating Bar Interactive", showBackground = true)
@Composable
private fun WgcRatingBarInteractivePreview() {
    Row(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
        WgcRatingBar(
            rating = 3f,
            isInteractive = true,
            onRatingChange = {}
        )
    }
}
