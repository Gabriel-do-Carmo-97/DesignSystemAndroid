package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.departmentfashion.*

enum class WgcDepartmentFashionScreen {
    HOME,
    COLLECTIONS,
    CARD,
    BAG,
    PROFILE
}

@Composable
fun WgcDepartmentFashionFactory(
    screen: WgcDepartmentFashionScreen = WgcDepartmentFashionScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcDepartmentFashionScreen.HOME -> WgcRennerHomeTemplate(modifier = modifier)
        WgcDepartmentFashionScreen.COLLECTIONS -> WgcRennerCollectionsTemplate(modifier = modifier)
        WgcDepartmentFashionScreen.CARD -> WgcRennerCardTemplate(modifier = modifier)
        WgcDepartmentFashionScreen.BAG -> WgcRennerBagTemplate(modifier = modifier)
        WgcDepartmentFashionScreen.PROFILE -> WgcRennerProfileTemplate(modifier = modifier)
    }
}
