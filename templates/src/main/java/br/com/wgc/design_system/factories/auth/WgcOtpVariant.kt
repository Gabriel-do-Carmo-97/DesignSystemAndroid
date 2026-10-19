package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors

/**
 * Variantes da Tela de OTP suportadas pelo WGC Design System.
 */
enum class WgcOtpVariant(
    val displayName: String,
    val logoText: String = "DS",
    val primaryColor: Color = Color(WgcCoreDsColors.orange500)
) {
    STANDARD("PadrÃ£o", "DS", Color(WgcCoreDsColors.orange500)),
    FOOD_DELIVERY("Food Delivery", "FD", Color(WgcCoreDsColors.red18)),
    RIDE_HAILING("Ride Hailing", "RH", Color(WgcCoreDsColors.grayDark3)),
    MARKETPLACE("Marketplace", "MP", Color(WgcCoreDsColors.yellow8)),
    GYM_FITNESS("Gym & Fitness", "GF", Color(WgcCoreDsColors.orange23)),
    TELEMEDICINE("Telemedicine", "TM", Color(WgcCoreDsColors.cyan4)),
    FINTECH_NEOBANK("Fintech Neobank", "FN", Color(WgcCoreDsColors.purple3));
}
