package br.com.wgc.design_system.templates.screens.register.address.model

import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val cep: String = "",
    val street: String = "",
    val number: String = "",
    val complement: String? = null,
    val neighborhood: String = "",
    val city: String = "",
    val state: String = "",
    val referencePoint: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
)