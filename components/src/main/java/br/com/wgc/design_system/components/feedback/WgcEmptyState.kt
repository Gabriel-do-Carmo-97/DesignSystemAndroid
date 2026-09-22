package br.com.wgc.design_system.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SearchOff
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.ThemePreviews

/**
 * Componente oficial de Estado Vazio (Empty State) do Design System WGC.
 *
 * Utilizado em listas vazias, resultados de busca inexistentes ou ausência de dados.
 *
 * @param modifier Modificador aplicado ao contêiner raiz.
 * @param title Título explicativo do estado vazio.
 * @param message Descrição com instruções ou contexto adicional.
 * @param icon Ícone opcional exibido no topo.
 * @param iconSlot Slot customizável para ilustrações ou animações (sobrepõe [icon]).
 * @param actionSlot Slot opcional para botões de ação (ex: "Limpar Filtros", "Criar Novo").
 */
@Composable
fun WgcEmptyState(
    modifier: Modifier = Modifier,
    title: String = "Nenhum item encontrado",
    message: String = "Ainda não há dados disponíveis para exibição no momento.",
    icon: ImageVector? = Icons.Outlined.SearchOff,
    iconSlot: (@Composable () -> Unit)? = null,
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
        if (iconSlot != null) {
            iconSlot()
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        } else if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                modifier = Modifier.padding(bottom = WgcCoreDsSpacing.md16.dp)
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface,
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
        }
    }
}

@ThemePreviews
@Composable
private fun WgcEmptyStatePreview() {
    MaterialTheme {
        WgcEmptyState()
    }
}
