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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Card de Produto de Supermercado do Clube Extra.
 *
 * Exibe foto/slot, unidade/peso, comparador de Preço Regular vs Preço Exclusivo Clube Extra,
 * selo de desconto percentual, botão de ativação de cupom e controle de quantidade no carrinho.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcExtraProductCard(
    name: String,
    unitDescription: String,
    regularPrice: String,
    clubPrice: String,
    discountPercentage: String,
    modifier: Modifier = Modifier,
    isDiscountActivated: Boolean = true,
    quantityInCart: Int = 0,
    onActivateDiscountToggle: (() -> Unit)? = null,
    onAddToCart: () -> Unit = {},
    onIncrementQuantity: () -> Unit = {},
    onDecrementQuantity: () -> Unit = {},
    onClick: () -> Unit = {},
    slotImage: (@Composable () -> Unit)? = null
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
            color = Color(WgcCoreDsColors.extraBorder)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.sm12.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            // Header do Card: Tag de Desconto + Status de Ativação
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.extraRed))
                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                ) {
                    Text(
                        text = "$discountPercentage OFF",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Black
                    )
                }

                if (onActivateDiscountToggle != null) {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(
                                if (isDiscountActivated) {
                                    Color(WgcCoreDsColors.extraSuccessGreenLight)
                                } else {
                                    Color(WgcCoreDsColors.extraYellowLight)
                                }
                            )
                            .border(
                                width = WgcCoreDsSize.s1.dp,
                                color = if (isDiscountActivated) {
                                    Color(WgcCoreDsColors.extraSuccessGreen)
                                } else {
                                    Color(WgcCoreDsColors.extraYellow)
                                },
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                            )
                            .clickable { onActivateDiscountToggle() }
                            .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)
                    ) {
                        Icon(
                            imageVector = if (isDiscountActivated) Icons.Default.Check else Icons.Default.LocalOffer,
                            contentDescription = null,
                            tint = if (isDiscountActivated) {
                                Color(WgcCoreDsColors.extraSuccessGreen)
                            } else {
                                Color(WgcCoreDsColors.extraRed)
                            },
                            modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                        )
                        Text(
                            text = if (isDiscountActivated) "ATIVADO NO CPF" else "ATIVAR DESCONTO",
                            color = if (isDiscountActivated) {
                                Color(WgcCoreDsColors.extraSuccessGreen)
                            } else {
                                Color(WgcCoreDsColors.extraDark)
                            },
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Área da Imagem / Placeholder
            if (slotImage != null) {
                slotImage()
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s100.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.extraBackground)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.extraPlaceholder),
                        modifier = Modifier.size(WgcCoreDsSize.s40.dp)
                    )
                }
            }

            // Detalhes do Produto
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)) {
                Text(
                    text = name,
                    color = Color(WgcCoreDsColors.extraDark),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 16.sp
                )
                Text(
                    text = unitDescription,
                    color = Color(WgcCoreDsColors.extraSecondaryText),
                    fontSize = 11.sp
                )
            }

            // Bloco de Preços (De / Por Clube)
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxxs2.dp)) {
                Text(
                    text = "De $regularPrice",
                    color = Color(WgcCoreDsColors.extraSecondaryText),
                    fontSize = 11.sp,
                    textDecoration = TextDecoration.LineThrough
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Text(
                        text = clubPrice,
                        color = Color(WgcCoreDsColors.extraRed),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.extraYellow))
                            .padding(horizontal = WgcCoreDsSpacing.xxs4.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                    ) {
                        Text(
                            text = "CLUBE EXTRA",
                            color = Color(WgcCoreDsColors.extraDark),
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }

            // Controle de Carrinho (Adicionar ou Stepper de Quantidade)
            if (quantityInCart == 0) {
                Button(
                    onClick = onAddToCart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s36.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(WgcCoreDsColors.extraRed),
                        contentColor = Color.White
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                        Text(
                            text = "ADICIONAR",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s36.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.extraBackground))
                        .border(
                            width = WgcCoreDsSize.s1.dp,
                            color = Color(WgcCoreDsColors.extraBorder),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                        )
                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onDecrementQuantity,
                        modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Diminuir",
                            tint = Color(WgcCoreDsColors.extraRed),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                    }

                    Text(
                        text = "$quantityInCart",
                        color = Color(WgcCoreDsColors.extraDark),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(
                        onClick = onIncrementQuantity,
                        modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Aumentar",
                            tint = Color(WgcCoreDsColors.extraRed),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Clube Extra Product Card - Preview", showBackground = true)
@Composable
fun WgcExtraProductCardPreview() {
    WgcExtraProductCard(
        name = "Azeite de Oliva Extra Virgem Borges",
        unitDescription = "Vidro 500ml",
        regularPrice = "R$ 42,90",
        clubPrice = "R$ 31,90",
        discountPercentage = "25%",
        isDiscountActivated = true,
        quantityInCart = 2
    )
}
