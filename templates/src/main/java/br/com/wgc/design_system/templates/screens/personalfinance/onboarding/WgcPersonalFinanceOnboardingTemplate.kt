package br.com.wgc.design_system.templates.screens.personalfinance.onboarding

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
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Template de Boas-Vindas / Onboarding do Organizze.
 */
@Composable
fun WgcOrganizzeOnboardingTemplate(
    modifier: Modifier = Modifier,
    onGetStartedClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header com Logo / Ícone
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = WgcCoreDsSpacing.xl32.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s100.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.personalFinancePrimaryLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBalanceWallet,
                        contentDescription = "Organizze Logo",
                        tint = Color(WgcCoreDsColors.personalFinancePrimary),
                        modifier = Modifier.size(WgcCoreDsSize.s56.dp)
                    )
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

                Text(
                    text = "Organizze",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(WgcCoreDsColors.personalFinancePrimary)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = "Controle financeiro simples e descomplicado para sua vida.",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = Color(WgcCoreDsColors.personalFinanceSecondaryText)
                )
            }

            // Benefícios em destaque
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                BenefitItem(
                    icon = Icons.Default.TrendingUp,
                    title = "Previsibilidade total",
                    subtitle = "Saiba exatamente para onde vai cada centavo do seu dinheiro"
                )
                BenefitItem(
                    icon = Icons.Default.PieChart,
                    title = "Gráficos inteligentes",
                    subtitle = "Relatórios visuais e categorias automáticas para facilitar"
                )
            }

            // Botões de Ação
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                Button(
                    onClick = onGetStartedClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s48.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(WgcCoreDsColors.personalFinancePrimary)
                    )
                ) {
                    Text(
                        text = "Começar Grátis",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                OutlinedButton(
                    onClick = onLoginClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s48.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp)
                ) {
                    Text(
                        text = "Já tenho uma conta",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(WgcCoreDsColors.personalFinanceDark)
                    )
                }
            }
        }
    }
}

@Composable
private fun BenefitItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(WgcCoreDsSpacing.xxl40.dp)
                .clip(CircleShape)
                .background(Color(WgcCoreDsColors.personalFinancePrimaryLight)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.personalFinancePrimary),
                modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
            )
        }
        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.personalFinanceDark)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.personalFinanceSecondaryText)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeOnboardingTemplatePreview() {
    WgcOrganizzeOnboardingTemplate()
}
