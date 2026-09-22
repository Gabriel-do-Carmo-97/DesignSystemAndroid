@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.factories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.apparel.cart.WgcClotheeCartTemplate
import br.com.wgc.design_system.templates.screens.boutique.cart.WgcLazaCartTemplate
import br.com.wgc.design_system.templates.screens.carepharmacy.cart.WgcDrogasilCartTemplate
import br.com.wgc.design_system.templates.screens.cart.FakeStandardCartViewModel
import br.com.wgc.design_system.templates.screens.cart.StandardCartScreenTemplate
import br.com.wgc.design_system.templates.screens.curatedmarket.cart.WgcTasselCartTemplate
import br.com.wgc.design_system.templates.screens.freshgrocery.cart.WgcFreshGroceryCartTemplate
import br.com.wgc.design_system.templates.screens.gadgetshop.cart.WgcNexkartCartTemplate
import br.com.wgc.design_system.templates.screens.grocery.cart.WgcSupermercadoCartTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.cart.WgcExtraCartTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.model.ExtraCartItem
import br.com.wgc.design_system.templates.screens.hypermarket.model.HypermarketMockData
import br.com.wgc.design_system.templates.screens.megastore.checkout.WgcShoppeCartScreenTemplate
import br.com.wgc.design_system.templates.screens.pharmacychain.cart.WgcDrogaRaiaCartTemplate
import br.com.wgc.design_system.templates.screens.popularpharmacy.cart.WgcPagueMenosCartTemplate
import br.com.wgc.design_system.templates.screens.premiumgrocery.cart.WgcPdaGourmetCartTemplate
import br.com.wgc.design_system.templates.screens.retail.checkout.WgcKutukuCartScreen

/**
 * Variantes de Carrinho suportadas pela [WgcCartFactory].
 */
enum class WgcCartType {
    STANDARD,
    MEGA_STORE,
    RETAIL,
    GADGET_SHOP,
    BOUTIQUE,
    FRESH_GROCERY,
    CURATED_MARKET,
    APPAREL,
    HYPERMARKET,
    PREMIUM_GROCERY,
    GROCERY,
    PHARMACY_CHAIN,
    CARE_PHARMACY,
    POPULAR_PHARMACY
}

/**
 * Fábrica Universal de Carrinhos de Compra (WgcCartFactory).
 *
 * Ponto de entrada unificado para todas as variações de carrinho do ecossistema,
 * integrando os fluxos existentes e suportando custom slots cirúrgicos.
 */
@Suppress("LongMethod", "CyclomaticComplexMethod", "ReturnCount")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcCartFactory(
    modifier: Modifier = Modifier,
    type: WgcCartType = WgcCartType.STANDARD,
    topBarSlot: (@Composable () -> Unit)? = null,
    cartItemsSlot: (@Composable () -> Unit)? = null,
    voucherSlot: (@Composable () -> Unit)? = null,
    summarySlot: (@Composable () -> Unit)? = null,
    checkoutButtonSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {},
    onCheckoutClick: () -> Unit = {}
) {
    val hasCustomSlots = topBarSlot != null || cartItemsSlot != null ||
        voucherSlot != null || summarySlot != null || checkoutButtonSlot != null

    if (!hasCustomSlots) {
        when (type) {
            WgcCartType.STANDARD -> {
                StandardCartScreenTemplate(viewModel = FakeStandardCartViewModel())
                return
            }
            WgcCartType.MEGA_STORE -> {
                WgcShoppeCartScreenTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onCheckoutClick = onCheckoutClick
                )
                return
            }
            WgcCartType.RETAIL -> {
                WgcKutukuCartScreen(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onCheckoutClick = { onCheckoutClick() }
                )
                return
            }
            WgcCartType.GADGET_SHOP -> {
                WgcNexkartCartTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onCheckoutClick = onCheckoutClick
                )
                return
            }
            WgcCartType.BOUTIQUE -> {
                WgcLazaCartTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onCheckoutClick = onCheckoutClick
                )
                return
            }
            WgcCartType.FRESH_GROCERY -> {
                WgcFreshGroceryCartTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onCheckoutClick = onCheckoutClick
                )
                return
            }
            WgcCartType.CURATED_MARKET -> {
                WgcTasselCartTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onCheckoutClick = onCheckoutClick
                )
                return
            }
            WgcCartType.APPAREL -> {
                WgcClotheeCartTemplate(
                    modifier = modifier,
                    onBackClick = onBackClick,
                    onCheckoutClick = onCheckoutClick
                )
                return
            }
            WgcCartType.HYPERMARKET -> {
                WgcExtraCartTemplate(
                    modifier = modifier,
                    cartItems = HypermarketMockData.mockProducts.take(DEFAULT_HYPERMARKET_ITEMS_COUNT).map { ExtraCartItem(it, 1) },
                    onCheckoutClick = onCheckoutClick
                )
                return
            }
            WgcCartType.PREMIUM_GROCERY -> {
                WgcPdaGourmetCartTemplate(
                    modifier = modifier,
                    onCheckoutClick = onCheckoutClick
                )
                return
            }
            WgcCartType.GROCERY -> {
                WgcSupermercadoCartTemplate(
                    modifier = modifier,
                    onCheckout = onCheckoutClick
                )
                return
            }
            WgcCartType.PHARMACY_CHAIN -> {
                WgcDrogaRaiaCartTemplate(
                    modifier = modifier,
                    onCheckout = onCheckoutClick
                )
                return
            }
            WgcCartType.CARE_PHARMACY -> {
                WgcDrogasilCartTemplate(
                    modifier = modifier,
                    onCheckout = onCheckoutClick
                )
                return
            }
            WgcCartType.POPULAR_PHARMACY -> {
                WgcPagueMenosCartTemplate(
                    modifier = modifier,
                    onCheckout = onCheckoutClick
                )
                return
            }
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            topBarSlot?.invoke() ?: TopAppBar(
                title = {
                    Text(
                        text = "Meu Carrinho",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        },
        bottomBar = {
            checkoutButtonSlot?.invoke() ?: Surface(
                tonalElevation = WgcCoreDsElevation.level2.dp,
                shadowElevation = WgcCoreDsElevation.level2.dp,
                color = MaterialTheme.colorScheme.surface
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp)
                ) {
                    WgcClassicButton(
                        textButton = "Avançar para Checkout",
                        onClick = onCheckoutClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

            // 1. Itens do Carrinho
            cartItemsSlot?.invoke() ?: Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Item do Carrinho Exemplo",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Quantidade: 1 • R$ 89,90",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            // 2. Cupom de Desconto
            voucherSlot?.invoke()

            // 3. Resumo Financeiro
            summarySlot?.invoke() ?: Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Text(
                        text = "Subtotal: R$ 89,90",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Frete: Grátis",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    HorizontalDivider(modifier = Modifier.padding(vertical = WgcCoreDsSpacing.xxs4.dp))
                    Text(
                        text = "Total: R$ 89,90",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

private const val DEFAULT_HYPERMARKET_ITEMS_COUNT = 3

@WgcDevicePreviews
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun WgcCartFactoryPreview() {
    MaterialTheme {
        WgcCartFactory(type = WgcCartType.STANDARD)
    }
}
