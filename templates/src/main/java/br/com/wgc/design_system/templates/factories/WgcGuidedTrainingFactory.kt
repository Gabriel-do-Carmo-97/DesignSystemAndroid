package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcFitnessNavItem
import br.com.wgc.design_system.templates.screens.guidedtraining.activity.WgcNtcActivityTemplate
import br.com.wgc.design_system.templates.screens.guidedtraining.detail.WgcNtcWorkoutDetailTemplate
import br.com.wgc.design_system.templates.screens.guidedtraining.home.WgcNtcHomeTemplate
import br.com.wgc.design_system.templates.screens.guidedtraining.model.NtcActivityStats
import br.com.wgc.design_system.templates.screens.guidedtraining.model.GuidedTrainingMockData
import br.com.wgc.design_system.templates.screens.guidedtraining.model.NtcProgramItem
import br.com.wgc.design_system.templates.screens.guidedtraining.model.NtcUserProfile
import br.com.wgc.design_system.templates.screens.guidedtraining.model.NtcWorkoutItem
import br.com.wgc.design_system.templates.screens.guidedtraining.player.WgcNtcWorkoutPlayerTemplate
import br.com.wgc.design_system.templates.screens.guidedtraining.programs.WgcNtcProgramsTemplate

enum class WgcGuidedTrainingScreen {
    HOME,
    PLAYER,
    DETAIL,
    PROGRAMS,
    ACTIVITY
}

@Composable
fun WgcGuidedTrainingFactory(
    modifier: Modifier = Modifier,
    screen: WgcGuidedTrainingScreen = WgcGuidedTrainingScreen.HOME,
    user: NtcUserProfile = GuidedTrainingMockData.mockUser,
    workouts: List<NtcWorkoutItem> = GuidedTrainingMockData.mockWorkouts,
    programs: List<NtcProgramItem> = GuidedTrainingMockData.mockPrograms,
    stats: NtcActivityStats = GuidedTrainingMockData.mockStats,
    selectedWorkout: NtcWorkoutItem = GuidedTrainingMockData.mockWorkouts.first(),
    currentExerciseIndex: Int = 0,
    timeRemainingFormatted: String = "00:45",
    progressFraction: Float = 0.5f,
    isPlaying: Boolean = true,
    selectedNavItem: WgcFitnessNavItem = WgcFitnessNavItem.HOME,
    onNavItemClick: (WgcFitnessNavItem) -> Unit = {},
    onSelectWorkout: (NtcWorkoutItem) -> Unit = {},
    onStartWorkout: (NtcWorkoutItem) -> Unit = {},
    onOpenProgram: (NtcProgramItem) -> Unit = {},
    onClosePlayer: () -> Unit = {},
    onFinishWorkout: () -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotHero: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null,
    customScreenSlot: (@Composable () -> Unit)? = null
) {
    if (customScreenSlot != null) {
        customScreenSlot()
        return
    }

    when (screen) {
        WgcGuidedTrainingScreen.HOME -> {
            WgcNtcHomeTemplate(
                user = user,
                featuredWorkout = selectedWorkout,
                activeProgram = programs.firstOrNull { it.isEnrolled },
                workouts = workouts,
                modifier = modifier,
                onSelectWorkout = onSelectWorkout,
                onStartWorkout = onStartWorkout,
                onOpenProgram = onOpenProgram,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                slotHeader = slotHeader,
                slotHeroWorkout = slotHero,
                slotBottomNav = slotBottomNav
            )
        }
        WgcGuidedTrainingScreen.PLAYER -> {
            WgcNtcWorkoutPlayerTemplate(
                workout = selectedWorkout,
                currentExerciseIndex = currentExerciseIndex,
                timeRemainingFormatted = timeRemainingFormatted,
                progressFraction = progressFraction,
                isPlaying = isPlaying,
                modifier = modifier,
                onCloseClick = onClosePlayer,
                onFinishWorkout = onFinishWorkout
            )
        }
        WgcGuidedTrainingScreen.DETAIL -> {
            WgcNtcWorkoutDetailTemplate(
                workout = selectedWorkout,
                modifier = modifier,
                onBackClick = onClosePlayer,
                onStartWorkout = { onStartWorkout(selectedWorkout) },
                slotHero = slotHero
            )
        }
        WgcGuidedTrainingScreen.PROGRAMS -> {
            WgcNtcProgramsTemplate(
                programs = programs,
                modifier = modifier,
                onSelectProgram = onOpenProgram,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                slotHeader = slotHeader,
                slotBottomNav = slotBottomNav
            )
        }
        WgcGuidedTrainingScreen.ACTIVITY -> {
            WgcNtcActivityTemplate(
                stats = stats,
                modifier = modifier,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                slotHeader = slotHeader,
                slotBottomNav = slotBottomNav
            )
        }
    }
}
