package br.com.wgc.design_system.factories.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcSettingsHubFactory
import br.com.wgc.design_system.templates.factories.WgcSettingsHubType
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Configurações (WgcSettingsScreenFactory).
 */
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
    val type = when (variant) {
        WgcSettingsVariant.STANDARD -> WgcSettingsHubType.STANDARD
        WgcSettingsVariant.SECURITY -> WgcSettingsHubType.SECURITY
        WgcSettingsVariant.PREFERENCES -> WgcSettingsHubType.PREFERENCES
    }

    WgcSettingsHubFactory(
        modifier = modifier,
        type = type,
        userName = userName,
        email = email,
        notificationsEnabled = notificationsEnabled,
        onToggleNotifications = onToggleNotifications,
        darkModeEnabled = darkModeEnabled,
        onToggleDarkMode = onToggleDarkMode,
        biometricsEnabled = biometricsEnabled,
        onToggleBiometrics = onToggleBiometrics,
        onLogoutClick = onLogoutClick,
        onPrivacyClick = onPrivacyClick,
        onTermsClick = onTermsClick,
        onBackClick = onBackClick,
        headerSlot = headerSlot,
        contentSlot = contentSlot,
        footerSlot = footerSlot
    )
}

@Preview(name = "WgcSettingsScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcSettingsScreenFactoryPreview() {
    WgcTheme {
        WgcSettingsScreenFactory()
    }
}
