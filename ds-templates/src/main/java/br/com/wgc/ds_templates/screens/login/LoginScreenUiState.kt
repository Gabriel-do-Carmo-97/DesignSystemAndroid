package br.com.wgc.ds_templates.screens.login

import br.com.wgc.design_system.R
import br.com.wgc.design_system.components.providers_login.LoginProviderModel

data class LoginScreenUiState(
    // Dados do formulário
    val email: String = "",
    val password: String = "",
    val providers: List<LoginProviderModel> = listOf(
        LoginProviderModel(
            iconRes = R.drawable.google,
            contentDescription = "Google",
            onClick = {}
        ),
        LoginProviderModel(
            iconRes = R.drawable.facebook,
            contentDescription = "Google",
            onClick = {}
        ),
        LoginProviderModel(
            iconRes = R.drawable.phone,
            contentDescription = "Google",
            onClick = {}
        )
    ),

    // Estado da UI
    val imageLogo: String = "",
    val imageLogoDescription: String = "",

    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,

    // Estado de erros (podem ser nulos se não houver erro)
    val emailError: String? = null,
    val passwordError: String? = null,
    val generalError: String? = null,
)