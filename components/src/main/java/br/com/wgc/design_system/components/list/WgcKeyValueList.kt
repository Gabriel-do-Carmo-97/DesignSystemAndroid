@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Item chave-valor para comprovantes e extratos.
 */
data class WgcKeyValueEntry(
    val key: String,
    val value: String,
    val isHighlighted: Boolean = false
)

/**
 * WgcKeyValueList
 *
 * Exibidor corporativo de dados estruturados chave-valor para comprovantes, recibos e telas de resumo.
 */
@Composable
fun WgcKeyValueList(
    entries: List<WgcKeyValueEntry>,
    modifier: Modifier = Modifier,
    showDividers: Boolean = true
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM.dp)
    ) {
        entries.forEachIndexed { index, entry ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = entry.key,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = entry.value,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = if (entry.isHighlighted) FontWeight.Bold else FontWeight.Medium,
                    color = if (entry.isHighlighted) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
            }
            if (showDividers && index < entries.lastIndex) {
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            }
        }
    }
}

@Preview(showBackground = true, name = "WgcKeyValueList Preview")
@Composable
private fun WgcKeyValueListPreview() {
    WgcTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.MD.dp)
        ) {
            WgcKeyValueList(
                entries = listOf(
                    WgcKeyValueEntry("Data", "14/10/2026 - 19:45"),
                    WgcKeyValueEntry("Beneficiário", "WGC Serviços Digitais S.A."),
                    WgcKeyValueEntry("Método de Pagamento", "PIX"),
                    WgcKeyValueEntry("Total", "R$ 1.250,00", isHighlighted = true)
                )
            )
        }
    }
}
