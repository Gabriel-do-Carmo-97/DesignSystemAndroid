package br.com.wgc.ds_templates.screens.wellhub.plans

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import br.com.wgc.design_system.components.cards.WgcWellhubPlanCard
import br.com.wgc.design_system.components.cards.WgcWellhubPlanTier
import br.com.wgc.design_system.components.navigation.WgcWellhubBottomNav
import br.com.wgc.design_system.components.navigation.WgcWellhubNavItem
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubMockData
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubPlan

/**
 * Template de Comparação e Escolha de Planos Corporativos Wellhub.
 *
 * Apresenta todas as faixas (Starter, Basic, Silver, Gold, Platinum), valores subsidiados,
 * academias inclusas e botão de upgrade.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcWellhubPlansTemplate(
    plans: List<WellhubPlan>,
    currentTier: WgcWellhubPlanTier,
    modifier: Modifier = Modifier,
    companyName: String = "Tech Corporation Brasil",
    onBackClick: (() -> Unit)? = null,
    onSelectPlan: ((WellhubPlan) -> Unit)? = null,
    selectedNavItem: WgcWellhubNavItem = WgcWellhubNavItem.PROFILE,
    onNavItemClick: (WgcWellhubNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcWellhubBottomNav(
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        if (onBackClick != null) {
                            IconButton(onClick = onBackClick) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Voltar",
                                    tint = Color(WgcCoreDsColors.wellhubDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "BENEFÍCIO CORPORATIVO",
                                color = Color(WgcCoreDsColors.wellhubCoral),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Escolha seu Plano",
                                color = Color(WgcCoreDsColors.wellhubDark),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Banner do subsídio corporativo
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellhubForestLight)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellhubBorder))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = "SUBSÍDIO DE ATÉ 70%",
                            color = Color(WgcCoreDsColors.wellhubForest),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = "A $companyName oferece planos exclusivos para você cuidar do corpo e da mente.",
                            color = Color(WgcCoreDsColors.wellhubDark),
                            fontSize = 13.sp
                        )
                    }
                }
            }

            // Lista de Planos
            items(plans, key = { it.tier.name }) { plan ->
                val isCurrent = plan.tier == currentTier
                WgcWellhubPlanCard(
                    tier = plan.tier,
                    monthlyPrice = plan.monthlyPrice,
                    gymCountLabel = plan.gymCountLabel,
                    benefits = plan.benefits,
                    isCurrentPlan = isCurrent,
                    discountBadge = plan.discountBadge,
                    onSelectPlan = { onSelectPlan?.invoke(plan) }
                )
            }

            // Garantia Sem Fidelidade
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = WgcCoreDsSpacing.xl32.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellhubSurface)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellhubBorder))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Security,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.wellhubCheckInGreen),
                            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                        )
                        Column {
                            Text(
                                text = "Sem carência e sem fidelidade",
                                color = Color(WgcCoreDsColors.wellhubDark),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Cancele ou pause sua assinatura a qualquer momento diretamente pelo app.",
                                color = Color(WgcCoreDsColors.wellhubSecondaryText),
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Wellhub Plans Template - Preview")
@Composable
fun WgcWellhubPlansTemplatePreview() {
    WgcWellhubPlansTemplate(
        plans = WellhubMockData.mockPlans,
        currentTier = WgcWellhubPlanTier.GOLD
    )
}
