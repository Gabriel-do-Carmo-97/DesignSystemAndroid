package br.com.wgc.ds_templates.screens.nubank

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcNubankCaixinhaCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcNubankInvestTemplate(
    onCreateCaixinhaClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Caixinhas & Investimentos", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(WgcCoreDsColors.nubankPrimary),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Text("Total guardado em Caixinhas", fontSize = WgcCoreDsFontSize.caption.sp, color = Color.Gray)
                        Text("R$ 35.651,30", fontSize = WgcCoreDsFontSize.h1.sp, fontWeight = FontWeight.ExtraBold, color = Color(WgcCoreDsColors.nubankPrimary))
                        Button(
                            onClick = onCreateCaixinhaClick,
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(WgcCoreDsColors.nubankPrimary)),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.full9999.dp)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
                            Spacer(Modifier.width(WgcCoreDsSpacing.xs8.dp))
                            Text("Criar nova Caixinha", fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }

            item {
                Text("Minhas Caixinhas", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
            }

            items(NubankMockData.sampleCaixinhas) { caixinha ->
                WgcNubankCaixinhaCard(
                    title = caixinha.name,
                    currentAmount = caixinha.currentAmount,
                    targetAmount = caixinha.targetAmount,
                    yieldLabel = caixinha.yieldPercentage
                )
            }
        }
    }
}
