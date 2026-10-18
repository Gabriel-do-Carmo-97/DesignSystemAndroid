package br.com.wgc.design_system.core

internal data class WgcAccessibilityAuditorArgb(val hex: Long) {
    val red: Double get() = ((hex shr 16) and 0xFF).toDouble() / 255.0
    val green: Double get() = ((hex shr 8) and 0xFF).toDouble() / 255.0
    val blue: Double get() = (hex and 0xFF).toDouble() / 255.0
}
