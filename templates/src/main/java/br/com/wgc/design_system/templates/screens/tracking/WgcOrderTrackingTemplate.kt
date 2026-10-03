package br.com.wgc.design_system.templates.screens.tracking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

data class WgcOrderTrackingUiState(
    val orderId: String = "#WGC-89421",
    val estimatedDeliveryTime: String = "14:30 - 15:00",
    val courierName: String = "Rodrigo Santos",
    val courierVehicle: String = "Honda CG 160 • Placa ABC-1234",
    val currentStatus: String = "A caminho do seu endereço"
)

/**
 * Template completo de rastreamento de entregas com slot de mapa e card do entregador.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcOrderTrackingTemplate(
    uiState: WgcOrderTrackingUiState = WgcOrderTrackingUiState(),
    onBack: () -> Unit = {},
    onCallCourier: () -> Unit = {},
    mapSlot: @Composable () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Rastreio ${uiState.orderId}", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Slot do Mapa interativo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                mapSlot()
            }

            // Card com informações do entregador e status
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.md16.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)
                ) {
                    Text(
                        text = uiState.currentStatus,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Previsão de entrega: ${uiState.estimatedDeliveryTime}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.sm8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                modifier = Modifier.size(44.dp),
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                                }
                            }
                            Column {
                                Text(
                                    text = uiState.courierName,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = uiState.courierVehicle,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }
                        }

                        IconButton(onClick = onCallCourier) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Ligar para o entregador",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }
}
