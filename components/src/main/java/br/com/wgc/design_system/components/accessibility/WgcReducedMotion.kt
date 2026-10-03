package br.com.wgc.design_system.components.accessibility

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween

/**
 * Utilitário de Motion Acessível para respeito às diretrizes de movimento reduzido do sistema operacional.
 */
object WgcReducedMotion {

    /**
     * Retorna a especificação de animação padrão, ou snap instantâneo caso o usuário tenha reduzido o movimento.
     */
    fun <T> accessibleAnimationSpec(
        defaultSpec: AnimationSpec<T> = tween(durationMillis = 300),
        isReducedMotionEnabled: Boolean = false
    ): AnimationSpec<T> {
        return if (isReducedMotionEnabled) snap() else defaultSpec
    }
}
