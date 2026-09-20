package br.com.wgc.design_system.templates.screens.community.wave

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcBiometricButton
import br.com.wgc.design_system.components.auth.WgcBiometricStyle
import br.com.wgc.design_system.components.auth.WgcSocialLoginButtons
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Estado de UI do Template 1 do Figma (Clean Wave Auth).
 */
data class WaveAuthUiState(
    val email: String = "",
    val password: String = "",
    val rememberPassword: Boolean = true,
    val selectedTab: Int = 0,
    val isLoading: Boolean = false
)

/**
 * Contrato de ViewModel para o Template Wave Auth.
 */
abstract class BaseWaveAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<WaveAuthUiState>
    abstract fun onEmailChange(email: String)
    abstract fun onPasswordChange(password: String)
    abstract fun onRememberPasswordChange(remember: Boolean)
    abstract fun onTabSelected(tabIndex: Int)
    abstract fun onSubmit()
    abstract fun onBiometricAuth()
}

/**
 * Implementação Fake do ViewModel para Preview e uso imediato com defaults sensatos.
 */
class FakeWaveAuthViewModel : BaseWaveAuthViewModel() {
    override val uiState: StateFlow<WaveAuthUiState> = MutableStateFlow(WaveAuthUiState()).asStateFlow()
    override fun onEmailChange(email: String) {}
    override fun onPasswordChange(password: String) {}
    override fun onRememberPasswordChange(remember: Boolean) {}
    override fun onTabSelected(tabIndex: Int) {}
    override fun onSubmit() {}
    override fun onBiometricAuth() {}
}

/**
 * Template 1 do Figma: Clean Wave Auth (Tela de Login com Onda Inferior e Biometria).
 */
@Composable
fun WgcWaveAuthScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseWaveAuthViewModel = FakeWaveAuthViewModel(),
    onNavigateToForgotPassword: () -> Unit = {},
    onTermsClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    biometricSlot: (@Composable () -> Unit)? = null,
    socialSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Seção Superior do Formulário
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                    .padding(top = WgcCoreDsSpacing.xl32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                // Header Slot
                if (headerSlot != null) {
                    headerSlot()
                } else {
                    Text(
                        text = if (state.selectedTab == 0) "Login" else "Register",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "By signing in you are agreeing our Term and privacy policy",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Tab Switcher (Login / Register)
                @Suppress("DEPRECATION")
                TabRow(
                    selectedTabIndex = state.selectedTab,
                    modifier = Modifier.fillMaxWidth(0.6f),
                    indicator = { tabPositions ->
                        SecondaryIndicator(
                            Modifier.tabIndicatorOffset(tabPositions[state.selectedTab]),
                            color = MaterialTheme.colorScheme.primary
                        )
                    },
                    divider = {}
                ) {
                    Tab(
                        selected = state.selectedTab == 0,
                        onClick = { viewModel.onTabSelected(0) },
                        text = {
                            Text(
                                "Login",
                                fontWeight = if (state.selectedTab == 0) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    )
                    Tab(
                        selected = state.selectedTab == 1,
                        onClick = { viewModel.onTabSelected(1) },
                        text = {
                            Text(
                                "Register",
                                fontWeight = if (state.selectedTab == 1) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                // Campos de Entrada
                SimpleTextField(
                    value = state.email,
                    onValueChange = viewModel::onEmailChange,
                    label = "Email Address",
                    placeholderText = "Enter your email",
                    leadingIcon = Icons.Default.Email
                )

                SimpleTextField(
                    value = state.password,
                    onValueChange = viewModel::onPasswordChange,
                    label = "Password",
                    placeholderText = "Enter your password",
                    leadingIcon = Icons.Default.Lock,
                    isPasswordField = true
                )

                // Opções: Remember password + Forget password
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            viewModel.onRememberPasswordChange(!state.rememberPassword)
                        }
                    ) {
                        Checkbox(
                            checked = state.rememberPassword,
                            onCheckedChange = viewModel::onRememberPasswordChange
                        )
                        Text(
                            text = "Remember password",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    TextButton(onClick = onNavigateToForgotPassword) {
                        Text(
                            text = "Forget password",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                // Botão Primário
                WgcButton(
                    text = if (state.selectedTab == 0) "Login" else "Register",
                    onClick = viewModel::onSubmit,
                    isLoading = state.isLoading
                )

                // Divisor Social
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(modifier = Modifier.weight(1f))
                    Text(
                        text = "  or connect with  ",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f))
                }

                // Social Slot
                if (socialSlot != null) {
                    socialSlot()
                } else {
                    WgcSocialLoginButtons()
                }
            }

            Spacer(modifier = Modifier.weight(1f, fill = false).height(32.dp))

            // Footer Wave com Biometria
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.85f),
                        shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp)
                    )
                    .padding(vertical = WgcCoreDsSpacing.lg24.dp),
                contentAlignment = Alignment.Center
            ) {
                if (biometricSlot != null) {
                    biometricSlot()
                } else {
                    WgcBiometricButton(
                        label = "Login with touch",
                        style = WgcBiometricStyle.Circular,
                        containerColor = MaterialTheme.colorScheme.surface,
                        iconTint = MaterialTheme.colorScheme.primary,
                        onClick = viewModel::onBiometricAuth
                    )
                }
            }
        }
    }
}

@Preview(name = "WgcWaveAuthScreenTemplate", showBackground = true)
@Composable
private fun WgcWaveAuthPreview() {
    MaterialTheme {
        WgcWaveAuthScreenTemplate()
    }
}
