package br.com.wgc.ds_templates.screens.propertyrental.model

import br.com.wgc.design_system.components.fields.WgcPropertyRentalContractType

/**
 * Modelo representativo de um imóvel do PropertyRental.
 */
data class PropertyRentalPropertyModel(
    val id: String,
    val title: String,
    val neighborhood: String,
    val address: String,
    val city: String = "São Paulo",
    val rentPrice: String,
    val condoPrice: String,
    val iptuPrice: String,
    val serviceFee: String,
    val fireInsurance: String,
    val totalPrice: String,
    val areaM2: Int,
    val bedrooms: Int,
    val suites: Int = 0,
    val bathrooms: Int,
    val parkingSpots: Int,
    val isFurnished: Boolean = false,
    val petFriendly: Boolean = true,
    val nearMetro: Boolean = true,
    val metroDistanceText: String = "300m do metrô",
    val tags: List<String> = listOf("Sem Fiador"),
    val amenities: List<String> = listOf("Piscina", "Academia", "Portaria 24h", "Varanda"),
    val isFavorite: Boolean = false,
    val isRent: Boolean = true
)

/**
 * Modelo de visita agendada a um imóvel.
 */
data class PropertyRentalVisitModel(
    val id: String,
    val propertyId: String,
    val propertyTitle: String,
    val propertyAddress: String,
    val dateText: String,
    val timeSlot: String,
    val isVideo: Boolean = false,
    val status: String = "Confirmada",
    val brokerName: String = "Carlos Mendes (Corretor Parceiro)"
)

/**
 * Estado de filtros de busca.
 */
data class PropertyRentalFilterState(
    val contractType: WgcPropertyRentalContractType = WgcPropertyRentalContractType.Rent,
    val maxPrice: String? = null,
    val minBedrooms: Int = 0,
    val parkingOnly: Boolean = false,
    val petFriendlyOnly: Boolean = false,
    val furnishedOnly: Boolean = false,
    val nearMetroOnly: Boolean = false
)

/**
 * Dados de amostra oficiais para previews e demonstrações PropertyRental.
 */
object PropertyRentalMockData {
    val properties: List<PropertyRentalPropertyModel> = listOf(
        PropertyRentalPropertyModel(
            id = "qa-prop-1",
            title = "Apartamento amplo com varanda gourmet",
            neighborhood = "Pinheiros",
            address = "Rua Mourato Coelho, 740",
            rentPrice = "R$ 3.500",
            condoPrice = "R$ 650",
            iptuPrice = "R$ 180",
            serviceFee = "R$ 95",
            fireInsurance = "R$ 35",
            totalPrice = "Total R$ 4.460 /mês",
            areaM2 = 74,
            bedrooms = 2,
            suites = 1,
            bathrooms = 2,
            parkingSpots = 1,
            isFurnished = true,
            petFriendly = true,
            nearMetro = true,
            metroDistanceText = "350m do Metrô Fradique Coutinho",
            tags = listOf("Sem Fiador", "Metrô próximo"),
            amenities = listOf("Piscina", "Academia", "Varanda gourmet", "Portaria 24h", "Pet friendly", "Churrasqueira"),
            isFavorite = true
        ),
        PropertyRentalPropertyModel(
            id = "qa-prop-2",
            title = "Studio moderno mobiliado de alto padrão",
            neighborhood = "Vila Madalena",
            address = "Rua Harmonia, 420",
            rentPrice = "R$ 2.800",
            condoPrice = "R$ 480",
            iptuPrice = "R$ 120",
            serviceFee = "R$ 75",
            fireInsurance = "R$ 28",
            totalPrice = "Total R$ 3.503 /mês",
            areaM2 = 42,
            bedrooms = 1,
            suites = 0,
            bathrooms = 1,
            parkingSpots = 0,
            isFurnished = true,
            petFriendly = true,
            nearMetro = true,
            metroDistanceText = "200m do Metrô Vila Madalena",
            tags = listOf("Sem Fiador", "Mobiliado", "Destaque"),
            amenities = listOf("Academia", "Rooftop", "Lavanderia compartilhada", "Bicicletário"),
            isFavorite = false
        ),
        PropertyRentalPropertyModel(
            id = "qa-prop-3",
            title = "Apartamento espaçoso com vista panorâmica",
            neighborhood = "Itaim Bibi",
            address = "Rua Joaquim Floriano, 880",
            rentPrice = "R$ 5.900",
            condoPrice = "R$ 1.100",
            iptuPrice = "R$ 340",
            serviceFee = "R$ 150",
            fireInsurance = "R$ 55",
            totalPrice = "Total R$ 7.545 /mês",
            areaM2 = 110,
            bedrooms = 3,
            suites = 2,
            bathrooms = 3,
            parkingSpots = 2,
            isFurnished = false,
            petFriendly = true,
            nearMetro = false,
            metroDistanceText = "1.2km do Parque do Povo",
            tags = listOf("Sem Fiador", "2 Vagas"),
            amenities = listOf("Piscina aquecida", "Academia", "Quadra poliesportiva", "Portaria 24h", "Depósito"),
            isFavorite = false
        ),
        PropertyRentalPropertyModel(
            id = "qa-prop-4",
            title = "Apartamento aconchegante perto do parque",
            neighborhood = "Vila Mariana",
            address = "Rua Domingos de Morais, 1500",
            rentPrice = "R$ 3.100",
            condoPrice = "R$ 590",
            iptuPrice = "R$ 140",
            serviceFee = "R$ 80",
            fireInsurance = "R$ 30",
            totalPrice = "Total R$ 3.940 /mês",
            areaM2 = 68,
            bedrooms = 2,
            suites = 1,
            bathrooms = 2,
            parkingSpots = 1,
            isFurnished = false,
            petFriendly = true,
            nearMetro = true,
            metroDistanceText = "400m do Metrô Ana Rosa",
            tags = listOf("Sem Fiador", "Preço Baixou"),
            amenities = listOf("Salão de festas", "Playground", "Portaria 24h", "Aceita pet"),
            isFavorite = true
        ),
        PropertyRentalPropertyModel(
            id = "qa-prop-5",
            title = "Cobertura duplex com área externa privativa",
            neighborhood = "Perdizes",
            address = "Rua Monte Alegre, 980",
            rentPrice = "R$ 7.500",
            condoPrice = "R$ 1.400",
            iptuPrice = "R$ 480",
            serviceFee = "R$ 190",
            fireInsurance = "R$ 70",
            totalPrice = "Total R$ 9.640 /mês",
            areaM2 = 155,
            bedrooms = 3,
            suites = 2,
            bathrooms = 4,
            parkingSpots = 3,
            isFurnished = true,
            petFriendly = true,
            nearMetro = false,
            metroDistanceText = "Próximo à PUC e Parque da Água Branca",
            tags = listOf("Sem Fiador", "Cobertura"),
            amenities = listOf("Churrasqueira privativa", "Jacuzzi", "Piscina", "Academia", "Portaria 24h"),
            isFavorite = false
        )
    )

    val visits: List<PropertyRentalVisitModel> = listOf(
        PropertyRentalVisitModel(
            id = "visit-1",
            propertyId = "qa-prop-1",
            propertyTitle = "Apartamento amplo com varanda gourmet",
            propertyAddress = "Rua Mourato Coelho, 740 - Pinheiros",
            dateText = "Amanhã, 15 de Setembro",
            timeSlot = "10:30",
            isVideo = false,
            status = "Confirmada",
            brokerName = "Carlos Mendes (Corretor Parceiro)"
        ),
        PropertyRentalVisitModel(
            id = "visit-2",
            propertyId = "qa-prop-2",
            propertyTitle = "Studio moderno mobiliado",
            propertyAddress = "Rua Harmonia, 420 - Vila Madalena",
            dateText = "Quinta-feira, 17 de Setembro",
            timeSlot = "15:00",
            isVideo = true,
            status = "Agendada por Vídeo",
            brokerName = "Mariana Castro (Corretora Parceira)"
        )
    )

    val sampleDetailProperty: PropertyRentalPropertyModel = properties[0]
}
