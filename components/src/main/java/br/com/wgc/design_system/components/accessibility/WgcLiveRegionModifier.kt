package br.com.wgc.design_system.components.accessibility

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics

/**
 * Modificador para definir regiões dinâmicas (Live Regions) informando ao TalkBack quando há atualizações em tempo real.
 */
fun Modifier.wgcLiveRegion(mode: LiveRegionMode = LiveRegionMode.Polite): Modifier {
    return this.semantics {
        liveRegion = mode
    }
}
