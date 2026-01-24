package br.com.wgc.ds_templates.screens.login.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.commons.shimmerEffect
import br.com.wgc.design_system.components.buttons.ClassicButton
import br.com.wgc.design_system.components.buttons.secondarybutton.SecondaryClassicButton
import br.com.wgc.design_system.components.checkbox.CheckboxDefaults
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.design_system.components.providers_login.ProvidersLogin
import br.com.wgc.ds_templates.screens.login.state.LoginScreenUiState
import br.com.wgc.ds_templates.screens.login.viewmodel.BaseLoginScreenTemplateViewModel
import br.com.wgc.ds_templates.screens.login.viewmodel.FakeLoginViewModel

/**
 * Versão Stateless e pura do template de login.
 *
 * Este componente não tem conhecimento sobre ViewModels ou qualquer outra fonte de dados.
 * Ele é totalmente controlado de fora, recebendo o estado (`state`) e os callbacks de eventos.
 * Isso o torna altamente reutilizável, testável e alinhado com as melhores práticas do Jetpack Compose.
 *
 * @param state O objeto de estado que contém todos os dados necessários para renderizar a UI.
 * @param onEmailChange Callback invocado quando o valor do campo de e-mail muda.
 * @param onPasswordChange Callback invocado quando o valor do campo de senha muda.
 * @param onTogglePasswordVisibility Callback para alternar a visibilidade da senha.
 * @param onRememberMeCheckedChange Callback para alterar o estado do checkbox "Lembrar de mim".
 * @param onLoginClick Callback invocado quando o botão de login é clicado.
 * @param onRegisterClick Callback invocado quando o botão de registro é clicado.
 * @param onForgotPasswordClick Callback invocado quando o link "Esqueceu a senha" é clicado.
 */

/**
 * Versão "Stateful" ou "ViewModel-Driven" do template.
 *
 * Esta função atua como um conector (ou "collector"). Ela coleta o estado
 * do ViewModel e o passa, junto com os callbacks, para a versão Stateless
 * do template, que é responsável pela renderização da UI.
 */
@Composable
fun LoginScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseLoginScreenTemplateViewModel
) {
    val state by viewModel.uiState.collectAsState()

    LoginScreenTemplateStateless(
        modifier = modifier,
        state = state,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onTogglePasswordVisibility = viewModel::onTogglePasswordVisibility,
        onRememberMeCheckedChange = viewModel::onRememberMeCheckedChange,
        onLoginClick = viewModel::onLoginClick,
        onRegisterClick = viewModel::onRegisterClick,
        onForgotPasswordClick = viewModel::onForgotPasswordClick
    )
}


@Composable
fun LoginScreenTemplateStateless(
    modifier: Modifier = Modifier,
    state: LoginScreenUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onRememberMeCheckedChange: (Boolean) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = MaterialTheme.colorScheme.primary,
                )
                Spacer(modifier = Modifier.height(32.dp))
                SimpleTextField(
                    modifier = Modifier,
                    value = state.email,
                    onValueChange = onEmailChange, // <-- MUDOU
                    isEnabled = !state.isLoading,
                    label = "Email :",
                    placeholderText = "Digite seu E-mail:",
                    leadingIcon = Icons.Default.Email,
                    isError = state.emailError != null,
                    errorMessage = state.emailError.orEmpty(),
                    keyboardType = KeyboardType.Email,
                    isReadOnly = state.isLoading
                )
                SimpleTextField(
                    modifier = Modifier,
                    value = state.password,
                    onValueChange = onPasswordChange, // <-- MUDOU
                    isEnabled = !state.isLoading,
                    label = "Senha :",
                    placeholderText = "Digite sua senha:",
                    leadingIcon = Icons.Default.Password,
                    trailingIcon = if (state.isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    onTrailingIconClick = onTogglePasswordVisibility, // <-- MUDOU
                    isError = state.passwordError != null,
                    errorMessage = state.passwordError.orEmpty(),
                    keyboardType = KeyboardType.Password,
                    isReadOnly = state.isLoading,
                    isPasswordField = true
                )
                CheckboxDefaults(
                    label = "Lembrar de mim",
                    isEnabled = !state.isLoading,
                    checked = state.rememberMeChecked,
                    onCheckedChange = onRememberMeCheckedChange // <-- MUDOU
                )
                Spacer(modifier = Modifier.height(32.dp))
                ClassicButton(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .shimmerEffect(isLoading = state.isLoading),
                    onClick = onLoginClick, // <-- MUDOU
                    isEnabled = state.isLoginButtonEnabled,
                    textButton = "Login"
                )
                Spacer(modifier = Modifier.height(8.dp))
                SecondaryClassicButton(
                    textButton = "Não tem uma conta? Cadastrar-se",
                    onClick = onRegisterClick, // <-- MUDOU
                    isEnabled = !state.isLoading
                )
                Spacer(modifier = Modifier.height(16.dp))
                if (state.providers.isNotEmpty()) {
                    ProvidersLogin(
                        providers = state.providers
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Row(
                    modifier = Modifier
                        .clickable { if (!state.isLoading) return@clickable onForgotPasswordClick() } // <-- MUDOU
                        .height(48.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "Esqueceu a senha?",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(
                        "Recuperar",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Stateless Light Theme")
@Composable
private fun LoginScreenTemplateStatelessPreview() {
    LoginScreenTemplateStateless(
        state = LoginScreenUiState( // Crie um estado de exemplo
            email = "preview@email.com",
            password = "123",
        ),
        onEmailChange = {}, // Lambdas vazias para o preview
        onPasswordChange = {},
        onTogglePasswordVisibility = {},
        onRememberMeCheckedChange = {},
        onLoginClick = {},
        onRegisterClick = {},
        onForgotPasswordClick = {}
    )
}

@Preview(showBackground = true, name = "Stateless Loading")
@Composable
private fun LoginScreenTemplateStatelessLoadingPreview() {
    LoginScreenTemplateStateless(
        state = LoginScreenUiState(
            isLoading = true, // Exemplo com loading
            email = "preview@email.com"
        ),
        onEmailChange = {},
        onPasswordChange = {},
        onTogglePasswordVisibility = {},
        onRememberMeCheckedChange = {},
        onLoginClick = {},
        onRegisterClick = {},
        onForgotPasswordClick = {}
    )
}

// O preview antigo, que usa a versão com ViewModel, continua funcionando normalmente
@Preview(showBackground = true, name = "Stateful (Old) Preview")
@Composable
private fun LoginScreenTemplatePreview() = LoginScreenTemplate(viewModel = FakeLoginViewModel())
