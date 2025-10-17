package br.com.wgc.ds_templates.screens.login

class LoginScreenUiState(
    val imageLogo: String = "",
    val onLoginClick: () -> Unit = {},
    val onRegisterClick: () -> Unit = {},
    val onForgotPasswordClick: () -> Unit = {},
    val onTermsClick: () -> Unit = {},
) {
}