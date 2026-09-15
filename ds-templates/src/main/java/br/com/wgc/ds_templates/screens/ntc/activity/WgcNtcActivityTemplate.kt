package br.com.wgc.ds_templates.screens.ntc.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.WorkspacePremium
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcNtcBottomNav
import br.com.wgc.design_system.components.navigation.WgcNtcNavItem
import br.com.wgc.ds_templates.screens.ntc.model.NtcActivityStats
import br.com.wgc.ds_templates.screens.ntc.model.NtcMockData

/**
 * Template da Tela de Atividades, Conquistas e Histórico Nike Training Club (NTC).
 *
 * Apresenta o placar atlético com sequências ininterruptas (streak),
 * métricas semanais consolidadas e mural de medalhas/conquistas desbloqueadas.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcNtcActivityTemplate(
    stats: NtcActivityStats,
    modifier: Modifier = Modifier,
    selectedNavItem: WgcNtcNavItem = WgcNtcNavItem.ACTIVITY,
    onNavItemClick: (WgcNtcNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.ntcBlack),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcNtcBottomNav(
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
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.ntcVolt),
                                    modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                                )
                                Text(
                                    text = "SUA ATIVIDADE",
                                    color = Color(WgcCoreDsColors.ntcVolt),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )
                            }
                            Text(
                                text = "Histórico & Conquistas",
                                color = Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Black
                            )
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                .background(Color(WgcCoreDsColors.ntcDarkGray))
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = Color(WgcCoreDsColors.ntcMediumGray),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                                )
                                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Text(
                                text = "${stats.totalWorkoutsAllTime} Treinos",
                                color = Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Banner do Streak
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.ntcDarkGray)),
                    border = androidx.compose.foundation.BorderStroke(
                        WgcCoreDsSize.s1.dp,
                        Color(WgcCoreDsColors.ntcOrange).copy(alpha = 0.5f)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.lg24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s52.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.ntcOrange).copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalFireDepartment,
                                contentDescription = "Fogo do Streak",
                                tint = Color(WgcCoreDsColors.ntcOrange),
                                modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                            )
                        }

                        Column {
                            Text(
                                text = "SEQUÊNCIA DE ${stats.currentStreakDays} DIAS 🔥",
                                color = Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "Você está em ritmo de atleta profissional. Continue treinando amanhã para manter o fogo aceso!",
                                color = Color(WgcCoreDsColors.ntcSecondaryText),
                                fontSize = 12.sp,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            }

            // Cards de Métricas Semanais (3 colunas / Row)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    // Minutos
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.ntcDarkGray)),
                        border = androidx.compose.foundation.BorderStroke(
                            WgcCoreDsSize.s1.dp,
                            Color(WgcCoreDsColors.ntcMediumGray)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.sm12.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Schedule,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.ntcVolt),
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                            Text(
                                text = "${stats.weeklyMinutes}",
                                color = Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "Minutos",
                                color = Color(WgcCoreDsColors.ntcSecondaryText),
                                fontSize = 11.sp
                            )
                        }
                    }

                    // Calorias
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.ntcDarkGray)),
                        border = androidx.compose.foundation.BorderStroke(
                            WgcCoreDsSize.s1.dp,
                            Color(WgcCoreDsColors.ntcMediumGray)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.sm12.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalFireDepartment,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.ntcOrange),
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                            Text(
                                text = "${stats.weeklyCalories}",
                                color = Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "Calorias",
                                color = Color(WgcCoreDsColors.ntcSecondaryText),
                                fontSize = 11.sp
                            )
                        }
                    }

                    // Treinos Realizados
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.ntcDarkGray)),
                        border = androidx.compose.foundation.BorderStroke(
                            WgcCoreDsSize.s1.dp,
                            Color(WgcCoreDsColors.ntcMediumGray)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.sm12.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.FitnessCenter,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.ntcBlue),
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                            Text(
                                text = "${stats.workoutsThisWeek}",
                                color = Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "Treinos",
                                color = Color(WgcCoreDsColors.ntcSecondaryText),
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }

            // Mural de Conquistas / Medalhas
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "MURAL DE CONQUISTAS",
                        color = Color(WgcCoreDsColors.ntcWhite),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = "${stats.badges.size} Desbloqueadas",
                        color = Color(WgcCoreDsColors.ntcVolt),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Lista de Medalhas
            items(stats.badges, key = { it.id }) { badge ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.ntcDarkGray)),
                    border = androidx.compose.foundation.BorderStroke(
                        WgcCoreDsSize.s1.dp,
                        Color(WgcCoreDsColors.ntcMediumGray)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s44.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.ntcStreakGold).copy(alpha = 0.18f))
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = Color(WgcCoreDsColors.ntcStreakGold),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.WorkspacePremium,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.ntcStreakGold),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = badge.title,
                                color = Color(WgcCoreDsColors.ntcWhite),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = badge.description,
                                color = Color(WgcCoreDsColors.ntcSecondaryText),
                                fontSize = 12.sp
                            )
                        }

                        Text(
                            text = badge.achievedDate,
                            color = Color(WgcCoreDsColors.ntcVolt),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "NTC Activity Template - Preview")
@Composable
fun WgcNtcActivityTemplatePreview() {
    WgcNtcActivityTemplate(
        stats = NtcMockData.mockStats
    )
}
