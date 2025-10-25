package br.com.wgc.ds_templates.screens.register.address.model

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