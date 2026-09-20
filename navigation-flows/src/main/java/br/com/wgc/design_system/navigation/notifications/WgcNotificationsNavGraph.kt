@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.navigation.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.notifications.BaseNotificationCenterViewModel
import br.com.wgc.design_system.templates.screens.notifications.FakeNotificationCenterViewModel
import br.com.wgc.design_system.templates.screens.notifications.WgcNotificationCenterTemplate
import kotlinx.serialization.Serializable

/**
 * Rotas type-safe para o grafo de Notificações.
 */
sealed interface NotificationsRoute {

    @Serializable
    data object List : NotificationsRoute

    @Serializable
    data class Detail(val notificationId: String) : NotificationsRoute
}

/**
 * Registra o grafo de notificações no [NavGraphBuilder].
 */
fun NavGraphBuilder.wgcNotificationsNavGraph(
    navController: NavController,
    viewModel: BaseNotificationCenterViewModel = FakeNotificationCenterViewModel(),
    onNavigateBack: (() -> Unit)? = null
) {
    composable<NotificationsRoute.List> {
        WgcNotificationCenterTemplate(
            viewModel = viewModel,
            onNavigateBack = onNavigateBack
        )
    }

    composable<NotificationsRoute.Detail> { backStackEntry ->
        val route = backStackEntry.toRoute<NotificationsRoute.Detail>()
        WgcNotificationDetailScreen(
            notificationId = route.notificationId,
            onBackClick = { navController.popBackStack() }
        )
    }
}

/**
 * Host autocontido do fluxo de Notificações.
 */
@Composable
fun WgcNotificationsNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: BaseNotificationCenterViewModel = FakeNotificationCenterViewModel(),
    onNavigateBack: (() -> Unit)? = null
) {
    NavHost(
        navController = navController,
        startDestination = NotificationsRoute.List,
        modifier = modifier
    ) {
        wgcNotificationsNavGraph(
            navController = navController,
            viewModel = viewModel,
            onNavigateBack = onNavigateBack
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WgcNotificationDetailScreen(
    notificationId: String,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhes da Notificação") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
                .padding(WgcCoreDsSpacing.lg.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Identificador: #$notificationId",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))
            Text(
                text = "Conteúdo Completo da Notificação",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
            Text(
                text = "Esta é a tela de detalhe type-safe da notificação selecionada no grafo.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
