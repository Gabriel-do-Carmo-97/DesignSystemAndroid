package br.com.wgc.design_system.components.form

/**
 * Estado reativo de um campo em um formulário WGC.
 */
data class WgcFormField<T>(
    val value: T,
    val error: String? = null,
    val isTouched: Boolean = false
) {
    val isValid: Boolean get() = error == null
}
