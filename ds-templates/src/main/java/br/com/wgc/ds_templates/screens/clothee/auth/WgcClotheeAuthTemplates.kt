package br.com.wgc.ds_templates.screens.clothee.auth

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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MarkEmailRead
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Tela de login oficial do Clothee (WgcClotheeSignInTemplate).
 * Apresenta campo de email, botão de continuação em roxo primário (#8E6CEF) e botões sociais arredondados.
 */
@Composable
fun WgcClotheeSignInTemplate(
    modifier: Modifier = Modifier,
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    onContinueClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onAppleSignIn: () -> Unit = {},
    onGoogleSignIn: () -> Unit = {},
    onFacebookSignIn: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    customHeaderSlot: (@Composable () -> Unit)? = null,
    customFooterSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            if (customHeaderSlot != null) {
                customHeaderSlot()
            } else {
                Text(
                    text = "Sign in",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.clotheeDark)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            // Campo de e-mail com cantos suaves
            OutlinedTextField(
                value = email,
                onValueChange = onEmailChange,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Email Address",
                        color = Color(WgcCoreDsColors.clotheeSecondaryText)
                    )
                },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(WgcCoreDsColors.clotheeSurface),
                    unfocusedContainerColor = Color(WgcCoreDsColors.clotheeSurface),
                    focusedBorderColor = Color(WgcCoreDsColors.clotheePrimary),
                    unfocusedBorderColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Botão Principal "Continue"
            Button(
                onClick = onContinueClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.clotheePrimary)
                )
            ) {
                Text(
                    text = "Continue",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            // Link "Dont have an Account? Create One"
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Dont have an Account? ",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.clotheeDark)
                )
                Text(
                    text = "Create One",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.clotheeDark),
                    modifier = Modifier.clickable(onClick = onCreateAccountClick)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxl48.dp))

            // Botões de login social
            ClotheeSocialButton(
                text = "Continue With Apple",
                onClick = onAppleSignIn
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            ClotheeSocialButton(
                text = "Continue With Google",
                onClick = onGoogleSignIn
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            ClotheeSocialButton(
                text = "Continue With Facebook",
                onClick = onFacebookSignIn
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            if (customFooterSlot != null) {
                customFooterSlot()
            } else {
                TextButton(
                    onClick = onForgotPasswordClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Forgot Password?",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.clotheeSecondaryText)
                    )
                }
            }
        }
    }
}

/**
 * Botão social no formato pílula com fundo cinza suave (#F4F4F4) e texto centralizado.
 */
@Composable
private fun ClotheeSocialButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(WgcCoreDsColors.clotheeSurface),
            contentColor = Color(WgcCoreDsColors.clotheeDark)
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/**
 * Tela de redefinição de senha do Clothee (WgcClotheeForgotPasswordTemplate).
 */
@Composable
fun WgcClotheeForgotPasswordTemplate(
    modifier: Modifier = Modifier,
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    onContinueClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
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
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.clotheeSurface))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color(WgcCoreDsColors.clotheeDark)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Text(
                text = "Forgot Password",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.clotheeDark)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = onEmailChange,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Enter Email Address",
                        color = Color(WgcCoreDsColors.clotheeSecondaryText)
                    )
                },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(WgcCoreDsColors.clotheeSurface),
                    unfocusedContainerColor = Color(WgcCoreDsColors.clotheeSurface),
                    focusedBorderColor = Color(WgcCoreDsColors.clotheePrimary),
                    unfocusedBorderColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

            Button(
                onClick = onContinueClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.clotheePrimary)
                )
            ) {
                Text(
                    text = "Continue",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}

/**
 * Tela de confirmação de envio de email de recuperação (WgcClotheeResetPasswordSentTemplate).
 */
@Composable
fun WgcClotheeResetPasswordSentTemplate(
    modifier: Modifier = Modifier,
    onReturnToLoginClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.clotheePrimaryLight)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MarkEmailRead,
                    contentDescription = "Email enviado",
                    tint = Color(WgcCoreDsColors.clotheePrimary),
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            Text(
                text = "We Sent you an Email to reset your password.",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.clotheeDark),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            Button(
                onClick = onReturnToLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.clotheePrimary)
                )
            ) {
                Text(
                    text = "Return to Login",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeSignInTemplatePreview() {
    WgcClotheeSignInTemplate(email = "gabriel@wgc.com")
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeForgotPasswordTemplatePreview() {
    WgcClotheeForgotPasswordTemplate()
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeResetPasswordSentTemplatePreview() {
    WgcClotheeResetPasswordSentTemplate()
}
