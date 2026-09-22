package br.com.wgc.design_system.commons

import androidx.compose.ui.tooling.preview.Preview

/**
 * Anotação MultiPreview que renderiza o Composable em:
 * 1. Device Pequeno (Phone Compact - 360x640 dp)
 * 2. Device Grande (Phone Large / Phablet - 411x891 dp)
 */
@Preview(
    name = "Small Device (360x640)",
    device = "spec:width=360dp,height=640dp,dpi=320",
    showBackground = true
)
@Preview(
    name = "Large Device (411x891)",
    device = "spec:width=411dp,height=891dp,dpi=420",
    showBackground = true
)
annotation class WgcDevicePreviews

/**
 * Anotação MultiPreview que renderiza o Composable em telas grandes de Tablets (7 e 10 polegadas).
 */
@Preview(
    name = "Tablet 7 Inch",
    device = "spec:width=600dp,height=1024dp,dpi=240",
    showBackground = true
)
@Preview(
    name = "Tablet 10 Inch",
    device = "spec:width=800dp,height=1280dp,dpi=240",
    showBackground = true
)
annotation class WgcTabletDevicePreviews

/**
 * Anotação MultiPreview que combina Device (Small/Large) com Status comuns (Default, Loading, Disabled/Error).
 * Uso recomendado: aplicar em Previews de telas para gerar todas as combinações de device+status.
 */
@Preview(name = "Default - Small Device", device = "spec:width=360dp,height=640dp,dpi=320", showBackground = true)
@Preview(name = "Default - Large Device", device = "spec:width=411dp,height=891dp,dpi=420", showBackground = true)
@Preview(name = "Loading - Small Device", device = "spec:width=360dp,height=640dp,dpi=320", showBackground = true)
@Preview(name = "Loading - Large Device", device = "spec:width=411dp,height=891dp,dpi=420", showBackground = true)
@Preview(name = "Disabled/Error - Small Device", device = "spec:width=360dp,height=640dp,dpi=320", showBackground = true)
@Preview(name = "Disabled/Error - Large Device", device = "spec:width=411dp,height=891dp,dpi=420", showBackground = true)
annotation class WgcStatusDevicePreviews
