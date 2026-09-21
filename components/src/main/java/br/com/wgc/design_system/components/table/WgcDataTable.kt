@file:Suppress("LongMethod", "CyclomaticComplexMethod")
package br.com.wgc.design_system.components.table

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.UnfoldMore
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Direção de ordenação da coluna.
 */
enum class WgcSortDirection {
    ASCENDING,
    DESCENDING,
    NONE
}

/**
 * Estado atual de ordenação da tabela.
 */
data class WgcSortState(
    val columnId: String = "",
    val direction: WgcSortDirection = WgcSortDirection.NONE
)

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

/**
 * Componente corporativo de Tabela de Dados com ordenação, seleção de linhas e paginação.
 */
@Composable
fun <T> WgcDataTable(
    modifier: Modifier = Modifier,
    columns: List<WgcTableColumn<T>>,
    items: List<T>,
    rowIdProvider: (T) -> String,
    sortState: WgcSortState = WgcSortState(),
    onSortChange: (WgcSortState) -> Unit = {},
    selectedRowIds: Set<String> = emptySet(),
    onRowSelect: (String) -> Unit = {},
    onSelectAll: () -> Unit = {},
    isSelectable: Boolean = false,
    currentPage: Int = 1,
    totalPages: Int = 1,
    totalItems: Int = items.size,
    onPageChange: (Int) -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        color = MaterialTheme.colorScheme.surface,
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            val horizontalScrollState = rememberScrollState()

            // Header e Linhas com Rolagem Horizontal
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(horizontalScrollState)
            ) {
                // Header da Tabela
                WgcTableHeaderRow(
                    columns = columns,
                    sortState = sortState,
                    onSortChange = onSortChange,
                    isSelectable = isSelectable,
                    isAllSelected = items.isNotEmpty() && selectedRowIds.size == items.size,
                    onSelectAll = onSelectAll
                )

                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                // Linhas de Dados
                if (items.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.xl32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Nenhum dado disponível",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                } else {
                    items.forEachIndexed { index, item ->
                        val rowId = rowIdProvider(item)
                        val isSelected = rowId in selectedRowIds
                        WgcDataTableRow(
                            columns = columns,
                            item = item,
                            rowId = rowId,
                            isSelected = isSelected,
                            isSelectable = isSelectable,
                            isEven = index % 2 == 0,
                            onRowSelect = onRowSelect
                        )
                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.25f)
                        )
                    }
                }
            }

            // Rodapé de Paginação
            if (totalPages > 1 || totalItems > 0) {
                WgcTablePaginationFooter(
                    currentPage = currentPage,
                    totalPages = totalPages,
                    totalItems = totalItems,
                    onPageChange = onPageChange
                )
            }
        }
    }
}

@Composable
private fun <T> WgcTableHeaderRow(
    columns: List<WgcTableColumn<T>>,
    sortState: WgcSortState,
    onSortChange: (WgcSortState) -> Unit,
    isSelectable: Boolean,
    isAllSelected: Boolean,
    onSelectAll: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelectable) {
            Checkbox(
                checked = isAllSelected,
                onCheckedChange = { onSelectAll() }
            )
            Spacer(Modifier.width(WgcCoreDsSpacing.xs8.dp))
        }

        columns.forEach { col ->
            val isCurrentSort = sortState.columnId == col.id
            Row(
                modifier = Modifier
                    .width(col.width.dp)
                    .then(
                        if (col.sortable) {
                            Modifier.clickable {
                                val nextDirection = when {
                                    !isCurrentSort -> WgcSortDirection.ASCENDING
                                    sortState.direction == WgcSortDirection.ASCENDING -> WgcSortDirection.DESCENDING
                                    else -> WgcSortDirection.NONE
                                }
                                onSortChange(WgcSortState(col.id, nextDirection))
                            }
                        } else Modifier
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = col.header,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                if (col.sortable) {
                    val icon = when {
                        !isCurrentSort || sortState.direction == WgcSortDirection.NONE -> Icons.Default.UnfoldMore
                        sortState.direction == WgcSortDirection.ASCENDING -> Icons.Default.ArrowUpward
                        else -> Icons.Default.ArrowDownward
                    }
                    Icon(
                        imageVector = icon,
                        contentDescription = "Ordenar por ${col.header}",
                        tint = if (isCurrentSort && sortState.direction != WgcSortDirection.NONE) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                        },
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun <T> WgcDataTableRow(
    columns: List<WgcTableColumn<T>>,
    item: T,
    rowId: String,
    isSelected: Boolean,
    isSelectable: Boolean,
    isEven: Boolean,
    onRowSelect: (String) -> Unit
) {
    val rowBg = when {
        isSelected -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.25f)
        isEven -> MaterialTheme.colorScheme.surface
        else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.15f)
    }

    Row(
        modifier = Modifier
            .background(rowBg)
            .clickable(enabled = isSelectable) { onRowSelect(rowId) }
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelectable) {
            Checkbox(
                checked = isSelected,
                onCheckedChange = { onRowSelect(rowId) }
            )
            Spacer(Modifier.width(WgcCoreDsSpacing.xs8.dp))
        }

        columns.forEach { col ->
            Box(
                modifier = Modifier.width(col.width.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                col.cell(item)
            }
        }
    }
}

@Composable
private fun WgcTablePaginationFooter(
    currentPage: Int,
    totalPages: Int,
    totalItems: Int,
    onPageChange: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Total de registros: $totalItems",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            IconButton(
                onClick = { onPageChange((currentPage - 1).coerceAtLeast(1)) },
                enabled = currentPage > 1,
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Página anterior"
                )
            }

            Text(
                text = "Pág. $currentPage de $totalPages",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Medium
            )

            IconButton(
                onClick = { onPageChange((currentPage + 1).coerceAtMost(totalPages)) },
                enabled = currentPage < totalPages,
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Próxima página"
                )
            }
        }
    }
}

@Preview(name = "WgcDataTable - Preview", showBackground = true)
@Composable
private fun WgcDataTablePreview() {
    data class SampleItem(val id: String, val name: String, val status: String, val value: String)
    val sampleItems = listOf(
        SampleItem("1", "Pedido #1042", "Concluído", "R$ 149,90"),
        SampleItem("2", "Pedido #1043", "Pendente", "R$ 89,00"),
        SampleItem("3", "Pedido #1044", "Cancelado", "R$ 320,50")
    )
    val columns = listOf(
        WgcTableColumn<SampleItem>(id = "name", header = "Identificador", sortable = true) {
            Text(it.name, fontWeight = FontWeight.SemiBold)
        },
        WgcTableColumn<SampleItem>(id = "status", header = "Status", sortable = true) {
            Text(it.status)
        },
        WgcTableColumn<SampleItem>(id = "value", header = "Valor", sortable = true) {
            Text(it.value, fontWeight = FontWeight.Bold)
        }
    )

    MaterialTheme {
        WgcDataTable(
            modifier = Modifier.padding(16.dp),
            columns = columns,
            items = sampleItems,
            rowIdProvider = { it.id },
            isSelectable = true,
            selectedRowIds = setOf("1")
        )
    }
}
