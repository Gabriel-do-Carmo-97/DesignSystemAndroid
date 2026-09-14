package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card de visualização de Cartão de Crédito do Organizze.
 * Exibe o banco/emissor, últimos 4 dígitos, fatura atual, limite disponível e barra de uso.
 */
@Composable
fun WgcOrganizzeCreditCardRow(
    modifier: Modifier = Modifier,
    bankName: String = "Nubank Mastercard",
    lastDigits: String = "•••• 8421",
    currentInvoice: String = "R$ 1.840,50",
    availableLimit: String = "R$ 3.159,50",
    totalLimit: String = "R$ 5.000,00",
    closingDate: String = "Fecha em 24/05",
    accentColor: Color = Color(WgcCoreDsColors.organizzeCardNubank),
    usageProgress: Float = 0.368f,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.xxs4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header do Cartão com Ícone e Nome
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSpacing.xl32.dp)
                            .clip(CircleShape)
                            .background(accentColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
                    Column {
                        Text(
                            text = bankName,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.organizzeDark)
                        )
                        Text(
                            text = lastDigits,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.organizzeSecondaryText)
                        )
                    }
                }

                Text(
                    text = closingDate,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(WgcCoreDsColors.organizzeSecondaryText)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Fatura Atual em destaque
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = "Fatura atual",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.organizzeSecondaryText)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = currentInvoice,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.organizzeExpenseRed)
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Limite disponível",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.organizzeSecondaryText)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = availableLimit,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(WgcCoreDsColors.organizzePrimary)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Barra de Progresso do Limite
            LinearProgressIndicator(
                progress = { usageProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSpacing.xs8.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)),
                color = accentColor,
                trackColor = Color(WgcCoreDsColors.organizzeBorder),
                strokeCap = StrokeCap.Round
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeCreditCardRowPreview() {
    WgcOrganizzeCreditCardRow(
        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)
    )
}
