package br.com.wgc.design_system.templates.screens.fintechcarbon

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcC6ProfileTemplate(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Perfil & Segurança da Conta", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(WgcCoreDsColors.fintechDark),
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
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.fintechDark))
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)) {
                    Text("Gabriel do Carmo", fontWeight = FontWeight.Bold, color = Color.White)
                    Text("Banco 336 - Banco Digital S.A.", color = Color.Gray)
                    Text("Agência 0001 • Conta 554433-2", color = Color.Gray)
                }
            }
        }
    }
}
