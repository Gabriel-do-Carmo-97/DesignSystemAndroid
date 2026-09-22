package br.com.wgc.design_system.templates.screens.dealmarketplace.auth

import br.com.wgc.design_system.templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

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
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcBrandAuthHeader
import br.com.wgc.design_system.components.auth.WgcOtpCodeInput
import br.com.wgc.design_system.components.auth.WgcSocialLoginButtons
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DealMarketplaceAuthUiState(
    val emailOrPhone: String = "",
    val name: String = "",
    val password: String = "",
    val otpCode: String = "",
    val isLoading: Boolean = false
)

abstract class BaseDealMarketplaceAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<DealMarketplaceAuthUiState>
    abstract fun onEmailOrPhoneChange(value: String)
    abstract fun onNameChange(value: String)
    abstract fun onPasswordChange(value: String)
    abstract fun onOtpCodeChange(value: String)
    abstract fun onSubmit()
}

class FakeDealMarketplaceAuthViewModel : BaseDealMarketplaceAuthViewModel() {
    override val uiState: StateFlow<DealMarketplaceAuthUiState> = MutableStateFlow(DealMarketplaceAuthUiState()).asStateFlow()
    override fun onEmailOrPhoneChange(value: String) {}
    override fun onNameChange(value: String) {}
    override fun onPasswordChange(value: String) {}
    override fun onOtpCodeChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcDealMarketplaceLoginScreenTemplate(viewModel: BaseDealMarketplaceAuthViewModel, onNavigateToRegister: () -> Unit = {}, onNavigateToResetPassword: () -> Unit = {}) =
    WgcGenericPlaceholderTemplate(title = "Esqueceu a senha? / Entrar com SMS")

@Composable
fun WgcDealMarketplaceRegisterScreenTemplate(viewModel: BaseDealMarketplaceAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Deal Marketplace",
                brandLogoText = "DM",
                brandColor = Color(WgcCoreDsColors.dealMarketplaceOrange),
                title = "Cadastrar no Marketplace",
                subtitle = "Informe seu número de celular para receber o código"
            )

            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "Número de Telefone")
            WgcClassicButton(textButton = "Próximo", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Já possui uma conta no Marketplace?", onClick = onNavigateToLogin)
        }
    }
}

@Composable
fun WgcDealMarketplaceResetPasswordScreenTemplate(viewModel: BaseDealMarketplaceAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Deal Marketplace",
                brandLogoText = "DM",
                brandColor = Color(WgcCoreDsColors.dealMarketplaceOrange),
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
private fun WgcDealMarketplaceAuthPreview() {
    MaterialTheme {
        WgcDealMarketplaceLoginScreenTemplate(viewModel = FakeDealMarketplaceAuthViewModel())
    }
}
