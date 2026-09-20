package br.com.wgc.design_system.templates.screens.receipt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class WgcReceiptField(
    val label: String,
    val value: String
)

data class WgcTransactionReceiptUiState(
    val title: String = "Comprovante de Transferência",
    val statusText: String = "Transferência enviada com sucesso!",
    val amountFormatted: String = "R$ 1.450,00",
    val transactionDate: String = "15/09/2026 às 14:35:12",
    val transactionType: String = "PIX Instantâneo",
    val recipientName: String = "Maria Helena de Almeida",
    val recipientDocumentMasked: String = "***.382.918-**",
    val recipientBank: String = "WGC Instituição Financeira",
    val senderName: String = "Gabriel do Carmo",
    val senderBank: String = "WGC Instituição Financeira",
    val authenticationProtocol: String = "E00038166202609151435WGC7612984",
    val additionalDetails: List<WgcReceiptField> = listOf(
        WgcReceiptField("Canal de Atendimento", "Aplicativo Android DS"),
        WgcReceiptField("Tarifa da operação", "R$ 0,00 (Gratuito)")
    )
)

abstract class BaseTransactionReceiptViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcTransactionReceiptUiState>
    abstract fun onShareReceiptClick()
    abstract fun onSavePdfClick()
    abstract fun onCloseClick()
}

class FakeTransactionReceiptViewModel : BaseTransactionReceiptViewModel() {
    private val _uiState = MutableStateFlow(WgcTransactionReceiptUiState())
    override val uiState: StateFlow<WgcTransactionReceiptUiState> = _uiState.asStateFlow()
    override fun onShareReceiptClick() {}
    override fun onSavePdfClick() {}
    override fun onCloseClick() {}
}

@Composable
fun WgcTransactionReceiptTemplate(
    viewModel: BaseTransactionReceiptViewModel = FakeTransactionReceiptViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    actionButtonsSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()
    WgcTransactionReceiptContent(
        state = state,
        onShareReceiptClick = viewModel::onShareReceiptClick,
        onSavePdfClick = viewModel::onSavePdfClick,
        onCloseClick = viewModel::onCloseClick,
        headerSlot = headerSlot,
        actionButtonsSlot = actionButtonsSlot
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcTransactionReceiptContent(
    state: WgcTransactionReceiptUiState,
    onShareReceiptClick: () -> Unit,
    onSavePdfClick: () -> Unit,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier,
    headerSlot: (@Composable () -> Unit)? = null,
    actionButtonsSlot: (@Composable () -> Unit)? = null
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
                    actions = {
                        IconButton(onClick = onCloseClick) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Fechar comprovante"
                            )
                        }
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
                Column(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    if (actionButtonsSlot != null) {
                        actionButtonsSlot()
                    } else {
                        WgcClassicButton(
                            textButton = "Compartilhar Comprovante",
                            onClick = onShareReceiptClick,
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedButton(
                            onClick = onSavePdfClick,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                        ) {
                            Text(
                                text = "Salvar em PDF",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Ícone de sucesso
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(36.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Text(
                text = state.statusText,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = state.amountFormatted,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = state.transactionDate,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Card com detalhes
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    ReceiptRow(label = "Tipo de transferência", value = state.transactionType)
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)

                    ReceiptRow(label = "Para", value = state.recipientName)
                    ReceiptRow(label = "CPF / CNPJ", value = state.recipientDocumentMasked)
                    ReceiptRow(label = "Instituição de destino", value = state.recipientBank)
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)

                    ReceiptRow(label = "De", value = state.senderName)
                    ReceiptRow(label = "Instituição de origem", value = state.senderBank)
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)

                    ReceiptRow(label = "Autenticação Bancária", value = state.authenticationProtocol)

                    state.additionalDetails.forEach { detail ->
                        ReceiptRow(label = detail.label, value = detail.value)
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Composable
private fun ReceiptRow(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Composable
private fun WgcTransactionReceiptTemplatePreview() {
    MaterialTheme {
        WgcTransactionReceiptTemplate()
    }
}
