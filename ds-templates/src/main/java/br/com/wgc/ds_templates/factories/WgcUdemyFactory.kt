package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.udemy.*

enum class WgcUdemyScreen {
    EXPLORE,
    DETAIL,
    MY_COURSES,
    REVIEWS,
    PROFILE
}

@Composable
fun WgcUdemyFactory(
    screen: WgcUdemyScreen = WgcUdemyScreen.EXPLORE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcUdemyScreen.EXPLORE -> WgcUdemyExploreTemplate(modifier = modifier)
        WgcUdemyScreen.DETAIL -> WgcUdemyCourseDetailTemplate(modifier = modifier)
        WgcUdemyScreen.MY_COURSES -> WgcUdemyMyCoursesTemplate(modifier = modifier)
        WgcUdemyScreen.REVIEWS -> WgcUdemyReviewsTemplate(modifier = modifier)
        WgcUdemyScreen.PROFILE -> WgcUdemyProfileTemplate(modifier = modifier)
    }
}
