package br.com.wgc.ds_templates.screens.login

data class LoginScreenUiState(
    // Dados do formulário
    val email: String = "",
    val password: String = "",

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