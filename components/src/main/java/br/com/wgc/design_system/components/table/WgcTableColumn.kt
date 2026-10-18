@file:Suppress("LongMethod", "CyclomaticComplexMethod")

package br.com.wgc.design_system.components.table

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable

/**
 * Definição de coluna da tabela corporativa.
 */
data class WgcTableColumn<T>(
    val id: String,
    val header: String,
    val width: Int = 140,
    val sortable: Boolean = false,
    val cell: @Composable (T) -> Unit
)
