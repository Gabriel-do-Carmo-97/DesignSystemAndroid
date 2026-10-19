@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.tag

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
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
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

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
    trailingIcon: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    onDismiss: (() -> Unit)? = null,
    selected: Boolean = false
) {
    val tagColors = resolveTagColors(variant)

    val effectiveStyle = if (selected) WgcTagStyle.Filled else style

    val backgroundColor = when (effectiveStyle) {
        WgcTagStyle.Filled -> tagColors.container
        WgcTagStyle.Outlined -> Color.Transparent
    }

    val contentColor = when (effectiveStyle) {
        WgcTagStyle.Filled -> tagColors.onContainer
        WgcTagStyle.Outlined -> tagColors.primary
    }

    val border = when (effectiveStyle) {
        WgcTagStyle.Filled -> if (selected) BorderStroke(1.dp, tagColors.primary) else null
        WgcTagStyle.Outlined -> BorderStroke(1.dp, tagColors.primary)
    }

    val horizontalPadding = when (size) {
        WgcTagSize.Small -> WgcCoreDsSpacing.XXS4.dp
        WgcTagSize.Medium -> WgcCoreDsSpacing.XS8.dp
    }

    val verticalPadding = when (size) {
        WgcTagSize.Small -> WgcCoreDsSpacing.XXXS2.dp
        WgcTagSize.Medium -> WgcCoreDsSpacing.XXS4.dp
    }

    val textStyle = when (size) {
        WgcTagSize.Small -> MaterialTheme.typography.labelSmall
        WgcTagSize.Medium -> MaterialTheme.typography.labelMedium
    }

    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp)

    val surfaceModifier = if (onClick != null) {
        modifier.clickable(onClick = onClick)
    } else {
        modifier
    }

    Surface(
        modifier = surfaceModifier,
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
        border = border
    ) {
        Row(
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = verticalPadding),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp),
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
            } else if (onDismiss != null) {
                androidx.compose.foundation.layout.Box(
                    modifier = Modifier
                        .size(14.dp)
                        .clickable(onClick = onDismiss),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Remover tag",
                        modifier = Modifier.size(10.dp),
                        tint = contentColor
                    )
                }
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
