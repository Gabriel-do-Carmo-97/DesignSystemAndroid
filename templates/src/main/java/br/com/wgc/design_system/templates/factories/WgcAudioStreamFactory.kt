package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.screens.audiostreaming.*
import br.com.wgc.design_system.theme.WgcTheme

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

@Preview(name = "WgcAudioStreamFactory - Home", showBackground = true)
@Composable
private fun WgcAudioStreamFactoryHomePreview() {
    WgcTheme {
        WgcAudioStreamFactory(screen = WgcAudioStreamScreen.HOME)
    }
}

@Preview(name = "WgcAudioStreamFactory - Search", showBackground = true)
@Composable
private fun WgcAudioStreamFactorySearchPreview() {
    WgcTheme {
        WgcAudioStreamFactory(screen = WgcAudioStreamScreen.SEARCH)
    }
}

@Preview(name = "WgcAudioStreamFactory - Library", showBackground = true)
@Composable
private fun WgcAudioStreamFactoryLibraryPreview() {
    WgcTheme {
        WgcAudioStreamFactory(screen = WgcAudioStreamScreen.LIBRARY)
    }
}

@Preview(name = "WgcAudioStreamFactory - Player", showBackground = true)
@Composable
private fun WgcAudioStreamFactoryPlayerPreview() {
    WgcTheme {
        WgcAudioStreamFactory(screen = WgcAudioStreamScreen.PLAYER)
    }
}

@Preview(name = "WgcAudioStreamFactory - Profile", showBackground = true)
@Composable
private fun WgcAudioStreamFactoryProfilePreview() {
    WgcTheme {
        WgcAudioStreamFactory(screen = WgcAudioStreamScreen.PROFILE)
    }
}

