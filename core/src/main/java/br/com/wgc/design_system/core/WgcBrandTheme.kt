package br.com.wgc.design_system.core

import br.com.wgc.design_system.core.colors.brands.WgcBrandEcommerce
import br.com.wgc.design_system.core.colors.brands.WgcBrandFashion
import br.com.wgc.design_system.core.colors.brands.WgcBrandFinance
import br.com.wgc.design_system.core.colors.brands.WgcBrandFoodDelivery
import br.com.wgc.design_system.core.colors.brands.WgcBrandFitness

/**
 * Identificador de marcas corporativas suportadas pelo ecossistema WGC.
 */
enum class WgcBrandType {
    DEFAULT,
    FINANCE,
    FOOD_DELIVERY,
    ECOMMERCE,
    FASHION,
    FITNESS
}

/**
 * Modelo de Tema Whitelabel Multi-Tenancy para o Design System WGC.
 * Permite que diferentes produtos da organização compartilhem componentes com identidades cromáticas customizadas.
 */
data class WgcBrandTheme(
    val brandType: WgcBrandType,
    override val primaryColor: Int,
    override val secondaryColor: Int,
    override val backgroundColor: Int,
    val surfaceColor: Int,
    val onPrimaryColor: Int,
    val onSurfaceColor: Int,
    val errorColor: Int
) : WgcThemeTokens {

    companion object {
        /**
         * Tema padrão corporativo WGC.
         */
        fun default(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.DEFAULT,
            primaryColor = WgcCoreDsColorsFacade.primary,
            secondaryColor = WgcCoreDsColorsFacade.secondary,
            backgroundColor = WgcCoreDsColorsFacade.background,
            surfaceColor = 0xFFFFFFFF.toInt(),
            onPrimaryColor = 0xFFFFFFFF.toInt(),
            onSurfaceColor = 0xFF1C1B1F.toInt(),
            errorColor = 0xFFBA1A1A.toInt()
        )

        /**
         * Tema Whitelabel para serviços de Finanças e Banco Digital.
         */
        fun finance(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.FINANCE,
            primaryColor = WgcBrandFinance.personalFinancePrimary,
            secondaryColor = WgcBrandFinance.personalFinanceSecondary,
            backgroundColor = WgcBrandFinance.personalFinanceBackground,
            surfaceColor = WgcBrandFinance.personalFinanceSurface,
            onPrimaryColor = 0xFFFFFFFF.toInt(),
            onSurfaceColor = WgcBrandFinance.personalFinanceDark,
            errorColor = WgcBrandFinance.personalFinanceExpenseRed
        )

        /**
         * Tema Whitelabel para aplicativos de Delivery e Gastronomia.
         */
        fun foodDelivery(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.FOOD_DELIVERY,
            primaryColor = WgcBrandFoodDelivery.foodDeliveryRed,
            secondaryColor = WgcBrandFoodDelivery.foodDeliveryGreen,
            backgroundColor = WgcBrandFoodDelivery.foodDeliveryBgGray,
            surfaceColor = 0xFFFFFFFF.toInt(),
            onPrimaryColor = 0xFFFFFFFF.toInt(),
            onSurfaceColor = WgcBrandFoodDelivery.foodDeliveryDarkBlue,
            errorColor = WgcBrandFoodDelivery.foodDeliveryRedDark
        )

        /**
         * Tema Whitelabel para E-commerce e Varejo.
         */
        fun ecommerce(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.ECOMMERCE,
            primaryColor = WgcBrandEcommerce.dealMarketplaceOrange,
            secondaryColor = WgcBrandEcommerce.trendFashionBlue,
            backgroundColor = WgcBrandEcommerce.trendFashionLightGray,
            surfaceColor = 0xFFFFFFFF.toInt(),
            onPrimaryColor = 0xFFFFFFFF.toInt(),
            onSurfaceColor = WgcBrandEcommerce.trendFashionDark,
            errorColor = WgcBrandEcommerce.globalMarketplaceRed
        )

        /**
         * Tema Whitelabel para Moda e Lifestyle.
         */
        fun fashion(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.FASHION,
            primaryColor = WgcBrandFashion.megaStorePrimary,
            secondaryColor = WgcBrandFashion.megaStoreGold,
            backgroundColor = WgcBrandFashion.megaStoreBackground,
            surfaceColor = 0xFFFFFFFF.toInt(),
            onPrimaryColor = 0xFFFFFFFF.toInt(),
            onSurfaceColor = WgcBrandFashion.megaStoreDark,
            errorColor = WgcBrandFashion.retailAlertRed
        )

        /**
         * Tema Whitelabel para Saúde e Fitness.
         */
        fun fitness(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.FITNESS,
            primaryColor = WgcBrandFitness.gymYellow,
            secondaryColor = WgcBrandFitness.gymAccentCyan,
            backgroundColor = WgcBrandFitness.gymDarkGray,
            surfaceColor = WgcBrandFitness.gymBlack,
            onPrimaryColor = WgcBrandFitness.gymTextInverse,
            onSurfaceColor = WgcBrandFitness.gymTextPrimary,
            errorColor = WgcBrandFitness.gymCrowdHigh
        )
    }
}
