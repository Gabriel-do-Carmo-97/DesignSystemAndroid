@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.filter

data class WgcFilterOption(
    val id: String,
    val label: String,
    val isSelected: Boolean = false
)
