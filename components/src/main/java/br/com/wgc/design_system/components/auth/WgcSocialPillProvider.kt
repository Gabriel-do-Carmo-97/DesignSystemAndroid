package br.com.wgc.design_system.components.auth

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.theme.WgcCoreDsColors

/**
 * Provedores sociais suportados nos botões pill.
 */
enum class WgcSocialPillProvider(
    val defaultLabel: String,
    val brandColor: Color
) {
    Facebook("Login with Facebook", Color(WgcCoreDsColors.blue34)),
    Instagram("Login with Instagram", Color(WgcCoreDsColors.pink3)),
    LinkedIn("Login with LinkedIn", Color(WgcCoreDsColors.blue16))
}
