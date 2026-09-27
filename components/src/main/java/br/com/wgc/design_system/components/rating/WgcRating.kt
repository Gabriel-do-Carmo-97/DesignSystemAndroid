package br.com.wgc.design_system.components.rating

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Componente de Avaliação Corporativo Interativo (WgcRating).
 * Suporta State Hoisting estrito, contagem configurável de estrelas e cores semânticas.
 *
 * @param rating Nota atual selecionada (1 a maxRating).
 * @param onRatingChange Callback disparado ao selecionar uma estrela.
 * @param modifier Modificador de layout.
 * @param maxRating Quantidade máxima de estrelas (padrão: 5).
 * @param readOnly Se verdadeiro, desabilita a interação de clique.
 */
@Composable
fun WgcRating(
    rating: Int,
    onRatingChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    maxRating: Int = 5,
    readOnly: Boolean = false
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..maxRating) {
            val isSelected = i <= rating
            val iconModifier = if (!readOnly) {
                Modifier
                    .size(28.dp)
                    .clickable { onRatingChange(i) }
            } else {
                Modifier.size(24.dp)
            }

            Icon(
                imageVector = if (isSelected) Icons.Default.Star else Icons.Outlined.StarOutline,
                contentDescription = "Nota $i de $maxRating",
                tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant,
                modifier = iconModifier
            )
        }
    }
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcRatingPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            WgcRating(
                rating = 4,
                onRatingChange = {}
            )
        }
    }
}
