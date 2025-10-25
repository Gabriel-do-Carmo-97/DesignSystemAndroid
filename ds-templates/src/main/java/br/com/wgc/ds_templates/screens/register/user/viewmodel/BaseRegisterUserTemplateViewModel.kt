package br.com.wgc.ds_templates.screens.register.user.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wgc.ds_templates.screens.register.user.state.RegisterUserScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

abstract class BaseRegisterUserTemplateViewModel: ViewModel() {
    protected val name = MutableStateFlow("")
    val onNameChange: (String) -> Unit = { name.value = it }
    protected val lastName = MutableStateFlow("")
    val onLastNameChange: (String) -> Unit = { lastName.value = it }

    protected val email = MutableStateFlow("")
    val onEmailChange: (String) -> Unit = { email.value = it }
    protected val phone = MutableStateFlow("")
    val onPhoneChange: (String) -> Unit = { phone.value = it }
    protected val password = MutableStateFlow("")
    val onPasswordChange: (String) -> Unit = { password.value = it }
    protected val confirmPassword = MutableStateFlow("")
    val onConfirmPasswordChange: (String) -> Unit = { confirmPassword.value = it }
    protected val acceptedTerms = MutableStateFlow(false)
    val onTermsChange: (Boolean) -> Unit = { acceptedTerms.value = it }
    private val _isLoading = MutableStateFlow(false)

    private val nameError = combine(name) { (name) ->
        if (name.isBlank()) "O nome não pode ser vazio"
        else if (name.length < 3) "O nome deve ter pelo menos 3 caracteres"
        else if (name.any { it.isDigit() }) "O nome não pode conter números"
        else if (name.any { !it.isLetter() && it != ' ' }) "O nome não pode conter caracteres especiais"
        else null
    }

    private val lastNameError = combine(name, lastName) { (name, lastName) ->
        if (lastName.isBlank()) "O sobrenome não pode ser vazio"
        else if (lastName.length < 3) "O sobrenome deve ter pelo menos 3 caracteres"
        else if (lastName.any { it.isDigit() }) "O sobrenome não pode conter números"
        else if (lastName.any { !it.isLetter() && it != ' ' }) "O sobrenome não pode conter caracteres especiais"
        else if (name == lastName) "O sobrenome não pode ser igual ao nome"
        else null
    }

    private val emailError = combine(email) { (email) ->
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) "E-mail inválido"
        else if (email.length < 5) "O e-mail deve ter pelo menos 5 caracteres"
        else null
    }

    private val phoneError = combine(phone) { (phone) ->
        if (phone.length < 10) "Telefone inválido"
        else if (phone.any { !it.isDigit() }) "Telefone deve conter apenas números"
        else if (phone.length > 11) "Telefone deve conter no máximo 11 dígitos"
        else if (phone.length < 10) "Telefone deve conter no mínimo 10 dígitos"
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

    private val confirmPasswordError = combine(password, confirmPassword) { (pass, confirmPass) ->
        if (pass != confirmPass) "As senhas não coincidem"
        else null
    }

    private val acceptedTermsError = combine(acceptedTerms) { (accepted) ->
        if (!accepted) "Você deve aceitar os termos"
        else null
    }

    val nameState: StateFlow<RegisterUserScreenUiState> = combine(
        name,
        lastName,
        nameError,
        lastNameError,
    ){name, lastName, nameError, lastNameError ->
        RegisterUserScreenUiState(
            name = name,
            lastName = lastName,
            nameError = nameError,
            lastNameError = lastNameError,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(3000),
        initialValue = RegisterUserScreenUiState()
    )
    val passwordState: StateFlow<RegisterUserScreenUiState> = combine(
        password,
        confirmPassword,
        passwordError,
        confirmPasswordError,
    ){password, confirmPassword, passwordError, confirmPasswordError ->
        RegisterUserScreenUiState(
            password = password,
            confirmPassword = confirmPassword,
            passwordError = passwordError,
            confirmPasswordError = confirmPasswordError,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(3000),
        initialValue = RegisterUserScreenUiState()
    )

    val othersDataUserState: StateFlow<RegisterUserScreenUiState> = combine(
        email,
        phone,
        emailError,
        phoneError,
    ){email, phone, emailError, phoneError ->
        RegisterUserScreenUiState(
            email = email,
            phone = phone,
            emailError = emailError,
            phoneError = phoneError,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(3000),
        initialValue = RegisterUserScreenUiState()
    )

    val termsState: StateFlow<RegisterUserScreenUiState> = combine(
        acceptedTerms,
        acceptedTermsError,
    ){acceptedTerms, acceptedTermsError ->
        RegisterUserScreenUiState(
            acceptedTerms = acceptedTerms,
            acceptedTermsError = acceptedTermsError,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(3000),
        initialValue = RegisterUserScreenUiState()
    )

    val uiState: StateFlow<RegisterUserScreenUiState> = combine(
        nameState,
        passwordState,
        othersDataUserState,
        termsState,
        _isLoading
    ){nameState, passwordState, othersDataUserState, termsState, isLoading ->
        RegisterUserScreenUiState(
            name = nameState.name,
            lastName = nameState.lastName,
            nameError = nameState.nameError,
            lastNameError = nameState.lastNameError,
            email = othersDataUserState.email,
            phone = othersDataUserState.phone,
            emailError = othersDataUserState.emailError,
            phoneError = othersDataUserState.phoneError,
            confirmPassword = passwordState.confirmPassword,
            password = passwordState.password,
            passwordError = passwordState.passwordError,
            confirmPasswordError = passwordState.confirmPasswordError,
            acceptedTerms = termsState.acceptedTerms,
            acceptedTermsError = termsState.acceptedTermsError,
            isLoading = isLoading,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(3000),
        initialValue = RegisterUserScreenUiState()
    )

    abstract fun<T: Any> onRegisterClick(): T

}