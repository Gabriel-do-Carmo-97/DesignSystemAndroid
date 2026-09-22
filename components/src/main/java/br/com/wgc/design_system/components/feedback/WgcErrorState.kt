package br.com.wgc.design_system.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.ThemePreviews
import br.com.wgc.design_system.components.buttons.WgcClassicButton

/**
 * Componente oficial de Estado de Erro (Error State) do Design System WGC.
 *
 * Utilizado para exibir falhas de rede, erros de carregamento ou exceções com opção de retry.
 *
 * @param modifier Modificador aplicado ao contêiner raiz.
 * @param title Título explicativo do erro.
 * @param message Descrição do erro e orientação ao usuário.
 * @param retryButtonText Texto do botão de nova tentativa. Se nulo ou vazio, nenhum botão padrão é exibido.
 * @param onRetry Callback executado ao acionar o botão de retry.
 * @param icon Ícone indicativo de erro.
 * @param actionSlot Slot opcional para substituir ou customizar o botão de ação.
 */
@Composable
fun WgcErrorState(
    modifier: Modifier = Modifier,
    title: String = "Ocorreu um erro",
    message: String = "Não foi possível carregar as informações. Verifique sua conexão e tente novamente.",
    retryButtonText: String? = "Tentar Novamente",
    onRetry: (() -> Unit)? = null,
    icon: ImageVector? = Icons.Outlined.ErrorOutline,
    actionSlot: (@Composable () -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.lg24.dp)
            .semantics(mergeDescendants = true) {},
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = WgcCoreDsSpacing.md16.dp)
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center,
            modifier = Modifier.semantics { heading() },
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )

        if (actionSlot != null) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))
            actionSlot()
        } else if (onRetry != null && !retryButtonText.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))
            WgcClassicButton(
                textButton = retryButtonText,
                onClick = onRetry,
            )
        }
    }
}

@ThemePreviews
@Composable
private fun WgcErrorStatePreview() {
    MaterialTheme {
        WgcErrorState(
            onRetry = {}
        )
    }
}
