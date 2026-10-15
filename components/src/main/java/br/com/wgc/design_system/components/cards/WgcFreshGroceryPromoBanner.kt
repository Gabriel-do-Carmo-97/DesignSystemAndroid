package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Banner promocional de destaque Shopper ("Don't Miss Out! Get discount up to 50%").
 * Fundo bege/pastel ou verde claro com botão CTA "Check Now" e imagem ilustrativa.
 */
@Composable
fun WgcFreshGroceryPromoBanner(
    title: String = "Don't Miss Out!",
    subtitle: String = "Get discount up to 50%",
    buttonText: String = "Check Now",
    onButtonClick: () -> Unit = {},
    illustrationSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp))
            .background(Color(WgcCoreDsColors.orangeLight4))
            .padding(WgcCoreDsSpacing.MD16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.greenDark4)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.gray9)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

                Button(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(WgcCoreDsColors.green6),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(
                        horizontal = WgcCoreDsSpacing.MD16.dp,
                        vertical = WgcCoreDsSpacing.XS8.dp
                    )
                ) {
                    Text(
                        text = buttonText,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.SM12.dp))

            if (illustrationSlot != null) {
                illustrationSlot()
            } else {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.S80.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                        .background(Color(WgcCoreDsColors.greenLight8)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "50% OFF",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(WgcCoreDsColors.green6)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShopperPromoBannerPreview() {
    WgcFreshGroceryPromoBanner()
}
