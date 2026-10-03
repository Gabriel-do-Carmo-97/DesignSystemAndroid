package br.com.wgc.design_system.core

import java.util.concurrent.CopyOnWriteArrayList

/**
 * Contexto de tema reativo para observação e propagação de mudanças de tenant e modo visual em tempo de execução.
 */
object WgcThemeContext {

    enum class ThemeMode {
        LIGHT,
        DARK,
        HIGH_CONTRAST
    }

    private var currentMode: ThemeMode = ThemeMode.LIGHT
    private var currentBrandTenant: String = "default"
    private val listeners = CopyOnWriteArrayList<(ThemeMode, String) -> Unit>()

    fun getThemeMode(): ThemeMode = currentMode

    fun getBrandTenant(): String = currentBrandTenant

    fun updateTheme(mode: ThemeMode, tenant: String = currentBrandTenant) {
        currentMode = mode
        currentBrandTenant = tenant
        listeners.forEach { listener -> listener(mode, tenant) }
    }

    fun addListener(listener: (ThemeMode, String) -> Unit) {
        listeners.add(listener)
    }

    fun removeListener(listener: (ThemeMode, String) -> Unit) {
        listeners.remove(listener)
    }
}
