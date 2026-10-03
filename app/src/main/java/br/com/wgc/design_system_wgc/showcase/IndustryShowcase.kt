@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system_wgc.showcase

import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Representação de uma indústria suportada pelo ecossistema WGC.
 */
data class WgcIndustryDemo(
    val id: String,
    val title: String,
    val description: String,
    val icon: ImageVector,
    val onSelect: () -> Unit = {}
)

/**
 * Showcase de verticais de negócio / indústrias no app de catálogo.
 */
@Composable
fun IndustryShowcase(
    modifier: Modifier = Modifier,
    onNavigateToIndustry: (String) -> Unit = {}
) {
    val industries = listOf(
        WgcIndustryDemo(
            id = "fintech",
            title = "Banco Digital & Fintech",
            description = "Extrato com saldo mascarado, Pix Copia e Cola, cartões virtuais e limites.",
            icon = Icons.Default.AccountBalance
        ),
        WgcIndustryDemo(
            id = "food",
            title = "Food Delivery & Restaurantes",
            description = "Cardápios em abas, personalização de itens, rastreamento de entregas e cupom.",
            icon = Icons.Default.Fastfood
        ),
        WgcIndustryDemo(
            id = "retail",
            title = "Varejo & E-commerce",
            description = "Catálogos com carrossel de produtos, filtros rápidos, sacola e checkout express.",
            icon = Icons.Default.ShoppingBag
        ),
        WgcIndustryDemo(
            id = "mobility",
            title = "Mobilidade Urbana",
            description = "Seleção de categorias de corrida, estimativa de tarifa e status do motorista.",
            icon = Icons.Default.DirectionsCar
        )
    )

    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            item {
                Text(
                    text = "Ecossistema por Indústria",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Explore telas completas montadas com a arquitetura de tokens e componentes da WGC.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = WgcCoreDsSpacing.xxs.dp, bottom = WgcCoreDsSpacing.sm.dp)
                )
            }

            items(industries, key = { it.id }) { industry ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNavigateToIndustry(industry.id) },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = industry.icon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Column {
                                Text(
                                    text = industry.title,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = industry.description,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
