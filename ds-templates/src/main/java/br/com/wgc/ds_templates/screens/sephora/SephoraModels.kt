package br.com.wgc.ds_templates.screens.sephora

data class SephoraItem(val id: String, val brand: String, val name: String, val pointsReward: Int, val price: Double)

object SephoraMockData {
    val sampleProducts = listOf(
        SephoraItem("1", "Rare Beauty", "Soft Pinch Liquid Blush", 250, 169.00),
        SephoraItem("2", "Fenty Beauty", "Gloss Bomb Universal Lip Luminizer", 200, 149.00),
        SephoraItem("3", "Dior", "Sauvage Eau de Parfum 100ml", 800, 789.00)
    )
}
