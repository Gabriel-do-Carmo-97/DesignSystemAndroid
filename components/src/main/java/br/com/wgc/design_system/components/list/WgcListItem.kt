package br.com.wgc.design_system.components.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Item de lista padronizado do Design System (WgcListItem) baseado no Material 3.
 */
@Composable
fun WgcListItem(
    modifier: Modifier = Modifier,
    headlineText: String,
    supportingText: String? = null,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    val headline: @Composable () -> Unit = { Text(text = headlineText) }
    val supporting: (@Composable () -> Unit)? = supportingText?.let { { Text(text = it) } }

    if (onClick != null) {
        Surface(onClick = onClick, modifier = modifier) {
            ListItem(
                headlineContent = headline,
                supportingContent = supporting,
                leadingContent = leadingContent,
                trailingContent = trailingContent
            )
        }
    } else {
        ListItem(
            modifier = modifier,
            headlineContent = headline,
            supportingContent = supporting,
            leadingContent = leadingContent,
            trailingContent = trailingContent
        )
    }
}

@Preview(showBackground = true, name = "WgcListItem Preview")
@Composable
private fun WgcListItemPreview() {
    WgcTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.SM8.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM8.dp)
        ) {
            WgcListItem(
                headlineText = "Item Simples"
            )
            WgcListItem(
                headlineText = "Item com Suporte",
                supportingText = "Texto de suporte detalhado"
            )
            WgcListItem(
                headlineText = "Item Completo",
                supportingText = "Com leading e trailing",
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null
                    )
                },
                trailingContent = {
                    Text(text = "R$ 99,00")
                },
                onClick = {}
            )
        }
    }
}
