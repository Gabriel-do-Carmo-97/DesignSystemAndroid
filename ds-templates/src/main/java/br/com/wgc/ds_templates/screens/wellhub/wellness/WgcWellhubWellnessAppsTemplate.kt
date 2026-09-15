package br.com.wgc.ds_templates.screens.wellhub.wellness

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
import androidx.compose.material.icons.filled.Check
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
import br.com.wgc.design_system.components.navigation.WgcWellhubBottomNav
import br.com.wgc.design_system.components.navigation.WgcWellhubNavItem
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubMockData
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubWellnessApp

/**
 * Template de Aplicativos de Bem-Estar Inclusos no Wellhub.
 *
 * Apresenta o catálogo de apps de meditação, sono, terapia e nutrição
 * disponíveis para ativação imediata pelo colaborador.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcWellhubWellnessAppsTemplate(
    apps: List<WellhubWellnessApp>,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    onToggleActivateApp: ((appId: String, activate: Boolean) -> Unit)? = null,
    selectedNavItem: WgcWellhubNavItem = WgcWellhubNavItem.WELLNESS,
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
                                text = "SAÚDE INTEGRAL",
                                color = Color(WgcCoreDsColors.wellhubCoral),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Apps de Bem-Estar",
                                color = Color(WgcCoreDsColors.wellhubDark),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Banner explicativo
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
                            text = "ACESSO PREMIUM INCLUSO",
                            color = Color(WgcCoreDsColors.wellhubForest),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = "Além das academias, você tem acesso livre às versões premium dos " +
                                "principais aplicativos globais de saúde mental e nutrição.",
                            color = Color(WgcCoreDsColors.wellhubDark),
                            fontSize = 13.sp
                        )
                    }
                }
            }

            // Lista de Apps
            items(apps, key = { it.id }) { app ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellhubSurface)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellhubBorder)),
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
                            verticalAlignment = Alignment.Top
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(WgcCoreDsSize.s48.dp)
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                        .background(Color(WgcCoreDsColors.wellhubCoralLight)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Spa,
                                        contentDescription = null,
                                        tint = Color(WgcCoreDsColors.wellhubCoral),
                                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                    )
                                }

                                Column {
                                    Text(
                                        text = app.name,
                                        color = Color(WgcCoreDsColors.wellhubDark),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = app.category,
                                        color = Color(WgcCoreDsColors.wellhubSecondaryText),
                                        fontSize = 12.sp
                                    )
                                }
                            }

                            if (app.isActivated) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                                        .background(Color(WgcCoreDsColors.wellhubCheckInGreenLight))
                                        .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null,
                                            tint = Color(WgcCoreDsColors.wellhubCheckInGreen),
                                            modifier = Modifier.size(WgcCoreDsSize.s12.dp)
                                        )
                                        Text(
                                            text = "ATIVADO",
                                            color = Color(WgcCoreDsColors.wellhubCheckInGreen),
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }

                        Text(
                            text = app.description,
                            color = Color(WgcCoreDsColors.wellhubSecondaryText),
                            fontSize = 13.sp
                        )

                        // Botão de Ativação / Acesso
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(
                                    if (app.isActivated) Color(WgcCoreDsColors.wellhubCreamBg)
                                    else Color(WgcCoreDsColors.wellhubCoral)
                                )
                                .clickable {
                                    onToggleActivateApp?.invoke(app.id, !app.isActivated)
                                }
                                .padding(vertical = WgcCoreDsSpacing.xs8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (app.isActivated) "ABRIR APLICATIVO" else "ATIVAR ACESSO GRATUITO",
                                color = if (app.isActivated) Color(WgcCoreDsColors.wellhubDark) else Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
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

@Preview(name = "Wellhub Wellness Apps - Preview")
@Composable
fun WgcWellhubWellnessAppsTemplatePreview() {
    WgcWellhubWellnessAppsTemplate(
        apps = WellhubMockData.mockWellnessApps
    )
}
