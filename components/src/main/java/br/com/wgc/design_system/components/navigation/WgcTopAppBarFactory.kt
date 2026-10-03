@file:Suppress("LongMethod")

package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Fábrica universal de barras superiores corporativas (WgcTopAppBarFactory).
 */
object WgcTopAppBarFactory {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Small(
        title: String,
        modifier: Modifier = Modifier,
        onNavigationClick: (() -> Unit)? = null,
        actions: @Composable RowScope.() -> Unit = {}
    ) {
        TopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                if (onNavigationClick != null) {
                    IconButton(onClick = onNavigationClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            },
            actions = actions,
            modifier = modifier
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Medium(
        title: String,
        modifier: Modifier = Modifier,
        scrollBehavior: TopAppBarScrollBehavior? = null,
        onNavigationClick: (() -> Unit)? = null,
        actions: @Composable RowScope.() -> Unit = {}
    ) {
        MediumTopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                if (onNavigationClick != null) {
                    IconButton(onClick = onNavigationClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            },
            actions = actions,
            scrollBehavior = scrollBehavior,
            modifier = modifier
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Large(
        title: String,
        modifier: Modifier = Modifier,
        scrollBehavior: TopAppBarScrollBehavior? = null,
        onNavigationClick: (() -> Unit)? = null,
        actions: @Composable RowScope.() -> Unit = {}
    ) {
        LargeTopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                if (onNavigationClick != null) {
                    IconButton(onClick = onNavigationClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            },
            actions = actions,
            scrollBehavior = scrollBehavior,
            modifier = modifier
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Search(
        query: String,
        onQueryChange: (String) -> Unit,
        onClose: () -> Unit,
        modifier: Modifier = Modifier,
        placeholder: String = "Pesquisar..."
    ) {
        TopAppBar(
            title = {
                OutlinedTextField(
                    value = query,
                    onValueChange = onQueryChange,
                    placeholder = { Text(text = placeholder) },
                    leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
                    trailingIcon = {
                        if (query.isNotEmpty()) {
                            IconButton(onClick = { onQueryChange("") }) {
                                Icon(imageVector = Icons.Default.Close, contentDescription = "Limpar busca")
                            }
                        }
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            navigationIcon = {
                IconButton(onClick = onClose) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Fechar busca")
                }
            },
            modifier = modifier
        )
    }
}
