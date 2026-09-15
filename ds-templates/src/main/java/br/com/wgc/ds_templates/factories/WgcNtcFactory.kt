package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcNtcNavItem
import br.com.wgc.ds_templates.screens.ntc.activity.WgcNtcActivityTemplate
import br.com.wgc.ds_templates.screens.ntc.detail.WgcNtcWorkoutDetailTemplate
import br.com.wgc.ds_templates.screens.ntc.home.WgcNtcHomeTemplate
import br.com.wgc.ds_templates.screens.ntc.model.NtcActivityStats
import br.com.wgc.ds_templates.screens.ntc.model.NtcMockData
import br.com.wgc.ds_templates.screens.ntc.model.NtcProgramItem
import br.com.wgc.ds_templates.screens.ntc.model.NtcUserProfile
import br.com.wgc.ds_templates.screens.ntc.model.NtcWorkoutItem
import br.com.wgc.ds_templates.screens.ntc.player.WgcNtcWorkoutPlayerTemplate
import br.com.wgc.ds_templates.screens.ntc.programs.WgcNtcProgramsTemplate

/**
 * Telas suportadas pela Fábrica Nike Training Club (NTC).
 */
enum class WgcNtcScreen {
    HOME,
    PLAYER,
    DETAIL,
    PROGRAMS,
    ACTIVITY
}

/**
 * Fábrica Universal de Telas do Nike Training Club (WgcNtcFactory).
 *
 * Provê alternância instantânea entre as telas de treino, player guiado por áudio,
 * detalhes com roteiro muscular, programas progressivos e conquistas atléticas.
 *
 * 100% tokenizado com WgcCoreDs, State Hoisting e slots customizáveis.
 */
@Composable
fun WgcNtcFactory(
    modifier: Modifier = Modifier,
    screen: WgcNtcScreen = WgcNtcScreen.HOME,
    user: NtcUserProfile = NtcMockData.mockUser,
    workouts: List<NtcWorkoutItem> = NtcMockData.mockWorkouts,
    programs: List<NtcProgramItem> = NtcMockData.mockPrograms,
    stats: NtcActivityStats = NtcMockData.mockStats,
    selectedWorkout: NtcWorkoutItem = NtcMockData.mockWorkouts.first(),
    currentExerciseIndex: Int = 0,
    timeRemainingFormatted: String = "00:45",
    progressFraction: Float = 0.5f,
    isPlaying: Boolean = true,
    selectedNavItem: WgcNtcNavItem = WgcNtcNavItem.FOR_YOU,
    onNavItemClick: (WgcNtcNavItem) -> Unit = {},
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
        WgcNtcScreen.HOME -> {
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
        WgcNtcScreen.PLAYER -> {
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
        WgcNtcScreen.DETAIL -> {
            WgcNtcWorkoutDetailTemplate(
                workout = selectedWorkout,
                modifier = modifier,
                onBackClick = onClosePlayer,
                onStartWorkout = { onStartWorkout(selectedWorkout) },
                slotHero = slotHero
            )
        }
        WgcNtcScreen.PROGRAMS -> {
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
        WgcNtcScreen.ACTIVITY -> {
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
