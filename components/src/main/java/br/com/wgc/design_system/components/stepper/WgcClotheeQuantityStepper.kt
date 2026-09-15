package br.com.wgc.design_system.components.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Seletor de quantidade no estilo Clothee (WgcClotheeQuantityStepper).
 * Apresenta botões circulares na cor roxa primária (#8E6CEF) com ícones brancos e contagem ao centro.
 */
@Composable
fun WgcClotheeQuantityStepper(
    modifier: Modifier = Modifier,
    count: Int,
    minCount: Int = 1,
    maxCount: Int = 99,
    onCountChange: (Int) -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
    ) {
        // Botão de diminuir
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(
                    if (count > minCount) Color(WgcCoreDsColors.clotheePrimary)
                    else Color(WgcCoreDsColors.clotheePrimary).copy(alpha = 0.4f)
                )
                .clickable(enabled = count > minCount) { onCountChange(count - 1) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Remove,
                contentDescription = "Diminuir quantidade",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

        // Quantidade
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.clotheeDark)
        )

        // Botão de aumentar
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(
                    if (count < maxCount) Color(WgcCoreDsColors.clotheePrimary)
                    else Color(WgcCoreDsColors.clotheePrimary).copy(alpha = 0.4f)
                )
                .clickable(enabled = count < maxCount) { onCountChange(count + 1) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Aumentar quantidade",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeQuantityStepperPreview() {
    WgcClotheeQuantityStepper(count = 2)
}
