package br.com.wgc.ds_templates.screens.globalmarketplace.auth

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
import br.com.wgc.core_ds.WgcCoreDsColors
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

data class GlobalMarketplaceAuthUiState(
    val emailOrPhone: String = "",
    val name: String = "",
    val password: String = "",
    val otpCode: String = "",
    val isLoading: Boolean = false
)

abstract class BaseGlobalMarketplaceAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<GlobalMarketplaceAuthUiState>
    abstract fun onEmailOrPhoneChange(value: String)
    abstract fun onNameChange(value: String)
    abstract fun onPasswordChange(value: String)
    abstract fun onOtpCodeChange(value: String)
    abstract fun onSubmit()
}

class FakeGlobalMarketplaceAuthViewModel : BaseGlobalMarketplaceAuthViewModel() {
    override val uiState: StateFlow<GlobalMarketplaceAuthUiState> = MutableStateFlow(GlobalMarketplaceAuthUiState()).asStateFlow()
    override fun onEmailOrPhoneChange(value: String) {}
    override fun onNameChange(value: String) {}
    override fun onPasswordChange(value: String) {}
    override fun onOtpCodeChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcGlobalMarketplaceLoginScreenTemplate(viewModel: BaseGlobalMarketplaceAuthViewModel, onNavigateToRegister: () -> Unit = {}, onNavigateToResetPassword: () -> Unit = {}) =
    WgcGenericPlaceholderTemplate(title = "Esqueceu a senha?")

@Composable
fun WgcGlobalMarketplaceRegisterScreenTemplate(viewModel: BaseGlobalMarketplaceAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Global Marketplace",
                brandLogoText = "GM",
                brandColor = Color(WgcCoreDsColors.globalMarketplaceRed),
                title = "Cadastrar no Marketplace Global",
                subtitle = "Ganhe cupons para novos usuários"
            )

            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "E-mail")
            SimpleTextField(value = state.password, onValueChange = viewModel::onPasswordChange, label = "Senha")

            WgcClassicButton(textButton = "Cadastrar e Obter Ofertas", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Já possui uma conta?", onClick = onNavigateToLogin)
        }
    }
}

@Composable
fun WgcGlobalMarketplaceResetPasswordScreenTemplate(viewModel: BaseGlobalMarketplaceAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Global Marketplace",
                brandLogoText = "GM",
                brandColor = Color(WgcCoreDsColors.globalMarketplaceRed),
                title = "Redefinir Senha no Marketplace Global",
                subtitle = "Insira o código de verificação enviado"
            )

            WgcOtpCodeInput(otpCode = state.otpCode, onOtpCodeChange = viewModel::onOtpCodeChange)
            WgcClassicButton(textButton = "Confirmar Código", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Voltar ao Login", onClick = onNavigateToLogin)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GlobalMarketplaceAuthPreview() {
    MaterialTheme {
        WgcGlobalMarketplaceLoginScreenTemplate(viewModel = FakeGlobalMarketplaceAuthViewModel())
    }
}
