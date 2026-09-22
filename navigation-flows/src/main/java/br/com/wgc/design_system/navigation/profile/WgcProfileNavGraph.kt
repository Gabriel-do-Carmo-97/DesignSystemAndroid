@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.navigation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.factories.WgcProfileFactory
import br.com.wgc.design_system.templates.screens.profile.BaseUserProfileEditViewModel
import br.com.wgc.design_system.templates.screens.profile.FakeUserProfileEditViewModel
import br.com.wgc.design_system.templates.screens.profile.WgcUserProfileEditTemplate
import kotlinx.serialization.Serializable

/**
 * Rotas type-safe para o fluxo de Perfil e Gestão de Conta.
 */
sealed interface ProfileRoute {

    @Serializable
    data object View : ProfileRoute

    @Serializable
    data object Edit : ProfileRoute

    @Serializable
    data object Security : ProfileRoute
}

/**
 * Registra o grafo de perfil no [NavGraphBuilder].
 */
fun NavGraphBuilder.wgcProfileNavGraph(
    navController: NavController,
    editViewModel: BaseUserProfileEditViewModel = FakeUserProfileEditViewModel(),
    onNavigateBack: (() -> Unit)? = null
) {
    composable<ProfileRoute.View> {
        WgcProfileFactory(
            onLogoutClick = { onNavigateBack?.invoke() },
            footerSlot = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
                ) {
                    WgcClassicButton(
                        textButton = "Editar Dados Cadastrais",
                        onClick = { navController.navigate(ProfileRoute.Edit) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    WgcClassicButton(
                        textButton = "Segurança e Senha",
                        onClick = { navController.navigate(ProfileRoute.Security) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        )
    }

    composable<ProfileRoute.Edit> {
        WgcUserProfileEditTemplate(
            viewModel = editViewModel,
            onNavigateBack = { onNavigateBack?.invoke() ?: navController.popBackStack() }
        )
    }

    composable<ProfileRoute.Security> {
        WgcProfileSecurityScreen(
            onBackClick = { navController.popBackStack() }
        )
    }
}

/**
 * Host autocontido do fluxo de Perfil.
 */
@Composable
fun WgcProfileNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    editViewModel: BaseUserProfileEditViewModel = FakeUserProfileEditViewModel(),
    onNavigateBack: (() -> Unit)? = null
) {
    NavHost(
        navController = navController,
        startDestination = ProfileRoute.View,
        modifier = modifier
    ) {
        wgcProfileNavGraph(
            navController = navController,
            editViewModel = editViewModel,
            onNavigateBack = onNavigateBack
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WgcProfileSecurityScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Segurança e Senha") },
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
                modifier = Modifier.padding(top = WgcCoreDsSpacing.xl.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Proteção de Conta",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Gerencie a autenticação em duas etapas, altere sua senha de acesso e visualize dispositivos conectados.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
            WgcClassicButton(
                textButton = "Alterar Senha de Acesso",
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
