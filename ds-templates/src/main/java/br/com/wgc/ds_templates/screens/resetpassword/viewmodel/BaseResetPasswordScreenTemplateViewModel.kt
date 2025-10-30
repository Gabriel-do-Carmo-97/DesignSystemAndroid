package br.com.wgc.ds_templates.screens.resetpassword.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import br.com.wgc.ds_templates.screens.resetpassword.state.ResetPasswordScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


/**
 * ViewModel base abstrato para a tela de redefinição de senha.
 *
 * Gerencia o estado da UI, incluindo o campo de e-mail, validações
 * reativas e interações do usuário, seguindo o padrão de um único StateFlow.
 */
abstract class BaseResetPasswordScreenTemplateViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ResetPasswordScreenUiState())
    val uiState: StateFlow<ResetPasswordScreenUiState> = _uiState.asStateFlow()


    /**
     * Ação a ser executada quando o botão de redefinir senha for clicado.
     * A implementação concreta deve realizar a chamada de API.
     */
    abstract fun onResetPasswordClick()

    /**
     * Ação a ser executada para navegar de volta para a tela de login.
     */
    abstract fun onBackToLoginClick()



    /**
     * Atualiza o e-mail no estado e executa a validação em tempo real.
     */
    val onEmailChange: (String) -> Unit = { newEmail ->
        _uiState.update { currentState ->
            currentState.copy(
                email = newEmail,
                emailError = validateEmail(newEmail)
            )
        }
    }

    private fun validateEmail(email: String): String? {
        return when {
            email.isBlank() -> "O e-mail é obrigatório"
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Formato de e-mail inválido"
            else -> null
        }
    }

    /**
     * Permite que a subclasse (ex: ResetPasswordViewModel) atualize o estado de forma segura.
     * Útil para controlar `isLoading` e `generalError`.
     */
    protected fun updateState(update: (currentState: ResetPasswordScreenUiState) -> ResetPasswordScreenUiState) {
        _uiState.update(update)
    }
}