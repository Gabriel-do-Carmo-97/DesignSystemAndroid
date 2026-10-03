@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.navigation.routes

import kotlinx.serialization.Serializable

/**
 * Definições de rotas Type-Safe com Kotlinx Serialization para o Navigation Compose 2.8+.
 */
sealed interface WgcRoute {

    @Serializable
    data object AuthFlow : WgcRoute

    @Serializable
    data object Login : WgcRoute

    @Serializable
    data object Register : WgcRoute

    @Serializable
    data object ForgotPassword : WgcRoute

    @Serializable
    data object HomeFlow : WgcRoute

    @Serializable
    data class ProductDetails(val productId: String) : WgcRoute

    @Serializable
    data object Cart : WgcRoute

    @Serializable
    data object Checkout : WgcRoute

    @Serializable
    data class PixPayment(val amountInCents: Long) : WgcRoute

    @Serializable
    data object Profile : WgcRoute

    @Serializable
    data object Settings : WgcRoute

    @Serializable
    data object NotificationCenter : WgcRoute

    @Serializable
    data object FaqHelpCenter : WgcRoute
}
