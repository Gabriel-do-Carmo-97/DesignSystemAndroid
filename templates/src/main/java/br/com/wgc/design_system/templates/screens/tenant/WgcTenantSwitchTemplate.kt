package br.com.wgc.design_system.templates.screens.tenant

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcTenantItem(
    val id: String,
    val name: String,
    val plan: String,
    val isCurrent: Boolean = false
)

data class WgcTenantSwitchUiState(
    val title: String = "Alternar Organização",
    val subtitle: String = "Selecione o espaço de trabalho corporativo ativo.",
    val tenants: List<WgcTenantItem> = listOf(
        WgcTenantItem("1", "WGC Holding Corp", "Enterprise", isCurrent = true),
        WgcTenantItem("2", "WGC Fintech & Banking", "Business"),
        WgcTenantItem("3", "WGC Retail & Labs", "Startup")
    )
)

/**
 * Template de alternância de organização multi-tenant corporativa.
 */
@Composable
fun WgcTenantSwitchTemplate(
    uiState: WgcTenantSwitchUiState = WgcTenantSwitchUiState(),
    onSelectTenant: (WgcTenantItem) -> Unit = {},
    onAddNewTenant: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.lg24.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        Column {
            Text(
                text = uiState.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = uiState.subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)) {
            items(uiState.tenants) { tenant ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelectTenant(tenant) },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (tenant.isCurrent) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                modifier = Modifier.size(40.dp),
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primary
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.Business,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                            }

                            Column {
                                Text(
                                    text = tenant.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    text = "Plano ${tenant.plan}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }
                        }

                        if (tenant.isCurrent) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Organização ativa",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }

        OutlinedButton(
            onClick = onAddNewTenant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = "Conectar Nova Organização",
                modifier = Modifier.padding(start = WgcCoreDsSpacing.xs6.dp)
            )
        }
    }
}
