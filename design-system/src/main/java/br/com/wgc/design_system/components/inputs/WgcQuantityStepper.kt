package br.com.wgc.design_system.components.inputs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Componente Stepper de quantidade (WgcQuantityStepper).
 * Permite incrementar e decrementar itens no carrinho de compras.
 */
@Composable
fun WgcQuantityStepper(
    modifier: Modifier = Modifier,
    quantity: Int,
    onQuantityChange: (Int) -> Unit,
    minQuantity: Int = 1,
    maxQuantity: Int = 99,
    isEnabled: Boolean = true
) {
    val canDecrement = isEnabled && quantity > minQuantity
    val canIncrement = isEnabled && quantity < maxQuantity
    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm.dp)
    val borderColor = Color(WgcCoreDsColors.stylishBorderGray).copy(alpha = 0.5f)

    Surface(
        modifier = modifier.semantics {
            contentDescription = "Controle de quantidade: $quantity"
        },
        shape = shape,
        border = BorderStroke(1.dp, borderColor),
        color = Color(WgcCoreDsColors.white)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(shape)
                    .clickable(enabled = canDecrement) { onQuantityChange(quantity - 1) },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Diminuir quantidade",
                    tint = if (canDecrement) Color(WgcCoreDsColors.stylishDark) else Color(WgcCoreDsColors.stylishBorderGray),
                    modifier = Modifier.size(16.dp)
                )
            }

            Box(
                modifier = Modifier
                    .widthIn(min = 36.dp)
                    .padding(horizontal = WgcCoreDsSpacing.xs.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = quantity.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.stylishDark)
                )
            }

            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(shape)
                    .clickable(enabled = canIncrement) { onQuantityChange(quantity + 1) },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Aumentar quantidade",
                    tint = if (canIncrement) Color(WgcCoreDsColors.stylishDark) else Color(WgcCoreDsColors.stylishBorderGray),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Preview(name = "Quantity Stepper Preview", showBackground = true)
@Composable
private fun WgcQuantityStepperPreview() {
    Box(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
        WgcQuantityStepper(
            quantity = 2,
            onQuantityChange = {}
        )
    }
}
