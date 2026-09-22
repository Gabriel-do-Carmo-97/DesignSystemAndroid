package br.com.wgc.design_system.navigation.help

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.support.FakeHelpCenterViewModel
import br.com.wgc.design_system.templates.screens.support.WgcHelpCenterSupportContent
import kotlinx.serialization.Serializable

@Serializable
object WgcHelpCenterGraphRoute

@Serializable
object WgcHelpCenterHomeRoute

@Serializable
data class WgcHelpCenterFaqDetailRoute(
    val faqId: String,
    val question: String = "",
    val answer: String = ""
)

@Serializable
data class WgcHelpCenterTicketDetailRoute(
    val ticketId: String
)

/**
 * Grafo de navegação completo para a Central de Ajuda e Suporte ao Cliente.
 *
 * @param navController Controlador de navegação.
 * @param onNavigateBack Callback acionado ao voltar do fluxo.
 * @param onContactSupport Callback acionado ao solicitar suporte via atendente.
 */
@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.wgcHelpCenterNavGraph(
    navController: NavController,
    onNavigateBack: () -> Unit = {},
    onContactSupport: () -> Unit = {}
) {
    navigation<WgcHelpCenterGraphRoute>(startDestination = WgcHelpCenterHomeRoute) {
        composable<WgcHelpCenterHomeRoute> {
            val fakeVm = FakeHelpCenterViewModel()
            WgcHelpCenterSupportContent(
                state = fakeVm.uiState.value,
                onSearchQueryChange = fakeVm::onSearchQueryChange,
                onCategorySelect = fakeVm::onCategorySelect,
                onContactSupportClick = onContactSupport,
                onTicketClick = { ticketId ->
                    navController.navigate(WgcHelpCenterTicketDetailRoute(ticketId = ticketId))
                },
                headerSlot = {
                    TopAppBar(
                        title = { Text(fakeVm.uiState.value.title, style = MaterialTheme.typography.titleLarge) },
                        navigationIcon = {
                            IconButton(onClick = onNavigateBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Voltar"
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                            titleContentColor = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            )
        }

        composable<WgcHelpCenterFaqDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<WgcHelpCenterFaqDetailRoute>()
            WgcFaqDetailScreen(
                faqId = route.faqId,
                question = route.question,
                answer = route.answer,
                onBackClick = { navController.popBackStack() },
                onContactSupport = onContactSupport
            )
        }

        composable<WgcHelpCenterTicketDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<WgcHelpCenterTicketDetailRoute>()
            WgcTicketDetailScreen(
                ticketId = route.ticketId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WgcFaqDetailScreen(
    faqId: String,
    question: String,
    answer: String,
    onBackClick: () -> Unit,
    onContactSupport: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dúvida Frequente", style = MaterialTheme.typography.titleMedium) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(WgcCoreDsSpacing.md16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Text(
                        text = if (question.isNotBlank()) question else "Detalhes da Pergunta #$faqId",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = if (answer.isNotBlank()) answer else "Resposta detalhada com instruções passo a passo para resolução do seu questionamento.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            WgcClassicButton(
                textButton = "Ainda preciso de ajuda",
                onClick = onContactSupport,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WgcTicketDetailScreen(
    ticketId: String,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Protocolo $ticketId", style = MaterialTheme.typography.titleMedium) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Text(
                        text = "Status: Em Análise pela Equipe WGC",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Seu chamado foi registrado e nossa equipe técnica está analisando a solicitação.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
