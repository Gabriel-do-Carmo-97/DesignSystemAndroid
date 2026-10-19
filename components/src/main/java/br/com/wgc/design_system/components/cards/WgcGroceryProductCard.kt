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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import java.util.Locale

/**
 * Retorna a cor correspondente à pontuação oficial do Nutri-Score internacional.
 */
fun getNutriScoreColor(grade: String): Color {
    return when (grade.uppercase(Locale.ROOT)) {
        "A" -> Color(WgcCoreDsColors.green2)
        "B" -> Color(WgcCoreDsColors.green24)
        "C" -> Color(WgcCoreDsColors.yellow9)
        "D" -> Color(WgcCoreDsColors.orange11)
        else -> Color(WgcCoreDsColors.orange12)
    }
}

/**
 * Card de produto de supermercado & hipermercado Supermercado Brasil.
 *
 * Apresenta classificação nutricional Nutri-Score (A a E), preço regular vs
 * preço exclusivo com Cartão Supermercado, condições de parcelamento e stepper de quantidade.
 */
@Composable
fun WgcGroceryProductCard(
    title: String,
    brandLine: String,
    unit: String,
    regularPrice: Double,
    cardSupermercadoPrice: Double,
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
            .width(WgcCoreDsSize.S180.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(WgcCoreDsColors.white)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = WgcCoreDsElevation.LEVEL1.dp
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.S1.dp,
            color = Color(WgcCoreDsColors.blueLight4)
        )
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.XS8.dp)
        ) {
            // Topo: Imagem, Nutri-Score e Favorito
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.S120.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                    .background(Color(WgcCoreDsColors.blueLight30)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingBag,
                    contentDescription = null,
                    modifier = Modifier.size(WgcCoreDsSize.S48.dp),
                    tint = Color(WgcCoreDsColors.blueDark32)
                )

                // Selo Nutri-Score no canto superior esquerdo
                if (!nutriScore.isNullOrBlank()) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.XXS4.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                            .background(getNutriScoreColor(nutriScore))
                            .padding(horizontal = WgcCoreDsSpacing.XS8.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
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
                            .padding(WgcCoreDsSpacing.XXS4.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                            .background(Color(WgcCoreDsColors.red19))
                            .padding(horizontal = WgcCoreDsSpacing.XXS4.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
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
                        .size(WgcCoreDsSize.S32.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = if (isFavorite) Color(WgcCoreDsColors.red19) else Color(WgcCoreDsColors.gray5),
                        modifier = Modifier.size(WgcCoreDsSize.S18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            // Marca / Linha
            Text(
                text = brandLine.uppercase(Locale.ROOT),
                color = Color(WgcCoreDsColors.gray5),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Nome do Produto
            Text(
                text = title,
                color = Color(WgcCoreDsColors.blueDark13),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.height(WgcCoreDsSize.S40.dp)
            )

            // Unidade
            Text(
                text = unit,
                color = Color(WgcCoreDsColors.gray5),
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XXS4.dp))

            // Preço Regular
            Text(
                text = String.format(Locale.GERMANY, "R$ %.2f", regularPrice),
                color = Color(WgcCoreDsColors.gray5),
                style = MaterialTheme.typography.labelSmall,
                textDecoration = TextDecoration.LineThrough
            )

            // Preço Exclusivo Cartão Supermercado
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XXS4.dp)
            ) {
                Text(
                    text = String.format(Locale.GERMANY, "R$ %.2f", cardSupermercadoPrice),
                    color = Color(WgcCoreDsColors.blueDark32),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Black
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                        .background(Color(WgcCoreDsColors.blueLight20))
                        .padding(horizontal = WgcCoreDsSpacing.XXS4.dp, vertical = WgcCoreDsSpacing.XXXS2.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.blueDark32),
                            modifier = Modifier.size(WgcCoreDsSize.S10.dp)
                        )
                        Spacer(modifier = Modifier.size(WgcCoreDsSpacing.XXXS2.dp))
                        Text(
                            text = "Cartão",
                            color = Color(WgcCoreDsColors.blueDark32),
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
                    color = Color(WgcCoreDsColors.blueDark14),
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

            // Botão Adicionar ou Stepper
            if (quantity == 0) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.S32.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                        .background(Color(WgcCoreDsColors.blueDark32))
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
                        .height(WgcCoreDsSize.S32.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp))
                        .border(
                            width = WgcCoreDsSize.S1.dp,
                            color = Color(WgcCoreDsColors.blueDark32),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.SM4.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { onQuantityChange(quantity - 1) },
                        modifier = Modifier.size(WgcCoreDsSize.S32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Diminuir",
                            tint = Color(WgcCoreDsColors.blueDark32),
                            modifier = Modifier.size(WgcCoreDsSize.S14.dp)
                        )
                    }

                    Text(
                        text = "$quantity",
                        color = Color(WgcCoreDsColors.blueDark32),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(
                        onClick = { onQuantityChange(quantity + 1) },
                        modifier = Modifier.size(WgcCoreDsSize.S32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Aumentar",
                            tint = Color(WgcCoreDsColors.blueDark32),
                            modifier = Modifier.size(WgcCoreDsSize.S14.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Supermercado Product Card - Default", showBackground = true)
@Composable
private fun WgcSupermercadoProductCardPreview() {
    WgcGroceryProductCard(
        title = "Arroz Tipo 1 Supermercado Classic 5kg",
        brandLine = "Supermercado Classic",
        unit = "Pacote 5kg",
        regularPrice = 32.90,
        cardSupermercadoPrice = 28.90,
        nutriScore = "A",
        discountPercentage = "-12%",
        quantity = 0
    )
}
