package br.com.wgc.design_system.templates.screens.register.user.state

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserScreenUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val nameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmPasswordError: String? = null,
    val isPasswordVisible: Boolean = false,
    val isConfirmPasswordVisible: Boolean = false,
    val lastName: String = "",
    val lastNameError: String? = null,
    val phone: String = "",
    val phoneError: String? = null,
    val acceptedTerms: Boolean = false,
    val acceptedTermsError: String? = null,

    val isLoading: Boolean = false,
    val generalError: String? = null
){
    /**
     * Lógica computada para habilitar ou desabilitar o botão de registro.
     * Garante que todos os campos estão preenchidos corretamente e sem erros
     * antes de permitir a submissão.
     */
    val isRegisterButtonEnabled: Boolean
        get() = !isLoading &&
                acceptedTerms &&
                name.isNotBlank() &&
                lastName.isNotBlank() &&
                email.isNotBlank() &&
                phone.isNotBlank() &&
                password.isNotBlank() &&
                confirmPassword.isNotBlank() &&
                nameError == null &&
                lastNameError == null &&
                emailError == null &&
                phoneError == null &&
                passwordError == null &&
                confirmPasswordError == null
}