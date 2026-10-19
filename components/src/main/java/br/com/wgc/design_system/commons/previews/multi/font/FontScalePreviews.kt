package br.com.wgc.design_system.commons.previews.multi.font

import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Gera previews com escala de fonte normal (1,0×) e ampliada (1,5×).
 *
 * Use para verificar legibilidade, quebra de linha e clipping em diferentes escalas de acessibilidade:
 * `@FontScalePreviews @Composable fun TextPreview() { Text("Texto de exemplo") }`.
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
