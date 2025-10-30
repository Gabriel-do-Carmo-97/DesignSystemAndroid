package br.com.wgc.ds_templates.screens.register.address.viewmodel

import androidx.lifecycle.ViewModel
import br.com.wgc.ds_templates.screens.register.address.state.RegisterAddressScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel base abstrato para a tela de cadastro de endereço.
 *
 * Gerencia o estado da UI, que contém um objeto aninhado 'Address',
 * validações reativas e interações do usuário.
 */
abstract class BaseRegisterAddressScreenTemplateViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterAddressScreenUiState())
    val uiState: StateFlow<RegisterAddressScreenUiState> = _uiState.asStateFlow()

    abstract fun onRegisterClick()
    abstract fun onBackClick()
    abstract fun onCepSearch(cep: String)


    /**
     * Atualiza o CEP no estado e executa a validação.
     * Se o CEP estiver completo (8 dígitos), dispara a busca automática.
     */
    val onCepChange: (String) -> Unit = { newCep ->
        val cleanedCep = newCep.filter { it.isDigit() }
        _uiState.update { currentState ->
            currentState.copy(
                address = currentState.address.copy(cep = cleanedCep),
                cepError = validateCep(cleanedCep)
            )
        }
        if (cleanedCep.length == 8) {
            onCepSearch(cleanedCep)
        }
    }

    /** Atualiza o estado (UF) no estado e executa a validação. */
    val onStateChange: (String) -> Unit = { newState ->
        _uiState.update { currentState ->
            currentState.copy(
                address = currentState.address.copy(state = newState),
                stateError = validateState(newState)
            )
        }
    }

    /** Atualiza a cidade no estado e executa a validação. */
    val onCityChange: (String) -> Unit = { newCity ->
        _uiState.update { currentState ->
            currentState.copy(
                address = currentState.address.copy(city = newCity),
                cityError = validateCity(newCity)
            )
        }
    }

    /** Atualiza o bairro no estado e executa a validação. */
    val onNeighborhoodChange: (String) -> Unit = { newNeighborhood ->
        _uiState.update { currentState ->
            currentState.copy(
                address = currentState.address.copy(neighborhood = newNeighborhood),
                neighborhoodError = validateNeighborhood(newNeighborhood)
            )
        }
    }

    /** Atualiza a rua no estado e executa a validação. */
    val onStreetChange: (String) -> Unit = { newStreet ->
        _uiState.update { currentState ->
            currentState.copy(
                address = currentState.address.copy(street = newStreet),
                streetError = validateStreet(newStreet)
            )
        }
    }

    /** Atualiza o número no estado e executa a validação. */
    val onNumberChange: (String) -> Unit = { newNumber ->
        _uiState.update { currentState ->
            currentState.copy(
                address = currentState.address.copy(number = newNumber),
                numberError = validateNumber(newNumber)
            )
        }
    }

    /** Atualiza o complemento no estado (campo opcional). */
    val onComplementChange: (String) -> Unit = { newComplement ->
        _uiState.update { currentState ->
            currentState.copy(
                address = currentState.address.copy(complement = newComplement)
            )
        }
    }

    /** Atualiza o ponto de referência no estado (campo opcional). */
    val onReferencePointChange: (String) -> Unit = { newReference ->
        _uiState.update { currentState ->
            currentState.copy(
                address = currentState.address.copy(referencePoint = newReference)
            )
        }
    }


    private fun validateCep(cep: String): String? =
        if (cep.length != 8) "CEP inválido" else null

    private fun validateState(state: String): String? =
        if (state.isBlank()) "O estado é obrigatório" else null

    private fun validateCity(city: String): String? =
        if (city.isBlank()) "A cidade é obrigatória" else null

    private fun validateNeighborhood(neighborhood: String): String? =
        if (neighborhood.isBlank()) "O bairro é obrigatório" else null

    private fun validateStreet(street: String): String? =
        if (street.isBlank()) "A rua é obrigatória" else null

    private fun validateNumber(number: String): String? =
        if (number.isBlank()) "O número é obrigatório" else null

    /**
     * Permite que a subclasse (ex: RegisterAddressViewModel) atualize o estado de forma segura.
     * Essencial para atualizar o endereço após a busca de CEP e controlar `isLoading` / `isCepLoading`.
     */
    protected fun updateState(update: (currentState: RegisterAddressScreenUiState) -> RegisterAddressScreenUiState) {
        _uiState.update(update)
    }
}