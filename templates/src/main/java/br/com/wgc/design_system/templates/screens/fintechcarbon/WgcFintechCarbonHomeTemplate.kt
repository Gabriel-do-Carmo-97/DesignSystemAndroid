package br.com.wgc.design_system.templates.screens.fintechcarbon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPlasticCreditCard

@Composable
fun WgcC6HomeTemplate(
    onCarbonClick: () -> Unit = {},
    onAtomosClick: () -> Unit = {},
    onGlobalClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.fintechDark))
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Carbon Bank", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Icon(Icons.Default.AccountCircle, contentDescription = null, tint = Color.White)
                }
                Spacer(Modifier.height(WgcCoreDsSpacing.sm12.dp))
                Text("Saldo disponível", color = Color.Gray, fontSize = 14.sp)
                Text("R$ 18.340,90", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcPlasticCreditCard(
                    holderName = "GABRIEL CARMO",
                    cardLastDigits = "7412",
                    rewardPoints = 8625
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.fintechDark))
                ) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                        Text("Pontos Átomos", color = Color.Gray, fontSize = 14.sp)
                        Text("48.500 pts", color = Color(WgcCoreDsColors.fintechYellow), fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
                        Text("Seus pontos nunca expiram!", color = Color.White, fontSize = 14.sp)
                        Button(
                            onClick = onAtomosClick,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(WgcCoreDsColors.fintechYellow)),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                        ) {
                            Text("Ver Catálogo Átomos", color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}
