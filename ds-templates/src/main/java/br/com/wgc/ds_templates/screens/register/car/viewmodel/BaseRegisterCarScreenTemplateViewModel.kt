package br.com.wgc.ds_templates.screens.register.car.viewmodel

import android.icu.util.Calendar
import android.util.Patterns
import androidx.lifecycle.ViewModel
import br.com.wgc.ds_templates.screens.register.car.state.RegisterCarScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel base abstrato para a tela de cadastro de veículos.
 *
 * Gerencia o estado da UI, incluindo campos genéricos do veículo, dados do proprietário,
 * e campos condicionais para Food Trucks. As validações são reativas e atualizam o estado
 * em tempo real.
 */
abstract class BaseRegisterCarScreenTemplateViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(RegisterCarScreenUiState())
    val uiState: StateFlow<RegisterCarScreenUiState> = _uiState.asStateFlow()

    abstract fun onRegisterClick()
    abstract fun onBackClick()

    val onBrandChange: (String) -> Unit = { newBrand ->
        _uiState.update { it.copy(brand = newBrand, brandError = validateBrand(newBrand)) }
    }

    val onModelChange: (String) -> Unit = { newModel ->
        _uiState.update { it.copy(model = newModel, modelError = validateModel(newModel)) }
    }

    val onYearChange: (String) -> Unit = { newYear ->
        _uiState.update { it.copy(year = newYear, yearError = validateYear(newYear)) }
    }

    val onLicensePlateChange: (String) -> Unit = { newLicensePlate ->
        _uiState.update {
            it.copy(
                licensePlate = newLicensePlate,
                licensePlateError = validateLicensePlate(newLicensePlate)
            )
        }
    }

    val onOwnerNameChange: (String) -> Unit = { newOwnerName ->
        _uiState.update {
            it.copy(
                ownerName = newOwnerName,
                ownerNameError = validateOwnerName(newOwnerName)
            )
        }
    }

    val onEmailChange: (String) -> Unit = { newEmail ->
        _uiState.update { it.copy(email = newEmail, emailError = validateEmail(newEmail)) }
    }

    val onPasswordChange: (String) -> Unit = { newPassword ->
        _uiState.update {
            it.copy(
                password = newPassword,
                passwordError = validatePassword(newPassword)
            )
        }
    }


    val onIsFoodTruckChange: (Boolean) -> Unit = { isChecked ->
        _uiState.update { currentState ->
            currentState.copy(
                isFoodTruck = isChecked,
                // Limpa os erros dos campos de Food Truck se a opção for desmarcada
                vehicleNameError = if (!isChecked) null else currentState.vehicleNameError,
                foodCategoryError = if (!isChecked) null else currentState.foodCategoryError
            )
        }
    }

    val onVehicleNameChange: (String) -> Unit = { newVehicleName ->
        _uiState.update {
            it.copy(
                vehicleName = newVehicleName,
                vehicleNameError = validateVehicleName(newVehicleName, it.isFoodTruck)
            )
        }
    }

    val onFoodCategoryChange: (String) -> Unit = { newFoodCategory ->
        _uiState.update {
            it.copy(
                foodCategory = newFoodCategory,
                foodCategoryError = validateFoodCategory(newFoodCategory, it.isFoodTruck)
            )
        }
    }


    private fun validateBrand(brand: String): String? =
        if (brand.isBlank()) "A marca é obrigatória" else null

    private fun validateModel(model: String): String? =
        if (model.isBlank()) "O modelo é obrigatório" else null

    private fun validateYear(year: String): String? {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val yearAsInt = year.toIntOrNull()
        return when {
            year.isBlank() -> "O ano é obrigatório"
            year.length != 4 || yearAsInt == null -> "Ano inválido"
            yearAsInt > currentYear -> "O ano não pode ser no futuro"
            yearAsInt < 1900 -> "Ano muito antigo"
            else -> null
        }
    }

    private fun validateLicensePlate(plate: String): String? =
        if (plate.isBlank()) "A placa é obrigatória" else null // Pode ser melhorada com regex

    private fun validateOwnerName(name: String): String? =
        if (name.trim().length < 3) "O nome do proprietário é muito curto" else null

    private fun validateEmail(email: String): String? =
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Formato de e-mail inválido" else null

    private fun validatePassword(password: String): String? =
        when {
            password.length < 8 -> "A senha deve ter no mínimo 8 caracteres"
            !password.any { it.isDigit() } -> "A senha precisa de um número"
            !password.any { it.isUpperCase() } -> "A senha precisa de uma letra maiúscula"
            else -> null
        }

    private fun validateVehicleName(name: String, isFoodTruck: Boolean): String? =
        if (isFoodTruck && name.isBlank()) "O nome do negócio é obrigatório" else null

    private fun validateFoodCategory(category: String, isFoodTruck: Boolean): String? =
        if (isFoodTruck && category.isBlank()) "A categoria é obrigatória" else null

    /**
     * Permite que a subclasse (ex: RegisterCarViewModel) atualize o estado de forma segura.
     * Útil para controlar `isLoading` e erros gerais.
     */
    protected fun updateState(update: (currentState: RegisterCarScreenUiState) -> RegisterCarScreenUiState) {
        _uiState.update(update)
    }

}