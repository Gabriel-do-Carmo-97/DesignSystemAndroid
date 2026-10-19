package br.com.wgc.design_system.factories.auth.templates.state

import kotlinx.serialization.Serializable

@Serializable
data class ResetPasswordScreenUiState(
    val title: String = "Recupere sua senha !",
    val isLoading: Boolean = false,
    val email: String = "",
    val emailError: String? = null,
)
