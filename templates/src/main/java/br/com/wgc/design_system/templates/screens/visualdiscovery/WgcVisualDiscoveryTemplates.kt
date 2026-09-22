package br.com.wgc.design_system.templates.screens.visualdiscovery

import br.com.wgc.design_system.templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

@Composable
fun WgcPinterestFeedTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.visualDiscoveryRed)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Visual Discovery • Inspirações", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(VisualDiscoveryMockData.samplePins) { pin ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(pin.title, fontWeight = FontWeight.Bold)
                        Text("${pin.author} • ${pin.saves} salvamentos", color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcPinterestSearchTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Buscar Ideias & Tendências", modifier = modifier)

@Composable
fun WgcPinterestCreateTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Criar Novo Pin & Pasta", modifier = modifier)

@Composable
fun WgcPinterestUpdatesTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Atualizações de Inspiração", modifier = modifier)

@Composable
fun WgcPinterestProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Meu Perfil & Minhas Pastas", modifier = modifier)
