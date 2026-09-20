package br.com.wgc.design_system.templates.screens.apparel.tracking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.automirrored.filled.ReceiptLong
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import br.com.wgc.design_system.components.tracking.WgcApparelOrderTimeline
import br.com.wgc.design_system.components.tracking.WgcClotheeTimelineStep
import br.com.wgc.design_system.templates.screens.apparel.model.ClotheeAddress
import br.com.wgc.design_system.templates.screens.apparel.model.ApparelMockData

/**
 * Tela de rastreamento do pedido do Clothee (WgcClotheeTrackOrderTemplate).
 * Apresenta número do pedido, linha do tempo dos estágios da entrega,
 * card de itens do pedido e endereço de entrega.
 */
@Composable
fun WgcClotheeTrackOrderTemplate(
    modifier: Modifier = Modifier,
    orderNumber: String = "#456765",
    timelineSteps: List<WgcClotheeTimelineStep> = ApparelMockData.trackingSteps,
    itemCount: Int = 3,
    shippingAddress: ClotheeAddress = ApparelMockData.defaultAddress,
    onBackClick: () -> Unit = {},
    onViewItemsClick: () -> Unit = {},
    customHeaderSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            if (customHeaderSlot != null) {
                customHeaderSlot()
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.apparelSurface))
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(WgcCoreDsColors.apparelDark)
                        )
                    }

                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                    Text(
                        text = "Order $orderNumber",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.apparelDark)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Timeline vertical de rastreamento
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                WgcApparelOrderTimeline(steps = timelineSteps)
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            // Card de itens do pedido
            Text(
                text = "Order Items",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.apparelDark),
                modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.apparelSurface))
                    .clickable(onClick = onViewItemsClick)
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.apparelPrimaryLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ReceiptLong,
                        contentDescription = "Itens",
                        tint = Color(WgcCoreDsColors.apparelPrimary),
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                Text(
                    text = "$itemCount items in package",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.apparelDark),
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "View All",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.apparelPrimary)
                )

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))

                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "Ver itens",
                    tint = Color(WgcCoreDsColors.apparelPrimary)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Card de detalhes de envio
            Text(
                text = "Shipping Details",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.apparelDark),
                modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.apparelSurface))
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocalShipping,
                        contentDescription = "Entrega",
                        tint = Color(WgcCoreDsColors.apparelDark),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Standard Delivery",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.apparelDark)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = shippingAddress.street,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.apparelSecondaryText)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                Text(
                    text = shippingAddress.phoneNumber,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.apparelSecondaryText)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeTrackOrderTemplatePreview() {
    WgcClotheeTrackOrderTemplate()
}
