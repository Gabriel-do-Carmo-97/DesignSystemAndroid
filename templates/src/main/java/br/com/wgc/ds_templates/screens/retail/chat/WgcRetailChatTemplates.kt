package br.com.wgc.ds_templates.screens.retail.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.ds_templates.screens.retail.model.KutukuActivityUser
import br.com.wgc.ds_templates.screens.retail.model.KutukuMessageItem
import br.com.wgc.ds_templates.screens.retail.model.RetailMockData

/**
 * Tela de Mensagens oficial do Kutuku (WgcKutukuMessageScreen).
 */
@Composable
fun WgcKutukuMessageScreen(
    modifier: Modifier = Modifier,
    activities: List<KutukuActivityUser> = RetailMockData.sampleActivities,
    messages: List<KutukuMessageItem> = RetailMockData.sampleMessages,
    onBackClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onMessageClick: (KutukuMessageItem) -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(WgcCoreDsColors.retailSurface))
            .padding(horizontal = WgcCoreDsSpacing.lg.dp, vertical = WgcCoreDsSpacing.sm.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = WgcCoreDsSpacing.xs.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color(WgcCoreDsColors.retailDark)
                )
            }

            Text(
                text = "Message",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.retailDark)
            )

            Box(contentAlignment = Alignment.TopEnd) {
                IconButton(onClick = onNotificationClick) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notificações",
                        tint = Color(WgcCoreDsColors.retailDark)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(top = WgcCoreDsSpacing.xs.dp, end = WgcCoreDsSpacing.xs.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.retailAlertRed))
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

        // Campo de Busca com Ícone de Filtro
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search something...", color = Color(WgcCoreDsColors.retailSecondaryText)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.retailDark)
                )
            },
            trailingIcon = {
                IconButton(onClick = onSearchClick) {
                    Icon(
                        imageVector = Icons.Default.Tune,
                        contentDescription = "Filtros",
                        tint = Color(WgcCoreDsColors.retailDark)
                    )
                }
            },
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(WgcCoreDsColors.retailPrimary),
                unfocusedBorderColor = Color(WgcCoreDsColors.retailBorder)
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

        // Seção "Activities"
        Text(
            text = "Activities",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.retailDark)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp),
            contentPadding = PaddingValues(vertical = WgcCoreDsSpacing.xs.dp)
        ) {
            items(activities) { user ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { }
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color(WgcCoreDsColors.retailPrimary), CircleShape)
                            .padding(3.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.retailPrimaryLight)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (!user.avatarUrl.isNullOrEmpty()) {
                            AsyncImageDefault(
                                image = user.avatarUrl,
                                contentDescription = user.name,
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            Text(user.name.take(1), fontWeight = FontWeight.Bold)
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))

                    Text(
                        text = user.name,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(WgcCoreDsColors.retailDark)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

        // Seção "Messages"
        Text(
            text = "Messages",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.retailDark)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            items(messages) { msg ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onMessageClick(msg) }
                        .padding(vertical = WgcCoreDsSpacing.xs.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .border(1.5.dp, Color(WgcCoreDsColors.retailPrimary), CircleShape)
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.retailPrimaryLight)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (!msg.avatarUrl.isNullOrEmpty()) {
                            AsyncImageDefault(
                                image = msg.avatarUrl,
                                contentDescription = msg.senderName,
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            Text(msg.senderName.take(1), fontWeight = FontWeight.Bold)
                        }
                    }

                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = msg.senderName,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.retailDark)
                        )
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs.dp))
                        Text(
                            text = msg.lastMessage,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.retailSecondaryText),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs.dp))

                    Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs.dp)
                    ) {
                        Text(
                            text = msg.timeAgo,
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(WgcCoreDsColors.retailSecondaryText)
                        )

                        if (msg.unreadCount > 0) {
                            Box(
                                modifier = Modifier
                                    .size(22.dp)
                                    .clip(CircleShape)
                                    .background(Color(WgcCoreDsColors.retailPrimary)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = msg.unreadCount.toString(),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        } else {
                            Spacer(modifier = Modifier.height(22.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuMessageScreenPreview() {
    WgcKutukuMessageScreen()
}
