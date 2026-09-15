package br.com.wgc.ds_templates.screens.zedelivery

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.SportsBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun WgcZeDeliveryHomeTemplate(
    beverages: List<BeverageItem> = ZeDeliveryMockData.sampleBeverages,
    distributor: DeliveryPartnerDistributor = ZeDeliveryMockData.sampleDistributor,
    onAddToCart: (BeverageItem) -> Unit = {}
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
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.zeDeliveryYellow))
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.Black)
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Text(text = "Entregar em: Av. Paulista, 1000", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "🍺 Bebidas geladas a preço de supermercado", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Chega em ~${distributor.estimatedMinutes} min • Distribuidor a ${distributor.distanceKm} km", fontSize = 13.sp)
                }
            }
        }

        item {
            Text(text = "Cervejas Mais Pedidas", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }

        items(beverages) { bev ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = bev.name, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        Text(text = "${bev.volume} • ${bev.temperatureStatus}", fontSize = 12.sp, color = Color(WgcCoreDsColors.decolarBlue))
                        if (bev.returnableBottle) {
                            Text(text = "♻️ Garrafa retornável (traga o casco)", fontSize = 11.sp, color = Color(WgcCoreDsColors.cdtGreen), fontWeight = FontWeight.SemiBold)
                        }
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                        Text(text = "R$ " + String.format("%.2f", bev.price), fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    WgcClassicButton(
                        textButton = "Adicionar",
                        onClick = { onAddToCart(bev) }
                    )
                }
            }
        }
    }
}

@Composable
fun WgcZeDeliveryColdTrackerTemplate(
    distributor: DeliveryPartnerDistributor = ZeDeliveryMockData.sampleDistributor
) {
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Rastreio Imediato da Entrega", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.DeliveryDining, contentDescription = null, tint = Color(WgcCoreDsColors.zeDeliveryRed), modifier = Modifier.size(WgcCoreDsSize.s40.dp))
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Column {
                        Text(text = "O motoboy está a caminho!", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text(text = "Previsão de chegada: ${distributor.estimatedMinutes} minutos", fontSize = 13.sp, color = Color.Gray)
                    }
                }
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                Text(text = "Parceiro: ${distributor.name}", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Text(text = "Distância atual: ${distributor.distanceKm} km", fontSize = 13.sp, color = Color.DarkGray)
            }
        }
    }
}

@Composable
fun WgcZeDeliveryOffersTemplate(
    beverages: List<BeverageItem> = ZeDeliveryMockData.sampleBeverages
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        item {
            Text(text = "Combos & Ofertas da Geladeira", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
        items(beverages) { bev ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = "COMBO FINAL DE SEMANA", color = Color(WgcCoreDsColors.zeDeliveryRed), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text(text = bev.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Por apenas R$ " + String.format("%.2f", bev.price), fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
            }
        }
    }
}

@Composable
fun WgcZeDeliveryCartTemplate(
    items: List<BeverageItem> = ZeDeliveryMockData.sampleBeverages.take(2),
    onCheckout: () -> Unit = {}
) {
    val total = items.sumOf { it.price }
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Sacola Express", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        items.forEach { item ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(bottom = WgcCoreDsSpacing.xs8.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item.name, fontWeight = FontWeight.Medium, fontSize = 14.sp)
                    Text(text = "R$ " + String.format("%.2f", item.price), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Total: R$ " + String.format("%.2f", total), fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
        WgcClassicButton(
            textButton = "Confirmar Pedido Gelado",
            onClick = onCheckout,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun WgcZeDeliveryProfileTemplate() {
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Minha Conta Zé Delivery", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                Text(text = "Nome: Gabriel do Carmo", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = "Endereço Padrão: Av. Paulista, 1000", fontSize = 14.sp)
                Text(text = "Cupons da Geladeira: 3 ativos", fontSize = 14.sp, color = Color(WgcCoreDsColors.cdtGreen), fontWeight = FontWeight.SemiBold)
            }
        }
    }
}
