package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Variantes suportadas pelo WgcButton.
 * 
 * Esta enum define os estilos visuais disponíveis para o botão:
 * - [Primary]: Botão principal com fundo preenchido na cor primária
 * - [Secondary]: Botão secundário com fundo na cor secundária
 * - [Outlined]: Botão com borda e fundo transparente
 * - [Ghost]: Botão apenas com texto, sem borda nem fundo
 * - [Danger]: Botão com fundo na cor de erro/aviso
 */
enum class WgcButtonVariant {
    /**
     * Botão principal com fundo preenchido na cor primária do tema.
     * Use para ações principais e de alta importância.
     */
    Primary,
    
    /**
     * Botão secundário com fundo na cor secundária do tema.
     * Use para ações de importância média ou alternativas.
     */
    Secondary,
    
    /**
     * Botão com borda e fundo transparente.
     * Use para ações que não devem chamar muita atenção.
     */
    Outlined,
    
    /**
     * Botão apenas com texto, sem borda nem fundo.
     * Use para ações secundárias ou links clicáveis.
     */
    Ghost,
    
    /**
     * Botão com fundo na cor de erro/aviso.
     * Use para ações destrutivas ou de alto risco.
     */
    Danger
}

/**
 * Tamanhos padronizados para o WgcButton.
 * 
 * Esta enum define os tamanhos pré-configurados seguindo os tokens de design:
 * - [Small]: Botão compacto para espaços limitados (altura 36dp)
 * - [Medium]: Tamanho padrão para maioria dos casos (altura 56dp)
 * - [Large]: Botão destacado para ações importantes (altura 64dp)
 * 
 * @property minHeight Altura mínima do botão em dp
 * @property horizontalPadding Espaçamento horizontal interno em dp
 * @property fontSize Tamanho da fonte do texto em sp
 * @property indicatorSize Tamanho do indicador de carregamento em dp
 */
enum class WgcButtonSize(
    val minHeight: Dp,
    val horizontalPadding: Dp,
    val fontSize: TextUnit,
    val indicatorSize: Dp
) {
    /**
     * Botão compacto para espaços limitados.
     * Altura: 36dp, Fonte: 12sp
     */
    Small(
        minHeight = 36.dp,
        horizontalPadding = WgcCoreDsSpacing.sm12.dp,
        fontSize = 12.sp,
        indicatorSize = 16.dp
    ),
    
    /**
     * Tamanho padrão para maioria dos casos.
     * Altura: 56dp, Fonte: 14sp
     */
    Medium(
        minHeight = 56.dp,
        horizontalPadding = WgcCoreDsSpacing.md16.dp,
        fontSize = 14.sp,
        indicatorSize = 24.dp
    ),
    
    /**
     * Botão destacado para ações importantes.
     * Altura: 64dp, Fonte: 16sp
     */
    Large(
        minHeight = 64.dp,
        horizontalPadding = WgcCoreDsSpacing.lg24.dp,
        fontSize = 16.sp,
        indicatorSize = 28.dp
    )
}

/**
 * Fábrica Universal de Botões do Design System (WgcButton).
 * 
 * Este componente implementa o padrão State Hoisting, onde o estado é controlado
 * externamente através dos parâmetros. Não mantém estado interno mutável.
 * 
 * ### Características:
 * - **Stateless**: Todo estado é passado como parâmetro
 * - **Sensible Defaults**: Funciona imediatamente com parâmetros padrão corporativos
 * - **Multiple Variants**: Suporta Primary, Secondary, Outlined, Ghost e Danger
 * - **Responsive Sizes**: Small, Medium e Large com tokens de design
 * - **Loading State**: Indicador de carregamento integrado
 * - **Accessible**: Semântica apropriada para leitores de tela
 * - **Icon Slots**: Suporte opcional para ícones à esquerda e direita
 * 
 * ### Uso Básico:
 * ```kotlin
 * WgcButton(
 *     text = "Salvar",
 *     onClick = { onSave() }
 * )
 * ```
 * 
 * ### Uso com Loading:
 * ```kotlin
 * WgcButton(
 *     text = "Salvar",
 *     onClick = { onSave() },
 *     isLoading = isSaving
 * )
 * ```
 * 
 * ### Uso com Ícones:
 * ```kotlin
 * WgcButton(
 *     text = "Enviar",
 *     onClick = { onSend() },
 *     leadingIcon = { Icon(Icons.Default.Send, contentDescription = null) }
 * )
 * ```
 * 
 * @param modifier Modificador para o componente
 * @param text Texto do botão (padrão: "Continuar")
 * @param onClick Callback executado ao clicar no botão
 * @param variant Variante visual do botão (padrão: Primary)
 * @param size Tamanho do botão (padrão: Medium)
 * @param isEnabled Se o botão está habilitado (padrão: true)
 * @param isLoading Se o botão está em estado de carregamento (padrão: false)
 * @param leadingIcon Slot opcional para ícone à esquerda do texto
 * @param trailingIcon Slot opcional para ícone à direita do texto
 */
@Composable
fun WgcButton(
    modifier: Modifier = Modifier,
    text: String = "Continuar",
    onClick: () -> Unit = {},
    variant: WgcButtonVariant = WgcButtonVariant.Primary,
    size: WgcButtonSize = WgcButtonSize.Medium,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
    val buttonModifier = modifier
        .fillMaxWidth()
        .heightIn(min = size.minHeight)
        .semantics { role = Role.Button }

    val contentComposable: @Composable () -> Unit = {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(size.indicatorSize),
                color = when (variant) {
                    WgcButtonVariant.Primary -> MaterialTheme.colorScheme.onPrimary
                    WgcButtonVariant.Secondary -> MaterialTheme.colorScheme.onSecondaryContainer
                    WgcButtonVariant.Outlined -> MaterialTheme.colorScheme.primary
                    WgcButtonVariant.Ghost -> MaterialTheme.colorScheme.primary
                    WgcButtonVariant.Danger -> MaterialTheme.colorScheme.onError
                },
                strokeWidth = 2.dp
            )
        } else {
            Row(
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = size.horizontalPadding)
            ) {
                leadingIcon?.invoke()
                Text(
                    text = text,
                    fontSize = size.fontSize
                )
                trailingIcon?.invoke()
            }
        }
    }

    when (variant) {
        WgcButtonVariant.Primary -> {
            Button(
                onClick = { if (!isLoading) onClick() },
                modifier = buttonModifier,
                enabled = isEnabled && !isLoading,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                ),
                content = { contentComposable() }
            )
        }
        WgcButtonVariant.Secondary -> {
            Button(
                onClick = { if (!isLoading) onClick() },
                modifier = buttonModifier,
                enabled = isEnabled && !isLoading,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                ),
                content = { contentComposable() }
            )
        }
        WgcButtonVariant.Outlined -> {
            OutlinedButton(
                onClick = { if (!isLoading) onClick() },
                modifier = buttonModifier,
                enabled = isEnabled && !isLoading,
                shape = shape,
                border = BorderStroke(
                    1.dp,
                    if (isEnabled) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                ),
                content = { contentComposable() }
            )
        }
        WgcButtonVariant.Ghost -> {
            TextButton(
                onClick = { if (!isLoading) onClick() },
                modifier = buttonModifier,
                enabled = isEnabled && !isLoading,
                shape = shape,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                ),
                content = { contentComposable() }
            )
        }
        WgcButtonVariant.Danger -> {
            Button(
                onClick = { if (!isLoading) onClick() },
                modifier = buttonModifier,
                enabled = isEnabled && !isLoading,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error,
                    contentColor = MaterialTheme.colorScheme.onError,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                    disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                ),
                content = { contentComposable() }
            )
        }
    }
}

@Preview(name = "WgcButton - Variants", showBackground = true)
@Composable
private fun WgcButtonVariantsPreview() {
    MaterialTheme {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            WgcButton(text = "Primary (Default)")
            WgcButton(text = "Secondary", variant = WgcButtonVariant.Secondary)
            WgcButton(text = "Outlined", variant = WgcButtonVariant.Outlined)
            WgcButton(text = "Ghost", variant = WgcButtonVariant.Ghost)
            WgcButton(text = "Danger", variant = WgcButtonVariant.Danger)
            WgcButton(text = "Loading", isLoading = true)
        }
    }
}
