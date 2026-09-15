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
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Star
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
 * Card de produto gourmet e supermercado para Pão de Açúcar Mais.
 *
 * Apresenta selos orgânicos/gourmet, preço regular vs preço exclusivo "Cliente Mais",
 * controle de quantidade no carrinho e favorito.
 */
@Composable
fun WgcPdaProductCard(
    title: String,
    brandOrOrigin: String,
    unit: String,
    originalPrice: Double,
    clienteMaisPrice: Double,
    modifier: Modifier = Modifier,
    badgeText: String? = "Orgânico",
    isOrganic: Boolean = false,
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
            containerColor = Color(WgcCoreDsColors.pdaSurface)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = WgcCoreDsElevation.level1.dp
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = WgcCoreDsSize.s1.dp,
            color = Color(WgcCoreDsColors.pdaBorder)
        )
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.xs8.dp)
        ) {
            // Topo da imagem: Badge Gourmet/Orgânico e Ícone de Favorito
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s120.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                    .background(Color(WgcCoreDsColors.pdaBackground)),
                contentAlignment = Alignment.Center
            ) {
                // Mock visual do produto com ícone estilizado
                Icon(
                    imageVector = if (isOrganic) Icons.Default.Eco else Icons.Default.ShoppingBag,
                    contentDescription = null,
                    modifier = Modifier.size(WgcCoreDsSize.s48.dp),
                    tint = if (isOrganic) Color(WgcCoreDsColors.pdaGreen) else Color(WgcCoreDsColors.pdaGold)
                )

                // Tag de Destaque Orgânico ou Importado no canto superior esquerdo
                if (!badgeText.isNullOrBlank()) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(WgcCoreDsSpacing.xxs4.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                            .background(
                                if (isOrganic) Color(WgcCoreDsColors.pdaGreen)
                                else Color(WgcCoreDsColors.pdaGold)
                            )
                            .padding(
                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                vertical = WgcCoreDsSpacing.xxxs2.dp
                            )
                    ) {
                        Text(
                            text = badgeText,
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
                        tint = if (isFavorite) Color(WgcCoreDsColors.pdaWineRed) else Color(WgcCoreDsColors.pdaTextSecondary),
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Marca / Linha Gourmet
            Text(
                text = brandOrOrigin.uppercase(Locale.ROOT),
                color = Color(WgcCoreDsColors.pdaTextSecondary),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Nome do Produto
            Text(
                text = title,
                color = Color(WgcCoreDsColors.pdaTextPrimary),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.height(WgcCoreDsSize.s40.dp)
            )

            // Unidade / Peso
            Text(
                text = unit,
                color = Color(WgcCoreDsColors.pdaTextSecondary),
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

            // Preço Regular riscado
            Text(
                text = String.format(Locale.GERMANY, "R$ %.2f", originalPrice),
                color = Color(WgcCoreDsColors.pdaTextSecondary),
                style = MaterialTheme.typography.labelSmall,
                textDecoration = TextDecoration.LineThrough
            )

            // Bloco de Preço Exclusivo Cliente Mais
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = String.format(Locale.GERMANY, "R$ %.2f", clienteMaisPrice),
                    color = Color(WgcCoreDsColors.pdaGreenDark),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Black
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.pdaGoldLight))
                        .border(
                            width = WgcCoreDsSize.s1.dp,
                            color = Color(WgcCoreDsColors.pdaGold),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                        )
                        .padding(horizontal = WgcCoreDsSpacing.xxs4.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.pdaGoldDark),
                            modifier = Modifier.size(WgcCoreDsSize.s10.dp)
                        )
                        Text(
                            text = "Mais",
                            color = Color(WgcCoreDsColors.pdaGoldDark),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // Seletor de Quantidade ou Botão Adicionar
            if (quantity == 0) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(WgcCoreDsSize.s32.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(Color(WgcCoreDsColors.pdaGreen))
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
                            color = Color(WgcCoreDsColors.pdaGreen),
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
                            tint = Color(WgcCoreDsColors.pdaGreen),
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                    }

                    Text(
                        text = "$quantity",
                        color = Color(WgcCoreDsColors.pdaGreenDark),
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
                            tint = Color(WgcCoreDsColors.pdaGreen),
                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "PDA Product Card - Default", showBackground = true)
@Composable
private fun WgcPdaProductCardPreview() {
    WgcPdaProductCard(
        title = "Azeite de Oliva Extra Virgem Taeq",
        brandOrOrigin = "Taeq Orgânico",
        unit = "500ml",
        originalPrice = 49.90,
        clienteMaisPrice = 39.90,
        badgeText = "100% Orgânico",
        isOrganic = true,
        quantity = 0
    )
}

@Preview(name = "PDA Product Card - In Cart", showBackground = true)
@Composable
private fun WgcPdaProductCardInCartPreview() {
    WgcPdaProductCard(
        title = "Queijo Brie Francês Paysan Breton",
        brandOrOrigin = "Paysan Breton França",
        unit = "200g",
        originalPrice = 38.50,
        clienteMaisPrice = 29.90,
        badgeText = "Importado",
        isOrganic = false,
        quantity = 2,
        isFavorite = true
    )
}
