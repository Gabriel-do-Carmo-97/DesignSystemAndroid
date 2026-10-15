package br.com.wgc.design_system.commons.previews.multi.device

import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Anotação Multi-Preview para validação em múltiplos formatos de tela: Celular, Tablet e Dobrável (Foldable).
 */
@Preview(
    name = "Phone",
    group = "Devices",
    device = ComponentsConstants.Previews.SPEC_PHONE,
    showSystemUi = true,
)
@Preview(
    name = "Tablet",
    group = "Devices",
    device = ComponentsConstants.Previews.SPEC_TABLET_LANDSCAPE,
    showSystemUi = true,
)
@Preview(
    name = "Foldable",
    group = "Devices",
    device = ComponentsConstants.Previews.SPEC_FOLDABLE,
    showSystemUi = true,
)
annotation class DevicePreviews
