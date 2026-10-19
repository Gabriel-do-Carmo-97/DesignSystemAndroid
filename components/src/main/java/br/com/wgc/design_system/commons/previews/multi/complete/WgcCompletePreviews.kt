package br.com.wgc.design_system.commons.previews.multi.complete

import br.com.wgc.design_system.commons.previews.multi.device.DevicePreviews
import br.com.wgc.design_system.commons.previews.multi.theme.ThemePreviews

/**
 * Combina [ThemePreviews] e [DevicePreviews] para inspecionar uma UI em tema claro/escuro e em
 * telefone, tablet e dobrável.
 *
 * Use para componentes/telas responsivos cuja aparência deve ser validada em todas essas
 * combinações: `@WgcCompletePreviews @Composable fun ScreenPreview() { Text("Exemplo") }`.
 */
@ThemePreviews
@DevicePreviews
annotation class WgcCompletePreviews
