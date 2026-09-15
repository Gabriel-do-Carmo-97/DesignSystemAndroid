package br.com.wgc.ds_templates.screens.community.split

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcBiometricButton
import br.com.wgc.design_system.components.auth.WgcBiometricStyle
import br.com.wgc.design_system.components.auth.WgcSocialLoginButtons
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Estado de UI do Template 2 do Figma (Split Diagonal Card Auth).
 */
data class SplitCardAuthUiState(
    val email: String = "",
    val password: String = "",
    val rememberPassword: Boolean = true,
    val isLoading: Boolean = false
)

/**
 * Contrato de ViewModel para o Template Split Card.
 */
abstract class BaseSplitCardAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<SplitCardAuthUiState>
    abstract fun onEmailChange(email: String)
    abstract fun onPasswordChange(password: String)
    abstract fun onRememberPasswordChange(remember: Boolean)
    abstract fun onLoginSubmit()
    abstract fun onRegisterSubmit()
    abstract fun onBiometricAuth()
}

/**
 * Fake ViewModel para Template Split Card.
 */
class FakeSplitCardAuthViewModel : BaseSplitCardAuthViewModel() {
    override val uiState: StateFlow<SplitCardAuthUiState> = MutableStateFlow(SplitCardAuthUiState()).asStateFlow()
    override fun onEmailChange(email: String) {}
    override fun onPasswordChange(password: String) {}
    override fun onRememberPasswordChange(remember: Boolean) {}
    override fun onLoginSubmit() {}
    override fun onRegisterSubmit() {}
    override fun onBiometricAuth() {}
}

/**
 * Template 2 do Figma: Split Diagonal Card Auth (Tela com Card Superior e Ações Divididas).
 */
@Composable
fun WgcSplitCardAuthScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseSplitCardAuthViewModel = FakeSplitCardAuthViewModel(),
    onNavigateToForgotPassword: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    actionsSlot: (@Composable () -> Unit)? = null,
    biometricSlot: (@Composable () -> Unit)? = null,
    socialSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f))
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header Ilustrado
            if (headerSlot != null) {
                headerSlot()
            } else {
                Surface(
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                    modifier = Modifier.padding(top = WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Group,
                            contentDescription = "Team",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Work Together",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Text(
                    text = "Welcome",
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

            // Card Superior do Formulário
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level3.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.lg24.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
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
                        placeholderText = "Enter password",
                        leadingIcon = Icons.Default.Lock,
                        isPasswordField = true
                    )

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
                }
            }

            // Link Forget Password
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                TextButton(onClick = onNavigateToForgotPassword) {
                    Text(
                        text = "Forget password",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // Ações Principais (Botões Lado a Lado ou Custom Slot)
            if (actionsSlot != null) {
                actionsSlot()
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    WgcButton(
                        modifier = Modifier.weight(1f),
                        text = "Login",
                        onClick = viewModel::onLoginSubmit,
                        isLoading = state.isLoading
                    )
                    OutlinedButton(
                        modifier = Modifier.weight(1f).height(56.dp),
                        onClick = viewModel::onRegisterSubmit,
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Register",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Biometria
            if (biometricSlot != null) {
                biometricSlot()
            } else {
                WgcBiometricButton(
                    label = "Login with touch ID",
                    style = WgcBiometricStyle.RoundedSquare,
                    containerColor = MaterialTheme.colorScheme.surface,
                    iconTint = MaterialTheme.colorScheme.primary,
                    onClick = viewModel::onBiometricAuth
                )
            }

            // Social Connect
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = WgcCoreDsSpacing.xs8.dp),
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

            if (socialSlot != null) {
                socialSlot()
            } else {
                WgcSocialLoginButtons()
            }
        }
    }
}

@Preview(name = "WgcSplitCardAuthScreenTemplate", showBackground = true)
@Composable
private fun WgcSplitCardAuthPreview() {
    MaterialTheme {
        WgcSplitCardAuthScreenTemplate()
    }
}
