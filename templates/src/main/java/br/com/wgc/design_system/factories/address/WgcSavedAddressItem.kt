package br.com.wgc.design_system.factories.address

/**
 * Modelo de Endereço Salvo para seleção no fluxo de entrega/endereço.
 */
data class WgcSavedAddressItem(
    val id: String,
    val title: String,
    val street: String,
    val number: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val isDefault: Boolean = false
)
