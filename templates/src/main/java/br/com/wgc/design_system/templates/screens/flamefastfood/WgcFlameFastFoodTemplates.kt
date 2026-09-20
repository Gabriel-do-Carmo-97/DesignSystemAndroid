package br.com.wgc.design_system.templates.screens.flamefastfood

import br.com.wgc.design_system.templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

@Composable
fun WgcBurgerKingMenuTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.flameFastFoodBrown)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Flame Burger • Grelhados Artesanais", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(BurgerKingMockData.sampleMenu) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.name, fontWeight = FontWeight.Bold)
                        if (item.fireGrilled) Text("🔥 Grelhado no Fogo de Verdade", color = Color(WgcCoreDsColors.flameFastFoodOrange), fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcBurgerKingClubeTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Clube Flame • Seus Pontos & Descontos", modifier = modifier)

@Composable
fun WgcBurgerKingCouponsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Cupons Exclusivos do App", modifier = modifier)

@Composable
fun WgcBurgerKingBagTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Sacola de Pedidos Flame", modifier = modifier)

@Composable
fun WgcBurgerKingProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Flame Burger", modifier = modifier)
