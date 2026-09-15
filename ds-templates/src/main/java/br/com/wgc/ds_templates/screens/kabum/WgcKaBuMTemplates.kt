package br.com.wgc.ds_templates.screens.kabum

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcKaBuMHomeTemplate(
    hardware: List<HardwareItem> = KaBuMMockData.sampleHardware,
    onAddToCart: (HardwareItem) -> Unit = {}
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
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.kabumOrange))
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = "⚡ Live de Ofertas Ninja KaBuM!", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(text = "Preços imperdíveis no PIX com envio imediato", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp)
                }
            }
        }

        items(hardware) { item ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text(text = item.category, color = Color(WgcCoreDsColors.kabumOrange), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "De R$ " + String.format("%.2f", item.price), fontSize = 12.sp, color = Color.Gray)
                    Text(text = "Por R$ " + String.format("%.2f", item.ninjaDiscountPrice) + " no PIX", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(WgcCoreDsColors.kabumOrange))
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                    Text(text = "Socket: ${item.socket} • TDP: ${item.tdpWatts}W • Benchmark: ${item.benchmarkScore} pts", fontSize = 12.sp, color = Color.DarkGray)
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
                    WgcClassicButton(
                        textButton = "Comprar Ninja",
                        onClick = { onAddToCart(item) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun WgcKaBuMHardwareSpecsTemplate(
    hardware: List<HardwareItem> = KaBuMMockData.sampleHardware
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)),
        contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        item {
            Text(text = "Especificações Técnicas & Benchmarks", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
        items(hardware) { item ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                    Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Text(text = "• Consumo Elétrico (TDP): ${item.tdpWatts} Watts", fontSize = 13.sp)
                    Text(text = "• Encaixe / Socket: ${item.socket}", fontSize = 13.sp)
                    Text(text = "• Pontuação em Benchmark 3DMark: ${item.benchmarkScore} pontos", fontSize = 13.sp, color = Color(WgcCoreDsColors.kabumOrange), fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Composable
fun WgcKaBuMPcBuilderTemplate(
    selectedParts: List<HardwareItem> = KaBuMMockData.sampleHardware
) {
    val totalWatts = selectedParts.sumOf { it.tdpWatts } + 150 // +150W margem coolers e RAM
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Monte seu PC Ninja (Compatibilidade)", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                Text(text = "Fonte Recomendada: Mínimo ${totalWatts}W 80 Plus Gold", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color(WgcCoreDsColors.cdtGreen))
                Text(text = "Compatibilidade de Socket: 100% Compatível (AM5)", fontSize = 14.sp)
                Text(text = "Peças Selecionadas: ${selectedParts.size} componentes", fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun WgcKaBuMCartTemplate(
    items: List<HardwareItem> = KaBuMMockData.sampleHardware.take(2),
    onCheckout: () -> Unit = {}
) {
    val total = items.sumOf { it.ninjaDiscountPrice }
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Carrinho Ninja KaBuM!", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        items.forEach { item ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(bottom = WgcCoreDsSpacing.xs8.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = item.name.take(30) + "...", fontSize = 14.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
                    Text(text = "R$ " + String.format("%.2f", item.ninjaDiscountPrice), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Total no PIX: R$ " + String.format("%.2f", total), fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(WgcCoreDsColors.kabumOrange))
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
        WgcClassicButton(
            textButton = "Finalizar Pedido Ninja",
            onClick = onCheckout,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun WgcKaBuMProfileTemplate() {
    Column(modifier = Modifier.fillMaxSize().background(Color(WgcCoreDsColors.grey50)).padding(WgcCoreDsSpacing.md16.dp)) {
        Text(text = "Minha Conta Ninja & Protocolos RMA", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                Text(text = "Cliente: Gabriel do Carmo", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = "Nível Ninja: Black Prime (Frete Grátis)", fontSize = 14.sp, color = Color(WgcCoreDsColors.kabumOrange), fontWeight = FontWeight.Bold)
                Text(text = "Protocolos de Garantia / RMA: 0 pendentes", fontSize = 14.sp, color = Color(WgcCoreDsColors.cdtGreen))
            }
        }
    }
}
