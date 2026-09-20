package br.com.wgc.design_system.templates.screens.petlifestyle

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
fun WgcZeeDogHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.petLifestyleBlack)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("ZEE.DOG • Design & Conexão", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(ZeeDogMockData.sampleProducts) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.name, fontWeight = FontWeight.Bold)
                        Text(item.category, color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcZeeDogKitchenTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Zee.Dog Kitchen • Alimentação Natural Completa", modifier = modifier)

@Composable
fun WgcZeeDogAccessoriesTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Coleiras, Guias & Conectores", modifier = modifier)

@Composable
fun WgcZeeDogCartTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Carrinho Zee.Dog", modifier = modifier)

@Composable
fun WgcZeeDogProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Zee.Club", modifier = modifier)
