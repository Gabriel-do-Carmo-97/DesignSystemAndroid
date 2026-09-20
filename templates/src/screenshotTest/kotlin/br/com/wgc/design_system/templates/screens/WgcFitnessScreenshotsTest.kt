package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcGuidedTrainingFactory
import br.com.wgc.design_system.templates.factories.WgcGuidedTrainingScreen
import br.com.wgc.design_system.templates.screens.guidedtraining.activity.WgcNtcActivityTemplate
import br.com.wgc.design_system.templates.screens.guidedtraining.detail.WgcNtcWorkoutDetailTemplate
import br.com.wgc.design_system.templates.screens.guidedtraining.home.WgcNtcHomeTemplate
import br.com.wgc.design_system.templates.screens.guidedtraining.model.GuidedTrainingMockData
import br.com.wgc.design_system.templates.screens.guidedtraining.player.WgcNtcWorkoutPlayerTemplate
import br.com.wgc.design_system.templates.screens.guidedtraining.programs.WgcNtcProgramsTemplate

class WgcFitnessScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcHome() {
        WgcNtcHomeTemplate(
            user = GuidedTrainingMockData.mockUser,
            featuredWorkout = GuidedTrainingMockData.mockWorkouts.first(),
            activeProgram = GuidedTrainingMockData.mockPrograms.first(),
            workouts = GuidedTrainingMockData.mockWorkouts
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcPlayer() {
        WgcNtcWorkoutPlayerTemplate(
            workout = GuidedTrainingMockData.mockWorkouts.first(),
            currentExerciseIndex = 2,
            timeRemainingFormatted = "00:45",
            progressFraction = 0.60f,
            isPlaying = true
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcDetail() {
        WgcNtcWorkoutDetailTemplate(
            workout = GuidedTrainingMockData.mockWorkouts.first()
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcPrograms() {
        WgcNtcProgramsTemplate(
            programs = GuidedTrainingMockData.mockPrograms
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcActivity() {
        WgcNtcActivityTemplate(
            stats = GuidedTrainingMockData.mockStats
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcFactory() {
        WgcGuidedTrainingFactory(screen = WgcGuidedTrainingScreen.HOME)
    }
}
