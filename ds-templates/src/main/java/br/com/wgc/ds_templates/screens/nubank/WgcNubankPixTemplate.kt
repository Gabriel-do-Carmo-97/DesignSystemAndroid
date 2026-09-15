package br.com.wgc.ds_templates.screens.nubank

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcNubankPixTemplate(
    onSendPixClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Área Pix & Transferências", fontWeight = FontWeight.Bold) },
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
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
                        Text("Envie ou Receba em segundos", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
                        Button(
                            onClick = onSendPixClick,
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(WgcCoreDsColors.nubankPrimary)),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.full9999.dp)
                        ) {
                            Text("Transferir com Chave Pix", fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }

            item {
                Text("Histórico Recente", fontWeight = FontWeight.Bold, fontSize = WgcCoreDsFontSize.h3.sp)
            }

            items(NubankMockData.sampleTransactions) { tx ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.sm12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(tx.title, fontWeight = FontWeight.SemiBold, fontSize = WgcCoreDsFontSize.body1.sp)
                            Text("${tx.category} • ${tx.date}", fontSize = WgcCoreDsFontSize.caption.sp, color = Color.Gray)
                        }
                        Text(
                            text = "${if (tx.isPositive) "+" else "-"} R$ ${"%,.2f".format(tx.amount)}",
                            fontWeight = FontWeight.Bold,
                            color = if (tx.isPositive) Color(0xFF2E7D32) else Color.Black
                        )
                    }
                }
            }
        }
    }
}
