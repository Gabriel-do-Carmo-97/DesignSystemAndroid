@file:Suppress("LongMethod", "UnusedPrivateMember")

package br.com.wgc.design_system.navigation.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import br.com.wgc.design_system.templates.screens.card.FakeCardManagementViewModel
import br.com.wgc.design_system.templates.screens.card.WgcCardManagementContent
import kotlinx.serialization.Serializable
import kotlin.math.roundToInt

@Serializable
object WgcCardGraphRoute

@Serializable
object WgcCardHomeRoute

@Serializable
data class WgcCardLimitAdjustRoute(
    val currentLimit: Float,
    val maxLimit: Float
)

/**
 * Grafo desacoplado de navegação do fluxo de Cartões.
 *
 * @param navController Controlador de navegação
 * @param onNavigateBack Callback acionado ao sair da gestão de cartões
 */
@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.wgcCardManagementNavGraph(
    navController: NavController,
    onNavigateBack: () -> Unit = {}
) {
    navigation<WgcCardGraphRoute>(startDestination = WgcCardHomeRoute) {
        composable<WgcCardHomeRoute> {
            val fakeVm = FakeCardManagementViewModel()
            WgcCardManagementContent(
                state = fakeVm.uiState.value,
                onBackClick = onNavigateBack,
                onToggleLock = fakeVm::onToggleLock,
                onLimitChange = { newLimit ->
                    navController.navigate(
                        WgcCardLimitAdjustRoute(
                            currentLimit = newLimit,
                            maxLimit = fakeVm.uiState.value.maxLimit
                        )
                    )
                },
                onCreateVirtualCard = fakeVm::onCreateVirtualCard
            )
        }

        composable<WgcCardLimitAdjustRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<WgcCardLimitAdjustRoute>()
            CardLimitAdjustScreen(
                currentLimit = route.currentLimit,
                maxLimit = route.maxLimit,
                onBackClick = { navController.popBackStack() },
                onSaveLimit = { navController.popBackStack() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CardLimitAdjustScreen(
    currentLimit: Float,
    maxLimit: Float,
    onBackClick: () -> Unit,
    onSaveLimit: (Float) -> Unit
) {
    var limit by remember { mutableFloatStateOf(currentLimit) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ajustar Limite", style = MaterialTheme.typography.titleMedium) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
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
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
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
                    Text(text = "Novo Limite Escolhido", style = MaterialTheme.typography.labelMedium)
                    Text(
                        text = "R$ ${limit.roundToInt()},00",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Slider(
                        value = limit,
                        onValueChange = { limit = it },
                        valueRange = 500f..maxLimit,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Mín: R$ 500", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Disponível: R$ ${maxLimit.roundToInt()}", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }

            WgcClassicButton(
                textButton = "Salvar Novo Limite",
                onClick = { onSaveLimit(limit) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
