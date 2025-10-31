package br.com.wgc.ds_templates.screens.register.car.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Factory
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.ClassicButton
import br.com.wgc.design_system.components.checkbox.CheckboxDefaults
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.ds_templates.screens.register.car.viewmodel.BaseRegisterCarScreenTemplateViewModel
import br.com.wgc.ds_templates.screens.register.car.viewmodel.FakeRegisterCarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterCarScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseRegisterCarScreenTemplateViewModel,
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = viewModel::onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp, vertical = 16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Dados do Veículo",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                SimpleTextField(
                    value = state.brand,
                    onValueChange = viewModel.onBrandChange,
                    label = "Marca:",
                    placeholderText = "Ex: Volkswagen",
                    leadingIcon = Icons.Default.Factory,
                    isError = state.brandError != null,
                    errorMessage = state.brandError.orEmpty(),
                )
                SimpleTextField(
                    value = state.model,
                    onValueChange = viewModel.onModelChange,
                    label = "Modelo:",
                    placeholderText = "Ex: Kombi",
                    leadingIcon = Icons.Default.DirectionsCar,
                    isError = state.modelError != null,
                    errorMessage = state.modelError.orEmpty(),
                )
                SimpleTextField(
                    value = state.year,
                    onValueChange = viewModel.onYearChange,
                    label = "Ano:",
                    placeholderText = "Ex: 1998",
                    leadingIcon = Icons.Default.CalendarMonth,
                    isError = state.yearError != null,
                    errorMessage = state.yearError.orEmpty(),
                    keyboardType = KeyboardType.Number,
                )
                SimpleTextField(
                    value = state.licensePlate,
                    onValueChange = viewModel.onLicensePlateChange,
                    label = "Placa do Veículo:",
                    placeholderText = "Ex: ABC1D23",
                    leadingIcon = Icons.Default.ConfirmationNumber,
                    isError = state.licensePlateError != null,
                    errorMessage = state.licensePlateError.orEmpty(),
                )
                CheckboxDefaults(
                    label = "Este veículo é um Food Truck?",
                    checked = state.isFoodTruck,
                    onCheckedChange = viewModel.onIsFoodTruckChange
                )
                AnimatedVisibility(
                    visible = state.isFoodTruck,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(16.dp))
                        SimpleTextField(
                            value = state.vehicleName,
                            onValueChange = viewModel.onVehicleNameChange,
                            label = "Nome do Negócio:",
                            placeholderText = "Ex: Lanches do Zé",
                            leadingIcon = Icons.Default.Storefront,
                            isError = state.vehicleNameError != null,
                            errorMessage = state.vehicleNameError.orEmpty(),
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        SimpleTextField(
                            value = state.foodCategory,
                            onValueChange = viewModel.onFoodCategoryChange,
                            label = "Categoria da Comida:",
                            placeholderText = "Ex: Hambúrguer, Pastel",
                            leadingIcon = Icons.Default.Fastfood,
                            isError = state.foodCategoryError != null,
                            errorMessage = state.foodCategoryError.orEmpty(),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                ClassicButton(
                    textButton = if (state.isFoodTruck) "Cadastrar Food Truck" else "Cadastrar Veículo",
                    onClick = viewModel::onRegisterClick,
                    isEnabled = state.isRegisterButtonEnabled
                )
            }
        }
    }
}

// --- PREVIEWS ---

@Preview(showBackground = true, name = "Cadastro de Veículo Genérico")
@Composable
private fun RegisterCarScreenTemplatePreview() {
    MaterialTheme {
        RegisterCarScreenTemplate(
            viewModel = FakeRegisterCarViewModel(),
        )
    }
}

@Preview(showBackground = true, name = "Cadastro de Food Truck")
@Composable
private fun RegisterFoodTruckScreenTemplatePreview() {
    MaterialTheme {
        RegisterCarScreenTemplate(
            viewModel = FakeRegisterCarViewModel(),
        )
    }
}