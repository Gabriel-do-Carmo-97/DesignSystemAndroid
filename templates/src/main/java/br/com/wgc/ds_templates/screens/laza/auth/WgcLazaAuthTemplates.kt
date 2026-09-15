package br.com.wgc.ds_templates.screens.laza.auth

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcLazaBottomNavButton

/**
 * Tela de introdução/onboarding oficial do Laza (WgcLazaIntroScreenTemplate).
 * Apresenta superfície na cor primária (#9775FA) e card inferior branco com seletores de gênero e CTA.
 */
@Composable
fun WgcLazaIntroScreenTemplate(
    modifier: Modifier = Modifier,
    selectedGender: String = "Men",
    onGenderSelected: (String) -> Unit = {},
    onGetStartedClick: () -> Unit = {},
    onSkipClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Bottom
        ) {
            // Card inferior branco com cantos superiores arredondados
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = WgcCoreDsBorderRadius.xxl24.dp,
                            topEnd = WgcCoreDsBorderRadius.xxl24.dp
                        )
                    )
                    .background(Color.White)
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp, vertical = WgcCoreDsSpacing.xl32.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Look Good, Feel Good",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.lazaDark),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Text(
                        text = "Create your individual unique style and look amazing everyday.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.lazaSecondaryText),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                    // Seletores Men e Women
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        listOf("Men", "Women").forEach { gender ->
                            val isSelected = gender == selectedGender
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(WgcCoreDsSize.s52.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                    .background(
                                        if (isSelected) Color(WgcCoreDsColors.lazaPrimary)
                                        else Color(WgcCoreDsColors.lazaSurface)
                                    )
                                    .clickable { onGenderSelected(gender) },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = gender,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else Color(WgcCoreDsColors.lazaSecondaryText)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                    Button(
                        onClick = onGetStartedClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s52.dp),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.lazaPrimary)
                        )
                    ) {
                        Text(
                            text = "Get Started",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    TextButton(onClick = onSkipClick) {
                        Text(
                            text = "Skip",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.lazaSecondaryText)
                        )
                    }
                }
            }
        }
    }
}

/**
 * Tela de boas-vindas e login social do Laza (WgcLazaSignInScreenTemplate).
 */
@Composable
fun WgcLazaSignInTemplate(
    modifier: Modifier = Modifier,
    onFacebookClick: () -> Unit = {},
    onTwitterClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onEmailSignInClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    WgcLazaSignInScreenTemplate(
        modifier = modifier,
        onFacebookClick = onFacebookClick,
        onTwitterClick = onTwitterClick,
        onGoogleClick = onGoogleClick,
        onEmailSignInClick = onEmailSignInClick,
        onCreateAccountClick = onCreateAccountClick,
        onBackClick = onBackClick
    )
}

@Composable
fun WgcLazaSignInScreenTemplate(
    modifier: Modifier = Modifier,
    onFacebookClick: () -> Unit = {},
    onTwitterClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onEmailSignInClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            WgcLazaBottomNavButton(
                label = "Create An Account",
                onClick = onCreateAccountClick
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .size(WgcCoreDsSize.s40.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.lazaSurface))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color(WgcCoreDsColors.lazaDark)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            Text(
                text = "Let's Get Started",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.lazaDark),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxl40.dp))

            // Botões sociais
            LazaSocialButton(
                text = "Facebook",
                bgColor = Color(WgcCoreDsColors.lazaFacebook),
                textColor = Color.White,
                onClick = onFacebookClick
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            LazaSocialButton(
                text = "Twitter",
                bgColor = Color(WgcCoreDsColors.lazaTwitter),
                textColor = Color.White,
                onClick = onTwitterClick
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            LazaSocialButton(
                text = "Google",
                bgColor = Color(WgcCoreDsColors.lazaGoogle),
                textColor = Color.White,
                onClick = onGoogleClick
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            LazaSocialButton(
                text = "Sign in with Email",
                bgColor = Color(WgcCoreDsColors.lazaSurface),
                textColor = Color(WgcCoreDsColors.lazaDark),
                onClick = onEmailSignInClick
            )
        }
    }
}

/**
 * Botão social retangular com cantos arredondados (10dp) conforme o kit Laza.
 */
@Composable
private fun LazaSocialButton(
    text: String,
    bgColor: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(WgcCoreDsSize.s52.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = textColor
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/**
 * Tela de login com Email e Senha do Laza (WgcLazaEmailSignInTemplate).
 */
@Composable
fun WgcLazaEmailSignInTemplate(
    modifier: Modifier = Modifier,
    usernameOrEmail: String = "",
    password: String = "",
    rememberMe: Boolean = true,
    onUsernameOrEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onRememberMeChange: (Boolean) -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
    onSignInClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            WgcLazaBottomNavButton(
                label = "Login",
                onClick = {
                    onLoginClick()
                    onSignInClick()
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .size(WgcCoreDsSize.s40.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.lazaSurface))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color(WgcCoreDsColors.lazaDark)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            Text(
                text = "Welcome",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.lazaDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            Text(
                text = "Please enter your data to continue",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.lazaSecondaryText)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxl48.dp))

            // Campo de Usuário
            Text(
                text = "Username",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.lazaSecondaryText)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            OutlinedTextField(
                value = usernameOrEmail,
                onValueChange = onUsernameOrEmailChange,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Esther Howard", color = Color(WgcCoreDsColors.lazaSecondaryText)) },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(WgcCoreDsColors.lazaSurface),
                    unfocusedContainerColor = Color(WgcCoreDsColors.lazaSurface),
                    focusedBorderColor = Color(WgcCoreDsColors.lazaPrimary),
                    unfocusedBorderColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Campo de Senha
            Text(
                text = "Password",
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.lazaSecondaryText)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("••••••••••••", color = Color(WgcCoreDsColors.lazaSecondaryText)) },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(WgcCoreDsColors.lazaSurface),
                    unfocusedContainerColor = Color(WgcCoreDsColors.lazaSurface),
                    focusedBorderColor = Color(WgcCoreDsColors.lazaPrimary),
                    unfocusedBorderColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            TextButton(
                onClick = onForgotPasswordClick,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = "Forgot password?",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.lazaAlertRed)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Remember me Switch
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Remember me",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = Color(WgcCoreDsColors.lazaDark)
                )

                Switch(
                    checked = rememberMe,
                    onCheckedChange = onRememberMeChange,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color(WgcCoreDsColors.lazaSuccessGreen)
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaIntroScreenTemplatePreview() {
    WgcLazaIntroScreenTemplate()
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaSignInScreenTemplatePreview() {
    WgcLazaSignInScreenTemplate()
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaEmailSignInTemplatePreview() {
    WgcLazaEmailSignInTemplate()
}
