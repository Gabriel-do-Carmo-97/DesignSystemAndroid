package br.com.wgc.design_system.components.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Provedores sociais suportados nos botões pill.
 */
enum class WgcSocialPillProvider(
    val defaultLabel: String,
    val brandColor: Color
) {
    Facebook("Login with Facebook", Color(WgcCoreDsColors.socialFacebook)),
    Instagram("Login with Instagram", Color(WgcCoreDsColors.socialInstagram)),
    LinkedIn("Login with LinkedIn", Color(WgcCoreDsColors.socialLinkedIn))
}

/**
 * Botão Social em Formato Pill de Largura Total (WgcSocialLoginPillButton).
 * Utilizado no Template Modern Klok do Figma.
 */
@Composable
fun WgcSocialLoginPillButton(
    modifier: Modifier = Modifier,
    provider: WgcSocialPillProvider,
    customLabel: String? = null,
    icon: ImageVector? = null,
    onClick: () -> Unit = {}
) {
    val displayLabel = customLabel ?: provider.defaultLabel
    val displayIcon = icon ?: when (provider) {
        WgcSocialPillProvider.Facebook -> Icons.Default.Share
        WgcSocialPillProvider.Instagram -> Icons.Default.CameraAlt
        WgcSocialPillProvider.LinkedIn -> Icons.Default.Link
    }

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .semantics { role = Role.Button },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = WgcCoreDsElevation.level1.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = WgcCoreDsSpacing.sm12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = displayIcon,
                contentDescription = displayLabel,
                tint = provider.brandColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
            Text(
                text = displayLabel,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * Grupo de botões sociais pill conforme o Template 3 do Figma.
 */
@Composable
fun WgcSocialLoginPillGroup(
    modifier: Modifier = Modifier,
    onFacebookClick: () -> Unit = {},
    onInstagramClick: () -> Unit = {},
    onLinkedInClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        WgcSocialLoginPillButton(
            provider = WgcSocialPillProvider.Facebook,
            onClick = onFacebookClick
        )
        WgcSocialLoginPillButton(
            provider = WgcSocialPillProvider.Instagram,
            onClick = onInstagramClick
        )
        WgcSocialLoginPillButton(
            provider = WgcSocialPillProvider.LinkedIn,
            onClick = onLinkedInClick
        )
    }
}

@Preview(name = "WgcSocialLoginPillGroup", showBackground = true)
@Composable
private fun WgcSocialLoginPillGroupPreview() {
    MaterialTheme {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            WgcSocialLoginPillGroup()
        }
    }
}
