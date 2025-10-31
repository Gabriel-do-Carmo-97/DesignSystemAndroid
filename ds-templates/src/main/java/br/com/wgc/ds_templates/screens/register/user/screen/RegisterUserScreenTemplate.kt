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
import br.com.wgc.ds_templates.screens.register.user.viewmodel.BaseRegisterUserTemplateViewModel
import br.com.wgc.ds_templates.screens.register.user.viewmodel.FakeUserViewModel

/**
 * Template de UI para a tela de cadastro de um novo usuário (cliente).
 *
 * @param modifier O modificador a ser aplicado ao componente.
 * @param state O estado atual da tela de cadastro de usuário.
 * @param onNameChange Callback para o campo "Nome".
 * @param onLastNameChange Callback para o campo "Sobrenome".
 * @param onEmailChange Callback para o campo "Email".
 * @param onPasswordChange Callback para o campo "Senha".
 * @param onPhoneChange Callback para o campo "Telefone".
 * @param onAcceptTermsToggle Callback para o checkbox de "Aceitar Termos".
 * @param onRegisterClick Ação do botão principal para registrar.
 * @param onBackClick Ação para o botão de voltar.
 * @param onLoginClick Ação para o link "Já tem uma conta?".
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterUserScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseRegisterUserTemplateViewModel
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
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)
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
                    onValueChange = viewModel.onNameChange,
                    label = "Nome :",
                    placeholderText = "Digite seu nome:",
                    leadingIcon = Icons.Default.Person,
                    isError = state.nameError != null,
                    errorMessage = state.nameError.orEmpty(),
                    keyboardType = KeyboardType.Text,
                )
                SimpleTextField(
                    value = state.lastName,
                    onValueChange = viewModel.onLastNameChange,
                    label = "Sobrenome :",
                    leadingIcon = Icons.Default.Person,
                    placeholderText = "Digite o sobrenome:",
                    isError = state.lastNameError != null,
                    errorMessage = state.lastNameError.orEmpty(),
                    keyboardType = KeyboardType.Text,
                )
                SimpleTextField(
                    value = state.email,
                    onValueChange = viewModel.onEmailChange,
                    label = "Email :",
                    placeholderText = "Digite seu email ",
                    leadingIcon = Icons.Default.Email,
                    isError = state.emailError != null,
                    errorMessage = state.emailError.orEmpty(),
                    keyboardType = KeyboardType.Email,
                )
                SimpleTextField(
                    value = state.phone,
                    onValueChange = viewModel.onPhoneChange,
                    label = "Telefone :",
                    placeholderText = "Digite seu telefone",
                    leadingIcon = Icons.Default.Phone,
                    isError = state.phoneError != null,
                    errorMessage = state.phoneError.orEmpty(),
                    keyboardType = KeyboardType.Phone,
                )
                SimpleTextField(
                    value = state.password,
                    onValueChange = viewModel.onPasswordChange,
                    label = "Senha :",
                    placeholderText = "Digite sua senha",
                    leadingIcon = Icons.Default.Password,
                    isError = state.passwordError != null,
                    errorMessage = state.passwordError.orEmpty(),
                    keyboardType = KeyboardType.Password,
                    isPasswordField = true,
                )
                SimpleTextField(
                    value = state.confirmPassword,
                    onValueChange = viewModel.onConfirmPasswordChange,
                    label = "Confirmar Senha :",
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
                    onCheckedChange = viewModel.onAcceptedTermsChange
                )
                Spacer(modifier = Modifier.height(24.dp))

                ClassicButton(
                    modifier = Modifier.shimmerEffect(isLoading = state.isLoading),
                    textButton = "Cadastrar",
                    onClick = viewModel::onRegisterClick,
                    isEnabled = state.isRegisterButtonEnabled
                )

                TextButton(onClick = { if (!state.isLoading) return@TextButton viewModel.onLoginClick() }) {
                    Text(
                        "Já tem uma conta? Faça login",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun RegisterUserScreenTemplatePReview() {
    RegisterUserScreenTemplate(viewModel = FakeUserViewModel())
}