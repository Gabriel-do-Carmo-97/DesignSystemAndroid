package br.com.wgc.design_system.components.badge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * Variantes de cor para o WgcBadge.
 */
enum class WgcBadgeVariant {
    Primary,
    Error,
    Success,
    Warning,
    Neutral
}

/**
 * WgcBadge
 *
 * Emblema de notificação corporativo com suporte a dot (ponto indicador) ou rótulo textual/numérico.
 *
 * @param modifier Modificador de layout.
 * @param variant Variante visual do badge (Primary, Error, Success, Warning, Neutral).
 * @param count Contagem numérica opcional (formata automaticamente valores acima de 99 como "99+").
 * @param text Texto customizado alternativo a count.
 */
@Composable
fun WgcBadge(
    modifier: Modifier = Modifier,
    variant: WgcBadgeVariant = WgcBadgeVariant.Error,
    count: Int? = null,
    text: String? = null
) {
    val (containerColor, contentColor) = when (variant) {
        WgcBadgeVariant.Primary -> Pair(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.onPrimary
        )
        WgcBadgeVariant.Error -> Pair(
            MaterialTheme.colorScheme.error,
            MaterialTheme.colorScheme.onError
        )
        WgcBadgeVariant.Success -> Pair(
            MaterialTheme.colorScheme.tertiary,
            MaterialTheme.colorScheme.onTertiary
        )
        WgcBadgeVariant.Warning -> Pair(
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.onSecondary
        )
        WgcBadgeVariant.Neutral -> Pair(
            MaterialTheme.colorScheme.surfaceVariant,
            MaterialTheme.colorScheme.onSurfaceVariant
        )
    }

    val displayText = when {
        text != null -> text
        count != null -> if (count > 99) "99+" else count.toString()
        else -> null
    }

    Badge(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor
    ) {
        if (displayText != null) {
            Text(
                text = displayText,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

/**
 * WgcBadgedBox
 *
 * Container para posicionar um WgcBadge sobre qualquer elemento composable (ex: ícones ou avatares).
 *
 * @param badge Slot que renderiza o WgcBadge.
 * @param modifier Modificador de layout.
 * @param content Conteúdo principal sobre o qual o badge será ancorado.
 */
@Composable
fun WgcBadgedBox(
    badge: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    BadgedBox(
        badge = badge,
        modifier = modifier,
        content = content
    )
}

@WgcComponentPreviews
@Composable
private fun WgcBadgePreview() {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row(
                modifier = Modifier.padding(WgcCoreDsSpacing.lg24.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Dot badge
                WgcBadgedBox(badge = { WgcBadge(variant = WgcBadgeVariant.Error) }) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
                }

                // Count badge
                WgcBadgedBox(badge = { WgcBadge(count = 5, variant = WgcBadgeVariant.Primary) }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                }

                // Over 99 badge
                WgcBadgedBox(badge = { WgcBadge(count = 120, variant = WgcBadgeVariant.Error) }) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
                }
            }
        }
    }
}
