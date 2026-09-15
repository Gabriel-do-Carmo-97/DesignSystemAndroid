package br.com.wgc.ds_templates.screens.nubank

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Lock
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
import br.com.wgc.design_system.components.cards.WgcNubankCreditCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcNubankCardTemplate(
    onAdjustLimitClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Cartão de Crédito", fontWeight = FontWeight.Bold) },
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
                WgcNubankCreditCard(
                    currentInvoice = NubankMockData.sampleCard.currentInvoice,
                    availableLimit = NubankMockData.sampleCard.availableLimit,
                    dueDate = NubankMockData.sampleCard.dueDate
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Text("Cartão Virtual", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
                        Text("Crie cartões temporários para compras online seguras.", color = Color.Gray, fontSize = 14.sp.sp)
                        OutlinedButton(
                            onClick = onAdjustLimitClick,
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                        ) {
                            Icon(Icons.Default.Lock, contentDescription = null)
                            Spacer(Modifier.width(WgcCoreDsSpacing.xs8.dp))
                            Text("Ajustar Limite")
                        }
                    }
                }
            }
        }
    }
}
