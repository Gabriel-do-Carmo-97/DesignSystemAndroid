package br.com.wgc.design_system.navigation.deeplink

import android.net.Uri

/**
 * Validador e sanitizador de Deep Links corporativos e Android App Links.
 */
object WgcDeepLinkValidator {

    private val ALLOWED_SCHEMES = setOf("wgc", "https")
    private val VERIFIED_DOMAINS = setOf("app.wgc.com.br", "ds.wgc.com.br")

    /**
     * Valida se uma URI de Deep Link possui esquema seguro e domínio autorizado.
     */
    @Suppress("TooGenericExceptionCaught")
    fun isValid(uriString: String): Boolean {
        return try {
            val uri = Uri.parse(uriString)
            val scheme = uri.scheme?.lowercase() ?: return false
            if (scheme !in ALLOWED_SCHEMES) return false

            if (scheme == "https") {
                val host = uri.host?.lowercase() ?: return false
                host in VERIFIED_DOMAINS
            } else {
                // Esquema customizado wgc://
                uri.host != null && uri.host!!.isNotBlank()
            }
        } catch (_: Exception) {
            false
        }
    }

    /**
     * Extrai o caminho semântico normalizado do deep link.
     */
    fun extractPath(uriString: String): String? {
        if (!isValid(uriString)) return null
        val uri = Uri.parse(uriString)
        val host = uri.host ?: return null
        val path = uri.path.orEmpty()
        return if (uri.scheme == "wgc") {
            "$host$path"
        } else {
            path.trimStart('/')
        }
    }
}
