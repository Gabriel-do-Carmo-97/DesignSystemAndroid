package br.com.wgc.ds_templates.factories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.commons.WgcStatusDevicePreviews
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.buttons.WgcClassicButton

/**
 * Catálogo Universal de Variantes de Perfil do Design System.
 * Preserva 100% de cada especialização de vertical e marca do ecossistema.
 */
enum class WgcProfileType {
    CARE_PHARMACY,
    PHARMACY_CHAIN,
    POPULAR_PHARMACY,
    FRESH_GROCERY,
    GROCERY,
    PREMIUM_GROCERY,
    FINTECH_NEOBANK,
    FINTECH_CARBON,
    FINTECH_SUPERAPP,
    CURATED_MARKET,
    GADGET_SHOP,
    GYM_FITNESS,
    MEGA_STORE,
    PROPERTY_CLASSIFIEDS,
    PROPERTY_LISTING,
    PROPERTY_RENTAL,
    QUICK_SHOP,
    RETAIL,
    TREND_FASHION,
    GAMING_STORE,
    LIVE_STREAMING,
    STANDARD
}

/**
 * Status de ciclo de vida do Perfil para renderização com State Hoisting.
 */
enum class WgcProfileStatus {
    DEFAULT,
    LOADING,
    DISABLED,
    ERROR
}

/**
 * Modelo de dados de usuário para o perfil corporativo padrão.
 */
data class WgcProfileUserData(
    val name: String = "Gabriel do Carmo",
    val email: String = "gabriel.carmo@wgc.com.br",
    val badge: String = "Cliente VIP",
    val avatarUrl: String? = null
)

/**
 * Fábrica Universal de Perfil do Design System (WgcProfileFactory).
 *
 * Provê alternância entre todas as 22 variantes oficiais preservadas do ecossistema WGC,
 * defaults sensatos de produção e slots customizáveis para injeção granular.
 */
@Composable
fun WgcProfileFactory(
    modifier: Modifier = Modifier,
    type: WgcProfileType = WgcProfileType.STANDARD,
    status: WgcProfileStatus = WgcProfileStatus.DEFAULT,
    user: WgcProfileUserData = WgcProfileUserData(),
    headerSlot: (@Composable () -> Unit)? = null,
    contentSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null,
    onLogoutClick: () -> Unit = {}
) {
    when (status) {
        WgcProfileStatus.LOADING -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
            return
        }
        WgcProfileStatus.DISABLED -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Perfil indisponível",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            return
        }
        WgcProfileStatus.ERROR -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Erro ao carregar perfil",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))
                    WgcClassicButton(textButton = "Tentar novamente", onClick = {})
                }
            }
            return
        }
        else -> Unit
    }

    when (type) {
        WgcProfileType.CARE_PHARMACY -> br.com.wgc.ds_templates.screens.carepharmacy.profile.WgcCarePharmacyProfileTemplate(modifier = modifier)
        WgcProfileType.PHARMACY_CHAIN -> br.com.wgc.ds_templates.screens.pharmacychain.profile.WgcPharmacyChainProfileTemplate(modifier = modifier)
        WgcProfileType.POPULAR_PHARMACY -> br.com.wgc.ds_templates.screens.popularpharmacy.profile.WgcPopularPharmacyProfileTemplate(modifier = modifier)
        WgcProfileType.FRESH_GROCERY -> br.com.wgc.ds_templates.screens.freshgrocery.profile.WgcFreshGroceryProfileTemplate(modifier = modifier)
        WgcProfileType.GROCERY -> br.com.wgc.ds_templates.screens.grocery.profile.WgcGroceryProfileTemplate(modifier = modifier)
        WgcProfileType.PREMIUM_GROCERY -> br.com.wgc.ds_templates.screens.premiumgrocery.profile.WgcPremiumGroceryClienteMaisProfileTemplate(modifier = modifier)
        WgcProfileType.FINTECH_NEOBANK -> br.com.wgc.ds_templates.screens.fintechneobank.WgcFintechNeobankProfileTemplate(modifier = modifier)
        WgcProfileType.FINTECH_CARBON -> br.com.wgc.ds_templates.screens.fintechcarbon.WgcFintechCarbonProfileTemplate(modifier = modifier)
        WgcProfileType.FINTECH_SUPERAPP -> br.com.wgc.ds_templates.screens.fintechsuperapp.WgcFintechSuperAppProfileTemplate(modifier = modifier)
        WgcProfileType.CURATED_MARKET -> br.com.wgc.ds_templates.screens.curatedmarket.profile.WgcCuratedMarketProfileTemplate(modifier = modifier)
        WgcProfileType.GADGET_SHOP -> br.com.wgc.ds_templates.screens.gadgetshop.profile.WgcGadgetShopProfileTemplate(modifier = modifier)
        WgcProfileType.GYM_FITNESS -> br.com.wgc.ds_templates.screens.gymfitness.profile.WgcGymFitnessProfilePassTemplate(modifier = modifier)
        WgcProfileType.MEGA_STORE -> br.com.wgc.ds_templates.screens.megastore.profile.WgcShoppeProfileScreenTemplate(modifier = modifier)
        WgcProfileType.PROPERTY_CLASSIFIEDS -> br.com.wgc.ds_templates.screens.propertyclassifieds.profile.WgcPropertyClassifiedsProfileTemplate(modifier = modifier)
        WgcProfileType.PROPERTY_LISTING -> br.com.wgc.ds_templates.screens.propertylisting.profile.WgcPropertyListingProfileTemplate(modifier = modifier)
        WgcProfileType.PROPERTY_RENTAL -> br.com.wgc.ds_templates.screens.propertyrental.profile.WgcPropertyRentalProfileTemplate(modifier = modifier)
        WgcProfileType.QUICK_SHOP -> br.com.wgc.ds_templates.screens.quickshop.profile.WgcQuickShopProfileTemplate(modifier = modifier)
        WgcProfileType.RETAIL -> br.com.wgc.ds_templates.screens.retail.profile.WgcKutukuSettingsScreen(modifier = modifier)
        WgcProfileType.TREND_FASHION -> br.com.wgc.ds_templates.screens.trendfashion.profile.WgcStylishProfileScreenTemplate(modifier = modifier)
        WgcProfileType.GAMING_STORE -> br.com.wgc.ds_templates.screens.gamingstore.WgcGamingStoreProfileTemplate(modifier = modifier)
        WgcProfileType.LIVE_STREAMING -> br.com.wgc.ds_templates.screens.livestreaming.WgcLiveStreamingProfileTemplate(modifier = modifier)
        WgcProfileType.STANDARD -> WgcStandardProfileLayout(
            modifier = modifier,
            user = user,
            headerSlot = headerSlot,
            contentSlot = contentSlot,
            footerSlot = footerSlot,
            onLogoutClick = onLogoutClick
        )
    }
}

/**
 * Layout padrão corporativo de perfil com seções agrupadas, header com avatar e slots.
 */
@Composable
private fun WgcStandardProfileLayout(
    modifier: Modifier = Modifier,
    user: WgcProfileUserData,
    headerSlot: (@Composable () -> Unit)?,
    contentSlot: (@Composable () -> Unit)?,
    footerSlot: (@Composable () -> Unit)?,
    onLogoutClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Header
            if (headerSlot != null) {
                headerSlot()
            } else {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                    ) {
                        WgcAvatar(
                            url = user.avatarUrl,
                            contentDescription = user.name
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = user.name,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = user.email,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(Modifier.height(WgcCoreDsSpacing.xs4.dp))
                            Surface(
                                shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Text(
                                    text = user.badge,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Content
            if (contentSlot != null) {
                contentSlot()
            } else {
                Text(
                    text = "Configurações da Conta",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column {
                        ProfileMenuRow(Icons.Default.Person, "Dados Pessoais")
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                        ProfileMenuRow(Icons.Default.LocationOn, "Endereços Cadastrados")
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                        ProfileMenuRow(Icons.Default.CreditCard, "Cartões e Formas de Pagamento")
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                        ProfileMenuRow(Icons.Default.Notifications, "Notificações & Alertas")
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                        ProfileMenuRow(Icons.Default.Lock, "Segurança e Senha")
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                        ProfileMenuRow(Icons.Default.HelpOutline, "Central de Ajuda & Suporte")
                    }
                }
            }

            // Footer
            if (footerSlot != null) {
                footerSlot()
            } else {
                Spacer(Modifier.height(WgcCoreDsSpacing.sm8.dp))
                WgcClassicButton(
                    textButton = "Sair da Conta",
                    onClick = onLogoutClick
                )
            }
        }
    }
}

@Composable
private fun ProfileMenuRow(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.md16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(22.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outline,
            modifier = Modifier.size(16.dp)
        )
    }
}

// --- PREVIEWS MULTI-DEVICE & MULTI-STATUS ---

@WgcDevicePreviews
@Preview(name = "Profile Factory - Standard Default", showBackground = true)
@Composable
private fun WgcProfileFactoryDefaultPreview() {
    WgcProfileFactory(
        type = WgcProfileType.STANDARD,
        status = WgcProfileStatus.DEFAULT
    )
}

@WgcDevicePreviews
@Preview(name = "Profile Factory - Loading", showBackground = true)
@Composable
private fun WgcProfileFactoryLoadingPreview() {
    WgcProfileFactory(
        type = WgcProfileType.STANDARD,
        status = WgcProfileStatus.LOADING
    )
}

@WgcDevicePreviews
@Preview(name = "Profile Factory - Disabled", showBackground = true)
@Composable
private fun WgcProfileFactoryDisabledPreview() {
    WgcProfileFactory(
        type = WgcProfileType.STANDARD,
        status = WgcProfileStatus.DISABLED
    )
}

@WgcDevicePreviews
@Preview(name = "Profile Factory - Error", showBackground = true)
@Composable
private fun WgcProfileFactoryErrorPreview() {
    WgcProfileFactory(
        type = WgcProfileType.STANDARD,
        status = WgcProfileStatus.ERROR
    )
}

@WgcDevicePreviews
@Preview(name = "Profile Factory - Fresh Grocery", showBackground = true)
@Composable
private fun WgcProfileFactoryFreshGroceryPreview() {
    WgcProfileFactory(
        type = WgcProfileType.FRESH_GROCERY
    )
}

@WgcDevicePreviews
@Preview(name = "Profile Factory - Care Pharmacy", showBackground = true)
@Composable
private fun WgcProfileFactoryCarePharmacyPreview() {
    WgcProfileFactory(
        type = WgcProfileType.CARE_PHARMACY
    )
}

@WgcDevicePreviews
@Preview(name = "Profile Factory - Gaming Store", showBackground = true)
@Composable
private fun WgcProfileFactoryGamingStorePreview() {
    WgcProfileFactory(
        type = WgcProfileType.GAMING_STORE
    )
}
