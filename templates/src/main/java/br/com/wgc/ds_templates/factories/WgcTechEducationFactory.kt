package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.techeducation.*

enum class WgcTechEducationScreen {
    HOME,
    PLAYER,
    CAREER,
    FORUM,
    PROFILE
}

@Composable
fun WgcTechEducationFactory(
    screen: WgcTechEducationScreen = WgcTechEducationScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcTechEducationScreen.HOME -> WgcAluraHomeTemplate(modifier = modifier)
        WgcTechEducationScreen.PLAYER -> WgcAluraPlayerTemplate(modifier = modifier)
        WgcTechEducationScreen.CAREER -> WgcAluraCareerTemplate(modifier = modifier)
        WgcTechEducationScreen.FORUM -> WgcAluraForumTemplate(modifier = modifier)
        WgcTechEducationScreen.PROFILE -> WgcAluraProfileTemplate(modifier = modifier)
    }
}
