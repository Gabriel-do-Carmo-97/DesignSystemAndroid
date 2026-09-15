package br.com.wgc.ds_templates.screens.zeedog

data class ZeeDogProduct(val id: String, val name: String, val category: String, val price: Double)

object ZeeDogMockData {
    val sampleProducts = listOf(
        ZeeDogProduct("1", "Guia com Amortecedor Gotham", "Passeio", 169.00),
        ZeeDogProduct("2", "Cama Zee.Bed Viscoelástica Tamanho L", "Conforto", 549.00),
        ZeeDogProduct("3", "Zee.Dog Kitchen Alimentação Natural Frango 1kg", "Nutrição", 68.00)
    )
}
