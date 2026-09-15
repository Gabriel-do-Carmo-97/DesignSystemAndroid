package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalPharmacy
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Remove
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

enum class DrogaRaiaMedicineStripe {
    NONE,
    RED,
    BLACK,
    GENERIC
}

@Composable
fun WgcDrogaRaiaProductCard(
    title: String,
    laboratory: String,
    presentation: String,
    price: Double,
    modifier: Modifier = Modifier,
    originalPrice: Double? = null,
    raiaClientPrice: Double? = null,
    stripe: DrogaRaiaMedicineStripe = DrogaRaiaMedicineStripe.NONE,
    requiresPrescription: Boolean = false,
    hasSubscription: Boolean = false,
    isFavorite: Boolean = false,
    quantityInCart: Int = 0,
    onCardClick: () -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onQuantityChange: (Int) -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCardClick() },
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.drogaRaiaSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.drogaRaiaBorder))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            // Tarja Superior de Medicamento / Alerta
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                when (stripe) {
                    DrogaRaiaMedicineStripe.RED -> {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.drogaRaiaRed))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxxs2.dp
                                )
                        ) {
                            Text(
                                text = "VENDA SOB PRESCRIÇÃO MÉDICA",
                                color = Color(WgcCoreDsColors.drogaRaiaSurface),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    DrogaRaiaMedicineStripe.BLACK -> {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.drogaRaiaNavyDark))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxxs2.dp
                                )
                        ) {
                            Text(
                                text = "TARJA PRETA - RETENÇÃO DE RECEITA",
                                color = Color(WgcCoreDsColors.drogaRaiaSurface),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    DrogaRaiaMedicineStripe.GENERIC -> {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.drogaRaiaPrescriptionYellow))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxxs2.dp
                                )
                        ) {
                            Text(
                                text = "MEDICAMENTO GENÉRICO (LEI 9.787/99)",
                                color = Color(WgcCoreDsColors.drogaRaiaNavyDark),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    DrogaRaiaMedicineStripe.NONE -> {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.drogaRaiaGreenLight))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxxs2.dp
                                )
                        ) {
                            Text(
                                text = "PRODUTO DE SAÚDE & BEM-ESTAR",
                                color = Color(WgcCoreDsColors.drogaRaiaGreen),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                IconButton(
                    onClick = onFavoriteToggle,
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = if (isFavorite) Color(WgcCoreDsColors.drogaRaiaRed) else Color(WgcCoreDsColors.drogaRaiaTextSecondary),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Imagem Placeholder & Info
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s80.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.drogaRaiaPlaceholder)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.LocalPharmacy,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.drogaRaiaNavy),
                        modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = laboratory,
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.drogaRaiaTextSecondary),
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.drogaRaiaTextPrimary),
                        maxLines = 2
                    )
                    Text(
                        text = presentation,
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.drogaRaiaTextSecondary)
                    )
                }
            }

            // Alerta de Receita Médica
            if (requiresPrescription) {
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.drogaRaiaPrescriptionYellowLight))
                        .padding(WgcCoreDsSpacing.xs8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.drogaRaiaRedDark),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Apresente a receita no momento da entrega ou retirada",
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.drogaRaiaNavyDark),
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            // Preços & Desconto Programa Sua Farmácia
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    if (originalPrice != null) {
                        Text(
                            text = "De R$ " + String.format("%.2f", originalPrice),
                            fontSize = 14.sp,
                            color = Color(WgcCoreDsColors.drogaRaiaTextSecondary),
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                    Text(
                        text = "R$ " + String.format("%.2f", price),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.drogaRaiaNavy)
                    )

                    if (raiaClientPrice != null) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "R$ " + String.format("%.2f", raiaClientPrice),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.drogaRaiaRed)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = "no Programa Raia",
                                fontSize = 14.sp,
                                color = Color(WgcCoreDsColors.drogaRaiaRed),
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    if (hasSubscription) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.drogaRaiaGreen),
                                modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxxs2.dp))
                            Text(
                                text = "Disponível na Assinatura (10% OFF)",
                                fontSize = 14.sp,
                                color = Color(WgcCoreDsColors.drogaRaiaGreen),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                // Stepper de Quantidade ou Botão Adicionar
                if (quantityInCart > 0) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color(WgcCoreDsColors.drogaRaiaNavyLight))
                            .padding(horizontal = WgcCoreDsSpacing.xs8.dp)
                    ) {
                        IconButton(
                            onClick = { onQuantityChange(quantityInCart - 1) },
                            modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Diminuir",
                                tint = Color(WgcCoreDsColors.drogaRaiaNavy),
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                        }
                        Text(
                            text = quantityInCart.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.drogaRaiaNavy),
                            modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs8.dp)
                        )
                        IconButton(
                            onClick = { onQuantityChange(quantityInCart + 1) },
                            modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Aumentar",
                                tint = Color(WgcCoreDsColors.drogaRaiaNavy),
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                        }
                    }
                } else {
                    WgcClassicButton(
                        textButton = "Comprar",
                        onClick = { onQuantityChange(1) }
                        )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogaRaiaProductCardPreview() {
    WgcDrogaRaiaProductCard(
        title = "Dipirona Monoidratada 500mg/mL",
        laboratory = "EMS Genéricos",
        presentation = "Gotas Frasco com 20mL",
        price = 14.50,
        originalPrice = 19.90,
        raiaClientPrice = 9.90,
        stripe = DrogaRaiaMedicineStripe.GENERIC,
        requiresPrescription = false,
        hasSubscription = true,
        quantityInCart = 1
    )
}
