package br.com.wgc.ds_templates.screens.automotive

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcAutomotiveHomeTemplate(
    vehicles: List<VehicleItem> = AutomotiveMockData.sampleVehicles,
    onVehicleClick: (VehicleItem) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.automotiveRed))
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = "🚘 Encontre seu Próximo Carro", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(text = "Mais de 300 mil ofertas com Laudo Cautelar Aprovado", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp)
                }
            }
        }

        items(vehicles) { car ->
            Card(
                modifier = Modifier.fillMaxWidth().clickable { onVehicleClick(car) },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = car.makeModel, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Text(text = car.version, fontSize = 12.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "R$ " + String.format("%.2f", car.price), fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(WgcCoreDsColors.automotiveRed))
                        Text(text = "FIPE: R$ " + String.format("%.2f", car.fipePrice), fontSize = 12.sp, color = Color(WgcCoreDsColors.cdtGreen), fontWeight = FontWeight.SemiBold)
                    }
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "${car.yearModel} • ${car.mileageKm} km • ${car.cityState}", fontSize = 12.sp, color = Color.DarkGray)
                    if (car.certifiedReportApproved) {
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                        Text(text = "🛡️ Laudo Cautelar 100% Aprovado", fontSize = 11.sp, color = Color(WgcCoreDsColors.cdtGreen), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcAutomotiveDetailTemplate(
    car: VehicleItem = AutomotiveMockData.sampleVehicles.first(),
    onSimulateFinancing: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Ficha Técnica & Tour 360°", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                Text(text = car.makeModel, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = car.version, fontSize = 13.sp, color = Color.Gray)
                Text(text = "Ano: ${car.yearModel} | Km: ${car.mileageKm}", fontSize = 14.sp)
                Text(text = "Preço Anunciado: R$ " + String.format("%.2f", car.price), fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(WgcCoreDsColors.automotiveRed))
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
                WgcClassicButton(
                    textButton = "Simular Financiamento",
                    onClick = onSimulateFinancing,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun WgcAutomotiveFipeTemplate(
    car: VehicleItem = AutomotiveMockData.sampleVehicles.first()
) {
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Tabela FIPE Oficial", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                Text(text = "Veículo: ${car.makeModel}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "Valor Oficial FIPE: R$ " + String.format("%.2f", car.fipePrice), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(WgcCoreDsColors.cdtGreen))
                Text(text = "Variação últimos 12 meses: -3.8% (Desvalorização normal)", fontSize = 13.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun WgcAutomotiveFinancingTemplate(
    carPrice: Double = 189900.00
) {
    var downPayment by remember { mutableStateOf(50000.00) }
    val financedAmount = carPrice - downPayment
    val monthlyPayment = (financedAmount * 1.45) / 48

    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Simulador de Financiamento", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                Text(text = "Valor Total: R$ " + String.format("%.2f", carPrice), fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "Entrada: R$ " + String.format("%.2f", downPayment), fontSize = 14.sp)
                Text(text = "Saldo em: 48x de R$ " + String.format("%.2f", monthlyPayment), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(WgcCoreDsColors.automotiveRed))
                Text(text = "Taxa média: 1.39% a.m. (Sujeito a aprovação de crédito)", fontSize = 11.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun WgcAutomotiveProfileTemplate() {
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Garagem & Meus Anúncios", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                Text(text = "Usuário: Gabriel do Carmo", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = "Anúncios Ativos: 1 veículo", fontSize = 14.sp)
                Text(text = "Propostas Recebidas: 4 novas mensagens", fontSize = 14.sp, color = Color(WgcCoreDsColors.automotiveRed), fontWeight = FontWeight.SemiBold)
            }
        }
    }
}
