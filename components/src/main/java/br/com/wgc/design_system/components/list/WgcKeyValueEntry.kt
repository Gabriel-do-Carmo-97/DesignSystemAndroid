@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.list

/**
 * Item chave-valor para comprovantes e extratos.
 */
data class WgcKeyValueEntry(
    val key: String,
    val value: String,
    val isHighlighted: Boolean = false
)
