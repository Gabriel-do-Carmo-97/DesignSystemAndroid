package br.com.wgc.ds_templates.screens.register.car.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wgc.ds_templates.screens.register.car.state.RegisterCarScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlin.text.isBlank
import kotlin.text.isDigit

abstract class BaseRegisterCarScreenTemplateViewModel: ViewModel() {
    protected val brand = MutableStateFlow("")
    val onBrandChange: (String) -> Unit = { brand.value = it }

    protected val model = MutableStateFlow("")
    val onModelChange: (String) -> Unit = { model.value = it }

    protected val year = MutableStateFlow("")
    val onYearChange: (String) -> Unit = { year.value = it }

    protected val licensePlate = MutableStateFlow("")
    val onLicensePlateChange: (String) -> Unit = { licensePlate.value = it }

    protected val isFoodTruck = MutableStateFlow(false)
    val onToggleFoodTruck: (Boolean) -> Unit = { isFoodTruck.value = it }

    protected val vehicleName = MutableStateFlow("") // Nome do Negócio
    val onVehicleNameChange: (String) -> Unit = { vehicleName.value = it }

    protected val foodCategory = MutableStateFlow("")
    val onFoodCategoryChange: (String) -> Unit = { foodCategory.value = it }

    protected val isLoading = MutableStateFlow(false)


    private val brandError = combine(brand) { (brand) ->
        if (brand.isBlank()) "A marca não pode ser vazia" else null
    }

    private val modelError = combine(model) { (model) ->
        if (model.isBlank()) "O modelo não pode ser vazio" else null
    }

    private val yearError = combine(year) { (year) ->
        when {
            year.isBlank() -> "O ano não pode ser vazio"
            year.length != 4 || !year.all { it.isDigit() } -> "Digite um ano válido (ex: 2023)"
            else -> null
        }
    }

    private val licensePlateError = combine(licensePlate) { (licensePlate) ->
        // Adicionar uma validação de placa mais robusta aqui se necessário
        if (licensePlate.isBlank()) "A placa não pode ser vazia" else null
    }

    private val vehicleNameError = combine(vehicleName, isFoodTruck) { vehicleName, isFoodTruck ->
        if (isFoodTruck && vehicleName.isBlank()) "O nome do negócio não pode ser vazio" else null
    }

    private val foodCategoryError = combine(foodCategory, isFoodTruck) { foodCategory, isFoodTruck ->
        if (isFoodTruck && foodCategory.isBlank()) "A categoria da comida não pode ser vazia" else null
    }

    private val carState: StateFlow<RegisterCarScreenUiState> = combine(
        brand,
        brandError,
        model,
        modelError,
    ){ brand, brandError, model, modelError ->
        RegisterCarScreenUiState(
            brand = brand,
            brandError = brandError,
            model = model,
            modelError = modelError,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = RegisterCarScreenUiState()
    )

    private val othersDataCarState: StateFlow<RegisterCarScreenUiState> = combine(
        year,
        yearError,
        licensePlate,
        licensePlateError,
    ){ year, yearError, licensePlate, licensePlateError ->
        RegisterCarScreenUiState(
            year = year,
            yearError = yearError,
            licensePlate = licensePlate,
            licensePlateError = licensePlateError
        )

    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = RegisterCarScreenUiState()
    )

    private val foodTruckDataState: StateFlow<RegisterCarScreenUiState> = combine(
    isFoodTruck,
        vehicleName,
        vehicleNameError,
        foodCategory,
        foodCategoryError,
    ){ isFoodTruck, vehicleName, vehicleNameError, foodCategory, foodCategoryError ->
        RegisterCarScreenUiState(
            isFoodTruck = isFoodTruck,
            vehicleName = vehicleName,
            vehicleNameError = vehicleNameError,
            foodCategory = foodCategory,
            foodCategoryError = foodCategoryError
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = RegisterCarScreenUiState()
    )


    val uiState: StateFlow<RegisterCarScreenUiState> = combine(
        carState,
        othersDataCarState,
        foodTruckDataState,
        isLoading
    ) { carState, othersDataCarState, foodTruckDataState, isLoading ->
        RegisterCarScreenUiState(
            brand = carState.brand,
            brandError = carState.brandError,
            model = carState.model,
            modelError = carState.modelError,
            year = othersDataCarState.year,
            yearError = othersDataCarState.yearError,
            licensePlate = othersDataCarState.licensePlate,
            licensePlateError = othersDataCarState.licensePlateError,
            isFoodTruck = foodTruckDataState.isFoodTruck,
            vehicleName = foodTruckDataState.vehicleName,
            vehicleNameError = foodTruckDataState.vehicleNameError,
            foodCategory = foodTruckDataState.foodCategory,
            foodCategoryError = foodTruckDataState.foodCategoryError,
            isLoading = isLoading
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = RegisterCarScreenUiState()
    )

    /**
     * Ação executada quando o usuário clica no botão principal de registro.
     * A lógica de salvar os dados no backend pertence à implementação desta função.
     */
    abstract fun onRegisterClick()

}