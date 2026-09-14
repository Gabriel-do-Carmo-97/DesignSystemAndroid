package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcSmartFitNavItem
import br.com.wgc.ds_templates.screens.smartfit.classes.WgcSmartFitClassesTemplate
import br.com.wgc.ds_templates.screens.smartfit.go.WgcSmartFitGoVideoTemplate
import br.com.wgc.ds_templates.screens.smartfit.home.WgcSmartFitHomeTemplate
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitClass
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitGymUnit
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitMockData
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitUserProfile
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitVideoWorkout
import br.com.wgc.ds_templates.screens.smartfit.model.SmartFitWorkoutRoutine
import br.com.wgc.ds_templates.screens.smartfit.profile.WgcSmartFitProfilePassTemplate
import br.com.wgc.ds_templates.screens.smartfit.workouts.WgcSmartFitWorkoutRoutineTemplate

/**
 * Variantes de Telas suportadas pela Fábrica Smart Fit.
 */
enum class WgcSmartFitScreen {
    Home,
    Workouts,
    Classes,
    GoVideos,
    ProfilePass
}

/**
 * Fábrica Universal do ecossistema Smart Fit (WgcSmartFitFactory).
 *
 * Fornece ponto de entrada único para inicialização de qualquer tela Smart Fit
 * com Sensible Defaults prontos para produção e slots customizáveis.
 *
 * Em conformidade com a Regra 6 do AGENTS.md.
 */
object WgcSmartFitFactory {

    @Composable
    fun Screen(
        screen: WgcSmartFitScreen,
        modifier: Modifier = Modifier,
        user: SmartFitUserProfile = SmartFitMockData.mockUser,
        currentUnit: SmartFitGymUnit = SmartFitMockData.mockUnits.first(),
        routines: List<SmartFitWorkoutRoutine> = SmartFitMockData.mockRoutines,
        selectedRoutineIndex: Int = 0,
        classes: List<SmartFitClass> = SmartFitMockData.mockClasses,
        selectedDayIndex: Int = 0,
        selectedCategoryIndex: Int = 0,
        videos: List<SmartFitVideoWorkout> = SmartFitMockData.mockGoVideos,
        onNavigateScreen: ((WgcSmartFitScreen) -> Unit)? = null,
        onSelectRoutine: (Int) -> Unit = {},
        onSelectDay: (Int) -> Unit = {},
        onSelectCategory: (Int) -> Unit = {},
        onToggleExercise: ((exerciseId: String, completed: Boolean) -> Unit)? = null,
        onToggleBooking: ((classId: String, booked: Boolean) -> Unit)? = null,
        onSelectVideo: ((SmartFitVideoWorkout) -> Unit)? = null,
        onRefreshQr: () -> Unit = {},
        onCheckIn: () -> Unit = {},
        slotHeader: (@Composable () -> Unit)? = null,
        slotBottomNav: (@Composable () -> Unit)? = null
    ) {
        when (screen) {
            WgcSmartFitScreen.Home -> {
                WgcSmartFitHomeTemplate(
                    user = user,
                    currentUnit = currentUnit,
                    todayRoutine = routines.getOrNull(selectedRoutineIndex) ?: routines.first(),
                    modifier = modifier,
                    onOpenQrPass = { onNavigateScreen?.invoke(WgcSmartFitScreen.ProfilePass) },
                    onOpenWorkouts = { onNavigateScreen?.invoke(WgcSmartFitScreen.Workouts) },
                    onOpenClasses = { onNavigateScreen?.invoke(WgcSmartFitScreen.Classes) },
                    onOpenGoVideos = { onNavigateScreen?.invoke(WgcSmartFitScreen.GoVideos) },
                    selectedNavItem = WgcSmartFitNavItem.HOME,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcSmartFitNavItem.HOME -> onNavigateScreen?.invoke(WgcSmartFitScreen.Home)
                            WgcSmartFitNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcSmartFitScreen.Workouts)
                            WgcSmartFitNavItem.CLASSES -> onNavigateScreen?.invoke(WgcSmartFitScreen.Classes)
                            WgcSmartFitNavItem.GO -> onNavigateScreen?.invoke(WgcSmartFitScreen.GoVideos)
                            WgcSmartFitNavItem.PROFILE -> onNavigateScreen?.invoke(WgcSmartFitScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcSmartFitScreen.Workouts -> {
                WgcSmartFitWorkoutRoutineTemplate(
                    routines = routines,
                    selectedRoutineIndex = selectedRoutineIndex,
                    onSelectRoutine = onSelectRoutine,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcSmartFitScreen.Home) },
                    onToggleExercise = onToggleExercise,
                    selectedNavItem = WgcSmartFitNavItem.WORKOUTS,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcSmartFitNavItem.HOME -> onNavigateScreen?.invoke(WgcSmartFitScreen.Home)
                            WgcSmartFitNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcSmartFitScreen.Workouts)
                            WgcSmartFitNavItem.CLASSES -> onNavigateScreen?.invoke(WgcSmartFitScreen.Classes)
                            WgcSmartFitNavItem.GO -> onNavigateScreen?.invoke(WgcSmartFitScreen.GoVideos)
                            WgcSmartFitNavItem.PROFILE -> onNavigateScreen?.invoke(WgcSmartFitScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcSmartFitScreen.Classes -> {
                WgcSmartFitClassesTemplate(
                    classes = classes,
                    selectedDayIndex = selectedDayIndex,
                    onSelectDay = onSelectDay,
                    selectedCategoryIndex = selectedCategoryIndex,
                    onSelectCategory = onSelectCategory,
                    modifier = modifier,
                    unitName = currentUnit.name,
                    onBackClick = { onNavigateScreen?.invoke(WgcSmartFitScreen.Home) },
                    onToggleBooking = onToggleBooking,
                    selectedNavItem = WgcSmartFitNavItem.CLASSES,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcSmartFitNavItem.HOME -> onNavigateScreen?.invoke(WgcSmartFitScreen.Home)
                            WgcSmartFitNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcSmartFitScreen.Workouts)
                            WgcSmartFitNavItem.CLASSES -> onNavigateScreen?.invoke(WgcSmartFitScreen.Classes)
                            WgcSmartFitNavItem.GO -> onNavigateScreen?.invoke(WgcSmartFitScreen.GoVideos)
                            WgcSmartFitNavItem.PROFILE -> onNavigateScreen?.invoke(WgcSmartFitScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcSmartFitScreen.GoVideos -> {
                WgcSmartFitGoVideoTemplate(
                    videos = videos,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcSmartFitScreen.Home) },
                    onSelectVideo = onSelectVideo,
                    selectedNavItem = WgcSmartFitNavItem.GO,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcSmartFitNavItem.HOME -> onNavigateScreen?.invoke(WgcSmartFitScreen.Home)
                            WgcSmartFitNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcSmartFitScreen.Workouts)
                            WgcSmartFitNavItem.CLASSES -> onNavigateScreen?.invoke(WgcSmartFitScreen.Classes)
                            WgcSmartFitNavItem.GO -> onNavigateScreen?.invoke(WgcSmartFitScreen.GoVideos)
                            WgcSmartFitNavItem.PROFILE -> onNavigateScreen?.invoke(WgcSmartFitScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcSmartFitScreen.ProfilePass -> {
                WgcSmartFitProfilePassTemplate(
                    user = user,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcSmartFitScreen.Home) },
                    onRefreshQr = onRefreshQr,
                    onCheckIn = onCheckIn,
                    selectedNavItem = WgcSmartFitNavItem.PROFILE,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcSmartFitNavItem.HOME -> onNavigateScreen?.invoke(WgcSmartFitScreen.Home)
                            WgcSmartFitNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcSmartFitScreen.Workouts)
                            WgcSmartFitNavItem.CLASSES -> onNavigateScreen?.invoke(WgcSmartFitScreen.Classes)
                            WgcSmartFitNavItem.GO -> onNavigateScreen?.invoke(WgcSmartFitScreen.GoVideos)
                            WgcSmartFitNavItem.PROFILE -> onNavigateScreen?.invoke(WgcSmartFitScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
        }
    }
}
