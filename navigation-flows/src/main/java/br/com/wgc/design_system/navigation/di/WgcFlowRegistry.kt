package br.com.wgc.design_system.navigation.di

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

/**
 * Interface para módulos que expõem um subgrafo de navegação independente.
 */
fun interface WgcNavGraphProvider {
    fun registerGraph(builder: NavGraphBuilder, navController: NavHostController)
}

/**
 * Registro central singleton para injeção dinâmica de fluxos de navegação desacoplados.
 */
object WgcFlowRegistry {
    private val providers = mutableListOf<WgcNavGraphProvider>()

    fun register(provider: WgcNavGraphProvider) {
        synchronized(providers) {
            providers.add(provider)
        }
    }

    fun buildAll(builder: NavGraphBuilder, navController: NavHostController) {
        synchronized(providers) {
            providers.forEach { it.registerGraph(builder, navController) }
        }
    }
}
