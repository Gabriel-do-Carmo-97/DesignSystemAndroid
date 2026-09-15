package br.com.wgc.ds_templates.screens.community.klok

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcBiometricButton
import br.com.wgc.design_system.components.auth.WgcBiometricStyle
import br.com.wgc.design_system.components.auth.WgcSocialLoginPillGroup
import br.com.wgc.design_system.components.buttons.WgcPillTabSwitch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Estado de UI do Template 3 do Figma (Modern Klok Auth).
 */
data class KlokAuthUiState(
    val email: String = "",
    val password: String = "",
    val rememberPassword: Boolean = true,
    val selectedTab: Int = 0,
    val isLoading: Boolean = false
)

/**
 * Contrato de ViewModel para o Template Klok Auth.
 */
abstract class BaseKlokAuthViewModel : ViewModel() {
    abstract val uiState: StateFlow<KlokAuthUiState>
    abstract fun onEmailChange(email: String)
    abstract fun onPasswordChange(password: String)
    abstract fun onRememberPasswordChange(remember: Boolean)
    abstract fun onTabSelected(tabIndex: Int)
    abstract fun onSubmit()
    abstract fun onBiometricAuth()
    abstract fun onSocialLogin(providerName: String)
}

/**
 * Fake ViewModel para Template Klok Auth.
 */
class FakeKlokAuthViewModel : BaseKlokAuthViewModel() {
    override val uiState: StateFlow<KlokAuthUiState> = MutableStateFlow(KlokAuthUiState()).asStateFlow()
    override fun onEmailChange(email: String) {}
    override fun onPasswordChange(password: String) {}
    override fun onRememberPasswordChange(remember: Boolean) {}
    override fun onTabSelected(tabIndex: Int) {}
    override fun onSubmit() {}
    override fun onBiometricAuth() {}
    override fun onSocialLogin(providerName: String) {}
}

/**
 * Template 3 do Figma: Modern Klok Brand Auth (Tela com Estilo Pill, Marca Klok e Botões Sociais em Barra).
 */
@Composable
fun WgcKlokAuthScreenTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseKlokAuthViewModel = FakeKlokAuthViewModel(),
    brandPrimaryColor: Color = Color(0xFFFF9800),
    onNavigateToForgotPassword: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    switcherSlot: (@Composable () -> Unit)? = null,
    biometricSlot: (@Composable () -> Unit)? = null,
    socialSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.lg24.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header com Marca Klok
            if (headerSlot != null) {
                headerSlot()
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = WgcCoreDsSpacing.md16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (state.selectedTab == 0) "Login" else "Register",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = brandPrimaryColor
                        )
                        Text(
                            text = "By signing in you are agreeing our Term and privacy policy",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    // Logo KLOK
                    Surface(
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        color = brandPrimaryColor.copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, brandPrimaryColor.copy(alpha = 0.3f)),
                        modifier = Modifier.padding(start = WgcCoreDsSpacing.md16.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Schedule,
                                contentDescription = "KLOK Logo",
                                tint = brandPrimaryColor,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "KLOK",
                                fontWeight = FontWeight.Bold,
                                color = brandPrimaryColor,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Inputs em formato Pill
            OutlinedTextField(
                value = state.email,
                onValueChange = viewModel::onEmailChange,
                modifier = Modifier.fillMaxWidth(),
                shape = CircleShape,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                placeholder = { Text("Email Address") },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                    focusedContainerColor = MaterialTheme.colorScheme.surface
                )
            )

            OutlinedTextField(
                value = state.password,
                onValueChange = viewModel::onPasswordChange,
                modifier = Modifier.fillMaxWidth(),
                shape = CircleShape,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                placeholder = { Text("Password") },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                    focusedContainerColor = MaterialTheme.colorScheme.surface
                )
            )

            // Opções
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

            // Dual Pill Switcher (Login / Register)
            if (switcherSlot != null) {
                switcherSlot()
            } else {
                WgcPillTabSwitch(
                    selectedIndex = state.selectedTab,
                    onTabSelected = viewModel::onTabSelected,
                    tabs = listOf("Login", "Register"),
                    activeColor = brandPrimaryColor
                )
            }

            // Biometria
            Box(
                modifier = Modifier.fillMaxWidth().padding(top = WgcCoreDsSpacing.xs8.dp),
                contentAlignment = Alignment.Center
            ) {
                if (biometricSlot != null) {
                    biometricSlot()
                } else {
                    WgcBiometricButton(
                        label = "Login with touch ID",
                        style = WgcBiometricStyle.OutlinedSquare,
                        containerColor = MaterialTheme.colorScheme.surface,
                        iconTint = brandPrimaryColor,
                        borderColor = brandPrimaryColor.copy(alpha = 0.5f),
                        onClick = viewModel::onBiometricAuth
                    )
                }
            }

            // Social Connect Full-Width
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

            if (socialSlot != null) {
                socialSlot()
            } else {
                WgcSocialLoginPillGroup(
                    onFacebookClick = { viewModel.onSocialLogin("Facebook") },
                    onInstagramClick = { viewModel.onSocialLogin("Instagram") },
                    onLinkedInClick = { viewModel.onSocialLogin("LinkedIn") }
                )
            }
        }
    }
}

@Preview(name = "WgcKlokAuthScreenTemplate", showBackground = true)
@Composable
private fun WgcKlokAuthPreview() {
    MaterialTheme {
        WgcKlokAuthScreenTemplate()
    }
}
