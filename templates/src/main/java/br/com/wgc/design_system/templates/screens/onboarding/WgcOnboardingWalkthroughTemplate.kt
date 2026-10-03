@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.templates.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Página individual do carrossel de onboarding.
 */
data class WgcOnboardingPage(
    val title: String,
    val description: String
)

/**
 * Estado da tela de Onboarding.
 */
data class WgcOnboardingUiState(
    val currentPageIndex: Int = 0,
    val pages: List<WgcOnboardingPage> = listOf(
        WgcOnboardingPage("Bem-vindo ao WGC", "Gerencie suas finanças, compras e serviços em um único lugar."),
        WgcOnboardingPage("Segurança em Primeiro Lugar", "Seus dados estão protegidos com biometria e criptografia de ponta a ponta."),
        WgcOnboardingPage("Comece Agora", "Crie sua conta em poucos passos e aproveite todos os benefícios corporativos.")
    )
) {
    val isLastPage: Boolean get() = currentPageIndex == pages.lastIndex
}

/**
 * Template corporativo de Onboarding e boas-vindas (WgcOnboardingWalkthroughTemplate).
 */
@Composable
fun WgcOnboardingWalkthroughTemplate(
    uiState: WgcOnboardingUiState,
    onNextPage: () -> Unit,
    onSkip: () -> Unit,
    modifier: Modifier = Modifier,
    illustrationSlot: (@Composable () -> Unit)? = null
) {
    val currentPage = uiState.pages.getOrNull(uiState.currentPageIndex) ?: return

    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.xl.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                if (!uiState.isLastPage) {
                    TextButton(onClick = onSkip) {
                        Text(text = "Pular", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }

            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                illustrationSlot?.invoke()
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
            ) {
                Text(
                    text = currentPage.title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = currentPage.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                // Indicador de pontos
                Row(
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp),
                    modifier = Modifier.padding(vertical = WgcCoreDsSpacing.md.dp)
                ) {
                    uiState.pages.indices.forEach { index ->
                        val isSelected = index == uiState.currentPageIndex
                        Box(
                            modifier = Modifier
                                .size(if (isSelected) 10.dp else 8.dp)
                                .clip(CircleShape)
                                .background(if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant)
                        )
                    }
                }

                WgcClassicButton(
                    text = if (uiState.isLastPage) "Começar" else "Próximo",
                    onClick = onNextPage,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
