@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.upload

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estado do upload de um arquivo.
 */
enum class WgcUploadStatus {
    IDLE,
    UPLOADING,
    SUCCESS,
    ERROR
}

/**
 * Componente de anexo e upload de arquivos corporativo (WgcFileUpload).
 */
@Composable
fun WgcFileUpload(
    fileName: String?,
    uploadProgress: Float,
    status: WgcUploadStatus,
    onSelectFile: () -> Unit,
    onRemoveFile: () -> Unit,
    modifier: Modifier = Modifier,
    errorMessage: String? = null
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md.dp))
            .border(
                width = 1.dp,
                color = if (status == WgcUploadStatus.ERROR) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp)
            ),
        color = MaterialTheme.colorScheme.surface
    ) {
        if (fileName == null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onSelectFile)
                    .padding(WgcCoreDsSpacing.lg.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.AttachFile,
                        contentDescription = "Anexar arquivo",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Toque para anexar um documento",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = fileName,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    IconButton(onClick = onRemoveFile) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Remover arquivo",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                if (status == WgcUploadStatus.UPLOADING) {
                    LinearProgressIndicator(
                        progress = { uploadProgress.coerceIn(0f, 1f) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                if (status == WgcUploadStatus.ERROR && errorMessage != null) {
                    Text(
                        text = errorMessage,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}
