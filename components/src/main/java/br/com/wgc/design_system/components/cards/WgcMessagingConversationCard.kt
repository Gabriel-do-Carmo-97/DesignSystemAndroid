package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

@Composable
fun WgcMessagingConversationCard(
    contactName: String,
    lastMessage: String,
    timestamp: String,
    unreadCount: Int = 0,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.MD16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.S48.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.green25)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = contactName.take(1),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.SM12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = contactName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = lastMessage,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    maxLines = 1
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = timestamp,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                if (unreadCount > 0) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.green25))
                            .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
                    ) {
                        Text(
                            text = unreadCount.toString(),
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "WgcMessagingConversationCard Preview", showBackground = true)
@Composable
private fun WgcMessagingConversationCardPreview() {
    WgcTheme {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp)) {
            WgcMessagingConversationCard(
                contactName = "Ana Silva",
                lastMessage = "Olá! Tudo bem? Vamos alinhar a reunião de design amanhã?",
                timestamp = "14:32",
                unreadCount = 3
            )
        }
    }
}
