package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors

/**
 * Variantes da Tela de Login suportadas pelo WGC Design System.
 */
enum class WgcLoginVariant(
    val displayName: String,
    val logoText: String = "DS",
    val primaryColor: Color = Color(WgcCoreDsColors.orange500)
) {
    STANDARD("PadrÃ£o", "DS", Color(WgcCoreDsColors.orange500)),
    BIOMETRIC("Biometria", "BIO", Color(WgcCoreDsColors.orange500)),
    SPLIT_CARD("Split Card", "SC", Color(WgcCoreDsColors.blue36)),
    WAVE("Wave", "WA", Color(WgcCoreDsColors.blue500)),
    CLOCK("Clock", "TT", Color(WgcCoreDsColors.yellow10)),
    FOOD_DELIVERY("Food Delivery", "FD", Color(WgcCoreDsColors.red18)),
    RIDE_HAILING("Ride Hailing", "RH", Color(WgcCoreDsColors.grayDark3)),
    MARKETPLACE("Marketplace", "MP", Color(WgcCoreDsColors.yellow8)),
    QUICK_FOOD_DELIVERY("Quick Food", "QD", Color(WgcCoreDsColors.orange500)),
    DEAL_MARKETPLACE("Deal Marketplace", "DM", Color(WgcCoreDsColors.red21)),
    GLOBAL_MARKETPLACE("Global Marketplace", "GM", Color(WgcCoreDsColors.red27)),
    TREND_FASHION("Trend Fashion", "TF", Color(WgcCoreDsColors.pink4)),
    GYM_FITNESS("Gym & Fitness", "GF", Color(WgcCoreDsColors.orange23)),
    TELEMEDICINE("Telemedicine", "TM", Color(WgcCoreDsColors.cyan4)),
    DENTAL("Dental Clinic", "DC", Color(WgcCoreDsColors.cyan5)),
    FINTECH_NEOBANK("Fintech Neobank", "FN", Color(WgcCoreDsColors.purple3)),
    FINTECH_SUPER_APP("Fintech SuperApp", "SA", Color(WgcCoreDsColors.orange20)),
    FINTECH_CARBON("Fintech Carbon", "FC", Color(WgcCoreDsColors.grayDark16)),
    PHARMACY_CHAIN("Pharmacy Chain", "PC", Color(WgcCoreDsColors.red8)),
    CARE_PHARMACY("Care Pharmacy", "CP", Color(WgcCoreDsColors.red12)),
    POPULAR_PHARMACY("Popular Pharmacy", "PP", Color(WgcCoreDsColors.green10)),
    FRESH_GROCERY("Fresh Grocery", "FG", Color(WgcCoreDsColors.green6)),
    HYPERMARKET("Hypermarket", "HM", Color(WgcCoreDsColors.red12)),
    PREMIUM_GROCERY("Premium Grocery", "PG", Color(WgcCoreDsColors.greenDark7)),
    GROCERY("Grocery", "GR", Color(WgcCoreDsColors.blueDark32)),
    PET_CARE("Pet Care", "PC", Color(WgcCoreDsColors.yellow2)),
    PET_SUPERSTORE("Pet Superstore", "PS", Color(WgcCoreDsColors.blue18)),
    PET_LIFESTYLE("Pet Lifestyle", "PL", Color(WgcCoreDsColors.grayDark3)),
    BURGER_FAST_FOOD("Burger Fast Food", "BF", Color(WgcCoreDsColors.orange29)),
    FLAME_FAST_FOOD("Flame Fast Food", "FF", Color(WgcCoreDsColors.red7)),
    PIZZA_DELIVERY("Pizza Delivery", "PD", Color(WgcCoreDsColors.blue5)),
    URBAN_MOBILITY("Urban Mobility", "UM", Color(WgcCoreDsColors.yellow4)),
    BIDDING_RIDES("Bidding Rides", "BR", Color(WgcCoreDsColors.green23)),
    BUS_TRAVEL("Bus Travel", "BT", Color(WgcCoreDsColors.blue10)),
    FLIGHT_TRAVEL("Flight Travel", "FT", Color(WgcCoreDsColors.pink2)),
    HOTEL_BOOKING("Hotel Booking", "HB", Color(WgcCoreDsColors.blue1)),
    VIDEO_STREAM("Video Streaming", "VS", Color(WgcCoreDsColors.red13)),
    AUDIO_STREAM("Audio Streaming", "AS", Color(WgcCoreDsColors.green20)),
    LANGUAGE_LEARNING("Language Learning", "LL", Color(WgcCoreDsColors.green19)),
    TECH_EDUCATION("Tech Education", "TE", Color(WgcCoreDsColors.blue24)),
    WORKSPACE_DOCS("Workspace Docs", "WD", Color(WgcCoreDsColors.grayDark22)),
    KANBAN_TASKS("Kanban Tasks", "KT", Color(WgcCoreDsColors.blue14)),
    EXPRESS_LOGISTICS("Express Logistics", "EL", Color(WgcCoreDsColors.blue29)),
    DEPARTMENT_FASHION("Department Fashion", "DF", Color(WgcCoreDsColors.red8)),
    HOME_IMPROVEMENT("Home Improvement", "HI", Color(WgcCoreDsColors.green22)),
    DAILY_NEWS("Daily News", "DN", Color(WgcCoreDsColors.red5)),
    CITIZEN_SERVICES("Citizen Services", "CS", Color(WgcCoreDsColors.blue7)),
    BEVERAGE_DELIVERY("Beverage Delivery", "BD", Color(WgcCoreDsColors.yellow4)),
    AUTOMOTIVE("Automotive", "AM", Color(WgcCoreDsColors.red16)),
    HARDWARE("Hardware", "HW", Color(WgcCoreDsColors.orange17));
}
