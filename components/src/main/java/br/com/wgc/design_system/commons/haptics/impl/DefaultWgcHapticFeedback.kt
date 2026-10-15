package br.com.wgc.design_system.commons.haptics.impl

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import br.com.wgc.design_system.commons.constants.ComponentsConstants
import br.com.wgc.design_system.commons.haptics.contract.WgcHapticFeedback
import br.com.wgc.design_system.core.feedback.WgcCoreDsHaptics

/**
 * Implementação padrão de [WgcHapticFeedback] utilizando o [HapticFeedback] do Jetpack Compose
 * com fallback dinâmico para [Vibrator] e [VibratorManager] baseado nos tokens de [WgcCoreDsHaptics].
 */
@Suppress("EmptyFunctionBlock", "TooGenericExceptionCaught", "SwallowedException")
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
            vibrate(WgcCoreDsHaptics.DURATION_MICRO_MS)
        }
    }

    override fun confirm() {
        try {
            composeHaptic?.performHapticFeedback(HapticFeedbackType.LongPress)
        } catch (_: Exception) {
            vibrate(WgcCoreDsHaptics.DURATION_STANDARD_MS)
        }
    }

    override fun success() {
        val timings = longArrayOf(
            ComponentsConstants.Haptics.INITIAL_DELAY_MS,
            WgcCoreDsHaptics.DURATION_MICRO_MS,
            ComponentsConstants.Haptics.PAUSE_INTERVAL_MS,
            WgcCoreDsHaptics.DURATION_STANDARD_MS,
        )
        val amplitudes = intArrayOf(
            ComponentsConstants.Haptics.AMPLITUDE_OFF,
            ComponentsConstants.Haptics.AMPLITUDE_LIGHT,
            ComponentsConstants.Haptics.AMPLITUDE_OFF,
            ComponentsConstants.Haptics.AMPLITUDE_HIGH,
        )
        vibratePattern(timings, amplitudes, WgcCoreDsHaptics.DURATION_STANDARD_MS)
    }

    override fun warning() {
        val timings = longArrayOf(
            ComponentsConstants.Haptics.INITIAL_DELAY_MS,
            WgcCoreDsHaptics.DURATION_STANDARD_MS,
            ComponentsConstants.Haptics.PAUSE_INTERVAL_MS,
            WgcCoreDsHaptics.DURATION_STANDARD_MS,
        )
        val amplitudes = intArrayOf(
            ComponentsConstants.Haptics.AMPLITUDE_OFF,
            ComponentsConstants.Haptics.AMPLITUDE_MEDIUM_LOW,
            ComponentsConstants.Haptics.AMPLITUDE_OFF,
            ComponentsConstants.Haptics.AMPLITUDE_MEDIUM,
        )
        vibratePattern(timings, amplitudes, WgcCoreDsHaptics.DURATION_STANDARD_MS)
    }

    override fun error() {
        val timings = longArrayOf(
            ComponentsConstants.Haptics.INITIAL_DELAY_MS,
            WgcCoreDsHaptics.DURATION_STANDARD_MS,
            ComponentsConstants.Haptics.PAUSE_INTERVAL_MS,
            WgcCoreDsHaptics.DURATION_LONG_MS,
        )
        val amplitudes = intArrayOf(
            ComponentsConstants.Haptics.AMPLITUDE_OFF,
            ComponentsConstants.Haptics.AMPLITUDE_MAX,
            ComponentsConstants.Haptics.AMPLITUDE_OFF,
            ComponentsConstants.Haptics.AMPLITUDE_MAX,
        )
        vibratePattern(timings, amplitudes, WgcCoreDsHaptics.DURATION_LONG_MS)
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
            activeVibrator.vibrate(
                VibrationEffect.createWaveform(
                    timings,
                    amplitudes,
                    ComponentsConstants.Haptics.WAVEFORM_NO_REPEAT,
                ),
            )
        } catch (_: Exception) {
            vibrate(fallbackDurationMs)
        }
    }
}
