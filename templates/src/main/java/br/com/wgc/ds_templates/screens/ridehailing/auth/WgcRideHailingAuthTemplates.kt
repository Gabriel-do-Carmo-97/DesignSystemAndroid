package br.com.wgc.ds_templates.screens.ridehailing.auth

import br.com.wgc.ds_templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

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

data class RideHailingAuthUiState(
    val emailOrPhone: String = "",
    val name: String = "",
    val password: String = "",
    val otpCode: String = "",
    val isLoading: Boolean = false
)

abstract class BaseRideHailingAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<RideHailingAuthUiState>
    abstract fun onEmailOrPhoneChange(value: String)
    abstract fun onNameChange(value: String)
    abstract fun onPasswordChange(value: String)
    abstract fun onOtpCodeChange(value: String)
    abstract fun onSubmit()
}

class FakeRideHailingAuthViewModel : BaseRideHailingAuthViewModel() {
    override val uiState: StateFlow<RideHailingAuthUiState> = MutableStateFlow(RideHailingAuthUiState()).asStateFlow()
    override fun onEmailOrPhoneChange(value: String) {}
    override fun onNameChange(value: String) {}
    override fun onPasswordChange(value: String) {}
    override fun onOtpCodeChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcRideHailingLoginScreenTemplate(viewModel: BaseRideHailingAuthViewModel, onNavigateToRegister: () -> Unit = {}, onNavigateToResetPassword: () -> Unit = {}) =
    WgcGenericPlaceholderTemplate(title = "Ajuda para entrar / Código por SMS")

@Composable
fun WgcRideHailingRegisterScreenTemplate(viewModel: BaseRideHailingAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Ride Hailing",
                brandLogoText = "Ride Hailing",
                brandColor = Color(0xFF111111),
                title = "Crie sua conta Ride Hailing",
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
fun WgcRideHailingResetPasswordScreenTemplate(viewModel: BaseRideHailingAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Ride Hailing",
                brandLogoText = "Ride Hailing",
                brandColor = Color(0xFF111111),
                title = "Verificação de Segurança Ride Hailing",
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
private fun RideHailingAuthPreview() {
    MaterialTheme {
        WgcRideHailingLoginScreenTemplate(viewModel = FakeRideHailingAuthViewModel())
    }
}
