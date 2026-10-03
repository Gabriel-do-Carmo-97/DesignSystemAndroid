package br.com.wgc.design_system.components.accessibility

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Modificador para garantir o padrão de acessibilidade WCAG 2.1 / 2.2 de área de toque mínima (48x48 dp).
 */
fun Modifier.wgcMinTouchTarget(minSize: Dp = 48.dp): Modifier {
    return this.defaultMinSize(minWidth = minSize, minHeight = minSize)
}
