package br.com.wgc.design_system.templates.screens.retail.tracking

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.components.tracking.WgcRetailOrderTrackingStepper
import br.com.wgc.design_system.components.tracking.WgcKutukuStepStatus
import br.com.wgc.design_system.components.tracking.WgcKutukuTrackingStepItem
import br.com.wgc.design_system.templates.screens.retail.model.RetailMockData

/**
 * Tela de Rastreamento de Pedido oficial do Kutuku (WgcKutukuOrderTrackingScreen).
 */
@Composable
fun WgcKutukuOrderTrackingScreen(
    modifier: Modifier = Modifier,
    courierName: String = "Alexander Jr",
    courierRole: String = "Courier",
    courierAvatarUrl: String? = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=200",
    onBackClick: () -> Unit = {},
    onChatClick: () -> Unit = {},
    onCallClick: () -> Unit = {},
    onMarkAsDoneClick: () -> Unit = {}
) {
    val steps = listOf(
        WgcKutukuTrackingStepItem(
            title = "Upbox Bag",
            subtitle = "Shop",
            time = "02:50 PM",
            status = WgcKutukuStepStatus.COMPLETED
        ),
        WgcKutukuTrackingStepItem(
            title = "On the way",
            subtitle = "Delivery",
            time = "03:20 PM",
            status = WgcKutukuStepStatus.IN_PROGRESS
        ),
        WgcKutukuTrackingStepItem(
            title = "5482 Adobe Falls Rd #15San Diego,...",
            subtitle = "Houser",
            time = "03:45 PM",
            status = WgcKutukuStepStatus.PENDING
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(WgcCoreDsColors.retailBackground))
    ) {
        // Área Superior com Mapa Simulado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(Color(WgcCoreDsColors.premiumGroceryGreenLight)),
            contentAlignment = Alignment.Center
        ) {
            // Linhas de rua decorativas
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(14.dp)
                        .background(Color.White)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                        .background(Color.White)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(12.dp)
                        .background(Color.White)
                )
            }

            // Marcador de Rota
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.retailPrimary)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.LocalShipping,
                    contentDescription = "Veículo",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            // Top Bar Flutuante
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.retailDark)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Order Tracking",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.retailDark)
                )
                Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.size(48.dp))
            }
        }

        // Bottom Sheet de Informações
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(
                topStart = WgcCoreDsBorderRadius.xxl.dp,
                topEnd = WgcCoreDsBorderRadius.xxl.dp
            ),
            color = Color(WgcCoreDsColors.retailSurface),
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = WgcCoreDsSpacing.lg.dp, vertical = WgcCoreDsSpacing.md.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Drag Handle
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(4.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                        .background(Color(WgcCoreDsColors.retailBorder))
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

                // Card do Entregador
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp))
                        .border(
                            width = 1.dp,
                            color = Color(WgcCoreDsColors.retailBorder),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp)
                        )
                        .padding(WgcCoreDsSpacing.md.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md.dp))
                                .background(Color(WgcCoreDsColors.retailPrimaryLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            if (!courierAvatarUrl.isNullOrEmpty()) {
                                AsyncImageDefault(
                                    image = courierAvatarUrl,
                                    contentDescription = courierName,
                                    modifier = Modifier.fillMaxSize()
                                )
                            } else {
                                Text(
                                    text = courierName.take(1),
                                    fontWeight = FontWeight.Bold,
                                    color = Color(WgcCoreDsColors.retailPrimary)
                                )
                            }
                        }

                        Column {
                            Text(
                                text = courierName,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.retailDark)
                            )
                            Text(
                                text = courierRole,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.retailSecondaryText)
                            )
                        }
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)) {
                        IconButton(
                            onClick = onChatClick,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.retailBackground))
                        ) {
                            Icon(
                                imageVector = Icons.Default.Language,
                                contentDescription = "Chat",
                                tint = Color(WgcCoreDsColors.retailDark)
                            )
                        }

                        IconButton(
                            onClick = onCallClick,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.retailBackground))
                        ) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Ligar",
                                tint = Color(WgcCoreDsColors.retailDark)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

                // Progresso do Pedido
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Progress of your Order",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailDark)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

                WgcRetailOrderTrackingStepper(steps = steps)

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

                // Botão "Mark as Done"
                OutlinedButton(
                    onClick = onMarkAsDoneClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp),
                    border = BorderStroke(1.5.dp, Color(WgcCoreDsColors.retailPrimary))
                ) {
                    Text(
                        text = "Mark as Done",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.retailPrimary)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuOrderTrackingScreenPreview() {
    WgcKutukuOrderTrackingScreen()
}
