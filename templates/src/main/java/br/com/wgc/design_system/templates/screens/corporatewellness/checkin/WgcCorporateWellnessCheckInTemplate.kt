package br.com.wgc.design_system.templates.screens.corporatewellness.checkin

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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcWellnessCheckInCard
import br.com.wgc.design_system.components.navigation.WgcWellnessBottomNav
import br.com.wgc.design_system.components.navigation.WgcCorporateWellnessNavItem
import br.com.wgc.design_system.templates.screens.corporatewellness.model.CorporateWellnessCheckIn
import br.com.wgc.design_system.templates.screens.corporatewellness.model.CorporateWellnessMockData
import br.com.wgc.design_system.templates.screens.corporatewellness.model.CorporateWellnessUserProfile

/**
 * Template de Validação e Execução de Check-In Corporate Wellness (Wellness Network).
 *
 * Apresenta confirmação via GPS, token numérico, QR Code para catraca/recepção e
 * passo a passo de entrada na unidade credenciada.
 *
 * 100% tokenizado com WgcCoreDs e State Hoisting.
 */
@Composable
fun WgcCorporateWellnessCheckInTemplate(
    user: CorporateWellnessUserProfile,
    currentCheckIn: CorporateWellnessCheckIn,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    onConfirmCheckIn: () -> Unit = {},
    selectedNavItem: WgcCorporateWellnessNavItem = WgcCorporateWellnessNavItem.CHECKIN,
    onNavItemClick: (WgcCorporateWellnessNavItem) -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
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
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        if (onBackClick != null) {
                            IconButton(onClick = onBackClick) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Voltar",
                                    tint = Color(WgcCoreDsColors.wellnessDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "CHECK-IN DIÁRIO",
                                color = Color(WgcCoreDsColors.wellnessCoral),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Validação de Entrada",
                                color = Color(WgcCoreDsColors.wellnessDark),
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
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellnessCheckInGreenLight)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellnessCheckInGreen).copy(alpha = 0.3f))
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
                            tint = Color(WgcCoreDsColors.wellnessCheckInGreen),
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Text(
                            text = "Geolocalização verificada: Você está na unidade credenciada",
                            color = Color(WgcCoreDsColors.wellnessForest),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Card Principal de Check-in com Token
            item {
                WgcWellnessCheckInCard(
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
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellnessSurface)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellnessBorder))
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
                            color = Color(WgcCoreDsColors.wellnessSecondaryText),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )

                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s140.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.wellnessCreamBg))
                                .clickable { onConfirmCheckIn() }
                                .padding(WgcCoreDsSpacing.sm12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.QrCode,
                                contentDescription = "QR Code Check-in",
                                tint = Color(WgcCoreDsColors.wellnessForest),
                                modifier = Modifier.size(WgcCoreDsSize.s120.dp)
                            )
                        }

                        Text(
                            text = "Aproxime o leitor da catraca ou mostre na recepção.",
                            color = Color(WgcCoreDsColors.wellnessSecondaryText),
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
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.wellnessSurface)),
                    border = BorderStroke(WgcCoreDsSize.s1.dp, Color(WgcCoreDsColors.wellnessBorder))
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
                                tint = Color(WgcCoreDsColors.wellnessCoral),
                                modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                            )
                            Text(
                                text = "Como funciona a sua entrada",
                                color = Color(WgcCoreDsColors.wellnessDark),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = "1. Você tem direito a 1 check-in presencial por dia em qualquer academia participante do seu plano.\n" +
                                "2. Caso a unidade não utilize catraca com leitor digital, informe o código de 5 dígitos para o atendente.\n" +
                                "3. O check-in é renovado automaticamente todas as noites à meia-noite.",
                            color = Color(WgcCoreDsColors.wellnessSecondaryText),
                            fontSize = 12.sp,
                            lineHeight = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Corporate Wellness Check-in Template - Preview")
@Composable
fun WgcCorporateWellnessCheckInTemplatePreview() {
    WgcCorporateWellnessCheckInTemplate(
        user = CorporateWellnessMockData.mockUser,
        currentCheckIn = CorporateWellnessMockData.mockUser.todayCheckIn!!
    )
}
