package br.com.wgc.design_system.templates.screens.hypermarket.loyalty

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcExtraBottomNav
import br.com.wgc.design_system.components.navigation.WgcExtraNavItem
import br.com.wgc.design_system.templates.screens.hypermarket.model.HypermarketMockData
import br.com.wgc.design_system.templates.screens.hypermarket.model.ExtraStampsLoyalty

/**
 * Item do Catálogo de Prêmios da Campanha Juntou & Ganhou.
 */
data class ExtraLoyaltyReward(
    val id: String,
    val name: String,
    val description: String,
    val requiredStamps: Int,
    val regularPrice: String,
    val specialPriceWithStamps: String
)

/**
 * Template da Tela de Fidelidade "Juntou Ganhou" do Clube Extra.
 *
 * Apresenta a cartela digital de selos acumulados em compras,
 * regras da campanha e catálogo de resgate de produtos importados.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcExtraLoyaltyTemplate(
    stamps: ExtraStampsLoyalty,
    modifier: Modifier = Modifier,
    onShowCashierQrClick: () -> Unit = {},
    selectedNavItem: WgcExtraNavItem = WgcExtraNavItem.PROFILE,
    onNavItemClick: (WgcExtraNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    val mockRewards = listOf(
        ExtraLoyaltyReward(
            id = "rew_1",
            name = "Panela Wok Royal VKB 28cm",
            description = "Alumínio fundido antiaderente compatível com indução",
            requiredStamps = 30,
            regularPrice = "R$ 299,90",
            specialPriceWithStamps = "R$ 49,90"
        ),
        ExtraLoyaltyReward(
            id = "rew_2",
            name = "Caçarola com Tampa Royal VKB 24cm",
            description = "Revestimento em granito cerâmico de alta resistência",
            requiredStamps = 25,
            regularPrice = "R$ 249,90",
            specialPriceWithStamps = "R$ 39,90"
        ),
        ExtraLoyaltyReward(
            id = "rew_3",
            name = "Faca Chef em Aço Inox 20cm",
            description = "Lâmina forjada de alta precisão com cabo ergonômico",
            requiredStamps = 15,
            regularPrice = "R$ 129,90",
            specialPriceWithStamps = "R$ 19,90"
        )
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcExtraBottomNav(
                    selectedItem = selectedNavItem,
                    onItemSelected = onNavItemClick
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header
            item {
                if (slotHeader != null) {
                    slotHeader()
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Stars,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.hypermarketOrange),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                            Text(
                                text = "JUNTOU & GANHOU EXTRA",
                                color = Color(WgcCoreDsColors.hypermarketOrange),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                        }

                        Text(
                            text = "Sua Cartela Digital",
                            color = Color(WgcCoreDsColors.hypermarketDark),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
            }

            // Cartela Digital de Selos
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.hypermarketSurface)),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.hypermarketBorder)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "SELOS ACUMULADOS",
                                color = Color(WgcCoreDsColors.hypermarketSecondaryText),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.5.sp
                            )

                            Text(
                                text = "${stamps.currentStamps} de ${stamps.targetStamps} Selos",
                                color = Color(WgcCoreDsColors.hypermarketOrange),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black
                            )
                        }

                        // Simulação visual de selos (Grade compacta)
                        val totalSlots = 30
                        val columns = 6
                        val rows = totalSlots / columns

                        for (r in 0 until rows) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                for (c in 0 until columns) {
                                    val slotIndex = r * columns + c + 1
                                    val isFilled = slotIndex <= stamps.currentStamps

                                    Box(
                                        modifier = Modifier
                                            .size(WgcCoreDsSize.s40.dp)
                                            .clip(CircleShape)
                                            .background(
                                                if (isFilled) Color(WgcCoreDsColors.hypermarketOrange) else Color(WgcCoreDsColors.hypermarketBackground)
                                            )
                                            .border(
                                                width = WgcCoreDsSize.s1.dp,
                                                color = if (isFilled) Color(WgcCoreDsColors.hypermarketOrange) else Color(WgcCoreDsColors.hypermarketBorder),
                                                shape = CircleShape
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (isFilled) {
                                            Icon(
                                                imageVector = Icons.Default.Stars,
                                                contentDescription = "Selo $slotIndex",
                                                tint = Color.White,
                                                modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                                            )
                                        } else {
                                            Text(
                                                text = "$slotIndex",
                                                color = Color(WgcCoreDsColors.hypermarketSecondaryText),
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        // Botão de Identificação para o Caixa
                        Button(
                            onClick = onShowCashierQrClick,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = WgcCoreDsSpacing.xs8.dp)
                                .height(WgcCoreDsSize.s44.dp),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(WgcCoreDsColors.hypermarketOrange),
                                contentColor = Color.White
                            )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.QrCode,
                                    contentDescription = null,
                                    modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                )
                                Text(
                                    text = "MOSTRAR QR CODE NO CAIXA",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 0.5.sp
                                )
                            }
                        }
                    }
                }
            }

            // Título Catálogo de Prêmios
            item {
                Text(
                    text = "PRÊMIOS DISPONÍVEIS PARA RESGATE",
                    color = Color(WgcCoreDsColors.hypermarketDark),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }

            // Lista de Prêmios
            items(mockRewards, key = { it.id }) { reward ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.hypermarketSurface)),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.hypermarketBorder)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = reward.name,
                                color = Color(WgcCoreDsColors.hypermarketDark),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(Color(WgcCoreDsColors.hypermarketOrangeLight))
                                    .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                            ) {
                                Text(
                                    text = "${reward.requiredStamps} Selos",
                                    color = Color(WgcCoreDsColors.hypermarketOrange),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Text(
                            text = reward.description,
                            color = Color(WgcCoreDsColors.hypermarketSecondaryText),
                            fontSize = 12.sp
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "De ${reward.regularPrice}",
                                    color = Color(WgcCoreDsColors.hypermarketSecondaryText),
                                    fontSize = 11.sp
                                )
                                Text(
                                    text = "Por ${reward.specialPriceWithStamps} + Selos",
                                    color = Color(WgcCoreDsColors.hypermarketRed),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }

                            val canRedeem = stamps.currentStamps >= reward.requiredStamps
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                    .background(
                                        if (canRedeem) Color(WgcCoreDsColors.hypermarketSuccessGreenLight) else Color(WgcCoreDsColors.hypermarketBackground)
                                    )
                                    .padding(horizontal = WgcCoreDsSpacing.sm12.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Text(
                                    text = if (canRedeem) "PRONTO PARA RESGATAR" else "FALTAM ${reward.requiredStamps - stamps.currentStamps} SELOS",
                                    color = if (canRedeem) Color(WgcCoreDsColors.hypermarketSuccessGreen) else Color(WgcCoreDsColors.hypermarketSecondaryText),
                                    fontSize = 11.sp,
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

@Preview(name = "Clube Extra Loyalty Template - Preview")
@Composable
fun WgcExtraLoyaltyTemplatePreview() {
    WgcExtraLoyaltyTemplate(
        stamps = HypermarketMockData.mockStamps
    )
}
