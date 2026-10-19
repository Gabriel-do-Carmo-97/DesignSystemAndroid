@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.previews.multi.theme.ThemePreviews
import br.com.wgc.design_system.theme.WgcTheme

/**
 * WgcFinancialCard
 *
 * Card de extrato/balanço bancário com saldo mascarável e atalhos de ações financeiras.
 */
@Composable
fun WgcFinancialCard(
    accountName: String,
    balance: String,
    isBalanceVisible: Boolean,
    onToggleBalanceVisibility: () -> Unit,
    modifier: Modifier = Modifier,
    percentageVariation: String? = null,
    isPositiveVariation: Boolean = true,
    actionRowSlot: (@Composable () -> Unit)? = null
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.LG.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.MD.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = accountName,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                IconButton(onClick = onToggleBalanceVisibility) {
                    Icon(
                        imageVector = if (isBalanceVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (isBalanceVisible) "Ocultar saldo" else "Mostrar saldo",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS.dp)) {
                Text(
                    text = if (isBalanceVisible) balance else "••••••",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                if (percentageVariation != null && isBalanceVisible) {
                    Text(
                        text = percentageVariation,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        color = if (isPositiveVariation) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                    )
                }
            }

            actionRowSlot?.invoke()
        }
    }
}

@ThemePreviews
@Composable
private fun WgcFinancialCardPreview() {
    var isBalanceVisible by remember { mutableStateOf(true) }

    WgcTheme {
        WgcFinancialCard(
            accountName = "Conta Corrente",
            balance = "R$ 12.450,80",
            isBalanceVisible = isBalanceVisible,
            onToggleBalanceVisibility = { isBalanceVisible = !isBalanceVisible },
            percentageVariation = "+2,5% este mês",
            isPositiveVariation = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@ThemePreviews
@Composable
private fun WgcFinancialCardHiddenPreview() {
    WgcTheme {
        WgcFinancialCard(
            accountName = "Conta Investimento",
            balance = "R$ 45.000,00",
            isBalanceVisible = false,
            onToggleBalanceVisibility = {},
            percentageVariation = "-0,5% hoje",
            isPositiveVariation = false,
            modifier = Modifier.padding(16.dp)
        )
    }
}
