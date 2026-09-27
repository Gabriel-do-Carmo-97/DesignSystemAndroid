package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Fábrica Corporativa Unificada para criação de botões no ecossistema WGC (WgcButtonFactory).
 * Fornece métodos ergonômicos com defaults sensatos e slots de customização completos.
 */
object WgcButtonFactory {

    /**
     * Cria um botão principal corporativo de alta ênfase.
     */
    @Composable
    fun Primary(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        isLoading: Boolean = false,
        size: WgcButtonSize = WgcButtonSize.Medium,
        leadingIcon: (@Composable () -> Unit)? = null,
        trailingIcon: (@Composable () -> Unit)? = null
    ) {
        WgcButton(
            text = text,
            onClick = onClick,
            modifier = modifier,
            variant = WgcButtonVariant.Primary,
            size = size,
            isEnabled = enabled,
            isLoading = isLoading,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }

    /**
     * Cria um botão secundário para ações complementares.
     */
    @Composable
    fun Secondary(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        isLoading: Boolean = false,
        size: WgcButtonSize = WgcButtonSize.Medium,
        leadingIcon: (@Composable () -> Unit)? = null,
        trailingIcon: (@Composable () -> Unit)? = null
    ) {
        WgcButton(
            text = text,
            onClick = onClick,
            modifier = modifier,
            variant = WgcButtonVariant.Secondary,
            size = size,
            isEnabled = enabled,
            isLoading = isLoading,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }

    /**
     * Cria um botão com contorno (Outlined) para ações de menor destaque visual.
     */
    @Composable
    fun Outlined(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        isLoading: Boolean = false,
        size: WgcButtonSize = WgcButtonSize.Medium,
        leadingIcon: (@Composable () -> Unit)? = null,
        trailingIcon: (@Composable () -> Unit)? = null
    ) {
        WgcButton(
            text = text,
            onClick = onClick,
            modifier = modifier,
            variant = WgcButtonVariant.Outlined,
            size = size,
            isEnabled = enabled,
            isLoading = isLoading,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }

    /**
     * Cria um botão transparente (Ghost/Text) para links ou ações secundárias contextuais.
     */
    @Composable
    fun Ghost(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        isLoading: Boolean = false,
        size: WgcButtonSize = WgcButtonSize.Medium,
        leadingIcon: (@Composable () -> Unit)? = null,
        trailingIcon: (@Composable () -> Unit)? = null
    ) {
        WgcButton(
            text = text,
            onClick = onClick,
            modifier = modifier,
            variant = WgcButtonVariant.Ghost,
            size = size,
            isEnabled = enabled,
            isLoading = isLoading,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }

    /**
     * Cria um botão destrutivo (Danger) para confirmação de ações de risco ou exclusão.
     */
    @Composable
    fun Danger(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        isLoading: Boolean = false,
        size: WgcButtonSize = WgcButtonSize.Medium,
        leadingIcon: (@Composable () -> Unit)? = null,
        trailingIcon: (@Composable () -> Unit)? = null
    ) {
        WgcButton(
            text = text,
            onClick = onClick,
            modifier = modifier,
            variant = WgcButtonVariant.Danger,
            size = size,
            isEnabled = enabled,
            isLoading = isLoading,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}

@Preview(showBackground = true)
@WgcComponentPreviews
@Composable
private fun WgcButtonFactoryPreview() {
    MaterialTheme {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            WgcButtonFactory.Primary(
                text = "Confirmar Pagamento",
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )
            WgcButtonFactory.Secondary(
                text = "Adicionar Item",
                onClick = {},
                leadingIcon = { Icon(Icons.Default.Add, contentDescription = null) }
            )
            WgcButtonFactory.Outlined(
                text = "Ver Detalhes",
                onClick = {}
            )
            WgcButtonFactory.Danger(
                text = "Excluir Conta",
                onClick = {},
                leadingIcon = { Icon(Icons.Default.Delete, contentDescription = null) }
            )
        }
    }
}
