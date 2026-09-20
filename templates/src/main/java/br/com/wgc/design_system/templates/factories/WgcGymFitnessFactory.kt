package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcGymFitnessNavItem
import br.com.wgc.design_system.templates.screens.gymfitness.classes.WgcGymFitnessClassesTemplate
import br.com.wgc.design_system.templates.screens.gymfitness.go.WgcGymFitnessGoVideoTemplate
import br.com.wgc.design_system.templates.screens.gymfitness.home.WgcGymFitnessHomeTemplate
import br.com.wgc.design_system.templates.screens.gymfitness.model.GymFitnessClass
import br.com.wgc.design_system.templates.screens.gymfitness.model.GymFitnessGymUnit
import br.com.wgc.design_system.templates.screens.gymfitness.model.GymFitnessMockData
import br.com.wgc.design_system.templates.screens.gymfitness.model.GymFitnessUserProfile
import br.com.wgc.design_system.templates.screens.gymfitness.model.GymFitnessVideoWorkout
import br.com.wgc.design_system.templates.screens.gymfitness.model.GymFitnessWorkoutRoutine
import br.com.wgc.design_system.templates.screens.gymfitness.profile.WgcGymFitnessProfilePassTemplate
import br.com.wgc.design_system.templates.screens.gymfitness.workouts.WgcGymFitnessWorkoutRoutineTemplate

/**
 * Variantes de Telas suportadas pela Fábrica Gym & Fitness.
 */
enum class WgcGymFitnessScreen {
    Home,
    Workouts,
    Classes,
    GoVideos,
    ProfilePass
}

/**
 * Fábrica Universal do ecossistema Gym & Fitness (WgcGymFitnessFactory).
 *
 * Fornece ponto de entrada único para inicialização de qualquer tela Gym & Fitness
 * com Sensible Defaults prontos para produção e slots customizáveis.
 *
 * Em conformidade com a Regra 6 do AGENTS.md.
 */
object WgcGymFitnessFactory {

    @Composable
    fun Screen(
        screen: WgcGymFitnessScreen,
        modifier: Modifier = Modifier,
        user: GymFitnessUserProfile = GymFitnessMockData.mockUser,
        currentUnit: GymFitnessGymUnit = GymFitnessMockData.mockUnits.first(),
        routines: List<GymFitnessWorkoutRoutine> = GymFitnessMockData.mockRoutines,
        selectedRoutineIndex: Int = 0,
        classes: List<GymFitnessClass> = GymFitnessMockData.mockClasses,
        selectedDayIndex: Int = 0,
        selectedCategoryIndex: Int = 0,
        videos: List<GymFitnessVideoWorkout> = GymFitnessMockData.mockGoVideos,
        onNavigateScreen: ((WgcGymFitnessScreen) -> Unit)? = null,
        onSelectRoutine: (Int) -> Unit = {},
        onSelectDay: (Int) -> Unit = {},
        onSelectCategory: (Int) -> Unit = {},
        onToggleExercise: ((exerciseId: String, completed: Boolean) -> Unit)? = null,
        onToggleBooking: ((classId: String, booked: Boolean) -> Unit)? = null,
        onSelectVideo: ((GymFitnessVideoWorkout) -> Unit)? = null,
        onRefreshQr: () -> Unit = {},
        onCheckIn: () -> Unit = {},
        slotHeader: (@Composable () -> Unit)? = null,
        slotBottomNav: (@Composable () -> Unit)? = null
    ) {
        when (screen) {
            WgcGymFitnessScreen.Home -> {
                WgcGymFitnessHomeTemplate(
                    user = user,
                    currentUnit = currentUnit,
                    todayRoutine = routines.getOrNull(selectedRoutineIndex) ?: routines.first(),
                    modifier = modifier,
                    onOpenQrPass = { onNavigateScreen?.invoke(WgcGymFitnessScreen.ProfilePass) },
                    onOpenWorkouts = { onNavigateScreen?.invoke(WgcGymFitnessScreen.Workouts) },
                    onOpenClasses = { onNavigateScreen?.invoke(WgcGymFitnessScreen.Classes) },
                    onOpenGoVideos = { onNavigateScreen?.invoke(WgcGymFitnessScreen.GoVideos) },
                    selectedNavItem = WgcGymFitnessNavItem.HOME,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcGymFitnessNavItem.HOME -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Home)
                            WgcGymFitnessNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Workouts)
                            WgcGymFitnessNavItem.CLASSES -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Classes)
                            WgcGymFitnessNavItem.GO -> onNavigateScreen?.invoke(WgcGymFitnessScreen.GoVideos)
                            WgcGymFitnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcGymFitnessScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcGymFitnessScreen.Workouts -> {
                WgcGymFitnessWorkoutRoutineTemplate(
                    routines = routines,
                    selectedRoutineIndex = selectedRoutineIndex,
                    onSelectRoutine = onSelectRoutine,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcGymFitnessScreen.Home) },
                    onToggleExercise = onToggleExercise,
                    selectedNavItem = WgcGymFitnessNavItem.WORKOUTS,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcGymFitnessNavItem.HOME -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Home)
                            WgcGymFitnessNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Workouts)
                            WgcGymFitnessNavItem.CLASSES -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Classes)
                            WgcGymFitnessNavItem.GO -> onNavigateScreen?.invoke(WgcGymFitnessScreen.GoVideos)
                            WgcGymFitnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcGymFitnessScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcGymFitnessScreen.Classes -> {
                WgcGymFitnessClassesTemplate(
                    classes = classes,
                    selectedDayIndex = selectedDayIndex,
                    onSelectDay = onSelectDay,
                    selectedCategoryIndex = selectedCategoryIndex,
                    onSelectCategory = onSelectCategory,
                    modifier = modifier,
                    unitName = currentUnit.name,
                    onBackClick = { onNavigateScreen?.invoke(WgcGymFitnessScreen.Home) },
                    onToggleBooking = onToggleBooking,
                    selectedNavItem = WgcGymFitnessNavItem.CLASSES,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcGymFitnessNavItem.HOME -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Home)
                            WgcGymFitnessNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Workouts)
                            WgcGymFitnessNavItem.CLASSES -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Classes)
                            WgcGymFitnessNavItem.GO -> onNavigateScreen?.invoke(WgcGymFitnessScreen.GoVideos)
                            WgcGymFitnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcGymFitnessScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcGymFitnessScreen.GoVideos -> {
                WgcGymFitnessGoVideoTemplate(
                    videos = videos,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcGymFitnessScreen.Home) },
                    onSelectVideo = onSelectVideo,
                    selectedNavItem = WgcGymFitnessNavItem.GO,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcGymFitnessNavItem.HOME -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Home)
                            WgcGymFitnessNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Workouts)
                            WgcGymFitnessNavItem.CLASSES -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Classes)
                            WgcGymFitnessNavItem.GO -> onNavigateScreen?.invoke(WgcGymFitnessScreen.GoVideos)
                            WgcGymFitnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcGymFitnessScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcGymFitnessScreen.ProfilePass -> {
                WgcGymFitnessProfilePassTemplate(
                    user = user,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcGymFitnessScreen.Home) },
                    onRefreshQr = onRefreshQr,
                    onCheckIn = onCheckIn,
                    selectedNavItem = WgcGymFitnessNavItem.PROFILE,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcGymFitnessNavItem.HOME -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Home)
                            WgcGymFitnessNavItem.WORKOUTS -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Workouts)
                            WgcGymFitnessNavItem.CLASSES -> onNavigateScreen?.invoke(WgcGymFitnessScreen.Classes)
                            WgcGymFitnessNavItem.GO -> onNavigateScreen?.invoke(WgcGymFitnessScreen.GoVideos)
                            WgcGymFitnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcGymFitnessScreen.ProfilePass)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
        }
    }
}
