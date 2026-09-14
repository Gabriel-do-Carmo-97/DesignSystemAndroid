package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.chip.WgcChip
import br.com.wgc.design_system.components.ifood.WgcIFoodRestaurantCard

/**
 * Variantes de cards suportadas pela WgcCardFactory.
 */
enum class WgcCardType {
    ProductDetail,
    RestaurantCard,
    StatusCard,
    EcommerceProduct,
    DealOfTheDay,
    Address,
    PaymentMethod,
    ShoppeProduct,
    ShoppeOrderStatus,
    ShoppeVoucher,
    ShoppeFlashSale,
    KutukuProduct,
    KutukuCategory,
    KutukuCartItem,
    ClotheeProduct,
    ClotheeCategory,
    ClotheeCartItem,
    TasselCollection,
    TasselProduct,
    TasselOrderTracker,
    ShopperProduct,
    ShopperPromoBanner,
    NexkartProduct,
    NexkartTopProduct,
    NexkartCartItem,
    ShopEaseProduct,
    ShopEaseOfferBanner
}

/**
 * Fábrica Universal de Cards do Design System (WgcCardFactory).
 * Provê alternância imediata entre [WgcCardType] com defaults prontos para produção,
 * slot de ação granular ([actionSlot]) e substituição total via [customCardSlot].
 */
@Composable
fun WgcCardFactory(
    modifier: Modifier = Modifier,
    type: WgcCardType = WgcCardType.ProductDetail,
    title: String = "Item em Destaque",
    subtitle: String = "Descrição do item selecionado",
    price: String = "R$ 29,90",
    imageUrl: String? = null,
    badgeText: String? = null,
    onClick: () -> Unit = {},
    actionSlot: (@Composable () -> Unit)? = null,
    customCardSlot: (@Composable () -> Unit)? = null
) {
    if (customCardSlot != null) {
        customCardSlot()
        return
    }

    when (type) {
        WgcCardType.ProductDetail -> {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable(onClick = onClick),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    if (badgeText != null) {
                        WgcChip(label = badgeText, selected = true, onClick = {})
                    }
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = price,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        actionSlot?.invoke()
                    }
                }
            }
        }
        WgcCardType.RestaurantCard -> {
            WgcIFoodRestaurantCard(
                modifier = modifier,
                name = title,
                rating = badgeText ?: "4.8",
                category = subtitle,
                onClick = onClick
            )
        }
        WgcCardType.StatusCard -> {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable(onClick = onClick),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Status",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                        )
                        if (badgeText != null) {
                            Text(
                                text = badgeText,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    actionSlot?.invoke()
                }
            }
        }
        WgcCardType.EcommerceProduct -> {
            WgcEcommerceProductCard(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                price = price,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.DealOfTheDay -> {
            WgcDealOfTheDayCard(
                modifier = modifier,
                title = title,
                remainingTime = subtitle,
                onViewAllClick = onClick
            )
        }
        WgcCardType.Address -> {
            WgcAddressCard(
                modifier = modifier,
                title = title,
                address = subtitle,
                onChangeClick = onClick
            )
        }
        WgcCardType.PaymentMethod -> {
            WgcPaymentMethodRadioCard(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                isSelected = true,
                onSelect = onClick
            )
        }
        WgcCardType.KutukuProduct -> {
            WgcKutukuProductCard(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                price = price,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.KutukuCategory -> {
            WgcKutukuCategoryCard(
                modifier = modifier,
                title = title,
                productCountText = subtitle,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.KutukuCartItem -> {
            WgcKutukuCartItemRow(
                modifier = modifier,
                title = title,
                colorVariant = subtitle,
                price = price,
                quantity = 1,
                imageUrl = imageUrl
            )
        }
        WgcCardType.ShoppeProduct -> {
            WgcShoppeProductCard(
                modifier = modifier,
                title = title,
                category = subtitle,
                price = price,
                imageUrl = imageUrl ?: "https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?w=600",
                onClick = onClick
            )
        }
        WgcCardType.ShoppeOrderStatus -> {
            WgcShoppeOrderStatusRow(
                modifier = modifier
            )
        }
        WgcCardType.ShoppeVoucher -> {
            WgcShoppeVoucherCard(
                modifier = modifier,
                discountTitle = title,
                minSpend = subtitle,
                onCollectClick = onClick
            )
        }
        WgcCardType.ShoppeFlashSale -> {
            WgcShoppeFlashSaleBanner(
                modifier = modifier,
                title = title,
                discountTag = subtitle
            )
        }
        WgcCardType.ClotheeProduct -> {
            WgcClotheeProductCard(
                modifier = modifier,
                title = title,
                price = price,
                originalPrice = subtitle.takeIf { it.isNotBlank() },
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.ClotheeCategory -> {
            WgcClotheeCategoryAvatar(
                modifier = modifier,
                name = title,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.ClotheeCartItem -> {
            WgcClotheeCartItemCard(
                modifier = modifier,
                title = title,
                price = price,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.TasselCollection -> {
            WgcTasselCollectionCard(
                modifier = modifier,
                title = title,
                onClick = onClick
            )
        }
        WgcCardType.TasselProduct -> {
            WgcTasselProductCard(
                modifier = modifier,
                title = title,
                price = price,
                brand = subtitle,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.TasselOrderTracker -> {
            WgcTasselOrderTrackerCard(
                modifier = modifier,
                productTitle = title,
                productDetails = subtitle,
                productImageUrl = imageUrl,
                onMoreInfoClick = onClick
            )
        }
        WgcCardType.ShopperProduct -> {
            WgcShopperProductCard(
                modifier = modifier,
                title = title,
                price = price,
                originalPrice = subtitle.takeIf { it.isNotBlank() },
                discountBadge = badgeText?.takeIf { it.isNotBlank() },
                onClick = onClick
            )
        }
        WgcCardType.ShopperPromoBanner -> {
            WgcShopperPromoBanner(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                onButtonClick = onClick
            )
        }
        WgcCardType.NexkartProduct -> {
            WgcNexkartProductCard(
                modifier = modifier,
                title = title,
                price = price,
                originalPrice = subtitle.takeIf { it.isNotBlank() },
                tag = badgeText,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.NexkartTopProduct -> {
            WgcNexkartTopProductRow(
                modifier = modifier,
                rank = 1,
                title = title,
                description = subtitle,
                price = price,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.NexkartCartItem -> {
            WgcNexkartCartItemRow(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                price = price,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.ShopEaseProduct -> {
            WgcShopEaseProductCard(
                modifier = modifier,
                title = title,
                price = price,
                originalPrice = subtitle.takeIf { it.isNotBlank() },
                discountBadge = badgeText?.takeIf { it.isNotBlank() },
                onClick = onClick
            )
        }
        WgcCardType.ShopEaseOfferBanner -> {
            WgcShopEaseOfferBanner(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                badgeText = badgeText ?: "FREE",
                onApplyClick = onClick
            )
        }
    }
}

@Preview(name = "WgcCardFactory - All Variants", showBackground = true)
@Composable
private fun WgcCardFactoryPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcCardFactory(
                type = WgcCardType.ProductDetail,
                title = "Hambúrguer Artesanal Angus",
                subtitle = "Pão brioche, 180g de blend angus e queijo cheddar",
                price = "R$ 38,90",
                badgeText = "Mais Pedido"
            )

            WgcCardFactory(
                type = WgcCardType.RestaurantCard,
                title = "Outback Steakhouse",
                subtitle = "Steakhouse & Carnes"
            )

            WgcCardFactory(
                type = WgcCardType.StatusCard,
                title = "Pedido Confirmado",
                subtitle = "Seu pedido #8392 foi enviado para a cozinha",
                badgeText = "Previsão: 25-35 min"
            )
        }
    }
}
