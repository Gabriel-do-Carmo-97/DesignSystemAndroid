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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Seletor de quantidade no formato pílula arredondada (`- count +`),
 * conforme o design oficial do Kutuku.
 */
@Composable
fun WgcRetailQuantityStepper(
    modifier: Modifier = Modifier,
    count: Int,
    minCount: Int = 1,
    maxCount: Int = 99,
    onCountChange: (Int) -> Unit = {}
) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(Color(WgcCoreDsColors.retailBackground))
            .padding(horizontal = WgcCoreDsSpacing.sm.dp, vertical = WgcCoreDsSpacing.xxs.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .clickable(enabled = count > minCount) { onCountChange(count - 1) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Remove,
                contentDescription = "Diminuir quantidade",
                tint = if (count > minCount) Color(WgcCoreDsColors.retailDark) else Color(WgcCoreDsColors.retailSecondaryText),
                modifier = Modifier.size(16.dp)
            )
        }

        Text(
            text = count.toString(),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.retailDark)
        )

        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .clickable(enabled = count < maxCount) { onCountChange(count + 1) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Aumentar quantidade",
                tint = if (count < maxCount) Color(WgcCoreDsColors.retailDark) else Color(WgcCoreDsColors.retailSecondaryText),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuQuantityStepperPreview() {
    WgcRetailQuantityStepper(count = 3)
}
