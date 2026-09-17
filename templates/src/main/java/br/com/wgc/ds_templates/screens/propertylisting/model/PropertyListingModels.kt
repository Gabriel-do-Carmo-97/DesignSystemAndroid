package br.com.wgc.ds_templates.screens.propertylisting.model

import br.com.wgc.design_system.components.fields.WgcPropertyListingPurpose

/**
 * Modelo de Imóvel anunciado no portal PropertyListing.
 */
data class PropertyListingPropertyModel(
    val id: String,
    val code: String,
    val title: String,
    val neighborhood: String,
    val address: String,
    val city: String = "São Paulo",
    val price: String,
    val condoPrice: String,
    val iptuPrice: String,
    val areaM2: Int,
    val bedrooms: Int,
    val suites: Int = 1,
    val bathrooms: Int,
    val parkingSpots: Int,
    val isSale: Boolean = true,
    val propertyType: String = "Apartamento",
    val badgeText: String? = "Super Destaque",
    val agencyName: String = "Lopes Prime",
    val agencyCreci: String = "CRECI 19842-J",
    val agencyPhone: String = "(11) 99876-5432",
    val amenities: List<String> = listOf("Piscina", "Academia", "Varanda Gourmet", "Portaria 24h", "Churrasqueira"),
    val description: String = "Excelente imóvel em localização privilegiada, próximo a comércios, " +
        "escolas e com fácil acesso a vias principais. Acabamento moderno e condomínio completo.",
    val hasVirtualTour: Boolean = true,
    val isFavorite: Boolean = false
)

/**
 * Modelo de proposta ou mensagem de contato enviada ao anunciante.
 */
data class PropertyListingLeadForm(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val message: String = "Olá, tenho interesse neste imóvel. Por favor, entre em contato.",
    val scheduleVisit: Boolean = false
)

/**
 * Dados de amostra para testes e previews do ecossistema PropertyListing.
 */
object PropertyListingMockData {
    val properties: List<PropertyListingPropertyModel> = listOf(
        PropertyListingPropertyModel(
            id = "vr-prop-1",
            code = "VR-94812",
            title = "Apartamento à venda com varanda gourmet",
            neighborhood = "Moema",
            address = "Alameda dos Maracatins, 450",
            price = "R$ 890.000",
            condoPrice = "Condomínio R$ 780",
            iptuPrice = "IPTU R$ 220",
            areaM2 = 78,
            bedrooms = 2,
            suites = 1,
            bathrooms = 2,
            parkingSpots = 1,
            isSale = true,
            propertyType = "Apartamento",
            badgeText = "Super Destaque",
            agencyName = "Lopes Prime",
            agencyCreci = "CRECI 19842-J",
            amenities = listOf("Piscina", "Academia", "Varanda Gourmet", "Portaria 24h", "Churrasqueira", "Pet Friendly"),
            hasVirtualTour = true,
            isFavorite = true
        ),
        PropertyListingPropertyModel(
            id = "vr-prop-2",
            code = "VR-83210",
            title = "Casa em condomínio fechado com piscina",
            neighborhood = "Morumbi",
            address = "Rua Três Irmãos, 820",
            price = "R$ 1.650.000",
            condoPrice = "Condomínio R$ 1.200",
            iptuPrice = "IPTU R$ 450",
            areaM2 = 240,
            bedrooms = 4,
            suites = 3,
            bathrooms = 5,
            parkingSpots = 3,
            isSale = true,
            propertyType = "Casa em Condomínio",
            badgeText = "Destaque",
            agencyName = "Lello Imóveis",
            agencyCreci = "CRECI 08721-J",
            amenities = listOf("Piscina privativa", "Espaço Gourmet", "Quintal", "Segurança 24h", "Ar condicionado"),
            hasVirtualTour = true,
            isFavorite = false
        ),
        PropertyListingPropertyModel(
            id = "vr-prop-3",
            code = "VR-72154",
            title = "Apartamento reformado para locação",
            neighborhood = "Perdizes",
            address = "Rua Cardoso de Almeida, 1100",
            price = "R$ 4.200 /mês",
            condoPrice = "Condomínio R$ 620",
            iptuPrice = "IPTU R$ 180",
            areaM2 = 82,
            bedrooms = 3,
            suites = 1,
            bathrooms = 2,
            parkingSpots = 2,
            isSale = false,
            propertyType = "Apartamento",
            badgeText = "Super Destaque",
            agencyName = "Coelho da Fonseca",
            agencyCreci = "CRECI 14205-J",
            amenities = listOf("Armários embutidos", "Salão de festas", "Playground", "Portaria 24h"),
            hasVirtualTour = false,
            isFavorite = true
        ),
        PropertyListingPropertyModel(
            id = "vr-prop-4",
            code = "VR-61048",
            title = "Studio moderno mobiliado próximo ao metrô",
            neighborhood = "Vila Olímpia",
            address = "Rua Funchal, 200",
            price = "R$ 550.000",
            condoPrice = "Condomínio R$ 450",
            iptuPrice = "IPTU R$ 110",
            areaM2 = 36,
            bedrooms = 1,
            suites = 0,
            bathrooms = 1,
            parkingSpots = 1,
            isSale = true,
            propertyType = "Studio",
            badgeText = "Destaque",
            agencyName = "Itambé Imóveis",
            agencyCreci = "CRECI 05120-J",
            amenities = listOf("Mobiliado", "Academia", "Coworking", "Lavanderia compartilhada", "Rooftop"),
            hasVirtualTour = true,
            isFavorite = false
        ),
        PropertyListingPropertyModel(
            id = "vr-prop-5",
            code = "VR-55102",
            title = "Cobertura duplex com vista para o parque",
            neighborhood = "Ibirapuera",
            address = "Avenida República do Líbano, 900",
            price = "R$ 3.800.000",
            condoPrice = "Condomínio R$ 2.800",
            iptuPrice = "IPTU R$ 950",
            areaM2 = 290,
            bedrooms = 4,
            suites = 4,
            bathrooms = 6,
            parkingSpots = 4,
            isSale = true,
            propertyType = "Cobertura",
            badgeText = "Super Destaque",
            agencyName = "Boutique Brokers",
            agencyCreci = "CRECI 22419-J",
            amenities = listOf("Piscina privativa", "Sauna", "Jacuzzi", "Adega", "Depósito privativo", "Segurança armada"),
            hasVirtualTour = true,
            isFavorite = false
        )
    )

    val sampleProperty: PropertyListingPropertyModel = properties[0]
}
