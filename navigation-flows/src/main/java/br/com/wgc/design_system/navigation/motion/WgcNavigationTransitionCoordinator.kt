package br.com.wgc.design_system.navigation.motion

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavBackStackEntry
import br.com.wgc.design_system.core.WgcCoreDsMotion

/**
 * Coordenador centralizado de animações de transição de tela para grafos de navegação Compose.
 * Alinhado rigorosamente aos tokens de tempo e interpolação de WgcCoreDsMotion.
 */
object WgcNavigationTransitionCoordinator {

    private const val DEFAULT_SCALE_DOWN = 0.92f
    private const val DEFAULT_SCALE_UP = 1.08f

    /**
     * Transição de entrada horizontal com fade suave (padrão de avanço no fluxo).
     */
    val slideInForward: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) = {
        slideInHorizontally(
            initialOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationStandard300,
                easing = FastOutSlowInEasing
            )
        ) + fadeIn(
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationShort200,
                easing = LinearOutSlowInEasing
            )
        )
    }

    /**
     * Transição de saída horizontal com fade suave (padrão ao avançar para próxima tela).
     */
    val slideOutForward: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) = {
        slideOutHorizontally(
            targetOffsetX = { fullWidth -> -fullWidth / 3 },
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationStandard300,
                easing = FastOutSlowInEasing
            )
        ) + fadeOut(
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationShort150
            )
        )
    }

    /**
     * Transição de entrada ao voltar (pop back stack).
     */
    val slideInBackward: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) = {
        slideInHorizontally(
            initialOffsetX = { fullWidth -> -fullWidth / 3 },
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationStandard300,
                easing = FastOutSlowInEasing
            )
        ) + fadeIn(
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationShort200
            )
        )
    }

    /**
     * Transição de saída ao voltar (pop back stack).
     */
    val slideOutBackward: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) = {
        slideOutHorizontally(
            targetOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationStandard300,
                easing = FastOutSlowInEasing
            )
        ) + fadeOut(
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationShort150
            )
        )
    }

    /**
     * Transição Fade Through para alternância de abas e telas no mesmo nível hierárquico.
     */
    val fadeThroughEnter: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) = {
        fadeIn(
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationShort200,
                easing = LinearOutSlowInEasing
            )
        ) + scaleIn(
            initialScale = DEFAULT_SCALE_DOWN,
            animationSpec = tween(durationMillis = WgcCoreDsMotion.durationStandard300)
        )
    }

    val fadeThroughExit: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) = {
        fadeOut(
            animationSpec = tween(
                durationMillis = WgcCoreDsMotion.durationShort150
            )
        ) + scaleOut(
            targetScale = DEFAULT_SCALE_UP,
            animationSpec = tween(durationMillis = WgcCoreDsMotion.durationStandard300)
        )
    }
}
