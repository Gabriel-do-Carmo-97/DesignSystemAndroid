package br.com.wgc.design_system.templates.screens.gymfitness.profile

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
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
import br.com.wgc.design_system.components.cards.WgcGymQrPassCard
import br.com.wgc.design_system.components.navigation.WgcGymBottomNav
import br.com.wgc.design_system.components.navigation.WgcGymFitnessNavItem
import br.com.wgc.design_system.templates.screens.gymfitness.model.GymFitnessMockData
import br.com.wgc.design_system.templates.screens.gymfitness.model.GymFitnessUserProfile

/**
 * Template de Perfil, Catraca e Benefícios Black da Gym & Fitness.
 *
 * Apresenta a carteirinha virtual ampliada com QR Code de acesso à catraca,
 * estatísticas mensais de frequência, vantagens ativas do Plano Black e opções da conta.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcGymFitnessProfilePassTemplate(
    user: GymFitnessUserProfile,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    onRefreshQr: () -> Unit = {},
    onCheckIn: () -> Unit = {},
    onManagePlan: () -> Unit = {},
    selectedNavItem: WgcGymFitnessNavItem = WgcGymFitnessNavItem.PROFILE,
    onNavItemClick: (WgcGymFitnessNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotPassCard: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    val weekDaysLabels = listOf("S", "T", "Q", "Q", "S", "S", "D")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcGymBottomNav(
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
                                    tint = Color(WgcCoreDsColors.gymTextPrimary),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "ACESSO & PERFIL",
                                color = Color(WgcCoreDsColors.gymYellow),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Carteirinha Digital",
                                color = Color(WgcCoreDsColors.gymTextPrimary),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // QR Pass Card
            item {
                if (slotPassCard != null) {
                    slotPassCard()
                } else {
                    WgcGymQrPassCard(
                        studentName = user.name,
                        planTitle = user.planTitle,
                        membershipId = user.membershipId,
                        unitName = user.homeUnit,
                        onRefreshCode = onRefreshQr,
                        onCheckInClick = onCheckIn
                    )
                }
            }

            // Frequência do Mês e Meta
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.gymDarkGray)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.gymMediumGray))
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
                                text = "Frequência Mensal",
                                color = Color(WgcCoreDsColors.gymTextPrimary),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "${user.daysTrainedThisMonth} de ${user.monthlyGoal} treinos",
                                color = Color(WgcCoreDsColors.gymYellow),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        LinearProgressIndicator(
                            progress = { user.daysTrainedThisMonth.toFloat() / user.monthlyGoal },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s8.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                            color = Color(WgcCoreDsColors.gymYellow),
                            trackColor = Color(WgcCoreDsColors.gymMediumGray)
                        )

                        // Dias da semana treinados
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            weekDaysLabels.forEachIndexed { index, label ->
                                val trained = user.weeklyCheckins.getOrNull(index) ?: false
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(WgcCoreDsSize.s28.dp)
                                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                            .background(
                                                if (trained) Color(WgcCoreDsColors.gymYellow)
                                                else Color(WgcCoreDsColors.gymMediumGray)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (trained) {
                                            Icon(
                                                imageVector = Icons.Default.Check,
                                                contentDescription = null,
                                                tint = Color(WgcCoreDsColors.gymTextInverse),
                                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                            )
                                        }
                                    }
                                    Text(
                                        text = label,
                                        color = Color(WgcCoreDsColors.gymTextSecondary),
                                        fontSize = 10.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Benefícios do Plano Black
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.gymDarkGray)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.gymMediumGray))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.gymYellow),
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                            Text(
                                text = "Benefícios do seu Plano Black",
                                color = Color(WgcCoreDsColors.gymTextPrimary),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        // Lista de Benefícios
                        listOf(
                            Icons.Default.Public to "Acesso a todas as unidades da América Latina",
                            Icons.Default.People to "Levar até 5 amigos por mês para treinar junto",
                            Icons.Default.Spa to "Acesso livre às cadeiras de massagem e Smart Spa"
                        ).forEach { (icon, desc) ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(WgcCoreDsSize.s32.dp)
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                        .background(Color(WgcCoreDsColors.gymMediumGray)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.gymYellow),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                }
                                Text(
                                    text = desc,
                                    color = Color(WgcCoreDsColors.gymTextPrimary),
                                    fontSize = 12.sp,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }
            }

            // Atalhos da Conta
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = WgcCoreDsSpacing.xl32.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    listOf(
                        Icons.Default.MonitorWeight to "Bioimpedância Gym & Fitness",
                        Icons.Default.CreditCard to "Gerenciar Assinatura e Faturas",
                        Icons.AutoMirrored.Filled.HelpOutline to "Central de Ajuda e Suporte"
                    ).forEach { (icon, title) ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onManagePlan() },
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.gymDarkGray)),
                            border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.gymMediumGray))
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                                ) {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.gymYellow),
                                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                    )
                                    Text(
                                        text = title,
                                        color = Color(WgcCoreDsColors.gymTextPrimary),
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                                Icon(
                                    imageVector = Icons.Default.ChevronRight,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.gymTextSecondary),
                                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Gym & Fitness Profile Pass Template - Preview")
@Composable
fun WgcGymFitnessProfilePassTemplatePreview() {
    WgcGymFitnessProfilePassTemplate(
        user = GymFitnessMockData.mockUser
    )
}
