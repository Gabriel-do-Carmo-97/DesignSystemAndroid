package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors

/**
 * Variantes da Tela de Cadastro suportadas pelo WGC Design System.
 */
enum class WgcRegisterVariant(
    val displayName: String,
    val logoText: String = "DS",
    val primaryColor: Color = Color(WgcCoreDsColors.primary)
) {
    STANDARD("PadrÃ£o", "DS", Color(WgcCoreDsColors.primary)),
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
    PHARMACY_CHAIN("Pharmacy Chain", "PC", Color(WgcCoreDsColors.pharmacyChainRed)),
    FRESH_GROCERY("Fresh Grocery", "FG", Color(WgcCoreDsColors.megaStorerPrimary)),
    PET_CARE("Pet Care", "PC", Color(WgcCoreDsColors.petCareYellow));
}
