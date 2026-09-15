package br.com.wgc.design_system.components.placeholder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.HideImage
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PlaceholderDefault(
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    icon: ImageVector = Icons.Default.HideImage,
    contentDescription: String? = "Imagem"
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (isError) Icons.Default.BrokenImage else icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(48.dp),
            tint = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
        )

    }
}

@Preview
@Composable
private fun PlaceholderDefaultPreview() = PlaceholderDefault()