package br.com.wgc.ds_templates.screens.resetpassword.state

data class ResetPasswordScreenUiState(
    val title: String = "Recupere sua senha !",
    val isLoading: Boolean = false,
    val email: String = "",
    val emailError: String? = null,
)