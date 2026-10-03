@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.navigation.motion

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavBackStackEntry

/**
 * Transições padrão corporativas para rotas no ecossistema WGC.
 */
object WgcNavigationTransitions {

    private const val DEFAULT_TRANSITION_DURATION = 350

    val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) = {
        slideInHorizontally(
            initialOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(DEFAULT_TRANSITION_DURATION)
        ) + fadeIn(animationSpec = tween(DEFAULT_TRANSITION_DURATION))
    }

    val exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) = {
        slideOutHorizontally(
            targetOffsetX = { fullWidth -> -fullWidth / 3 },
            animationSpec = tween(DEFAULT_TRANSITION_DURATION)
        ) + fadeOut(animationSpec = tween(DEFAULT_TRANSITION_DURATION))
    }

    val popEnterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) = {
        slideInHorizontally(
            initialOffsetX = { fullWidth -> -fullWidth / 3 },
            animationSpec = tween(DEFAULT_TRANSITION_DURATION)
        ) + fadeIn(animationSpec = tween(DEFAULT_TRANSITION_DURATION))
    }

    val popExitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) = {
        slideOutHorizontally(
            targetOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(DEFAULT_TRANSITION_DURATION)
        ) + fadeOut(animationSpec = tween(DEFAULT_TRANSITION_DURATION))
    }
}
