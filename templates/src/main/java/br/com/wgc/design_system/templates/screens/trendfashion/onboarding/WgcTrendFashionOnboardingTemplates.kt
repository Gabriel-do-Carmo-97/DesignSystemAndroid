package br.com.wgc.design_system.templates.screens.trendfashion.onboarding

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcButton

/**
 * Tela 1: Splash Screen com Logoipsum e indicador de carregamento.
 * (Figma ID: 1:18734)
 */
@Composable
fun WgcStylishSplashScreenTemplate(
    modifier: Modifier = Modifier,
    brandName: String = "Stylish",
    onTimeout: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg.dp))
                        .background(Color(WgcCoreDsColors.trendFashionPink)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = "Logo",
                        tint = Color.White,
                        modifier = Modifier.size(44.dp)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

                Text(
                    text = brandName,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    ),
                    color = Color(WgcCoreDsColors.trendFashionPink)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxl.dp))

                CircularProgressIndicator(
                    color = Color(WgcCoreDsColors.trendFashionPink),
                    strokeWidth = 3.dp,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

/**
 * Telas 2, 3 e 4: Onboarding Interativo com 3 passos.
 * (Figma IDs: 1:17865, 1:18135, 1:18392)
 */
@Composable
fun WgcStylishOnboardingScreenTemplate(
    modifier: Modifier = Modifier,
    step: Int = 1,
    totalSteps: Int = 3,
    title: String = when (step) {
        1 -> "Choose Products"
        2 -> "Make Payment"
        else -> "Get Your Order"
    },
    description: String = when (step) {
        1 -> "A huge collection of trendy fashion and footwear waiting for you."
        2 -> "Easy and secure payment through credit cards, UPI and NetBanking."
        else -> "Fast delivery at your doorstep with real-time tracking."
    },
    onNextClick: () -> Unit = {},
    onSkipClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$step/$totalSteps",
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionDark)
                )
                TextButton(onClick = onSkipClick) {
                    Text(
                        text = "Skip",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                        color = Color(WgcCoreDsColors.trendFashionDark)
                    )
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.lg.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Indicator Dots
                Row(verticalAlignment = Alignment.CenterVertically) {
                    for (i in 1..totalSteps) {
                        val isCurrent = i == step
                        Box(
                            modifier = Modifier
                                .height(8.dp)
                                .width(if (isCurrent) 28.dp else 8.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(
                                    if (isCurrent) Color(WgcCoreDsColors.trendFashionDark)
                                    else Color(WgcCoreDsColors.trendFashionBorderGray).copy(alpha = 0.4f)
                                )
                        )
                        if (i < totalSteps) Spacer(modifier = Modifier.width(6.dp))
                    }
                }

                WgcButton(
                    text = if (step == totalSteps) "Get Started" else "Next",
                    onClick = onNextClick
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.lg.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(240.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.trendFashionPink).copy(alpha = 0.08f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingBag,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.trendFashionPink),
                    modifier = Modifier.size(100.dp)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color(WgcCoreDsColors.trendFashionDark),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(WgcCoreDsColors.textSecondary),
                textAlign = TextAlign.Center
            )
        }
    }
}

/**
 * Tela 5: Get Started (Hero landing com background e chamada de ação).
 * (Figma ID: 1:16994)
 */
@Composable
fun WgcStylishGetStartedScreenTemplate(
    modifier: Modifier = Modifier,
    headline: String = "You want Authentic, here you go!",
    subheadline: String = "Find it here, buy it now!",
    onGetStartedClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(WgcCoreDsColors.trendFashionDark))
    ) {
        // Gradient overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(WgcCoreDsColors.trendFashionDark).copy(alpha = 0.8f),
                            Color(WgcCoreDsColors.trendFashionDark)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(WgcCoreDsSpacing.xl.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = headline,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                ),
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))

            Text(
                text = subheadline,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.75f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))

            WgcButton(
                text = "Get Started",
                onClick = onGetStartedClick,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
        }
    }
}

@Preview(name = "Splash Screen Preview", showBackground = true)
@Composable
private fun WgcStylishSplashScreenPreview() {
    WgcStylishSplashScreenTemplate()
}

@Preview(name = "Onboarding Screen Preview", showBackground = true)
@Composable
private fun WgcStylishOnboardingScreenPreview() {
    WgcStylishOnboardingScreenTemplate(step = 1)
}

@Preview(name = "Get Started Screen Preview", showBackground = true)
@Composable
private fun WgcStylishGetStartedScreenPreview() {
    WgcStylishGetStartedScreenTemplate()
}
