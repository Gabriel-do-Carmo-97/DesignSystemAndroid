package br.com.wgc.design_system.navigation.deeplink

import android.net.Uri

/**
 * DSL fluente para construção segura de Deep Links para notificações push e navegação externa.
 */
class WgcDeepLinkUriBuilder private constructor(
    private val scheme: String,
    private val host: String
) {
    private val pathSegments = mutableListOf<String>()
    private val queryParams = mutableMapOf<String, String>()

    fun path(segment: String): WgcDeepLinkUriBuilder = apply {
        pathSegments.add(segment.trim('/'))
    }

    fun query(key: String, value: String): WgcDeepLinkUriBuilder = apply {
        queryParams[key] = value
    }

    fun build(): Uri {
        val builder = Uri.Builder()
            .scheme(scheme)
            .authority(host)

        pathSegments.forEach { builder.appendPath(it) }
        queryParams.forEach { (k, v) -> builder.appendQueryParameter(k, v) }

        return builder.build()
    }

    fun buildString(): String = build().toString()

    companion object {
        /**
         * Inicia um builder com o esquema nativo wgc://
         */
        fun wgc(host: String): WgcDeepLinkUriBuilder = WgcDeepLinkUriBuilder("wgc", host)

        /**
         * Inicia um builder com HTTPS verificado para App Links
         */
        fun https(host: String = "app.wgc.com.br"): WgcDeepLinkUriBuilder = WgcDeepLinkUriBuilder("https", host)
    }
}
