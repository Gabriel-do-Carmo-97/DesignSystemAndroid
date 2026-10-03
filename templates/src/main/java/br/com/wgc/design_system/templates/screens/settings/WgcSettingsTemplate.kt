@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.templates.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estado da tela de configurações gerais do aplicativo.
 */
data class WgcSettingsUiState(
    val isDarkModeEnabled: Boolean = false,
    val isBiometricsEnabled: Boolean = true,
    val isPushNotificationsEnabled: Boolean = true,
    val selectedLanguage: String = "Português (Brasil)"
)

/**
 * Template corporativo de configurações do sistema (WgcSettingsTemplate).
 */
@Composable
fun WgcSettingsTemplate(
    uiState: WgcSettingsUiState,
    onToggleDarkMode: (Boolean) -> Unit,
    onToggleBiometrics: (Boolean) -> Unit,
    onTogglePushNotifications: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            Text(
                text = "Configurações",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
                    SettingSwitchRow(
                        title = "Modo Escuro (Dark Mode)",
                        subtitle = "Ajusta as cores para conforto visual em ambientes escuros",
                        checked = uiState.isDarkModeEnabled,
                        onCheckedChange = onToggleDarkMode
                    )
                    HorizontalDivider(modifier = Modifier.padding(vertical = WgcCoreDsSpacing.xs.dp))
                    SettingSwitchRow(
                        title = "Autenticação Biométrica",
                        subtitle = "Exigir digital ou Face ID para abrir o aplicativo",
                        checked = uiState.isBiometricsEnabled,
                        onCheckedChange = onToggleBiometrics
                    )
                    HorizontalDivider(modifier = Modifier.padding(vertical = WgcCoreDsSpacing.xs.dp))
                    SettingSwitchRow(
                        title = "Notificações Push",
                        subtitle = "Receber alertas sobre transações e atualizações",
                        checked = uiState.isPushNotificationsEnabled,
                        onCheckedChange = onTogglePushNotifications
                    )
                }
            }
        }
    }
}

@Composable
private fun SettingSwitchRow(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
            Text(text = subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}
