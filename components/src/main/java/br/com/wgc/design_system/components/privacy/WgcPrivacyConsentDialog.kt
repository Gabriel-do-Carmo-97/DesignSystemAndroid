@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.privacy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Preferências de consentimento LGPD / GDPR.
 */
data class WgcPrivacyPreferences(
    val analyticsAccepted: Boolean = false,
    val marketingAccepted: Boolean = false
)

/**
 * WgcPrivacyConsentDialog
 *
 * Diálogo corporativo de consentimento de privacidade e cookies (LGPD / GDPR) com opt-in granular.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcPrivacyConsentDialog(
    isOpen: Boolean,
    preferences: WgcPrivacyPreferences,
    onPreferencesChange: (WgcPrivacyPreferences) -> Unit,
    onAcceptAll: () -> Unit,
    onConfirmSelection: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (!isOpen) return

    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier
    ) {
        Surface(
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.lg.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
            ) {
                Text(
                    text = "Privacidade e Proteção de Dados",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "Utilizamos cookies e dados de navegação para aprimorar sua experiência e fornecer serviços personalizados de acordo com a LGPD.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Cookies Analíticos", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                        Text(text = "Nos ajudam a entender como o app é utilizado.", style = MaterialTheme.typography.bodySmall)
                    }
                    Switch(
                        checked = preferences.analyticsAccepted,
                        onCheckedChange = { onPreferencesChange(preferences.copy(analyticsAccepted = it)) }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Comunicações e Marketing", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                        Text(text = "Permite enviar ofertas e novidades relevantes.", style = MaterialTheme.typography.bodySmall)
                    }
                    Switch(
                        checked = preferences.marketingAccepted,
                        onCheckedChange = { onPreferencesChange(preferences.copy(marketingAccepted = it)) }
                    )
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
                ) {
                    WgcClassicButton(
                        text = "Aceitar Todos",
                        onClick = onAcceptAll,
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextButton(
                        onClick = onConfirmSelection,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Salvar Preferências")
                    }
                }
            }
        }
    }
}
