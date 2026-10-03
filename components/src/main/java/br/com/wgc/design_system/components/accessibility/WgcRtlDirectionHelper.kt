package br.com.wgc.design_system.components.accessibility

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.LayoutDirection

/**
 * Modificador para espelhar horizontalmente ícones direcionais (como setas) quando em layout RTL (Right-to-Left).
 */
fun Modifier.wgcRtlMirror(layoutDirection: LayoutDirection): Modifier {
    return if (layoutDirection == LayoutDirection.Rtl) {
        this.scale(scaleX = -1f, scaleY = 1f)
    } else {
        this
    }
}
