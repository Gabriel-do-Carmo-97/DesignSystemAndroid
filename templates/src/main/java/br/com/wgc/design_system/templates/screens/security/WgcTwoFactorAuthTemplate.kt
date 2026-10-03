package br.com.wgc.design_system.templates.screens.security

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ContentCopy
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.fields.WgcOtpPinInput
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcTwoFactorAuthUiState(
    val secretKey: String = "JBSWY3DPEHPK3PXP",
    val otpCode: String = "",
    val backupCodes: List<String> = listOf("8492-1029", "4921-9502", "3810-4491", "9012-7482")
)

/**
 * Template completo de configuração de autenticação em 2 fatores (2FA).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcTwoFactorAuthTemplate(
    uiState: WgcTwoFactorAuthUiState = WgcTwoFactorAuthUiState(),
    onBack: () -> Unit = {},
    onCopySecret: () -> Unit = {},
    onOtpChange: (String) -> Unit = {},
    onConfirm2FA: () -> Unit = {},
    qrCodeSlot: @Composable () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Autenticação em 2 Etapas (2FA)", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
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
                Text(
                    text = "1. Escaneie o QR Code no seu aplicativo autenticador (Google Authenticator ou 1Password):",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = WgcCoreDsSpacing.md16.dp)
                )
            }

            item {
                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.outlineVariant,
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    qrCodeSlot()
                }
            }

            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs6.dp)
                ) {
                    Text(
                        text = "Ou insira a chave secreta manualmente:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(WgcCoreDsSpacing.sm8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = uiState.secretKey,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        IconButton(onClick = onCopySecret) {
                            Icon(imageVector = Icons.Default.ContentCopy, contentDescription = "Copiar chave")
                        }
                    }
                }
            }

            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    Text(
                        text = "2. Digite o código de 6 dígitos gerado:",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    WgcOtpPinInput(
                        value = uiState.otpCode,
                        onValueChange = onOtpChange
                    )

                    WgcClassicButton(
                        text = "Ativar Autenticação",
                        onClick = onConfirm2FA,
                        isEnabled = uiState.otpCode.length == 6,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
