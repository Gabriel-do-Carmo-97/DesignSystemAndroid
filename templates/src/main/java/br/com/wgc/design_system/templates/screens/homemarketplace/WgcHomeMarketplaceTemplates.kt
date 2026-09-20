package br.com.wgc.design_system.templates.screens.homemarketplace

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
fun WgcMadeiraMadeiraHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.homeMarketplaceOrange)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("MadeiraMadeira • Tudo para sua Casa", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(MadeiraMadeiraMockData.sampleProducts) { prod ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(prod.title, fontWeight = FontWeight.Bold)
                        Text(prod.discount, color = Color(WgcCoreDsColors.homeMarketplaceOrange), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(prod.price)}", fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcMadeiraMadeiraPlannedTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Ambientes Planejados Direto de Fábrica", modifier = modifier)

@Composable
fun WgcMadeiraMadeiraShippingTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Ofertas com Frete Grátis Sul & Sudeste", modifier = modifier)

@Composable
fun WgcMadeiraMadeiraCartTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Carrinho de Móveis & Decoração", modifier = modifier)

@Composable
fun WgcMadeiraMadeiraProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Meus Pedidos & Rastreio de Transportadora", modifier = modifier)
