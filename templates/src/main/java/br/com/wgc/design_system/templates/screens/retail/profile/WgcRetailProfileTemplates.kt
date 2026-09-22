package br.com.wgc.design_system.templates.screens.retail.profile

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Item individual da lista de configurações.
 */
@Composable
fun WgcKutukuSettingItem(
    icon: ImageVector,
    title: String,
    value: String? = null,
    isDestructive: Boolean = false,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl.dp))
            .background(Color(WgcCoreDsColors.retailBackground))
            .clickable(onClick = onClick)
            .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.md.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = if (isDestructive) Color(WgcCoreDsColors.retailAlertRed) else Color(WgcCoreDsColors.retailDark),
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = if (isDestructive) FontWeight.Bold else FontWeight.SemiBold,
                color = if (isDestructive) Color(WgcCoreDsColors.retailAlertRed) else Color(WgcCoreDsColors.retailDark)
            )
        }

        if (value != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
            ) {
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.retailSecondaryText)
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.retailSecondaryText),
                    modifier = Modifier.size(16.dp)
                )
            }
        } else if (!isDestructive) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.retailSecondaryText),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

/**
 * Tela de Configurações oficial do Kutuku (WgcKutukuSettingsScreen).
 */
@Composable
fun WgcKutukuSettingsScreen(
    modifier: Modifier = Modifier,
    languageValue: String = "English",
    onBackClick: () -> Unit = {},
    onEditProfileClick: () -> Unit = {},
    onChangePasswordClick: () -> Unit = {},
    onNotificationsClick: () -> Unit = {},
    onSecurityClick: () -> Unit = {},
    onLanguageClick: () -> Unit = {},
    onLegalPoliciesClick: () -> Unit = {},
    onHelpSupportClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(WgcCoreDsColors.retailSurface))
            .verticalScroll(rememberScrollState())
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
                text = "Settings",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.retailDark)
            )

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Mais opções",
                    tint = Color(WgcCoreDsColors.retailDark)
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

        // Seção General
        Text(
            text = "General",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.retailDark)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

        Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)) {
            WgcKutukuSettingItem(
                icon = Icons.Default.Person,
                title = "Edit Profile",
                onClick = onEditProfileClick
            )
            WgcKutukuSettingItem(
                icon = Icons.Default.Lock,
                title = "Change Password",
                onClick = onChangePasswordClick
            )
            WgcKutukuSettingItem(
                icon = Icons.Default.Notifications,
                title = "Notifications",
                onClick = onNotificationsClick
            )
            WgcKutukuSettingItem(
                icon = Icons.Default.Security,
                title = "Security",
                onClick = onSecurityClick
            )
            WgcKutukuSettingItem(
                icon = Icons.Default.Language,
                title = "Language",
                value = languageValue,
                onClick = onLanguageClick
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

        // Seção Preferences
        Text(
            text = "Preferences",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.retailDark)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

        Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)) {
            WgcKutukuSettingItem(
                icon = Icons.Default.Policy,
                title = "Legal and Policies",
                onClick = onLegalPoliciesClick
            )
            WgcKutukuSettingItem(
                icon = Icons.AutoMirrored.Filled.HelpOutline,
                title = "Help & Support",
                onClick = onHelpSupportClick
            )
            WgcKutukuSettingItem(
                icon = Icons.AutoMirrored.Filled.Logout,
                title = "Logout",
                isDestructive = true,
                onClick = onLogoutClick
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuSettingsScreenPreview() {
    WgcKutukuSettingsScreen()
}
