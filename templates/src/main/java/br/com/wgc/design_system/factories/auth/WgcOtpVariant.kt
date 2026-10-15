package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.templates.brand.WgcBrand

/**
 * Variantes da Tela de OTP suportadas pelo WGC Design System.
 */
enum class WgcOtpVariant(
    val displayName: String,
    val logoText: String = "DS",
    val primaryColor: Color = Color(WgcCoreDsColors.primary),
    val associatedBrand: WgcBrand? = null
) {
    STANDARD("Padrão", "DS", Color(WgcCoreDsColors.primary)),
    FOOD_DELIVERY("Food Delivery", "FD", Color(WgcCoreDsColors.foodDeliveryRed), WgcBrand.FoodDelivery),
    RIDE_HAILING("Ride Hailing", "RH", Color(WgcCoreDsColors.rideHailingBlack), WgcBrand.RideHailing),
    MARKETPLACE("Marketplace", "MP", Color(WgcCoreDsColors.marketplaceYellow), WgcBrand.Marketplace),
    GYM_FITNESS("Gym & Fitness", "GF", Color(WgcCoreDsColors.gymYellow), WgcBrand.GymFitness),
    TELEMEDICINE("Telemedicine", "TM", Color(WgcCoreDsColors.telemedicineGreen), WgcBrand.Telemedicine),
    FINTECH_NEOBANK("Fintech Neobank", "FN", Color(WgcCoreDsColors.fintechPurple), WgcBrand.FintechNeobank);
}
