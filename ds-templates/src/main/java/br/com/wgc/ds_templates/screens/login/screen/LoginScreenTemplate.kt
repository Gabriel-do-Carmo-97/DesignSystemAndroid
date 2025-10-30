package br.com.wgc.ds_templates.screens.login.screen

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import br.com.wgc.ds_templates.screens.login.viewmodel.BaseLoginScreenTemplateViewModel
import br.com.wgc.ds_templates.screens.login.viewmodel.FakeLoginViewModel

@Composable
fun LoginScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseLoginScreenTemplateViewModel
) {
    val state by viewModel.uiState.collectAsState()
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
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
                    onValueChange = viewModel.onEmailChange,
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
                    onValueChange = viewModel.onPasswordChange,
                    isEnabled = !state.isLoading,
                    label = "Senha :",
                    placeholderText = "Digite sua senha:",
                    leadingIcon = Icons.Default.Password,
                    trailingIcon = if (state.isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    onTrailingIconClick = viewModel.onTogglePasswordVisibility,
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
                    onCheckedChange = viewModel::onRememberMeCheckedChange
                )
                Spacer(modifier = Modifier.height(32.dp))
                ClassicButton(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .shimmerEffect(isLoading = state.isLoading),
                    onClick = viewModel::onLoginClick,
                    isEnabled = state.isLoginButtonEnabled,
                    textButton = "Login"
                )
                Spacer(modifier = Modifier.height(8.dp))
                SecondaryClassicButton(
                    textButton = "Não tem uma conta? Cadastrar-se",
                    onClick = viewModel::onRegisterClick,
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
                        .clickable { if (!state.isLoading) return@clickable viewModel.onForgotPasswordClick() }
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


@Preview(showBackground = true, name = "Light Theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun LoginScreenTemplatePreview() = LoginScreenTemplate(viewModel = FakeLoginViewModel())



@Preview(showBackground = true, name = "Night Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoginScreenTemplatePreview2() = LoginScreenTemplate(viewModel = FakeLoginViewModel())
