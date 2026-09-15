package br.com.wgc.ds_templates.screens.uber.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcBrandAuthHeader
import br.com.wgc.design_system.components.auth.WgcOtpCodeInput
import br.com.wgc.design_system.components.auth.WgcSocialLoginButtons
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class UberAuthUiState(
    val emailOrPhone: String = "",
    val name: String = "",
    val password: String = "",
    val otpCode: String = "",
    val isLoading: Boolean = false
)

abstract class BaseUberAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<UberAuthUiState>
    abstract fun onEmailOrPhoneChange(value: String)
    abstract fun onNameChange(value: String)
    abstract fun onPasswordChange(value: String)
    abstract fun onOtpCodeChange(value: String)
    abstract fun onSubmit()
}

class FakeUberAuthViewModel : BaseUberAuthViewModel() {
    override val uiState: StateFlow<UberAuthUiState> = MutableStateFlow(UberAuthUiState()).asStateFlow()
    override fun onEmailOrPhoneChange(value: String) {}
    override fun onNameChange(value: String) {}
    override fun onPasswordChange(value: String) {}
    override fun onOtpCodeChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcUberLoginScreenTemplate(viewModel: BaseUberAuthViewModel, onNavigateToRegister: () -> Unit = {}, onNavigateToResetPassword: () -> Unit = {}) {
    val state by viewModel.uiState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcBrandAuthHeader(
                brandName = "Uber",
                brandLogoText = "Uber",
                brandColor = Color(0xFF111111),
                title = "Vá a qualquer lugar com a Uber",
                subtitle = "Insira seu número ou e-mail"
            )

            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "Celular ou E-mail")
            WgcClassicButton(textButton = "Avançar", onClick = viewModel::onSubmit)

            TextButton(onClick = onNavigateToResetPassword, modifier = Modifier.fillMaxWidth()) {
                Text("Ajuda para entrar / Código por SMS")
            }

            HorizontalDivider()
            WgcSocialLoginButtons()
            WgcSecondaryClassicButton(textButton = "Criar conta na Uber", onClick = onNavigateToRegister)
        }
    }
}

@Composable
fun WgcUberRegisterScreenTemplate(viewModel: BaseUberAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
    val state by viewModel.uiState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcBrandAuthHeader(
                brandName = "Uber",
                brandLogoText = "Uber",
                brandColor = Color(0xFF111111),
                title = "Crie sua conta Uber",
                subtitle = "Informe seu nome e dados de contato"
            )

            SimpleTextField(value = state.name, onValueChange = viewModel::onNameChange, label = "Nome completo")
            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "Celular ou E-mail")
            SimpleTextField(value = state.password, onValueChange = viewModel::onPasswordChange, label = "Senha")

            WgcClassicButton(textButton = "Concluir Cadastro", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Já possui uma conta?", onClick = onNavigateToLogin)
        }
    }
}

@Composable
fun WgcUberResetPasswordScreenTemplate(viewModel: BaseUberAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
    val state by viewModel.uiState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcBrandAuthHeader(
                brandName = "Uber",
                brandLogoText = "Uber",
                brandColor = Color(0xFF111111),
                title = "Verificação de Segurança Uber",
                subtitle = "Insira o código de 6 dígitos enviado"
            )

            WgcOtpCodeInput(otpCode = state.otpCode, onOtpCodeChange = viewModel::onOtpCodeChange)
            WgcClassicButton(textButton = "Confirmar", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Voltar", onClick = onNavigateToLogin)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UberAuthPreview() {
    MaterialTheme {
        WgcUberLoginScreenTemplate(viewModel = FakeUberAuthViewModel())
    }
}
