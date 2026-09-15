package br.com.wgc.ds_templates.screens.c6

import androidx.compose.foundation.layout.*
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
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcC6GlobalTemplate(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.c6Background),
        topBar = {
            TopAppBar(
                title = { Text("Conta Global Dólar & Euro", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(WgcCoreDsColors.c6Primary),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.c6Primary))
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                    Text("Saldo em Dólar Comercial", color = Color.Gray, fontSize = WgcCoreDsFontSize.caption.sp)
                    Text("US$ 2.450,00", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = WgcCoreDsFontSize.h1.sp)
                    Text("Cotação Comercial 24h • Spread a partir de 1%", color = Color.Gray, fontSize = WgcCoreDsFontSize.body2.sp)
                }
            }
        }
    }
}
