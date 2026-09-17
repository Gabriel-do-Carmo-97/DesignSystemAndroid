package br.com.wgc.ds_templates.screens.curatedmarket.tracking

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Mail
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
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcCuratedOrderTrackerCard
import br.com.wgc.ds_templates.screens.curatedmarket.model.CuratedMarketMockData
import br.com.wgc.ds_templates.screens.curatedmarket.model.TasselOrder

/**
 * Tela de rastreamento de pedidos oficial do Tassel (WgcTasselOrderTrackingTemplate).
 * Apresenta Top Bar minimalista com botão de fechar, card principal com timeline de entrega,
 * resumo do produto e histórico de status das atualizações.
 */
@Composable
fun WgcTasselOrderTrackingTemplate(
    modifier: Modifier = Modifier,
    order: TasselOrder = CuratedMarketMockData.currentOrder,
    onCloseClick: () -> Unit = {},
    onMoreInfoClick: () -> Unit = {},
    onCancelOrderClick: () -> Unit = {},
    customTrackerSlot: (@Composable () -> Unit)? = null,
    customHistorySlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Top Bar com fechar e ícone da marca
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = WgcCoreDsSpacing.md16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onCloseClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s40.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.curatedMarketSurface))
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Fechar",
                        tint = Color(WgcCoreDsColors.curatedMarketDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s40.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.curatedMarketSurface)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Mail,
                        contentDescription = "Tassel",
                        tint = Color(WgcCoreDsColors.curatedMarketDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                // Balanceador
                Spacer(modifier = Modifier.size(WgcCoreDsSize.s40.dp))
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Card Principal de Rastreamento
            if (customTrackerSlot != null) {
                customTrackerSlot()
            } else {
                WgcCuratedOrderTrackerCard(
                    statusText = order.statusText,
                    arrivalEstimate = order.arrivalEstimate,
                    currentStep = order.currentStep,
                    totalSteps = order.totalSteps,
                    productTitle = order.product.title,
                    productDetails = order.selectedDetails,
                    productImageUrl = order.product.imageUrl,
                    onMoreInfoClick = onMoreInfoClick,
                    onCancelOrderClick = onCancelOrderClick
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            // Histórico de Rastreamento Detalhado
            if (customHistorySlot != null) {
                customHistorySlot()
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    Text(
                        text = "Tracking details",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.curatedMarketDark)
                    )

                    val events = listOf(
                        "Package sorted in distribution center" to "Today, 10:45 AM",
                        "Dispatched from regional warehouse" to "Yesterday, 06:12 PM",
                        "Order confirmed & packed" to "12 Apr, 02:30 PM"
                    )

                    events.forEach { (eventTitle, eventTime) ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = eventTitle,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(WgcCoreDsColors.curatedMarketDark)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                            Text(
                                text = eventTime,
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(WgcCoreDsColors.curatedMarketSecondaryText)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselOrderTrackingTemplatePreview() {
    WgcTasselOrderTrackingTemplate()
}
