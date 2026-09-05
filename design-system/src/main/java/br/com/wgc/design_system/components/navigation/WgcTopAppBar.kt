package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
