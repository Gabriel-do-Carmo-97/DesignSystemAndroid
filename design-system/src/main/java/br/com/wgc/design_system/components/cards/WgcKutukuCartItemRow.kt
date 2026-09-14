package br.com.wgc.design_system.components.cards

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.components.stepper.WgcKutukuQuantityStepper

/**
 * Linha de item do carrinho Kutuku (WgcKutukuCartItemRow).
 * Exibe checkbox de seleção, miniatura arredondada, título, especificação de cor,
 * controle de quantidade e preço formatado.
 */
@Composable
fun WgcKutukuCartItemRow(
    modifier: Modifier = Modifier,
    title: String,
    colorVariant: String,
    price: String,
    quantity: Int,
    imageUrl: String? = null,
    isSelected: Boolean = true,
    onSelectionChange: (Boolean) -> Unit = {},
    onQuantityChange: (Int) -> Unit = {}
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = WgcCoreDsSpacing.sm.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isSelected,
                onCheckedChange = onSelectionChange,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(WgcCoreDsColors.kutukuPrimary),
                    uncheckedColor = Color(WgcCoreDsColors.kutukuBorder)
                )
            )

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs.dp))

            // Imagem do produto
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg.dp))
                    .background(Color(WgcCoreDsColors.kutukuBackground)),
                contentAlignment = Alignment.Center
            ) {
                if (!imageUrl.isNullOrEmpty()) {
                    AsyncImageDefault(
                        image = imageUrl,
                        contentDescription = title,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(WgcCoreDsColors.kutukuPrimaryLight).copy(alpha = 0.5f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = title.take(2).uppercase(),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.kutukuPrimary)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm.dp))

            // Conteúdo e Stepper
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.kutukuDark),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "Color: $colorVariant",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.kutukuSecondaryText)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    WgcKutukuQuantityStepper(
                        count = quantity,
                        onCountChange = onQuantityChange
                    )

                    Text(
                        text = price,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.kutukuDark)
                    )
                }
            }
        }

        HorizontalDivider(
            color = Color(WgcCoreDsColors.kutukuBorder).copy(alpha = 0.5f),
            thickness = 1.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcKutukuCartItemRowPreview() {
    WgcKutukuCartItemRow(
        title = "Bix Bag Limited Edition 229",
        colorVariant = "Berown",
        price = "$67.00",
        quantity = 1,
        isSelected = true
    )
}
