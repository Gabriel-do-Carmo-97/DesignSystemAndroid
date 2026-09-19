package br.com.wgc.design_system_wgc.showcase

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.WavingHand
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.buttons.WgcSecondaryClassicButton
import br.com.wgc.ds_navigation_flows.auth.WgcAuthGraphRoute
import br.com.wgc.ds_navigation_flows.auth.wgcAuthNavGraph
import br.com.wgc.ds_navigation_flows.checkout.WgcCheckoutGraphRoute
import br.com.wgc.ds_navigation_flows.checkout.wgcCheckoutNavGraph
import br.com.wgc.ds_navigation_flows.onboarding.WgcOnboardingGraphRoute
import br.com.wgc.ds_navigation_flows.onboarding.wgcOnboardingNavGraph

/**
 * Showcase interativo do módulo :navigation-flows.
 * Permite simular e testar os 3 grafos de navegação orquestrados e desacoplados.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationFlowsShowcase(
    onBack: () -> Unit
) {
    var activeFlow by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Módulo :navigation-flows", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(
                            text = if (activeFlow == null) "Grafos Desacoplados Type-Safe" else "Simulando: $activeFlow",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        if (activeFlow != null) {
                            activeFlow = null
                        } else {
                            onBack()
                        }
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (activeFlow) {
                "AUTH" -> AuthFlowSimulator(onFinish = { activeFlow = null })
                "CHECKOUT" -> CheckoutFlowSimulator(onFinish = { activeFlow = null })
                "ONBOARDING" -> OnboardingFlowSimulator(onFinish = { activeFlow = null })
                else -> FlowSelectorMenu(onSelectFlow = { activeFlow = it })
            }
        }
    }
}

@Composable
private fun FlowSelectorMenu(
    onSelectFlow: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        Text(
            text = "Selecione um Grafo de Navegação para Testar:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        FlowCard(
            title = "1. Fluxo de Autenticação (Auth Flow)",
            description = "Login ➔ Cadastro ➔ Esqueci a Senha ➔ Verificação OTP com State Hoisting e rotas type-safe.",
            icon = Icons.Default.Lock,
            onClick = { onSelectFlow("AUTH") }
        )

        FlowCard(
            title = "2. Fluxo de Checkout (Checkout Flow)",
            description = "Revisão do Carrinho ➔ Endereço de Entrega ➔ Seleção de Pagamento ➔ Confirmação do Pedido.",
            icon = Icons.Default.ShoppingBag,
            onClick = { onSelectFlow("CHECKOUT") }
        )

        FlowCard(
            title = "3. Fluxo de Onboarding (Onboarding Flow)",
            description = "Telas de Boas-Vindas carrossel ➔ Permissões essenciais ➔ Início da jornada.",
            icon = Icons.Default.WavingHand,
            onClick = { onSelectFlow("ONBOARDING") }
        )
    }
}

@Composable
private fun FlowCard(
    title: String,
    description: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(28.dp)
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(WgcCoreDsSpacing.xxs4.dp))
            WgcClassicButton(
                textButton = "Iniciar Simulação do Fluxo",
                onClick = onClick
            )
        }
    }
}

@Composable
private fun AuthFlowSimulator(onFinish: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WgcAuthGraphRoute
    ) {
        wgcAuthNavGraph(
            navController = navController,
            onAuthSuccess = onFinish
        )
    }
}

@Composable
private fun CheckoutFlowSimulator(onFinish: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WgcCheckoutGraphRoute
    ) {
        wgcCheckoutNavGraph(
            navController = navController,
            onCheckoutCompleted = { onFinish() },
            onCloseCheckout = onFinish
        )
    }
}

@Composable
private fun OnboardingFlowSimulator(onFinish: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WgcOnboardingGraphRoute
    ) {
        wgcOnboardingNavGraph(
            navController = navController,
            onOnboardingFinished = onFinish
        )
    }
}
