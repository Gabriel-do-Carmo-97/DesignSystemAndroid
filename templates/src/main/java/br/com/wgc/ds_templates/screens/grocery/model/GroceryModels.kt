package br.com.wgc.ds_templates.screens.grocery.model

/**
 * Modelo de item de produto do hipermercado Supermercado Brasil.
 */
data class SupermercadoProductItem(
    val id: String,
    val title: String,
    val brandLine: String,
    val unit: String,
    val regularPrice: Double,
    val cardSupermercadoPrice: Double,
    val nutriScore: String? = "A",
    val discountPercentage: String? = null,
    val installmentsText: String? = "em até 10x sem juros",
    val quantity: Int = 0,
    val isFavorite: Boolean = false,
    val price: Double = regularPrice,
    val groceryCardPrice: Double = cardSupermercadoPrice
)

/**
 * Cupom exclusivo do programa "Meu Supermercado".
 */
data class SupermercadoCouponItem(
    val id: String,
    val title: String,
    val category: String,
    val discountBadge: String,
    val minSpend: String,
    val validUntil: String,
    val isActivated: Boolean = false,
    val description: String = minSpend
)

/**
 * Item no carrinho de compras do Supermercado.
 */
data class SupermercadoCartItem(
    val product: SupermercadoProductItem,
    val quantity: Int
)

/**
 * Oferta em destaque no tabloide / folheto digital Supermercado.
 */
data class SupermercadoFlyerOffer(
    val id: String,
    val title: String,
    val department: String,
    val promoTag: String,
    val price: Double,
    val cardPrice: Double,
    val discountBadge: String = promoTag,
    val originalPrice: Double = price,
    val promoPrice: Double = cardPrice
)

/**
 * Perfil do usuário e dados do Cartão Supermercado.
 */
data class SupermercadoUserProfile(
    val name: String,
    val cardLastDigits: String,
    val availableLimit: Double,
    val coinsBalance: Int,
    val bestPurchaseDay: Int,
    val selectedStore: String,
    val deliveryOption: String,
    val cpf: String = "123.***.***-00",
    val membershipLevel: String = "Cliente Ouro",
    val email: String = "cliente@supermercado.com.br",
    val invoiceAmount: Double = 1420.50
)

/**
 * Dados simulados do Supermercado Brasil.
 */
object GroceryMockData {

    val defaultUser = SupermercadoUserProfile(
        name = "Gabriel do Carmo",
        cardLastDigits = "8412",
        availableLimit = 4250.00,
        coinsBalance = 380,
        bestPurchaseDay = 15,
        selectedStore = "Supermercado Hipermercado - Pamplona / Jardins",
        deliveryOption = "Entrega Express em até 2h ou Retire no Hipermercado"
    )

    val products = listOf(
        SupermercadoProductItem(
            id = "crf_1",
            title = "Arroz Tipo 1 Supermercado Classic 5kg",
            brandLine = "Supermercado Classic",
            unit = "Pacote 5kg",
            regularPrice = 32.90,
            cardSupermercadoPrice = 28.90,
            nutriScore = "A",
            discountPercentage = "-12%",
            installmentsText = "em até 3x sem juros no Cartão Supermercado",
            quantity = 1,
            isFavorite = true
        ),
        SupermercadoProductItem(
            id = "crf_2",
            title = "Azeite de Oliva Extra Virgem Supermercado Bio 500ml",
            brandLine = "Supermercado Bio Orgânico",
            unit = "Vidro 500ml",
            regularPrice = 45.90,
            cardSupermercadoPrice = 38.90,
            nutriScore = "B",
            discountPercentage = "-15%",
            installmentsText = "Preço exclusivo Cartão Supermercado",
            quantity = 0,
            isFavorite = false
        ),
        SupermercadoProductItem(
            id = "crf_3",
            title = "Café Torrado e Moído Supermercado Tradicional 500g",
            brandLine = "Supermercado Classic",
            unit = "Vácuo 500g",
            regularPrice = 21.90,
            cardSupermercadoPrice = 17.90,
            nutriScore = "A",
            discountPercentage = "-18%",
            installmentsText = "Leve 3 por R$ 16,90 cada",
            quantity = 2,
            isFavorite = false
        ),
        SupermercadoProductItem(
            id = "crf_4",
            title = "Lava Roupas Líquido Omo Lavagem Perfeita 3L",
            brandLine = "Limpeza & Cuidado",
            unit = "Galão 3L",
            regularPrice = 54.90,
            cardSupermercadoPrice = 44.90,
            nutriScore = null,
            discountPercentage = "-20%",
            installmentsText = "ou em até 10x sem juros",
            quantity = 0,
            isFavorite = true
        ),
        SupermercadoProductItem(
            id = "crf_5",
            title = "Cerveja Heineken Puro Malte Garrafa 600ml",
            brandLine = "Bebidas & Adega",
            unit = "Garrafa 600ml",
            regularPrice = 11.90,
            cardSupermercadoPrice = 9.90,
            nutriScore = null,
            discountPercentage = "-16%",
            installmentsText = "Gela Fácil Supermercado",
            quantity = 0,
            isFavorite = false
        )
    )

    val coupons = listOf(
        SupermercadoCouponItem(
            id = "coup_1",
            title = "20% OFF em toda a linha de Marca Própria Supermercado",
            category = "Marca Própria",
            discountBadge = "20% OFF",
            minSpend = "Em compras acima de R$ 50",
            validUntil = "Expira em 3 dias",
            isActivated = true
        ),
        SupermercadoCouponItem(
            id = "coup_2",
            title = "R$ 30 de desconto no Cartão Supermercado no setor Eletro & Bazar",
            category = "Cartão Supermercado",
            discountBadge = "R$ 30 OFF",
            minSpend = "Em compras acima de R$ 200",
            validUntil = "Expira hoje",
            isActivated = true
        ),
        SupermercadoCouponItem(
            id = "coup_3",
            title = "Compre 4 Pague 3 em Hortifruti Fresco (Terça & Quarta)",
            category = "Hortifruti",
            discountBadge = "Leve 4 Pague 3",
            minSpend = "Sem valor mínimo",
            validUntil = "Válido até quarta-feira",
            isActivated = false
        ),
        SupermercadoCouponItem(
            id = "coup_4",
            title = "15% de Cashback em Moedas Supermercado no Posto de Combustível",
            category = "Posto Supermercado",
            discountBadge = "15% Moedas",
            minSpend = "Ao abastecer no mínimo 30L",
            validUntil = "Válido até domingo",
            isActivated = false
        )
    )

    val flyerOffers = listOf(
        SupermercadoFlyerOffer(
            id = "flyer_1",
            title = "Picanha Bovina Fatiada Resfriada kg",
            department = "Açougue & Carnes",
            promoTag = "SUPER OFERTA SUPERMERCADO",
            price = 69.90,
            cardPrice = 59.90
        ),
        SupermercadoFlyerOffer(
            id = "flyer_2",
            title = "Smart TV LED 50\" 4K UHD Samsung",
            department = "Eletrônicos & TV",
            promoTag = "10X SEM JUROS",
            price = 2299.00,
            cardPrice = 2099.00
        ),
        SupermercadoFlyerOffer(
            id = "flyer_3",
            title = "Fritadeira Sem Óleo Air Fryer Mondial 4L",
            department = "Eletroportáteis",
            promoTag = "OFERTA DO FOLHETO",
            price = 349.90,
            cardPrice = 299.90
        )
    )

    val cartItems = listOf(
        SupermercadoCartItem(product = products[0], quantity = 1),
        SupermercadoCartItem(product = products[2], quantity = 2)
    )

    val sampleUserProfile = defaultUser
    val sampleProducts = products
    val sampleCoupons = coupons
    val sampleFlyerOffers = flyerOffers
    val sampleCartItems = cartItems
}
