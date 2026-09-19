@file:Suppress("MatchingDeclarationName")
package br.com.wgc.design_system_wgc.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

/**
 * Identificação dos 4 Módulos Oficiais do Design System.
 */
enum class DsModule(
    val title: String,
    val moduleBadge: String,
    val icon: String,
    val summary: String,
    val bulletPoints: List<String>,
    val containerColor: Color
) {
    CORE(
        title = "Design Tokens",
        moduleBadge = ":core",
        icon = "🎨",
        summary = "Single Source of Truth para Cores primitivas e semânticas, Tipografia, Espaçamentos, Raios e Elevações.",
        bulletPoints = listOf(
            "Paleta Semântica WgcCoreDsColors",
            "Escala de Espaçamentos WgcCoreDsSpacing",
            "Raios de Borda WgcCoreDsBorderRadius",
            "Níveis de Sombra WgcCoreDsElevation"
        ),
        containerColor = Color(0xFFFFF3E0)
    ),
    COMPONENTS(
        title = "Componentes de UI",
        moduleBadge = ":components",
        icon = "🧩",
        summary = "Biblioteca corporativa de Átomos, Moléculas e Organismos reutilizáveis com State Hoisting obrigatório.",
        bulletPoints = listOf(
            "Botões Clássicos, Ícones & Segmentados",
            "Fábricas de Cards (WgcCardFactory)",
            "Campos de Texto, Busca e OTP",
            "Switches, Chips, Alerts e Navigation Bars"
        ),
        containerColor = Color(0xFFE8F5E9)
    ),
    TEMPLATES(
        title = "Templates & Telas",
        moduleBadge = ":templates",
        icon = "📱",
        summary = "Showcase de Telas Completas e Desacopladas, nova WgcProfileFactory (22 variantes), Homes e Autenticação.",
        bulletPoints = listOf(
            "Nova WgcProfileFactory (22 Perfis 1 a 1)",
            "WgcHomeFactory & WgcAuthFactory",
            "78 Verticais Especializadas Preservadas",
            "Slots Customizáveis & Defaults Sensatos"
        ),
        containerColor = Color(0xFFE3F2FD)
    ),
    NAVIGATION_FLOWS(
        title = "Fluxos de Navegação",
        moduleBadge = ":navigation-flows",
        icon = "🗺️",
        summary = "Orquestração completa de fluxos desacoplados com type-safety e slots de tela integrados.",
        bulletPoints = listOf(
            "Grafo de Autenticação (wgcAuthNavGraph)",
            "Grafo de Checkout (wgcCheckoutNavGraph)",
            "Grafo de Onboarding (wgcOnboardingNavGraph)",
            "Rotas Type-Safe com Kotlin Serialization"
        ),
        containerColor = Color(0xFFF3E5F5)
    )
}

/**
 * Tela Hub de Entrada do Showcase do Design System.
 * Apresenta 4 botões interativos principais para explorar cada módulo de forma independente.
 */
@Composable
fun DsModuleHubScreen(
    onSelectModule: (DsModule) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        // Header de Boas-Vindas
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(
                modifier = Modifier.padding(WgcCoreDsSpacing.lg24.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = "Design System Android",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Showcase Hub • Escolha o módulo que deseja explorar:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                )
            }
        }

        Text(
            text = "Módulos Oficiais da Arquitetura:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        // 4 Botões Principais em Cartões de Destaque
        DsModule.entries.forEach { module ->
            ModuleHubCard(
                module = module,
                onClick = { onSelectModule(module) }
            )
        }

        Spacer(Modifier.height(WgcCoreDsSpacing.lg24.dp))
    }
}

@Suppress("LongMethod")
@Composable
private fun ModuleHubCard(
    module: DsModule,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Text(text = module.icon, fontSize = 28.sp)
                    Column {
                        Text(
                            text = module.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Surface(
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = module.moduleBadge,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Abrir módulo",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = module.summary,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                module.bulletPoints.forEach { point ->
                    Text(
                        text = "• $point",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            WgcClassicButton(
                textButton = "Explorar Módulo ${module.moduleBadge}",
                onClick = onClick
            )
        }
    }
}
