package br.com.wgc.ds_templates.screens.c6

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import br.com.wgc.core_ds.WgcCoreDsSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcC6AtomosTemplate(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.c6Background),
        topBar = {
            TopAppBar(
                title = { Text("Átomos C6 Store", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(WgcCoreDsColors.c6Primary),
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
            items(C6MockData.sampleRewards) { reward ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.c6Primary))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(reward.title, fontWeight = FontWeight.Bold, color = Color.White, fontSize = WgcCoreDsFontSize.body1.sp)
                            Text(reward.category, color = Color.Gray, fontSize = WgcCoreDsFontSize.caption.sp)
                        }
                        Text("${reward.pointsRequired} pts", fontWeight = FontWeight.Bold, color = Color(WgcCoreDsColors.c6Yellow))
                    }
                }
            }
        }
    }
}
