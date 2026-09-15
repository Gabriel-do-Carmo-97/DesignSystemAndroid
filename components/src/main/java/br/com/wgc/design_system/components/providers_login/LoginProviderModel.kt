package br.com.wgc.design_system.components.providers_login

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class LoginProviderModel(
    @param:DrawableRes val iconRes: Int,
    val contentDescription: String,
    val onClick: () -> Unit
)
