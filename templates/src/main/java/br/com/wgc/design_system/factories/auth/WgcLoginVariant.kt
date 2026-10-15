package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.templates.brand.WgcBrand

/**
 * Variantes da Tela de Login suportadas pelo WGC Design System.
 */
enum class WgcLoginVariant(
    val displayName: String,
    val logoText: String = "DS",
    val primaryColor: Color = Color(WgcCoreDsColors.primary),
    val associatedBrand: WgcBrand? = null
) {
    STANDARD("Padrão", "DS", Color(WgcCoreDsColors.primary)),
    BIOMETRIC("Biometria", "BIO", Color(WgcCoreDsColors.primary)),
    SPLIT_CARD("Split Card", "SC", Color(WgcCoreDsColors.personalFinanceTransferBlue), WgcBrand.SplitAuth),
    WAVE("Wave", "WA", Color(WgcCoreDsColors.blue500), WgcBrand.WaveAuth),
    CLOCK("Clock", "TT", Color(WgcCoreDsColors.warning), WgcBrand.ClockAuth),
    FOOD_DELIVERY("Food Delivery", "FD", Color(WgcCoreDsColors.foodDeliveryRed), WgcBrand.FoodDelivery),
    RIDE_HAILING("Ride Hailing", "RH", Color(WgcCoreDsColors.rideHailingBlack), WgcBrand.RideHailing),
    MARKETPLACE("Marketplace", "MP", Color(WgcCoreDsColors.marketplaceYellow), WgcBrand.Marketplace),
    QUICK_FOOD_DELIVERY("Quick Food", "QD", Color(WgcCoreDsColors.orange500), WgcBrand.QuickFoodDelivery),
    DEAL_MARKETPLACE("Deal Marketplace", "DM", Color(WgcCoreDsColors.dealMarketplaceOrange), WgcBrand.DealMarketplace),
    GLOBAL_MARKETPLACE("Global Marketplace", "GM", Color(WgcCoreDsColors.globalMarketplaceRed), WgcBrand.GlobalMarketplace),
    TREND_FASHION("Trend Fashion", "TF", Color(WgcCoreDsColors.trendFashionPink), WgcBrand.TrendFashion),
    GYM_FITNESS("Gym & Fitness", "GF", Color(WgcCoreDsColors.gymYellow), WgcBrand.GymFitness),
    TELEMEDICINE("Telemedicine", "TM", Color(WgcCoreDsColors.telemedicineGreen), WgcBrand.Telemedicine),
    DENTAL("Dental Clinic", "DC", Color(WgcCoreDsColors.dentalTeal), WgcBrand.Dental),
    FINTECH_NEOBANK("Fintech Neobank", "FN", Color(WgcCoreDsColors.fintechPurple), WgcBrand.FintechNeobank),
    FINTECH_SUPER_APP("Fintech SuperApp", "SA", Color(WgcCoreDsColors.fintechOrange), WgcBrand.FintechSuperApp),
    FINTECH_CARBON("Fintech Carbon", "FC", Color(WgcCoreDsColors.fintechCarbon), WgcBrand.FintechCarbon),
    PHARMACY_CHAIN("Pharmacy Chain", "PC", Color(WgcCoreDsColors.pharmacyChainRed), WgcBrand.PharmacyChain),
    CARE_PHARMACY("Care Pharmacy", "CP", Color(WgcCoreDsColors.carePharmacyRed), WgcBrand.CarePharmacy),
    POPULAR_PHARMACY("Popular Pharmacy", "PP", Color(WgcCoreDsColors.popularPharmacyGreen), WgcBrand.PopularPharmacy),
    FRESH_GROCERY("Fresh Grocery", "FG", Color(WgcCoreDsColors.megaStorerPrimary), WgcBrand.FreshGrocery),
    HYPERMARKET("Hypermarket", "HM", Color(WgcCoreDsColors.hypermarketRed), WgcBrand.Hypermarket),
    PREMIUM_GROCERY("Premium Grocery", "PG", Color(WgcCoreDsColors.premiumGroceryGreen), WgcBrand.PremiumGrocery),
    GROCERY("Grocery", "GR", Color(WgcCoreDsColors.groceryBlue), WgcBrand.Grocery),
    PET_CARE("Pet Care", "PC", Color(WgcCoreDsColors.petCareYellow), WgcBrand.PetCare),
    PET_SUPERSTORE("Pet Superstore", "PS", Color(WgcCoreDsColors.petSuperstoreBlue), WgcBrand.PetSuperstore),
    PET_LIFESTYLE("Pet Lifestyle", "PL", Color(WgcCoreDsColors.petLifestyleSkull), WgcBrand.PetLifestyle),
    BURGER_FAST_FOOD("Burger Fast Food", "BF", Color(WgcCoreDsColors.burgerFastFoodYellow), WgcBrand.BurgerFastFood),
    FLAME_FAST_FOOD("Flame Fast Food", "FF", Color(WgcCoreDsColors.flameFastFoodFlame), WgcBrand.FlameFastFood),
    PIZZA_DELIVERY("Pizza Delivery", "PD", Color(WgcCoreDsColors.pizzaBlue), WgcBrand.PizzaDelivery),
    URBAN_MOBILITY("Urban Mobility", "UM", Color(WgcCoreDsColors.urbanMobilityYellow), WgcBrand.UrbanMobility),
    BIDDING_RIDES("Bidding Rides", "BR", Color(WgcCoreDsColors.biddingRidesGreen), WgcBrand.BiddingRides),
    BUS_TRAVEL("Bus Travel", "BT", Color(WgcCoreDsColors.busTravelBlue), WgcBrand.BusTravel),
    FLIGHT_TRAVEL("Flight Travel", "FT", Color(WgcCoreDsColors.flightTravelRed), WgcBrand.FlightTravel),
    HOTEL_BOOKING("Hotel Booking", "HB", Color(WgcCoreDsColors.hotelBookingNavy), WgcBrand.HotelBooking),
    VIDEO_STREAM("Video Streaming", "VS", Color(WgcCoreDsColors.videoStreamingRed), WgcBrand.VideoStream),
    AUDIO_STREAM("Audio Streaming", "AS", Color(WgcCoreDsColors.audioStreamingGreen), WgcBrand.AudioStream),
    LANGUAGE_LEARNING("Language Learning", "LL", Color(WgcCoreDsColors.languageLearningGreen), WgcBrand.LanguageLearning),
    TECH_EDUCATION("Tech Education", "TE", Color(WgcCoreDsColors.techEducationBlue), WgcBrand.TechEducation),
    WORKSPACE_DOCS("Workspace Docs", "WD", Color(WgcCoreDsColors.workspaceDocsDark), WgcBrand.WorkspaceDocs),
    KANBAN_TASKS("Kanban Tasks", "KT", Color(WgcCoreDsColors.kanbanTasksBlue), WgcBrand.KanbanTasks),
    EXPRESS_LOGISTICS("Express Logistics", "EL", Color(WgcCoreDsColors.expressLogisticsBlue), WgcBrand.ExpressLogistics),
    DEPARTMENT_FASHION("Department Fashion", "DF", Color(WgcCoreDsColors.departmentFashionRed), WgcBrand.DepartmentFashion),
    HOME_IMPROVEMENT("Home Improvement", "HI", Color(WgcCoreDsColors.leroyGreen), WgcBrand.HomeImprovement),
    DAILY_NEWS("Daily News", "DN", Color(WgcCoreDsColors.dailyNewsRed), WgcBrand.DailyNews),
    CITIZEN_SERVICES("Citizen Services", "CS", Color(WgcCoreDsColors.govBlue), WgcBrand.CitizenServices),
    BEVERAGE_DELIVERY("Beverage Delivery", "BD", Color(WgcCoreDsColors.beverageDeliveryYellow), WgcBrand.BeverageDelivery),
    AUTOMOTIVE("Automotive", "AM", Color(WgcCoreDsColors.automotiveRed), WgcBrand.Automotive),
    HARDWARE("Hardware", "HW", Color(WgcCoreDsColors.hardwareOrange), WgcBrand.Hardware);
}
