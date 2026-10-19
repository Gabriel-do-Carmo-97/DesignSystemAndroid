package br.com.wgc.design_system.commons.haptics.provider

import androidx.compose.runtime.compositionLocalOf
import br.com.wgc.design_system.commons.haptics.contract.WgcHapticFeedback

/**
 * Fornece [WgcHapticFeedback] pela árvore de composição.
 *
 * Use `CompositionLocalProvider` para substituir o feedback em uma área da UI (por exemplo, em testes);
 * sem provedor, os métodos são no-op. Para obter a implementação padrão, prefira
 * `rememberWgcHapticFeedback()`.
 *
 * ```kotlin
 * CompositionLocalProvider(LocalWgcHapticFeedback provides fakeHaptics) {
 *     MyScreen()
 * }
 * ```
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
