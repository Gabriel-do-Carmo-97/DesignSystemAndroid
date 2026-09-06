package br.com.wgc.ds_templates.screens.nineninefood.auth

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

data class NineNineAuthUiState(
    val emailOrPhone: String = "",
    val name: String = "",
    val password: String = "",
    val otpCode: String = "",
    val isLoading: Boolean = false
)

abstract class BaseNineNineAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<NineNineAuthUiState>
    abstract fun onEmailOrPhoneChange(value: String)
    abstract fun onNameChange(value: String)
    abstract fun onPasswordChange(value: String)
    abstract fun onOtpCodeChange(value: String)
    abstract fun onSubmit()
}

class FakeNineNineAuthViewModel : BaseNineNineAuthViewModel() {
    override val uiState: StateFlow<NineNineAuthUiState> = MutableStateFlow(NineNineAuthUiState()).asStateFlow()
    override fun onEmailOrPhoneChange(value: String) {}
    override fun onNameChange(value: String) {}
    override fun onPasswordChange(value: String) {}
    override fun onOtpCodeChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcNineNineLoginScreenTemplate(viewModel: BaseNineNineAuthViewModel, onNavigateToRegister: () -> Unit = {}, onNavigateToResetPassword: () -> Unit = {}) {
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
                brandName = "99Food",
                brandLogoText = "99",
                brandColor = Color(0xFF0B2545),
                title = "Entrar no 99Food",
                subtitle = "Peça seus pratos favoritos com cupons exclusivos"
            )

            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "Celular ou E-mail")
            WgcClassicButton(textButton = "Entrar no 99Food", onClick = viewModel::onSubmit)

            TextButton(onClick = onNavigateToResetPassword, modifier = Modifier.fillMaxWidth()) {
                Text("Esqueci a senha / Entrar por SMS")
            }

            HorizontalDivider()
            WgcSocialLoginButtons()
            WgcSecondaryClassicButton(textButton = "Criar conta no 99Food", onClick = onNavigateToRegister)
        }
    }
}

@Composable
fun WgcNineNineRegisterScreenTemplate(viewModel: BaseNineNineAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "99Food",
                brandLogoText = "99",
                brandColor = Color(0xFF0B2545),
                title = "Cadastro 99Food",
                subtitle = "Crie sua conta para aproveitar os descontos 99Club"
            )

            SimpleTextField(value = state.name, onValueChange = viewModel::onNameChange, label = "Nome completo")
            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "Número de Celular")

            WgcClassicButton(textButton = "Cadastrar no 99Food", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Já tenho uma conta 99", onClick = onNavigateToLogin)
        }
    }
}

@Composable
fun WgcNineNineResetPasswordScreenTemplate(viewModel: BaseNineNineAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "99Food",
                brandLogoText = "99",
                brandColor = Color(0xFF0B2545),
                title = "Recuperar Acesso 99Food",
                subtitle = "Digite o código enviado por SMS para seu celular"
            )

            WgcOtpCodeInput(otpCode = state.otpCode, onOtpCodeChange = viewModel::onOtpCodeChange)
            WgcClassicButton(textButton = "Confirmar Código", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Voltar ao Login", onClick = onNavigateToLogin)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NineNineAuthPreview() {
    MaterialTheme {
        WgcNineNineLoginScreenTemplate(viewModel = FakeNineNineAuthViewModel())
    }
}
