package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.alura.*

enum class WgcAluraScreen {
    HOME,
    PLAYER,
    CAREER,
    FORUM,
    PROFILE
}

@Composable
fun WgcAluraFactory(
    screen: WgcAluraScreen = WgcAluraScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcAluraScreen.HOME -> WgcAluraHomeTemplate(modifier = modifier)
        WgcAluraScreen.PLAYER -> WgcAluraPlayerTemplate(modifier = modifier)
        WgcAluraScreen.CAREER -> WgcAluraCareerTemplate(modifier = modifier)
        WgcAluraScreen.FORUM -> WgcAluraForumTemplate(modifier = modifier)
        WgcAluraScreen.PROFILE -> WgcAluraProfileTemplate(modifier = modifier)
    }
}
