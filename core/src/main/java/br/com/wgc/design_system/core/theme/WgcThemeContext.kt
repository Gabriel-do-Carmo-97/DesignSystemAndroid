package br.com.wgc.design_system.core.theme

import java.util.concurrent.CopyOnWriteArrayList

/**
 * Contexto de tema reativo para observação e propagação de mudanças de tenant e modo visual em tempo de execução.
 * Exemplo: `WgcThemeContext.updateTheme(WgcThemeMode.DARK, "finance")`.
 * Quando usar: escolha esta API quando observar ou atualizar o modo visual e o tenant ativos.
 */
object WgcThemeContext {
    private var currentMode: WgcThemeMode = WgcThemeMode.LIGHT
    private var currentBrandTenant: String = "default"
    private val listeners = CopyOnWriteArrayList<(WgcThemeMode, String) -> Unit>()

    fun getThemeMode(): WgcThemeMode = currentMode

    fun getBrandTenant(): String = currentBrandTenant

    fun updateTheme(mode: WgcThemeMode, tenant: String = currentBrandTenant) {
        currentMode = mode
        currentBrandTenant = tenant
        listeners.forEach { listener -> listener(mode, tenant) }
    }

    fun addListener(listener: (WgcThemeMode, String) -> Unit) {
        listeners.add(listener)
    }

    fun removeListener(listener: (WgcThemeMode, String) -> Unit) {
        listeners.remove(listener)
    }
}
