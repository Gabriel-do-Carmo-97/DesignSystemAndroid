@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName", "MaxLineLength")

package br.com.wgc.design_system.templates.screens.pix

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import java.util.Locale

/**
 * Estado da tela de pagamento Pix Copia e Cola / QR Code.
 */
data class WgcPixQrPaymentUiState(
    val title: String = "Pague via Pix",
    val amountFormatted: String = "R$ 150,00",
    val pixCode: String = "00020126580014br.gov.bcb.pix0136123e4567-e89b-12d3-a456-42661417400052040000" +
        "53039865406150.005802BR5913WGC Pagamentos6009SAO PAULO62070503***6304E2CA",
    val expirationSecondsRemaining: Int = 900
)

/**
 * Template corporativo de pagamento Pix com QR Code e Pix Copia e Cola.
 */
@Composable
fun WgcPixQrCodePaymentTemplate(
    uiState: WgcPixQrPaymentUiState,
    onCopyPixCode: () -> Unit,
    onCheckPaymentStatus: () -> Unit,
    modifier: Modifier = Modifier
) {
    val minutes = uiState.expirationSecondsRemaining / 60
    val seconds = uiState.expirationSecondsRemaining % 60
    val formattedTime = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)

    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.md.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
            ) {
                Text(
                    text = uiState.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = uiState.amountFormatted,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "O código expira em $formattedTime",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .border(2.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(WgcCoreDsBorderRadius.md.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.QrCode,
                    contentDescription = "QR Code Pix",
                    modifier = Modifier.size(160.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            ) {
                Column(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
                ) {
                    Text(
                        text = "Código Pix Copia e Cola:",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = uiState.pixCode,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
            ) {
                WgcClassicButton(
                    text = "Copiar Código Pix",
                    onClick = onCopyPixCode,
                    modifier = Modifier.fillMaxWidth()
                )

                WgcClassicButton(
                    text = "Já realizei o pagamento",
                    onClick = onCheckPaymentStatus,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
