@file:Suppress("UnusedPrivateMember")

package br.com.wgc.design_system.components.signature

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
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
import androidx.compose.material.icons.automirrored.filled.Undo
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

private const val SIGNATURE_BOX_HEIGHT = 200
private const val DEFAULT_STROKE_WIDTH = 3f

/**
 * Componente corporativo para captura de assinatura digital em tela.
 * Totalmente aderente ao State Hoisting, sem valores mágicos e com suporte a desfazer/limpar.
 *
 * @param modifier Modificador de layout
 * @param strokes Lista de traços desenhados (cada traço é uma lista de pontos Offset)
 * @param onStrokesChange Callback acionado ao adicionar um novo traço
 * @param onClear Callback acionado ao solicitar a limpeza da área de assinatura
 * @param onUndo Callback acionado ao desfazer o último traço
 * @param onExport Callback acionado ao confirmar/exportar a assinatura
 * @param strokeColor Cor da caneta/traço
 * @param isEnabled Se a interação com o painel está ativa
 * @param showControls Se a barra de botões auxiliares deve ser exibida
 */
@Composable
fun WgcSignaturePad(
    strokes: List<List<Offset>>,
    onStrokesChange: (List<List<Offset>>) -> Unit,
    onClear: () -> Unit,
    onUndo: () -> Unit,
    onExport: () -> Unit,
    modifier: Modifier = Modifier,
    strokeColor: Color = MaterialTheme.colorScheme.onSurface,
    isEnabled: Boolean = true,
    showControls: Boolean = true
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            SignatureHeader(strokesCount = strokes.size)

            SignatureCanvasBox(
                strokes = strokes,
                onStrokesChange = onStrokesChange,
                strokeColor = strokeColor,
                isEnabled = isEnabled
            )

            if (showControls) {
                SignatureControlsRow(
                    hasStrokes = strokes.isNotEmpty(),
                    isEnabled = isEnabled,
                    onUndo = onUndo,
                    onClear = onClear,
                    onExport = onExport
                )
            }
        }
    }
}

@Composable
private fun SignatureHeader(strokesCount: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Assinatura Digital",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = if (strokesCount == 0) "Área em branco" else "$strokesCount traço(s)",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Composable
private fun SignatureCanvasBox(
    strokes: List<List<Offset>>,
    onStrokesChange: (List<List<Offset>>) -> Unit,
    strokeColor: Color,
    isEnabled: Boolean
) {
    val currentPoints = remember { mutableStateListOf<Offset>() }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(SIGNATURE_BOX_HEIGHT.dp)
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .pointerInput(isEnabled) {
                if (!isEnabled) return@pointerInput
                detectDragGestures(
                    onDragStart = { offset ->
                        currentPoints.clear()
                        currentPoints.add(offset)
                    },
                    onDrag = { change, _ ->
                        change.consume()
                        currentPoints.add(change.position)
                    },
                    onDragEnd = {
                        if (currentPoints.isNotEmpty()) {
                            val newStrokes = strokes + listOf(currentPoints.toList())
                            onStrokesChange(newStrokes)
                            currentPoints.clear()
                        }
                    }
                )
            }
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            for (stroke in strokes) {
                drawSmoothPath(stroke, strokeColor)
            }
            if (currentPoints.isNotEmpty()) {
                drawSmoothPath(currentPoints, strokeColor)
            }
        }
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawSmoothPath(
    points: List<Offset>,
    color: Color
) {
    if (points.size < 2) return
    val path = Path().apply {
        moveTo(points[0].x, points[0].y)
        for (i in 1 until points.size) {
            lineTo(points[i].x, points[i].y)
        }
    }
    drawPath(
        path = path,
        color = color,
        style = Stroke(
            width = DEFAULT_STROKE_WIDTH,
            cap = StrokeCap.Round,
            join = StrokeJoin.Round
        )
    )
}

@Composable
private fun SignatureControlsRow(
    hasStrokes: Boolean,
    isEnabled: Boolean,
    onUndo: () -> Unit,
    onClear: () -> Unit,
    onExport: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
            IconButton(
                onClick = onUndo,
                enabled = isEnabled && hasStrokes
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Undo,
                    contentDescription = "Desfazer último traço",
                    tint = if (isEnabled && hasStrokes) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.outline
                )
            }
            IconButton(
                onClick = onClear,
                enabled = isEnabled && hasStrokes
            ) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Limpar assinatura",
                    tint = if (isEnabled && hasStrokes) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.outline
                )
            }
        }

        WgcClassicButton(
            textButton = "Confirmar",
            onClick = onExport,
            isEnabled = isEnabled && hasStrokes
        )
    }
}

@Preview(name = "WgcSignaturePad Preview", showBackground = true)
@Composable
private fun WgcSignaturePadPreview() {
    MaterialTheme {
        WgcSignaturePad(
            strokes = emptyList(),
            onStrokesChange = {},
            onClear = {},
            onUndo = {},
            onExport = {}
        )
    }
}
