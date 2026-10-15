package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.templates.brand.WgcBrand

/**
 * Variantes da Tela de Cadastro suportadas pelo WGC Design System.
 */
enum class WgcRegisterVariant(
    val displayName: String,
    val logoText: String = "DS",
    val primaryColor: Color = Color(WgcCoreDsColors.primary),
    val associatedBrand: WgcBrand? = null
) {
    STANDARD("Padrão", "DS", Color(WgcCoreDsColors.primary)),
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
    PHARMACY_CHAIN("Pharmacy Chain", "PC", Color(WgcCoreDsColors.pharmacyChainRed), WgcBrand.PharmacyChain),
    FRESH_GROCERY("Fresh Grocery", "FG", Color(WgcCoreDsColors.megaStorerPrimary), WgcBrand.FreshGrocery),
    PET_CARE("Pet Care", "PC", Color(WgcCoreDsColors.petCareYellow), WgcBrand.PetCare);
}
