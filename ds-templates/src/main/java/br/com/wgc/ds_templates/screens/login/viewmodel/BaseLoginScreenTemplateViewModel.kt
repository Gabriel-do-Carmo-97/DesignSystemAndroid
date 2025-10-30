package br.com.wgc.ds_templates.screens.login.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import br.com.wgc.ds_templates.screens.login.state.LoginScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


abstract class BaseLoginScreenTemplateViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(LoginScreenUiState())

    val uiState: StateFlow<LoginScreenUiState> = _uiState.asStateFlow()

    abstract fun onLoginClick()
    abstract fun onRegisterClick()
    abstract fun onForgotPasswordClick()


    /**
     * Função chamada pela UI sempre que o campo de e-mail muda.
     * Ela atualiza o valor do e-mail e executa a validação reativamente.
     */
    val onEmailChange: (String) -> Unit = { newEmail ->
        _uiState.update { currentState ->
            currentState.copy(
                email = newEmail,
                emailError = validateEmail(newEmail)
            )
        }
    }

    /**
     * Função chamada pela UI sempre que o campo de senha muda.
     * Ela atualiza o valor da senha e executa a validação reativamente.
     */
    val onPasswordChange: (String) -> Unit = { newPassword ->
        _uiState.update { currentState ->
            currentState.copy(
                password = newPassword,
                passwordError = validatePassword(newPassword)
            )
        }
    }

    /**
     * Função chamada pela UI para alternar a visibilidade da senha.
     */
    val onTogglePasswordVisibility: () -> Unit = {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    private fun validateEmail(email: String): String? {
        return when {
            email.isBlank() -> "O e-mail é obrigatório"
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "E-mail inválido"
            email.length < 5 -> "O e-mail deve ter pelo menos 5 caracteres"
            email.length > 50 -> "O e-mail deve ter no máximo 50 caracteres"
            else -> null
        }
    }

    private fun validatePassword(password: String): String? {
        return when {
            password.isNotBlank() && password.length < 8 -> "A senha deve ter no mínimo 8 caracteres"
            password.isNotBlank() && !password.any { it.isDigit() } -> "A senha deve conter pelo menos um número"
            password.isNotBlank() && !password.any { it.isUpperCase() } -> "A senha deve conter pelo menos uma letra maiúscula"
            password.isNotBlank() && !password.any { it.isLowerCase() } -> "A senha deve conter pelo menos uma letra minúscula"
            password.isNotBlank() && !password.any { !it.isLetterOrDigit() } -> "A senha deve conter pelo menos um caractere especial"
            else -> null
        }
    }

    /**
     * Permite que a subclasse (LoginViewModel) atualize o estado de forma segura.
     * Isso será usado para controlar o `isLoading` do Shimmer e os erros gerais.
     */
    protected fun updateState(update: (currentState: LoginScreenUiState) -> LoginScreenUiState) {
        _uiState.update(update)
    }
}
