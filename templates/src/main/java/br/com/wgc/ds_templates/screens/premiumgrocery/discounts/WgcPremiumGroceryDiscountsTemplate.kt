package br.com.wgc.ds_templates.screens.premiumgrocery.discounts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcPdaBottomNav
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaDiscountItem
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PremiumGroceryMockData

/**
 * Template da Tela "Meu Desconto Gourmet VIP".
 *
 * Central de descontos exclusivos e personalizados por CPF, com ativação
 * em lote de 1 toque e cálculo da economia prevista.
 */
@Composable
fun WgcPdaDiscountsTemplate(
    modifier: Modifier = Modifier,
    discounts: List<PdaDiscountItem> = PremiumGroceryMockData.discounts,
    selectedNavIndex: Int = 2,
    onNavSelect: (Int) -> Unit = {},
    onActivateAllClick: () -> Unit = {},
    onToggleDiscount: (String) -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    val categories = listOf("Todas as Ofertas", "Adega & Sommelier", "Frios & Queijos", "Hortifruti Orgânico", "Mercearia Fina")
    var selectedCategoryIndex by remember { mutableStateOf(0) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            footerSlot?.invoke() ?: WgcPdaBottomNav(
                selectedItem = selectedNavIndex,
                onItemSelected = onNavSelect
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Header Meu Desconto
            item {
                headerSlot?.invoke() ?: Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.premiumGroceryGreenDark))
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalOffer,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.premiumGroceryGold),
                                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                            )
                            Column {
                                Text(
                                    text = "MEU DESCONTO PDA",
                                    color = Color(WgcCoreDsColors.premiumGroceryGold),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Black
                                )
                                Text(
                                    text = "Ofertas Exclusivas por CPF",
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(Color(WgcCoreDsColors.premiumGroceryGold))
                                .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Text(
                                text = "CPF ATIVO",
                                color = Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                    Text(
                        text = "Ative os descontos no aplicativo e eles serão aplicados automaticamente na finalização da compra ou ao informar seu CPF no caixa físico.",
                        color = Color.White.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            // Banner de Ação em Lote: "Ativar Todos os Descontos"
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.premiumGrocerySurface)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = WgcCoreDsElevation.level1.dp
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.premiumGroceryBorder)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Ganhe tempo!",
                                color = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Ative todas as suas ofertas de uma só vez com 1 toque.",
                                color = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        Button(
                            onClick = onActivateAllClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(WgcCoreDsColors.premiumGroceryGreenDark)
                            ),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.TouchApp,
                                contentDescription = null,
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                            Spacer(modifier = Modifier.size(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = "ATIVAR TODOS",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Filtro por Categoria
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(
                        horizontal = WgcCoreDsSpacing.md16.dp
                    )
                ) {
                    items(categories.size) { idx ->
                        val isSelected = selectedCategoryIndex == idx
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(
                                    if (isSelected) Color(WgcCoreDsColors.premiumGroceryGreenDark)
                                    else Color(WgcCoreDsColors.premiumGrocerySurface)
                                )
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = if (isSelected) Color(WgcCoreDsColors.premiumGroceryGreenDark)
                                    else Color(WgcCoreDsColors.premiumGroceryBorder),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .clickable { selectedCategoryIndex = idx }
                                .padding(
                                    horizontal = WgcCoreDsSpacing.sm12.dp,
                                    vertical = WgcCoreDsSpacing.xs8.dp
                                )
                        ) {
                            Text(
                                text = categories[idx],
                                color = if (isSelected) Color.White else Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }

            // Lista de Descontos Personalizados
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    discounts.forEach { disc ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(WgcCoreDsColors.premiumGrocerySurface)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = WgcCoreDsElevation.level1.dp
                            ),
                            border = androidx.compose.foundation.BorderStroke(
                                width = WgcCoreDsSize.s1.dp,
                                color = if (disc.isActivated) Color(WgcCoreDsColors.premiumGroceryGreen)
                                else Color(WgcCoreDsColors.premiumGroceryBorder)
                            )
                        ) {
                            Column(modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                            .background(Color(WgcCoreDsColors.premiumGroceryGoldLight))
                                            .border(
                                                width = WgcCoreDsSize.s1.dp,
                                                color = Color(WgcCoreDsColors.premiumGroceryGold),
                                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                                            )
                                            .padding(
                                                horizontal = WgcCoreDsSpacing.xs8.dp,
                                                vertical = WgcCoreDsSize.s1.dp
                                            )
                                    ) {
                                        Text(
                                            text = disc.discountBadge,
                                            color = Color(WgcCoreDsColors.premiumGroceryGoldDark),
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Schedule,
                                            contentDescription = null,
                                            tint = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                                            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                        )
                                        Text(
                                            text = disc.validUntil,
                                            color = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                                            style = MaterialTheme.typography.labelSmall
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                                Text(
                                    text = disc.title,
                                    color = Color(WgcCoreDsColors.premiumGroceryTextPrimary),
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = disc.economyText,
                                    color = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.SemiBold
                                )

                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = disc.category,
                                        color = Color(WgcCoreDsColors.premiumGroceryTextSecondary),
                                        style = MaterialTheme.typography.labelSmall
                                    )

                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                            .background(
                                                if (disc.isActivated) Color(WgcCoreDsColors.premiumGroceryGreenLight)
                                                else Color(WgcCoreDsColors.premiumGroceryGreen)
                                            )
                                            .clickable { onToggleDiscount(disc.id) }
                                            .padding(
                                                horizontal = WgcCoreDsSpacing.sm12.dp,
                                                vertical = WgcCoreDsSpacing.xs8.dp
                                            )
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                        ) {
                                            if (disc.isActivated) {
                                                Icon(
                                                    imageVector = Icons.Default.Check,
                                                    contentDescription = null,
                                                    tint = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                                )
                                                Text(
                                                    text = "ATIVADO",
                                                    color = Color(WgcCoreDsColors.premiumGroceryGreenDark),
                                                    style = MaterialTheme.typography.labelSmall,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            } else {
                                                Text(
                                                    text = "ATIVAR DESCONTO",
                                                    color = Color.White,
                                                    style = MaterialTheme.typography.labelSmall,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "PDA Discounts Template", showBackground = true)
@Composable
private fun WgcPdaDiscountsTemplatePreview() {
    WgcPdaDiscountsTemplate()
}
