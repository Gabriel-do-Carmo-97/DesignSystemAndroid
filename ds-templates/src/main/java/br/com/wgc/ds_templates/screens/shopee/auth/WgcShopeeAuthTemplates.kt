package br.com.wgc.ds_templates.screens.shopee.auth

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

data class ShopeeAuthUiState(
    val emailOrPhone: String = "",
    val name: String = "",
    val password: String = "",
    val otpCode: String = "",
    val isLoading: Boolean = false
)

abstract class BaseShopeeAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<ShopeeAuthUiState>
    abstract fun onEmailOrPhoneChange(value: String)
    abstract fun onNameChange(value: String)
    abstract fun onPasswordChange(value: String)
    abstract fun onOtpCodeChange(value: String)
    abstract fun onSubmit()
}

class FakeShopeeAuthViewModel : BaseShopeeAuthViewModel() {
    override val uiState: StateFlow<ShopeeAuthUiState> = MutableStateFlow(ShopeeAuthUiState()).asStateFlow()
    override fun onEmailOrPhoneChange(value: String) {}
    override fun onNameChange(value: String) {}
    override fun onPasswordChange(value: String) {}
    override fun onOtpCodeChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcShopeeLoginScreenTemplate(viewModel: BaseShopeeAuthViewModel, onNavigateToRegister: () -> Unit = {}, onNavigateToResetPassword: () -> Unit = {}) {
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
                brandName = "Shopee",
                brandLogoText = "S",
                brandColor = Color(0xFFEE4D2D),
                title = "Entre na Shopee",
                subtitle = "Aproveite cupons de frete grátis e ofertas"
            )

            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "Telefone, E-mail ou Usuário")
            SimpleTextField(value = state.password, onValueChange = viewModel::onPasswordChange, label = "Senha")

            WgcClassicButton(textButton = "Entrar", onClick = viewModel::onSubmit)

            TextButton(onClick = onNavigateToResetPassword, modifier = Modifier.fillMaxWidth()) {
                Text("Esqueceu a senha? / Entrar com SMS")
            }

            HorizontalDivider()
            WgcSocialLoginButtons()
            WgcSecondaryClassicButton(textButton = "Cadastrar-se na Shopee", onClick = onNavigateToRegister)
        }
    }
}

@Composable
fun WgcShopeeRegisterScreenTemplate(viewModel: BaseShopeeAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Shopee",
                brandLogoText = "S",
                brandColor = Color(0xFFEE4D2D),
                title = "Cadastrar na Shopee",
                subtitle = "Informe seu número de celular para receber o código"
            )

            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "Número de Telefone")
            WgcClassicButton(textButton = "Próximo", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Já possui uma conta Shopee?", onClick = onNavigateToLogin)
        }
    }
}

@Composable
fun WgcShopeeResetPasswordScreenTemplate(viewModel: BaseShopeeAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Shopee",
                brandLogoText = "S",
                brandColor = Color(0xFFEE4D2D),
                title = "Verificação do Celular",
                subtitle = "Insira o código enviado por SMS para redefinir"
            )

            WgcOtpCodeInput(otpCode = state.otpCode, onOtpCodeChange = viewModel::onOtpCodeChange)
            WgcClassicButton(textButton = "Confirmar Código", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Voltar ao Login", onClick = onNavigateToLogin)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShopeeAuthPreview() {
    MaterialTheme {
        WgcShopeeLoginScreenTemplate(viewModel = FakeShopeeAuthViewModel())
    }
}
