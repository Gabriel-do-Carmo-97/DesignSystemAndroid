package br.com.wgc.ds_templates.screens.smartfit.home

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
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.QrCode
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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcSmartFitUnitCrowdCard
import br.com.wgc.design_system.components.navigation.WgcSmartFitBottomNav
import br.com.wgc.design_system.components.navigation.WgcSmartFitNavItem
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitGymUnit
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitMockData
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitUserProfile
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitWorkoutRoutine

/**
 * Template da Tela Inicial (Home) do Smart Fit.
 *
 * Apresenta saudação ao aluno, indicador de plano Black, status de lotação da unidade favorita,
 * botão de catraca rápida, ficha do dia e atalhos rápidos de aulas e vídeos.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcSmartFitHomeTemplate(
    user: SmartFitUserProfile,
    currentUnit: SmartFitGymUnit,
    todayRoutine: SmartFitWorkoutRoutine,
    modifier: Modifier = Modifier,
    onOpenQrPass: () -> Unit = {},
    onOpenWorkouts: () -> Unit = {},
    onOpenClasses: () -> Unit = {},
    onOpenGoVideos: () -> Unit = {},
    onOpenUnitDetails: () -> Unit = {},
    selectedNavItem: WgcSmartFitNavItem = WgcSmartFitNavItem.HOME,
    onNavItemClick: (WgcSmartFitNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotCrowdCard: (@Composable () -> Unit)? = null,
    slotTodayWorkout: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.smartfitBlack),
        bottomBar = {
            if (slotBottomNav != null) {
                slotBottomNav()
            } else {
                WgcSmartFitBottomNav(
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
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Text(
                                    text = "SMART FIT",
                                    color = Color(WgcCoreDsColors.smartfitYellow),
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs2.dp))
                                        .background(Color(WgcCoreDsColors.smartfitYellow))
                                        .padding(horizontal = WgcCoreDsSpacing.xxs4.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                                ) {
                                    Text(
                                        text = "BLACK",
                                        color = Color(WgcCoreDsColors.smartfitTextInverse),
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                            }
                            Text(
                                text = "Olá, ${user.name.split(" ").firstOrNull() ?: "Aluno"}!",
                                color = Color(WgcCoreDsColors.smartfitTextPrimary),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notificações",
                                tint = Color(WgcCoreDsColors.smartfitTextPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                        }
                    }
                }
            }

            // Acesso Rápido à Catraca (Aproximação / QR)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                        .clickable { onOpenQrPass() },
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.smartfitYellow)
                    ),
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
                                    .background(Color.Black),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.QrCode,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.smartfitYellow),
                                    modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "LIBERAR CATRACA",
                                    color = Color(WgcCoreDsColors.smartfitTextInverse),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Black
                                )
                                Text(
                                    text = "Toque para abrir seu QR Code de acesso",
                                    color = Color(WgcCoreDsColors.smartfitTextInverse).copy(alpha = 0.8f),
                                    fontSize = 12.sp
                                )
                            }
                        }

                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.smartfitTextInverse),
                            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                        )
                    }
                }
            }

            // Minha Unidade & Status de Lotação
            item {
                if (slotCrowdCard != null) {
                    slotCrowdCard()
                } else {
                    Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                        Text(
                            text = "MINHA UNIDADE",
                            color = Color(WgcCoreDsColors.smartfitTextSecondary),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                        WgcSmartFitUnitCrowdCard(
                            unitName = currentUnit.name,
                            address = "${currentUnit.address} • ${currentUnit.distance}",
                            operatingHours = currentUnit.operatingHours,
                            crowdLevel = currentUnit.crowdLevel,
                            crowdPercentage = currentUnit.crowdPercentage,
                            hourlyDistribution = currentUnit.hourlyDistribution,
                            onNavigateClick = onOpenUnitDetails
                        )
                    }
                }
            }

            // Treino do Dia
            item {
                if (slotTodayWorkout != null) {
                    slotTodayWorkout()
                } else {
                    Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "SEU TREINO DE HOJE",
                                color = Color(WgcCoreDsColors.smartfitTextSecondary),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Ver ficha completa",
                                color = Color(WgcCoreDsColors.smartfitYellow),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.clickable { onOpenWorkouts() }
                            )
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onOpenWorkouts() },
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(WgcCoreDsColors.smartfitDarkGray)
                            ),
                            border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.smartfitMediumGray)),
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
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(WgcCoreDsSize.s32.dp)
                                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                                .background(Color(WgcCoreDsColors.smartfitYellow)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = todayRoutine.letter,
                                                color = Color(WgcCoreDsColors.smartfitTextInverse),
                                                fontWeight = FontWeight.Black,
                                                fontSize = 16.sp
                                            )
                                        }
                                        Column {
                                            Text(
                                                text = todayRoutine.title,
                                                color = Color(WgcCoreDsColors.smartfitTextPrimary),
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = todayRoutine.focus,
                                                color = Color(WgcCoreDsColors.smartfitTextSecondary),
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }

                                // Progresso do treino
                                Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "Progresso de execução",
                                            color = Color(WgcCoreDsColors.smartfitTextSecondary),
                                            fontSize = 11.sp
                                        )
                                        Text(
                                            text = "${todayRoutine.completedCount} de ${todayRoutine.totalCount} exercícios",
                                            color = Color(WgcCoreDsColors.smartfitYellow),
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }

                                    LinearProgressIndicator(
                                        progress = { todayRoutine.progressPercentage },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(WgcCoreDsSize.s8.dp)
                                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                                        color = Color(WgcCoreDsColors.smartfitYellow),
                                        trackColor = Color(WgcCoreDsColors.smartfitMediumGray)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Atalhos rápidos: Aulas & Smart Fit GO
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = WgcCoreDsSpacing.xl32.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onOpenClasses() },
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.smartfitDarkGray)),
                        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.smartfitMediumGray))
                    ) {
                        Column(
                            modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.FitnessCenter,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.smartfitYellow),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                            Text(
                                text = "Grade de Aulas",
                                color = Color(WgcCoreDsColors.smartfitTextPrimary),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Reserve sua vaga",
                                color = Color(WgcCoreDsColors.smartfitTextSecondary),
                                fontSize = 11.sp
                            )
                        }
                    }

                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onOpenGoVideos() },
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.smartfitDarkGray)),
                        border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.smartfitMediumGray))
                    ) {
                        Column(
                            modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayCircle,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.smartfitYellow),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                            Text(
                                text = "Smart Fit GO",
                                color = Color(WgcCoreDsColors.smartfitTextPrimary),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Treine em casa",
                                color = Color(WgcCoreDsColors.smartfitTextSecondary),
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Smart Fit Home Template - Preview")
@Composable
fun WgcSmartFitHomeTemplatePreview() {
    WgcSmartFitHomeTemplate(
        user = SmartFitMockData.mockUser,
        currentUnit = SmartFitMockData.mockUnits.first(),
        todayRoutine = SmartFitMockData.mockRoutines.first()
    )
}
