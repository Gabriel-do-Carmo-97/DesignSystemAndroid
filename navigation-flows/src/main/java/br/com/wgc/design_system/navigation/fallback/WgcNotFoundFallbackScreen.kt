@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.navigation.fallback

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.placeholder.WgcEmptyDataPlaceholder
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.serialization.Serializable

@Serializable
data class WgcNotFoundRoute(
    val attemptedRoute: String = ""
)

/**
 * Tela de fallback de contingência (404 Not Found) para rotas inválidas ou deep links corrompidos.
 */
@Composable
fun WgcNotFoundFallbackScreen(
    attemptedRoute: String,
    onNavigateHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.lg24.dp),
            contentAlignment = Alignment.Center
        ) {
            WgcEmptyDataPlaceholder(
                title = "Destino não encontrado (404)",
                description = if (attemptedRoute.isNotBlank()) {
                    "A rota '$attemptedRoute' não existe ou está temporariamente indisponível."
                } else {
                    "O destino solicitado não pôde ser carregado."
                },
                actionSlot = {
                    WgcClassicButton(
                        text = "Voltar ao Início",
                        onClick = onNavigateHome
                    )
                }
            )
        }
    }
}
