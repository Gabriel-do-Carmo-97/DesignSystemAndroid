package br.com.wgc.design_system.components.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estilo visual do botão de biometria.
 */
enum class WgcBiometricStyle {
    Circular,
    RoundedSquare,
    OutlinedSquare
}

/**
 * Botão Oficial de Autenticação Biométrica / Impressão Digital (WgcBiometricButton).
 * Suporta State Hoisting, semântica de acessibilidade e variações de estilo do Figma.
 */
@Composable
fun WgcBiometricButton(
    modifier: Modifier = Modifier,
    label: String? = null,
    style: WgcBiometricStyle = WgcBiometricStyle.Circular,
    size: Dp = 64.dp,
    iconSize: Dp = 36.dp,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    iconTint: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    borderColor: Color? = null,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.semantics { role = Role.Button },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        val shape = when (style) {
            WgcBiometricStyle.Circular -> CircleShape
            WgcBiometricStyle.RoundedSquare,
            WgcBiometricStyle.OutlinedSquare -> RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp)
        }

        val border = when {
            borderColor != null -> BorderStroke(1.5.dp, borderColor)
            style == WgcBiometricStyle.OutlinedSquare -> BorderStroke(1.5.dp, MaterialTheme.colorScheme.outline)
            else -> null
        }

        Surface(
            modifier = Modifier
                .size(size)
                .clickable(onClick = onClick),
            shape = shape,
            color = containerColor,
            border = border,
            shadowElevation = if (style == WgcBiometricStyle.Circular) WgcCoreDsElevation.level3.dp else WgcCoreDsElevation.level0.dp
        ) {
            Box(
                modifier = Modifier.size(size),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Fingerprint,
                    contentDescription = label ?: "Autenticação por biometria",
                    tint = iconTint,
                    modifier = Modifier.size(iconSize)
                )
            }
        }

        if (label != null) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(name = "WgcBiometricButton - All Styles", showBackground = true)
@Composable
private fun WgcBiometricButtonPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcBiometricButton(
                label = "Login with touch",
                style = WgcBiometricStyle.Circular
            )
            WgcBiometricButton(
                label = "Login with touch ID",
                style = WgcBiometricStyle.RoundedSquare
            )
            WgcBiometricButton(
                label = "Login with touch ID",
                style = WgcBiometricStyle.OutlinedSquare,
                borderColor = Color(WgcCoreDsColors.warning)
            )
        }
    }
}
