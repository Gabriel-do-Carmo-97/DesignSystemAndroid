package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import java.util.Locale

/**
 * Retorna a cor correspondente à pontuação oficial do Nutri-Score internacional.
 */
fun getNutriScoreColor(grade: String): Color {
    return when (grade.uppercase(Locale.ROOT)) {
        "A" -> Color(WgcCoreDsColors.carrefourNutriScoreA)
        "B" -> Color(WgcCoreDsColors.carrefourNutriScoreB)
        "C" -> Color(WgcCoreDsColors.carrefourNutriScoreC)
        "D" -> Color(WgcCoreDsColors.carrefourNutriScoreD)
        else -> Color(WgcCoreDsColors.carrefourNutriScoreE)
    }
}

/**
 * Card de produto de supermercado & hipermercado Carrefour Brasil.
 *
 * Apresenta classificação nutricional Nutri-Score (A a E), preço regular vs
 * preço exclusivo com Cartão Carrefour, condições de parcelamento e stepper de quantidade.
 */
@Composable
fun WgcCarrefourProductCard(
    title: String,
    brandLine: String,
    unit: String,
    regularPrice: Double,
    cardCarrefourPrice: Double,
    modifier: Modifier = Modifier,
    nutriScore: String? = "A",
    discountPercentage: String? = "-15%",
    installmentsText: String? = "em até 10x sem juros",
    quantity: Int = 0,
    isFavorite: Boolean = false,
    onQuantityChange: (Int) -> Unit = {},
    onFavoriteToggle: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(WgcCoreDsSize.s180.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.carrefourSurface)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = WgcCoreDsElevation.level1.dp
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.carrefourBorder)
        )
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.xs8.dp)
        ) {
            // Topo: Imagem, Nutri-Score e Favorito
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s120.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                    .background(Color(WgcCoreDsColors.carrefourBackground)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingBag,
                    contentDescription = null,
                    modifier = Modifier.size(WgcCoreDsSize.s48.dp),
                    tint = Color(WgcCoreDsColors.carrefourBlue)
                )

                // Selo Nutri-Score no canto superior esquerdo
                if (!nutriScore.isNullOrBlank()) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.xxs4.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(getNutriScoreColor(nutriScore))
                            .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                    ) {
                        Text(
                            text = "NUTRI-SCORE $nutriScore",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Black
                        )
                    }
                }

                // Desconto no canto inferior esquerdo da imagem
                if (!discountPercentage.isNullOrBlank()) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(WgcCoreDsSpacing.xxs4.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(Color(WgcCoreDsColors.carrefourRed))
                            .padding(horizontal = WgcCoreDsSpacing.xxs4.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                    ) {
                        Text(
                            text = discountPercentage,
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // Botão de Favorito no canto superior direito
                IconButton(
                    onClick = onFavoriteToggle,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(WgcCoreDsSize.s32.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = if (isFavorite) Color(WgcCoreDsColors.carrefourRed) else Color(WgcCoreDsColors.carrefourTextSecondary),
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Marca / Linha
            Text(
                text = brandLine.uppercase(Locale.ROOT),
                color = Color(WgcCoreDsColors.carrefourTextSecondary),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Nome do Produto
            Text(
                text = title,
                color = Color(WgcCoreDsColors.carrefourTextPrimary),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.height(WgcCoreDsSize.s40.dp)
            )

            // Unidade
            Text(
                text = unit,
                color = Color(WgcCoreDsColors.carrefourTextSecondary),
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            // Preço Regular
            Text(
                text = String.format(Locale.GERMANY, "R$ %.2f", regularPrice),
                color = Color(WgcCoreDsColors.carrefourTextSecondary),
                style = MaterialTheme.typography.labelSmall,
                textDecoration = TextDecoration.LineThrough
            )

            // Preço Exclusivo Cartão Carrefour
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = String.format(Locale.GERMANY, "R$ %.2f", cardCarrefourPrice),
                    color = Color(WgcCoreDsColors.carrefourBlue),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Black
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.carrefourBlueLight))
                        .padding(horizontal = WgcCoreDsSpacing.xxs4.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.carrefourBlue),
                            modifier = Modifier.size(WgcCoreDsSize.s10.dp)
                        )
                        Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xxxs2.dp))
                        Text(
                            text = "Cartão",
                            color = Color(WgcCoreDsColors.carrefourBlue),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Condições de Parcelamento
            if (!installmentsText.isNullOrBlank()) {
                Text(
                    text = installmentsText,
                    color = Color(WgcCoreDsColors.carrefourBlueDark),
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Botão Adicionar ou Stepper
            if (quantity == 0) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s32.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.carrefourBlue))
                        .clickable { onQuantityChange(1) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "ADICIONAR",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s32.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .border(
                            width = WgcCoreDsSize.s1.dp,
                            color = Color(WgcCoreDsColors.carrefourBlue),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { onQuantityChange(quantity - 1) },
                        modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Diminuir",
                            tint = Color(WgcCoreDsColors.carrefourBlue),
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                    }

                    Text(
                        text = "$quantity",
                        color = Color(WgcCoreDsColors.carrefourBlue),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(
                        onClick = { onQuantityChange(quantity + 1) },
                        modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Aumentar",
                            tint = Color(WgcCoreDsColors.carrefourBlue),
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Carrefour Product Card - Default", showBackground = true)
@Composable
private fun WgcCarrefourProductCardPreview() {
    WgcCarrefourProductCard(
        title = "Arroz Tipo 1 Carrefour Classic 5kg",
        brandLine = "Carrefour Classic",
        unit = "Pacote 5kg",
        regularPrice = 32.90,
        cardCarrefourPrice = 28.90,
        nutriScore = "A",
        discountPercentage = "-12%",
        quantity = 0
    )
}
