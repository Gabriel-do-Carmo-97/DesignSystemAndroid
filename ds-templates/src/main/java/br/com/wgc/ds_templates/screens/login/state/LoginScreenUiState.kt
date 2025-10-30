package br.com.wgc.ds_templates.screens.login.state

import br.com.wgc.design_system.R
import br.com.wgc.design_system.components.providers_login.LoginProviderModel
import kotlinx.serialization.Serializable

@Serializable
data class LoginScreenUiState(
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

    val imageLogo: String = "",
    val imageLogoDescription: String = "",
    val isChecked: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,

    val emailError: String? = null,
    val passwordError: String? = null,
    val generalError: String? = null,
){
    val isLoginButtonEnabled: Boolean
        get() = !isLoading && email.isNotBlank() &&
                password.isNotBlank() && emailError == null &&
                passwordError == null && generalError == null
}