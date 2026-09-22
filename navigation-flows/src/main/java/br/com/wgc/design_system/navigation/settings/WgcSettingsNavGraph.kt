package br.com.wgc.design_system.navigation.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.factories.WgcSettingsHubFactory
import br.com.wgc.design_system.templates.factories.WgcSettingsHubType
import kotlinx.serialization.Serializable

@Serializable
object WgcSettingsGraphRoute

@Serializable
object WgcSettingsOverviewRoute

@Serializable
object WgcSettingsSecurityRoute

@Serializable
object WgcSettingsPreferencesRoute

@Serializable
object WgcSettingsTermsRoute

/**
 * Grafo de navegação completo e type-safe para configurações de conta, segurança e preferências (WgcSettingsNavGraph).
 *
 * @param navController Controlador de navegação.
 * @param onLogoutConfirmed Callback disparado quando o logout for concluído.
 * @param onBackClick Callback disparado ao solicitar retorno da tela de visão geral.
 */
fun NavGraphBuilder.wgcSettingsNavGraph(
    navController: NavController,
    onLogoutConfirmed: () -> Unit = {},
    onBackClick: () -> Unit = { navController.popBackStack() }
) {
    navigation<WgcSettingsGraphRoute>(startDestination = WgcSettingsOverviewRoute) {
        composable<WgcSettingsOverviewRoute> {
            var showLogoutDialog by remember { mutableStateOf(false) }

            WgcSettingsHubFactory(
                type = WgcSettingsHubType.STANDARD,
                onPrivacyClick = { navController.navigate(WgcSettingsSecurityRoute) },
                onTermsClick = { navController.navigate(WgcSettingsTermsRoute) },
                onLogoutClick = { showLogoutDialog = true },
                onBackClick = onBackClick
            )

            if (showLogoutDialog) {
                AlertDialog(
                    onDismissRequest = { showLogoutDialog = false },
                    title = { Text("Encerrar Sessão", fontWeight = FontWeight.Bold) },
                    text = { Text("Deseja realmente sair da sua conta corporativa WGC?") },
                    confirmButton = {
                        TextButton(onClick = {
                            showLogoutDialog = false
                            onLogoutConfirmed()
                        }) {
                            Text("Sair", color = MaterialTheme.colorScheme.error)
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showLogoutDialog = false }) {
                            Text("Cancelar")
                        }
                    }
                )
            }
        }

        composable<WgcSettingsSecurityRoute> {
            WgcSettingsHubFactory(
                type = WgcSettingsHubType.SECURITY,
                onBackClick = { navController.popBackStack() },
                onPrivacyClick = { navController.navigate(WgcSettingsTermsRoute) }
            )
        }

        composable<WgcSettingsPreferencesRoute> {
            WgcSettingsHubFactory(
                type = WgcSettingsHubType.PREFERENCES,
                onBackClick = { navController.popBackStack() },
                onTermsClick = { navController.navigate(WgcSettingsTermsRoute) },
                onLogoutClick = onLogoutConfirmed
            )
        }

        composable<WgcSettingsTermsRoute> {
            WgcSettingsTermsNavScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcSettingsTermsNavScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Termos e Privacidade", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Text(
                text = "Termos Gerais de Uso e Política de Privacidade",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "1. Coleta e Proteção de Dados: Todos os dados coletados através das bibliotecas WGC " +
                    "são protegidos conforme as diretrizes da LGPD/GDPR e criptografados em trânsito e em repouso.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "2. Autenticação Segura: O acesso via biometria utiliza as APIs nativas do Android " +
                    "BiometricPrompt com armazenamento de credenciais no Android Keystore.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "3. Propriedade Intelectual: Os componentes visuais e padrões de design são protegidos " +
                    "pela licença Apache 2.0 corporativa da WGC.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * Host independente do fluxo de configurações para uso direto em qualquer tela.
 */
@Composable
fun WgcSettingsNavHost(
    modifier: Modifier = Modifier,
    onLogoutConfirmed: () -> Unit = {},
    onClose: () -> Unit = {}
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WgcSettingsGraphRoute,
        modifier = modifier
    ) {
        wgcSettingsNavGraph(
            navController = navController,
            onLogoutConfirmed = onLogoutConfirmed,
            onBackClick = onClose
        )
    }
}

@Preview(showBackground = true)
@WgcDevicePreviews
@Composable
private fun WgcSettingsNavHostPreview() {
    MaterialTheme {
        WgcSettingsNavHost()
    }
}
