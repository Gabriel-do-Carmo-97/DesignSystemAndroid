package br.com.wgc.design_system.commons.previews.devices.status

import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Gera seis previews em telefones pequeno e grande, cobrindo nomes de estado padrão, loading e
 * disabled/erro.
 *
 * Use em telas com variações visuais de estado para inspecionar cada apresentação nos dois tamanhos:
 * `@WgcStatusDevicePreviews @Composable fun StatusPreview() { Text("Exemplo") }`.
 * A anotação cria os previews, mas não altera o estado da função anotada; prepare o conteúdo de cada
 * estado na própria preview conforme necessário.
 */
@Preview(name = "Default - Small Device", device = ComponentsConstants.Previews.SPEC_PHONE_SMALL, showBackground = true)
@Preview(name = "Default - Large Device", device = ComponentsConstants.Previews.SPEC_PHONE_LARGE, showBackground = true)
@Preview(name = "Loading - Small Device", device = ComponentsConstants.Previews.SPEC_PHONE_SMALL, showBackground = true)
@Preview(name = "Loading - Large Device", device = ComponentsConstants.Previews.SPEC_PHONE_LARGE, showBackground = true)
@Preview(name = "Disabled/Error - Small Device", device = ComponentsConstants.Previews.SPEC_PHONE_SMALL, showBackground = true)
@Preview(name = "Disabled/Error - Large Device", device = ComponentsConstants.Previews.SPEC_PHONE_LARGE, showBackground = true)
annotation class WgcStatusDevicePreviews
