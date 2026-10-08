package br.com.wgc.design_system.commons.previews.devices.phone

import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Anotação MultiPreview que renderiza o Composable em:
 * 1. Device Pequeno (Phone Compact - 360x640 dp)
 * 2. Device Grande (Phone Large / Phablet - 411x891 dp)
 */
@Preview(
    name = "Small Device (360x640)",
    device = ComponentsConstants.Previews.SPEC_PHONE_SMALL,
    showBackground = true,
)
@Preview(
    name = "Large Device (411x891)",
    device = ComponentsConstants.Previews.SPEC_PHONE_LARGE,
    showBackground = true,
)
annotation class WgcDevicePreviews
