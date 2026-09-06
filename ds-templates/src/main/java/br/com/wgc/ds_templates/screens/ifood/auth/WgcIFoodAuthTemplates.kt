package br.com.wgc.ds_templates.screens.ifood.auth

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

data class IFoodAuthUiState(
    val emailOrPhone: String = "",
    val name: String = "",
    val password: String = "",
    val otpCode: String = "",
    val isLoading: Boolean = false
)

abstract class BaseIFoodAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<IFoodAuthUiState>
    abstract fun onEmailOrPhoneChange(value: String)
    abstract fun onNameChange(value: String)
    abstract fun onPasswordChange(value: String)
    abstract fun onOtpCodeChange(value: String)
    abstract fun onSubmit()
}

class FakeIFoodAuthViewModel : BaseIFoodAuthViewModel() {
    override val uiState: StateFlow<IFoodAuthUiState> = MutableStateFlow(IFoodAuthUiState()).asStateFlow()
    override fun onEmailOrPhoneChange(value: String) {}
    override fun onNameChange(value: String) {}
    override fun onPasswordChange(value: String) {}
    override fun onOtpCodeChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcIFoodLoginScreenTemplate(viewModel: BaseIFoodAuthViewModel, onNavigateToRegister: () -> Unit = {}, onNavigateToResetPassword: () -> Unit = {}) {
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
                brandName = "iFood",
                brandLogoText = "iF",
                brandColor = Color(0xFFEA1D2C),
                title = "Falta pouco para matar sua fome!",
                subtitle = "Como deseja continuar?"
            )

            SimpleTextField(
                value = state.emailOrPhone,
                onValueChange = viewModel::onEmailOrPhoneChange,
                label = "E-mail ou número de celular"
            )

            WgcClassicButton(textButton = "Continuar", onClick = viewModel::onSubmit)

            TextButton(onClick = onNavigateToResetPassword, modifier = Modifier.fillMaxWidth()) {
                Text("Esqueci minha senha / Verificar por SMS")
            }

            HorizontalDivider()

            WgcSocialLoginButtons()

            WgcSecondaryClassicButton(textButton = "Criar nova conta no iFood", onClick = onNavigateToRegister)
        }
    }
}

@Composable
fun WgcIFoodRegisterScreenTemplate(viewModel: BaseIFoodAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "iFood",
                brandLogoText = "iF",
                brandColor = Color(0xFFEA1D2C),
                title = "Crie sua conta no iFood",
                subtitle = "Preencha seus dados para começar a pedir"
            )

            SimpleTextField(value = state.name, onValueChange = viewModel::onNameChange, label = "Nome completo")
            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "E-mail ou Celular")
            SimpleTextField(value = state.password, onValueChange = viewModel::onPasswordChange, label = "Senha (mínimo 6 caracteres)")

            WgcClassicButton(textButton = "Cadastrar no iFood", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Já tenho uma conta", onClick = onNavigateToLogin)
        }
    }
}

@Composable
fun WgcIFoodResetPasswordScreenTemplate(viewModel: BaseIFoodAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "iFood",
                brandLogoText = "iF",
                brandColor = Color(0xFFEA1D2C),
                title = "Recuperar Conta iFood",
                subtitle = "Digite o código enviado por SMS/E-mail"
            )

            WgcOtpCodeInput(otpCode = state.otpCode, onOtpCodeChange = viewModel::onOtpCodeChange)
            WgcClassicButton(textButton = "Verificar Código", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Voltar ao Login", onClick = onNavigateToLogin)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun IFoodAuthPreview() {
    MaterialTheme {
        WgcIFoodLoginScreenTemplate(viewModel = FakeIFoodAuthViewModel())
    }
}
