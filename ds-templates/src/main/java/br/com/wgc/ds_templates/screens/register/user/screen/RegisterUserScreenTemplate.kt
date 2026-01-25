package br.com.wgc.ds_templates.screens.register.user.screen

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.shimmerEffect
import br.com.wgc.design_system.components.buttons.ClassicButton
import br.com.wgc.design_system.components.checkbox.CheckboxDefaults
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.ds_templates.screens.register.user.state.RegisterUserScreenUiState
import br.com.wgc.ds_templates.screens.register.user.viewmodel.BaseRegisterUserTemplateViewModel

/**
 * Tela de cadastro de usuário (Stateful).
 *
 * Esta versão é "com estado" (stateful). Ela conecta a lógica de negócio (ViewModel)
 * com a UI, coletando o estado e passando os eventos para a versão stateless.
 *
 * @param modifier O modificador a ser aplicado ao Composable.
 * @param viewModel A instância do ViewModel que provê o estado e os eventos.
 */
@Composable
fun RegisterUserScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseRegisterUserTemplateViewModel,
) {
    // Coleta o estado como 'uiState' para manter a nomenclatura consistente com o ViewModel.
    val uiState by viewModel.uiState.collectAsState()

    // Chama a versão Stateless, passando o 'uiState' e as referências das funções.
    RegisterUserScreenTemplate(
        modifier = modifier,
        state = uiState,
        onNameChange = viewModel::onNameChange,
        onLastNameChange = viewModel::onLastNameChange,
        onEmailChange = viewModel::onEmailChange,
        onPhoneChange = viewModel::onPhoneChange,
        onPasswordChange = viewModel::onPasswordChange,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
        onAcceptedTermsChange = viewModel::onAcceptedTermsChange,
        onRegisterClick = viewModel::onRegisterClick,
        onBackClick = viewModel::onBackClick,
        onLoginClick = viewModel::onLoginClick
    )
}

/**
 * Tela de cadastro de usuário (Stateless).
 *
 * Esta versão é "sem estado" (stateless) e puramente declarativa. Ela descreve a UI
 * com base no `state` recebido e delega os eventos para as funções de callback.
 *
 * @param state O estado atual da UI a ser exibido.
 * @param onChange Callbacks para atualização dos campos de texto.
 * @param onClick Callbacks para ações de clique.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegisterUserScreenTemplate(
    modifier: Modifier = Modifier,
    state: RegisterUserScreenUiState,
    onNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onAcceptedTermsChange: (Boolean) -> Unit,
    onRegisterClick: () -> Unit,
    onBackClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Crie sua Conta",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(vertical = 24.dp)
                )

                SimpleTextField(
                    value = state.name,
                    onValueChange = onNameChange,
                    label = "Nome:",
                    placeholderText = "Digite seu nome",
                    leadingIcon = Icons.Default.Person,
                    isError = state.nameError != null,
                    errorMessage = state.nameError.orEmpty(),
                )
                SimpleTextField(
                    value = state.lastName,
                    onValueChange = onLastNameChange,
                    label = "Sobrenome:",
                    placeholderText = "Digite seu sobrenome",
                    leadingIcon = Icons.Default.Person,
                    isError = state.lastNameError != null,
                    errorMessage = state.lastNameError.orEmpty(),
                )
                SimpleTextField(
                    value = state.email,
                    onValueChange = onEmailChange,
                    label = "Email:",
                    placeholderText = "Digite seu email",
                    leadingIcon = Icons.Default.Email,
                    isError = state.emailError != null,
                    errorMessage = state.emailError.orEmpty(),
                    keyboardType = KeyboardType.Email,
                )
                SimpleTextField(
                    value = state.phone,
                    onValueChange = onPhoneChange,
                    label = "Telefone:",
                    placeholderText = "Digite seu telefone",
                    leadingIcon = Icons.Default.Phone,
                    isError = state.phoneError != null,
                    errorMessage = state.phoneError.orEmpty(),
                    keyboardType = KeyboardType.Phone,
                )
                SimpleTextField(
                    value = state.password,
                    onValueChange = onPasswordChange,
                    label = "Senha:",
                    placeholderText = "Digite sua senha",
                    leadingIcon = Icons.Default.Password,
                    isError = state.passwordError != null,
                    errorMessage = state.passwordError.orEmpty(),
                    keyboardType = KeyboardType.Password,
                    isPasswordField = true,
                )
                SimpleTextField(
                    value = state.confirmPassword,
                    onValueChange = onConfirmPasswordChange,
                    label = "Confirmar Senha:",
                    placeholderText = "Confirme sua senha",
                    leadingIcon = Icons.Default.Password,
                    isError = state.confirmPasswordError != null,
                    errorMessage = state.confirmPasswordError.orEmpty(),
                    keyboardType = KeyboardType.Password,
                    isPasswordField = true,
                )
                CheckboxDefaults(
                    label = "Aceito os termos e condições",
                    checked = state.acceptedTerms,
                    onCheckedChange = onAcceptedTermsChange
                )
                Spacer(modifier = Modifier.height(24.dp))

                ClassicButton(
                    modifier = Modifier.shimmerEffect(isLoading = state.isLoading),
                    textButton = "Cadastrar",
                    onClick = onRegisterClick,
                    isEnabled = state.isRegisterButtonEnabled
                )

                TextButton(onClick = { if (!state.isLoading) onLoginClick() }) {
                    Text(
                        "Já tem uma conta? Faça login",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

// --- PREVIEWS ---

@Preview(showBackground = true, name = "Estado Padrão")
@Composable
private fun RegisterUserScreenTemplatePreview() {
    MaterialTheme {
        // A preview agora chama a versão stateless (privada)
        RegisterUserScreenTemplate(
            state = RegisterUserScreenUiState(),
            onNameChange = {},
            onLastNameChange = {},
            onEmailChange = {},
            onPhoneChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onAcceptedTermsChange = {},
            onRegisterClick = {},
            onBackClick = {},
            onLoginClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Estado de Carregamento")
@Composable
private fun RegisterUserScreenTemplateLoadingPreview() {
    MaterialTheme {
        // Exemplo de preview para o estado de loading
        RegisterUserScreenTemplate(
            state = RegisterUserScreenUiState(isLoading = true),
            onNameChange = {},
            onLastNameChange = {},
            onEmailChange = {},
            onPhoneChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onAcceptedTermsChange = {},
            onRegisterClick = {},
            onBackClick = {},
            onLoginClick = {}
        )
    }
}