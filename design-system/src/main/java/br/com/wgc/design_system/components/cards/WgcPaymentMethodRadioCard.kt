package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card selecionável para método de pagamento (WgcPaymentMethodRadioCard).
 */
@Composable
fun WgcPaymentMethodRadioCard(
    modifier: Modifier = Modifier,
    title: String = "Visa",
    subtitle: String? = "********* 2109",
    icon: ImageVector = Icons.Outlined.CreditCard,
    isSelected: Boolean = false,
    onSelect: () -> Unit
) {
    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp)
    val activeBorderColor = Color(WgcCoreDsColors.stylishPink)
    val inactiveBorderColor = Color(WgcCoreDsColors.stylishBorderGray).copy(alpha = 0.3f)

    val border = if (isSelected) {
        BorderStroke(1.5.dp, activeBorderColor)
    } else {
        BorderStroke(1.dp, inactiveBorderColor)
    }

    val containerColor = if (isSelected) {
        Color(WgcCoreDsColors.stylishPink).copy(alpha = 0.05f)
    } else {
        Color(WgcCoreDsColors.white)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .clickable(role = Role.RadioButton, onClick = onSelect)
            .semantics { role = Role.RadioButton },
        shape = shape,
        border = border,
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (isSelected) Color(WgcCoreDsColors.stylishPink) else Color(WgcCoreDsColors.stylishDark),
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm.dp))
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color(WgcCoreDsColors.stylishDark)
                    )
                    if (subtitle != null) {
                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(WgcCoreDsColors.textSecondary)
                        )
                    }
                }
            }

            RadioButton(
                selected = isSelected,
                onClick = onSelect,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(WgcCoreDsColors.stylishPink),
                    unselectedColor = Color(WgcCoreDsColors.stylishBorderGray)
                )
            )
        }
    }
}

@Preview(name = "Payment Method Radio Preview", showBackground = true)
@Composable
private fun WgcPaymentMethodRadioCardPreview() {
    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
        WgcPaymentMethodRadioCard(
            title = "Visa",
            subtitle = "********* 2109",
            isSelected = true,
            onSelect = {}
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))
        WgcPaymentMethodRadioCard(
            title = "PayPal",
            subtitle = "gabriel@example.com",
            isSelected = false,
            onSelect = {}
        )
    }
}
