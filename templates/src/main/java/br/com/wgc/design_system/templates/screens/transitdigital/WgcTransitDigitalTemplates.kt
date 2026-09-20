package br.com.wgc.design_system.templates.screens.transitdigital

import br.com.wgc.design_system.templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

@Composable
fun WgcCdtCnhTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.transitDigitalGreen)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Carteira Digital de Trânsito • CDT", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                    Text("CNH DIGITAL COM QR CODE", fontWeight = FontWeight.Bold, color = Color(WgcCoreDsColors.transitDigitalGreen))
                    Text("Gabriel do Carmo", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("Categoria: AB • Validade: 14/09/2034", color = Color.DarkGray)
                    Text("Documento Oficial Válido em Todo Território Nacional", color = Color.Gray, fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
fun WgcCdtCrlvTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "CRLV Digital (Documento do Veículo)", modifier = modifier)

@Composable
fun WgcCdtInfractionsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Infrações & 40% de Desconto no SNE", modifier = modifier)

@Composable
fun WgcCdtPointsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Histórico de Pontuação • 0 Pontos (Sem Multas)", modifier = modifier)

@Composable
fun WgcCdtProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil do Condutor CDT", modifier = modifier)
