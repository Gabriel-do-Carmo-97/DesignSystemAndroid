@file:Suppress("ReturnCount", "TooGenericExceptionCaught")

package br.com.wgc.design_system.navigation.deeplink

import androidx.navigation.NavController
import br.com.wgc.design_system.navigation.checkout.WgcCheckoutCartRoute
import br.com.wgc.design_system.navigation.help.WgcHelpCenterFaqDetailRoute
import br.com.wgc.design_system.navigation.help.WgcHelpCenterHomeRoute
import br.com.wgc.design_system.navigation.help.WgcHelpCenterTicketDetailRoute
import br.com.wgc.design_system.navigation.review.WgcReviewFormRoute
import br.com.wgc.design_system.navigation.search.WgcSearchMainRoute
import br.com.wgc.design_system.navigation.statement.WgcStatementDetailRoute
import br.com.wgc.design_system.navigation.statement.WgcStatementHomeRoute

/**
 * Utilitário centralizado para resolução e geração de Deep Links do ecossistema WGC.
 * Suporta o scheme proprietário 'wgc://' e o domínio web corporativo 'https://wgc.com.br/app/'.
 */
object WgcDeepLinkHandler {

    const val SCHEME_CUSTOM = "wgc"
    const val HOST_WEB = "wgc.com.br"
    const val PATH_PREFIX_WEB = "/app/"

    /**
     * Faz o parse de uma URI de deep link para o objeto de rota correspondente.
     * Retorna null caso a URI não seja reconhecida.
     */
    fun parseUri(uriString: String): Any? {
        val components = extractComponents(uriString) ?: return null

        return when (components.host?.lowercase()) {
            "statement" -> resolveStatementRoute(components.pathSegments)
            "help" -> resolveHelpRoute(components.pathSegments)
            "review" -> {
                val orderId = components.pathSegments.firstOrNull() ?: "89210"
                WgcReviewFormRoute(orderId = orderId)
            }
            "checkout" -> WgcCheckoutCartRoute
            "search" -> WgcSearchMainRoute
            else -> null
        }
    }

    /**
     * Gera a URI customizada 'wgc://' para a rota fornecida.
     */
    fun createDeepLink(route: Any): String {
        return when (route) {
            is WgcStatementHomeRoute -> "$SCHEME_CUSTOM://statement"
            is WgcStatementDetailRoute -> "$SCHEME_CUSTOM://statement/${route.transactionId}"
            is WgcHelpCenterHomeRoute -> "$SCHEME_CUSTOM://help"
            is WgcHelpCenterFaqDetailRoute -> "$SCHEME_CUSTOM://help/faq/${route.faqId}"
            is WgcHelpCenterTicketDetailRoute -> "$SCHEME_CUSTOM://help/ticket/${route.ticketId}"
            is WgcReviewFormRoute -> "$SCHEME_CUSTOM://review/${route.orderId}"
            is WgcCheckoutCartRoute -> "$SCHEME_CUSTOM://checkout"
            is WgcSearchMainRoute -> "$SCHEME_CUSTOM://search"
            else -> "$SCHEME_CUSTOM://home"
        }
    }

    /**
     * Extension para navegar via deep link com tratamento automático de erros.
     */
    fun NavController.handleDeepLink(uriString: String): Boolean {
        val route = parseUri(uriString) ?: return false
        return try {
            navigate(route)
            true
        } catch (_: Exception) {
            false
        }
    }

    private fun resolveStatementRoute(pathSegments: List<String>): Any {
        val txId = pathSegments.firstOrNull()
        return if (txId != null) {
            WgcStatementDetailRoute(transactionId = txId)
        } else {
            WgcStatementHomeRoute
        }
    }

    private fun resolveHelpRoute(pathSegments: List<String>): Any {
        return when (pathSegments.firstOrNull()?.lowercase()) {
            "faq" -> {
                val faqId = pathSegments.getOrNull(1) ?: return WgcHelpCenterHomeRoute
                WgcHelpCenterFaqDetailRoute(faqId = faqId)
            }
            "ticket" -> {
                val ticketId = pathSegments.getOrNull(1) ?: return WgcHelpCenterHomeRoute
                WgcHelpCenterTicketDetailRoute(ticketId = ticketId)
            }
            else -> WgcHelpCenterHomeRoute
        }
    }

    private fun extractComponents(uriString: String): ParsedUriComponents? {
        val schemeSeparatorIndex = uriString.indexOf("://")
        if (schemeSeparatorIndex == -1) return null

        val scheme = uriString.substring(0, schemeSeparatorIndex).lowercase()
        val remaining = uriString.substring(schemeSeparatorIndex + 3)

        return if (scheme == SCHEME_CUSTOM) {
            val parts = remaining.split("/").filter { it.isNotEmpty() }
            ParsedUriComponents(
                host = parts.firstOrNull(),
                pathSegments = parts.drop(1)
            )
        } else if (scheme == "https" && remaining.startsWith(HOST_WEB)) {
            val afterHost = remaining.removePrefix(HOST_WEB)
            val parts = afterHost.split("/").filter { it.isNotEmpty() }
            if (parts.isEmpty() || parts[0] != "app") return null
            ParsedUriComponents(
                host = parts.getOrNull(1),
                pathSegments = parts.drop(2)
            )
        } else {
            null
        }
    }

    private data class ParsedUriComponents(
        val host: String?,
        val pathSegments: List<String>
    )
}
