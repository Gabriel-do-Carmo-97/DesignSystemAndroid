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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.commons.WgcDevicePreviews

/**
 * Botão de ação primária do Design System (WgcClassicButton).
 * 
 * Este é um botão elevado (elevated button) seguindo o Material Design 3,
 * otimizado para ações principais em formulários e fluxos de navegação.
 * 
 * ### Características:
 * - **Elevated Style**: Botão com elevação sutil para destaque visual
 * - **Loading State**: Indicador de carregamento integrado que desabilita interações
 * - **Accessibility**: Semântica de botão para leitores de tela
 * - **Standard Height**: Altura fixa de 56dp seguindo guias de Material Design
 * - **State Hoisting**: Estado controlado externamente (stateless)
 * 
 * ### Quando usar:
 * - Como ação principal em formulários
 * - Em diálogos e bottom sheets
 * - Para ações de confirmação importantes
 * 
 * ### Quando não usar:
 * - Para ações secundárias (use WgcSecondaryClassicButton)
 * - Em barras de navegação (use WgcPillTabSwitch)
 * - Para ações textuais (use TextButton ou WgcButton com variant Ghost)
 * 
 * ### Uso Básico:
 * ```kotlin
 * WgcClassicButton(
 *     textButton = "Confirmar",
 *     onClick = { onConfirm() }
 * )
 * ```
 * 
 * ### Uso com Loading:
 * ```kotlin
 * WgcClassicButton(
 *     textButton = "Confirmar",
 *     onClick = { onConfirm() },
 *     isLoading = isConfirming
 * )
 * ```
 * 
 * @param modifier Modificador para o componente
 * @param onClick Callback executado ao clicar no botão
 * @param isEnabled Se o botão está habilitado (padrão: true)
 * @param isLoading Se o botão está em estado de carregamento (padrão: false)
 * @param textButton Texto exibido no botão (padrão: "Button")
 */
@Composable
fun WgcClassicButton(
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

@WgcDevicePreviews
@Preview(showBackground = true, name = "Default - Enabled")
@Composable
private fun ButtonClassicDefaultPreview() = WgcClassicButton(
    isEnabled = true,
    textButton = "Continuar"
)

@WgcDevicePreviews
@Preview(showBackground = true, name = "Disabled State")
@Composable
private fun ButtonClassicDisabledPreview() = WgcClassicButton(
    isEnabled = false,
    textButton = "Continuar"
)

@WgcDevicePreviews
@Preview(showBackground = true, name = "Loading State")
@Composable
private fun ButtonClassicLoadingPreview() = WgcClassicButton(
    isLoading = true,
    textButton = "Continuar"
)
