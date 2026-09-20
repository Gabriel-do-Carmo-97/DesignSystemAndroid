package br.com.wgc.design_system.navigation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcBrandAuthHeader
import br.com.wgc.design_system.components.auth.WgcOtpCodeInput
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import kotlinx.serialization.Serializable

@Serializable
object WgcAuthGraphRoute

@Serializable
object WgcAuthLoginRoute

@Serializable
object WgcAuthRegisterRoute

@Serializable
object WgcAuthForgotPasswordRoute

@Serializable
data class WgcAuthOtpRoute(val emailOrPhone: String = "seu e-mail")

/**
 * Grafo de navegação completo para fluxos de autenticação (WgcAuthNavGraph).
 *
 * @param navController Controlador de navegação do Compose.
 * @param onAuthSuccess Callback disparado quando o fluxo de autenticação é concluído com êxito.
 * @param startDestination Rota inicial dentro do grafo.
 */
fun NavGraphBuilder.wgcAuthNavGraph(
    navController: NavController,
    onAuthSuccess: () -> Unit,
    startDestination: Any = WgcAuthLoginRoute
) {
    navigation<WgcAuthGraphRoute>(startDestination = startDestination) {
        composable<WgcAuthLoginRoute> {
            WgcLoginNavScreen(
                onNavigateToRegister = {
                    navController.navigate(WgcAuthRegisterRoute)
                },
                onNavigateToForgotPassword = {
                    navController.navigate(WgcAuthForgotPasswordRoute)
                },
                onLoginSuccess = onAuthSuccess
            )
        }

        composable<WgcAuthRegisterRoute> {
            WgcRegisterNavScreen(
                onNavigateToLogin = {
                    navController.popBackStack()
                },
                onRegisterSuccess = { email ->
                    navController.navigate(WgcAuthOtpRoute(emailOrPhone = email))
                }
            )
        }

        composable<WgcAuthForgotPasswordRoute> {
            WgcForgotPasswordNavScreen(
                onNavigateToLogin = {
                    navController.popBackStack()
                },
                onResetCodeSent = { email ->
                    navController.navigate(WgcAuthOtpRoute(emailOrPhone = email))
                }
            )
        }

        composable<WgcAuthOtpRoute> {
            WgcOtpNavScreen(
                onOtpVerified = onAuthSuccess,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
private fun WgcLoginNavScreen(
    onNavigateToRegister: () -> Unit,
    onNavigateToForgotPassword: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WgcBrandAuthHeader(
                brandName = "WGC",
                brandLogoText = "W",
                brandColor = MaterialTheme.colorScheme.primary,
                title = "Bem-vindo de volta",
                subtitle = "Informe seus dados para acessar sua conta corporativa"
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            SimpleTextField(
                label = "E-mail ou CPF",
                placeholderText = "seu.email@empresa.com",
                value = email,
                onValueChange = { email = it },
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            SimpleTextField(
                label = "Senha",
                placeholderText = "Digite sua senha",
                value = password,
                onValueChange = { password = it },
                isPasswordField = true
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            TextButton(
                onClick = onNavigateToForgotPassword,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = "Esqueci minha senha",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            WgcClassicButton(
                textButton = "Entrar",
                onClick = onLoginSuccess,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            TextButton(onClick = onNavigateToRegister) {
                Text(
                    text = "Não tem uma conta? Cadastre-se",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun WgcRegisterNavScreen(
    onNavigateToLogin: () -> Unit,
    onRegisterSuccess: (email: String) -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WgcBrandAuthHeader(
                brandName = "WGC",
                brandLogoText = "W",
                brandColor = MaterialTheme.colorScheme.primary,
                title = "Criar nova conta",
                subtitle = "Preencha as informações para iniciar seu cadastro"
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            SimpleTextField(
                label = "Nome Completo",
                placeholderText = "Seu nome",
                value = fullName,
                onValueChange = { fullName = it }
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            SimpleTextField(
                label = "E-mail corporativo",
                placeholderText = "seu.email@empresa.com",
                value = email,
                onValueChange = { email = it },
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            SimpleTextField(
                label = "Senha de acesso",
                placeholderText = "Mínimo 8 caracteres",
                value = password,
                onValueChange = { password = it },
                isPasswordField = true
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            WgcClassicButton(
                textButton = "Continuar",
                onClick = { onRegisterSuccess(email.ifBlank { "seu e-mail" }) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            TextButton(onClick = onNavigateToLogin) {
                Text(
                    text = "Já possui uma conta? Faça login",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun WgcForgotPasswordNavScreen(
    onNavigateToLogin: () -> Unit,
    onResetCodeSent: (email: String) -> Unit
) {
    var email by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WgcBrandAuthHeader(
                brandName = "WGC",
                brandLogoText = "W",
                brandColor = MaterialTheme.colorScheme.primary,
                title = "Recuperar senha",
                subtitle = "Enviaremos um código de verificação para o seu e-mail cadastrado"
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            SimpleTextField(
                label = "E-mail de recuperação",
                placeholderText = "seu.email@empresa.com",
                value = email,
                onValueChange = { email = it },
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            WgcClassicButton(
                textButton = "Enviar código",
                onClick = { onResetCodeSent(email.ifBlank { "seu e-mail" }) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            TextButton(onClick = onNavigateToLogin) {
                Text(
                    text = "Lembrou sua senha? Fazer login",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun WgcOtpNavScreen(
    onOtpVerified: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var otpCode by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WgcBrandAuthHeader(
                brandName = "WGC",
                brandLogoText = "W",
                brandColor = MaterialTheme.colorScheme.primary,
                title = "Código de Validação",
                subtitle = "Digite o código numérico enviado para validar seu acesso"
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            WgcOtpCodeInput(
                otpCode = otpCode,
                onOtpCodeChange = { otpCode = it }
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            WgcClassicButton(
                textButton = "Validar e Entrar",
                onClick = onOtpVerified,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            TextButton(onClick = onNavigateBack) {
                Text(
                    text = "Voltar",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
