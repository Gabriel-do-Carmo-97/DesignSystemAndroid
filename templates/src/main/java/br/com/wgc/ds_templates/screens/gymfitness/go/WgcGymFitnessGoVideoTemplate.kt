package br.com.wgc.ds_templates.screens.gymfitness.go

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Timer
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
import br.com.wgc.design_system.components.navigation.WgcGymBottomNav
import br.com.wgc.design_system.components.navigation.WgcGymFitnessNavItem
import br.com.wgc.ds_templates.screens.gymfitness.model.GymFitnessMockData
import br.com.wgc.ds_templates.screens.gymfitness.model.GymFitnessVideoWorkout

/**
 * Template do Gym & Fitness GO (Treinos em Vídeo e On-Demand).
 *
 * Apresenta catálogo de treinos digitais divididos por intensidade, duração e gasto calórico.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcGymFitnessGoVideoTemplate(
    videos: List<GymFitnessVideoWorkout>,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    onSelectVideo: ((GymFitnessVideoWorkout) -> Unit)? = null,
    selectedNavItem: WgcGymFitnessNavItem = WgcGymFitnessNavItem.GO,
    onNavItemClick: (WgcGymFitnessNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null
) {
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
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                            ) {
                                Text(
                                    text = "GYM FITNESS",
                                    color = Color(WgcCoreDsColors.gymYellow),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs2.dp))
                                        .background(Color(WgcCoreDsColors.gymYellow))
                                        .padding(horizontal = WgcCoreDsSpacing.xxs4.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                                ) {
                                    Text(
                                        text = "GO",
                                        color = Color(WgcCoreDsColors.gymTextInverse),
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                            }
                            Text(
                                text = "Treine Onde Quiser",
                                color = Color(WgcCoreDsColors.gymTextPrimary),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Banner Destaque
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
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = "PROGRAMAS COMPLETOS EM VÍDEO",
                            color = Color(WgcCoreDsColors.gymYellow),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = "Hiit, Alongamento, Dança e Força guiados pelos melhores personais do Brasil.",
                            color = Color(WgcCoreDsColors.gymTextPrimary),
                            fontSize = 14.sp
                        )
                    }
                }
            }

            // Lista de Vídeos
            items(videos, key = { it.id }) { video ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelectVideo?.invoke(video) },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.gymDarkGray)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.gymMediumGray)),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Thumbnail simulada com player overlay
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s140.dp)
                                .clip(
                                    RoundedCornerShape(
                                        topStart = WgcCoreDsBorderRadius.lg12.dp,
                                        topEnd = WgcCoreDsBorderRadius.lg12.dp
                                    )
                                )
                                .background(Color(WgcCoreDsColors.gymCardPlaceholder)),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s52.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                    .background(Color(WgcCoreDsColors.gymYellow)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = "Assistir Vídeo",
                                    tint = Color(WgcCoreDsColors.gymTextInverse),
                                    modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                                )
                            }

                            // Badge de Duração
                            Box(
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .padding(WgcCoreDsSpacing.xs8.dp)
                                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs2.dp))
                                    .background(Color.Black.copy(alpha = 0.8f))
                                    .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxxs2.dp)
                            ) {
                                Text(
                                    text = video.duration,
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        // Informações do Treino em Vídeo
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Text(
                                text = video.category.uppercase(),
                                color = Color(WgcCoreDsColors.gymYellow),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.5.sp
                            )
                            Text(
                                text = video.title,
                                color = Color(WgcCoreDsColors.gymTextPrimary),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp),
                                modifier = Modifier.padding(top = WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.gymTextSecondary),
                                        modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                                    )
                                    Text(
                                        text = video.trainer,
                                        color = Color(WgcCoreDsColors.gymTextSecondary),
                                        fontSize = 11.sp
                                    )
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocalFireDepartment,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.gymCrowdMedium),
                                        modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                                    )
                                    Text(
                                        text = video.caloriesBurned,
                                        color = Color(WgcCoreDsColors.gymTextSecondary),
                                        fontSize = 11.sp
                                    )
                                }

                                Text(
                                    text = video.intensity,
                                    color = Color(WgcCoreDsColors.gymAccentCyan),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            item {
                Box(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
            }
        }
    }
}

@Preview(name = "Gym & Fitness GO Video Template - Preview")
@Composable
fun WgcGymFitnessGoVideoTemplatePreview() {
    WgcGymFitnessGoVideoTemplate(
        videos = GymFitnessMockData.mockGoVideos
    )
}
