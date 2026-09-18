package br.com.wgc.ds_templates.screens.freshgrocery.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Tela Splash & Onboarding do Fresh Grocery:
 * Fundo verde vibrante degradê, logo e ícone, e botão CTA branco "Get Started".
 */
@Composable
fun WgcFreshGrocerySplashTemplate(
    onGetStartedClick: () -> Unit = {},
    logoSlot: (@Composable () -> Unit)? = null,
    buttonSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(WgcCoreDsColors.megaStorerSecondary),
            Color(WgcCoreDsColors.megaStorerPrimary),
            Color(WgcCoreDsColors.megaStorerPrimaryDark)
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(gradient)
            .navigationBarsPadding()
            .padding(WgcCoreDsSpacing.lg24.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (logoSlot != null) {
                logoSlot()
            } else {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s88.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = "Shopper Logo",
                        tint = Color.White,
                        modifier = Modifier.size(WgcCoreDsSize.s48.dp)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                Text(
                    text = "Shopper",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = "Your Everyday Fashion & Lifestyle Store",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.85f),
                    textAlign = TextAlign.Center
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = WgcCoreDsSpacing.lg24.dp)
        ) {
            if (buttonSlot != null) {
                buttonSlot()
            } else {
                Button(
                    onClick = onGetStartedClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                ) {
                    Text(
                        text = "Get Started",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcFreshGrocerySplashTemplatePreview() {
    WgcFreshGrocerySplashTemplate()
}
