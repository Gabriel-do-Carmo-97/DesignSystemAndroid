package br.com.wgc.ds_templates.screens.register.user.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import br.com.wgc.ds_templates.screens.register.user.state.RegisterUserScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel base abstrato para uma tela de cadastro de usuário completa.
 *
 * Gerencia o estado da UI, incluindo os campos do formulário (nome, sobrenome, e-mail, telefone, senha),
 * validações reativas e interações do usuário.
 */
abstract class BaseRegisterUserTemplateViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUserScreenUiState())
    val uiState: StateFlow<RegisterUserScreenUiState> = _uiState.asStateFlow()

    abstract fun onRegisterClick()
    abstract fun onLoginClick()
    abstract fun onTermsClick()
    abstract fun onBackClick()


    /** Atualiza o nome e executa a validação. */
    val onNameChange: (String) -> Unit = { newName ->
        _uiState.update { it.copy(name = newName, nameError = validateName(newName)) }
    }

    /** Atualiza o sobrenome e executa a validação. */
    val onLastNameChange: (String) -> Unit = { newLastName ->
        _uiState.update { it.copy(lastName = newLastName, lastNameError = validateLastName(newLastName)) }
    }

    /** Atualiza o e-mail e executa a validação. */
    val onEmailChange: (String) -> Unit = { newEmail ->
        _uiState.update { it.copy(email = newEmail, emailError = validateEmail(newEmail)) }
    }

    /** Atualiza o telefone e executa a validação. */
    val onPhoneChange: (String) -> Unit = { newPhone ->
        _uiState.update { it.copy(phone = newPhone, phoneError = validatePhone(newPhone)) }
    }

    /** Atualiza a senha e executa a validação. */
    val onPasswordChange: (String) -> Unit = { newPassword ->
        _uiState.update { currentState ->
            currentState.copy(
                password = newPassword,
                passwordError = validatePassword(newPassword),
                confirmPasswordError = validateConfirmPassword(currentState.confirmPassword, newPassword)
            )
        }
    }

    /** Atualiza a confirmação de senha e executa a validação. */
    val onConfirmPasswordChange: (String) -> Unit = { newConfirmPassword ->
        _uiState.update { currentState ->
            currentState.copy(
                confirmPassword = newConfirmPassword,
                confirmPasswordError = validateConfirmPassword(newConfirmPassword, currentState.password)
            )
        }
    }

    /** Alterna a visibilidade da senha. */
    val onTogglePasswordVisibility: () -> Unit = {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    /** Alterna a visibilidade da confirmação de senha. */
    val onToggleConfirmPasswordVisibility: () -> Unit = {
        _uiState.update { it.copy(isConfirmPasswordVisible = !it.isConfirmPasswordVisible) }
    }

    /** Atualiza o estado de aceite dos termos. */
    val onAcceptedTermsChange: (Boolean) -> Unit = { isChecked ->
        _uiState.update { it.copy(acceptedTerms = isChecked) }
    }

    private fun validateName(name: String): String? {
        return if (name.trim().length < 2) "O nome é muito curto" else null
    }

    private fun validateLastName(lastName: String): String? {
        return if (lastName.trim().length < 2) "O sobrenome é muito curto" else null
    }

    private fun validateEmail(email: String): String? {
        return if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Formato de e-mail inválido" else null
    }

    private fun validatePhone(phone: String): String? {
        // Validação simples: verifica se tem entre 10 e 11 dígitos numéricos.
        val phoneDigits = phone.filter { it.isDigit() }
        return if (phoneDigits.length !in 10..11) "Número de telefone inválido" else null
    }

    private fun validatePassword(password: String): String? {
        return when {
            password.length < 8 -> "A senha deve ter no mínimo 8 caracteres"
            !password.any { it.isDigit() } -> "A senha deve conter pelo menos um número"
            !password.any { it.isUpperCase() } -> "A senha deve conter uma letra maiúscula"
            else -> null
        }
    }

    private fun validateConfirmPassword(confirmPassword: String, password: String): String? {
        return if (confirmPassword != password) "As senhas não coincidem" else null
    }

    /**
     * Permite que a subclasse (ex: RegisterUserViewModel) atualize o estado de forma segura.
     * Útil para controlar `isLoading` e `generalError`.
     */
    protected fun updateState(update: (currentState: RegisterUserScreenUiState) -> RegisterUserScreenUiState) {
        _uiState.update(update)
    }
}