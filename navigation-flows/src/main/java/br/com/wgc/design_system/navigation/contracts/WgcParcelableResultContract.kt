package br.com.wgc.design_system.navigation.contracts

import android.os.Parcelable
import androidx.navigation.NavController

/**
 * Contrato type-safe para retorno de resultados complexos (Parcelable) entre destinos de navegação.
 */
object WgcParcelableResultContract {

    /**
     * Envia um resultado para o destino anterior na pilha e executa o pop.
     */
    fun <T : Parcelable> setNavigationResult(
        navController: NavController,
        key: String,
        result: T
    ) {
        navController.previousBackStackEntry
            ?.savedStateHandle
            ?.set(key, result)
    }

    /**
     * Recupera e consome (remove) o resultado recebido na tela atual.
     */
    fun <T : Parcelable> consumeNavigationResult(
        navController: NavController,
        key: String
    ): T? {
        val handle = navController.currentBackStackEntry?.savedStateHandle
        val value: T? = handle?.get<T>(key)
        if (value != null) {
            handle.remove<T>(key)
        }
        return value
    }
}
