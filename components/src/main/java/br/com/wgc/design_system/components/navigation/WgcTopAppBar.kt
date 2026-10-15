package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.previews.components.WgcComponentPreviews

/**
 * Barra superior de navegação do Design System (WgcTopAppBar) baseado no Material 3.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = { navigationIcon?.invoke() },
        actions = actions,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcTopAppBarPreview() {
    MaterialTheme {
        Surface {
            WgcTopAppBar(
                title = "WgcTopAppBar",
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Mais opções"
                        )
                    }
                }
            )
        }
    }
}
