package br.com.wgc.design_system.commons.previews.multi.font

import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Anotação Multi-Preview para validação de acessibilidade tipográfica com escala normal (1.0x) e ampliada (1.5x).
 */
@Preview(
    name = "Font Normal (1.0x)",
    group = "Font Scale",
    fontScale = ComponentsConstants.Previews.FONT_SCALE_NORMAL,
    showBackground = true,
)
@Preview(
    name = "Font Large (1.5x)",
    group = "Font Scale",
    fontScale = ComponentsConstants.Previews.FONT_SCALE_LARGE,
    showBackground = true,
)
annotation class FontScalePreviews
