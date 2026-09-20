package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.audiostreaming.*

enum class WgcAudioStreamScreen {
    HOME,
    SEARCH,
    LIBRARY,
    PLAYER,
    PROFILE
}

@Composable
fun WgcAudioStreamFactory(
    screen: WgcAudioStreamScreen = WgcAudioStreamScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcAudioStreamScreen.HOME -> WgcAudioStreamHomeTemplate(modifier = modifier)
        WgcAudioStreamScreen.SEARCH -> WgcAudioStreamSearchTemplate(modifier = modifier)
        WgcAudioStreamScreen.LIBRARY -> WgcAudioStreamLibraryTemplate(modifier = modifier)
        WgcAudioStreamScreen.PLAYER -> WgcAudioStreamPlayerTemplate(modifier = modifier)
        WgcAudioStreamScreen.PROFILE -> WgcAudioStreamProfileTemplate(modifier = modifier)
    }
}
