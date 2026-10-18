@file:Suppress("LongMethod", "CyclomaticComplexMethod")

package br.com.wgc.design_system.components.table

/**
 * Estado atual de ordenação da tabela.
 */
data class WgcSortState(
    val columnId: String = "",
    val direction: WgcSortDirection = WgcSortDirection.NONE
)
