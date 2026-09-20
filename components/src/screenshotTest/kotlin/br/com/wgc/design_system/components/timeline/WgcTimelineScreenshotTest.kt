package br.com.wgc.design_system.components.timeline

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.tools.screenshot.PreviewTest

class WgcTimelineScreenshotTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Order Tracking Timeline")
    @Composable
    private fun OrderTrackingTimelinePreview() {
        Column(modifier = Modifier.padding(16.dp)) {
            WgcTimeline(
                items = listOf(
                    WgcTimelineItem(
                        title = "Pedido Confirmado",
                        description = "Pagamento aprovado via PIX.",
                        timestamp = "14:20",
                        status = WgcTimelineStatus.COMPLETED
                    ),
                    WgcTimelineItem(
                        title = "Em Preparação",
                        description = "O restaurante está montando seu pedido.",
                        timestamp = "14:35",
                        status = WgcTimelineStatus.CURRENT
                    ),
                    WgcTimelineItem(
                        title = "Saiu para Entrega",
                        description = "Entregador a caminho do endereço.",
                        timestamp = "14:50",
                        status = WgcTimelineStatus.PENDING
                    )
                )
            )
        }
    }
}
