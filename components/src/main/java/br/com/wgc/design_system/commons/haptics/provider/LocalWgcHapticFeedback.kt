package br.com.wgc.design_system.commons.haptics.provider

import androidx.compose.runtime.compositionLocalOf
import br.com.wgc.design_system.commons.haptics.contract.WgcHapticFeedback

/**
 * [androidx.compose.runtime.CompositionLocal] para prover e consumir [WgcHapticFeedback] na árvore de componentes.
 */
val LocalWgcHapticFeedback = compositionLocalOf<WgcHapticFeedback> {
    @Suppress("EmptyFunctionBlock")
    object : WgcHapticFeedback {
        override fun click() {}
        override fun confirm() {}
        override fun success() {}
        override fun warning() {}
        override fun error() {}
    }
}
