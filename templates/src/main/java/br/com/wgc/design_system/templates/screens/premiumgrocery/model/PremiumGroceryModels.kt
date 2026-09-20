package br.com.wgc.design_system.templates.screens.premiumgrocery.model

/**
 * Modelo de dados de um produto do Supermercado Gourmet.
 */
data class PdaProductItem(
    val id: String,
    val title: String,
    val brandOrOrigin: String,
    val unit: String,
    val originalPrice: Double,
    val clienteMaisPrice: Double,
    val badgeText: String? = null,
    val isOrganic: Boolean = false,
    val quantity: Int = 0,
    val isFavorite: Boolean = false
)

/**
 * Modelo de dados especializado para garrafas da Adega / Sommelier.
 */
data class PdaWineItem(
    val id: String,
    val wineName: String,
    val countryOrigin: String,
    val grape: String,
    val vintage: String,
    val rating: Double,
    val sommelierPoints: Int,
    val pairingTip: String,
    val servingTemp: String,
    val price: Double,
    val clienteMaisPrice: Double,
    val quantity: Int = 0
)

/**
 * Modelo de cupom de desconto personalizado "Meu Desconto Gourmet VIP".
 */
data class PdaDiscountItem(
    val id: String,
    val title: String,
    val category: String,
    val discountBadge: String,
    val economyText: String,
    val validUntil: String,
    val isActivated: Boolean = false
)

/**
 * Modelo de item no carrinho de compras com preferência de substituição gourmet.
 */
data class PdaCartItem(
    val product: PdaProductItem,
    val quantity: Int,
    val substitutionPreference: String = "Trocar por similar de qualidade superior sem acréscimo"
)

/**
 * Perfil VIP do Cliente Mais.
 */
data class PdaUserProfile(
    val name: String,
    val cpfMasked: String,
    val tier: String,
    val stilloCoins: Int,
    val monthlySavings: Double,
    val selectedStore: String,
    val deliveryWindow: String
)

/**
 * Dados simulados e curadoria gourmet para os templates do Supermercado Gourmet.
 */
object PremiumGroceryMockData {

    val defaultUser = PdaUserProfile(
        name = "Gabriel do Carmo",
        cpfMasked = "***.458.918-**",
        tier = "Cliente Mais Black",
        stilloCoins = 3450,
        monthlySavings = 512.80,
        selectedStore = "Supermercado Gourmet - Jardins",
        deliveryWindow = "Hoje entre 17:00 e 19:00 (Entrega Express)"
    )

    val gourmetProducts = listOf(
        PdaProductItem(
            id = "pda_1",
            title = "Azeite de Oliva Extra Virgem Taeq Orgânico",
            brandOrOrigin = "Taeq Orgânico",
            unit = "500ml",
            originalPrice = 52.90,
            clienteMaisPrice = 42.90,
            badgeText = "100% Orgânico",
            isOrganic = true,
            quantity = 1,
            isFavorite = true
        ),
        PdaProductItem(
            id = "pda_2",
            title = "Queijo Brie Francês Casino Délices",
            brandOrOrigin = "Casino França",
            unit = "250g",
            originalPrice = 46.50,
            clienteMaisPrice = 34.90,
            badgeText = "Importado",
            isOrganic = false,
            quantity = 0,
            isFavorite = false
        ),
        PdaProductItem(
            id = "pda_3",
            title = "Filé de Salmão Fresco com Pele Premium",
            brandOrOrigin = "Peixaria Fresca PDA",
            unit = "kg",
            originalPrice = 98.90,
            clienteMaisPrice = 79.90,
            badgeText = "Pesca Sustentável",
            isOrganic = false,
            quantity = 0,
            isFavorite = true
        ),
        PdaProductItem(
            id = "pda_4",
            title = "Café Especial em Grãos Torra Média Taeq",
            brandOrOrigin = "Taeq 100% Arábica",
            unit = "250g",
            originalPrice = 32.90,
            clienteMaisPrice = 24.90,
            badgeText = "Orgânico Certificado",
            isOrganic = true,
            quantity = 2,
            isFavorite = false
        ),
        PdaProductItem(
            id = "pda_5",
            title = "Presunto Cru Jamón Serrano Fatiado",
            brandOrOrigin = "Espanha Curado 14 Meses",
            unit = "100g",
            originalPrice = 39.90,
            clienteMaisPrice = 29.90,
            badgeText = "Charcutaria Fina",
            isOrganic = false,
            quantity = 0,
            isFavorite = false
        )
    )

    val sommelierWines = listOf(
        PdaWineItem(
            id = "wine_1",
            wineName = "Marqués de Riscal Gran Reserva D.O.Ca Rioja",
            countryOrigin = "Espanha • Rioja",
            grape = "Tempranillo, Graciano",
            vintage = "Safra 2018",
            rating = 4.5,
            sommelierPoints = 94,
            pairingTip = "Cordeiro assado, cortes nobres grelhados e queijos maduros.",
            servingTemp = "16°C a 18°C",
            price = 320.00,
            clienteMaisPrice = 249.90,
            quantity = 1
        ),
        PdaWineItem(
            id = "wine_2",
            wineName = "Vinho Branco Chablis Louis Jadot AOC",
            countryOrigin = "França • Borgonha",
            grape = "100% Chardonnay",
            vintage = "Safra 2021",
            rating = 4.3,
            sommelierPoints = 92,
            pairingTip = "Ostras frescas, vieiras grelhadas e risoto de frutos do mar.",
            servingTemp = "10°C a 12°C",
            price = 389.00,
            clienteMaisPrice = 299.00,
            quantity = 0
        ),
        PdaWineItem(
            id = "wine_3",
            wineName = "Brunello di Montalcino DOCG Castiglion del Bosco",
            countryOrigin = "Itália • Toscana",
            grape = "100% Sangiovese Grosso",
            vintage = "Safra 2017",
            rating = 4.7,
            sommelierPoints = 96,
            pairingTip = "Bistecca alla Fiorentina e queijo Pecorino envelhecido.",
            servingTemp = "18°C",
            price = 650.00,
            clienteMaisPrice = 520.00,
            quantity = 0
        ),
        PdaWineItem(
            id = "wine_4",
            wineName = "Espumante Brut Rosé Casa Valduga 130",
            countryOrigin = "Brasil • Vale dos Vinhedos",
            grape = "Chardonnay, Pinot Noir",
            vintage = "Método Tradicional 36m",
            rating = 4.4,
            sommelierPoints = 93,
            pairingTip = "Canapés finos, carpaccio de salmão e sobremesas de frutas vermelhas.",
            servingTemp = "6°C a 8°C",
            price = 169.90,
            clienteMaisPrice = 129.90,
            quantity = 0
        )
    )

    val discounts = listOf(
        PdaDiscountItem(
            id = "disc_1",
            title = "30% OFF em toda a linha de Vinhos e Espumantes Europeus",
            category = "Adega & Sommelier",
            discountBadge = "30% OFF",
            economyText = "Economia média de R$ 85,00 por garrafa",
            validUntil = "Expira em 2 dias",
            isActivated = true
        ),
        PdaDiscountItem(
            id = "disc_2",
            title = "25% OFF em Queijos Importados e Charcutaria Especial",
            category = "Frios & Laticínios Nobres",
            discountBadge = "25% OFF",
            economyText = "Válido para Brie, Camembert, Gorgonzola e Jamón",
            validUntil = "Expira em 4 dias",
            isActivated = true
        ),
        PdaDiscountItem(
            id = "disc_3",
            title = "Compre 3 Pague 2 em Frutas, Legumes e Verduras Taeq Orgânicos",
            category = "Hortifruti & Orgânicos",
            discountBadge = "Leve 3 Pague 2",
            economyText = "Item de menor valor sai grátis",
            validUntil = "Válido até domingo",
            isActivated = false
        ),
        PdaDiscountItem(
            id = "disc_4",
            title = "20% OFF em Azeites Extra Virgem Importados e Nacionais Premiados",
            category = "Mercearia Fina",
            discountBadge = "20% OFF",
            economyText = "Acidez máxima de 0.2%",
            validUntil = "Válido até domingo",
            isActivated = false
        )
    )

    val cartItems = listOf(
        PdaCartItem(product = gourmetProducts[0], quantity = 1),
        PdaCartItem(product = gourmetProducts[3], quantity = 2)
    )
}
