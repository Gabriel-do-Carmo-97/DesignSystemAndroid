package br.com.wgc.design_system.templates.screens.fintechsuperapp

data class InterShopDeal(
    val id: String,
    val storeName: String,
    val description: String,
    val cashbackPercent: String,
    val tag: String
)

data class InterInvestmentOption(
    val id: String,
    val name: String,
    val type: String,
    val profitability: String,
    val minimumAmount: Double
)

object FintechSuperAppMockData {
    val sampleShopDeals = listOf(
        InterShopDeal("1", "Amazon", "Eletrônicos, livros e informática", "8% de volta", "Destaque"),
        InterShopDeal("2", "Marketplace", "Eletrodomésticos e móveis", "10% de volta", "Cashback Turbo"),
        InterShopDeal("3", "Nike Brasil", "Tênis e vestuário esportivo", "12% de volta", "Exclusivo"),
        InterShopDeal("4", "Perfumaria Prestige", "Perfumaria e cosméticos", "7% de volta", "Beleza")
    )

    val sampleInvestments = listOf(
        InterInvestmentOption("1", "CDB Meu Porquinho", "Renda Fixa", "102% do CDI", 1.0),
        InterInvestmentOption("2", "LCI DI Liquidez 90 Dias", "Isento de IR", "95% do CDI", 50.0),
        InterInvestmentOption("3", "Tesouro Selic 2029", "Títulos Públicos", "Selic + 0,15%", 140.0)
    )
}
