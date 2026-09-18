package br.com.wgc.ds_templates.screens.prestigebeauty

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
fun WgcPrestigeBeautyHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.prestigeBeautyBlack)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("PRESTIGE BEAUTY • Exclusividades & Makes", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(PrestigeBeautyMockData.sampleProducts) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.brand, fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 14.sp)
                        Text(item.name, fontWeight = FontWeight.Bold)
                        Text("+${item.pointsReward} Beauty Club pts", color = Color(WgcCoreDsColors.gadgetShopAccentPink), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcPrestigeBeautyClubTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Beauty Club • Resgate de Miniaturas de Luxo", modifier = modifier)

@Composable
fun WgcPrestigeBeautyTutorialsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Tutoriais de Maquiagem & Reviews Reais", modifier = modifier)

@Composable
fun WgcPrestigeBeautyBagTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Sacola de Cosméticos • Amostras Grátis", modifier = modifier)

@Composable
fun WgcPrestigeBeautyProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Beauty Pass & Histórico", modifier = modifier)
