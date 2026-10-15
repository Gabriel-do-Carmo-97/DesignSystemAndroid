package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcGymFitnessFactory
import br.com.wgc.design_system.templates.factories.WgcGymFitnessScreen
import br.com.wgc.design_system.factories.verticals.gymfitness.templates.classes.WgcGymFitnessClassesTemplate
import br.com.wgc.design_system.factories.verticals.gymfitness.templates.go.WgcGymFitnessGoVideoTemplate
import br.com.wgc.design_system.factories.verticals.gymfitness.templates.home.WgcGymFitnessHomeTemplate
import br.com.wgc.design_system.factories.verticals.gymfitness.templates.model.GymFitnessMockData
import br.com.wgc.design_system.factories.verticals.gymfitness.templates.profile.WgcGymFitnessProfilePassTemplate
import br.com.wgc.design_system.factories.verticals.gymfitness.templates.workouts.WgcGymFitnessWorkoutRoutineTemplate

class WgcGymFitnessScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewGymFitnessHome() {
        WgcGymFitnessHomeTemplate(
            user = GymFitnessMockData.mockUser,
            currentUnit = GymFitnessMockData.mockUnits.first(),
            todayRoutine = GymFitnessMockData.mockRoutines.first()
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewGymFitnessWorkouts() {
        WgcGymFitnessWorkoutRoutineTemplate(
            routines = GymFitnessMockData.mockRoutines,
            selectedRoutineIndex = 0,
            onSelectRoutine = {}
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewGymFitnessClasses() {
        WgcGymFitnessClassesTemplate(
            classes = GymFitnessMockData.mockClasses,
            selectedDayIndex = 0,
            onSelectDay = {},
            selectedCategoryIndex = 0,
            onSelectCategory = {}
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewGymFitnessGoVideos() {
        WgcGymFitnessGoVideoTemplate(
            videos = GymFitnessMockData.mockGoVideos
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewGymFitnessProfilePass() {
        WgcGymFitnessProfilePassTemplate(
            user = GymFitnessMockData.mockUser
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewGymFitnessFactory() {
        WgcGymFitnessFactory.Screen(screen = WgcGymFitnessScreen.Home)
    }
}
