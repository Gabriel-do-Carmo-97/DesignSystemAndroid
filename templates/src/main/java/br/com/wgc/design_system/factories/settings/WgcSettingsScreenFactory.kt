package br.com.wgc.design_system.factories.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.previews.devices.phone.WgcDevicePreviews
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.inputs.WgcSwitch
import br.com.wgc.design_system.components.list.WgcListItem
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.factories.profile.templates.SettingsHubScreenContent
import br.com.wgc.design_system.factories.profile.templates.SettingsHubUiState
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Configurações (WgcSettingsScreenFactory).
 *
 * Ponto de entrada unificado para telas de configurações, segurança, termos e preferências.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Suppress("LongMethod", "CyclomaticComplexMethod")
@Composable
fun WgcSettingsScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcSettingsVariant = WgcSettingsVariant.STANDARD,
    userName: String = "Gabriel do Carmo",
    email: String = "gabriel@wgc.com.br",
    notificationsEnabled: Boolean = true,
    onToggleNotifications: (Boolean) -> Unit = {},
    darkModeEnabled: Boolean = false,
    onToggleDarkMode: (Boolean) -> Unit = {},
    biometricsEnabled: Boolean = true,
    onToggleBiometrics: (Boolean) -> Unit = {},
    onLogoutClick: () -> Unit = {},
    onPrivacyClick: () -> Unit = {},
    onTermsClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    contentSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    when (variant) {
        WgcSettingsVariant.STANDARD -> {
            if (contentSlot != null) {
                contentSlot()
            } else {
                SettingsHubScreenContent(
                    modifier = modifier,
                    state = SettingsHubUiState(
                        userName = userName,
                        email = email,
                        notificationsEnabled = notificationsEnabled,
                        darkModeEnabled = darkModeEnabled
                    ),
                    onToggleNotifications = onToggleNotifications,
                    onToggleDarkMode = onToggleDarkMode,
                    onLogoutClick = onLogoutClick
                )
            }
        }
        WgcSettingsVariant.SECURITY -> {
            Scaffold(
                modifier = modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = { Text("Segurança & Privacidade", fontWeight = FontWeight.Bold) },
                        navigationIcon = {
                            IconButton(onClick = onBackClick) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                            }
                        }
                    )
                }
            ) { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .verticalScroll(rememberScrollState())
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    if (headerSlot != null) {
                        headerSlot()
                    } else {
                        Text(
                            text = "Autenticação e Acesso",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Desbloqueio Biométrico", style = MaterialTheme.typography.bodyLarge)
                            Text(
                                text = "Acessar via FaceID ou Impressão Digital",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        WgcSwitch(checked = biometricsEnabled, onCheckedChange = onToggleBiometrics)
                    }

                    HorizontalDivider()

                    WgcListItem(
                        headlineText = "Alterar Senha de Acesso",
                        leadingContent = { Icon(Icons.Default.Lock, contentDescription = null) },
                        onClick = {}
                    )

                    WgcListItem(
                        headlineText = "Dispositivos Conectados",
                        leadingContent = { Icon(Icons.Default.Security, contentDescription = null) },
                        onClick = {}
                    )

                    WgcListItem(
                        headlineText = "Política de Privacidade WGC",
                        onClick = onPrivacyClick
                    )

                    if (footerSlot != null) {
                        footerSlot()
                    }
                }
            }
        }
        WgcSettingsVariant.PREFERENCES -> {
            Scaffold(
                modifier = modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = { Text("Preferências do App", fontWeight = FontWeight.Bold) },
                        navigationIcon = {
                            IconButton(onClick = onBackClick) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                            }
                        }
                    )
                }
            ) { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .verticalScroll(rememberScrollState())
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    if (headerSlot != null) {
                        headerSlot()
                    } else {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            WgcAvatar(initials = userName.take(2), size = WgcCoreDsSize.s56.dp)
                            Column {
                                Text(text = userName, style = MaterialTheme.typography.titleMedium)
                                Text(
                                    text = email,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    HorizontalDivider()

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Notificações Promocionais", style = MaterialTheme.typography.bodyLarge)
                        WgcSwitch(checked = notificationsEnabled, onCheckedChange = onToggleNotifications)
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Tema Escuro", style = MaterialTheme.typography.bodyLarge)
                        WgcSwitch(checked = darkModeEnabled, onCheckedChange = onToggleDarkMode)
                    }

                    HorizontalDivider()

                    WgcListItem(headlineText = "Termos de Uso", onClick = onTermsClick)
                    WgcListItem(
                        headlineText = "Sair da Conta",
                        leadingContent = { Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = null) },
                        onClick = onLogoutClick
                    )

                    if (footerSlot != null) {
                        footerSlot()
                    }
                }
            }
        }
    }
}

@Preview(name = "WgcSettingsScreenFactory - Standard", showBackground = true)
@WgcDevicePreviews
@Composable
private fun WgcSettingsScreenFactoryStandardPreview() {
    WgcTheme {
        WgcSettingsScreenFactory(variant = WgcSettingsVariant.STANDARD)
    }
}

@Preview(name = "WgcSettingsScreenFactory - Security", showBackground = true)
@Composable
private fun WgcSettingsScreenFactorySecurityPreview() {
    WgcTheme {
        WgcSettingsScreenFactory(variant = WgcSettingsVariant.SECURITY)
    }
}

@Preview(name = "WgcSettingsScreenFactory - Preferences", showBackground = true)
@Composable
private fun WgcSettingsScreenFactoryPreferencesPreview() {
    WgcTheme {
        WgcSettingsScreenFactory(variant = WgcSettingsVariant.PREFERENCES)
    }
}
