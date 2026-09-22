package br.com.wgc.design_system.templates.screens.megastore.auth

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.auth.WgcOtpCodeInput
import br.com.wgc.design_system.components.auth.WgcSocialLoginButtons
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.buttons.WgcButtonVariant
import br.com.wgc.design_system.components.fields.SimpleTextField

/**
 * Telas 01 a 06: Autenticação Shoppe (Start, Login, Create Account, Password, Erro).
 */
@Composable
fun WgcShoppeStartScreenTemplate(
    modifier: Modifier = Modifier,
    onGetStartedClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.megaStorePrimaryLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = "Shoppe Logo",
                        tint = Color(WgcCoreDsColors.megaStorePrimary),
                        modifier = Modifier.size(48.dp)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

                Text(
                    text = "Shoppe",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Black),
                    color = Color(WgcCoreDsColors.megaStoreDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

                Text(
                    text = "Beautiful eCommerce Clothing & Fashion Store App",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.megaStoreSecondaryText),
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
            ) {
                WgcButton(
                    text = "Get Started",
                    onClick = onGetStartedClick
                )

                WgcButton(
                    text = "I already have an account",
                    variant = WgcButtonVariant.Ghost,
                    onClick = onLoginClick
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
            }
        }
    }
}

@Composable
fun WgcShoppeLoginScreenTemplate(
    modifier: Modifier = Modifier,
    emailOrPhone: String = "",
    onEmailOrPhoneChange: (String) -> Unit = {},
    onContinueClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {}
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
                text = "Login",
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Black),
                color = Color(WgcCoreDsColors.megaStoreDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            Text(
                text = "Good to see you back! Please enter your details.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.megaStoreSecondaryText)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            SimpleTextField(
                modifier = Modifier.fillMaxWidth(),
                value = emailOrPhone,
                onValueChange = onEmailOrPhoneChange,
                label = "Email or Phone Number",
                leadingIcon = Icons.Default.Person,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            WgcButton(
                text = "Next",
                onClick = onContinueClick
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            WgcSocialLoginButtons(
                onGoogleClick = onGoogleClick
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don't have an account? ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.megaStoreSecondaryText)
                )
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.megaStorePrimary),
                    modifier = Modifier.clickable(onClick = onCreateAccountClick)
                )
            }
        }
    }
}

@Composable
fun WgcShoppePasswordScreenTemplate(
    modifier: Modifier = Modifier,
    password: String = "",
    onPasswordChange: (String) -> Unit = {},
    isWrongPasswordError: Boolean = false,
    onLoginClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
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
                text = "Enter Password",
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Black),
                color = Color(WgcCoreDsColors.megaStoreDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            Text(
                text = "Enter your secret account password to proceed.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.megaStoreSecondaryText)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            SimpleTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = onPasswordChange,
                label = "Password",
                leadingIcon = Icons.Default.Lock,
                isPasswordField = true,
                isError = isWrongPasswordError,
                errorMessage = "Incorrect password. Please try again.",
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            Text(
                text = "Forgot Password?",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.megaStorePrimary),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable(onClick = onForgotPasswordClick)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            WgcButton(
                text = "Continue",
                onClick = onLoginClick
            )
        }
    }
}

@Composable
fun WgcShoppeOtpRecoveryScreenTemplate(
    modifier: Modifier = Modifier,
    onOtpChange: (String) -> Unit = {},
    onSubmitClick: () -> Unit = {},
    onResendClick: () -> Unit = {}
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.megaStorePrimaryLight)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.megaStorePrimary),
                    modifier = Modifier.size(36.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            Text(
                text = "Password Recovery",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Black),
                color = Color(WgcCoreDsColors.megaStoreDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            Text(
                text = "Enter the 4-digit code sent to your registered email.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.megaStoreSecondaryText),
                textAlign = TextAlign.Center
            )

            var code by remember { mutableStateOf("") }
            WgcOtpCodeInput(
                otpCode = code,
                onOtpCodeChange = {
                    code = it
                    onOtpChange(it)
                }
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            WgcButton(
                text = "Verify Code",
                onClick = onSubmitClick
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            TextButton(onClick = onResendClick) {
                Text(
                    text = "Resend Code",
                    color = Color(WgcCoreDsColors.megaStorePrimary),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeStartScreenTemplatePreview() {
    MaterialTheme {
        WgcShoppeStartScreenTemplate()
    }
}
