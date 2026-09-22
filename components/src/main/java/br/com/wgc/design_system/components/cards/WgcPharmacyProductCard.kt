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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

enum class PharmacyMedicineStripe {
    NONE,
    RED,
    BLACK,
    GENERIC
}

@Composable
fun WgcPharmacyProductCard(
    title: String,
    laboratory: String,
    presentation: String,
    price: Double,
    modifier: Modifier = Modifier,
    originalPrice: Double? = null,
    pharmacyClientPrice: Double? = null,
    stripe: PharmacyMedicineStripe = PharmacyMedicineStripe.NONE,
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
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.pharmacyChainSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp),
        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.pharmacyChainBorder))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                when (stripe) {
                    PharmacyMedicineStripe.RED -> {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.pharmacyChainRed))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxxs2.dp
                                )
                        ) {
                            Text(
                                text = "VENDA SOB PRESCRIÇÃO MÉDICA",
                                color = Color(WgcCoreDsColors.pharmacyChainSurface),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    PharmacyMedicineStripe.BLACK -> {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.pharmacyChainNavyDark))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxxs2.dp
                                )
                        ) {
                            Text(
                                text = "TARJA PRETA - RETENÇÃO DE RECEITA",
                                color = Color(WgcCoreDsColors.pharmacyChainSurface),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    PharmacyMedicineStripe.GENERIC -> {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.pharmacyChainPrescriptionYellow))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxxs2.dp
                                )
                        ) {
                            Text(
                                text = "MEDICAMENTO GENÉRICO (LEI 9.787/99)",
                                color = Color(WgcCoreDsColors.pharmacyChainNavyDark),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    PharmacyMedicineStripe.NONE -> {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.pharmacyChainGreenLight))
                                .padding(
                                    horizontal = WgcCoreDsSpacing.xs8.dp,
                                    vertical = WgcCoreDsSpacing.xxxs2.dp
                                )
                        ) {
                            Text(
                                text = "PRODUTO DE SAÚDE & BEM-ESTAR",
                                color = Color(WgcCoreDsColors.pharmacyChainGreen),
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
                        tint = if (isFavorite) Color(WgcCoreDsColors.pharmacyChainRed) else Color(WgcCoreDsColors.pharmacyChainTextSecondary),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(WgcCoreDsSize.s80.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .background(Color(WgcCoreDsColors.pharmacyChainPlaceholder)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.LocalPharmacy,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.pharmacyChainNavy),
                        modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                    )
                }

                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = laboratory,
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.pharmacyChainTextSecondary),
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.pharmacyChainTextPrimary),
                        maxLines = 2
                    )
                    Text(
                        text = presentation,
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.pharmacyChainTextSecondary)
                    )
                }
            }

            if (requiresPrescription) {
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.pharmacyChainPrescriptionYellowLight))
                        .padding(WgcCoreDsSpacing.xs8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.pharmacyChainRedDark),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Apresente a receita no momento da entrega ou retirada",
                        fontSize = 14.sp,
                        color = Color(WgcCoreDsColors.pharmacyChainNavyDark),
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

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
                            color = Color(WgcCoreDsColors.pharmacyChainTextSecondary),
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                    Text(
                        text = "R$ " + String.format("%.2f", price),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.pharmacyChainNavy)
                    )

                    if (pharmacyClientPrice != null) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "R$ " + String.format("%.2f", pharmacyClientPrice),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.pharmacyChainRed)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = "no Programa Pharmacy",
                                fontSize = 14.sp,
                                color = Color(WgcCoreDsColors.pharmacyChainRed),
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    if (hasSubscription) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pharmacyChainGreen),
                                modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxxs2.dp))
                            Text(
                                text = "Disponível na Assinatura (10% OFF)",
                                fontSize = 14.sp,
                                color = Color(WgcCoreDsColors.pharmacyChainGreen),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                if (quantityInCart > 0) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color(WgcCoreDsColors.pharmacyChainNavyLight))
                            .padding(horizontal = WgcCoreDsSpacing.xs8.dp)
                    ) {
                        IconButton(
                            onClick = { onQuantityChange(quantityInCart - 1) },
                            modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Diminuir",
                                tint = Color(WgcCoreDsColors.pharmacyChainNavy),
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                        }
                        Text(
                            text = quantityInCart.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.pharmacyChainNavy),
                            modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs8.dp)
                        )
                        IconButton(
                            onClick = { onQuantityChange(quantityInCart + 1) },
                            modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Aumentar",
                                tint = Color(WgcCoreDsColors.pharmacyChainNavy),
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
private fun WgcPharmacyProductCardPreview() {
    WgcPharmacyProductCard(
        title = "Dipirona Monoidratada 500mg/mL",
        laboratory = "EMS Genéricos",
        presentation = "Gotas Frasco com 20mL",
        price = 14.50,
        originalPrice = 19.90,
        pharmacyClientPrice = 9.90,
        stripe = PharmacyMedicineStripe.GENERIC,
        requiresPrescription = false,
        hasSubscription = true,
        quantityInCart = 1
    )
}
