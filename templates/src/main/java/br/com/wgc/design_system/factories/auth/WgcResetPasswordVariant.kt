package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors

/**
 * Variantes da Tela de RecuperaÃ§Ã£o de Senha suportadas pelo WGC Design System.
 */
enum class WgcResetPasswordVariant(
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
    GYM_FITNESS("Gym & Fitness", "GF", Color(WgcCoreDsColors.gymYellow)),
    TELEMEDICINE("Telemedicine", "TM", Color(WgcCoreDsColors.telemedicineGreen)),
    FINTECH_NEOBANK("Fintech Neobank", "FN", Color(WgcCoreDsColors.fintechPurple));
}
