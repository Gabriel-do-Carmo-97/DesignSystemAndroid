package br.com.wgc.ds_templates.brand

import androidx.compose.ui.graphics.Color

/**
 * Domínios e arquétipos suportados pelo ecossistema de templates do WGC Design System (100% White-label).
 */
enum class WgcBrand(
    val brandName: String,
    val brandLogoText: String,
    val primaryColor: Color
) {
    FoodDelivery("Food Delivery", "FD", Color(0xFFEA1D2C)),
    RideHailing("Ride Hailing", "RH", Color(0xFF000000)),
    Marketplace("Marketplace", "MP", Color(0xFFFFE600)),
    QuickFoodDelivery("Quick Food Delivery", "QD", Color(0xFFFF5722)),
    DealMarketplace("Deal Marketplace", "DM", Color(0xFFEE4D2D)),
    GlobalMarketplace("Global Marketplace", "GM", Color(0xFFFF4747)),
    ClockAuth("Time Tracking", "TT", Color(0xFFFF9800)),
    WaveAuth("Wave Auth", "WA", Color(0xFF1976D2)),
    SplitAuth("Split Card", "SC", Color(0xFF0288D1)),
    TrendFashion("Trend Fashion", "TF", Color(0xFFF83758)),
    MegaStore("Mega Store", "MS", Color(0xFF004CFF)),
    Retail("Retail Store", "RT", Color(0xFF514EB7)),
    Apparel("Apparel Fashion", "AP", Color(0xFF8E6CEF)),
    Boutique("Boutique Fashion", "BF", Color(0xFF9775FA)),
    CuratedMarket("Curated Market", "CM", Color(0xFF4D38DC)),
    FreshGrocery("Fresh Grocery", "FG", Color(0xFF00966B)),
    GadgetShop("Gadget Shop", "GS", Color(0xFF2D60FF)),
    QuickShop("Quick Shop", "QS", Color(0xFFFF8C42)),
    PersonalFinance("Personal Finance", "PF", Color(0xFF2ECC71)),
    PropertyRental("Property Rental", "PR", Color(0xFF1C2A44)),
    PropertyListing("Property Listing", "PL", Color(0xFF1C9963)),
    PropertyClassifieds("Property Classifieds", "PC", Color(0xFF002F6C)),
    GymFitness("Gym & Fitness", "GF", Color(0xFFFFB800)),
    CorporateWellness("Corporate Wellness", "CW", Color(0xFFFF4338)),
    GuidedTraining("Guided Training", "GT", Color(0xFFD0FF00)),
    Hypermarket("Hypermarket", "HM", Color(0xFFE30613)),
    PremiumGrocery("Premium Grocery", "PG", Color(0xFF006837)),
    Grocery("Grocery & Supermarket", "GR", Color(0xFF00387B)),
    PharmacyChain("Pharmacy Chain", "PC", Color(0xFFC8102E)),
    CarePharmacy("Care Pharmacy", "CP", Color(0xFFE30613)),
    PopularPharmacy("Popular Pharmacy", "PP", Color(0xFF00A859)),
    FintechNeobank("Fintech Neobank", "FN", Color(0xFF820AD1)),
    FintechSuperApp("Fintech SuperApp", "SA", Color(0xFFFF7A00)),
    FintechCarbon("Fintech Carbon", "FC", Color(0xFF242424)),

    // Mobilidade & Viagem
    UrbanMobility("Urban Mobility", "UM", Color(0xFFFFC800)),
    BiddingRides("Bidding Rides", "BR", Color(0xFF29B75F)),
    BusTravel("Bus Travel", "BT", Color(0xFF0054A6)),
    FlightTravel("Flight Travel", "FT", Color(0xFFE6004C)),
    HospitalityLodging("Hospitality & Lodging", "HL", Color(0xFFFF5A5F)),
    HotelBooking("Hotel Booking", "HB", Color(0xFF003580)),

    // Streaming
    VideoStream("VideoStreaming", "VS", Color(0xFFE50914)),
    AudioStream("AudioStreaming", "AS", Color(0xFF1DB954)),
    BroadcastStreaming("Broadcast Streaming", "BS", Color(0xFFFF5028)),

    // Educação
    LanguageLearning("Language Learning", "LL", Color(0xFF58CC02)),
    TechEducation("Tech Education", "TE", Color(0xFF0070F3)),
    CourseMarketplace("Course Marketplace", "CM", Color(0xFFA435F0)),

    // Social & Comunicação
    DirectMessaging("Direct Messaging", "DM", Color(0xFF25D366)),
    ChannelMessaging("Channel Messaging", "CM", Color(0xFF24A1DE)),
    VisualDiscovery("Visual Discovery", "VD", Color(0xFFE60023)),

    // Games
    GamingStore("Gaming Store", "GS", Color(0xFF171A21)),
    LiveStreaming("Live Streaming", "LS", Color(0xFF9146FF)),
    CommunityChat("Community Chat", "CC", Color(0xFF5865F2)),

    // Produtividade
    WorkspaceDocs("Workspace Docs", "WD", Color(0xFF2F3437)),
    KanbanTasks("Kanban Tasks", "KT", Color(0xFF0079BF)),
    TeamCollaboration("Team Collaboration", "TC", Color(0xFF4A154B)),

    // Fast Food & Delivery
    BurgerFastFood("Burger Fast Food", "BF", Color(0xFFFFBC0D)),
    FlameFastFood("Flame Fast Food", "FF", Color(0xFFD62300)),
    PizzaDelivery("Pizza Delivery", "PD", Color(0xFF006491)),

    // Logística
    Carpooling("Carpooling", "CP", Color(0xFF00AFF5)),
    ExpressLogistics("Express Logistics", "EL", Color(0xFF0073FF)),
    FreightLogistics("Freight Logistics", "FL", Color(0xFFFF6600)),

    // Vestuário & Beleza
    DepartmentFashion("Department Fashion", "DF", Color(0xFFC8102E)),
    UrbanFashion("Urban Fashion", "UF", Color(0xFF003882)),
    TrendApparel("Trend Apparel", "TA", Color(0xFF00965E)),
    FragranceBeauty("Fragrance & Beauty", "FB", Color(0xFF00573D)),
    NaturalBeauty("Natural Beauty", "NB", Color(0xFFFF6A13)),
    PrestigeBeauty("Prestige Beauty", "PB", Color(0xFF000000)),

    // Pet Shop
    PetCare("Pet Care", "PC", Color(0xFFFED100)),
    PetSuperstore("Pet Superstore", "PS", Color(0xFF0071CE)),
    PetLifestyle("Pet Lifestyle", "PL", Color(0xFF111111)),

    // Casa & Decoração
    HomeImprovement("Home Improvement", "HI", Color(0xFF78BE20)),
    DesignerFurniture("Designer Furniture", "DF", Color(0xFFFFCC00)),
    HomeMarketplace("Home Marketplace", "HM", Color(0xFFFF5C00)),

    // Notícias & Informação
    DailyNews("Daily News", "DN", Color(0xFFC4170C)),
    MediaNetwork("Media Network", "MN", Color(0xFFFF6600)),
    BusinessNews("Business News", "BN", Color(0xFF003F7F)),

    // Serviços Cívicos / Governo
    CitizenServices("Citizen Services", "CS", Color(0xFF003399)),
    TransitDigital("Transit Digital", "TD", Color(0xFF008037)),
    EmploymentRecord("Employment Record", "ER", Color(0xFF005CA9)),

    // Especialidades Médicas & Verticais
    Dental("Dental Clinic", "DC", Color(0xFF00A8B5)),
    Telemedicine("Telemedicine", "TM", Color(0xFF00B39B)),
    BeverageDelivery("Beverage Delivery", "BD", Color(0xFFFFCC00)),
    Automotive("Automotive Marketplace", "AM", Color(0xFFE6192E)),
    Hardware("Hardware & Tech", "HW", Color(0xFFFF6500))
}
