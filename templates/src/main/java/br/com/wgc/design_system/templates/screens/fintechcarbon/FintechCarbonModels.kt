package br.com.wgc.design_system.templates.screens.fintechcarbon

data class C6AtomosReward(
    val id: String,
    val title: String,
    val pointsRequired: Int,
    val category: String
)

object FintechCarbonMockData {
    val sampleRewards = listOf(
        C6AtomosReward("1", "R$ 50 de Cashback na Fatura", 2500, "Cashback"),
        C6AtomosReward("2", "1.000 Milhas Smiles / Livelo", 1000, "Milhas"),
        C6AtomosReward("3", "Cafeteira Nespresso Essenza", 18000, "Produtos"),
        C6AtomosReward("4", "Fone JBL Tune Bluetooth", 9500, "Eletrônicos")
    )
}
