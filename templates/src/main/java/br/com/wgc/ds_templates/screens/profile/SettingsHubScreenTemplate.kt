package br.com.wgc.ds_templates.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.inputs.WgcSwitch
import br.com.wgc.design_system.components.list.WgcListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SettingsHubUiState(
    val userName: String = "Gabriel do Carmo",
    val email: String = "gabriel@wgc.com.br",
    val notificationsEnabled: Boolean = true,
    val darkModeEnabled: Boolean = false
)

abstract class BaseSettingsHubViewModel : ViewModel() {
    abstract val uiState: StateFlow<SettingsHubUiState>
    abstract fun onToggleNotifications(enabled: Boolean)
    abstract fun onToggleDarkMode(enabled: Boolean)
    abstract fun onLogoutClick()
}

class FakeSettingsHubViewModel : BaseSettingsHubViewModel() {
    override val uiState: StateFlow<SettingsHubUiState> = MutableStateFlow(SettingsHubUiState()).asStateFlow()
    override fun onToggleNotifications(enabled: Boolean) {}
    override fun onToggleDarkMode(enabled: Boolean) {}
    override fun onLogoutClick() {}
}

@Composable
fun SettingsHubScreenTemplate(viewModel: BaseSettingsHubViewModel) {
    val state by viewModel.uiState.collectAsState()
    SettingsHubScreenContent(
        state = state,
        onToggleNotifications = { viewModel.onToggleNotifications(it) },
        onToggleDarkMode = { viewModel.onToggleDarkMode(it) },
        onLogoutClick = { viewModel.onLogoutClick() }
    )
}

@Composable
fun SettingsHubScreenContent(
    modifier: Modifier = Modifier,
    state: SettingsHubUiState,
    onToggleNotifications: (Boolean) -> Unit,
    onToggleDarkMode: (Boolean) -> Unit,
    onLogoutClick: () -> Unit
) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp),
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
            ) {
                WgcAvatar(initials = state.userName.take(2), size = 64.dp)
                Column {
                    Text(text = state.userName, style = MaterialTheme.typography.titleLarge)
                    Text(text = state.email, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

            HorizontalDivider()

            Text(text = "Preferências", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Notificações Push", style = MaterialTheme.typography.bodyLarge)
                WgcSwitch(checked = state.notificationsEnabled, onCheckedChange = onToggleNotifications)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Modo Escuro", style = MaterialTheme.typography.bodyLarge)
                WgcSwitch(checked = state.darkModeEnabled, onCheckedChange = onToggleDarkMode)
            }

            HorizontalDivider()

            WgcListItem(headlineText = "Privacidade e Segurança", onClick = {})
            WgcListItem(headlineText = "Termos e Condições", onClick = {})
            WgcListItem(headlineText = "Sair da Conta", onClick = onLogoutClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SettingsHubPreview() {
    MaterialTheme {
        SettingsHubScreenContent(
            state = SettingsHubUiState(),
            onToggleNotifications = {},
            onToggleDarkMode = {},
            onLogoutClick = {}
        )
    }
}
