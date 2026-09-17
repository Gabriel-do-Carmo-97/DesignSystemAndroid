package br.com.wgc.ds_templates.screens.petcare

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
fun WgcPetzHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.petCareYellow)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Pet Care • Especialidades para Pets", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(PetCareMockData.sampleProducts) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.title, fontWeight = FontWeight.Bold)
                        Text(item.category, color = Color.Gray, fontSize = 14.sp)
                        Text("R$ ${"%,.2f".format(item.price)}", fontWeight = FontWeight.SemiBold)
                        Text("Com Assinatura Pet Care: R$ ${"%,.2f".format(item.subscriptionPrice)}", color = Color(WgcCoreDsColors.petCareBlue), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcPetzSubscriptionTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Assinatura Pet Care • 10% OFF em Entregas", modifier = modifier)

@Composable
fun WgcPetzClinicTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Centro Veterinário Seres & Banho/Tosa", modifier = modifier)

@Composable
fun WgcPetzCartTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Carrinho Pet Care", modifier = modifier)

@Composable
fun WgcPetzProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil dos Meus Pets (Bob & Luna)", modifier = modifier)
