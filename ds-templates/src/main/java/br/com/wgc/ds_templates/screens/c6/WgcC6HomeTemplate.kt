package br.com.wgc.ds_templates.screens.c6

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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcC6CarbonCard

@Composable
fun WgcC6HomeTemplate(
    onCarbonClick: () -> Unit = {},
    onAtomosClick: () -> Unit = {},
    onGlobalClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.c6Background),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.c6Primary))
                    .padding(WgcCoreDsSpacing.md16.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("C6 Bank", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
                    Icon(Icons.Default.AccountCircle, contentDescription = null, tint = Color.White)
                }
                Spacer(Modifier.height(WgcCoreDsSpacing.sm12.dp))
                Text("Saldo disponível", color = Color.Gray, fontSize = 14.sp.sp)
                Text("R$ 18.340,90", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcC6CarbonCard(
                    cardHolder = "GABRIEL CARMO",
                    invoiceAmount = 3450.00
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.c6Primary))
                ) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                        Text("Pontos Átomos", color = Color.Gray, fontSize = 14.sp.sp)
                        Text("48.500 pts", color = Color(WgcCoreDsColors.c6Yellow), fontWeight = FontWeight.ExtraBold, fontSize = 14.sp.sp)
                        Text("Seus pontos nunca expiram!", color = Color.White, fontSize = 14.sp.sp)
                        Button(
                            onClick = onAtomosClick,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(WgcCoreDsColors.c6Yellow)),
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
