package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors

/**
 * Variantes da Tela de OTP suportadas pelo WGC Design System.
 */
enum class WgcOtpVariant(
    val displayName: String,
    val logoText: String = "DS",
    val primaryColor: Color = Color(WgcCoreDsColors.primary)
) {
    STANDARD("PadrÃ£o", "DS", Color(WgcCoreDsColors.primary)),
    FOOD_DELIVERY("Food Delivery", "FD", Color(WgcCoreDsColors.foodDeliveryRed)),
    RIDE_HAILING("Ride Hailing", "RH", Color(WgcCoreDsColors.rideHailingBlack)),
    MARKETPLACE("Marketplace", "MP", Color(WgcCoreDsColors.marketplaceYellow)),
    GYM_FITNESS("Gym & Fitness", "GF", Color(WgcCoreDsColors.gymYellow)),
    TELEMEDICINE("Telemedicine", "TM", Color(WgcCoreDsColors.telemedicineGreen)),
    FINTECH_NEOBANK("Fintech Neobank", "FN", Color(WgcCoreDsColors.fintechPurple));
}
