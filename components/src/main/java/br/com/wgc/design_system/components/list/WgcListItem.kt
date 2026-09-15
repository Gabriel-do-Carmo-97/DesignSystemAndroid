package br.com.wgc.design_system.components.list

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
