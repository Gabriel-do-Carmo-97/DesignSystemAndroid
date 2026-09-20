@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.factories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
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
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.inputs.WgcSwitch
import br.com.wgc.design_system.components.list.WgcListItem
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.profile.SettingsHubScreenContent
import br.com.wgc.design_system.templates.screens.profile.SettingsHubUiState

/**
 * Variantes de Configurações suportadas pela [WgcSettingsHubFactory].
 */
enum class WgcSettingsHubType {
    STANDARD,
    SECURITY,
    PREFERENCES
}

/**
 * Fábrica Universal do Hub de Configurações (WgcSettingsHubFactory).
 *
 * Provê um ponto de entrada unificado com defaults sensatos de produção e arquitetura de slots,
 * integrando configurações de conta, preferências do aplicativo, segurança e privacidade.
 */
@Suppress("LongMethod", "CyclomaticComplexMethod", "ReturnCount")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcSettingsHubFactory(
    modifier: Modifier = Modifier,
    type: WgcSettingsHubType = WgcSettingsHubType.STANDARD,
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
    when (type) {
        WgcSettingsHubType.STANDARD -> {
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
        WgcSettingsHubType.SECURITY -> {
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
        WgcSettingsHubType.PREFERENCES -> {
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
                            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                        ) {
                            WgcAvatar(initials = userName.take(2), size = 56.dp)
                            Column {
                                Text(text = userName, style = MaterialTheme.typography.titleMedium)
                                Text(text = email, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
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

@Preview(showBackground = true)
@WgcDevicePreviews
@Composable
private fun WgcSettingsHubFactoryStandardPreview() {
    MaterialTheme {
        WgcSettingsHubFactory(type = WgcSettingsHubType.STANDARD)
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSettingsHubFactorySecurityPreview() {
    MaterialTheme {
        WgcSettingsHubFactory(type = WgcSettingsHubType.SECURITY)
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcSettingsHubFactoryPreferencesPreview() {
    MaterialTheme {
        WgcSettingsHubFactory(type = WgcSettingsHubType.PREFERENCES)
    }
}
