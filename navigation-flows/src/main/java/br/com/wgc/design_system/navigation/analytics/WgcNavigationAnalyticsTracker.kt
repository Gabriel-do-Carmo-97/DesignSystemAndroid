package br.com.wgc.design_system.navigation.analytics

import androidx.navigation.NavController
import androidx.navigation.NavDestination

/**
 * Listener corporativo para eventos de telemetria de navegação.
 */
fun interface WgcRouteChangeListener {
    fun onRouteChange(route: String?)
}

/**
 * Rastreador de telemetria e navegação integrado ao NavController.
 */
object WgcNavigationAnalyticsTracker {

    private val listeners = mutableListOf<WgcRouteChangeListener>()

    fun registerListener(listener: WgcRouteChangeListener) {
        listeners.add(listener)
    }

    /**
     * Vincula o NavController para disparar eventos automáticos a cada transição de rota.
     */
    fun attachToNavController(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val route = destination.route
            listeners.forEach { it.onRouteChange(route) }
        }
    }
}
