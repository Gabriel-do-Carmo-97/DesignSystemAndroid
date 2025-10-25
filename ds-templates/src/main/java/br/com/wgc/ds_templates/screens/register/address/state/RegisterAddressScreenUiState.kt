package br.com.wgc.ds_templates.screens.register.address.state

import br.com.wgc.ds_templates.screens.register.address.model.Address

data class RegisterAddressScreenUiState(
    val address: Address = Address(),
    val cepError: String? = null,
    val streetError: String? = null,
    val numberError: String? = null,
    val complementError: String? = null,
    val neighborhoodError: String? = null,
    val cityError: String? = null,
    val stateError: String? = null,
    val referencePointError: String? = null,
    val isLoading: Boolean = false,
    val isCepLoading: Boolean = false,
){
    val isRegisterButtonEnabled: Boolean
        get() = !isLoading && !isCepLoading &&
                address.cep.isNotBlank() && cepError == null &&
                address.street.isNotBlank() && streetError == null &&
                address.number.isNotBlank() && numberError == null &&
                address.neighborhood.isNotBlank() && neighborhoodError == null &&
                address.city.isNotBlank() && cityError == null &&
                address.state.isNotBlank() && stateError == null
}