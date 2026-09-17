package br.com.wgc.ds_templates.screens.fooddelivery.auth

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

data class FoodDeliveryAuthUiState(
    val emailOrPhone: String = "",
    val name: String = "",
    val password: String = "",
    val otpCode: String = "",
    val isLoading: Boolean = false
)

abstract class BaseFoodDeliveryAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<FoodDeliveryAuthUiState>
    abstract fun onEmailOrPhoneChange(value: String)
    abstract fun onNameChange(value: String)
    abstract fun onPasswordChange(value: String)
    abstract fun onOtpCodeChange(value: String)
    abstract fun onSubmit()
}

class FakeFoodDeliveryAuthViewModel : BaseFoodDeliveryAuthViewModel() {
    override val uiState: StateFlow<FoodDeliveryAuthUiState> = MutableStateFlow(FoodDeliveryAuthUiState()).asStateFlow()
    override fun onEmailOrPhoneChange(value: String) {}
    override fun onNameChange(value: String) {}
    override fun onPasswordChange(value: String) {}
    override fun onOtpCodeChange(value: String) {}
    override fun onSubmit() {}
}

@Composable
fun WgcFoodDeliveryLoginScreenTemplate(viewModel: BaseFoodDeliveryAuthViewModel, onNavigateToRegister: () -> Unit = {}, onNavigateToResetPassword: () -> Unit = {}) =
    WgcGenericPlaceholderTemplate(title = "Esqueci minha senha / Verificar por SMS")

@Composable
fun WgcFoodDeliveryRegisterScreenTemplate(viewModel: BaseFoodDeliveryAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Food Delivery",
                brandLogoText = "iF",
                brandColor = Color(0xFFEA1D2C),
                title = "Crie sua conta no Food Delivery",
                subtitle = "Preencha seus dados para começar a pedir"
            )

            SimpleTextField(value = state.name, onValueChange = viewModel::onNameChange, label = "Nome completo")
            SimpleTextField(value = state.emailOrPhone, onValueChange = viewModel::onEmailOrPhoneChange, label = "E-mail ou Celular")
            SimpleTextField(value = state.password, onValueChange = viewModel::onPasswordChange, label = "Senha (mínimo 6 caracteres)")

            WgcClassicButton(textButton = "Cadastrar no Food Delivery", onClick = viewModel::onSubmit)
            WgcSecondaryClassicButton(textButton = "Já tenho uma conta", onClick = onNavigateToLogin)
        }
    }
}

@Composable
fun WgcFoodDeliveryResetPasswordScreenTemplate(viewModel: BaseFoodDeliveryAuthViewModel, onNavigateToLogin: () -> Unit = {}) {
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
                brandName = "Food Delivery",
                brandLogoText = "iF",
                brandColor = Color(0xFFEA1D2C),
                title = "Recuperar Conta Food Delivery",
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
private fun FoodDeliveryAuthPreview() {
    MaterialTheme {
        WgcFoodDeliveryLoginScreenTemplate(viewModel = FakeFoodDeliveryAuthViewModel())
    }
}
