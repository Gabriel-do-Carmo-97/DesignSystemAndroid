package br.com.wgc.ds_templates.factories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcMessagingConversationCard

enum class WgcMessagingScreen {
    WHATSAPP,
    TELEGRAM,
    PINTEREST
}

@Composable
fun WgcMessagingFactory(
    modifier: Modifier = Modifier,
    screen: WgcMessagingScreen = WgcMessagingScreen.WHATSAPP
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(0xFFF7F8FA)
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcMessagingConversationCard(
                    contactName = "Gabriel do Carmo (Tech Lead)",
                    lastMessage = "Design System em 100% de conformidade!",
                    timestamp = "15:40",
                    unreadCount = 1
                )
            }
            item {
                WgcMessagingConversationCard(
                    contactName = "Equipe Mobile Architecture",
                    lastMessage = "PRs mesclados com sucesso na branch master.",
                    timestamp = "14:15",
                    unreadCount = 0
                )
            }
        }
    }
}
