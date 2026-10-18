package br.com.wgc.design_system.commons.previews.multi.device

import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Gera previews em telefone, tablet em paisagem e dispositivo dobrável, exibindo também a system UI.
 *
 * Use ao validar responsividade em classes de dispositivo diferentes:
 * `@DevicePreviews @Composable fun ContentPreview() { Text("Exemplo") }`.
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
