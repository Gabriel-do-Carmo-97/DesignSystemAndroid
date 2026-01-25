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
import br.com.wgc.ds_templates.screens.register.address.state.RegisterAddressScreenUiState
import br.com.wgc.ds_templates.screens.register.address.viewmodel.BaseRegisterAddressScreenTemplateViewModel


/**
 * Componente Stateful para a tela de registro de endereço.
 * Ele observa o estado do ViewModel e o passa para o componente Stateless.
 *
 * @param modifier O modificador a ser aplicado ao componente.
 * @param viewModel A instância do ViewModel que gerencia o estado e a lógica da tela.
 */
@Composable
fun RegisterAddressScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseRegisterAddressScreenTemplateViewModel
) {
    val state by viewModel.uiState.collectAsState()

    RegisterAddressScreenTemplateStateless(
        modifier = modifier,
        state = state,
        onCepChange = viewModel::onCepChange,
        onStreetChange = viewModel::onStreetChange,
        onNumberChange = viewModel::onNumberChange,
        onComplementChange = viewModel::onComplementChange,
        onReferencePointChange = viewModel::onReferencePointChange,
        onNeighborhoodChange = viewModel::onNeighborhoodChange,
        onCityChange = viewModel::onCityChange,
        onRegisterClick = viewModel::onRegisterClick,
        onBackClick = viewModel::onBackClick
    )
}

/**
 * Componente Stateless (apenas UI) para o formulário de endereço.
 * Ele é puramente declarativo, recebendo o estado e os callbacks como parâmetros.
 *
 * @param modifier O modificador a ser aplicado ao componente.
 * @param state O estado da UI a ser exibido.
 * @param onCepChange Callback invocado quando o campo CEP é alterado.
 * @param onStreetChange Callback invocado quando o campo Rua é alterado.
 * @param onNumberChange Callback invocado quando o campo Número é alterado.
 * @param onComplementChange Callback invocado quando o campo Complemento é alterado.
 * @param onReferencePointChange Callback invocado quando o Ponto de Referência é alterado.
 * @param onNeighborhoodChange Callback invocado quando o campo Bairro é alterado.
 * @param onCityChange Callback invocado quando o campo Cidade é alterado.
 * @param onRegisterClick Callback para a ação do botão principal de salvar.
 * @param onBackClick Callback para a ação do botão de voltar.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegisterAddressScreenTemplateStateless(
    modifier: Modifier = Modifier,
    state: RegisterAddressScreenUiState,
    onCepChange: (String) -> Unit,
    onStreetChange: (String) -> Unit,
    onNumberChange: (String) -> Unit,
    onComplementChange: (String) -> Unit,
    onReferencePointChange: (String) -> Unit,
    onNeighborhoodChange: (String) -> Unit,
    onCityChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
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
                    onValueChange = onCepChange,
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
                    onValueChange = onStreetChange,
                    label = "Rua / Logradouro:",
                    placeholderText = "Ex: Av. Paulista",
                    leadingIcon = Icons.Default.Signpost,
                    isError = state.streetError != null,
                    errorMessage = state.streetError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.number,
                    onValueChange = onNumberChange,
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
                    onValueChange = onComplementChange,
                    label = "Complemento (Opcional):",
                    placeholderText = "Ex: Apto 10, Bloco 2",
                    leadingIcon = Icons.Default.Business,
                    isError = state.complementError != null,
                    errorMessage = state.complementError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.referencePoint.orEmpty(),
                    onValueChange = onReferencePointChange,
                    label = "Ponto de Referência:",
                    placeholderText = "Ex: Em frente à estação de metrô",
                    leadingIcon = Icons.Default.LocationOn,
                    isError = state.referencePointError != null,
                    errorMessage = state.referencePointError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.neighborhood,
                    onValueChange = onNeighborhoodChange,
                    label = "Bairro:",
                    placeholderText = "Ex: Bela Vista",
                    leadingIcon = Icons.Default.LocationOn,
                    isError = state.neighborhoodError != null,
                    errorMessage = state.neighborhoodError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                SimpleTextField(
                    value = state.address.city,
                    onValueChange = onCityChange,
                    label = "Cidade:",
                    placeholderText = "Ex: São Paulo",
                    leadingIcon = Icons.Default.LocationCity,
                    isError = state.cityError != null,
                    errorMessage = state.cityError.orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(32.dp))

                ClassicButton(
                    textButton = "Salvar",
                    onClick = onRegisterClick,
                    isEnabled = state.isRegisterButtonEnabled,
                    // Adicione aqui o suporte a `isLoading` se o seu ClassicButton tiver
                )
            }
        }
    }
}

// Preview atualizado para usar o componente Stateless
@Preview(showBackground = true, name = "Estado Padrão")
@Composable
private fun RegisterAddressScreenTemplatePreview() {
    MaterialTheme {
        RegisterAddressScreenTemplateStateless(
            state = RegisterAddressScreenUiState(),
            onCepChange = {},
            onStreetChange = {},
            onNumberChange = {},
            onComplementChange = {},
            onReferencePointChange = {},
            onNeighborhoodChange = {},
            onCityChange = {},
            onRegisterClick = {},
            onBackClick = {}
        )
    }
}

// Preview atualizado para simular um estado de erro
@Preview(showBackground = true, name = "Com Erros")
@Composable
private fun RegisterAddressScreenTemplateWithErrorPreview() {
    MaterialTheme {
        RegisterAddressScreenTemplateStateless(
            state = RegisterAddressScreenUiState(
                cepError = "CEP inválido",
                streetError = "Campo obrigatório"
            ),
            onCepChange = {},
            onStreetChange = {},
            onNumberChange = {},
            onComplementChange = {},
            onReferencePointChange = {},
            onNeighborhoodChange = {},
            onCityChange = {},
            onRegisterClick = {},
            onBackClick = {}
        )
    }
}
