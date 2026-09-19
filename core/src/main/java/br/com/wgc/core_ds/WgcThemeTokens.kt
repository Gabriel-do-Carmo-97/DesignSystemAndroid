package br.com.wgc.core_ds

interface WgcThemeTokens {
    val primaryColor: Int
    val secondaryColor: Int
    val backgroundColor: Int
}

class DefaultWgcThemeTokens : WgcThemeTokens {
    override val primaryColor: Int = WgcCoreDsColorsFacade.primary
    override val secondaryColor: Int = WgcCoreDsColorsFacade.secondary
    override val backgroundColor: Int = WgcCoreDsColorsFacade.background
}
