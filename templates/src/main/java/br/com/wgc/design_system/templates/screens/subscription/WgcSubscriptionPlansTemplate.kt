@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.screens.subscription

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.segmented.WgcSegmentedControl
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcPlan(
    val id: String,
    val name: String,
    val price: String,
    val period: String,
    val isPopular: Boolean = false,
    val features: List<String>
)

data class WgcSubscriptionPlansUiState(
    val title: String = "Escolha o melhor plano",
    val subtitle: String = "Desbloqueie todos os recursos corporativos sem limites.",
    val isAnnual: Boolean = true,
    val plans: List<WgcPlan> = listOf(
        WgcPlan(
            id = "starter",
            name = "Starter",
            price = "R$ 49",
            period = "/mês",
            features = listOf("Até 3 projetos", "Exportação básica de tokens", "Suporte da comunidade")
        ),
        WgcPlan(
            id = "pro",
            name = "Professional",
            price = "R$ 119",
            period = "/mês",
            isPopular = true,
            features = listOf("Projetos ilimitados", "Exportação para iOS/Web/Flutter", "Suporte prioritário 24/7", "Roborazzi Matrix CI")
        )
    )
)

/**
 * Template completo de Planos e Assinaturas (SaaS/Billing).
 */
@Suppress("LongMethod")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcSubscriptionPlansTemplate(
    uiState: WgcSubscriptionPlansUiState = WgcSubscriptionPlansUiState(),
    onBack: () -> Unit = {},
    onTogglePeriod: (Int) -> Unit = {},
    onSelectPlan: (WgcPlan) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Planos e Assinaturas", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = WgcCoreDsSpacing.md16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)
                ) {
                    Text(
                        text = uiState.title,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = uiState.subtitle,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )

                    WgcSegmentedControl(
                        items = listOf("Mensal", "Anual (-20%)"),
                        selectedIndex = if (uiState.isAnnual) 1 else 0,
                        onItemSelected = onTogglePeriod,
                        modifier = Modifier.padding(top = WgcCoreDsSpacing.md16.dp)
                    )
                }
            }

            items(uiState.plans) { plan ->
                val borderColor = if (plan.isPopular) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = if (plan.isPopular) 2.dp else 1.dp,
                            color = borderColor,
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp)
                        ),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.lg24.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Text(
                            text = plan.name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = plan.price,
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = plan.period,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(bottom = WgcCoreDsSpacing.xxs4.dp)
                            )
                        }

                        Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)) {
                            plan.features.forEach { feature ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                    Text(text = feature, style = MaterialTheme.typography.bodyMedium)
                                }
                            }
                        }

                        WgcClassicButton(
                            text = "Selecionar ${plan.name}",
                            onClick = { onSelectPlan(plan) },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
