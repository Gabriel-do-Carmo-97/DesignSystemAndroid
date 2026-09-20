package br.com.wgc.design_system.templates.screens.notifications

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
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
 * Categorias para filtragem na central de notificações.
 */
enum class WgcNotificationCategory(val label: String) {
    ALL("Todas"),
    UNREAD("Não lidas"),
    TRANSACTIONAL("Transações")
}

/**
 * Tipo semântico da notificação.
 */
enum class WgcNotificationType {
    INFO,
    SUCCESS,
    WARNING,
    TRANSACTION
}

/**
 * Modelo de dados de um item de notificação.
 */
data class WgcNotificationItemData(
    val id: String,
    val title: String,
    val message: String,
    val timestamp: String,
    val isRead: Boolean = false,
    val type: WgcNotificationType = WgcNotificationType.INFO
)

/**
 * Estado de UI da Central de Notificações.
 */
data class WgcNotificationCenterUiState(
    val selectedCategory: WgcNotificationCategory = WgcNotificationCategory.ALL,
    val notifications: List<WgcNotificationItemData> = defaultNotifications(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

private fun defaultNotifications() = listOf(
    WgcNotificationItemData(
        id = "1",
        title = "Pix Recebido com Sucesso",
        message = "Você recebeu uma transferência de R$ 250,00 de João Silva.",
        timestamp = "Há 5 minutos",
        isRead = false,
        type = WgcNotificationType.TRANSACTION
    ),
    WgcNotificationItemData(
        id = "2",
        title = "Novo Acesso Detectado",
        message = "Um login recente foi realizado a partir de São Paulo, Brasil.",
        timestamp = "Há 1 hora",
        isRead = false,
        type = WgcNotificationType.WARNING
    ),
    WgcNotificationItemData(
        id = "3",
        title = "Atualização do Sistema",
        message = "A nova versão do Design System WGC está disponível com novos componentes.",
        timestamp = "Ontem",
        isRead = true,
        type = WgcNotificationType.INFO
    ),
    WgcNotificationItemData(
        id = "4",
        title = "Fatura Paga",
        message = "O pagamento da sua fatura mensal foi confirmado.",
        timestamp = "Há 2 dias",
        isRead = true,
        type = WgcNotificationType.SUCCESS
    )
)

abstract class BaseNotificationCenterViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcNotificationCenterUiState>
    abstract fun onCategorySelected(category: WgcNotificationCategory)
    abstract fun onNotificationClick(id: String)
    abstract fun onMarkAllAsRead()
    abstract fun onClearAll()
}

class FakeNotificationCenterViewModel : BaseNotificationCenterViewModel() {
    private val _uiState = MutableStateFlow(WgcNotificationCenterUiState())
    override val uiState: StateFlow<WgcNotificationCenterUiState> = _uiState.asStateFlow()

    override fun onCategorySelected(category: WgcNotificationCategory) {
        _uiState.value = _uiState.value.copy(selectedCategory = category)
    }

    override fun onNotificationClick(id: String) {
        val updated = _uiState.value.notifications.map {
            if (it.id == id) it.copy(isRead = true) else it
        }
        _uiState.value = _uiState.value.copy(notifications = updated)
    }

    override fun onMarkAllAsRead() {
        val updated = _uiState.value.notifications.map { it.copy(isRead = true) }
        _uiState.value = _uiState.value.copy(notifications = updated)
    }

    override fun onClearAll() {
        _uiState.value = _uiState.value.copy(notifications = emptyList())
    }
}

/**
 * Template da Central de Notificações com State Hoisting, abas de filtro e slots.
 */
@Composable
fun WgcNotificationCenterTemplate(
    viewModel: BaseNotificationCenterViewModel = FakeNotificationCenterViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    emptySlot: (@Composable () -> Unit)? = null,
    onNavigateBack: (() -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    WgcNotificationCenterContent(
        state = state,
        onCategorySelected = viewModel::onCategorySelected,
        onNotificationClick = viewModel::onNotificationClick,
        onMarkAllAsRead = viewModel::onMarkAllAsRead,
        onClearAll = viewModel::onClearAll,
        headerSlot = headerSlot,
        emptySlot = emptySlot,
        onNavigateBack = onNavigateBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("LongMethod", "CyclomaticComplexMethod", "LongParameterList")
@Composable
private fun WgcNotificationCenterContent(
    state: WgcNotificationCenterUiState,
    onCategorySelected: (WgcNotificationCategory) -> Unit,
    onNotificationClick: (String) -> Unit,
    onMarkAllAsRead: () -> Unit,
    onClearAll: () -> Unit,
    headerSlot: (@Composable () -> Unit)?,
    emptySlot: (@Composable () -> Unit)?,
    onNavigateBack: (() -> Unit)?
) {
    val filteredNotifications = when (state.selectedCategory) {
        WgcNotificationCategory.ALL -> state.notifications
        WgcNotificationCategory.UNREAD -> state.notifications.filter { !it.isRead }
        WgcNotificationCategory.TRANSACTIONAL -> state.notifications.filter {
            it.type == WgcNotificationType.TRANSACTION
        }
    }

    Scaffold(
        topBar = {
            if (headerSlot != null) {
                headerSlot()
            } else {
                TopAppBar(
                    title = {
                        Text(
                            text = "Notificações",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        if (onNavigateBack != null) {
                            IconButton(onClick = onNavigateBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Voltar"
                                )
                            }
                        }
                    },
                    actions = {
                        IconButton(onClick = onMarkAllAsRead) {
                            Icon(
                                imageVector = Icons.Default.DoneAll,
                                contentDescription = "Marcar todas como lidas"
                            )
                        }
                        IconButton(onClick = onClearAll) {
                            Icon(
                                imageVector = Icons.Default.DeleteSweep,
                                contentDescription = "Limpar notificações"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Chips de categoria
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.md.dp,
                        vertical = WgcCoreDsSpacing.xs.dp
                    ),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
            ) {
                WgcNotificationCategory.values().forEach { category ->
                    val isSelected = state.selectedCategory == category
                    FilterChip(
                        selected = isSelected,
                        onClick = { onCategorySelected(category) },
                        label = { Text(text = category.label) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            when {
                state.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                filteredNotifications.isEmpty() -> {
                    if (emptySlot != null) {
                        emptySlot()
                    } else {
                        WgcNotificationEmptyState()
                    }
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = WgcCoreDsSpacing.md.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
                    ) {
                        items(filteredNotifications, key = { it.id }) { item ->
                            WgcNotificationCard(
                                item = item,
                                onClick = { onNotificationClick(item.id) }
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))
                        }
                    }
                }
            }
        }
    }
}

@Suppress("LongMethod")
@Composable
private fun WgcNotificationCard(
    item: WgcNotificationItemData,
    onClick: () -> Unit
) {
    val containerColor = if (item.isRead) {
        MaterialTheme.colorScheme.surface
    } else {
        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.15f)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md.dp),
            verticalAlignment = Alignment.Top
        ) {
            val (icon, tint) = notificationIconAndTint(item.type)
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(tint.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = tint,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = if (item.isRead) FontWeight.Medium else FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                    if (!item.isRead) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))

                Text(
                    text = item.message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

                Text(
                    text = item.timestamp,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}

@Composable
private fun notificationIconAndTint(type: WgcNotificationType): Pair<ImageVector, Color> {
    return when (type) {
        WgcNotificationType.INFO -> Icons.Default.Info to MaterialTheme.colorScheme.primary
        WgcNotificationType.SUCCESS -> Icons.Default.CheckCircle to MaterialTheme.colorScheme.primary
        WgcNotificationType.WARNING -> Icons.Default.Warning to MaterialTheme.colorScheme.error
        WgcNotificationType.TRANSACTION -> Icons.Default.Payment to MaterialTheme.colorScheme.secondary
    }
}

@Composable
private fun WgcNotificationEmptyState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(WgcCoreDsSpacing.xl.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.NotificationsNone,
                contentDescription = null,
                modifier = Modifier.size(64.dp),
                tint = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
            Text(
                text = "Nenhuma notificação",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
            Text(
                text = "Você está em dia com todas as suas notificações.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(name = "Notification Center Preview", showBackground = true)
@Composable
private fun WgcNotificationCenterTemplatePreview() {
    Surface {
        WgcNotificationCenterTemplate()
    }
}
