package br.com.wgc.ds_navigation_flows.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.tabs.WgcHorizontalPagerIndicator
import kotlinx.serialization.Serializable

@Serializable
object WgcOnboardingGraphRoute

@Serializable
object WgcOnboardingWelcomeRoute

@Serializable
object WgcOnboardingPermissionsRoute

@Serializable
object WgcOnboardingProfileSetupRoute

/**
 * Grafo de navegação para fluxos de Onboarding e boas-vindas (WgcOnboardingNavGraph).
 *
 * @param navController Controlador de navegação do Compose.
 * @param onOnboardingFinished Callback disparado ao completar todas as etapas.
 */
fun NavGraphBuilder.wgcOnboardingNavGraph(
    navController: NavController,
    onOnboardingFinished: () -> Unit
) {
    navigation<WgcOnboardingGraphRoute>(startDestination = WgcOnboardingWelcomeRoute) {
        composable<WgcOnboardingWelcomeRoute> {
            WgcOnboardingWelcomeNavScreen(
                onNext = { navController.navigate(WgcOnboardingPermissionsRoute) },
                onSkip = onOnboardingFinished
            )
        }

        composable<WgcOnboardingPermissionsRoute> {
            WgcOnboardingPermissionsNavScreen(
                onNext = { navController.navigate(WgcOnboardingProfileSetupRoute) },
                onBack = { navController.popBackStack() }
            )
        }

        composable<WgcOnboardingProfileSetupRoute> {
            WgcOnboardingProfileSetupNavScreen(
                onComplete = onOnboardingFinished,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Composable
private fun WgcOnboardingWelcomeNavScreen(
    onNext: () -> Unit,
    onSkip: () -> Unit
) {
    Scaffold(
        bottomBar = {
            Surface(
                tonalElevation = WgcCoreDsSpacing.xs8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    WgcClassicButton(
                        textButton = "Começar Agora",
                        onClick = onNext,
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextButton(
                        onClick = onSkip,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Pular introdução", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(54.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Text(
                text = "Bem-vindo ao Ecossistema WGC",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Text(
                text = "Sua plataforma unificada com design consistente, segurança corporativa e alto desempenho.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            WgcHorizontalPagerIndicator(
                pageCount = 3,
                currentPage = 0
            )
        }
    }
}

@Composable
private fun WgcOnboardingPermissionsNavScreen(
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        bottomBar = {
            Surface(
                tonalElevation = WgcCoreDsSpacing.xs8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    TextButton(
                        onClick = onBack,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Voltar")
                    }
                    WgcClassicButton(
                        textButton = "Permitir e Continuar",
                        onClick = onNext,
                        modifier = Modifier.weight(2f)
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(54.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Text(
                text = "Fique por dentro de tudo",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Text(
                text = "Habilite as notificações para receber alertas de segurança instantâneos e comprovantes em tempo real.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            WgcHorizontalPagerIndicator(
                pageCount = 3,
                currentPage = 1
            )
        }
    }
}

@Composable
private fun WgcOnboardingProfileSetupNavScreen(
    onComplete: () -> Unit,
    onBack: () -> Unit
) {
    val selectedInterests = remember { mutableStateListOf("Finanças", "Tecnologia") }
    val availableCategories = listOf("Finanças", "Tecnologia", "E-commerce", "Educação", "Saúde", "Logística")

    Scaffold(
        bottomBar = {
            Surface(
                tonalElevation = WgcCoreDsSpacing.xs8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    TextButton(
                        onClick = onBack,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Voltar")
                    }
                    WgcClassicButton(
                        textButton = "Concluir e Acessar",
                        onClick = onComplete,
                        modifier = Modifier.weight(2f)
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(54.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Text(
                text = "Personalize sua Experiência",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Text(
                text = "Escolha as categorias de seu maior interesse:",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                availableCategories.chunked(3).forEach { rowCategories ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        rowCategories.forEach { cat ->
                            val isSelected = selectedInterests.contains(cat)
                            FilterChip(
                                selected = isSelected,
                                onClick = {
                                    if (isSelected) selectedInterests.remove(cat)
                                    else selectedInterests.add(cat)
                                },
                                label = { Text(cat) },
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sl18.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            WgcHorizontalPagerIndicator(
                pageCount = 3,
                currentPage = 2
            )
        }
    }
}
