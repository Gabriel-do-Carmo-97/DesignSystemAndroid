@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.screens.pix

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FlashOn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcPixScannerUiState(
    val title: String = "Escanear QR Code Pix",
    val instruction: String = "Aponte a câmera para o QR Code Pix para efetuar o pagamento instantâneo.",
    val isFlashlightOn: Boolean = false
)

/**
 * Template de escaneamento de QR Code Pix com mira iluminada e slot para CameraX.
 */
@Suppress("LongMethod")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcPixScannerTemplate(
    uiState: WgcPixScannerUiState = WgcPixScannerUiState(),
    onBack: () -> Unit = {},
    onToggleFlashlight: () -> Unit = {},
    onPasteKeyManually: () -> Unit = {},
    cameraPreviewSlot: @Composable () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = uiState.title, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                actions = {
                    IconButton(onClick = onToggleFlashlight) {
                        Icon(
                            imageVector = Icons.Default.FlashOn,
                            contentDescription = "Lanterna",
                            tint = if (uiState.isFlashlightOn) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            cameraPreviewSlot()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(WgcCoreDsSpacing.lg24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = uiState.instruction,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)
                )

                // Retículo de enquadramento do QR Code
                Box(
                    modifier = Modifier
                        .size(240.dp)
                        .border(
                            width = 3.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp)
                        )
                )

                WgcClassicButton(
                    text = "Digitar ou Colar Chave Pix",
                    onClick = onPasteKeyManually,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
