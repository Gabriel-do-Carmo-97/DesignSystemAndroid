package br.com.wgc.design_system.navigation.motion

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import br.com.wgc.design_system.core.WgcCoreDsMotion

/**
 * Transições cinemáticas padrão Material Motion Shared Axis (Axis-X, Axis-Y, Axis-Z).
 */
object WgcSharedAxisMotion {

    private val DURATION = WgcCoreDsMotion.durationStandard300

    /**
     * Shared Axis X: transição horizontal para fluxo linear (avançar/voltar).
     */
    val sharedAxisXEnter: EnterTransition = slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth / 4 },
        animationSpec = tween(durationMillis = DURATION, easing = FastOutSlowInEasing)
    ) + fadeIn(animationSpec = tween(durationMillis = DURATION))

    val sharedAxisXExit: ExitTransition = slideOutHorizontally(
        targetOffsetX = { fullWidth -> -fullWidth / 4 },
        animationSpec = tween(durationMillis = DURATION, easing = FastOutSlowInEasing)
    ) + fadeOut(animationSpec = tween(durationMillis = DURATION))

    /**
     * Shared Axis Y: transição vertical para fluxos de criação, filtros e modais.
     */
    val sharedAxisYEnter: EnterTransition = slideInVertically(
        initialOffsetY = { fullHeight -> fullHeight / 4 },
        animationSpec = tween(durationMillis = DURATION, easing = FastOutSlowInEasing)
    ) + fadeIn(animationSpec = tween(durationMillis = DURATION))

    val sharedAxisYExit: ExitTransition = slideOutVertically(
        targetOffsetY = { fullHeight -> -fullHeight / 4 },
        animationSpec = tween(durationMillis = DURATION, easing = FastOutSlowInEasing)
    ) + fadeOut(animationSpec = tween(durationMillis = DURATION))

    /**
     * Shared Axis Z: transição de escala/profundidade para abrir detalhes ou trocar abas.
     */
    val sharedAxisZEnter: EnterTransition = scaleIn(
        initialScale = 0.8f,
        animationSpec = tween(durationMillis = DURATION, easing = FastOutSlowInEasing)
    ) + fadeIn(animationSpec = tween(durationMillis = DURATION))

    val sharedAxisZExit: ExitTransition = scaleOut(
        targetScale = 1.1f,
        animationSpec = tween(durationMillis = DURATION, easing = FastOutSlowInEasing)
    ) + fadeOut(animationSpec = tween(durationMillis = DURATION))
}
