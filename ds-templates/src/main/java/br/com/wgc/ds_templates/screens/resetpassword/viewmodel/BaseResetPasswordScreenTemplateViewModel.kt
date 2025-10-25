package br.com.wgc.ds_templates.screens.resetpassword.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wgc.ds_templates.screens.resetpassword.state.ResetPasswordScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

abstract class BaseResetPasswordScreenTemplateViewModel : ViewModel() {
    protected val email = MutableStateFlow("")
    val onEmailChange: (String) -> Unit = { email.value = it }
    private val _isLoading = MutableStateFlow(false)

    private val emailError = combine(email) { (email) ->
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) "E-mail inválido"
        else if (email.length < 5) "O e-mail deve ter pelo menos 5 caracteres"
        else null
    }

    val uiState: StateFlow<ResetPasswordScreenUiState> = combine(
        email,
        _isLoading,
        emailError
    ) { email, isLoading, emailError ->
        ResetPasswordScreenUiState(
            email = email,
            isLoading = isLoading,
            emailError = emailError
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(3000),
        initialValue = ResetPasswordScreenUiState(),
    )

    abstract fun<T: Any> onRegisterClick() : T
    abstract fun onRegisterClick()
}