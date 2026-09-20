package br.com.wgc.design_system.templates.screens.pizza

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
fun WgcPizzaBuildTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.pizzaBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Pizzaria Pizza • Monte sua Pizza", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(PizzaMockData.samplePizzas) { pizza ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(pizza.name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text(pizza.ingredients, color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(pizza.price)}", fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.pizzaRed))
                    }
                }
            }
        }
    }
}

@Composable
fun WgcPizzaTrackerTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Pizza Tracker • Acompanhe o Forno e a Entrega", modifier = modifier)

@Composable
fun WgcPizzaOffersTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Ofertas 2 por 1 • Terça em Dobro", modifier = modifier)

@Composable
fun WgcPizzaCartTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Carrinho de Pedidos Pizzaria", modifier = modifier)

@Composable
fun WgcPizzaProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil Pizzaria & Endereços de Entrega", modifier = modifier)
