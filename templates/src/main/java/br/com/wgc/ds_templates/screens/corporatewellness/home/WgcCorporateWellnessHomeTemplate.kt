package br.com.wgc.ds_templates.screens.corporatewellness.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcWellnessCheckInCard
import br.com.wgc.design_system.components.cards.WgcWellnessGymCard
import br.com.wgc.design_system.components.navigation.WgcWellnessBottomNav
import br.com.wgc.design_system.components.navigation.WgcCorporateWellnessNavItem
import br.com.wgc.ds_templates.screens.corporatewellness.model.CorporateWellnessGym
import br.com.wgc.ds_templates.screens.corporatewellness.model.CorporateWellnessMockData
import br.com.wgc.ds_templates.screens.corporatewellness.model.CorporateWellnessUserProfile

/**
 * Template da Tela Inicial (Home) do Corporate Wellness (Wellness Network).
 *
 * Apresenta saudação corporativa, resumo do check-in de hoje, academias próximas recomendadas,
 * frequência mensal e atalhos rápidos para bem-estar.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcCorporateWellnessHomeTemplate(
    user: CorporateWellnessUserProfile,
    nearbyGyms: List<CorporateWellnessGym>,
    modifier: Modifier = Modifier,
    onOpenExplore: () -> Unit = {},
    onOpenCheckIn: () -> Unit = {},
    onOpenPlans: () -> Unit = {},
    onOpenWellness: () -> Unit = {},
    onSelectGym: ((CorporateWellnessGym) -> Unit)? = null,
    selectedNavItem: WgcCorporateWellnessNavItem = WgcCorporateWellnessNavItem.HOME,
    onNavItemClick: (WgcCorporateWellnessNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotCheckInBanner: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcWellnessBottomNav(
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
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Text(
                                    text = "WELLNESS",
                                    color = Color(WgcCoreDsColors.wellnessCoral),
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                        .background(Color(user.currentTier.colorHex).copy(alpha = 0.12f))
                                        .clickable { onOpenPlans() }
                                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                                ) {
                                    Text(
                                        text = "PLANO ${user.currentTier.label.uppercase()}",
                                        color = Color(user.currentTier.colorHex),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Text(
                                text = "Olá, ${user.name.split(" ").firstOrNull() ?: "Colaborador"}!",
                                color = Color(WgcCoreDsColors.wellnessDark),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = user.company,
                                color = Color(WgcCoreDsColors.wellnessSecondaryText),
                                fontSize = 12.sp
                            )
                        }

                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notificações",
                                tint = Color(WgcCoreDsColors.wellnessDark),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }
                    }
                }
            }

            // Check-in de Hoje
            item {
                if (slotCheckInBanner != null) {
                    slotCheckInBanner()
                } else if (user.todayCheckIn != null) {
                    val checkIn = user.todayCheckIn
                    WgcWellnessCheckInCard(
                        gymName = checkIn.gymName,
                        userName = user.name,
                        planTitle = checkIn.planTitle,
                        tokenCode = checkIn.tokenCode,
                        validUntil = checkIn.validUntil,
                        onShowQr = onOpenCheckIn,
                        onCopyToken = {}
                    )
                } else {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onOpenCheckIn() },
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellnessForest)),
                        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level3.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(WgcCoreDsSize.s48.dp)
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                        .background(Color.White.copy(alpha = 0.15f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.QrCode,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                    )
                                }
                                Column {
                                    Text(
                                        text = "FAZER CHECK-IN DE HOJE",
                                        color = Color.White,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                    Text(
                                        text = "Você tem 1 check-in disponível hoje",
                                        color = Color.White.copy(alpha = 0.8f),
                                        fontSize = 12.sp
                                    )
                                }
                            }

                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }
                    }
                }
            }

            // Estatísticas rápidas de uso
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellnessSurface)),
                        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellnessBorder))
                    ) {
                        Column(
                            modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.FitnessCenter,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.wellnessCoral),
                                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                )
                                Text(
                                    text = "Este Mês",
                                    color = Color(WgcCoreDsColors.wellnessSecondaryText),
                                    fontSize = 11.sp
                                )
                            }
                            Text(
                                text = "${user.checkInsThisMonth} treinos",
                                color = Color(WgcCoreDsColors.wellnessDark),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }

                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellnessSurface)),
                        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellnessBorder))
                    ) {
                        Column(
                            modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocalFireDepartment,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.wellnessTierGold),
                                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                )
                                Text(
                                    text = "Sequência Ativa",
                                    color = Color(WgcCoreDsColors.wellnessSecondaryText),
                                    fontSize = 11.sp
                                )
                            }
                            Text(
                                text = "${user.activeStreakDays} dias seguidos",
                                color = Color(WgcCoreDsColors.wellnessDark),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }
                }
            }

            // Academias perto de você
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ACADEMIAS PERTO DE VOCÊ",
                        color = Color(WgcCoreDsColors.wellnessSecondaryText),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "Ver mapa",
                        color = Color(WgcCoreDsColors.wellnessCoral),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { onOpenExplore() }
                    )
                }
            }

            items(nearbyGyms.take(DEFAULT_HOME_GYMS_LIMIT), key = { it.id }) { gym ->
                WgcWellnessGymCard(
                    name = gym.name,
                    category = gym.category,
                    address = gym.address,
                    distance = gym.distance,
                    rating = gym.rating,
                    reviewsCount = gym.reviewsCount,
                    requiredTier = gym.requiredTier,
                    isIncludedInUserPlan = true,
                    onClick = { onSelectGym?.invoke(gym) },
                    onCheckInClick = onOpenCheckIn
                )
            }

            // Banner Apps de Bem-Estar
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOpenWellness() }
                        .padding(bottom = WgcCoreDsSpacing.xl32.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellnessForestLight)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellnessBorder))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s40.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(Color(WgcCoreDsColors.wellnessForest)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Spa,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "BEM-ESTAR CORPORATIVO",
                                    color = Color(WgcCoreDsColors.wellnessForest),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 0.5.sp
                                )
                                Text(
                                    text = "Ative Calm e Headspace sem custo adicional no seu plano Gold.",
                                    color = Color(WgcCoreDsColors.wellnessDark),
                                    fontSize = 13.sp
                                )
                            }
                        }

                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.wellnessForest),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Corporate Wellness Home Template - Preview")
@Composable
fun WgcCorporateWellnessHomeTemplatePreview() {
    WgcCorporateWellnessHomeTemplate(
        user = CorporateWellnessMockData.mockUser,
        nearbyGyms = CorporateWellnessMockData.mockGyms
    )
}

private const val DEFAULT_HOME_GYMS_LIMIT = 3

