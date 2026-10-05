@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

enum class WgcBannerSeverity {
    INFO,
    WARNING,
    ERROR
}

/**
 * Banner persistente para avisos de sistema, manutenção e informações operacionais.
 */
@Suppress("LongMethod")
@Composable
fun WgcBanner(
    title: String,
    message: String,
    modifier: Modifier = Modifier,
    severity: WgcBannerSeverity = WgcBannerSeverity.INFO,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    onDismiss: (() -> Unit)? = null
) {
    val (containerColor, contentColor, icon) = when (severity) {
        WgcBannerSeverity.INFO -> Triple(
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.onPrimaryContainer,
            Icons.Default.Info
        )
        WgcBannerSeverity.WARNING -> Triple(
            MaterialTheme.colorScheme.tertiaryContainer,
            MaterialTheme.colorScheme.onTertiaryContainer,
            Icons.Default.Warning
        )
        WgcBannerSeverity.ERROR -> Triple(
            MaterialTheme.colorScheme.errorContainer,
            MaterialTheme.colorScheme.onErrorContainer,
            Icons.Default.Warning
        )
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(containerColor)
            .padding(WgcCoreDsSpacing.md16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = contentColor,
                modifier = Modifier.size(24.dp)
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = contentColor
                )
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = contentColor
                )

                if (actionLabel != null && onActionClick != null) {
                    TextButton(
                        onClick = onActionClick,
                        modifier = Modifier.padding(top = WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Text(text = actionLabel, color = contentColor, fontWeight = FontWeight.Bold)
                    }
                }
            }

            if (onDismiss != null) {
                IconButton(onClick = onDismiss, modifier = Modifier.size(24.dp)) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Fechar banner",
                        tint = contentColor
                    )
                }
            }
        }
    }
}
