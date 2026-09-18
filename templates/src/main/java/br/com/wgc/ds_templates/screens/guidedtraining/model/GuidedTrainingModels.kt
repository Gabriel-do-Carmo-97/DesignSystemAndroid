package br.com.wgc.ds_templates.screens.guidedtraining.model

import br.com.wgc.design_system.components.cards.WgcFitnessWorkoutCategory
import br.com.wgc.design_system.components.cards.WgcFitnessWorkoutIntensity

/**
 * Modelo de Exercício individual dentro de um Treino NTC.
 */
data class NtcExerciseItem(
    val id: String,
    val name: String,
    val durationSeconds: Int,
    val reps: Int? = null,
    val coachTip: String,
    val muscleGroup: String
)

/**
 * Modelo de Treino NTC guiado por instrutor.
 */
data class NtcWorkoutItem(
    val id: String,
    val title: String,
    val trainerName: String,
    val category: WgcFitnessWorkoutCategory,
    val durationMinutes: Int,
    val intensity: WgcFitnessWorkoutIntensity,
    val equipment: String,
    val estimatedCalories: Int,
    val description: String,
    val isSaved: Boolean = false,
    val exercises: List<NtcExerciseItem> = emptyList()
)

/**
 * Modelo de Programa de Treinamento Multi-semanas NTC.
 */
data class NtcProgramItem(
    val id: String,
    val title: String,
    val goal: String,
    val trainerName: String,
    val totalWeeks: Int,
    val currentWeek: Int,
    val completedWorkouts: Int,
    val totalWorkouts: Int,
    val isEnrolled: Boolean,
    val overview: String
)

/**
 * Modelo de Conquista / Medalha do Atleta NTC.
 */
data class NtcBadgeItem(
    val id: String,
    val title: String,
    val description: String,
    val achievedDate: String,
    val isUnlocked: Boolean = true
)

/**
 * Estatísticas e Atividades do Atleta NTC.
 */
data class NtcActivityStats(
    val weeklyMinutes: Int,
    val weeklyGoalMinutes: Int,
    val weeklyCalories: Int,
    val workoutsThisWeek: Int,
    val currentStreakDays: Int,
    val totalWorkoutsAllTime: Int,
    val badges: List<NtcBadgeItem>
)

/**
 * Perfil do Atleta Nike Training Club.
 */
data class NtcUserProfile(
    val name: String,
    val athleteLevel: String,
    val currentStreakDays: Int,
    val weeklyMinutesProgress: Int,
    val weeklyMinutesGoal: Int
)

/**
 * Dados Mockados Oficiais para as Telas Nike Training Club.
 */
object GuidedTrainingMockData {
    val mockUser = NtcUserProfile(
        name = "Gabriel do Carmo",
        athleteLevel = "Atleta Pro • Nível 3",
        currentStreakDays = 14,
        weeklyMinutesProgress = 145,
        weeklyMinutesGoal = 180
    )

    val mockExercises = listOf(
        NtcExerciseItem(
            id = "ex_1",
            name = "Polichinelos Dinâmicos",
            durationSeconds = 45,
            coachTip = "Abra bem os braços e mantenha um ritmo constante para aquecer os ombros e pernas.",
            muscleGroup = "Cardio & Corpo Inteiro"
        ),
        NtcExerciseItem(
            id = "ex_2",
            name = "Agachamentos com Salto",
            durationSeconds = 40,
            coachTip = "Desça com o quadril para trás e exploda para cima aterrissando suavemente.",
            muscleGroup = "Pernas & Glúteos"
        ),
        NtcExerciseItem(
            id = "ex_3",
            name = "Mountain Climbers",
            durationSeconds = 45,
            coachTip = "Puxe os joelhos em direção ao peito alternadamente mantendo as costas retas.",
            muscleGroup = "Core & Resistência"
        ),
        NtcExerciseItem(
            id = "ex_4",
            name = "Flexões com Rotação T",
            durationSeconds = 40,
            coachTip = "Faça a flexão completa e, ao subir, gire o tronco estendendo o braço em direção ao teto.",
            muscleGroup = "Peitoral, Ombros & Core"
        ),
        NtcExerciseItem(
            id = "ex_5",
            name = "Prancha Isométrica",
            durationSeconds = 60,
            coachTip = "Contraia glúteos e abdômen, sem deixar a lombar arquear.",
            muscleGroup = "Core Total"
        ),
        NtcExerciseItem(
            id = "ex_6",
            name = "Burpees com Salto Volt",
            durationSeconds = 45,
            coachTip = "Mantenha o foco mental e respire fundo em cada repetição.",
            muscleGroup = "Alta Intensidade / Cardio"
        )
    )

    val mockWorkouts = listOf(
        NtcWorkoutItem(
            id = "ntc_w1",
            title = "Queima Metabólica Rápida",
            trainerName = "Kirsty Godso",
            category = WgcFitnessWorkoutCategory.HIIT,
            durationMinutes = 20,
            intensity = WgcFitnessWorkoutIntensity.HIGH,
            equipment = "Sem equipamentos",
            estimatedCalories = 240,
            description = "Sequência HIIT explosiva de alta queima para acelerar o metabolismo e fortalecer o core sem usar pesos.",
            isSaved = true,
            exercises = mockExercises
        ),
        NtcWorkoutItem(
            id = "ntc_w2",
            title = "Força Total e Densidade Muscular",
            trainerName = "Betina Gozo",
            category = WgcFitnessWorkoutCategory.STRENGTH,
            durationMinutes = 35,
            intensity = WgcFitnessWorkoutIntensity.HIGH,
            equipment = "Halteres médios",
            estimatedCalories = 320,
            description = "Foco em hipertrofia funcional com movimentos compostos para pernas, peito e costas.",
            isSaved = false,
            exercises = mockExercises
        ),
        NtcWorkoutItem(
            id = "ntc_w3",
            title = "Yoga Restaurativo & Respiração",
            trainerName = "Jonah Kest",
            category = WgcFitnessWorkoutCategory.YOGA,
            durationMinutes = 25,
            intensity = WgcFitnessWorkoutIntensity.LOW,
            equipment = "Tapete de Yoga",
            estimatedCalories = 110,
            description = "Fluxo restaurador focado em abertura de quadris, descompressão da coluna e relaxamento ativo.",
            isSaved = true,
            exercises = mockExercises
        ),
        NtcWorkoutItem(
            id = "ntc_w4",
            title = "Mobilidade Essencial para Corredores",
            trainerName = "Cory Wharton-Malcolm",
            category = WgcFitnessWorkoutCategory.MOBILITY,
            durationMinutes = 18,
            intensity = WgcFitnessWorkoutIntensity.MODERATE,
            equipment = "Sem equipamentos",
            estimatedCalories = 95,
            description = "Melhore sua amplitude de movimento nos tornozelos, flexores do quadril e panturrilhas.",
            isSaved = false,
            exercises = mockExercises
        )
    )

    val mockPrograms = listOf(
        NtcProgramItem(
            id = "prog_1",
            title = "4 Semanas para Força Funcional",
            goal = "Aumento de força e resistência com peso corporal",
            trainerName = "Betina Gozo & Kirsty Godso",
            totalWeeks = 4,
            currentWeek = 2,
            completedWorkouts = 6,
            totalWorkouts = 16,
            isEnrolled = true,
            overview = "Um programa progressivo de 4 semanas projetado para desenvolver potência atlética e queimar gordura de forma consistente."
        ),
        NtcProgramItem(
            id = "prog_2",
            title = "Guia do Corredor Ágil",
            goal = "Condicionamento neuromuscular e prevenção de lesões",
            trainerName = "Chris Bennett (Coach Bennett)",
            totalWeeks = 6,
            currentWeek = 1,
            completedWorkouts = 0,
            totalWorkouts = 24,
            isEnrolled = false,
            overview = "Exercícios complementares de força e mobilidade essenciais para quem busca bater novos recordes nos 5k e 10k."
        ),
        NtcProgramItem(
            id = "prog_3",
            title = "Fundamentos do Yoga e Flexibilidade",
            goal = "Alinhamento postural e equilíbrio corporal",
            trainerName = "Brandee Evans",
            totalWeeks = 3,
            currentWeek = 1,
            completedWorkouts = 0,
            totalWorkouts = 12,
            isEnrolled = false,
            overview = "Aprenda as posturas clássicas de Vinyasa e cultive estabilidade mental e física."
        )
    )

    val mockBadges = listOf(
        NtcBadgeItem(
            id = "b1",
            title = "Sequência de Fogo (14 Dias)",
            description = "Completou 14 dias seguidos de treinos e mobilidade.",
            achievedDate = "Hoje"
        ),
        NtcBadgeItem(
            id = "b2",
            title = "Mestre do HIIT",
            description = "Concluiu 25 treinos de alta intensidade na zona vermelha.",
            achievedDate = "Semana passada"
        ),
        NtcBadgeItem(
            id = "b3",
            title = "Superação de 10.000 Minutos",
            description = "Atingiu a marca de 10.000 minutos totais de movimento guiado.",
            achievedDate = "Mês passado"
        ),
        NtcBadgeItem(
            id = "b4",
            title = "Madrugador Volt",
            description = "Completou 10 treinos antes das 07:00 da manhã.",
            achievedDate = "3 meses atrás"
        )
    )

    val mockStats = NtcActivityStats(
        weeklyMinutes = 145,
        weeklyGoalMinutes = 180,
        weeklyCalories = 1680,
        workoutsThisWeek = 4,
        currentStreakDays = 14,
        totalWorkoutsAllTime = 128,
        badges = mockBadges
    )
}
