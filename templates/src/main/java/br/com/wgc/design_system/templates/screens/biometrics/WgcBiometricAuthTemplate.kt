@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.templates.screens.biometrics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estado da tela de autenticação biométrica.
 */
data class WgcBiometricAuthUiState(
    val title: String = "Autenticação Rápida",
    val subtitle: String = "Toque no sensor de impressão digital para desbloquear",
    val isAuthenticating: Boolean = false,
    val errorMessage: String? = null
)

/**
 * ViewModel aberto para autenticação biométrica com callbacks para evitar subclasses anônimas em release.
 */
open class FakeBiometricAuthViewModel(
    private val onBiometricTrigger: () -> Unit = {},
    private val onFallbackPinTrigger: () -> Unit = {}
) {
    var uiState by mutableStateOf(WgcBiometricAuthUiState())

    open fun authenticate() {
        onBiometricTrigger()
    }

    open fun usePinFallback() {
        onFallbackPinTrigger()
    }
}

/**
 * Template corporativo para autenticação biométrica (WgcBiometricAuthTemplate).
 */
@Composable
fun WgcBiometricAuthTemplate(
    uiState: WgcBiometricAuthUiState,
    onTriggerBiometrics: () -> Unit,
    onUsePinFallback: () -> Unit,
    modifier: Modifier = Modifier,
    customIllustrationSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.xl.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
            ) {
                Text(
                    text = uiState.title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = uiState.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }

            Box(contentAlignment = Alignment.Center) {
                customIllustrationSlot?.invoke() ?: IconButton(
                    onClick = onTriggerBiometrics,
                    modifier = Modifier.size(120.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Fingerprint,
                        contentDescription = "Autenticar via biometria",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(96.dp)
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (uiState.errorMessage != null) {
                    Text(
                        text = uiState.errorMessage,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center
                    )
                }

                WgcClassicButton(
                    text = "Autenticar",
                    onClick = onTriggerBiometrics,
                    modifier = Modifier.fillMaxWidth()
                )

                TextButton(onClick = onUsePinFallback) {
                    Text(
                        text = "Usar senha numérica (PIN)",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
