package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcNtcFactory
import br.com.wgc.ds_templates.factories.WgcNtcScreen
import br.com.wgc.ds_templates.screens.ntc.activity.WgcNtcActivityTemplate
import br.com.wgc.ds_templates.screens.ntc.detail.WgcNtcWorkoutDetailTemplate
import br.com.wgc.ds_templates.screens.ntc.home.WgcNtcHomeTemplate
import br.com.wgc.ds_templates.screens.ntc.model.NtcMockData
import br.com.wgc.ds_templates.screens.ntc.player.WgcNtcWorkoutPlayerTemplate
import br.com.wgc.ds_templates.screens.ntc.programs.WgcNtcProgramsTemplate

class WgcNtcScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcHome() {
        WgcNtcHomeTemplate(
            user = NtcMockData.mockUser,
            featuredWorkout = NtcMockData.mockWorkouts.first(),
            activeProgram = NtcMockData.mockPrograms.first(),
            workouts = NtcMockData.mockWorkouts
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcPlayer() {
        WgcNtcWorkoutPlayerTemplate(
            workout = NtcMockData.mockWorkouts.first(),
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
            workout = NtcMockData.mockWorkouts.first()
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcPrograms() {
        WgcNtcProgramsTemplate(
            programs = NtcMockData.mockPrograms
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcActivity() {
        WgcNtcActivityTemplate(
            stats = NtcMockData.mockStats
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNtcFactory() {
        WgcNtcFactory(screen = WgcNtcScreen.HOME)
    }
}
