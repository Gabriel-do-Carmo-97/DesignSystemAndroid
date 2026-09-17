package br.com.wgc.ds_templates.screens.hypermarket.model

/**
 * Modelo de Produto de Supermercado do Clube Extra.
 */
data class ExtraProductItem(
    val id: String,
    val name: String,
    val unitDescription: String,
    val regularPrice: String,
    val clubPrice: String,
    val discountPercentage: String,
    val category: String,
    val isDiscountActivated: Boolean = true,
    val quantityInCart: Int = 0
)

/**
 * Modelo de Cupom "Meu Desconto" do Clube Extra.
 */
data class ExtraCouponItem(
    val id: String,
    val title: String,
    val category: String,
    val discountBadge: String,
    val limitCondition: String,
    val validUntil: String,
    val isActivated: Boolean = false
)

/**
 * Modelo da Campanha de Fidelidade "Juntou Ganhou" do Clube Extra.
 */
data class ExtraStampsLoyalty(
    val currentStamps: Int,
    val targetStamps: Int,
    val rewardName: String,
    val amountToNextStamp: String
)

/**
 * Modelo de Item no Carrinho de Supermercado.
 */
data class ExtraCartItem(
    val product: ExtraProductItem,
    val quantity: Int
) {
    val totalClubPriceValue: Double
        get() {
            val clean = product.clubPrice.replace("R$", "").replace(",", ".").trim()
            return (clean.toDoubleOrNull() ?: 0.0) * quantity
        }
}

/**
 * Perfil do Cliente Clube Extra.
 */
data class ExtraUserProfile(
    val name: String,
    val cpfMasked: String,
    val selectedStoreName: String,
    val deliveryAddress: String,
    val loyaltyStamps: ExtraStampsLoyalty
)

/**
 * Dados Mockados Oficiais para as Telas do Clube Extra.
 */
object HypermarketMockData {
    val mockStamps = ExtraStampsLoyalty(
        currentStamps = 18,
        targetStamps = 30,
        rewardName = "Panela Wok Antiaderente Royal VKB 28cm",
        amountToNextStamp = "R$ 11,50"
    )

    val mockUser = ExtraUserProfile(
        name = "Gabriel do Carmo",
        cpfMasked = "***.482.918-**",
        selectedStoreName = "Extra Hiper - Morumbi",
        deliveryAddress = "Av. Giovanni Gronchi, 5819 - São Paulo",
        loyaltyStamps = mockStamps
    )

    val mockProducts = listOf(
        ExtraProductItem(
            id = "prod_1",
            name = "Azeite de Oliva Extra Virgem Borges",
            unitDescription = "Vidro 500ml",
            regularPrice = "R$ 42,90",
            clubPrice = "R$ 31,90",
            discountPercentage = "25%",
            category = "Mercearia",
            isDiscountActivated = true,
            quantityInCart = 1
        ),
        ExtraProductItem(
            id = "prod_2",
            name = "Café Torrado e Moído Melitta Tradicional",
            unitDescription = "Vácuo 500g",
            regularPrice = "R$ 21,99",
            clubPrice = "R$ 16,49",
            discountPercentage = "25%",
            category = "Mercearia",
            isDiscountActivated = true,
            quantityInCart = 2
        ),
        ExtraProductItem(
            id = "prod_3",
            name = "Cerveja Heineken Puro Malte Long Neck",
            unitDescription = "Garrafa 330ml",
            regularPrice = "R$ 7,99",
            clubPrice = "R$ 5,99",
            discountPercentage = "25%",
            category = "Bebidas",
            isDiscountActivated = true,
            quantityInCart = 6
        ),
        ExtraProductItem(
            id = "prod_4",
            name = "Sabão Líquido Concentrado Ariel Toque de Downy",
            unitDescription = "Frasco 2 Litros",
            regularPrice = "R$ 54,90",
            clubPrice = "R$ 38,90",
            discountPercentage = "29%",
            category = "Limpeza",
            isDiscountActivated = false,
            quantityInCart = 0
        ),
        ExtraProductItem(
            id = "prod_5",
            name = "Filé de Peito de Frango Sadia Congelado",
            unitDescription = "Pacote 1kg",
            regularPrice = "R$ 24,90",
            clubPrice = "R$ 18,90",
            discountPercentage = "24%",
            category = "Carnes",
            isDiscountActivated = true,
            quantityInCart = 1
        ),
        ExtraProductItem(
            id = "prod_6",
            name = "Leite Condensado Moça Semidesnatado",
            unitDescription = "Lata 395g",
            regularPrice = "R$ 9,49",
            clubPrice = "R$ 6,99",
            discountPercentage = "26%",
            category = "Laticínios",
            isDiscountActivated = false,
            quantityInCart = 0
        )
    )

    val mockCoupons = listOf(
        ExtraCouponItem(
            id = "coup_1",
            title = "30% de desconto em Sabão Líquido Ariel e OMO",
            category = "Limpeza",
            discountBadge = "30% OFF",
            limitCondition = "Limite de até 4 frascos por CPF",
            validUntil = "Válido até domingo, 21/09",
            isActivated = true
        ),
        ExtraCouponItem(
            id = "coup_2",
            title = "25% de desconto em Carnes Nobres para Churrasco",
            category = "Açougue & Carnes",
            discountBadge = "25% OFF",
            limitCondition = "Limite de até 5kg por CPF",
            validUntil = "Válido até domingo, 21/09",
            isActivated = true
        ),
        ExtraCouponItem(
            id = "coup_3",
            title = "Pague 2 e Leve 3 em Cervejas Corona e Stella",
            category = "Bebidas",
            discountBadge = "LEVE 3 PAGUE 2",
            limitCondition = "Limite de até 12 unidades por CPF",
            validUntil = "Válido até segunda, 22/09",
            isActivated = false
        ),
        ExtraCouponItem(
            id = "coup_4",
            title = "40% de desconto na 2ª unidade de Fraldas Pampers",
            category = "Bebê & Infantil",
            discountBadge = "40% NA 2ª UNID.",
            limitCondition = "Válido para pacotes Mega e Hiper",
            validUntil = "Válido até domingo, 21/09",
            isActivated = false
        )
    )
}
