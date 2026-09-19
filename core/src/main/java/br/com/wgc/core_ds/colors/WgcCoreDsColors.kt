package br.com.wgc.core_ds.colors

/**
 * Coleção consolidada de todas as cores do Design System WGC.
 * Este objeto serve como ponto de entrada unificado para compatibilidade com código existente.
 * Nota de migração: Use os objetos específicos por categoria:
 * - {@link WgcCoreDsColorsPrimitive} para cores primitivas
 * - {@link WgcCoreDsColorsSemantic} para cores semânticas
 * - {@link br.com.wgc.core_ds.colors.brands.WgcBrandFoodDelivery} para cores de marcas
 * - {@link br.com.wgc.core_ds.colors.brands.WgcBrandMarketplace} para cores de marketplace
 * - {@link br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce} para cores de e-commerce
 * - {@link br.com.wgc.core_ds.colors.brands.WgcBrandFashion} para cores de fashion
 * - {@link br.com.wgc.core_ds.colors.brands.WgcBrandTechnology} para cores de tecnologia
 * - {@link br.com.wgc.core_ds.colors.brands.WgcBrandFinance} para cores de finanças
 * - {@link br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate} para cores de imobiliária
 * - {@link br.com.wgc.core_ds.colors.brands.WgcBrandFitness} para cores de fitness
 * - {@link br.com.wgc.core_ds.colors.brands.WgcBrandGrocery} para cores de supermercado
 */
@Deprecated("Use os objetos específicos por categoria")
object WgcCoreDsColors {
    // Import from primitive colors
    val red500 = WgcCoreDsColorsPrimitive.red500
    val red700 = WgcCoreDsColorsPrimitive.red700
    val blue500 = WgcCoreDsColorsPrimitive.blue500
    val orange500 = WgcCoreDsColorsPrimitive.orange500
    val grey50 = WgcCoreDsColorsPrimitive.grey50
    val grey100 = WgcCoreDsColorsPrimitive.grey100
    val grey900 = WgcCoreDsColorsPrimitive.grey900
    val white = WgcCoreDsColorsPrimitive.white
    val black = WgcCoreDsColorsPrimitive.black
    val transparent = WgcCoreDsColorsPrimitive.transparent

    // Import from semantic colors
    val primary = WgcCoreDsColorsSemantic.primary
    val secondary = WgcCoreDsColorsSemantic.secondary
    val background = WgcCoreDsColorsSemantic.background
    val error = WgcCoreDsColorsSemantic.error
    val success = WgcCoreDsColorsSemantic.success
    val warning = WgcCoreDsColorsSemantic.warning
    val textPrimary = WgcCoreDsColorsSemantic.textPrimary
    val textSecondary = WgcCoreDsColorsSemantic.textSecondary

    // Import from brand colors
    val foodDeliveryRed = br.com.wgc.core_ds.colors.brands.WgcBrandFoodDelivery.foodDeliveryRed
    val foodDeliveryRedDark = br.com.wgc.core_ds.colors.brands.WgcBrandFoodDelivery.foodDeliveryRedDark
    val foodDeliveryGreen = br.com.wgc.core_ds.colors.brands.WgcBrandFoodDelivery.foodDeliveryGreen
    val foodDeliveryBgGray = br.com.wgc.core_ds.colors.brands.WgcBrandFoodDelivery.foodDeliveryBgGray
    val foodDeliveryDarkBlue = br.com.wgc.core_ds.colors.brands.WgcBrandFoodDelivery.foodDeliveryDarkBlue
    val foodDeliveryLightBlue = br.com.wgc.core_ds.colors.brands.WgcBrandFoodDelivery.foodDeliveryLightBlue

    val marketplaceYellow = br.com.wgc.core_ds.colors.brands.WgcBrandMarketplace.marketplaceYellow
    val marketplaceBlue = br.com.wgc.core_ds.colors.brands.WgcBrandMarketplace.marketplaceBlue
    val marketplaceGreen = br.com.wgc.core_ds.colors.brands.WgcBrandMarketplace.marketplaceGreen
    val marketplaceBgGray = br.com.wgc.core_ds.colors.brands.WgcBrandMarketplace.marketplaceBgGray

    val dealMarketplaceOrange = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.dealMarketplaceOrange
    val rideHailingBlack = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.rideHailingBlack
    val globalMarketplaceRed = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.globalMarketplaceRed
    val globalMarketplaceOrange = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.globalMarketplaceOrange
    val trendFashionPink = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.trendFashionPink
    val trendFashionBlue = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.trendFashionBlue
    val trendFashionDark = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.trendFashionDark
    val trendFashionGold = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.trendFashionGold
    val trendFashionLightGray = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.trendFashionLightGray
    val trendFashionBorderGray = br.com.wgc.core_ds.colors.brands.WgcBrandEcommerce.trendFashionBorderGray

    val megaStorePrimary = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.megaStorePrimary
    val megaStorePrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.megaStorePrimaryLight
    val megaStoreDark = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.megaStoreDark
    val megaStoreSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.megaStoreSecondaryText
    val megaStoreBackground = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.megaStoreBackground
    val megaStoreGold = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.megaStoreGold
    val megaStoreBorder = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.megaStoreBorder
    val megaStoreAlertRed = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.megaStoreAlertRed

    val retailPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailPrimary
    val retailPrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailPrimaryLight
    val retailSecondary = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailSecondary
    val retailDark = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailDark
    val retailSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailSecondaryText
    val retailBackground = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailBackground
    val retailSurface = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailSurface
    val retailBorder = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailBorder
    val retailGold = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailGold
    val retailAlertRed = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.retailAlertRed

    val apparelPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelPrimary
    val apparelPrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelPrimaryLight
    val apparelDark = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelDark
    val apparelSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelSecondaryText
    val apparelBackground = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelBackground
    val apparelSurface = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelSurface
    val apparelDarkBackground = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelDarkBackground
    val apparelDarkSurface = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelDarkSurface
    val apparelBorder = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelBorder
    val apparelAlertRed = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelAlertRed
    val apparelSuccessGreen = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.apparelSuccessGreen

    val boutiquePrimary = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiquePrimary
    val boutiquePrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiquePrimaryLight
    val boutiqueDark = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueDark
    val boutiqueSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueSecondaryText
    val boutiqueBackground = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueBackground
    val boutiqueSurface = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueSurface
    val boutiqueDarkBackground = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueDarkBackground
    val boutiqueDarkSurface = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueDarkSurface
    val boutiqueBorder = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueBorder
    val boutiqueAlertRed = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueAlertRed
    val boutiqueSuccessGreen = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueSuccessGreen
    val boutiqueGold = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueGold
    val boutiqueFacebook = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueFacebook
    val boutiqueTwitter = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueTwitter
    val boutiqueGoogle = br.com.wgc.core_ds.colors.brands.WgcBrandFashion.boutiqueGoogle

    val curatedMarketPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketPrimary
    val curatedMarketPrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketPrimaryLight
    val curatedMarketDark = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketDark
    val curatedMarketSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketSecondaryText
    val curatedMarketBackground = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketBackground
    val curatedMarketSurface = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketSurface
    val curatedMarketDarkBackground = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketDarkBackground
    val curatedMarketDarkSurface = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketDarkSurface
    val curatedMarketBorder = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketBorder
    val curatedMarketSalePink = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketSalePink
    val curatedMarketSalePinkText = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketSalePinkText
    val curatedMarketNewInPurple = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketNewInPurple
    val curatedMarketNewInPurpleText = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketNewInPurpleText
    val curatedMarketSuccessGreen = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketSuccessGreen
    val curatedMarketAlertRed = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketAlertRed
    val curatedMarketGold = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketGold
    val curatedMarketDenimBlue = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.curatedMarketDenimBlue

    val megaStorerPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerPrimary
    val megaStorerPrimaryDark = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerPrimaryDark
    val megaStorerPrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerPrimaryLight
    val megaStorerSecondary = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerSecondary
    val megaStorerAccent = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerAccent
    val megaStorerDark = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerDark
    val megaStorerSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerSecondaryText
    val megaStorerBackground = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerBackground
    val megaStorerSurface = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerSurface
    val megaStorerDarkBackground = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerDarkBackground
    val megaStorerDarkSurface = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerDarkSurface
    val megaStorerBorder = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerBorder
    val megaStorerSaleOrange = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerSaleOrange
    val megaStorerSaleOrangeText = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerSaleOrangeText
    val megaStorerSuccessGreen = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerSuccessGreen
    val megaStorerGold = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.megaStorerGold

    val gadgetShopPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopPrimary
    val gadgetShopPrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopPrimaryLight
    val gadgetShopPrimaryDark = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopPrimaryDark
    val gadgetShopAccentPink = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopAccentPink
    val gadgetShopDark = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopDark
    val gadgetShopSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopSecondaryText
    val gadgetShopBackground = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopBackground
    val gadgetShopSurface = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopSurface
    val gadgetShopDarkBackground = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopDarkBackground
    val gadgetShopDarkSurface = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopDarkSurface
    val gadgetShopBorder = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopBorder
    val gadgetShopCatBeauty = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopCatBeauty
    val gadgetShopCatGadgets = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopCatGadgets
    val gadgetShopCatGames = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopCatGames
    val gadgetShopCatCine = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopCatCine
    val gadgetShopCatFashion = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopCatFashion
    val gadgetShopGold = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopGold
    val gadgetShopSuccessGreen = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopSuccessGreen
    val gadgetShopAlertRed = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.gadgetShopAlertRed

    val quickShopPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopPrimary
    val quickShopPrimaryDark = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopPrimaryDark
    val quickShopPrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopPrimaryLight
    val quickShopSecondary = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopSecondary
    val quickShopPeachBg = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopPeachBg
    val quickShopDark = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopDark
    val quickShopSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopSecondaryText
    val quickShopBackground = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopBackground
    val quickShopSurface = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopSurface
    val quickShopBorder = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopBorder
    val quickShopSuccessGreen = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopSuccessGreen
    val quickShopCardRed = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopCardRed
    val quickShopCardPurple = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopCardPurple
    val quickShopCardGreen = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopCardGreen
    val quickShopCardOrange = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopCardOrange
    val quickShopCardBlue = br.com.wgc.core_ds.colors.brands.WgcBrandTechnology.quickShopCardBlue

    val personalFinancePrimary = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinancePrimary
    val personalFinancePrimaryDark = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinancePrimaryDark
    val personalFinancePrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinancePrimaryLight
    val personalFinanceSecondary = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceSecondary
    val personalFinanceExpenseRed = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceExpenseRed
    val personalFinanceExpenseRedLight = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceExpenseRedLight
    val personalFinanceIncomeGreen = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceIncomeGreen
    val personalFinanceIncomeGreenLight = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceIncomeGreenLight
    val personalFinanceTransferBlue = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceTransferBlue
    val personalFinanceTransferBlueLight = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceTransferBlueLight
    val personalFinanceDark = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceDark
    val personalFinanceSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceSecondaryText
    val personalFinanceBackground = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceBackground
    val personalFinanceSurface = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceSurface
    val personalFinanceBorder = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceBorder
    val personalFinanceCardPurple = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceCardPurple
    val personalFinanceCardNavy = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceCardNavy
    val personalFinanceCardOrange = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceCardOrange
    val personalFinanceWarningYellow = br.com.wgc.core_ds.colors.brands.WgcBrandFinance.personalFinanceWarningYellow

    val propertyRentalPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalPrimary
    val propertyRentalPrimaryDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalPrimaryDark
    val propertyRentalPrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalPrimaryLight
    val propertyRentalYellow = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalYellow
    val propertyRentalYellowDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalYellowDark
    val propertyRentalYellowLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalYellowLight
    val propertyRentalCoral = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalCoral
    val propertyRentalCoralLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalCoralLight
    val propertyRentalGreen = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalGreen
    val propertyRentalGreenLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalGreenLight
    val propertyRentalDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalDark
    val propertyRentalSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalSecondaryText
    val propertyRentalBackground = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalBackground
    val propertyRentalSurface = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalSurface
    val propertyRentalBorder = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalBorder
    val propertyRentalCardPlaceholder = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyRentalCardPlaceholder

    val propertyListingPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingPrimary
    val propertyListingPrimaryDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingPrimaryDark
    val propertyListingPrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingPrimaryLight
    val propertyListingOrange = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingOrange
    val propertyListingOrangeDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingOrangeDark
    val propertyListingOrangeLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingOrangeLight
    val propertyListingWhatsApp = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingWhatsApp
    val propertyListingWhatsAppLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingWhatsAppLight
    val propertyListingSuperDestaque = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingSuperDestaque
    val propertyListingSuperDestaqueLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingSuperDestaqueLight
    val propertyListingDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingDark
    val propertyListingSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingSecondaryText
    val propertyListingBackground = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingBackground
    val propertyListingSurface = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingSurface
    val propertyListingBorder = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingBorder
    val propertyListingCardPlaceholder = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyListingCardPlaceholder

    val propertyClassifiedsPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsPrimary
    val propertyClassifiedsPrimaryDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsPrimaryDark
    val propertyClassifiedsPrimaryLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsPrimaryLight
    val propertyClassifiedsBlue = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsBlue
    val propertyClassifiedsBlueDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsBlueDark
    val propertyClassifiedsBlueLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsBlueLight
    val propertyClassifiedsOrange = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsOrange
    val propertyClassifiedsOrangeDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsOrangeDark
    val propertyClassifiedsOrangeLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsOrangeLight
    val propertyClassifiedsFipeGreen = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsFipeGreen
    val propertyClassifiedsFipeGreenLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsFipeGreenLight
    val propertyClassifiedsFipeYellow = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsFipeYellow
    val propertyClassifiedsFipeYellowLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsFipeYellowLight
    val propertyClassifiedsFipeRed = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsFipeRed
    val propertyClassifiedsFipeRedLight = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsFipeRedLight
    val propertyClassifiedsDark = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsDark
    val propertyClassifiedsSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsSecondaryText
    val propertyClassifiedsBackground = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsBackground
    val propertyClassifiedsSurface = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsSurface
    val propertyClassifiedsBorder = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsBorder
    val propertyClassifiedsCardPlaceholder = br.com.wgc.core_ds.colors.brands.WgcBrandRealEstate.propertyClassifiedsCardPlaceholder

    val gymYellow = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymYellow
    val gymYellowDark = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymYellowDark
    val gymYellowLight = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymYellowLight
    val gymBlack = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymBlack
    val gymDarkGray = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymDarkGray
    val gymMediumGray = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymMediumGray
    val gymLightGray = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymLightGray
    val gymCrowdLow = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymCrowdLow
    val gymCrowdLowLight = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymCrowdLowLight
    val gymCrowdMedium = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymCrowdMedium
    val gymCrowdMediumLight = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymCrowdMediumLight
    val gymCrowdHigh = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymCrowdHigh
    val gymCrowdHighLight = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymCrowdHighLight
    val gymTextPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymTextPrimary
    val gymTextSecondary = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymTextSecondary
    val gymTextInverse = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymTextInverse
    val gymCardPlaceholder = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymCardPlaceholder
    val gymAccentCyan = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.gymAccentCyan

    val trainingBlack = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingBlack
    val trainingDarkGray = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingDarkGray
    val trainingMediumGray = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingMediumGray
    val trainingLightGray = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingLightGray
    val trainingVolt = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingVolt
    val trainingVoltDark = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingVoltDark
    val trainingVoltGlow = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingVoltGlow
    val trainingWhite = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingWhite
    val trainingSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingSecondaryText
    val trainingOrange = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingOrange
    val trainingOrangeDark = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingOrangeDark
    val trainingOrangeLight = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingOrangeLight
    val trainingBlue = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingBlue
    val trainingBlueDark = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingBlueDark
    val trainingBlueLight = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingBlueLight
    val trainingPurple = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingPurple
    val trainingPlaceholder = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingPlaceholder
    val trainingStreakGold = br.com.wgc.core_ds.colors.brands.WgcBrandFitness.trainingStreakGold

    val hypermarketRed = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketRed
    val hypermarketRedDark = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketRedDark
    val hypermarketRedLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketRedLight
    val hypermarketBlue = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketBlue
    val hypermarketBlueDark = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketBlueDark
    val hypermarketBlueLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketBlueLight
    val hypermarketYellow = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketYellow
    val hypermarketYellowLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketYellowLight
    val hypermarketOrange = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketOrange
    val hypermarketOrangeLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketOrangeLight
    val hypermarketBackground = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketBackground
    val hypermarketSurface = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketSurface
    val hypermarketDark = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketDark
    val hypermarketSecondaryText = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketSecondaryText
    val hypermarketBorder = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketBorder
    val hypermarketPlaceholder = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketPlaceholder
    val hypermarketSuccessGreen = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketSuccessGreen
    val hypermarketSuccessGreenLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.hypermarketSuccessGreenLight

    val premiumGroceryGreen = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryGreen
    val premiumGroceryGreenDark = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryGreenDark
    val premiumGroceryGreenLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryGreenLight
    val premiumGroceryGold = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryGold
    val premiumGroceryGoldDark = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryGoldDark
    val premiumGroceryGoldLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryGoldLight
    val premiumGroceryWineRed = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryWineRed
    val premiumGroceryWineRedDark = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryWineRedDark
    val premiumGroceryWineRedLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryWineRedLight
    val premiumGroceryOrangeOrganic = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryOrangeOrganic
    val premiumGroceryOrangeOrganicLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryOrangeOrganicLight
    val premiumGroceryBackground = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryBackground
    val premiumGrocerySurface = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGrocerySurface
    val premiumGroceryTextPrimary = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryTextPrimary
    val premiumGroceryTextSecondary = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryTextSecondary
    val premiumGroceryBorder = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryBorder
    val premiumGroceryPlaceholder = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGroceryPlaceholder
    val premiumGrocerySuccessGreen = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGrocerySuccessGreen
    val premiumGrocerySuccessGreenLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.premiumGrocerySuccessGreenLight

    val groceryBlue = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.groceryBlue
    val groceryBlueDark = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.groceryBlueDark
    val groceryBlueLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.groceryBlueLight
    val groceryRed = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.groceryRed
    val groceryRedDark = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.groceryRedDark
    val groceryRedLight = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.groceryRedLight
    val groceryYellow = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.groceryYellow
    val groceryOrange = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.groceryOrange
    val groceryBackground = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.groceryBackground
    val grocerySurface = br.com.wgc.core_ds.colors.brands.WgcBrandGrocery.grocerySurface
}