package br.com.wgc.design_system.core.brand

import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.theme.WgcCoreDsColorsFacade
import br.com.wgc.design_system.core.theme.WgcThemeTokens

/**
 * Modelo de Tema Whitelabel Multi-Tenancy para o Design System WGC.
 * Permite que diferentes produtos da organização compartilhem componentes com identidades cromáticas customizadas.
 *
 * Exemplo: `val theme = WgcBrandTheme.finance()`.
 * Quando usar: escolha esta API quando configurar a identidade visual de um tenant ou produto.
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
         * Quando usar: chame este método ao obter o tema corporativo padrão.
         */
        fun default(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.DEFAULT,
            primaryColor = WgcCoreDsColorsFacade.orange500,
            secondaryColor = WgcCoreDsColorsFacade.white,
            backgroundColor = WgcCoreDsColorsFacade.gray50,
            surfaceColor = WgcCoreDsColors.white,
            onPrimaryColor = WgcCoreDsColors.white,
            onSurfaceColor = WgcCoreDsColors.grayDark10,
            errorColor = WgcCoreDsColors.red6
        )

        /**
         * Tema Whitelabel para serviços de Finanças e Banco Digital.
         * Quando usar: chame este método ao obter a paleta adequada a produtos financeiros e bancários.
         */
        fun finance(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.FINANCE,
            primaryColor = WgcCoreDsColors.cyan3,
            secondaryColor = WgcCoreDsColors.cyan8,
            backgroundColor = WgcCoreDsColors.blueLight27,
            surfaceColor = WgcCoreDsColors.white,
            onPrimaryColor = WgcCoreDsColors.white,
            onSurfaceColor = WgcCoreDsColors.blueDark33,
            errorColor = WgcCoreDsColors.red23
        )

        /**
         * Tema Whitelabel para aplicativos de Delivery e Gastronomia.
         * Quando usar: chame este método ao obter a paleta adequada a produtos de delivery e gastronomia.
         */
        fun foodDelivery(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.FOOD_DELIVERY,
            primaryColor = WgcCoreDsColors.red18,
            secondaryColor = WgcCoreDsColors.green8,
            backgroundColor = WgcCoreDsColors.grayLight9,
            surfaceColor = WgcCoreDsColors.white,
            onPrimaryColor = WgcCoreDsColors.white,
            onSurfaceColor = WgcCoreDsColors.blueDark18,
            errorColor = WgcCoreDsColors.red9
        )

        /**
         * Tema Whitelabel para E-commerce e Varejo.
         * Quando usar: chame este método ao obter a paleta adequada a produtos de comércio eletrônico.
         */
        fun ecommerce(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.ECOMMERCE,
            primaryColor = WgcCoreDsColors.red21,
            secondaryColor = WgcCoreDsColors.blue42,
            backgroundColor = WgcCoreDsColors.grayLight10,
            surfaceColor = WgcCoreDsColors.white,
            onPrimaryColor = WgcCoreDsColors.white,
            onSurfaceColor = WgcCoreDsColors.blueDark19,
            errorColor = WgcCoreDsColors.red27
        )

        /**
         * Tema Whitelabel para Moda e Lifestyle.
         * Quando usar: chame este método ao obter a paleta adequada a produtos de moda e lifestyle.
         */
        fun fashion(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.FASHION,
            primaryColor = WgcCoreDsColors.blue28,
            secondaryColor = WgcCoreDsColors.orange30,
            backgroundColor = WgcCoreDsColors.gray100,
            surfaceColor = 0xFFFFFFFF.toInt(),
            onPrimaryColor = 0xFFFFFFFF.toInt(),
            onSurfaceColor = WgcCoreDsColors.grayDark14,
            errorColor = WgcCoreDsColors.red23
        )

        /**
         * Tema Whitelabel para Saúde e Fitness.
         * Quando usar: chame este método ao obter a paleta adequada a produtos de saúde e fitness.
         */
        fun fitness(): WgcBrandTheme = WgcBrandTheme(
            brandType = WgcBrandType.FITNESS,
            primaryColor = WgcCoreDsColors.orange23,
            secondaryColor = WgcCoreDsColors.cyan9,
            backgroundColor = WgcCoreDsColors.grayDark7,
            surfaceColor = WgcCoreDsColors.grayDark1,
            onPrimaryColor = WgcCoreDsColors.black,
            onSurfaceColor = WgcCoreDsColors.white,
            errorColor = WgcCoreDsColors.red25
        )
    }
}
