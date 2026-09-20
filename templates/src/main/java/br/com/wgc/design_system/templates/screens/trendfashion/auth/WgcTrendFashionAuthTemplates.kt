package br.com.wgc.design_system.templates.screens.trendfashion.auth

import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcSocialLoginButtons
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.fields.SimpleTextField

/**
 * Tela 6: Sign In (Login oficial do Stylish).
 * (Figma ID: 1:18612)
 */
@Composable
fun WgcStylishLoginScreenTemplate(
    modifier: Modifier = Modifier,
    usernameOrEmail: String = "",
    onUsernameOrEmailChange: (String) -> Unit = {},
    password: String = "",
    onPasswordChange: (String) -> Unit = {},
    onLoginClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onAppleClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Text(
                text = "Welcome\nBack!",
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            SimpleTextField(
                modifier = Modifier.fillMaxWidth(),
                value = usernameOrEmail,
                onValueChange = onUsernameOrEmailChange,
                label = "Username or Email",
                leadingIcon = Icons.Outlined.Person,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            SimpleTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = onPasswordChange,
                label = "Password",
                leadingIcon = Icons.Outlined.Lock,
                isPasswordField = true,
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            Text(
                text = "Forgot Password?",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionPink),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable(onClick = onForgotPasswordClick)
                    .padding(vertical = WgcCoreDsSpacing.xs.dp)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            WgcButton(
                text = "Login",
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Text(
                text = "- OR Continue with -",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.textSecondary),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            WgcSocialLoginButtons(
                onGoogleClick = onGoogleClick,
                onAppleClick = onAppleClick,
                onFacebookClick = onFacebookClick
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Create An Account ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.textSecondary)
                )
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionPink),
                    modifier = Modifier.clickable(onClick = onSignUpClick)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
        }
    }
}

/**
 * Tela 7: Sign Up (Criação de Conta).
 * (Figma ID: 1:18668)
 */
@Composable
fun WgcStylishRegisterScreenTemplate(
    modifier: Modifier = Modifier,
    usernameOrEmail: String = "",
    onUsernameOrEmailChange: (String) -> Unit = {},
    password: String = "",
    onPasswordChange: (String) -> Unit = {},
    confirmPassword: String = "",
    onConfirmPasswordChange: (String) -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onSignInClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onAppleClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Text(
                text = "Create an\naccount",
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            SimpleTextField(
                modifier = Modifier.fillMaxWidth(),
                value = usernameOrEmail,
                onValueChange = onUsernameOrEmailChange,
                label = "Username or Email",
                leadingIcon = Icons.Outlined.Person,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            SimpleTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = onPasswordChange,
                label = "Password",
                leadingIcon = Icons.Outlined.Lock,
                isPasswordField = true,
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            SimpleTextField(
                modifier = Modifier.fillMaxWidth(),
                value = confirmPassword,
                onValueChange = onConfirmPasswordChange,
                label = "Confirm Password",
                leadingIcon = Icons.Outlined.Lock,
                isPasswordField = true,
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            Text(
                text = "By clicking the Register button, you agree to the public offer",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.textSecondary)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            WgcButton(
                text = "Create Account",
                onClick = onCreateAccountClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Text(
                text = "- OR Continue with -",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.textSecondary),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            WgcSocialLoginButtons(
                onGoogleClick = onGoogleClick,
                onAppleClick = onAppleClick,
                onFacebookClick = onFacebookClick
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "I Already Have an Account ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.textSecondary)
                )
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionPink),
                    modifier = Modifier.clickable(onClick = onSignInClick)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
        }
    }
}

/**
 * Tela 8: Forgot Password (Recuperação de Senha).
 * (Figma ID: 1:18585)
 */
@Composable
fun WgcStylishForgotPasswordScreenTemplate(
    modifier: Modifier = Modifier,
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    onSubmitClick: () -> Unit = {},
    onBackToLoginClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Forgot\npassword?",
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            SimpleTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = onEmailChange,
                label = "Enter your email address",
                leadingIcon = Icons.Outlined.Email,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            Text(
                text = "* We will send you a message to set or reset your new password",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.textSecondary)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            WgcButton(
                text = "Submit",
                onClick = onSubmitClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            Text(
                text = "Back to Login",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionPink),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onBackToLoginClick)
                    .padding(vertical = WgcCoreDsSpacing.xs.dp)
            )
        }
    }
}

@Preview(name = "Login Screen Preview", showBackground = true)
@Composable
private fun WgcStylishLoginScreenPreview() {
    var email by remember { mutableStateOf("gabriel@example.com") }
    var password by remember { mutableStateOf("123456") }
    WgcStylishLoginScreenTemplate(
        usernameOrEmail = email,
        onUsernameOrEmailChange = { email = it },
        password = password,
        onPasswordChange = { password = it }
    )
}

@Preview(name = "Register Screen Preview", showBackground = true)
@Composable
private fun WgcStylishRegisterScreenPreview() {
    WgcStylishRegisterScreenTemplate()
}

@Preview(name = "Forgot Password Preview", showBackground = true)
@Composable
private fun WgcStylishForgotPasswordPreview() {
    WgcStylishForgotPasswordScreenTemplate()
}
