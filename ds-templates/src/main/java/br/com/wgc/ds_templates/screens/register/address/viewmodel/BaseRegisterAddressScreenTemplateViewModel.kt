package br.com.wgc.ds_templates.screens.register.address.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wgc.ds_templates.screens.register.address.model.Address
import br.com.wgc.ds_templates.screens.register.address.state.RegisterAddressScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

abstract class BaseRegisterAddressScreenTemplateViewModel : ViewModel() {
    protected val address = MutableStateFlow(Address())
    val onAddressChange: (Address) -> Unit = { newAddress ->
        address.update { newAddress }
    }

    protected val isLoading = MutableStateFlow(false)
    protected val isCepLoading = MutableStateFlow(false)

    private val allowedCharsRegex = Regex("[a-zA-Z0-9 ]*")

    private val validationFlow = combine(address) { (address) ->
        object {
            val cepError = if (address.cep.isBlank()) "CEP é obrigatório" else null
            val streetError = if (address.street.isBlank()) "Rua é obrigatória" else null
            val numberError = if (address.number.isBlank()) "Número é obrigatório" else null
            val neighborhoodError = if (address.neighborhood.isBlank()) "Bairro é obrigatório" else null
            val cityError = if (address.city.isBlank()) "Cidade é obrigatória" else null
            val stateError = if (address.state.isBlank()) "Estado é obrigatório" else null
            val complementError = if (
                    !address.complement.isNullOrEmpty() &&
                    !address.complement.matches(allowedCharsRegex)
                ) { "Complemento contém caracteres inválidos" } else null

            val referencePointError = if (
                !address.referencePoint.isNullOrEmpty() &&
                !address.referencePoint.matches(allowedCharsRegex)
                ) { "Ponto de referência contém caracteres inválidos" } else null
        }
    }
    val uiState: StateFlow<RegisterAddressScreenUiState> = combine(
        address,
        validationFlow,
        isLoading,
        isCepLoading
    ) { address, validation, isLoading, isCepLoading ->
        RegisterAddressScreenUiState(
            address = address,
            cepError = validation.cepError,
            streetError = validation.streetError,
            numberError = validation.numberError,
            complementError = validation.complementError,
            neighborhoodError = validation.neighborhoodError,
            cityError = validation.cityError,
            stateError = validation.stateError,
            // CORREÇÃO: Passando o erro do ponto de referência para o State
            referencePointError = validation.referencePointError,
            isLoading = isLoading,
            isCepLoading = isCepLoading
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = RegisterAddressScreenUiState()
    )

    abstract fun<T: Any> onRegisterClick() : T

}