package br.com.wgc.ds_templates.screens.pharmacychain.prescriptions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.cards.WgcPharmacyPrescriptionCard
import br.com.wgc.design_system.components.navigation.PharmacyNavTab
import br.com.wgc.design_system.components.navigation.WgcPharmacyBottomNav

@Composable
fun WgcDrogaRaiaPrescriptionTemplate(
    modifier: Modifier = Modifier,
    activeTab: PharmacyNavTab = PharmacyNavTab.PRESCRIPTIONS,
    onTabSelected: (PharmacyNavTab) -> Unit = {},
    onUploadClick: () -> Unit = {},
    onConsultPharmacist: () -> Unit = {}
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
                Text(
                    text = "Receitas Médicas & Prescrições",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pharmacyChainTextPrimary)
                )
                Text(
                    text = "Envie receitas digitais (CFM / Memed) ou fotos de receitas físicas",
                    fontSize = 10.sp,
                    color = Color(WgcCoreDsColors.pharmacyChainTextSecondary)
                )
            }

            item {
                WgcPharmacyPrescriptionCard(
                    onUploadPrescription = onUploadClick,
                    onTalkToPharmacist = onConsultPharmacist
                )
            }

            item {
                Text(
                    text = "Minhas Receitas Ativas",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.pharmacyChainTextPrimary)
                )
            }

            item {
                PrescriptionItemCard(
                    doctorName = "Dr. Roberto Antunes (CRM 148920/SP)",
                    medicinesCount = 2,
                    issueDate = "10/09/2026",
                    validUntil = "10/10/2026",
                    status = "Aprovada pelo Farmacêutico"
                )
            }

            item {
                PrescriptionItemCard(
                    doctorName = "Dra. Camila Soares (CRM 204192/SP)",
                    medicinesCount = 1,
                    issueDate = "01/09/2026",
                    validUntil = "01/12/2026",
                    status = "Uso Contínuo (Válida)"
                )
            }
        }
    }
}

@Composable
private fun PrescriptionItemCard(
    doctorName: String,
    medicinesCount: Int,
    issueDate: String,
    validUntil: String,
    status: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.pharmacyChainSurface)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.pharmacyChainNavy),
                        modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = doctorName,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.pharmacyChainTextPrimary)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.pharmacyChainGreen),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = status,
                        fontSize = 9.sp,
                        color = Color(WgcCoreDsColors.pharmacyChainGreen),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            Text(
                text = "$medicinesCount medicamento(s) prescrito(s) • Emitida em $issueDate • Válida até $validUntil",
                fontSize = 10.sp,
                color = Color(WgcCoreDsColors.pharmacyChainTextSecondary)
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            WgcClassicButton(
                textButton = "Comprar Medicamentos da Receita",
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogaRaiaPrescriptionTemplatePreview() {
    WgcDrogaRaiaPrescriptionTemplate()
}
