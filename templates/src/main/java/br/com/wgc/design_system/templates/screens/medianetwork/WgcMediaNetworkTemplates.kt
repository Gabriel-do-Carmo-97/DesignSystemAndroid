package br.com.wgc.design_system.templates.screens.medianetwork

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
fun WgcUolHomeTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.mediaNetworkYellow)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("UOL • O Melhor Conteúdo", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(MediaNetworkMockData.sampleNews) { item ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(item.author, color = Color.Gray, fontSize = 14.sp)
                        Text(item.headline, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcUolEconomyTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "UOL Economia & Cotações em Tempo Real", modifier = modifier)

@Composable
fun WgcUolSportsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "UOL Esporte • Placar ao Vivo", modifier = modifier)

@Composable
fun WgcUolOpinionTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Colunistas & Opinião UOL", modifier = modifier)

@Composable
fun WgcUolProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Conta UOL & Clube UOL", modifier = modifier)
