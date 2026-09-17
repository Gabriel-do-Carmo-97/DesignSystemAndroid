package br.com.wgc.ds_templates.screens.expresslogistics

import br.com.wgc.ds_templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

@Composable
fun WgcLoggiTrackTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.expressLogisticsBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Logística Express • Rastreamento Inteligente", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(ExpressLogisticsMockData.samplePackages) { pkg ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(pkg.trackingCode, fontWeight = FontWeight.Bold, color = Color(WgcCoreDsColors.expressLogisticsBlue))
                        Text(pkg.status, fontWeight = FontWeight.SemiBold)
                        Text("${pkg.destination} • Previsão: ${pkg.eta}", color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcLoggiSendTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Solicitar Envio de Pacote", modifier = modifier)

@Composable
fun WgcLoggiDeliveriesTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Minhas Entregas em Andamento", modifier = modifier)

@Composable
fun WgcLoggiHistoryTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Histórico Completo de Envios", modifier = modifier)

@Composable
fun WgcLoggiProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil de Remetente / Empresa", modifier = modifier)
