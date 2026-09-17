package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.coursemarketplace.*

enum class WgcCourseMarketplaceScreen {
    EXPLORE,
    DETAIL,
    MY_COURSES,
    REVIEWS,
    PROFILE
}

@Composable
fun WgcCourseMarketplaceFactory(
    screen: WgcCourseMarketplaceScreen = WgcCourseMarketplaceScreen.EXPLORE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcCourseMarketplaceScreen.EXPLORE -> WgcUdemyExploreTemplate(modifier = modifier)
        WgcCourseMarketplaceScreen.DETAIL -> WgcUdemyCourseDetailTemplate(modifier = modifier)
        WgcCourseMarketplaceScreen.MY_COURSES -> WgcUdemyMyCoursesTemplate(modifier = modifier)
        WgcCourseMarketplaceScreen.REVIEWS -> WgcUdemyReviewsTemplate(modifier = modifier)
        WgcCourseMarketplaceScreen.PROFILE -> WgcUdemyProfileTemplate(modifier = modifier)
    }
}
