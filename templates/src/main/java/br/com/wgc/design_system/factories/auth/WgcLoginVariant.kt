package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors

/**
 * Variantes da Tela de Login suportadas pelo WGC Design System.
 */
enum class WgcLoginVariant(
    val displayName: String,
    val logoText: String = "DS",
    val primaryColor: Color = Color(WgcCoreDsColors.primary)
) {
    STANDARD("PadrÃ£o", "DS", Color(WgcCoreDsColors.primary)),
    BIOMETRIC("Biometria", "BIO", Color(WgcCoreDsColors.primary)),
    SPLIT_CARD("Split Card", "SC", Color(WgcCoreDsColors.personalFinanceTransferBlue)),
    WAVE("Wave", "WA", Color(WgcCoreDsColors.blue500)),
    CLOCK("Clock", "TT", Color(WgcCoreDsColors.warning)),
    FOOD_DELIVERY("Food Delivery", "FD", Color(WgcCoreDsColors.foodDeliveryRed)),
    RIDE_HAILING("Ride Hailing", "RH", Color(WgcCoreDsColors.rideHailingBlack)),
    MARKETPLACE("Marketplace", "MP", Color(WgcCoreDsColors.marketplaceYellow)),
    QUICK_FOOD_DELIVERY("Quick Food", "QD", Color(WgcCoreDsColors.orange500)),
    DEAL_MARKETPLACE("Deal Marketplace", "DM", Color(WgcCoreDsColors.dealMarketplaceOrange)),
    GLOBAL_MARKETPLACE("Global Marketplace", "GM", Color(WgcCoreDsColors.globalMarketplaceRed)),
    TREND_FASHION("Trend Fashion", "TF", Color(WgcCoreDsColors.trendFashionPink)),
    GYM_FITNESS("Gym & Fitness", "GF", Color(WgcCoreDsColors.gymYellow)),
    TELEMEDICINE("Telemedicine", "TM", Color(WgcCoreDsColors.telemedicineGreen)),
    DENTAL("Dental Clinic", "DC", Color(WgcCoreDsColors.dentalTeal)),
    FINTECH_NEOBANK("Fintech Neobank", "FN", Color(WgcCoreDsColors.fintechPurple)),
    FINTECH_SUPER_APP("Fintech SuperApp", "SA", Color(WgcCoreDsColors.fintechOrange)),
    FINTECH_CARBON("Fintech Carbon", "FC", Color(WgcCoreDsColors.fintechCarbon)),
    PHARMACY_CHAIN("Pharmacy Chain", "PC", Color(WgcCoreDsColors.pharmacyChainRed)),
    CARE_PHARMACY("Care Pharmacy", "CP", Color(WgcCoreDsColors.carePharmacyRed)),
    POPULAR_PHARMACY("Popular Pharmacy", "PP", Color(WgcCoreDsColors.popularPharmacyGreen)),
    FRESH_GROCERY("Fresh Grocery", "FG", Color(WgcCoreDsColors.megaStorerPrimary)),
    HYPERMARKET("Hypermarket", "HM", Color(WgcCoreDsColors.hypermarketRed)),
    PREMIUM_GROCERY("Premium Grocery", "PG", Color(WgcCoreDsColors.premiumGroceryGreen)),
    GROCERY("Grocery", "GR", Color(WgcCoreDsColors.groceryBlue)),
    PET_CARE("Pet Care", "PC", Color(WgcCoreDsColors.petCareYellow)),
    PET_SUPERSTORE("Pet Superstore", "PS", Color(WgcCoreDsColors.petSuperstoreBlue)),
    PET_LIFESTYLE("Pet Lifestyle", "PL", Color(WgcCoreDsColors.petLifestyleSkull)),
    BURGER_FAST_FOOD("Burger Fast Food", "BF", Color(WgcCoreDsColors.burgerFastFoodYellow)),
    FLAME_FAST_FOOD("Flame Fast Food", "FF", Color(WgcCoreDsColors.flameFastFoodFlame)),
    PIZZA_DELIVERY("Pizza Delivery", "PD", Color(WgcCoreDsColors.pizzaBlue)),
    URBAN_MOBILITY("Urban Mobility", "UM", Color(WgcCoreDsColors.urbanMobilityYellow)),
    BIDDING_RIDES("Bidding Rides", "BR", Color(WgcCoreDsColors.biddingRidesGreen)),
    BUS_TRAVEL("Bus Travel", "BT", Color(WgcCoreDsColors.busTravelBlue)),
    FLIGHT_TRAVEL("Flight Travel", "FT", Color(WgcCoreDsColors.flightTravelRed)),
    HOTEL_BOOKING("Hotel Booking", "HB", Color(WgcCoreDsColors.hotelBookingNavy)),
    VIDEO_STREAM("Video Streaming", "VS", Color(WgcCoreDsColors.videoStreamingRed)),
    AUDIO_STREAM("Audio Streaming", "AS", Color(WgcCoreDsColors.audioStreamingGreen)),
    LANGUAGE_LEARNING("Language Learning", "LL", Color(WgcCoreDsColors.languageLearningGreen)),
    TECH_EDUCATION("Tech Education", "TE", Color(WgcCoreDsColors.techEducationBlue)),
    WORKSPACE_DOCS("Workspace Docs", "WD", Color(WgcCoreDsColors.workspaceDocsDark)),
    KANBAN_TASKS("Kanban Tasks", "KT", Color(WgcCoreDsColors.kanbanTasksBlue)),
    EXPRESS_LOGISTICS("Express Logistics", "EL", Color(WgcCoreDsColors.expressLogisticsBlue)),
    DEPARTMENT_FASHION("Department Fashion", "DF", Color(WgcCoreDsColors.departmentFashionRed)),
    HOME_IMPROVEMENT("Home Improvement", "HI", Color(WgcCoreDsColors.leroyGreen)),
    DAILY_NEWS("Daily News", "DN", Color(WgcCoreDsColors.dailyNewsRed)),
    CITIZEN_SERVICES("Citizen Services", "CS", Color(WgcCoreDsColors.govBlue)),
    BEVERAGE_DELIVERY("Beverage Delivery", "BD", Color(WgcCoreDsColors.beverageDeliveryYellow)),
    AUTOMOTIVE("Automotive", "AM", Color(WgcCoreDsColors.automotiveRed)),
    HARDWARE("Hardware", "HW", Color(WgcCoreDsColors.hardwareOrange));
}
