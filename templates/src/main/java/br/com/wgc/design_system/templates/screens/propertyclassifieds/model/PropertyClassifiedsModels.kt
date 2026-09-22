package br.com.wgc.design_system.templates.screens.propertyclassifieds.model

import br.com.wgc.design_system.components.cards.WgcZapFipeStatus

/**
 * Tipo de transação imobiliária do Zap.
 */
enum class ZapTransactionType(val label: String) {
    BUY("Comprar"),
    RENT("Alugar"),
    NEW_DEVELOPMENTS("Lançamentos")
}

/**
 * Modelo de dados de um Imóvel no Zap Imóveis.
 */
data class ZapPropertyModel(
    val id: String,
    val title: String,
    val price: String,
    val pricePerSquareMeter: String,
    val condoAndIptu: String? = null,
    val neighborhood: String,
    val address: String,
    val areaM2: Int,
    val bedrooms: Int,
    val suites: Int = 0,
    val bathrooms: Int,
    val parkingSpaces: Int,
    val fipeStatus: WgcZapFipeStatus = WgcZapFipeStatus.ON_AVERAGE,
    val badgeText: String? = "Super Destaque",
    val advertiserName: String = "Zap Prime Imóveis",
    val advertiserCreci: String = "CRECI 24890-J",
    val advertiserPhone: String = "(11) 98765-4321",
    val amenities: List<String> = listOf("Varanda Gourmet", "Piscina", "Academia", "Churrasqueira", "Depósito"),
    val description: String = "Excelente oportunidade em localização nobre. " +
        "Planta moderna com acabamentos premium, vista panorâmica e condomínio clube completo.",
    val hasVirtualTour: Boolean = true,
    val isFavorite: Boolean = false,
    val transactionType: ZapTransactionType = ZapTransactionType.BUY
)

/**
 * Modelo de dados do Índice FipeZAP para um bairro.
 */
data class ZapFipeNeighborhoodMetric(
    val neighborhood: String,
    val city: String = "São Paulo, SP",
    val averageM2Price: String,
    val variation12m: String,
    val rentalYieldAnnual: String,
    val isRising: Boolean = true
)

/**
 * Alerta de busca salva no Zap Imóveis.
 */
data class ZapSearchAlertModel(
    val id: String,
    val title: String,
    val criteria: String,
    val newPropertiesCount: Int,
    val frequency: String = "Diário",
    val notificationsEnabled: Boolean = true
)

/**
 * Repositório de dados simulados (Mock) para o Zap Imóveis.
 */
object PropertyClassifiedsMockData {
    val sampleProperties: List<ZapPropertyModel> = listOf(
        ZapPropertyModel(
            id = "zap-01",
            title = "Apartamento Alto Padrão com Varanda Gourmet",
            price = "R$ 1.850.000",
            pricePerSquareMeter = "R$ 13.703/m²",
            condoAndIptu = "Condomínio R$ 1.650 • IPTU R$ 680",
            neighborhood = "Itaim Bibi",
            address = "Rua Joaquim Floriano, 900",
            areaM2 = 135,
            bedrooms = 3,
            suites = 2,
            bathrooms = 4,
            parkingSpaces = 2,
            fipeStatus = WgcZapFipeStatus.BELOW_AVERAGE,
            badgeText = "Super Destaque",
            hasVirtualTour = true,
            isFavorite = true,
            transactionType = ZapTransactionType.BUY
        ),
        ZapPropertyModel(
            id = "zap-02",
            title = "Studio Moderno Próximo à Faria Lima",
            price = "R$ 4.200 /mês",
            pricePerSquareMeter = "R$ 93/m²",
            condoAndIptu = "Condomínio R$ 580 • IPTU R$ 140",
            neighborhood = "Pinheiros",
            address = "Rua dos Pinheiros, 450",
            areaM2 = 45,
            bedrooms = 1,
            suites = 1,
            bathrooms = 1,
            parkingSpaces = 1,
            fipeStatus = WgcZapFipeStatus.ON_AVERAGE,
            badgeText = "Destaque Zap",
            hasVirtualTour = true,
            isFavorite = false,
            transactionType = ZapTransactionType.RENT
        ),
        ZapPropertyModel(
            id = "zap-03",
            title = "Cobertura Duplex com Vista Panorâmica",
            price = "R$ 3.450.000",
            pricePerSquareMeter = "R$ 16.428/m²",
            condoAndIptu = "Condomínio R$ 2.800 • IPTU R$ 1.150",
            neighborhood = "Moema Pássaros",
            address = "Avenida Rouxinol, 780",
            areaM2 = 210,
            bedrooms = 4,
            suites = 3,
            bathrooms = 5,
            parkingSpaces = 3,
            fipeStatus = WgcZapFipeStatus.ABOVE_AVERAGE,
            badgeText = "Super Destaque",
            hasVirtualTour = true,
            isFavorite = false,
            transactionType = ZapTransactionType.BUY
        ),
        ZapPropertyModel(
            id = "zap-04",
            title = "Lançamento Icon Moema Residencial",
            price = "A partir de R$ 780.000",
            pricePerSquareMeter = "R$ 12.000/m²",
            condoAndIptu = "Entrega em Dez/2027",
            neighborhood = "Moema",
            address = "Alameda dos Arapanés, 320",
            areaM2 = 65,
            bedrooms = 2,
            suites = 1,
            bathrooms = 2,
            parkingSpaces = 1,
            fipeStatus = WgcZapFipeStatus.BELOW_AVERAGE,
            badgeText = "Lançamento Exclusivo",
            hasVirtualTour = false,
            isFavorite = true,
            transactionType = ZapTransactionType.NEW_DEVELOPMENTS
        )
    )

    val fipeTopNeighborhoods: List<ZapFipeNeighborhoodMetric> = listOf(
        ZapFipeNeighborhoodMetric(
            neighborhood = "Itaim Bibi",
            averageM2Price = "R$ 17.890/m²",
            variation12m = "+6,4%",
            rentalYieldAnnual = "5,2% a.a."
        ),
        ZapFipeNeighborhoodMetric(
            neighborhood = "Pinheiros",
            averageM2Price = "R$ 15.420/m²",
            variation12m = "+7,1%",
            rentalYieldAnnual = "5,6% a.a."
        ),
        ZapFipeNeighborhoodMetric(
            neighborhood = "Jardins",
            averageM2Price = "R$ 16.150/m²",
            variation12m = "+4,8%",
            rentalYieldAnnual = "4,9% a.a."
        ),
        ZapFipeNeighborhoodMetric(
            neighborhood = "Moema",
            averageM2Price = "R$ 14.800/m²",
            variation12m = "+5,9%",
            rentalYieldAnnual = "5,4% a.a."
        ),
        ZapFipeNeighborhoodMetric(
            neighborhood = "Vila Madalena",
            averageM2Price = "R$ 13.950/m²",
            variation12m = "+5,1%",
            rentalYieldAnnual = "5,3% a.a."
        ),
        ZapFipeNeighborhoodMetric(
            neighborhood = "Brooklin",
            averageM2Price = "R$ 12.600/m²",
            variation12m = "+4,5%",
            rentalYieldAnnual = "5,8% a.a."
        )
    )

    val sampleSearchAlerts: List<ZapSearchAlertModel> = listOf(
        ZapSearchAlertModel(
            id = "alert-01",
            title = "Apartamento 3 quartos no Itaim Bibi",
            criteria = "Comprar • 3+ quartos • Até R$ 2.000.000 • 2+ vagas",
            newPropertiesCount = 14
        ),
        ZapSearchAlertModel(
            id = "alert-02",
            title = "Studio ou 1 dormitório em Pinheiros",
            criteria = "Alugar • Até R$ 4.500/mês • Mobiliado • Próximo ao metrô",
            newPropertiesCount = 8
        )
    )
}
