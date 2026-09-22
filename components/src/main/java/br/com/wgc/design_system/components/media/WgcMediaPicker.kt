@file:Suppress("LongMethod", "MatchingDeclarationName")
package br.com.wgc.design_system.components.media

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estados do componente de upload/seleção de mídia.
 */
sealed interface WgcMediaUploadState {
    data object Idle : WgcMediaUploadState
    data class Uploading(val progress: Float = 0f) : WgcMediaUploadState
    data class Success(val fileName: String, val fileSize: String? = null) : WgcMediaUploadState
    data class Error(val errorMessage: String) : WgcMediaUploadState
}

/**
 * Componente corporativo para seleção e upload de arquivos, fotos ou documentos.
 * Totalmente desacoplado e aderente ao State Hoisting.
 *
 * @param modifier Modificador de layout
 * @param label Título/rótulo do campo de upload
 * @param supportingText Texto de instrução complementar
 * @param state Estado atual do upload (Idle, Uploading, Success, Error)
 * @param isEnabled Se o componente está habilitado para interação
 * @param onPickFile Callback acionado ao clicar para selecionar arquivo
 * @param onRemoveFile Callback acionado ao clicar para remover o arquivo enviado
 * @param onRetry Callback acionado ao tentar novamente em caso de erro
 */
@Composable
fun WgcMediaPicker(
    modifier: Modifier = Modifier,
    label: String = "Anexar Arquivo ou Foto",
    supportingText: String = "Formatos suportados: PNG, JPG ou PDF (máx. 10MB)",
    state: WgcMediaUploadState = WgcMediaUploadState.Idle,
    isEnabled: Boolean = true,
    onPickFile: () -> Unit = {},
    onRemoveFile: () -> Unit = {},
    onRetry: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = if (isEnabled) MaterialTheme.colorScheme.onSurface
            else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        )

        when (state) {
            is WgcMediaUploadState.Idle -> {
                WgcMediaIdleCard(
                    supportingText = supportingText,
                    isEnabled = isEnabled,
                    onClick = onPickFile
                )
            }
            is WgcMediaUploadState.Uploading -> {
                WgcMediaUploadingCard(progress = state.progress)
            }
            is WgcMediaUploadState.Success -> {
                WgcMediaSuccessCard(
                    fileName = state.fileName,
                    fileSize = state.fileSize,
                    isEnabled = isEnabled,
                    onRemove = onRemoveFile
                )
            }
            is WgcMediaUploadState.Error -> {
                WgcMediaErrorCard(
                    errorMessage = state.errorMessage,
                    isEnabled = isEnabled,
                    onRetry = onRetry
                )
            }
        }
    }
}

@Composable
private fun WgcMediaIdleCard(
    supportingText: String,
    isEnabled: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isEnabled) MaterialTheme.colorScheme.outlineVariant
    else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
            )
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f))
            .clickable(enabled = isEnabled, onClick = onClick)
            .padding(WgcCoreDsSpacing.md16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CloudUpload,
                contentDescription = "Upload",
                tint = if (isEnabled) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.38f),
                modifier = Modifier.size(36.dp)
            )
            Text(
                text = "Toque para selecionar ou tirar foto",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = if (isEnabled) MaterialTheme.colorScheme.onSurface
                else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            )
            Text(
                text = supportingText,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
private fun WgcMediaUploadingCard(progress: Float) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Enviando arquivo...",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = "${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun WgcMediaSuccessCard(
    fileName: String,
    fileSize: String?,
    isEnabled: Boolean,
    onRemove: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
        )
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.xs8.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Description,
                contentDescription = "Arquivo",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(28.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = fileName,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                if (fileSize != null) {
                    Text(
                        text = fileSize,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Enviado com sucesso",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(20.dp)
            )
            IconButton(
                onClick = onRemove,
                enabled = isEnabled,
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Remover arquivo",
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
private fun WgcMediaErrorCard(
    errorMessage: String,
    isEnabled: Boolean,
    onRetry: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.error.copy(alpha = 0.5f)
        )
    ) {
        Row(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Error,
                contentDescription = "Erro",
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(24.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Falha no envio",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.error
                )
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }
            Text(
                text = "Tentar novamente",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .clickable(enabled = isEnabled, onClick = onRetry)
                    .padding(WgcCoreDsSpacing.xxs4.dp)
            )
        }
    }
}

@Preview(name = "WgcMediaPicker - Idle", showBackground = true)
@Composable
private fun WgcMediaPickerIdlePreview() {
    MaterialTheme {
        WgcMediaPicker(modifier = Modifier.padding(16.dp))
    }
}

@Preview(name = "WgcMediaPicker - Success", showBackground = true)
@Composable
private fun WgcMediaPickerSuccessPreview() {
    MaterialTheme {
        WgcMediaPicker(
            modifier = Modifier.padding(16.dp),
            state = WgcMediaUploadState.Success(
                fileName = "comprovante_pagamento.pdf",
                fileSize = "2.4 MB"
            )
        )
    }
}
