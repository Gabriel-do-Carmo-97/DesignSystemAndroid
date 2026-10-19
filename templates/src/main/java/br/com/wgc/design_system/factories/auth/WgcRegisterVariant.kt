package br.com.wgc.design_system.factories.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.WgcCoreDsColors

/**
 * Variantes da Tela de Cadastro suportadas pelo WGC Design System.
 */
enum class WgcRegisterVariant(
    val displayName: String,
    val logoText: String = "DS",
    val primaryColor: Color = Color(WgcCoreDsColors.orange500)
) {
    STANDARD("PadrÃ£o", "DS", Color(WgcCoreDsColors.orange500)),
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
    PHARMACY_CHAIN("Pharmacy Chain", "PC", Color(WgcCoreDsColors.red8)),
    FRESH_GROCERY("Fresh Grocery", "FG", Color(WgcCoreDsColors.green6)),
    PET_CARE("Pet Care", "PC", Color(WgcCoreDsColors.yellow2));
}
