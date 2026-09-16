package br.com.wgc.ds_templates.screens.burgerking

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
fun WgcBurgerKingMenuTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.burgerkingBrown)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Burger King • Grelhado no Fogo", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(BurgerKingMockData.sampleMenu) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.name, fontWeight = FontWeight.Bold)
                        if (item.fireGrilled) Text("🔥 Grelhado no Fogo de Verdade", color = Color(WgcCoreDsColors.burgerkingOrange), fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcBurgerKingClubeTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Clube BK • Seus Pontos & Descontos", modifier = modifier)

@Composable
fun WgcBurgerKingCouponsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Cupons Exclusivos do App BK", modifier = modifier)

@Composable
fun WgcBurgerKingBagTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Sacola de Pedidos BK", modifier = modifier)

@Composable
fun WgcBurgerKingProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Burger King", modifier = modifier)
