@file:Suppress("UnusedPrivateMember")

package br.com.wgc.design_system.components.scanner

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

private const val CORNER_LENGTH_DP = 24
private const val CORNER_STROKE_WIDTH_DP = 4
private const val LASER_STROKE_WIDTH_DP = 2
private const val ANIMATION_DURATION_MS = 1800
private const val OVERLAY_ALPHA = 0.6f

/**
 * Componente corporativo de mira e overlay para escaneamento de Códigos de Barras e QR Codes (Pix).
 *
 * @param modifier Modificador de layout
 * @param instructionText Instrução para posicionamento da câmera
 * @param isTorchOn Estado da lanterna/flash
 * @param onToggleTorch Callback acionado ao alternar o flash
 * @param cameraSlot Slot para inserção do Surface de Câmera (ex: CameraX PreviewView)
 */
@Composable
fun WgcBarcodeScanner(
    modifier: Modifier = Modifier,
    instructionText: String = "Alinhe o código de barras ou QR Code dentro da área demarcada",
    isTorchOn: Boolean = false,
    onToggleTorch: () -> Unit = {},
    cameraSlot: (@Composable () -> Unit)? = null
) {
    val laserColor = MaterialTheme.colorScheme.primary
    val cornerColor = MaterialTheme.colorScheme.primary

    val infiniteTransition = rememberInfiniteTransition(label = "LaserAnimation")
    val laserPosition by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = ANIMATION_DURATION_MS, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "LaserPosition"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        if (cameraSlot != null) {
            cameraSlot()
        } else {
            DefaultCameraPlaceholder()
        }

        ScannerOverlayViewfinder(
            cornerColor = cornerColor,
            laserColor = laserColor,
            laserProgress = laserPosition
        )

        ScannerControlsBar(
            instructionText = instructionText,
            isTorchOn = isTorchOn,
            onToggleTorch = onToggleTorch,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun DefaultCameraPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Câmera Ativa",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.LightGray
        )
    }
}

@Composable
private fun ScannerOverlayViewfinder(
    cornerColor: Color,
    laserColor: Color,
    laserProgress: Float
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(WgcCoreDsSpacing.xl32.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val width = size.width
                val height = size.height
                val cornerLength = CORNER_LENGTH_DP.dp.toPx()
                val strokeWidth = CORNER_STROKE_WIDTH_DP.dp.toPx()

                // Cantos do Viewfinder
                drawScannerCorners(cornerColor, width, height, cornerLength, strokeWidth)

                // Linha de Laser Animada
                val laserY = height * laserProgress
                drawLine(
                    color = laserColor,
                    start = Offset(0f, laserY),
                    end = Offset(width, laserY),
                    strokeWidth = LASER_STROKE_WIDTH_DP.dp.toPx(),
                    cap = StrokeCap.Round
                )
            }
        }
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawScannerCorners(
    color: Color,
    width: Float,
    height: Float,
    length: Float,
    stroke: Float
) {
    val style = Stroke(width = stroke, cap = StrokeCap.Round)

    // Top-Left
    drawLine(color, Offset(0f, 0f), Offset(length, 0f), strokeWidth = stroke)
    drawLine(color, Offset(0f, 0f), Offset(0f, length), strokeWidth = stroke)

    // Top-Right
    drawLine(color, Offset(width, 0f), Offset(width - length, 0f), strokeWidth = stroke)
    drawLine(color, Offset(width, 0f), Offset(width, length), strokeWidth = stroke)

    // Bottom-Left
    drawLine(color, Offset(0f, height), Offset(length, height), strokeWidth = stroke)
    drawLine(color, Offset(0f, height), Offset(0f, height - length), strokeWidth = stroke)

    // Bottom-Right
    drawLine(color, Offset(width, height), Offset(width - length, height), strokeWidth = stroke)
    drawLine(color, Offset(width, height), Offset(width, height - length), strokeWidth = stroke)
}

@Composable
private fun ScannerControlsBar(
    instructionText: String,
    isTorchOn: Boolean,
    onToggleTorch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = OVERLAY_ALPHA))
            .padding(WgcCoreDsSpacing.md16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        Text(
            text = instructionText,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        IconButton(
            onClick = onToggleTorch,
            modifier = Modifier
                .clip(CircleShape)
                .background(if (isTorchOn) MaterialTheme.colorScheme.primary else Color.White.copy(alpha = 0.2f))
        ) {
            Icon(
                imageVector = if (isTorchOn) Icons.Default.FlashOn else Icons.Default.FlashOff,
                contentDescription = if (isTorchOn) "Desativar lanterna" else "Ativar lanterna",
                tint = if (isTorchOn) MaterialTheme.colorScheme.onPrimary else Color.White
            )
        }
    }
}

@Preview(name = "WgcBarcodeScanner Preview", showBackground = true)
@Composable
private fun WgcBarcodeScannerPreview() {
    MaterialTheme {
        WgcBarcodeScanner()
    }
}
