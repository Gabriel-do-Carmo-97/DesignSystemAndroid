@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.tag

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Variantes de cor e semântica para [WgcTag].
 */
enum class WgcTagVariant {
    Primary,
    Secondary,
    Success,
    Error,
    Warning,
    Info,
    Neutral
}

/**
 * Estilo de preenchimento para [WgcTag].
 */
enum class WgcTagStyle {
    Filled,
    Outlined
}

/**
 * Tamanhos suportados para [WgcTag].
 */
enum class WgcTagSize {
    Small,
    Medium
}

/**
 * WgcTag
 *
 * Componente atômico para exibição de rótulos de status, categorias, badges promocionais
 * e metadados contextuais (ex: "Novo", "Destaque", "Promoção", "Esgotado").
 *
 * @param text Rótulo textual da tag.
 * @param modifier Modificador de layout.
 * @param variant Variante cromática/semântica.
 * @param style Estilo de exibição (Filled ou Outlined).
 * @param size Dimensão da tag (Small ou Medium).
 * @param leadingIcon Ícone opcional à esquerda do texto.
 * @param trailingIcon Ícone opcional à direita do texto.
 */
private data class WgcTagColors(
    val primary: Color,
    val container: Color,
    val onContainer: Color
)

@Composable
private fun resolveTagColors(variant: WgcTagVariant): WgcTagColors = when (variant) {
    WgcTagVariant.Primary -> WgcTagColors(
        primary = MaterialTheme.colorScheme.primary,
        container = MaterialTheme.colorScheme.primaryContainer,
        onContainer = MaterialTheme.colorScheme.onPrimaryContainer
    )
    WgcTagVariant.Secondary -> WgcTagColors(
        primary = MaterialTheme.colorScheme.secondary,
        container = MaterialTheme.colorScheme.secondaryContainer,
        onContainer = MaterialTheme.colorScheme.onSecondaryContainer
    )
    WgcTagVariant.Success -> WgcTagColors(
        primary = MaterialTheme.colorScheme.tertiary,
        container = MaterialTheme.colorScheme.tertiaryContainer,
        onContainer = MaterialTheme.colorScheme.onTertiaryContainer
    )
    WgcTagVariant.Error -> WgcTagColors(
        primary = MaterialTheme.colorScheme.error,
        container = MaterialTheme.colorScheme.errorContainer,
        onContainer = MaterialTheme.colorScheme.onErrorContainer
    )
    WgcTagVariant.Warning -> WgcTagColors(
        primary = MaterialTheme.colorScheme.secondary,
        container = MaterialTheme.colorScheme.secondaryContainer,
        onContainer = MaterialTheme.colorScheme.onSecondaryContainer
    )
    WgcTagVariant.Info -> WgcTagColors(
        primary = MaterialTheme.colorScheme.primary,
        container = MaterialTheme.colorScheme.surfaceVariant,
        onContainer = MaterialTheme.colorScheme.onSurfaceVariant
    )
    WgcTagVariant.Neutral -> WgcTagColors(
        primary = MaterialTheme.colorScheme.outline,
        container = MaterialTheme.colorScheme.surfaceVariant,
        onContainer = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Suppress("LongMethod", "CyclomaticComplexMethod")
@Composable
fun WgcTag(
    text: String,
    modifier: Modifier = Modifier,
    variant: WgcTagVariant = WgcTagVariant.Primary,
    style: WgcTagStyle = WgcTagStyle.Filled,
    size: WgcTagSize = WgcTagSize.Medium,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    val tagColors = resolveTagColors(variant)

    val backgroundColor = when (style) {
        WgcTagStyle.Filled -> tagColors.container
        WgcTagStyle.Outlined -> Color.Transparent
    }

    val contentColor = when (style) {
        WgcTagStyle.Filled -> tagColors.onContainer
        WgcTagStyle.Outlined -> tagColors.primary
    }

    val border = when (style) {
        WgcTagStyle.Filled -> null
        WgcTagStyle.Outlined -> BorderStroke(1.dp, tagColors.primary)
    }

    val horizontalPadding = when (size) {
        WgcTagSize.Small -> WgcCoreDsSpacing.xxs4.dp
        WgcTagSize.Medium -> WgcCoreDsSpacing.xs8.dp
    }

    val verticalPadding = when (size) {
        WgcTagSize.Small -> WgcCoreDsSpacing.xxxs2.dp
        WgcTagSize.Medium -> WgcCoreDsSpacing.xxs4.dp
    }

    val textStyle = when (size) {
        WgcTagSize.Small -> MaterialTheme.typography.labelSmall
        WgcTagSize.Medium -> MaterialTheme.typography.labelMedium
    }

    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)

    Surface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
        border = border
    ) {
        Row(
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = verticalPadding),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon != null) {
                leadingIcon()
            }
            Text(
                text = text,
                style = textStyle,
                fontWeight = FontWeight.SemiBold
            )
            if (trailingIcon != null) {
                trailingIcon()
            }
        }
    }
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcTagPreview() {
    MaterialTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            WgcTag(text = "Novo", variant = WgcTagVariant.Primary)
            WgcTag(text = "Destaque", variant = WgcTagVariant.Success, leadingIcon = {
                Icon(Icons.Default.Star, contentDescription = null, modifier = Modifier.size(12.dp))
            })
            WgcTag(text = "Promoção", variant = WgcTagVariant.Warning, style = WgcTagStyle.Outlined)
            WgcTag(text = "Esgotado", variant = WgcTagVariant.Error, size = WgcTagSize.Small)
        }
    }
}
