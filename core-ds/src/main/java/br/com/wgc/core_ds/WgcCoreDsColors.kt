package br.com.wgc.core_ds

import android.graphics.Color

object WgcCoreDsColors {
    // --- 1. CORES PRIMITIVAS ---
    val red500 = Color.parseColor("#F44336") // Equivalente ao Colors.red
    val red700 = Color.parseColor("#D32F2F")

    val blue500 = Color.parseColor("#2196F3") // Equivalente ao Colors.blue
    val orange500 = Color.parseColor("#FF5722") // Equivalente ao Colors.deepOrange

    val grey50 = Color.parseColor("#FAFAFA")
    val grey100 = Color.parseColor("#F5F5F5")
    val grey900 = Color.parseColor("#212121")

    const val white = Color.WHITE
    const val black = Color.BLACK
    const val transparent = Color.TRANSPARENT

    // --- 2. TOKENS SEMÂNTICOS ---
    val primary = orange500
    val secondary = white
    val background = grey50

    val error = red500
    val success = Color.parseColor("#4CAF50") // Equivalente ao Colors.green
    val warning = Color.parseColor("#FFC107") // Equivalente ao Colors.amber

    val textPrimary = grey900
    val textSecondary = Color.parseColor("#757575")
}