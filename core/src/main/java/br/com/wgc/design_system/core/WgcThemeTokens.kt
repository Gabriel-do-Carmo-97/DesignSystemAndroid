package br.com.wgc.design_system.core

interface WgcThemeTokens {
    val primaryColor: Int
    val secondaryColor: Int
    val backgroundColor: Int
}

class DefaultWgcThemeTokens : WgcThemeTokens {
    override val primaryColor: Int = WgcCoreDsColorsFacade.orange500
    override val secondaryColor: Int = WgcCoreDsColorsFacade.white
    override val backgroundColor: Int = WgcCoreDsColorsFacade.gray50
}
