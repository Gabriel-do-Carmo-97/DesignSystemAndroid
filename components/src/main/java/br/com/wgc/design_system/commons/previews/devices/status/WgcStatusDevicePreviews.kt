package br.com.wgc.design_system.commons.previews.devices.status

import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Anotação MultiPreview que combina Device (Small/Large) com Status comuns (Default, Loading, Disabled/Error).
 * Uso recomendado: aplicar em Previews de telas para gerar todas as combinações de device+status.
 */
@Preview(name = "Default - Small Device", device = ComponentsConstants.Previews.SPEC_PHONE_SMALL, showBackground = true)
@Preview(name = "Default - Large Device", device = ComponentsConstants.Previews.SPEC_PHONE_LARGE, showBackground = true)
@Preview(name = "Loading - Small Device", device = ComponentsConstants.Previews.SPEC_PHONE_SMALL, showBackground = true)
@Preview(name = "Loading - Large Device", device = ComponentsConstants.Previews.SPEC_PHONE_LARGE, showBackground = true)
@Preview(name = "Disabled/Error - Small Device", device = ComponentsConstants.Previews.SPEC_PHONE_SMALL, showBackground = true)
@Preview(name = "Disabled/Error - Large Device", device = ComponentsConstants.Previews.SPEC_PHONE_LARGE, showBackground = true)
annotation class WgcStatusDevicePreviews
