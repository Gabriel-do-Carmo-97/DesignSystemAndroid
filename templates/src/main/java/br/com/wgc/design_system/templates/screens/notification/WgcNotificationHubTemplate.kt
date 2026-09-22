@file:Suppress("LongMethod", "UnusedPrivateMember")

package br.com.wgc.design_system.templates.screens.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Modelo de notificação in-app / push do ecossistema WGC.
 */
data class WgcNotificationItem(
    val id: String,
    val title: String,
    val message: String,
    val timestamp: String,
    val category: String = "Transações",
    val isRead: Boolean = false,
    val deepLink: String? = null
)

/**
 * Estado corporativo da Central de Notificações.
 */
data class WgcNotificationHubUiState(
    val title: String = "Notificações",
    val categories: List<String> = listOf("Todas", "Transações", "Segurança", "Novidades"),
    val selectedCategory: String = "Todas",
    val notifications: List<WgcNotificationItem> = defaultNotificationItems(),
    val isLoading: Boolean = false
) {
    val unreadCount: Int
        get() = notifications.count { !it.isRead }

    val filteredNotifications: List<WgcNotificationItem>
        get() = if (selectedCategory == "Todas") {
            notifications
        } else {
            notifications.filter { it.category == selectedCategory }
        }
}

/**
 * ViewModel base para a Central de Notificações.
 */
abstract class BaseNotificationHubViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcNotificationHubUiState>
    abstract fun onCategorySelect(category: String)
    abstract fun onMarkAsRead(id: String)
    abstract fun onMarkAllAsRead()
    abstract fun onDeleteNotification(id: String)
    abstract fun onNotificationClick(item: WgcNotificationItem)
}

/**
 * Fake ViewModel para Testes e Previews.
 */
class FakeNotificationHubViewModel(
    initialState: WgcNotificationHubUiState = WgcNotificationHubUiState()
) : BaseNotificationHubViewModel() {
    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<WgcNotificationHubUiState> = _uiState.asStateFlow()

    override fun onCategorySelect(category: String) {
        _uiState.value = _uiState.value.copy(selectedCategory = category)
    }

    override fun onMarkAsRead(id: String) {
        _uiState.value = _uiState.value.copy(
            notifications = _uiState.value.notifications.map {
                if (it.id == id) it.copy(isRead = true) else it
            }
        )
    }

    override fun onMarkAllAsRead() {
        _uiState.value = _uiState.value.copy(
            notifications = _uiState.value.notifications.map { it.copy(isRead = true) }
        )
    }

    override fun onDeleteNotification(id: String) {
        _uiState.value = _uiState.value.copy(
            notifications = _uiState.value.notifications.filter { it.id != id }
        )
    }

    override fun onNotificationClick(item: WgcNotificationItem) {
        onMarkAsRead(item.id)
    }
}

/**
 * Template completo da Central de Notificações corporativa.
 */
@Composable
fun WgcNotificationHubTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseNotificationHubViewModel = FakeNotificationHubViewModel(),
    headerSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    WgcNotificationHubContent(
        state = state,
        modifier = modifier,
        onCategorySelect = viewModel::onCategorySelect,
        onMarkAsRead = viewModel::onMarkAsRead,
        onMarkAllAsRead = viewModel::onMarkAllAsRead,
        onDeleteNotification = viewModel::onDeleteNotification,
        onNotificationClick = viewModel::onNotificationClick,
        headerSlot = headerSlot
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcNotificationHubContent(
    state: WgcNotificationHubUiState,
    modifier: Modifier = Modifier,
    onCategorySelect: (String) -> Unit = {},
    onMarkAsRead: (String) -> Unit = {},
    onMarkAllAsRead: () -> Unit = {},
    onDeleteNotification: (String) -> Unit = {},
    onNotificationClick: (WgcNotificationItem) -> Unit = {},
    onBackClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (headerSlot != null) {
                headerSlot()
            } else {
                TopAppBar(
                    title = {
                        Column {
                            Text(state.title, style = MaterialTheme.typography.titleLarge)
                            if (state.unreadCount > 0) {
                                Text(
                                    text = "${state.unreadCount} não lida(s)",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                        }
                    },
                    actions = {
                        IconButton(onClick = onMarkAllAsRead) {
                            Icon(imageVector = Icons.Default.DoneAll, contentDescription = "Marcar todas como lidas")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NotificationCategoryChips(
                categories = state.categories,
                selected = state.selectedCategory,
                onSelect = onCategorySelect
            )

            val displayList = state.filteredNotifications
            if (displayList.isEmpty()) {
                EmptyNotificationsView()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    items(displayList, key = { it.id }) { item ->
                        NotificationCardItem(
                            item = item,
                            onClick = { onNotificationClick(item) },
                            onDelete = { onDeleteNotification(item.id) }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun NotificationCategoryChips(
    categories: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        items(categories) { category ->
            FilterChip(
                selected = category == selected,
                onClick = { onSelect(category) },
                label = { Text(category) },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
            )
        }
    }
}

@Composable
private fun NotificationCardItem(
    item: WgcNotificationItem,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (item.isRead) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSpacing.xs8.dp)
                    .clip(CircleShape)
                    .background(if (item.isRead) Color.Transparent else MaterialTheme.colorScheme.primary)
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = if (item.isRead) FontWeight.Medium else FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                Text(
                    text = item.message,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                Text(
                    text = "${item.category} • ${item.timestamp}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline
                )
            }

            IconButton(onClick = onDelete, modifier = Modifier.size(WgcCoreDsSpacing.xl32.dp)) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Excluir notificação",
                    tint = MaterialTheme.colorScheme.outline,
                    modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                )
            }
        }
    }
}

@Composable
private fun EmptyNotificationsView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WgcCoreDsSpacing.xl32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.NotificationsNone,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outline,
            modifier = Modifier.size(WgcCoreDsSpacing.xxxl48.dp)
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))
        Text(
            text = "Nenhuma notificação encontrada",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Você está em dia com todos os avisos e comunicações.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

private fun defaultNotificationItems(): List<WgcNotificationItem> {
    return listOf(
        WgcNotificationItem(
            id = "notif-1",
            title = "Transferência Pix Recebida",
            message = "Você recebeu R$ 350,00 de Marcos Souza via Pix.",
            timestamp = "Há 10 min",
            category = "Transações",
            isRead = false
        ),
        WgcNotificationItem(
            id = "notif-2",
            title = "Novo Dispositivo Conectado",
            message = "Acesso detectado a partir de Samsung Galaxy S24 em São Paulo, SP.",
            timestamp = "Hoje às 08:30",
            category = "Segurança",
            isRead = false
        ),
        WgcNotificationItem(
            id = "notif-3",
            title = "Cashback Liberado",
            message = "Seu cashback de R$ 42,50 referente à compra na NexKart já está disponível.",
            timestamp = "Ontem",
            category = "Novidades",
            isRead = true
        )
    )
}

@Preview(name = "WgcNotificationHubTemplate Preview", showBackground = true)
@Composable
private fun WgcNotificationHubTemplatePreview() {
    MaterialTheme {
        WgcNotificationHubContent(state = WgcNotificationHubUiState())
    }
}
