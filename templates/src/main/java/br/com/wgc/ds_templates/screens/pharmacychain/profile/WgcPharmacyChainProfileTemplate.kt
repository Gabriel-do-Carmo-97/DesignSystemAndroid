package br.com.wgc.ds_templates.screens.pharmacychain.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.EventRepeat
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.PharmacyNavTab
import br.com.wgc.design_system.components.navigation.WgcPharmacyBottomNav
import br.com.wgc.ds_templates.screens.pharmacychain.model.PharmacyMockData
import br.com.wgc.ds_templates.screens.pharmacychain.model.PharmacyUserProfile

@Composable
fun WgcDrogaRaiaProfileTemplate(
    modifier: Modifier = Modifier,
    userProfile: PharmacyUserProfile = PharmacyMockData.defaultUser,
    activeTab: PharmacyNavTab = PharmacyNavTab.PROFILE,
    onTabSelected: (PharmacyNavTab) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            WgcPharmacyBottomNav(
                selectedTab = activeTab,
                onTabSelected = onTabSelected,
                cartBadgeCount = 2
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                ProfileHeaderCard(userProfile = userProfile)
            }

            item {
                RaiaPointsCard(points = userProfile.pointsBalance)
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.pharmacyChainSurface)),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        ProfileOptionItem(icon = Icons.Default.Description, title = "Minhas Receitas Médicas")
                        HorizontalDivider(color = Color(WgcCoreDsColors.pharmacyChainBorder))
                        ProfileOptionItem(icon = Icons.Default.EventRepeat, title = "Minhas Assinaturas Ativas")
                        HorizontalDivider(color = Color(WgcCoreDsColors.pharmacyChainBorder))
                        ProfileOptionItem(icon = Icons.Default.History, title = "Histórico de Pedidos & Notas Fiscais")
                        HorizontalDivider(color = Color(WgcCoreDsColors.pharmacyChainBorder))
                        ProfileOptionItem(icon = Icons.Default.LocationOn, title = "Endereços Cadastrados")
                        HorizontalDivider(color = Color(WgcCoreDsColors.pharmacyChainBorder))
                        ProfileOptionItem(icon = Icons.Default.Badge, title = "Convênios e Planos de Saúde")
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfileHeaderCard(userProfile: PharmacyUserProfile) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.pharmacyChainNavy)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s56.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.pharmacyChainSurface)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.pharmacyChainNavy),
                    modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

            Column {
                Text(
                    text = userProfile.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pharmacyChainSurface)
                )
                Text(
                    text = "CPF: ${userProfile.cpfMasked}",
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.pharmacyChainSurface).copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Composable
private fun RaiaPointsCard(points: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.pharmacyChainRed)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Stars,
                    contentDescription = null,
                    tint = Color(WgcCoreDsColors.pharmacyChainPrescriptionYellow),
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                Column {
                    Text(
                        text = "Programa de Vantagens",
                        fontSize = 10.sp,
                        color = Color(WgcCoreDsColors.pharmacyChainSurface).copy(alpha = 0.85f)
                    )
                    Text(
                        text = "$points pontos disponíveis",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.pharmacyChainSurface)
                    )
                }
            }

            Icon(
                imageVector = Icons.Default.QrCode,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.pharmacyChainSurface),
                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
            )
        }
    }
}

@Composable
private fun ProfileOptionItem(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.md16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.pharmacyChainNavy),
            modifier = Modifier.size(WgcCoreDsSize.s24.dp)
        )
        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(WgcCoreDsColors.pharmacyChainTextPrimary),
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.pharmacyChainTextSecondary),
            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogaRaiaProfileTemplatePreview() {
    WgcDrogaRaiaProfileTemplate()
}
