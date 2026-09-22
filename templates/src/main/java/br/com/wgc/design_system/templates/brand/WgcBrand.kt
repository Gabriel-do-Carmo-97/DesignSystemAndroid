package br.com.wgc.design_system.templates.brand

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors

/**
 * Domínios e arquétipos suportados pelo ecossistema de templates do WGC Design System (100% White-label).
 * Vinculados diretamente aos tokens de design oficiais de [:core].
 */
enum class WgcBrand(
    val brandName: String,
    val brandLogoText: String,
    val primaryColor: Color
) {
    FoodDelivery("Food Delivery", "FD", Color(WgcCoreDsColors.foodDeliveryRed)),
    RideHailing("Ride Hailing", "RH", Color(WgcCoreDsColors.rideHailingBlack)),
    Marketplace("Marketplace", "MP", Color(WgcCoreDsColors.marketplaceYellow)),
    QuickFoodDelivery("Quick Food Delivery", "QD", Color(WgcCoreDsColors.orange500)),
    DealMarketplace("Deal Marketplace", "DM", Color(WgcCoreDsColors.dealMarketplaceOrange)),
    GlobalMarketplace("Global Marketplace", "GM", Color(WgcCoreDsColors.globalMarketplaceRed)),
    ClockAuth("Time Tracking", "TT", Color(WgcCoreDsColors.warning)),
    WaveAuth("Wave Auth", "WA", Color(WgcCoreDsColors.blue500)),
    SplitAuth("Split Card", "SC", Color(WgcCoreDsColors.personalFinanceTransferBlue)),
    TrendFashion("Trend Fashion", "TF", Color(WgcCoreDsColors.trendFashionPink)),
    MegaStore("Mega Store", "MS", Color(WgcCoreDsColors.megaStorePrimary)),
    Retail("Retail Store", "RT", Color(WgcCoreDsColors.retailPrimary)),
    Apparel("Apparel Fashion", "AP", Color(WgcCoreDsColors.apparelPrimary)),
    Boutique("Boutique Fashion", "BF", Color(WgcCoreDsColors.boutiquePrimary)),
    CuratedMarket("Curated Market", "CM", Color(WgcCoreDsColors.curatedMarketPrimary)),
    FreshGrocery("Fresh Grocery", "FG", Color(WgcCoreDsColors.megaStorerPrimary)),
    GadgetShop("Gadget Shop", "GS", Color(WgcCoreDsColors.gadgetShopPrimary)),
    QuickShop("Quick Shop", "QS", Color(WgcCoreDsColors.quickShopPrimary)),
    PersonalFinance("Personal Finance", "PF", Color(WgcCoreDsColors.personalFinancePrimary)),
    PropertyRental("Property Rental", "PR", Color(WgcCoreDsColors.propertyRentalPrimary)),
    PropertyListing("Property Listing", "PL", Color(WgcCoreDsColors.propertyListingPrimary)),
    PropertyClassifieds("Property Classifieds", "PC", Color(WgcCoreDsColors.propertyClassifiedsPrimary)),
    GymFitness("Gym & Fitness", "GF", Color(WgcCoreDsColors.gymYellow)),
    CorporateWellness("Corporate Wellness", "CW", Color(WgcCoreDsColors.wellnessCoral)),
    GuidedTraining("Guided Training", "GT", Color(WgcCoreDsColors.trainingVolt)),
    Hypermarket("Hypermarket", "HM", Color(WgcCoreDsColors.hypermarketRed)),
    PremiumGrocery("Premium Grocery", "PG", Color(WgcCoreDsColors.premiumGroceryGreen)),
    Grocery("Grocery & Supermarket", "GR", Color(WgcCoreDsColors.groceryBlue)),
    PharmacyChain("Pharmacy Chain", "PC", Color(WgcCoreDsColors.pharmacyChainRed)),
    CarePharmacy("Care Pharmacy", "CP", Color(WgcCoreDsColors.carePharmacyRed)),
    PopularPharmacy("Popular Pharmacy", "PP", Color(WgcCoreDsColors.popularPharmacyGreen)),
    FintechNeobank("Fintech Neobank", "FN", Color(WgcCoreDsColors.fintechPurple)),
    FintechSuperApp("Fintech SuperApp", "SA", Color(WgcCoreDsColors.fintechOrange)),
    FintechCarbon("Fintech Carbon", "FC", Color(WgcCoreDsColors.fintechCarbon)),

    // Mobilidade & Viagem
    UrbanMobility("Urban Mobility", "UM", Color(WgcCoreDsColors.urbanMobilityYellow)),
    BiddingRides("Bidding Rides", "BR", Color(WgcCoreDsColors.biddingRidesGreen)),
    BusTravel("Bus Travel", "BT", Color(WgcCoreDsColors.busTravelBlue)),
    FlightTravel("Flight Travel", "FT", Color(WgcCoreDsColors.flightTravelRed)),
    HospitalityLodging("Hospitality & Lodging", "HL", Color(WgcCoreDsColors.lodgingCoral)),
    HotelBooking("Hotel Booking", "HB", Color(WgcCoreDsColors.hotelBookingNavy)),

    // Streaming
    VideoStream("VideoStreaming", "VS", Color(WgcCoreDsColors.videoStreamingRed)),
    AudioStream("AudioStreaming", "AS", Color(WgcCoreDsColors.audioStreamingGreen)),
    BroadcastStreaming("Broadcast Streaming", "BS", Color(WgcCoreDsColors.broadcastStreamingSalmon)),

    // Educação
    LanguageLearning("Language Learning", "LL", Color(WgcCoreDsColors.languageLearningGreen)),
    TechEducation("Tech Education", "TE", Color(WgcCoreDsColors.techEducationBlue)),
    CourseMarketplace("Course Marketplace", "CM", Color(WgcCoreDsColors.courseMarketplacePurple)),

    // Social & Comunicação
    DirectMessaging("Direct Messaging", "DM", Color(WgcCoreDsColors.directMessagingGreen)),
    ChannelMessaging("Channel Messaging", "CM", Color(WgcCoreDsColors.channelMessagingBlue)),
    VisualDiscovery("Visual Discovery", "VD", Color(WgcCoreDsColors.visualDiscoveryRed)),

    // Games
    GamingStore("Gaming Store", "GS", Color(WgcCoreDsColors.gamingStoreNavy)),
    LiveStreaming("Live Streaming", "LS", Color(WgcCoreDsColors.liveStreamingPurple)),
    CommunityChat("Community Chat", "CC", Color(WgcCoreDsColors.communityChatBlurple)),

    // Produtividade
    WorkspaceDocs("Workspace Docs", "WD", Color(WgcCoreDsColors.workspaceDocsDark)),
    KanbanTasks("Kanban Tasks", "KT", Color(WgcCoreDsColors.kanbanTasksBlue)),
    TeamCollaboration("Team Collaboration", "TC", Color(WgcCoreDsColors.teamCollaborationAubergine)),

    // Fast Food & Delivery
    BurgerFastFood("Burger Fast Food", "BF", Color(WgcCoreDsColors.burgerFastFoodYellow)),
    FlameFastFood("Flame Fast Food", "FF", Color(WgcCoreDsColors.flameFastFoodFlame)),
    PizzaDelivery("Pizza Delivery", "PD", Color(WgcCoreDsColors.pizzaBlue)),

    // Logística
    Carpooling("Carpooling", "CP", Color(WgcCoreDsColors.carpoolingBlue)),
    ExpressLogistics("Express Logistics", "EL", Color(WgcCoreDsColors.expressLogisticsBlue)),
    FreightLogistics("Freight Logistics", "FL", Color(WgcCoreDsColors.freightLogisticsOrange)),

    // Vestuário & Beleza
    DepartmentFashion("Department Fashion", "DF", Color(WgcCoreDsColors.departmentFashionRed)),
    UrbanFashion("Urban Fashion", "UF", Color(WgcCoreDsColors.urbanFashionBlue)),
    TrendApparel("Trend Apparel", "TA", Color(WgcCoreDsColors.trendApparelGreen)),
    FragranceBeauty("Fragrance & Beauty", "FB", Color(WgcCoreDsColors.fragranceBeautyGreen)),
    NaturalBeauty("Natural Beauty", "NB", Color(WgcCoreDsColors.naturalBeautyOrange)),
    PrestigeBeauty("Prestige Beauty", "PB", Color(WgcCoreDsColors.prestigeBeautyBlack)),

    // Pet Shop
    PetCare("Pet Care", "PC", Color(WgcCoreDsColors.petCareYellow)),
    PetSuperstore("Pet Superstore", "PS", Color(WgcCoreDsColors.petSuperstoreBlue)),
    PetLifestyle("Pet Lifestyle", "PL", Color(WgcCoreDsColors.petLifestyleSkull)),

    // Casa & Decoração
    HomeImprovement("Home Improvement", "HI", Color(WgcCoreDsColors.leroyGreen)),
    DesignerFurniture("Designer Furniture", "DF", Color(WgcCoreDsColors.designerFurnitureYellow)),
    HomeMarketplace("Home Marketplace", "HM", Color(WgcCoreDsColors.madeiraOrange)),

    // Notícias & Informação
    DailyNews("Daily News", "DN", Color(WgcCoreDsColors.dailyNewsRed)),
    MediaNetwork("Media Network", "MN", Color(WgcCoreDsColors.mediaNetworkOrange)),
    BusinessNews("Business News", "BN", Color(WgcCoreDsColors.businessNewsBlue)),

    // Serviços Cívicos / Governo
    CitizenServices("Citizen Services", "CS", Color(WgcCoreDsColors.govBlue)),
    TransitDigital("Transit Digital", "TD", Color(WgcCoreDsColors.transitDigitalGreen)),
    EmploymentRecord("Employment Record", "ER", Color(WgcCoreDsColors.employmentRecordBlue)),

    // Especialidades Médicas & Verticais
    Dental("Dental Clinic", "DC", Color(WgcCoreDsColors.dentalTeal)),
    Telemedicine("Telemedicine", "TM", Color(WgcCoreDsColors.telemedicineGreen)),
    BeverageDelivery("Beverage Delivery", "BD", Color(WgcCoreDsColors.beverageDeliveryYellow)),
    Automotive("Automotive Marketplace", "AM", Color(WgcCoreDsColors.automotiveRed)),
    Hardware("Hardware & Tech", "HW", Color(WgcCoreDsColors.hardwareOrange))
}
