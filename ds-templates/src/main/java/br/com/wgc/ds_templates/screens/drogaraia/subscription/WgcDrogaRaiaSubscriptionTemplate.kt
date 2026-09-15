package br.com.wgc.ds_templates.screens.drogaraia.subscription

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.EventRepeat
import androidx.compose.material.icons.filled.Percent
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
import br.com.wgc.design_system.components.cards.WgcDrogaRaiaSubscriptionCard
import br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab
import br.com.wgc.design_system.components.navigation.WgcDrogaRaiaBottomNav
import br.com.wgc.ds_templates.screens.drogaraia.model.DrogaRaiaMockData
import br.com.wgc.ds_templates.screens.drogaraia.model.DrogaRaiaSubscriptionItem

@Composable
fun WgcDrogaRaiaSubscriptionTemplate(
    modifier: Modifier = Modifier,
    subscriptions: List<DrogaRaiaSubscriptionItem> = DrogaRaiaMockData.sampleSubscriptions,
    activeTab: DrogaRaiaNavTab = DrogaRaiaNavTab.SUBSCRIPTION,
    onTabSelected: (DrogaRaiaNavTab) -> Unit = {},
    onAddNewSubscription: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.drogaRaiaBackground),
        bottomBar = {
            WgcDrogaRaiaBottomNav(
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
                    text = "Sua Assinatura & Tratamento Contínuo",
                    fontSize = 18.sp.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogaRaiaTextPrimary)
                )
                Text(
                    text = "Receba seus medicamentos na data certa com 10% de desconto e frete grátis",
                    fontSize = 10.sp.sp,
                    color = Color(WgcCoreDsColors.drogaRaiaTextSecondary)
                )
            }

            item {
                SubscriptionBenefitBanner()
            }

            items(subscriptions) { sub ->
                WgcDrogaRaiaSubscriptionCard(
                    medicineName = sub.medicineName,
                    dosageFrequency = sub.frequency,
                    nextDeliveryDate = sub.nextDeliveryDate,
                    monthlyPrice = sub.price
                )
            }

            item {
                WgcClassicButton(
                    text = "Adicionar Novo Medicamento à Assinatura",
                    onClick = onAddNewSubscription,
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.drogaRaiaSurface),
                            modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                        )
                    },
                    containerColor = Color(WgcCoreDsColors.drogaRaiaRed),
                    contentColor = Color(WgcCoreDsColors.drogaRaiaSurface)
                )
            }
        }
    }
}

@Composable
private fun SubscriptionBenefitBanner() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.drogaRaiaGreenLight)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.none0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Percent,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.drogaRaiaGreen),
                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
            Column {
                Text(
                    text = "Vantagens da Assinatura Raia",
                    fontSize = 12.sp.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogaRaiaGreen)
                )
                Text(
                    text = "Cancele ou pause quando quiser sem nenhuma taxa adicional.",
                    fontSize = 10.sp.sp,
                    color = Color(WgcCoreDsColors.drogaRaiaTextSecondary)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogaRaiaSubscriptionTemplatePreview() {
    WgcDrogaRaiaSubscriptionTemplate()
}
