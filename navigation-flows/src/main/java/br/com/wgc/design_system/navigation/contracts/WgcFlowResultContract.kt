package br.com.wgc.design_system.navigation.contracts

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController

/**
 * Utilitário tipado para comunicação de resultados entre telas sem dependência de Singletons.
 */
object WgcFlowResultContract {

    fun <T> setResult(navController: NavController, key: String, result: T) {
        navController.previousBackStackEntry?.savedStateHandle?.set(key, result)
    }

    fun <T> getResult(savedStateHandle: SavedStateHandle, key: String): T? {
        return savedStateHandle.get<T>(key)
    }

    fun <T> observeResult(savedStateHandle: SavedStateHandle, key: String) =
        savedStateHandle.getStateFlow<T?>(key, null)
}
