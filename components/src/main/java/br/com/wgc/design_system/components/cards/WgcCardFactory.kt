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
import br.com.wgc.design_system.components.buttons.WgcBrandPill
import br.com.wgc.design_system.components.chip.WgcChip

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
    LazaProduct,
    LazaBrand,
    LazaCartItem,
    TasselCollection,
    TasselProduct,
    TasselOrderTracker,
    ShopperProduct,
    ShopperPromoBanner,
    NexkartProduct,
    NexkartTopProduct,
    NexkartCartItem,
    ShopEaseProduct,
    ShopEaseOfferBanner,
    OrganizzeBalance,
    OrganizzeCreditCard,
    OrganizzeTransaction,
    PropertyRentalProperty,
    PropertyListingProperty,
    ZapProperty,
    GymFitnessWorkout,
    GymFitnessCrowd,
    CorporateWellnessGym,
    CorporateWellnessCheckIn,
    NtcWorkout,
    NtcProgram,
    ExtraProduct,
    ExtraCoupon,
    PdaProduct,
    PdaWine,
    PdaLoyalty,
    SupermercadoProduct,
    SupermercadoNutriScore,
    SupermercadoMeuCard,
    DrogaRaiaProduct,
    DrogaRaiaPrescription,
    DrogaRaiaSubscription,
    DrogasilVaccine,
    DrogasilLoyalty,
    PagueMenosClinic,
    PagueMenosConvenio,
    NeobankAccount,
    InterSuperApp,
    C6Carbon,
    MobilityRide,
    TravelStay,
    StreamingMedia,
    EducationCourse,
    MessagingConversation,
    GameStore,
    ProductivityTask,
    FastFoodMeal,
    LogisticsPackage,
    FashionItem,
    BeautyCosmetic,
    PetCare,
    HomeImprovement,
    NewsHeadline,
    GovDigitalDocument
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
            WgcMerchantListingCard(
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
            WgcRetailProductCard(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                price = price,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.KutukuCategory -> {
            WgcRetailCategoryCard(
                modifier = modifier,
                title = title,
                productCountText = subtitle,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.KutukuCartItem -> {
            WgcRetailCartItemRow(
                modifier = modifier,
                title = title,
                colorVariant = subtitle,
                price = price,
                quantity = 1,
                imageUrl = imageUrl
            )
        }
        WgcCardType.ShoppeProduct -> {
            WgcMegaStoreProductCard(
                modifier = modifier,
                title = title,
                category = subtitle,
                price = price,
                imageUrl = imageUrl ?: "https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?w=600",
                onClick = onClick
            )
        }
        WgcCardType.ShoppeOrderStatus -> {
            WgcMegaStoreOrderStatusRow(
                modifier = modifier
            )
        }
        WgcCardType.ShoppeVoucher -> {
            WgcMegaStoreVoucherCard(
                modifier = modifier,
                discountTitle = title,
                minSpend = subtitle,
                onCollectClick = onClick
            )
        }
        WgcCardType.ShoppeFlashSale -> {
            WgcMegaStoreFlashSaleBanner(
                modifier = modifier,
                title = title,
                discountTag = subtitle
            )
        }
        WgcCardType.ClotheeProduct -> {
            WgcApparelProductCard(
                modifier = modifier,
                title = title,
                price = price,
                originalPrice = subtitle.takeIf { it.isNotBlank() },
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.ClotheeCategory -> {
            WgcApparelCategoryAvatar(
                modifier = modifier,
                name = title,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.ClotheeCartItem -> {
            WgcApparelCartItemCard(
                modifier = modifier,
                title = title,
                price = price,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.LazaProduct -> {
            WgcBoutiqueProductCard(
                modifier = modifier,
                title = title,
                price = price,
                subtitle = subtitle,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.LazaBrand -> {
            WgcBrandPill(
                modifier = modifier,
                brandName = title,
                logoUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.LazaCartItem -> {
            WgcBoutiqueCartItemRow(
                modifier = modifier,
                title = title,
                price = price,
                taxInfo = subtitle,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.TasselCollection -> {
            WgcCuratedCollectionCard(
                modifier = modifier,
                title = title,
                onClick = onClick
            )
        }
        WgcCardType.TasselProduct -> {
            WgcCuratedProductCard(
                modifier = modifier,
                title = title,
                price = price,
                brand = subtitle,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.TasselOrderTracker -> {
            WgcCuratedOrderTrackerCard(
                modifier = modifier,
                productTitle = title,
                productDetails = subtitle,
                productImageUrl = imageUrl,
                onMoreInfoClick = onClick
            )
        }
        WgcCardType.ShopperProduct -> {
            WgcFreshGroceryProductCard(
                modifier = modifier,
                title = title,
                price = price,
                originalPrice = subtitle.takeIf { it.isNotBlank() },
                discountBadge = badgeText?.takeIf { it.isNotBlank() },
                onClick = onClick
            )
        }
        WgcCardType.ShopperPromoBanner -> {
            WgcFreshGroceryPromoBanner(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                onButtonClick = onClick
            )
        }
        WgcCardType.NexkartProduct -> {
            WgcGadgetShopProductCard(
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
            WgcGadgetShopTopProductRow(
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
            WgcGadgetShopCartItemRow(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                price = price,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
        WgcCardType.ShopEaseProduct -> {
            WgcQuickShopProductCard(
                modifier = modifier,
                title = title,
                price = price,
                originalPrice = subtitle.takeIf { it.isNotBlank() },
                discountBadge = badgeText?.takeIf { it.isNotBlank() },
                onClick = onClick
            )
        }
        WgcCardType.ShopEaseOfferBanner -> {
            WgcQuickShopOfferBanner(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                badgeText = badgeText ?: "FREE",
                onApplyClick = onClick
            )
        }
        WgcCardType.OrganizzeBalance -> {
            WgcPersonalFinanceBalanceCard(
                modifier = modifier,
                monthLabel = title.ifBlank { "Maio 2026" },
                balance = price.ifBlank { "R$ 14.850,00" },
                income = subtitle.ifBlank { "R$ 8.200,00" },
                expense = badgeText ?: "R$ 3.450,00"
            )
        }
        WgcCardType.OrganizzeCreditCard -> {
            WgcPersonalFinanceCreditCardRow(
                modifier = modifier,
                bankName = title.ifBlank { "Neobank Mastercard" },
                lastDigits = subtitle.ifBlank { "•••• 8421" },
                currentInvoice = price.ifBlank { "R$ 1.840,50" },
                onClick = onClick
            )
        }
        WgcCardType.OrganizzeTransaction -> {
            WgcPersonalFinanceTransactionItem(
                modifier = modifier,
                title = title.ifBlank { "Lançamento" },
                category = subtitle.ifBlank { "Geral" },
                amount = price.ifBlank { "R$ 0,00" },
                onClick = onClick
            )
        }
        WgcCardType.PropertyRentalProperty -> {
            WgcPropertyRentalCard(
                modifier = modifier,
                title = title.ifBlank { "Apartamento para alugar" },
                neighborhood = subtitle.ifBlank { "Pinheiros" },
                address = "Rua Mourato Coelho, 700",
                price = price.ifBlank { "R$ 3.200 /mês" },
                totalPrice = "Total R$ 4.050 /mês",
                badgeText = badgeText ?: "Sem Fiador",
                onClick = onClick
            )
        }
        WgcCardType.PropertyListingProperty -> {
            WgcPropertyListingCard(
                modifier = modifier,
                title = title.ifBlank { "Apartamento à venda" },
                neighborhood = subtitle.ifBlank { "Moema" },
                address = "Alameda dos Maracatins, 450",
                price = price.ifBlank { "R$ 890.000" },
                condoAndIptu = "Condomínio R$ 780 • IPTU R$ 220",
                agencyName = "Lopes Prime",
                badgeText = badgeText ?: "Super Destaque",
                onClick = onClick
            )
        }
        WgcCardType.ZapProperty -> {
            WgcPropertyClassifiedsCard(
                modifier = modifier,
                title = title.ifBlank { "Apartamento Alto Padrão com Varanda Gourmet" },
                neighborhood = subtitle.ifBlank { "Itaim Bibi" },
                address = "Rua Joaquim Floriano, 900",
                price = price.ifBlank { "R$ 1.850.000" },
                pricePerSquareMeter = "R$ 13.703/m²",
                condoAndIptu = "Condomínio R$ 1.650 • IPTU R$ 680",
                areaM2 = 135,
                bedrooms = 3,
                suites = 2,
                bathrooms = 4,
                parkingSpaces = 2,
                fipeStatus = WgcZapFipeStatus.BELOW_AVERAGE,
                badgeText = badgeText ?: "Super Destaque",
                advertiserName = "Zap Prime Imóveis",
                hasVirtualTour = true,
                onCardClick = onClick
            )
        }
        WgcCardType.GymFitnessWorkout -> {
            WgcGymWorkoutCard(
                modifier = modifier,
                exerciseName = title.ifBlank { "Supino Reto com Barra" },
                targetMuscle = subtitle.ifBlank { "Peitoral Maior" },
                setsAndReps = "4 séries × 10 reps",
                weightKg = price.ifBlank { "32 kg" },
                isCompleted = false,
                onClick = onClick
            )
        }
        WgcCardType.GymFitnessCrowd -> {
            WgcGymCrowdCard(
                modifier = modifier,
                unitName = title.ifBlank { "Gym & Fitness - Paulista" },
                address = subtitle.ifBlank { "Av. Paulista, 2064 • 350m" },
                operatingHours = "06:00 às 23:00",
                crowdLevel = WgcGymFitnessCrowdLevel.LOW,
                crowdPercentage = 30,
                onClick = onClick
            )
        }
        WgcCardType.CorporateWellnessGym -> {
            WgcWellnessGymCard(
                modifier = modifier,
                name = title.ifBlank { "Gym & Fitness - Paulista" },
                category = subtitle.ifBlank { "Musculação • Aeróbico" },
                address = "Av. Paulista, 2064",
                distance = "350 m",
                rating = 4.8,
                reviewsCount = "1.4k",
                requiredTier = WgcCorporateWellnessPlanTier.BASIC,
                onClick = onClick
            )
        }
        WgcCardType.CorporateWellnessCheckIn -> {
            WgcWellnessCheckInCard(
                modifier = modifier,
                gymName = title.ifBlank { "Bio Ritmo - Jardins" },
                userName = subtitle.ifBlank { "Gabriel do Carmo" },
                planTitle = badgeText ?: "Plano Gold",
                tokenCode = price.ifBlank { "WH-94821" },
                validUntil = "23:59 de hoje",
                onCopyToken = onClick
            )
        }
        WgcCardType.NtcWorkout -> {
            WgcNtcWorkoutCard(
                modifier = modifier,
                title = title.ifBlank { "Queima Metabólica Rápida" },
                trainerName = subtitle.ifBlank { "Kirsty Godso" },
                category = WgcNtcWorkoutCategory.HIIT,
                durationMinutes = 20,
                intensity = WgcNtcWorkoutIntensity.HIGH,
                equipment = badgeText ?: "Sem equipamentos",
                onClick = onClick
            )
        }
        WgcCardType.NtcProgram -> {
            WgcNtcProgramCard(
                modifier = modifier,
                title = title.ifBlank { "4 Semanas para Força Funcional" },
                goal = subtitle.ifBlank { "Resistência muscular e queima calórica" },
                trainerName = "Betina Gozo",
                totalWeeks = 4,
                currentWeek = 2,
                completedWorkouts = 6,
                totalWorkouts = 16,
                isEnrolled = true,
                onClick = onClick,
                onActionClick = onClick
            )
        }
        WgcCardType.ExtraProduct -> {
            WgcExtraProductCard(
                modifier = modifier,
                name = title.ifBlank { "Azeite de Oliva Extra Virgem Borges" },
                unitDescription = subtitle.ifBlank { "Vidro 500ml" },
                regularPrice = "R$ 42,90",
                clubPrice = price.ifBlank { "R$ 31,90" },
                discountPercentage = badgeText ?: "25%",
                isDiscountActivated = true,
                quantityInCart = 1,
                onClick = onClick
            )
        }
        WgcCardType.ExtraCoupon -> {
            WgcExtraDiscountCouponCard(
                modifier = modifier,
                title = title.ifBlank { "30% de desconto em Sabão Líquido Ariel" },
                category = subtitle.ifBlank { "Higiene & Limpeza" },
                discountBadge = badgeText ?: "30% OFF",
                limitCondition = "Limite de 4 unidades por CPF",
                validUntil = "Válido até domingo, 21/09",
                isActivated = true,
                onClick = onClick
            )
        }
        WgcCardType.PdaProduct -> {
            WgcPdaProductCard(
                modifier = modifier,
                title = title.ifBlank { "Azeite Taeq Orgânico Extra Virgem" },
                brandOrOrigin = subtitle.ifBlank { "Taeq Orgânico" },
                unit = "500ml",
                originalPrice = 49.90,
                clienteMaisPrice = 39.90,
                badgeText = badgeText ?: "100% Orgânico",
                isOrganic = true,
                quantity = 1,
                onClick = onClick
            )
        }
        WgcCardType.PdaWine -> {
            WgcPdaSommelierWineCard(
                modifier = modifier,
                wineName = title.ifBlank { "Marqués de Riscal Gran Reserva Rioja" },
                countryOrigin = subtitle.ifBlank { "Espanha • D.O.Ca Rioja" },
                grape = "Tempranillo, Graciano",
                vintage = "Safra 2018",
                rating = 4.4,
                sommelierPoints = 94,
                pairingTip = "Carnes nobres grelhadas e queijos curados.",
                servingTemp = "16°C a 18°C",
                price = 289.90,
                clienteMaisPrice = 229.90,
                quantity = 0,
                onClick = onClick
            )
        }
        WgcCardType.PdaLoyalty -> {
            WgcPdaClienteMaisLoyaltyCard(
                modifier = modifier,
                clientName = title.ifBlank { "Gabriel do Carmo" },
                cpfMasked = subtitle.ifBlank { "***.458.918-**" },
                tier = badgeText ?: "Cliente Mais Black",
                stilloCoins = 2840,
                monthlySavings = 428.50,
                onClick = onClick
            )
        }
        WgcCardType.SupermercadoProduct -> {
            WgcGroceryProductCard(
                modifier = modifier,
                title = title.ifBlank { "Arroz Tipo 1 Supermercado Classic 5kg" },
                brandLine = subtitle.ifBlank { "Supermercado Classic" },
                unit = "5kg",
                regularPrice = 32.90,
                cardSupermercadoPrice = 28.90,
                nutriScore = badgeText ?: "A",
                quantity = 1,
                onClick = onClick
            )
        }
        WgcCardType.SupermercadoNutriScore -> {
            WgcGroceryNutriScoreCard(
                modifier = modifier,
                currentScore = badgeText ?: "A",
                onClick = onClick
            )
        }
        WgcCardType.SupermercadoMeuCard -> {
            WgcGroceryLoyaltyCard(
                modifier = modifier,
                holderName = title.ifBlank { "Gabriel do Carmo" },
                cardLastDigits = subtitle.ifBlank { "8412" },
                availableLimit = 4250.00,
                coinsBalance = 380,
                bestPurchaseDay = 15,
                onClick = onClick
            )
        }
        WgcCardType.DrogaRaiaProduct -> {
            WgcDrogaRaiaProductCard(
                modifier = modifier,
                title = title.ifBlank { "Dipirona Monoidratada 500mg/mL" },
                laboratory = subtitle.ifBlank { "EMS Genéricos" },
                presentation = "Frasco Gotas 20mL",
                price = 14.50,
                onCardClick = onClick
            )
        }
        WgcCardType.DrogaRaiaPrescription -> {
            WgcDrogaRaiaPrescriptionCard(
                modifier = modifier,
                onUploadPrescription = onClick
            )
        }
        WgcCardType.DrogaRaiaSubscription -> {
            WgcDrogaRaiaSubscriptionCard(
                modifier = modifier,
                medicineName = title.ifBlank { "Losartana Potássica 50mg" },
                dosageFrequency = subtitle.ifBlank { "1 comprimido ao dia" },
                nextDeliveryDate = "05/10/2026",
                monthlyPrice = 18.90,
                onManageClick = onClick
            )
        }
        WgcCardType.DrogasilVaccine -> {
            WgcDrogasilVaccineCard(
                modifier = modifier,
                vaccineName = title.ifBlank { "Vacina Gripe Tetravalente" },
                targetAudience = subtitle.ifBlank { "Adultos e Crianças" },
                price = 79.90,
                onScheduleClick = onClick
            )
        }
        WgcCardType.DrogasilLoyalty -> {
            WgcDrogasilLoyaltyCard(
                modifier = modifier,
                userName = title.ifBlank { "Mariana Alves" },
                cpfMasked = subtitle.ifBlank { "123.***.***-00" },
                pointsBalance = 420,
                onShowBarcodeClick = onClick
            )
        }
        WgcCardType.PagueMenosClinic -> {
            WgcPagueMenosClinicCard(
                modifier = modifier,
                serviceTitle = title.ifBlank { "Aferição de Pressão + Bioimpedância" },
                description = subtitle.ifBlank { "Sala exclusiva climatizada" },
                price = 0.0,
                estimatedDuration = "15 min",
                onBookClick = onClick
            )
        }
        WgcCardType.PagueMenosConvenio -> {
            WgcPagueMenosConvenioCard(
                modifier = modifier,
                convenioName = title.ifBlank { "Bradesco Saúde / Orizon" },
                cardNumberMasked = subtitle.ifBlank { "9874 **** **** 1029" },
                discountPercentage = 45,
                onManageConvenio = onClick
            )
        }
        WgcCardType.NeobankAccount -> {
            WgcFinancialBalanceCard(
                modifier = modifier,
                balance = 3450.75,
                onClick = onClick
            )
        }
        WgcCardType.InterSuperApp -> {
            WgcFintechSuperAppCard(
                modifier = modifier,
                partnerStore = title.ifBlank { "Marketplace" },
                offerTitle = subtitle.ifBlank { "Smartphones e Informática" },
                cashbackPercentage = 8,
                onShopClick = onClick
            )
        }
        WgcCardType.C6Carbon -> {
            WgcPlasticCreditCard(
                modifier = modifier,
                holderName = title.ifBlank { "Lucas Ferreira" },
                cardLastDigits = subtitle.ifBlank { "8832" },
                rewardPoints = 14250
            )
        }
        WgcCardType.MobilityRide -> {
            WgcMobilityRideCard(
                modifier = modifier,
                categoryName = title.ifBlank { "99Pop Express" },
                estimatedTime = subtitle.ifBlank { "4 min" },
                price = 19.80,
                onSelectRide = onClick
            )
        }
        WgcCardType.TravelStay -> {
            WgcTravelStayCard(
                modifier = modifier,
                title = title.ifBlank { "Flat Design em Copacabana" },
                location = subtitle.ifBlank { "Rio de Janeiro" },
                rating = 4.95,
                nightPrice = 280.0,
                onBookClick = onClick
            )
        }
        WgcCardType.StreamingMedia -> {
            WgcStreamingMediaCard(
                modifier = modifier,
                title = title.ifBlank { "Bohemian Rhapsody" },
                artistOrCreator = subtitle.ifBlank { "Queen" },
                duration = "5:55",
                onPlayClick = onClick
            )
        }
        WgcCardType.EducationCourse -> {
            WgcEducationCourseCard(
                modifier = modifier,
                courseTitle = title.ifBlank { "Android Jetpack Compose do Zero ao Avançado" },
                instructorOrTrack = subtitle.ifBlank { "Formação Mobile Master" },
                progressPercentage = 0.65f,
                onContinueClick = onClick
            )
        }
        WgcCardType.MessagingConversation -> {
            WgcMessagingConversationCard(
                modifier = modifier,
                contactName = title.ifBlank { "Gabriel do Carmo" },
                lastMessage = subtitle.ifBlank { "Componentes e templates aprovados!" },
                timestamp = "14:32",
                unreadCount = 2
            )
        }
        WgcCardType.GameStore -> {
            WgcGameStoreCard(
                modifier = modifier,
                gameTitle = title.ifBlank { "Cyberpunk 2077: Phantom Liberty" },
                genre = subtitle.ifBlank { "RPG / Ação" },
                price = 119.90,
                discountPercentage = 40,
                onBuyClick = onClick
            )
        }
        WgcCardType.ProductivityTask -> {
            WgcProductivityTaskCard(
                modifier = modifier,
                taskTitle = title.ifBlank { "Refatorar Módulo de Pagamento" },
                tag = subtitle.ifBlank { "Design System" },
                dueDate = "Amanhã"
            )
        }
        WgcCardType.FastFoodMeal -> {
            WgcFastFoodMealCard(
                modifier = modifier,
                comboName = title.ifBlank { "Big Mac Combo Clássico" },
                description = subtitle.ifBlank { "Com Batata Grande e Refrigerante Refill" },
                price = 36.90,
                onAddMeal = onClick
            )
        }
        WgcCardType.LogisticsPackage -> {
            WgcLogisticsPackageCard(
                modifier = modifier,
                trackingCode = title.ifBlank { "BR982347102SP" },
                statusText = subtitle.ifBlank { "Objeto em trânsito para entrega rápida" },
                deliveryDate = "Hoje até às 18h"
            )
        }
        WgcCardType.FashionItem -> {
            WgcFashionItemCard(
                modifier = modifier,
                brandName = title.ifBlank { "Fashion Premium" },
                itemTitle = subtitle.ifBlank { "Jaqueta Corta-Vento Street Casual" },
                price = 199.90,
                installments = "5x de R$ 39,98 sem juros",
                onBuy = onClick
            )
        }
        WgcCardType.BeautyCosmetic -> {
            WgcBeautyCosmeticCard(
                modifier = modifier,
                perfumeOrBrand = title.ifBlank { "Malbec Gold Desodorante Colônia" },
                productName = subtitle.ifBlank { "Fragrância Amadeirada Intensa" },
                volume = "100ml",
                price = 219.90,
                onAdd = onClick
            )
        }
        WgcCardType.PetCare -> {
            WgcPetCareCard(
                modifier = modifier,
                petProductTitle = title.ifBlank { "Ração Premier Formula Cães Adultos" },
                weightOrSize = subtitle.ifBlank { "15kg" },
                subscriberPrice = 249.90,
                regularPrice = 289.90,
                onSubscribeClick = onClick
            )
        }
        WgcCardType.HomeImprovement -> {
            WgcHomeImprovementCard(
                modifier = modifier,
                department = title.ifBlank { "Ferramentas Elétricas" },
                productName = subtitle.ifBlank { "Furadeira e Parafusadeira de Impacto Bivolt" },
                price = 349.90,
                onAddToCart = onClick
            )
        }
        WgcCardType.NewsHeadline -> {
            WgcNewsHeadlineCard(
                modifier = modifier,
                editoria = title.ifBlank { "Tecnologia & Inovação" },
                headline = subtitle.ifBlank { "Novo Design System Android atinge 100% de conformidade com tokens e zero valores mágicos" },
                publishedTime = "Há 5 minutos"
            )
        }
        WgcCardType.GovDigitalDocument -> {
            WgcGovDigitalDocumentCard(
                modifier = modifier,
                documentTitle = title.ifBlank { "Carteira Nacional de Habilitação (CNH-e)" },
                citizenName = subtitle.ifBlank { "Gabriel do Carmo" },
                documentNumberMasked = "058.***.***-91",
                securityLevel = "Nível Ouro"
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
