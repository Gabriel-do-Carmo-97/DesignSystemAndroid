package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

enum class WgcOrganizzeTransactionType {
    Expense,
    Income,
    Transfer
}

/**
 * Item de Transação / Lançamento do Organizze.
 * Mostra o ícone de categoria, descrição, conta/cartão, valor e botão de conciliação (pago/pendente).
 */
@Composable
@Suppress("LongMethod")
fun WgcPersonalFinanceTransactionItem(
    modifier: Modifier = Modifier,
    title: String = "Supermercado Gourmet",
    category: String = "Alimentação",
    account: String = "Neobank Cartão",
    amount: String = "R$ 248,90",
    type: WgcOrganizzeTransactionType = WgcOrganizzeTransactionType.Expense,
    categoryIcon: ImageVector = Icons.Default.Restaurant,
    categoryColor: Color = Color(WgcCoreDsColors.orange37),
    isPaid: Boolean = true,
    onTogglePaid: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    val amountColor = when (type) {
        WgcOrganizzeTransactionType.Expense -> Color(WgcCoreDsColors.red23)
        WgcOrganizzeTransactionType.Income -> Color(WgcCoreDsColors.green26)
        WgcOrganizzeTransactionType.Transfer -> Color(WgcCoreDsColors.blue36)
    }

    val amountPrefix = when (type) {
        WgcOrganizzeTransactionType.Expense -> "- "
        WgcOrganizzeTransactionType.Income -> "+ "
        WgcOrganizzeTransactionType.Transfer -> ""
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsSpacing.NONE0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.MD16.dp,
                    vertical = WgcCoreDsSpacing.SM12.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícone da Categoria + Descrição e Conta
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSpacing.XXL40.dp)
                        .clip(CircleShape)
                        .background(categoryColor.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = categoryIcon,
                        contentDescription = category,
                        tint = categoryColor,
                        modifier = Modifier.size(WgcCoreDsSpacing.LG24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.SM12.dp))

                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(WgcCoreDsColors.blueDark33)
                    )
                    Text(
                        text = "$category • $account",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.gray11)
                    )
                }
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XS8.dp))

            // Valor e Toggle Pago/Pendente
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "$amountPrefix$amount",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = amountColor
                )

                IconButton(
                    onClick = onTogglePaid,
                    modifier = Modifier.size(WgcCoreDsSpacing.XL32.dp)
                ) {
                    Icon(
                        imageVector = if (isPaid) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                        contentDescription = if (isPaid) "Pago" else "Pendente",
                        tint = if (isPaid) Color(WgcCoreDsColors.green26) else Color(WgcCoreDsColors.blueLight7),
                        modifier = Modifier.size(WgcCoreDsSpacing.MD16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcOrganizzeTransactionItemPreview() {
    WgcPersonalFinanceTransactionItem(
        modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp)
    )
}
