package br.com.wgc.design_system.components.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews

/**
 * Cabeçalho de Autenticação Reutilizável com Marca (WgcBrandAuthHeader).
 */
@Composable
fun WgcBrandAuthHeader(
    modifier: Modifier = Modifier,
    brandName: String,
    brandLogoText: String,
    brandColor: Color,
    title: String,
    subtitle: String
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        Surface(
            modifier = Modifier.size(72.dp),
            shape = CircleShape,
            color = brandColor,
            shadowElevation = 4.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = brandLogoText,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@WgcComponentPreviews
@Composable
private fun WgcBrandAuthHeaderPreview() {
    MaterialTheme {
        WgcBrandAuthHeader(
            brandName = "iFood",
            brandLogoText = "iF",
            brandColor = Color(0xFFEA1D2C),
            title = "Falta pouco para matar sua fome!",
            subtitle = "Como deseja continuar?"
        )
    }
}
