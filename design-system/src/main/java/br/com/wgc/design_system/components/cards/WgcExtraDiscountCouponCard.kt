package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card de Cupom Personalizado "Meu Desconto" do Clube Extra.
 *
 * Apresenta o benefício individual por CPF, percentual de economia,
 * restrição de unidades e gatilho de ativação imediata.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcExtraDiscountCouponCard(
    title: String,
    category: String,
    discountBadge: String,
    limitCondition: String,
    validUntil: String,
    modifier: Modifier = Modifier,
    isActivated: Boolean = false,
    onActivateToggle: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.extraSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.s1.dp,
            color = if (isActivated) Color(WgcCoreDsColors.extraSuccessGreen) else Color(WgcCoreDsColors.extraBorder)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            // Top: Categoria + Badge de Desconto
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ConfirmationNumber,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.extraRed),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Text(
                        text = category.uppercase(),
                        color = Color(WgcCoreDsColors.extraSecondaryText),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.extraRed))
                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                ) {
                    Text(
                        text = discountBadge,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }

            // Título e Condição
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                Text(
                    text = title,
                    color = Color(WgcCoreDsColors.extraDark),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 20.sp
                )
                Text(
                    text = limitCondition,
                    color = Color(WgcCoreDsColors.extraSecondaryText),
                    fontSize = 12.sp
                )
            }

            // Validade
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Schedule,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.extraSecondaryText),
                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                )
                Text(
                    text = validUntil,
                    color = Color(WgcCoreDsColors.extraSecondaryText),
                    fontSize = 11.sp
                )
            }

            // Botão de Ativação do Cupom
            Button(
                onClick = onActivateToggle,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s40.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isActivated) {
                        Color(WgcCoreDsColors.extraSuccessGreenLight)
                    } else {
                        Color(WgcCoreDsColors.extraYellow)
                    },
                    contentColor = if (isActivated) {
                        Color(WgcCoreDsColors.extraSuccessGreen)
                    } else {
                        Color(WgcCoreDsColors.extraDark)
                    }
                ),
                border = androidx.compose.foundation.BorderStroke(
                    width = WgcCoreDsSize.s1.dp,
                    color = if (isActivated) {
                        Color(WgcCoreDsColors.extraSuccessGreen)
                    } else {
                        Color(WgcCoreDsColors.extraYellow)
                    }
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    if (isActivated) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                    }
                    Text(
                        text = if (isActivated) "DESCONTO ATIVADO NO CPF" else "ATIVAR MEU DESCONTO",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
    }
}

@Preview(name = "Clube Extra Coupon Card - Preview", showBackground = true)
@Composable
fun WgcExtraDiscountCouponCardPreview() {
    WgcExtraDiscountCouponCard(
        title = "30% de desconto em Cervejas Especiais Spaten e Stella Artois",
        category = "Bebidas & Cervejas",
        discountBadge = "30% OFF",
        limitCondition = "Limite de até 12 garrafas por CPF",
        validUntil = "Válido até domingo, 21/09",
        isActivated = false
    )
}
