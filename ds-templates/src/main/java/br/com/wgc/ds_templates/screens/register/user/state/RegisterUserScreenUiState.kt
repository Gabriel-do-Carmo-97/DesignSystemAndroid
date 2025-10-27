package br.com.wgc.ds_templates.screens.register.user.state

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserScreenUiState(
    val name: String = "",
    val nameError: String? = null,

    val email: String = "",
    val emailError: String? = null,

    val password: String = "",
    val passwordError: String? = null,

    val lastName: String = "",
    val lastNameError: String? = null,

    val phone: String = "",
    val phoneError: String? = null,

    val confirmPassword: String = "",
    val confirmPasswordError: String? = null,

    val acceptedTerms: Boolean = false,
    val acceptedTermsError: String? = null,

    val isLoading: Boolean = false,

){
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