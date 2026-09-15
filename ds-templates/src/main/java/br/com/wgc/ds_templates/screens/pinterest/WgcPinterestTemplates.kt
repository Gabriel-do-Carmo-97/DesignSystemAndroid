package br.com.wgc.ds_templates.screens.pinterest

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
fun WgcPinterestFeedTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.pinterestRed)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Pinterest • Inspirações para Você", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(PinterestMockData.samplePins) { pin ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(pin.title, fontWeight = FontWeight.Bold)
                        Text("${pin.author} • ${pin.saves} salvamentos", color = Color.Gray, fontSize = 14.sp.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcPinterestSearchTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Buscar Ideias & Tendências", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcPinterestCreateTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Criar Novo Pin & Pasta", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcPinterestUpdatesTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Atualizações de Inspiração", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}

@Composable
fun WgcPinterestProfileTemplate(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(WgcCoreDsSpacing.md16.dp)) {
            Text("Meu Perfil & Minhas Pastas", fontWeight = FontWeight.Bold, fontSize = 14.sp.sp)
        }
    }
}
