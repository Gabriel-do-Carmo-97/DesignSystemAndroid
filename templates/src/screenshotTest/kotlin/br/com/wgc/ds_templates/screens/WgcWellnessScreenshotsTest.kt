package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.components.cards.WgcCorporateWellnessPlanTier
import br.com.wgc.ds_templates.factories.WgcCorporateWellnessFactory
import br.com.wgc.ds_templates.factories.WgcCorporateWellnessScreen
import br.com.wgc.ds_templates.screens.corporatewellness.checkin.WgcCorporateWellnessCheckInTemplate
import br.com.wgc.ds_templates.screens.corporatewellness.explore.WgcCorporateWellnessExploreGymsTemplate
import br.com.wgc.ds_templates.screens.corporatewellness.home.WgcCorporateWellnessHomeTemplate
import br.com.wgc.ds_templates.screens.corporatewellness.model.CorporateWellnessMockData
import br.com.wgc.ds_templates.screens.corporatewellness.plans.WgcCorporateWellnessPlansTemplate
import br.com.wgc.ds_templates.screens.corporatewellness.wellness.WgcCorporateWellnessWellnessAppsTemplate

class WgcCorporateWellnessScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewCorporateWellnessHome() {
        WgcCorporateWellnessHomeTemplate(
            user = CorporateWellnessMockData.mockUser,
            nearbyGyms = CorporateWellnessMockData.mockGyms
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCorporateWellnessExploreGyms() {
        WgcCorporateWellnessExploreGymsTemplate(
            gyms = CorporateWellnessMockData.mockGyms,
            selectedFilterIndex = 0,
            onSelectFilter = {}
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCorporateWellnessCheckIn() {
        WgcCorporateWellnessCheckInTemplate(
            user = CorporateWellnessMockData.mockUser,
            currentCheckIn = CorporateWellnessMockData.mockUser.todayCheckIn!!
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCorporateWellnessPlans() {
        WgcCorporateWellnessPlansTemplate(
            plans = CorporateWellnessMockData.mockPlans,
            currentTier = WgcCorporateWellnessPlanTier.GOLD
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCorporateWellnessWellnessApps() {
        WgcCorporateWellnessWellnessAppsTemplate(
            apps = CorporateWellnessMockData.mockWellnessApps
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCorporateWellnessFactory() {
        WgcCorporateWellnessFactory.Screen(screen = WgcCorporateWellnessScreen.Home)
    }
}
