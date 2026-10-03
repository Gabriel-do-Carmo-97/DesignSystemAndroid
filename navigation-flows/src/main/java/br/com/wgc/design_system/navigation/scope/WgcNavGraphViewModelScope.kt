package br.com.wgc.design_system.navigation.scope

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

/**
 * Utilitário para obter uma instância de ViewModel com escopo atrelado ao grafo pai ou a uma rota específica.
 */
@Composable
inline fun <reified VM : ViewModel, reified Route : Any> NavBackStackEntry.sharedGraphViewModel(
    navController: NavController,
    factory: ViewModelProvider.Factory? = null
): VM {
    val parentEntry = remember(this) {
        navController.getBackStackEntry<Route>()
    }
    return viewModel(
        viewModelStoreOwner = parentEntry,
        factory = factory
    )
}
