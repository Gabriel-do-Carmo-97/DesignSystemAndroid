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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

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
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.S1.dp,
            color = if (isActivated) Color(WgcCoreDsColors.green4) else Color(WgcCoreDsColors.blueLight6)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.MD16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM12.dp)
        ) {
            // Top: Categoria + Badge de Desconto
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ConfirmationNumber,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.red12),
                        modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                    )
                    Text(
                        text = category.uppercase(),
                        color = Color(WgcCoreDsColors.blue27),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                        .background(Color(WgcCoreDsColors.red12))
                        .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
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
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp)) {
                Text(
                    text = title,
                    color = Color(WgcCoreDsColors.grayDark7),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 20.sp
                )
                Text(
                    text = limitCondition,
                    color = Color(WgcCoreDsColors.blue27),
                    fontSize = 12.sp
                )
            }

            // Validade
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Schedule,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.blue27),
                    modifier = Modifier.size(WgcCoreDsSize.S14.dp)
                )
                Text(
                    text = validUntil,
                    color = Color(WgcCoreDsColors.blue27),
                    fontSize = 11.sp
                )
            }

            // Botão de Ativação do Cupom
            Button(
                onClick = onActivateToggle,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.S40.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isActivated) {
                        Color(WgcCoreDsColors.greenLight10)
                    } else {
                        Color(WgcCoreDsColors.yellow5)
                    },
                    contentColor = if (isActivated) {
                        Color(WgcCoreDsColors.green4)
                    } else {
                        Color(WgcCoreDsColors.grayDark7)
                    }
                ),
                border = androidx.compose.foundation.BorderStroke(
                    width = WgcCoreDsSize.S1.dp,
                    color = if (isActivated) {
                        Color(WgcCoreDsColors.green4)
                    } else {
                        Color(WgcCoreDsColors.yellow5)
                    }
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS8.dp)
                ) {
                    if (isActivated) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            modifier = Modifier.size(WgcCoreDsSize.S16.dp)
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
