package br.com.wgc.design_system.templates.screens.invoice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.list.WgcKeyValueEntry
import br.com.wgc.design_system.components.list.WgcKeyValueList
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcInvoiceReceiptUiState(
    val title: String = "Comprovante de Transferência",
    val amount: String = "R$ 1.250,00",
    val timestamp: String = "03/10/2026 às 10:30:15",
    val recipientName: String = "Gabriel do Carmo",
    val recipientDocument: String = "•••.492.108-••",
    val recipientBank: String = "Banco WGC S.A. (0492)",
    val authenticationHash: String = "E9A4-F291-C841-B730-1092-4820-FA81"
)

/**
 * Template completo de comprovante financeiro e fatura com hash de autenticidade e ações de download/compartilhamento.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcInvoiceReceiptTemplate(
    uiState: WgcInvoiceReceiptUiState = WgcInvoiceReceiptUiState(),
    onBack: () -> Unit = {},
    onShare: () -> Unit = {},
    onDownloadPdf: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Comprovante", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                actions = {
                    IconButton(onClick = onShare) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "Compartilhar comprovante")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = WgcCoreDsSpacing.md16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Transferência realizada",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(56.dp)
                    )
                    Text(
                        text = "Transferência Concluída",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = uiState.amount,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = uiState.timestamp,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                    ) {
                        WgcKeyValueList(
                            entries = listOf(
                                WgcKeyValueEntry("Destinatário", uiState.recipientName),
                                WgcKeyValueEntry("CPF", uiState.recipientDocument),
                                WgcKeyValueEntry("Instituição", uiState.recipientBank)
                            )
                        )

                        Column(modifier = Modifier.padding(top = WgcCoreDsSpacing.sm8.dp)) {
                            Text(
                                text = "Autenticação Digital",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.outline
                            )
                            Text(
                                text = uiState.authenticationHash,
                                style = MaterialTheme.typography.labelMedium,
                                fontFamily = FontFamily.Monospace,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            item {
                WgcClassicButton(
                    text = "Baixar Comprovante em PDF",
                    onClick = onDownloadPdf,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
