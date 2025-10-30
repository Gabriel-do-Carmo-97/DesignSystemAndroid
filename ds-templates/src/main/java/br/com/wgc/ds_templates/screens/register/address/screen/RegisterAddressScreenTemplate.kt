package br.com.wgc.ds_templates.screens.register.address.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Signpost
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
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.ds_templates.screens.register.address.viewmodel.BaseRegisterAddressScreenTemplateViewModel
import br.com.wgc.ds_templates.screens.register.address.viewmodel.FakeRegisterAddressVIewModel


/**
 * Um template de UI reutilizável para um formulário de endereço.
 *
 * @param modifier O modificador a ser aplicado ao componente.
 * @param state O estado atual do formulário de endereço, contendo os valores e os erros.
 * @param onAddressChange Callback invocado quando qualquer campo do endereço é alterado.
 *                         Ele retorna o objeto Address completo e atualizado.
 * @param onRegisterClick Callback para a ação do botão principal de salvar/registrar o endereço.
 * @param isStreetFoodVendor Flag para adaptar a UI, por exemplo, dando mais destaque
 *                           ao campo "Ponto de Referência" para um vendedor.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterAddressScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseRegisterAddressScreenTemplateViewModel
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
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 32.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Qual seu endereço?",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                SimpleTextField(
                    value = state.address.cep,
                    onValueChange = viewModel.onCepChange,
                    label = "CEP:",
                    placeholderText = "00000-000",
                    leadingIcon = Icons.Default.Map,
                    isError = state.cepError != null,
                    errorMessage = state.cepError.orEmpty(),
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.street,
                    onValueChange = viewModel.onStreetChange,
                    label = "Rua / Logradouro:",
                    placeholderText = "Ex: Av. Paulista",
                    leadingIcon = Icons.Default.Signpost,
                    isError = state.streetError != null,
                    errorMessage = state.streetError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.number,
                    onValueChange = viewModel.onNumberChange,
                    label = "Número:",
                    placeholderText = "Ex: 100",
                    leadingIcon = Icons.Default.ConfirmationNumber,
                    isError = state.numberError != null,
                    errorMessage = state.numberError.orEmpty(),
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.complement.orEmpty(),
                    onValueChange = viewModel.onComplementChange,
                    label = "Complemento (Opcional):",
                    placeholderText = "Ex: Apto 10, Bloco 2",
                    leadingIcon = Icons.Default.Business,
                    isError = state.complementError != null,
                    errorMessage = state.complementError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.referencePoint.orEmpty(),
                    onValueChange = viewModel.onReferencePointChange,
                    label = "Ponto de Referência:",
                    placeholderText = "Ex: Em frente à estação de metrô",
                    leadingIcon = Icons.Default.LocationOn,
                    isError = state.referencePointError != null,
                    errorMessage = state.referencePointError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.neighborhood,
                    onValueChange = viewModel.onNeighborhoodChange,
                    label = "Bairro:",
                    placeholderText = "Ex: Bela Vista",
                    leadingIcon = Icons.Default.LocationOn,
                    isError = state.neighborhoodError != null,
                    errorMessage = state.neighborhoodError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.city,
                    onValueChange = viewModel.onCityChange,
                    label = "Cidade:",
                    placeholderText = "Ex: São Paulo",
                    leadingIcon = Icons.Default.LocationCity,
                    isError = state.cityError != null,
                    errorMessage = state.cityError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(32.dp))
                //LOADING NO BOTAO
                ClassicButton(
                    textButton = "Salvar",
                    onClick = viewModel::onRegisterClick,
                    isEnabled = state.isRegisterButtonEnabled,
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Estado Padrão")
@Composable
private fun RegisterAddressScreenTemplatePreview() {
    MaterialTheme {
        RegisterAddressScreenTemplate(viewModel = FakeRegisterAddressVIewModel())
    }
}

@Preview(showBackground = true, name = "Com Erros")
@Composable
private fun RegisterAddressScreenTemplateWithErrorPreview() {
    MaterialTheme {
        RegisterAddressScreenTemplate(viewModel = FakeRegisterAddressVIewModel())
    }
}