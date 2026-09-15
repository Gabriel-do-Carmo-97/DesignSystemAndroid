package br.com.wgc.ds_templates.screens.wellhub.checkin

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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.QrCode
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
import br.com.wgc.design_system.components.cards.WgcWellhubCheckInCard
import br.com.wgc.design_system.components.navigation.WgcWellhubBottomNav
import br.com.wgc.design_system.components.navigation.WgcWellhubNavItem
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubCheckIn
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubMockData
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubUserProfile

/**
 * Template de Validação e Execução de Check-In Wellhub (Gympass).
 *
 * Apresenta confirmação via GPS, token numérico, QR Code para catraca/recepção e
 * passo a passo de entrada na unidade credenciada.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcWellhubCheckInTemplate(
    user: WellhubUserProfile,
    currentCheckIn: WellhubCheckIn,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    onConfirmCheckIn: () -> Unit = {},
    selectedNavItem: WgcWellhubNavItem = WgcWellhubNavItem.CHECKIN,
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
                                text = "CHECK-IN DIÁRIO",
                                color = Color(WgcCoreDsColors.wellhubCoral),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Validação de Entrada",
                                color = Color(WgcCoreDsColors.wellhubDark),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Indicador de GPS
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellhubCheckInGreenLight)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellhubCheckInGreen).copy(alpha = 0.3f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.wellhubCheckInGreen),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Text(
                            text = "Geolocalização verificada: Você está na unidade credenciada",
                            color = Color(WgcCoreDsColors.wellhubForest),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Card Principal de Check-in com Token
            item {
                WgcWellhubCheckInCard(
                    gymName = currentCheckIn.gymName,
                    userName = user.name,
                    planTitle = currentCheckIn.planTitle,
                    tokenCode = currentCheckIn.tokenCode,
                    validUntil = currentCheckIn.validUntil,
                    isConfirmed = currentCheckIn.isConfirmed,
                    onCopyToken = {},
                    onShowQr = {}
                )
            }

            // QR Code Ampliado para Leitura Óptica na Catraca
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellhubSurface)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellhubBorder))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Text(
                            text = "QR CODE DE ENTRADA",
                            color = Color(WgcCoreDsColors.wellhubSecondaryText),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )

                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s140.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.wellhubCreamBg))
                                .clickable { onConfirmCheckIn() }
                                .padding(WgcCoreDsSpacing.sm12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.QrCode,
                                contentDescription = "QR Code Check-in",
                                tint = Color(WgcCoreDsColors.wellhubForest),
                                modifier = Modifier.size(WgcCoreDsSize.s120.dp)
                            )
                        }

                        Text(
                            text = "Aproxime o leitor da catraca ou mostre na recepção.",
                            color = Color(WgcCoreDsColors.wellhubSecondaryText),
                            fontSize = 12.sp
                        )
                    }
                }
            }

            // Instruções de Entrada
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = WgcCoreDsSpacing.xl32.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellhubSurface)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellhubBorder))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.wellhubCoral),
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                            Text(
                                text = "Como funciona a sua entrada",
                                color = Color(WgcCoreDsColors.wellhubDark),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = "1. Você tem direito a 1 check-in presencial por dia em qualquer academia participante do seu plano.\n" +
                                "2. Caso a unidade não utilize catraca com leitor digital, informe o código de 5 dígitos para o atendente.\n" +
                                "3. O check-in é renovado automaticamente todas as noites à meia-noite.",
                            color = Color(WgcCoreDsColors.wellhubSecondaryText),
                            fontSize = 12.sp,
                            lineHeight = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Wellhub Check-in Template - Preview")
@Composable
fun WgcWellhubCheckInTemplatePreview() {
    WgcWellhubCheckInTemplate(
        user = WellhubMockData.mockUser,
        currentCheckIn = WellhubMockData.mockUser.todayCheckIn!!
    )
}
