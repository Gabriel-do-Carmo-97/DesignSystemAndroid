package br.com.wgc.core_ds

interface WgcThemeTokens {
    val primaryColor: Int
    val secondaryColor: Int
    val backgroundColor: Int
}

class DefaultWgcThemeTokens : WgcThemeTokens {
    override val primaryColor: Int = WgcCoreDsColors.primary
    override val secondaryColor: Int = WgcCoreDsColors.secondary
    override val backgroundColor: Int = WgcCoreDsColors.background
}
