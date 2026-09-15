package br.com.wgc.ds_templates.screens.wellhub.model

import br.com.wgc.design_system.components.cards.WgcWellhubPlanTier

/**
 * Academia ou estúdio parceiro credenciado na rede Wellhub.
 */
data class WellhubGym(
    val id: String,
    val name: String,
    val category: String,
    val address: String,
    val neighborhood: String,
    val distance: String,
    val rating: Double,
    val reviewsCount: String,
    val requiredTier: WgcWellhubPlanTier,
    val amenities: List<String>,
    val openingHours: String
)

/**
 * Plano Corporativo Wellhub (Gympass).
 */
data class WellhubPlan(
    val tier: WgcWellhubPlanTier,
    val monthlyPrice: String,
    val gymCountLabel: String,
    val benefits: List<String>,
    val discountBadge: String? = null
)

/**
 * Registro do Check-In diário Wellhub.
 */
data class WellhubCheckIn(
    val gymName: String,
    val address: String,
    val planTitle: String,
    val tokenCode: String,
    val validUntil: String,
    val isConfirmed: Boolean = true
)

/**
 * Aplicativo de Bem-Estar e Saúde Mental incluso no plano.
 */
data class WellhubWellnessApp(
    val id: String,
    val name: String,
    val category: String,
    val description: String,
    val isActivated: Boolean = false
)

/**
 * Perfil do Colaborador corporativo Wellhub.
 */
data class WellhubUserProfile(
    val name: String,
    val company: String,
    val email: String,
    val currentTier: WgcWellhubPlanTier,
    val checkInsThisMonth: Int,
    val activeStreakDays: Int,
    val todayCheckIn: WellhubCheckIn?
)

/**
 * Dados Mockados realistas para o ecossistema Wellhub (Gympass).
 */
object WellhubMockData {

    val mockGyms = listOf(
        WellhubGym(
            id = "sf-paulista",
            name = "Smart Fit - Paulista Bela Cintra",
            category = "Musculação • Aulas • Aeróbico",
            address = "Av. Paulista, 2064",
            neighborhood = "Consolação",
            distance = "350 m",
            rating = 4.8,
            reviewsCount = "1.8k",
            requiredTier = WgcWellhubPlanTier.BASIC,
            amenities = listOf("Smart Box", "Ar Condicionado", "Wi-Fi"),
            openingHours = "06:00 às 23:00"
        ),
        WellhubGym(
            id = "bioritmo-jardins",
            name = "Bio Ritmo - Jardins",
            category = "Musculação Premium • Natação • Spa",
            address = "Rua Bela Cintra, 2165",
            neighborhood = "Jardins",
            distance = "650 m",
            rating = 4.9,
            reviewsCount = "920",
            requiredTier = WgcWellhubPlanTier.GOLD,
            amenities = listOf("Piscina Semi-olímpica", "Sauna", "Estacionamento Grátis", "Toalhas"),
            openingHours = "06:00 às 22:30"
        ),
        WellhubGym(
            id = "bluefit-augusta",
            name = "Bluefit - Augusta",
            category = "Musculação 24 Horas • Danças",
            address = "Rua Augusta, 1400",
            neighborhood = "Consolação",
            distance = "800 m",
            rating = 4.7,
            reviewsCount = "1.1k",
            requiredTier = WgcWellhubPlanTier.BASIC,
            amenities = listOf("Aberto 24h", "Zumba", "Jump"),
            openingHours = "24 Horas"
        ),
        WellhubGym(
            id = "velocity-itaim",
            name = "Studio Velocity - Itaim",
            category = "Indoor Cycling • Experiência",
            address = "Rua Jerônimo da Veiga, 45",
            neighborhood = "Itaim Bibi",
            distance = "2.4 km",
            rating = 5.0,
            reviewsCount = "680",
            requiredTier = WgcWellhubPlanTier.PLATINUM,
            amenities = listOf("Sapatilhas Inclusas", "Som & Iluminação", "Smoothie Bar"),
            openingHours = "07:00 às 21:00"
        ),
        WellhubGym(
            id = "bodytech-iguatemi",
            name = "Bodytech - Shopping Iguatemi",
            category = "Alta Performance • Wellness • Natação",
            address = "Av. Brig. Faria Lima, 2232",
            neighborhood = "Jardim Paulistano",
            distance = "3.1 km",
            rating = 4.9,
            reviewsCount = "1.5k",
            requiredTier = WgcWellhubPlanTier.DIAMOND,
            amenities = listOf("Piscina Aquecida", "Personal Dedicado", "Spa"),
            openingHours = "06:00 às 23:00"
        )
    )

    val mockPlans = listOf(
        WellhubPlan(
            tier = WgcWellhubPlanTier.STARTER,
            monthlyPrice = "R$ 39,90",
            gymCountLabel = "Acesso a mais de 3.000 academias",
            benefits = listOf("Academias de bairro parceiras", "Aulas online", "1 check-in por dia"),
            discountBadge = "Ideal para começar"
        ),
        WellhubPlan(
            tier = WgcWellhubPlanTier.BASIC,
            monthlyPrice = "R$ 79,90",
            gymCountLabel = "Acesso a mais de 9.000 academias",
            benefits = listOf("Smart Fit e Bluefit inclusas", "Aulas coletivas e dança", "1 check-in diário"),
            discountBadge = "Mais popular"
        ),
        WellhubPlan(
            tier = WgcWellhubPlanTier.SILVER,
            monthlyPrice = "R$ 109,90",
            gymCountLabel = "Acesso a mais de 12.000 academias",
            benefits = listOf("Redes adicionais e estúdios de Cross", "Natação em unidades credenciadas", "Apps de nutrição"),
            discountBadge = "Melhor custo-benefício"
        ),
        WellhubPlan(
            tier = WgcWellhubPlanTier.GOLD,
            monthlyPrice = "R$ 149,90",
            gymCountLabel = "Acesso a mais de 16.000 academias",
            benefits = listOf("Bio Ritmo e estúdios premium", "Pilates em aparelhos e Natação", "Calm e Headspace inclusos"),
            discountBadge = "Seu plano atual"
        ),
        WellhubPlan(
            tier = WgcWellhubPlanTier.PLATINUM,
            monthlyPrice = "R$ 259,90",
            gymCountLabel = "Acesso a estúdios boutique selecionados",
            benefits = listOf("Studio Velocity, Race Bootcamp e Kore", "Sessões com nutricionista online", "Acesso ilimitado"),
            discountBadge = "Boutique & Premium"
        )
    )

    val mockWellnessApps = listOf(
        WellhubWellnessApp(
            id = "app1",
            name = "Calm",
            category = "Meditação & Sono",
            description = "Mais de 500 meditações guiadas, histórias para dormir e paisagens sonoras relaxantes.",
            isActivated = true
        ),
        WellhubWellnessApp(
            id = "app2",
            name = "Headspace",
            category = "Atenção Plena & Mindfulness",
            description = "Ferramentas práticas para reduzir a ansiedade diária e melhorar o foco no trabalho.",
            isActivated = true
        ),
        WellhubWellnessApp(
            id = "app3",
            name = "Lifesum",
            category = "Nutrição & Dieta Saudável",
            description = "Planejador de refeições, contador de macronutrientes e receitas nutritivas para seu objetivo.",
            isActivated = false
        ),
        WellhubWellnessApp(
            id = "app4",
            name = "Asana Rebel",
            category = "Yoga & Funcional em Casa",
            description = "Combinação de yoga dinâmico e treinos funcionais para flexibilidade e perda de peso.",
            isActivated = false
        )
    )

    val mockUser = WellhubUserProfile(
        name = "Gabriel do Carmo",
        company = "Tech Corporation Brasil",
        email = "gabriel.carmo@techcorp.com",
        currentTier = WgcWellhubPlanTier.GOLD,
        checkInsThisMonth = 16,
        activeStreakDays = 4,
        todayCheckIn = WellhubCheckIn(
            gymName = "Bio Ritmo - Jardins",
            address = "Rua Bela Cintra, 2165",
            planTitle = "Plano Gold",
            tokenCode = "WH-84920",
            validUntil = "23:59 de hoje",
            isConfirmed = true
        )
    )
}
