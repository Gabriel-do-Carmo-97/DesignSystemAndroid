package br.com.wgc.design_system.templates.screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcChatMessage(
    val id: String,
    val text: String,
    val timestamp: String,
    val isFromUser: Boolean
)

data class WgcChatSupportUiState(
    val agentName: String = "Suporte WGC",
    val agentStatus: String = "Online agora",
    val messages: List<WgcChatMessage> = listOf(
        WgcChatMessage("1", "Olá Gabriel! Como posso te ajudar hoje?", "10:14", false)
    ),
    val currentInput: String = ""
)

/**
 * Template completo para chat de atendimento e suporte corporativo.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcChatSupportTemplate(
    uiState: WgcChatSupportUiState = WgcChatSupportUiState(),
    onBack: () -> Unit = {},
    onInputChange: (String) -> Unit = {},
    onSendMessage: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = uiState.agentName, fontWeight = FontWeight.Bold)
                        Text(
                            text = uiState.agentStatus,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)
            ) {
                OutlinedTextField(
                    value = uiState.currentInput,
                    onValueChange = onInputChange,
                    placeholder = { Text("Digite sua mensagem...") },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                )

                IconButton(
                    onClick = onSendMessage,
                    enabled = uiState.currentInput.isNotBlank()
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Enviar",
                        tint = if (uiState.currentInput.isNotBlank()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                    )
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)
        ) {
            items(uiState.messages) { message ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = if (message.isFromUser) Alignment.CenterEnd else Alignment.CenterStart
                ) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(
                                if (message.isFromUser) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
                            )
                            .padding(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Text(
                            text = message.text,
                            color = if (message.isFromUser) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = message.timestamp,
                            style = MaterialTheme.typography.labelSmall,
                            color = if (message.isFromUser) MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f) else MaterialTheme.colorScheme.outline,
                            modifier = Modifier.padding(top = WgcCoreDsSpacing.xxs4.dp)
                        )
                    }
                }
            }
        }
    }
}
