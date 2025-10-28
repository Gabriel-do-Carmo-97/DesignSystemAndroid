package br.com.wgc.ds_templates.screens.login.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wgc.ds_templates.screens.login.state.LoginScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn


abstract class BaseLoginScreenTemplateViewModel : ViewModel() {

    protected val email = MutableStateFlow("")
    val onEmailChange: (String) -> Unit = { email.value = it }
    val password = MutableStateFlow("")
    val onPasswordChange: (String) -> Unit = { password.value = it }

    private val emailError = combine(email) { (email) ->
        if (email.isBlank()) "O e-mail é obrigatório"
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) "E-mail inválido"
        else if (email.length < 5) "O e-mail deve ter pelo menos 5 caracteres"
        else if (email.length > 50) "O e-mail deve ter no máximo 50 caracteres"
        else null
    }

    private val passwordError = combine(password) { (password) ->
        if (password.length < 8) "A senha deve ter no mínimo 8 caracteres"
        else if (!password.any { it.isDigit() }) "A senha deve conter pelo menos um número"
        else if (!password.any { it.isUpperCase() }) "A senha deve conter pelo menos uma letra maiúscula"
        else if (!password.any { it.isLowerCase() }) "A senha deve conter pelo menos uma letra minúscula"
        else if (!password.any { !it.isLetterOrDigit() }) "A senha deve conter pelo menos um caractere especial"
        else null
    }

    val uiState: StateFlow<LoginScreenUiState> = combine(
        email,
        password,
        emailError,
        passwordError
    ) { email, password, emailError, passwordError ->
        LoginScreenUiState(
            email = email,
            password = password,
            emailError = emailError,
            passwordError = passwordError
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(3000),
        initialValue = LoginScreenUiState(),
    )

    abstract fun onLoginClick()
    abstract fun onRegisterClick()
    abstract fun onForgotPasswordClick()
}
