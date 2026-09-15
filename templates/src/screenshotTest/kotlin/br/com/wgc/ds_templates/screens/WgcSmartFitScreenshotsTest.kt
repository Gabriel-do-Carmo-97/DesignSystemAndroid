package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcSmartFitFactory
import br.com.wgc.ds_templates.factories.WgcSmartFitScreen
import br.com.wgc.ds_templates.screens.smartfit.classes.WgcSmartFitClassesTemplate
import br.com.wgc.ds_templates.screens.smartfit.go.WgcSmartFitGoVideoTemplate
import br.com.wgc.ds_templates.screens.smartfit.home.WgcSmartFitHomeTemplate
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitMockData
import br.com.wgc.ds_templates.screens.smartfit.profile.WgcSmartFitProfilePassTemplate
import br.com.wgc.ds_templates.screens.smartfit.workouts.WgcSmartFitWorkoutRoutineTemplate

class WgcSmartFitScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewSmartFitHome() {
        WgcSmartFitHomeTemplate(
            user = SmartFitMockData.mockUser,
            currentUnit = SmartFitMockData.mockUnits.first(),
            todayRoutine = SmartFitMockData.mockRoutines.first()
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewSmartFitWorkouts() {
        WgcSmartFitWorkoutRoutineTemplate(
            routines = SmartFitMockData.mockRoutines,
            selectedRoutineIndex = 0,
            onSelectRoutine = {}
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewSmartFitClasses() {
        WgcSmartFitClassesTemplate(
            classes = SmartFitMockData.mockClasses,
            selectedDayIndex = 0,
            onSelectDay = {},
            selectedCategoryIndex = 0,
            onSelectCategory = {}
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewSmartFitGoVideos() {
        WgcSmartFitGoVideoTemplate(
            videos = SmartFitMockData.mockGoVideos
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewSmartFitProfilePass() {
        WgcSmartFitProfilePassTemplate(
            user = SmartFitMockData.mockUser
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewSmartFitFactory() {
        WgcSmartFitFactory.Screen(screen = WgcSmartFitScreen.Home)
    }
}
