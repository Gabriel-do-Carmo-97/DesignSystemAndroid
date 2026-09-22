package br.com.wgc.design_system.commons

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Anotação Multi-Preview para validação simultânea de temas Claro (Light) e Escuro (Dark).
 */
@Preview(
    name = "Light Mode",
    group = "Themes",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    name = "Dark Mode",
    group = "Themes",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
annotation class ThemePreviews

/**
 * Anotação Multi-Preview para validação em múltiplos formatos de tela: Celular, Tablet e Dobrável (Foldable).
 */
@Preview(
    name = "Phone",
    group = "Devices",
    device = "spec:width=411dp,height=891dp",
    showSystemUi = true,
)
@Preview(
    name = "Tablet",
    group = "Devices",
    device = "spec:width=1280dp,height=800dp,dpi=240",
    showSystemUi = true,
)
@Preview(
    name = "Foldable",
    group = "Devices",
    device = "spec:width=673dp,height=841dp",
    showSystemUi = true,
)
annotation class DevicePreviews

/**
 * Anotação Multi-Preview para validação de acessibilidade tipográfica com escala normal (1.0x) e ampliada (1.5x).
 */
@Preview(
    name = "Font Normal (1.0x)",
    group = "Font Scale",
    fontScale = 1.0f,
    showBackground = true,
)
@Preview(
    name = "Font Large (1.5x)",
    group = "Font Scale",
    fontScale = 1.5f,
    showBackground = true,
)
annotation class FontScalePreviews

/**
 * Anotação Multi-Preview completa corporativa para componentes WGC.
 * Combina simultaneamente temas (Light/Dark) e dispositivos (Phone/Tablet).
 */
@ThemePreviews
@DevicePreviews
annotation class WgcCompletePreviews
