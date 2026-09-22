@file:Suppress("LongMethod", "UnusedPrivateMember")

package br.com.wgc.design_system.templates.screens.pix

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Estado da tela corporativa de transferência via Pix.
 */
data class WgcPixTransferUiState(
    val title: String = "Área Pix",
    val pixKey: String = "",
    val availableKeyTypes: List<String> = listOf("CPF/CNPJ", "E-mail", "Celular", "Chave Aleatória"),
    val selectedKeyType: String = "CPF/CNPJ",
    val amount: String = "",
    val description: String = "",
    val recipientName: String? = null,
    val recipientBank: String? = null,
    val recipientDocumentMasked: String? = null,
    val isLoading: Boolean = false,
    val isConfirmed: Boolean = false,
    val errorMessage: String? = null
)

/**
 * ViewModel base desacoplada para transferência Pix.
 */
abstract class BasePixTransferViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcPixTransferUiState>
    abstract fun onKeyChange(key: String)
    abstract fun onKeyTypeSelect(type: String)
    abstract fun onAmountChange(amount: String)
    abstract fun onDescriptionChange(desc: String)
    abstract fun onConfirmTransfer()
    abstract fun onReset()
}

/**
 * Implementação Fake para Preview e Testes.
 */
class FakePixTransferViewModel(
    initialState: WgcPixTransferUiState = WgcPixTransferUiState(
        pixKey = "123.456.789-00",
        amount = "150,00",
        recipientName = "Gabriel do Carmo",
        recipientBank = "Banco WGC S.A.",
        recipientDocumentMasked = "***.456.789-**"
    )
) : BasePixTransferViewModel() {
    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<WgcPixTransferUiState> = _uiState.asStateFlow()

    override fun onKeyChange(key: String) {
        _uiState.value = _uiState.value.copy(pixKey = key)
    }

    override fun onKeyTypeSelect(type: String) {
        _uiState.value = _uiState.value.copy(selectedKeyType = type)
    }

    override fun onAmountChange(amount: String) {
        _uiState.value = _uiState.value.copy(amount = amount)
    }

    override fun onDescriptionChange(desc: String) {
        _uiState.value = _uiState.value.copy(description = desc)
    }

    override fun onConfirmTransfer() {
        _uiState.value = _uiState.value.copy(isConfirmed = true)
    }

    override fun onReset() {
        _uiState.value = WgcPixTransferUiState()
    }
}

/**
 * Template completo corporativo de transferência Pix.
 */
@Composable
fun WgcPixTransferTemplate(
    modifier: Modifier = Modifier,
    viewModel: BasePixTransferViewModel = FakePixTransferViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    confirmButtonSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    WgcPixTransferContent(
        state = state,
        modifier = modifier,
        onKeyChange = viewModel::onKeyChange,
        onKeyTypeSelect = viewModel::onKeyTypeSelect,
        onAmountChange = viewModel::onAmountChange,
        onDescriptionChange = viewModel::onDescriptionChange,
        onConfirmTransfer = viewModel::onConfirmTransfer,
        headerSlot = headerSlot,
        confirmButtonSlot = confirmButtonSlot
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcPixTransferContent(
    state: WgcPixTransferUiState,
    modifier: Modifier = Modifier,
    onKeyChange: (String) -> Unit = {},
    onKeyTypeSelect: (String) -> Unit = {},
    onAmountChange: (String) -> Unit = {},
    onDescriptionChange: (String) -> Unit = {},
    onConfirmTransfer: () -> Unit = {},
    onBackClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    confirmButtonSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (headerSlot != null) {
                headerSlot()
            } else {
                TopAppBar(
                    title = { Text(state.title, style = MaterialTheme.typography.titleLarge) },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Voltar"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
                )
            }
        },
        bottomBar = {
            Surface(
                tonalElevation = WgcCoreDsSpacing.xs8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    if (confirmButtonSlot != null) {
                        confirmButtonSlot()
                    } else {
                        WgcClassicButton(
                            textButton = if (state.isLoading) "Processando..." else "Transferir R$ ${state.amount.ifBlank { "0,00" }}",
                            onClick = onConfirmTransfer,
                            isEnabled = state.pixKey.isNotBlank() && state.amount.isNotBlank() && !state.isLoading,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            PixKeyTypeSelector(
                types = state.availableKeyTypes,
                selected = state.selectedKeyType,
                onSelect = onKeyTypeSelect
            )

            OutlinedTextField(
                value = state.pixKey,
                onValueChange = onKeyChange,
                label = { Text("Chave Pix (${state.selectedKeyType})") },
                placeholder = { Text("Informe a chave de destino") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = state.amount,
                onValueChange = onAmountChange,
                label = { Text("Valor da Transferência (R$)") },
                placeholder = { Text("0,00") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = state.description,
                onValueChange = onDescriptionChange,
                label = { Text("Descrição (opcional)") },
                placeholder = { Text("Escreva uma mensagem para o recebedor") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                singleLine = true
            )

            if (state.recipientName != null) {
                PixRecipientCard(
                    name = state.recipientName,
                    bank = state.recipientBank ?: "Instituição Financeira",
                    document = state.recipientDocumentMasked ?: "***"
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))
        }
    }
}

@Composable
private fun PixKeyTypeSelector(
    types: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        for (type in types) {
            FilterChip(
                selected = type == selected,
                onClick = { onSelect(type) },
                label = { Text(type, style = MaterialTheme.typography.labelSmall) },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    }
}

@Composable
private fun PixRecipientCard(
    name: String,
    bank: String,
    document: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                )
                Text(
                    text = "Dados do Destinatário Confirmados",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Text(text = "Nome: $name", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
            Text(text = "Instituição: $bank", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(text = "CPF/CNPJ: $document", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Preview(name = "WgcPixTransferTemplate Preview", showBackground = true)
@Composable
private fun WgcPixTransferTemplatePreview() {
    MaterialTheme {
        WgcPixTransferContent(
            state = WgcPixTransferUiState(
                pixKey = "chave@wgc.com.br",
                amount = "250,00",
                recipientName = "João da Silva",
                recipientBank = "WGC Pagamentos",
                recipientDocumentMasked = "***.123.456-**"
            )
        )
    }
}
