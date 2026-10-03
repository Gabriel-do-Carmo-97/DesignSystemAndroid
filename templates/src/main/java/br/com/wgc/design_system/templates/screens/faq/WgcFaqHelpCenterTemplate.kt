@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.templates.screens.faq

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.accordion.WgcAccordion
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Item de FAQ com pergunta e resposta.
 */
data class WgcFaqItem(
    val id: String,
    val question: String,
    val answer: String,
    val isExpanded: Boolean = false
)

/**
 * Estado da tela da Central de Ajuda.
 */
data class WgcFaqUiState(
    val searchQuery: String = "",
    val faqItems: List<WgcFaqItem> = emptyList()
)

/**
 * Template corporativo da Central de Ajuda e FAQ (WgcFaqHelpCenterTemplate).
 */
@Composable
fun WgcFaqHelpCenterTemplate(
    uiState: WgcFaqUiState,
    onSearchChange: (String) -> Unit,
    onToggleFaq: (WgcFaqItem) -> Unit,
    onContactSupportClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            Text(
                text = "Central de Ajuda",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            OutlinedTextField(
                value = uiState.searchQuery,
                onValueChange = onSearchChange,
                placeholder = { Text(text = "Qual é a sua dúvida?") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
            ) {
                items(uiState.faqItems, key = { it.id }) { item ->
                    WgcAccordion(
                        title = item.question,
                        isExpanded = item.isExpanded,
                        onToggle = { onToggleFaq(item) }
                    ) {
                        Text(
                            text = item.answer,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            WgcClassicButton(
                text = "Falar com Atendente",
                onClick = onContactSupportClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
