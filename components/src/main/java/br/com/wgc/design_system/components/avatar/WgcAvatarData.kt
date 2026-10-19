@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.avatar

/**
 * Avatar individual com iniciais ou placeholder.
 */
data class WgcAvatarData(
    val id: String,
    val name: String,
    val initials: String = name.take(2).uppercase()
)
