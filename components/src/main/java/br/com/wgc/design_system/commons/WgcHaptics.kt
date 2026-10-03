@file:Suppress("EmptyFunctionBlock", "TooGenericExceptionCaught", "SwallowedException")

package br.com.wgc.design_system.commons

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import br.com.wgc.design_system.core.WgcCoreDsHaptics

/**
 * Contrato oficial de feedback tátil (háptico) para componentes do Design System WGC.
 */
interface WgcHapticFeedback {
    /** Dispara vibração tátil suave para cliques em botões, chips e seletores. */
    fun click()

    /** Dispara vibração média para confirmação de ações (switches, checkboxes). */
    fun confirm()

    /** Dispara padrão tátil indicativo de sucesso ou conclusão. */
    fun success()

    /** Dispara vibração de alerta ou aviso de confirmação. */
    fun warning()

    /** Dispara padrão tátil firme para erros de validação ou recusa de ação. */
    fun error()
}

/**
 * Implementação padrão de [WgcHapticFeedback] utilizando o [HapticFeedback] do Jetpack Compose
 * com fallback dinâmico para [Vibrator] e [VibratorManager] baseado nos tokens de [WgcCoreDsHaptics].
 */
class DefaultWgcHapticFeedback(
    private val context: Context,
    private val composeHaptic: HapticFeedback? = null,
) : WgcHapticFeedback {

    private val vibrator: Vibrator? by lazy {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
                vibratorManager?.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
            }
        } catch (_: Exception) {
            null
        }
    }

    override fun click() {
        try {
            composeHaptic?.performHapticFeedback(HapticFeedbackType.TextHandleMove)
        } catch (_: Exception) {
            vibrate(WgcCoreDsHaptics.durationMicroMs)
        }
    }

    override fun confirm() {
        try {
            composeHaptic?.performHapticFeedback(HapticFeedbackType.LongPress)
        } catch (_: Exception) {
            vibrate(WgcCoreDsHaptics.durationStandardMs)
        }
    }

    override fun success() {
        val timings = longArrayOf(0, WgcCoreDsHaptics.durationMicroMs, 40L, WgcCoreDsHaptics.durationStandardMs)
        val amplitudes = intArrayOf(0, 100, 0, 180)
        vibratePattern(timings, amplitudes, WgcCoreDsHaptics.durationStandardMs)
    }

    override fun warning() {
        val timings = longArrayOf(0, WgcCoreDsHaptics.durationStandardMs, 40L, WgcCoreDsHaptics.durationStandardMs)
        val amplitudes = intArrayOf(0, 120, 0, 140)
        vibratePattern(timings, amplitudes, WgcCoreDsHaptics.durationStandardMs)
    }

    override fun error() {
        val timings = longArrayOf(0, WgcCoreDsHaptics.durationStandardMs, 40L, WgcCoreDsHaptics.durationLongMs)
        val amplitudes = intArrayOf(0, 255, 0, 255)
        vibratePattern(timings, amplitudes, WgcCoreDsHaptics.durationLongMs)
    }

    private fun vibrate(durationMs: Long) {
        val activeVibrator = vibrator ?: return
        if (!activeVibrator.hasVibrator()) return
        try {
            activeVibrator.vibrate(VibrationEffect.createOneShot(durationMs, VibrationEffect.DEFAULT_AMPLITUDE))
        } catch (_: Exception) {
            try {
                @Suppress("DEPRECATION")
                activeVibrator.vibrate(durationMs)
            } catch (_: Exception) {
                // Falha silenciosa
            }
        }
    }

    private fun vibratePattern(timings: LongArray, amplitudes: IntArray, fallbackDurationMs: Long) {
        val activeVibrator = vibrator ?: return
        if (!activeVibrator.hasVibrator()) return
        try {
            activeVibrator.vibrate(VibrationEffect.createWaveform(timings, amplitudes, -1))
        } catch (_: Exception) {
            vibrate(fallbackDurationMs)
        }
    }
}

/**
 * Cria e lembra uma instância de [WgcHapticFeedback] no escopo da composição.
 */
@Composable
fun rememberWgcHapticFeedback(): WgcHapticFeedback {
    val context = LocalContext.current
    val composeHaptic = LocalHapticFeedback.current
    return remember(context, composeHaptic) {
        DefaultWgcHapticFeedback(context = context, composeHaptic = composeHaptic)
    }
}

/**
 * [androidx.compose.runtime.CompositionLocal] para prover e consumir [WgcHapticFeedback] na árvore de componentes.
 */
val LocalWgcHapticFeedback = compositionLocalOf<WgcHapticFeedback> {
    object : WgcHapticFeedback {
        override fun click() {}
        override fun confirm() {}
        override fun success() {}
        override fun warning() {}
        override fun error() {}
    }
}
