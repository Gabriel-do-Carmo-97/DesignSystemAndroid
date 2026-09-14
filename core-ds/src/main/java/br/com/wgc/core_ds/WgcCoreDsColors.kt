package br.com.wgc.core_ds

import android.graphics.Color

object WgcCoreDsColors {
    // --- 1. CORES PRIMITIVAS ---
    val red500 = Color.parseColor("#F44336")
    val red700 = Color.parseColor("#D32F2F")

    val blue500 = Color.parseColor("#2196F3")
    val orange500 = Color.parseColor("#FF5722")

    val grey50 = Color.parseColor("#FAFAFA")
    val grey100 = Color.parseColor("#F5F5F5")
    val grey900 = Color.parseColor("#212121")

    const val white = Color.WHITE
    const val black = Color.BLACK
    const val transparent = Color.TRANSPARENT

    // --- 2. CORES BRAND IFOOD ---
    val ifoodRed = Color.parseColor("#EA1D2C")
    val ifoodRedDark = Color.parseColor("#CC1825")
    val ifoodGreen = Color.parseColor("#00A251")
    val ifoodBgGray = Color.parseColor("#F7F7F7")

    // --- 3. CORES BRAND 99FOOD ---
    val nineNineDarkBlue = Color.parseColor("#0B2545")
    val nineNineLightBlue = Color.parseColor("#1E88E5")

    // --- 4. CORES BRAND MERCADO LIVRE ---
    val mercadoLivreYellow = Color.parseColor("#FFE600")
    val mercadoLivreBlue = Color.parseColor("#2D3277")
    val mercadoLivreGreen = Color.parseColor("#00A650")
    val mercadoLivreBgGray = Color.parseColor("#EBEBEB")

    // --- 5. NOVAS BRANDS (SHOPEE, UBER, ALIEXPRESS, STYLISH) ---
    val shopeeOrange = Color.parseColor("#EE4D2D")
    val uberBlack = Color.parseColor("#111111")
    val aliExpressRed = Color.parseColor("#FF4747")
    val aliExpressOrange = Color.parseColor("#FF6E00")
    val stylishPink = Color.parseColor("#F83758")
    val stylishBlue = Color.parseColor("#4392F9")
    val stylishDark = Color.parseColor("#17223B")
    val stylishGold = Color.parseColor("#EDB310")
    val stylishLightGray = Color.parseColor("#F9F9F9")
    val stylishBorderGray = Color.parseColor("#A8A8A9")

    // --- 5.1 CORES BRAND SHOPPE (FASHION STORE) ---
    val shoppePrimary = Color.parseColor("#004CFF")
    val shoppePrimaryLight = Color.parseColor("#DFE9FF")
    val shoppeDark = Color.parseColor("#202020")
    val shoppeSecondaryText = Color.parseColor("#707070")
    val shoppeBackground = Color.parseColor("#F5F5F5")
    val shoppeGold = Color.parseColor("#F1B11C")
    val shoppeBorder = Color.parseColor("#D2D2D2")
    val shoppeAlertRed = Color.parseColor("#FFEBEB")

    // --- 6. TOKENS SEMÂNTICOS ---
    val primary = orange500
    val secondary = white
    val background = grey50

    val error = red500
    val success = Color.parseColor("#4CAF50")
    val warning = Color.parseColor("#FFC107")

    val textPrimary = grey900
    val textSecondary = Color.parseColor("#757575")

    // --- 7. CORES BRAND KUTUKU (LUXURY / ACCESSORIES) ---
    val kutukuPrimary = Color.parseColor("#514EB7")
    val kutukuPrimaryLight = Color.parseColor("#EAE9FB")
    val kutukuSecondary = Color.parseColor("#C4C3FF")
    val kutukuDark = Color.parseColor("#101010")
    val kutukuSecondaryText = Color.parseColor("#707070")
    val kutukuBackground = Color.parseColor("#FBFBFC")
    val kutukuSurface = Color.WHITE
    val kutukuBorder = Color.parseColor("#E8E8EE")
    val kutukuGold = Color.parseColor("#F1B11C")
    val kutukuAlertRed = Color.parseColor("#E74C3C")
}
