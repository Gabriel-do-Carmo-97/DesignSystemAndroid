@file:Suppress("LongMethod", "UnusedPrivateMember")

package br.com.wgc.design_system.templates.screens.security

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Modelo de dispositivo conectado à conta WGC.
 */
data class WgcConnectedDevice(
    val id: String,
    val deviceName: String,
    val location: String,
    val lastActive: String,
    val isCurrentDevice: Boolean = false
)

/**
 * Estado corporativo da tela de Segurança e Acesso.
 */
data class WgcSecuritySettingsUiState(
    val title: String = "Segurança & Acesso",
    val isBiometricsEnabled: Boolean = true,
    val isTwoFactorEnabled: Boolean = true,
    val connectedDevices: List<WgcConnectedDevice> = defaultConnectedDevices()
)

/**
 * ViewModel base desacoplada para configurações de segurança.
 */
abstract class BaseSecuritySettingsViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcSecuritySettingsUiState>
    abstract fun onToggleBiometrics(enabled: Boolean)
    abstract fun onToggleTwoFactor(enabled: Boolean)
    abstract fun onChangePassword()
    abstract fun onRevokeDevice(deviceId: String)
}

/**
 * Fake ViewModel para Testes e Previews.
 */
class FakeSecuritySettingsViewModel(
    initialState: WgcSecuritySettingsUiState = WgcSecuritySettingsUiState()
) : BaseSecuritySettingsViewModel() {
    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<WgcSecuritySettingsUiState> = _uiState.asStateFlow()

    override fun onToggleBiometrics(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(isBiometricsEnabled = enabled)
    }

    override fun onToggleTwoFactor(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(isTwoFactorEnabled = enabled)
    }

    override fun onChangePassword() {
        // No-op for fake preview
    }

    override fun onRevokeDevice(deviceId: String) {
        _uiState.value = _uiState.value.copy(
            connectedDevices = _uiState.value.connectedDevices.filter { it.id != deviceId }
        )
    }
}

/**
 * Template completo corporativo de Configurações de Segurança.
 */
@Composable
fun WgcSecuritySettingsTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseSecuritySettingsViewModel = FakeSecuritySettingsViewModel(),
    headerSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    WgcSecuritySettingsContent(
        state = state,
        modifier = modifier,
        onToggleBiometrics = viewModel::onToggleBiometrics,
        onToggleTwoFactor = viewModel::onToggleTwoFactor,
        onChangePassword = viewModel::onChangePassword,
        onRevokeDevice = viewModel::onRevokeDevice,
        headerSlot = headerSlot
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcSecuritySettingsContent(
    state: WgcSecuritySettingsUiState,
    modifier: Modifier = Modifier,
    onToggleBiometrics: (Boolean) -> Unit = {},
    onToggleTwoFactor: (Boolean) -> Unit = {},
    onChangePassword: () -> Unit = {},
    onRevokeDevice: (String) -> Unit = {},
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
                    title = { Text(state.title, style = MaterialTheme.typography.titleLarge) },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
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
                .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
        ) {
            SecurityTogglesCard(
                isBiometricsEnabled = state.isBiometricsEnabled,
                isTwoFactorEnabled = state.isTwoFactorEnabled,
                onToggleBiometrics = onToggleBiometrics,
                onToggleTwoFactor = onToggleTwoFactor,
                onChangePassword = onChangePassword
            )

            ConnectedDevicesSection(
                devices = state.connectedDevices,
                onRevokeDevice = onRevokeDevice
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Composable
private fun SecurityTogglesCard(
    isBiometricsEnabled: Boolean,
    isTwoFactorEnabled: Boolean,
    onToggleBiometrics: (Boolean) -> Unit,
    onToggleTwoFactor: (Boolean) -> Unit,
    onChangePassword: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Text(text = "Autenticação & Acesso", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Fingerprint,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column {
                        Text(
                            text = "Biometria Facial / Digital",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Acesse e aprove transações com biometria",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
                Switch(checked = isBiometricsEnabled, onCheckedChange = onToggleBiometrics)
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Security,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column {
                        Text(
                            text = "Autenticação em 2 Etapas (2FA)",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Código de segurança enviado por SMS/E-mail",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
                Switch(checked = isTwoFactorEnabled, onCheckedChange = onToggleTwoFactor)
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LockReset,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column {
                        Text(
                            text = "Alterar Senha de Acesso",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Recomendamos alterar a cada 90 dias",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
                IconButton(onClick = onChangePassword) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = "Alterar senha",
                        modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ConnectedDevicesSection(
    devices: List<WgcConnectedDevice>,
    onRevokeDevice: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                Icon(imageVector = Icons.Default.Devices, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                Text(text = "Dispositivos Conectados", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            }

            for (device in devices) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = if (device.isCurrentDevice) "${device.deviceName} (Este aparelho)" else device.deviceName,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "${device.location} • ${device.lastActive}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }

                    if (!device.isCurrentDevice) {
                        TextButton(onClick = { onRevokeDevice(device.id) }) {
                            Text(text = "Desconectar", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.labelMedium)
                        }
                    }
                }
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            }
        }
    }
}

private fun defaultConnectedDevices(): List<WgcConnectedDevice> {
    return listOf(
        WgcConnectedDevice(
            id = "dev-1",
            deviceName = "Samsung Galaxy S24 Ultra",
            location = "São Paulo, SP",
            lastActive = "Ativo agora",
            isCurrentDevice = true
        ),
        WgcConnectedDevice(
            id = "dev-2",
            deviceName = "MacBook Pro 16",
            location = "Campinas, SP",
            lastActive = "Hoje às 10:15",
            isCurrentDevice = false
        )
    )
}

@Preview(name = "WgcSecuritySettingsTemplate Preview", showBackground = true)
@Composable
private fun WgcSecuritySettingsTemplatePreview() {
    MaterialTheme {
        WgcSecuritySettingsContent(state = WgcSecuritySettingsUiState())
    }
}
