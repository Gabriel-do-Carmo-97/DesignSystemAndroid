package br.com.wgc.design_system.components.cards

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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card promocional de "Oferta do Dia" com contagem regressiva integrada (WgcDealOfTheDayCard).
 */
@Composable
fun WgcDealOfTheDayCard(
    modifier: Modifier = Modifier,
    title: String = "Deal of the Day",
    remainingTime: String = "22h 55m 20s remaining",
    actionLabel: String = "View all",
    backgroundColor: Color = Color(WgcCoreDsColors.stylishBlue),
    onViewAllClick: () -> Unit
) {
    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Schedule,
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.85f),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs.dp))
                    Text(
                        text = remainingTime,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm.dp),
                color = Color.White.copy(alpha = 0.2f),
                modifier = Modifier
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm.dp))
                    .clickable(onClick = onViewAllClick)
            ) {
                Row(
                    modifier = Modifier.padding(
                        horizontal = WgcCoreDsSpacing.sm.dp,
                        vertical = WgcCoreDsSpacing.xs.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = actionLabel,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}

@Preview(name = "Deal of the Day Card Preview", showBackground = true)
@Composable
private fun WgcDealOfTheDayCardPreview() {
    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
        WgcDealOfTheDayCard(
            onViewAllClick = {}
        )
    }
}
