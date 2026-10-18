package br.com.wgc.design_system.commons.previews.devices.phone

import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Gera previews em dois formatos de telefone: compacto (360 × 640 dp) e grande (411 × 891 dp).
 *
 * Use para conferir se um componente ou layout se adapta a larguras comuns de celular:
 * `@WgcDevicePreviews @Composable fun PhonePreview() { Text("Exemplo") }`.
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
