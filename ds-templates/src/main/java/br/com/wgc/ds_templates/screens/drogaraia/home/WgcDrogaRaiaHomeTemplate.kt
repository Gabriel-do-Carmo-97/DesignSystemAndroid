package br.com.wgc.ds_templates.screens.drogaraia.home

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
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import br.com.wgc.core_ds.WgcCoreDsFontSize
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcDrogaRaiaPrescriptionCard
import br.com.wgc.design_system.components.cards.WgcDrogaRaiaProductCard
import br.com.wgc.design_system.components.navigation.DrogaRaiaNavTab
import br.com.wgc.design_system.components.navigation.WgcDrogaRaiaBottomNav
import br.com.wgc.ds_templates.screens.drogaraia.model.DrogaRaiaMockData
import br.com.wgc.ds_templates.screens.drogaraia.model.DrogaRaiaProduct
import br.com.wgc.ds_templates.screens.drogaraia.model.DrogaRaiaUserProfile

@Composable
fun WgcDrogaRaiaHomeTemplate(
    modifier: Modifier = Modifier,
    userProfile: DrogaRaiaUserProfile = DrogaRaiaMockData.defaultUser,
    products: List<DrogaRaiaProduct> = DrogaRaiaMockData.sampleProducts,
    activeTab: DrogaRaiaNavTab = DrogaRaiaNavTab.HOME,
    onTabSelected: (DrogaRaiaNavTab) -> Unit = {},
    onProductClick: (DrogaRaiaProduct) -> Unit = {},
    onUploadPrescription: () -> Unit = {},
    onTalkToPharmacist: () -> Unit = {}
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
            contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.xl32.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header Droga Raia com Busca e Localização
            item {
                RaiaHeaderSection(userProfile = userProfile)
            }

            // Card de Prescrição Médica & Farmacêutico Digital
            item {
                Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
                    WgcDrogaRaiaPrescriptionCard(
                        onUploadPrescription = onUploadPrescription,
                        onTalkToPharmacist = onTalkToPharmacist
                    )
                }
            }

            // Banner Entrega Vizinha / Expressa
            item {
                RaiaFastDeliveryBanner()
            }

            // Título Seção Medicamentos & Produtos
            item {
                Text(
                    text = "Mais Vendidos e Cuidados Pessoais",
                    fontSize = WgcCoreDsFontSize.lg18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.drogaRaiaTextPrimary),
                    modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)
                )
            }

            // Lista de Produtos Farmacêuticos
            items(products) { product ->
                Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
                    WgcDrogaRaiaProductCard(
                        title = product.title,
                        laboratory = product.laboratory,
                        presentation = product.presentation,
                        price = product.price,
                        originalPrice = product.originalPrice,
                        raiaClientPrice = product.raiaClientPrice,
                        stripe = product.stripe,
                        requiresPrescription = product.requiresPrescription,
                        hasSubscription = product.hasSubscription,
                        onCardClick = { onProductClick(product) }
                    )
                }
            }
        }
    }
}

@Composable
private fun RaiaHeaderSection(userProfile: DrogaRaiaUserProfile) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(WgcCoreDsColors.drogaRaiaRed))
            .padding(WgcCoreDsSpacing.md16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.drogaRaiaSurface),
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "Entregar em: ${userProfile.address}",
                        color = Color(WgcCoreDsColors.drogaRaiaSurface),
                        fontSize = WgcCoreDsFontSize.xs12.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Buscar medicamentos, cosméticos, marcas...",
                        fontSize = WgcCoreDsFontSize.sm14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color(WgcCoreDsColors.drogaRaiaTextSecondary),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.full9999.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(WgcCoreDsColors.drogaRaiaSurface),
                    unfocusedContainerColor = Color(WgcCoreDsColors.drogaRaiaSurface),
                    focusedBorderColor = Color(WgcCoreDsColors.drogaRaiaSurface),
                    unfocusedBorderColor = Color(WgcCoreDsColors.drogaRaiaSurface)
                ),
                singleLine = true,
                readOnly = true
            )
        }
    }
}

@Composable
private fun RaiaFastDeliveryBanner() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.drogaRaiaNavy)),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocalShipping,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.drogaRaiaPrescriptionYellow),
                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))
            Column {
                Text(
                    text = "Entrega Rápida em até 1 hora",
                    color = Color(WgcCoreDsColors.drogaRaiaSurface),
                    fontSize = WgcCoreDsFontSize.sm14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Ou retire grátis em qualquer farmácia Raia em 15 minutos",
                    color = Color(WgcCoreDsColors.drogaRaiaSurface).copy(alpha = 0.85f),
                    fontSize = WgcCoreDsFontSize.xs12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcDrogaRaiaHomeTemplatePreview() {
    WgcDrogaRaiaHomeTemplate()
}
