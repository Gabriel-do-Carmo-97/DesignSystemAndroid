package br.com.wgc.ds_templates.screens.mercadolivre.auth

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

data class MercadoLivreAuthUiState(
    val emailOrPhone: String = "",
    val name: String = "",
    val password: String = "",
    val otpCode: String = "",
    val isLoading: Boolean = false
)

abstract class BaseMercadoLivreAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<MercadoLivreAuthUiState>
    abstract fun onEmailOrPhoneChange(value: String)
    abstract fun onNameChange(value: String)
    abstract fun onPasswordChange(value: String)
    abstract fun onOtpCodeChange(value: String)
    abstract fun onSubmit()
}

class FakeMercadoLivreAuthViewModel : BaseMercadoLivreAuthViewModel() {
    override val uiState: StateFlow<MercadoLivreAuthUiState> = MutableStateFlow(MercadoLivreAuthUiState()).asStateFlow()
    override fun onEmailOrPhoneChange(value: String) {}
    override fun onNameChange(value: String) {}
    override fun onPasswordChange(value: String) {}
    override fun onOtpCodeChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcMercadoLivreLoginScreenTemplate(viewModel: BaseMercadoLivreAuthViewModel, onNavigateToRegister: () -> Unit = {}, onNavigateToResetPassword: () -> Unit = {}) {
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
                brandName = "Mercado Livre",
                brandLogoText = "ML",
                brandColor = Color(0xFFFFE600),
                title = "Digite seu e-mail, e-mail ou usuário",
                subtitle = "Para acessar sua conta do Mercado Livre e Mercado Pago"
            )

            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "E-mail, telefone ou usuário")
            WgcClassicButton(textButton = "Continuar", onClick = viewModel::onSubmit)

            TextButton(onClick = onNavigateToResetPassword, modifier = Modifier.fillMaxWidth()) {
                Text("Preciso de ajuda com minha senha ou conta")
            }

            HorizontalDivider()
            WgcSocialLoginButtons()
            WgcSecondaryClassicButton(textButton = "Criar conta no Mercado Livre", onClick = onNavigateToRegister)
        }
    }
}

@Composable
fun WgcMercadoLivreRegisterScreenTemplate(viewModel: BaseMercadoLivreAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Mercado Livre",
                brandLogoText = "ML",
                brandColor = Color(0xFFFFE600),
                title = "Complete seus dados para se cadastrar",
                subtitle = "Sua conta valerá para Mercado Livre e Mercado Pago"
            )

            SimpleTextField(value = state.name, onValueChange = viewModel::onNameChange, label = "Nome e Sobrenome")
            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "E-mail")

            WgcClassicButton(textButton = "Validar e Cadastrar", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Já sou cadastrado", onClick = onNavigateToLogin)
        }
    }
}

@Composable
fun WgcMercadoLivreResetPasswordScreenTemplate(viewModel: BaseMercadoLivreAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Mercado Livre",
                brandLogoText = "ML",
                brandColor = Color(0xFFFFE600),
                title = "Código de Segurança",
                subtitle = "Digite o código enviado por e-mail/SMS para redefinir"
            )

            WgcOtpCodeInput(otpCode = state.otpCode, onOtpCodeChange = viewModel::onOtpCodeChange)
            WgcClassicButton(textButton = "Confirmar", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Voltar ao Login", onClick = onNavigateToLogin)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MercadoLivreAuthPreview() {
    MaterialTheme {
        WgcMercadoLivreLoginScreenTemplate(viewModel = FakeMercadoLivreAuthViewModel())
    }
}
