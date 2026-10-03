@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.templates.screens.kyc

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CheckCircle
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

/**
 * Estado da tela de envio de documentos KYC.
 */
data class WgcKycDocumentUiState(
    val title: String = "Envio de Documento",
    val description: String = "Tire foto da frente e do verso do seu documento oficial (RG ou CNH).",
    val hasFrontPhoto: Boolean = false,
    val hasBackPhoto: Boolean = false,
    val isUploading: Boolean = false
) {
    val isComplete: Boolean get() = hasFrontPhoto && hasBackPhoto
}

/**
 * Template corporativo para captura de documentos KYC (RG/CNH frente e verso).
 */
@Composable
fun WgcKycDocumentVerificationTemplate(
    uiState: WgcKycDocumentUiState,
    onCaptureFront: () -> Unit,
    onCaptureBack: () -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)) {
                Text(
                    text = uiState.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = uiState.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                DocumentCaptureCard(
                    label = "Frente do documento",
                    hasPhoto = uiState.hasFrontPhoto,
                    onClick = onCaptureFront
                )

                DocumentCaptureCard(
                    label = "Verso do documento",
                    hasPhoto = uiState.hasBackPhoto,
                    onClick = onCaptureBack
                )
            }

            WgcClassicButton(
                text = "Enviar Documentos",
                onClick = onSubmit,
                isEnabled = uiState.isComplete && !uiState.isUploading,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun DocumentCaptureCard(
    label: String,
    hasPhoto: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .border(
                width = 1.dp,
                color = if (hasPhoto) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp)
            ),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.lg.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
            ) {
                Icon(
                    imageVector = if (hasPhoto) Icons.Default.CheckCircle else Icons.Default.CameraAlt,
                    contentDescription = null,
                    tint = if (hasPhoto) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = label,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Text(
                text = if (hasPhoto) "Alterar" else "Capturar",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
