package br.com.wgc.ds_templates.screens.slack

import br.com.wgc.ds_templates.screens.common.placeholder.WgcGenericPlaceholderTemplate

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
fun WgcSlackChannelsTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.slackAubergine)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("WGC Engineering • Slack", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(SlackMockData.sampleChannels) { ch ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(ch.name, fontWeight = FontWeight.Bold)
                        Text(ch.topic, color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcSlackThreadsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Threads & Respostas de Mensagens", modifier = modifier)

@Composable
fun WgcSlackDirectTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Mensagens Diretas e Menções (@)", modifier = modifier)

@Composable
fun WgcSlackSearchTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Busca em Mensagens & Arquivos", modifier = modifier)

@Composable
fun WgcSlackProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Meu Status de Presença • 💬 Focado", modifier = modifier)
