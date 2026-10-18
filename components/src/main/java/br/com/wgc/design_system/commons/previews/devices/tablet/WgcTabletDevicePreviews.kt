package br.com.wgc.design_system.commons.previews.devices.tablet

import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Gera previews em tamanhos de tablet de 7 e 10 polegadas.
 *
 * Use para verificar componentes ou telas em larguras maiores:
 * `@WgcTabletDevicePreviews @Composable fun TabletPreview() { Text("Exemplo") }`.
 */
@Preview(
    name = "Tablet 7 Inch",
    device = ComponentsConstants.Previews.SPEC_TABLET_7_INCH,
    showBackground = true,
)
@Preview(
    name = "Tablet 10 Inch",
    device = ComponentsConstants.Previews.SPEC_TABLET_10_INCH,
    showBackground = true,
)
annotation class WgcTabletDevicePreviews
