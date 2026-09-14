package br.com.wgc.ds_templates.screens.kutuku.auth

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Tela de Onboarding oficial do Kutuku.
 */
@Composable
fun WgcKutukuOnboardingScreen(
    modifier: Modifier = Modifier,
    imageUrl: String? = "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=600",
    title: String = "Discover Your Style",
    subtitle: String = "Explore the best and latest collections of luxury fashion, premium bags and everyday modern accessories.",
    onGetStartedClick: () -> Unit = {},
    onSignInClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(WgcCoreDsColors.kutukuBackground))
            .padding(WgcCoreDsSpacing.lg.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

        // Hero Image
        Box(
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xxl.dp))
                .background(Color(WgcCoreDsColors.kutukuPrimaryLight)),
            contentAlignment = Alignment.Center
        ) {
            if (!imageUrl.isNullOrEmpty()) {
                AsyncImageDefault(
                    image = imageUrl,
                    contentDescription = "Onboarding Kutuku",
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.ShoppingBag,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.kutukuPrimary),
                    modifier = Modifier.size(80.dp)
                )
            }
        }

        // Títulos e Descrição
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.kutukuDark),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.kutukuSecondaryText),
                textAlign = TextAlign.Center
            )
        }

        // Ações Inferiores
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onGetStartedClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.kutukuPrimary)
                )
            ) {
                Text(
                    text = "Get Started",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            TextButton(onClick = onSignInClick) {
                Text(
                    text = "Already have an account? Sign In",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.kutukuPrimary),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

/**
 * Tela de Login oficial do Kutuku.
 */
@Composable
fun WgcKutukuLoginScreen(
    modifier: Modifier = Modifier,
    emailValue: String = "",
    passwordValue: String = "",
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    onSignInClick: () -> Unit = {},
    onGoogleSignInClick: () -> Unit = {},
    onFacebookSignInClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(WgcCoreDsColors.kutukuSurface))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = WgcCoreDsSpacing.lg.dp, vertical = WgcCoreDsSpacing.xl.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

        Text(
            text = "Login Account",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.kutukuDark)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

        Text(
            text = "Please login with registered account",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(WgcCoreDsColors.kutukuSecondaryText)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

        // Campo de Email
        Text(
            text = "Email or Phone Number",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color(WgcCoreDsColors.kutukuDark)
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
        OutlinedTextField(
            value = emailValue,
            onValueChange = onEmailChange,
            placeholder = { Text("Enter your email or phone number") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.kutukuSecondaryText)
                )
            },
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(WgcCoreDsColors.kutukuPrimary),
                unfocusedBorderColor = Color(WgcCoreDsColors.kutukuBorder)
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

        // Campo de Senha
        Text(
            text = "Password",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color(WgcCoreDsColors.kutukuDark)
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
        OutlinedTextField(
            value = passwordValue,
            onValueChange = onPasswordChange,
            placeholder = { Text("Create your password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.kutukuSecondaryText)
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Alternar visibilidade da senha",
                        tint = Color(WgcCoreDsColors.kutukuSecondaryText)
                    )
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(WgcCoreDsColors.kutukuPrimary),
                unfocusedBorderColor = Color(WgcCoreDsColors.kutukuBorder)
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            Text(
                text = "Forgot Password?",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                color = Color(WgcCoreDsColors.kutukuPrimary),
                modifier = Modifier.clickable(onClick = onForgotPasswordClick)
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

        // Botão Sign In
        Button(
            onClick = onSignInClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(WgcCoreDsColors.kutukuPrimary)
            )
        ) {
            Text(
                text = "Sign In",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

        Text(
            text = "Or using other method",
            style = MaterialTheme.typography.bodySmall,
            color = Color(WgcCoreDsColors.kutukuSecondaryText),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

        // Login Social
        OutlinedButton(
            onClick = onGoogleSignInClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(WgcCoreDsColors.kutukuDark)
            )
        ) {
            Text("Sign In with Google", fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

        OutlinedButton(
            onClick = onFacebookSignInClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(WgcCoreDsColors.kutukuDark)
            )
        ) {
            Text("Sign In with Facebook", fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account? ",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.kutukuSecondaryText)
            )
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.kutukuPrimary),
                modifier = Modifier.clickable(onClick = onSignUpClick)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuOnboardingPreview() {
    WgcKutukuOnboardingScreen()
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuLoginPreview() {
    WgcKutukuLoginScreen()
}
