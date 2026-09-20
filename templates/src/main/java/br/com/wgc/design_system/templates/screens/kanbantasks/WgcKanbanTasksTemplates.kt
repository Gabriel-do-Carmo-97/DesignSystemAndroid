package br.com.wgc.design_system.templates.screens.kanbantasks

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
fun WgcTrelloBoardTemplate(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(Color(WgcCoreDsColors.kanbanTasksBlue)).padding(WgcCoreDsSpacing.md16.dp)) {
                Text("Kanban • Quadro de Engenharia", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp), verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)) {
            items(KanbanTasksMockData.sampleCards) { card ->
                Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(card.title, fontWeight = FontWeight.Bold)
                        Text("${card.list} • Checklist: ${card.checklistCount}", color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun WgcTrelloCardDetailTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Detalhes do Cartão & Checklist", modifier = modifier)

@Composable
fun WgcTrelloCalendarTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Visualização em Calendário & Prazos", modifier = modifier)

@Composable
fun WgcTrelloPowerupsTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Power-Ups & Automações Butler", modifier = modifier)

@Composable
fun WgcTrelloProfileTemplate(modifier: Modifier = Modifier) =
    WgcGenericPlaceholderTemplate(title = "Perfil do Membro & Quadros Salvos", modifier = modifier)
