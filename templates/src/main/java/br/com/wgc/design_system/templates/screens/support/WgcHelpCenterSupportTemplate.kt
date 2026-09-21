package br.com.wgc.design_system.templates.screens.support

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class WgcSupportFaqItem(
    val id: String,
    val question: String,
    val answer: String
)

data class WgcSupportTicket(
    val id: String,
    val protocolNumber: String,
    val subject: String,
    val status: String,
    val updatedAt: String
)

data class WgcHelpCenterUiState(
    val title: String = "Central de Ajuda",
    val searchQuery: String = "",
    val categories: List<String> = listOf("Tudo", "Conta", "Pagamentos", "Segurança", "Cartões"),
    val selectedCategory: String = "Tudo",
    val faqs: List<WgcSupportFaqItem> = listOf(
        WgcSupportFaqItem(
            id = "1",
            question = "Como altero minha senha ou chave de acesso?",
            answer = "Acesse Perfil > Segurança > Alterar Senha. Você precisará confirmar sua biometria ou código de verificação."
        ),
        WgcSupportFaqItem(
            id = "2",
            question = "Qual o prazo para compensação de transferências?",
            answer = "Transferências via PIX ocorrem instantaneamente em até 10 segundos. TEDs são compensadas em até 2 horas úteis."
        ),
        WgcSupportFaqItem(
            id = "3",
            question = "Como solicitar segunda via do meu comprovante?",
            answer = "No menu Extrato, localize a transação desejada e clique em 'Ver Comprovante' para compartilhar ou salvar em PDF."
        )
    ),
    val recentTickets: List<WgcSupportTicket> = listOf(
        WgcSupportTicket(
            id = "ticket-101",
            protocolNumber = "#WGC-89210",
            subject = "Dúvida sobre estorno de compra",
            status = "Em análise",
            updatedAt = "Hoje às 11:20"
        )
    ),
    val isLoading: Boolean = false
)

abstract class BaseHelpCenterViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcHelpCenterUiState>
    abstract fun onSearchQueryChange(query: String)
    abstract fun onCategorySelect(category: String)
    abstract fun onContactSupportClick()
    abstract fun onTicketClick(ticketId: String)
}

class FakeHelpCenterViewModel : BaseHelpCenterViewModel() {
    private val _uiState = MutableStateFlow(WgcHelpCenterUiState())
    override val uiState: StateFlow<WgcHelpCenterUiState> = _uiState.asStateFlow()
    override fun onSearchQueryChange(query: String) {}
    override fun onCategorySelect(category: String) {}
    override fun onContactSupportClick() {}
    override fun onTicketClick(ticketId: String) {}
}

@Composable
fun WgcHelpCenterSupportTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseHelpCenterViewModel = FakeHelpCenterViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    contactActionSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()
    WgcHelpCenterSupportContent(
        modifier = modifier,
        state = state,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onCategorySelect = viewModel::onCategorySelect,
        onContactSupportClick = viewModel::onContactSupportClick,
        onTicketClick = viewModel::onTicketClick,
        headerSlot = headerSlot,
        contactActionSlot = contactActionSlot
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcHelpCenterSupportContent(
    state: WgcHelpCenterUiState,
    onSearchQueryChange: (String) -> Unit,
    onCategorySelect: (String) -> Unit,
    onContactSupportClick: () -> Unit,
    onTicketClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    headerSlot: (@Composable () -> Unit)? = null,
    contactActionSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (headerSlot != null) {
                headerSlot()
            } else {
                TopAppBar(
                    title = {
                        Text(
                            text = state.title,
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        titleContentColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        },
        bottomBar = {
            Surface(
                tonalElevation = WgcCoreDsSpacing.xs8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    if (contactActionSlot != null) {
                        contactActionSlot()
                    } else {
                        WgcClassicButton(
                            textButton = "Falar com Atendente",
                            onClick = onContactSupportClick,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                OutlinedTextField(
                    value = state.searchQuery,
                    onValueChange = onSearchQueryChange,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Buscar dúvidas, tópicos ou serviços...") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar"
                        )
                    },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    singleLine = true
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    items(state.categories) { category ->
                        FilterChip(
                            selected = category == state.selectedCategory,
                            onClick = { onCategorySelect(category) },
                            label = { Text(category) },
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sl18.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                }
            }

            if (state.recentTickets.isNotEmpty()) {
                item {
                    Text(
                        text = "Seus Chamados Recentes",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                items(state.recentTickets) { ticket ->
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .clickable { onTicketClick(ticket.id) },
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "${ticket.protocolNumber} • ${ticket.subject}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = "Status: ${ticket.status} • ${ticket.updatedAt}",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Dúvidas Frequentes",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            items(state.faqs) { faq ->
                var isExpanded by remember { mutableStateOf(false) }

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .clickable { isExpanded = !isExpanded },
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    tonalElevation = WgcCoreDsSpacing.xxxs2.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = faq.question,
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        AnimatedVisibility(visible = isExpanded) {
                            Column {
                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                                HorizontalDivider(
                                    color = MaterialTheme.colorScheme.outlineVariant,
                                    thickness = 1.dp
                                )
                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                                Text(
                                    text = faq.answer,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Composable
private fun WgcHelpCenterSupportTemplatePreview() {
    MaterialTheme {
        WgcHelpCenterSupportTemplate()
    }
}
