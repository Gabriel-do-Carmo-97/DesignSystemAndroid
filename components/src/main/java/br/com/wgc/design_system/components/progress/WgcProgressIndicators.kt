package br.com.wgc.design_system.components.progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * WgcCircularProgressIndicator (Indeterminado)
 *
 * Indicador de progresso circular rotativo corporativo.
 *
 * @param modifier Modificador de layout.
 * @param size Dimensão do indicador (largura e altura).
 * @param strokeWidth Espessura da linha circular.
 * @param color Cor do progresso.
 * @param trackColor Cor do fundo/trilha.
 * @param label Texto opcional exibido abaixo do indicador.
 */
@Composable
fun WgcCircularProgressIndicator(
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    label: String? = null
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(size),
            color = color,
            strokeWidth = strokeWidth,
            trackColor = trackColor,
            strokeCap = StrokeCap.Round
        )
        if (!label.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * WgcCircularProgressIndicator (Determinado)
 *
 * Indicador de progresso circular com percentual conhecido.
 *
 * @param progress Valor de 0.0f a 1.0f.
 * @param modifier Modificador de layout.
 * @param size Dimensão do indicador.
 * @param strokeWidth Espessura da linha circular.
 * @param color Cor do progresso.
 * @param trackColor Cor do fundo.
 * @param label Texto opcional exibido abaixo do indicador.
 */
@Composable
fun WgcCircularProgressIndicator(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    label: String? = null
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.size(size),
            color = color,
            strokeWidth = strokeWidth,
            trackColor = trackColor,
            strokeCap = StrokeCap.Round
        )
        if (!label.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * WgcLinearProgressIndicator (Indeterminado)
 *
 * Barra de progresso linear com animação contínua.
 *
 * @param modifier Modificador de layout.
 * @param color Cor do progresso.
 * @param trackColor Cor da trilha de fundo.
 * @param label Texto opcional acima ou abaixo da barra.
 */
@Composable
fun WgcLinearProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    label: String? = null
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
    ) {
        if (!label.isNullOrBlank()) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = color,
            trackColor = trackColor,
            strokeCap = StrokeCap.Round
        )
    }
}

/**
 * WgcLinearProgressIndicator (Determinado)
 *
 * Barra de progresso linear com percentual conhecido.
 *
 * @param progress Função que provê o valor de 0.0f a 1.0f.
 * @param modifier Modificador de layout.
 * @param color Cor do progresso.
 * @param trackColor Cor da trilha de fundo.
 * @param label Texto de status opcional.
 * @param showPercentage Define se deve exibir automaticamente o percentual formatado.
 */
@Composable
fun WgcLinearProgressIndicator(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    label: String? = null,
    showPercentage: Boolean = false
) {
    val currentProgress = progress()
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
    ) {
        if (!label.isNullOrBlank() || showPercentage) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (!label.isNullOrBlank()) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                if (showPercentage) {
                    val percentText = "${(currentProgress.coerceIn(0f, 1f) * 100).toInt()}%"
                    Text(
                        text = percentText,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.fillMaxWidth(),
            color = color,
            trackColor = trackColor,
            strokeCap = StrokeCap.Round
        )
    }
}

@WgcComponentPreviews
@Composable
private fun WgcProgressIndicatorsPreview() {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WgcCircularProgressIndicator(label = "Carregando dados...")
                WgcCircularProgressIndicator(progress = { 0.65f }, label = "65% completo")
                WgcLinearProgressIndicator(label = "Processando transação...")
                WgcLinearProgressIndicator(progress = { 0.75f }, label = "Upload", showPercentage = true)
            }
        }
    }
}
