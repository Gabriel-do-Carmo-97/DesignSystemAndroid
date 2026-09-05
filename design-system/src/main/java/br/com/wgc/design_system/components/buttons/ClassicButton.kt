package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius

/**
 * Botão de ação primária do Design System (ClassicButton).
 * Suporta estado de carregamento nativo (`isLoading`) e semântica de acessibilidade.
 *
 * Exemplo de uso:
 * ```kotlin
 * ClassicButton(
 *     textButton = "Salvar",
 *     isLoading = false,
 *     onClick = { /* ação */ }
 * )
 * ```
 */
@Composable
fun ClassicButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    textButton: String = "Button"
) {
    ElevatedButton(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .semantics { role = Role.Button },
        onClick = { if (!isLoading) onClick() },
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        ),
        enabled = isEnabled && !isLoading,
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        content = {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = 2.dp
                )
            } else {
                Text(text = textButton, fontSize = 14.sp)
            }
        },
    )
}

@Preview(showBackground = true , name = "Only Component")
@Composable
private fun ButtonClassicPreview() = ClassicButton(
    isEnabled = false
)

@Preview(showBackground = true, name = "Loading State")
@Composable
private fun ButtonClassicLoadingPreview() = ClassicButton(
    isLoading = true
)

@Preview(showBackground = true, showSystemUi = true, name = "Component and SystemUi")
@Composable
private fun ButtonClassicPreview2() = ClassicButton()
