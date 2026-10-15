package br.com.wgc.design_system.factories.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Perfil (WgcProfileScreenFactory).
 */
@Composable
fun WgcProfileScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcProfileVariant = WgcProfileVariant.STANDARD,
    userName: String = "Gabriel do Carmo",
    userEmail: String = "usuario@wgc.com.br",
    headerSlot: (@Composable () -> Unit)? = null,
    menuSlot: (@Composable () -> Unit)? = null,
    onLogoutClick: () -> Unit = {}
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            headerSlot?.invoke() ?: DefaultProfileHeader(
                name = userName,
                email = userEmail,
                variant = variant
            )

            menuSlot?.invoke() ?: DefaultProfileMenu(onLogoutClick = onLogoutClick)
        }
    }
}

@Composable
private fun DefaultProfileHeader(
    name: String,
    email: String,
    variant: WgcProfileVariant = WgcProfileVariant.STANDARD
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcAvatar(initials = name.take(2))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(text = email, style = MaterialTheme.typography.bodyMedium)
                if (variant != WgcProfileVariant.STANDARD) {
                    Text(
                        text = variant.name.replace("_", " ").lowercase().replaceFirstChar { it.uppercase() },
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
private fun DefaultProfileMenu(onLogoutClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp)
    ) {
        Column {
            ProfileMenuRow(Icons.Default.Person, "Dados Pessoais")
            HorizontalDivider()
            ProfileMenuRow(Icons.Default.LocationOn, "Endereços Cadastrados")
            HorizontalDivider()
            ProfileMenuRow(Icons.Default.CreditCard, "Formas de Pagamento")
            HorizontalDivider()
            ProfileMenuRow(Icons.Default.Notifications, "Notificações")
            HorizontalDivider()
            ProfileMenuRow(Icons.AutoMirrored.Filled.HelpOutline, "Ajuda e Suporte")
            HorizontalDivider()
            ProfileMenuRow(Icons.AutoMirrored.Filled.Logout, "Sair da Conta", onClick = onLogoutClick)
        }
    }
}

@Composable
private fun ProfileMenuRow(icon: ImageVector, title: String, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = WgcCoreDsSpacing.sm12.dp)
        )
        Icon(
            Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outline
        )
    }
}

@Preview(name = "WgcProfileScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcProfileScreenFactoryPreview() {
    WgcTheme {
        WgcProfileScreenFactory()
    }
}
