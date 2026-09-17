package br.com.wgc.ds_templates.screens.gymfitness.model

import br.com.wgc.design_system.components.cards.WgcGymFitnessCrowdLevel

/**
 * Modelo de Exercício de Treino Gym & Fitness.
 */
data class GymFitnessExercise(
    val id: String,
    val name: String,
    val muscleGroup: String,
    val sets: Int,
    val reps: Int,
    val weightKg: Double,
    val restSeconds: Int = 60,
    val isCompleted: Boolean = false,
    val instructions: String = "Mantenha a postura ereta e contraia o abdômen durante toda a execução."
)

/**
 * Ficha de Treino (Treino A, B, C, etc.).
 */
data class GymFitnessWorkoutRoutine(
    val id: String,
    val letter: String,
    val title: String,
    val focus: String,
    val estimatedMinutes: Int,
    val exercises: List<GymFitnessExercise>
) {
    val completedCount: Int get() = exercises.count { it.isCompleted }
    val totalCount: Int get() = exercises.size
    val progressPercentage: Float get() = if (totalCount > 0) completedCount.toFloat() / totalCount else 0f
}

/**
 * Unidade da Rede Gym & Fitness.
 */
data class GymFitnessGymUnit(
    val id: String,
    val name: String,
    val address: String,
    val distance: String,
    val operatingHours: String,
    val crowdLevel: WgcGymFitnessCrowdLevel,
    val crowdPercentage: Int,
    val hourlyDistribution: List<Float>,
    val amenities: List<String>
)

/**
 * Aula Coletiva na Grade da Unidade.
 */
data class GymFitnessClass(
    val id: String,
    val title: String,
    val instructor: String,
    val time: String,
    val durationMinutes: Int,
    val room: String,
    val spotsLeft: Int,
    val totalSpots: Int,
    val isBooked: Boolean = false
)

/**
 * Treino sob Demanda do Gym & Fitness GO.
 */
data class GymFitnessVideoWorkout(
    val id: String,
    val title: String,
    val category: String,
    val duration: String,
    val intensity: String,
    val caloriesBurned: String,
    val trainer: String
)

/**
 * Perfil do Aluno Gym & Fitness e Carteirinha Digital Black.
 */
data class GymFitnessUserProfile(
    val name: String,
    val membershipId: String,
    val planTitle: String,
    val homeUnit: String,
    val qrCodeData: String,
    val daysTrainedThisMonth: Int,
    val monthlyGoal: Int,
    val weeklyCheckins: List<Boolean>, // Seg a Dom
    val weightKg: Double,
    val heightCm: Int
)

/**
 * Dados Mockados realistas para o ecossistema Gym & Fitness.
 */
object GymFitnessMockData {

    val mockExercisesTreinoA = listOf(
        GymFitnessExercise("1", "Supino Reto com Barra", "Peitoral Maior", 4, 10, 32.0, 60, true),
        GymFitnessExercise("2", "Supino Inclinado com Halteres", "Peitoral Superior", 4, 12, 22.0, 60, true),
        GymFitnessExercise("3", "Crucifixo na Máquina Fly", "Peitoral", 3, 15, 45.0, 45, false),
        GymFitnessExercise("4", "Desenvolvimento com Halteres", "Deltóides", 4, 10, 16.0, 60, false),
        GymFitnessExercise("5", "Elevação Lateral com Halteres", "Deltóide Lateral", 4, 12, 10.0, 45, false),
        GymFitnessExercise("6", "Tríceps Corda na Polia", "Tríceps", 4, 12, 25.0, 45, false),
        GymFitnessExercise("7", "Tríceps Testa com Barra W", "Tríceps", 3, 10, 18.0, 60, false)
    )

    val mockExercisesTreinoB = listOf(
        GymFitnessExercise("8", "Puxada Frontal Aberta", "Dorsais e Bíceps", 4, 10, 50.0, 60, false),
        GymFitnessExercise("9", "Remada Baixa Triângulo", "Costas / Rombóides", 4, 12, 45.0, 60, false),
        GymFitnessExercise("10", "Remada Curvada com Halteres", "Costas", 3, 12, 20.0, 60, false),
        GymFitnessExercise("11", "Rosca Direta Barra W", "Bíceps", 4, 10, 22.0, 45, false),
        GymFitnessExercise("12", "Rosca Martelo Alternada", "Braquial / Bíceps", 3, 12, 14.0, 45, false),
        GymFitnessExercise("13", "Encolhimento com Halteres", "Trapézio", 4, 15, 26.0, 45, false)
    )

    val mockExercisesTreinoC = listOf(
        GymFitnessExercise("14", "Leg Press 45°", "Quadríceps e Glúteos", 4, 12, 180.0, 90, false),
        GymFitnessExercise("15", "Agachamento Hack", "Quadríceps", 4, 10, 60.0, 90, false),
        GymFitnessExercise("16", "Cadeira Extensora", "Quadríceps", 4, 15, 40.0, 45, false),
        GymFitnessExercise("17", "Mesa Flexora", "Posterior de Coxa", 4, 12, 35.0, 60, false),
        GymFitnessExercise("18", "Panturrilha no Leg Press", "Panturrilhas", 4, 15, 120.0, 45, false)
    )

    val mockRoutines = listOf(
        GymFitnessWorkoutRoutine(
            id = "A",
            letter = "A",
            title = "Treino A - Peito, Ombros e Tríceps",
            focus = "Hipertrofia e Força Superior",
            estimatedMinutes = 55,
            exercises = mockExercisesTreinoA
        ),
        GymFitnessWorkoutRoutine(
            id = "B",
            letter = "B",
            title = "Treino B - Costas, Bíceps e Trapézio",
            focus = "Volume e Densidade Dorsal",
            estimatedMinutes = 50,
            exercises = mockExercisesTreinoB
        ),
        GymFitnessWorkoutRoutine(
            id = "C",
            letter = "C",
            title = "Treino C - Membros Inferiores Completo",
            focus = "Quadríceps, Posteriores e Panturrilhas",
            estimatedMinutes = 60,
            exercises = mockExercisesTreinoC
        )
    )

    val mockUnits = listOf(
        GymFitnessGymUnit(
            id = "paulista",
            name = "Gym & Fitness - Paulista Bela Cintra",
            address = "Av. Paulista, 2064 - Consolação",
            distance = "350 m",
            operatingHours = "Seg a Sex: 06h às 23h • Sáb: 08h às 17h • Dom: 08h às 14h",
            crowdLevel = WgcGymFitnessCrowdLevel.LOW,
            crowdPercentage = 28,
            hourlyDistribution = listOf(0.2f, 0.5f, 0.4f, 0.45f, 0.85f, 0.6f),
            amenities = listOf("Smart Box", "Cadeiras de Massagem", "Aulas Coletivas", "Ar Condicionado", "Wi-Fi Grátis")
        ),
        GymFitnessGymUnit(
            id = "farialima",
            name = "Gym & Fitness - Faria Lima",
            address = "Av. Brig. Faria Lima, 1485 - Pinheiros",
            distance = "1.8 km",
            operatingHours = "Seg a Sex: 06h às 23h • Sáb: 08h às 17h",
            crowdLevel = WgcGymFitnessCrowdLevel.HIGH,
            crowdPercentage = 84,
            hourlyDistribution = listOf(0.4f, 0.7f, 0.65f, 0.55f, 0.95f, 0.8f),
            amenities = listOf("Smart Box", "Smart Spa", "FitDance", "Estacionamento Conveniado")
        ),
        GymFitnessGymUnit(
            id = "vilaolimpia",
            name = "Gym & Fitness - Vila Olímpia",
            address = "Rua Gomes de Carvalho, 1507",
            distance = "3.2 km",
            operatingHours = "Seg a Sex: 06h às 23h • Sáb: 09h às 16h",
            crowdLevel = WgcGymFitnessCrowdLevel.MEDIUM,
            crowdPercentage = 52,
            hourlyDistribution = listOf(0.3f, 0.6f, 0.5f, 0.5f, 0.8f, 0.65f),
            amenities = listOf("Smart Cross", "Cadeiras de Massagem", "Aulas de Ritmos")
        )
    )

    val mockClasses = listOf(
        GymFitnessClass(
            id = "c1",
            title = "Smart Box HIIT Express",
            instructor = "Prof. Lucas Mendes",
            time = "18:00 - 18:30",
            durationMinutes = 30,
            room = "Área Smart Box",
            spotsLeft = 3,
            totalSpots = 15,
            isBooked = true
        ),
        GymFitnessClass(
            id = "c2",
            title = "FitDance Oficial",
            instructor = "Profª. Camila Rocha",
            time = "19:00 - 19:45",
            durationMinutes = 45,
            room = "Sala Coletiva 1",
            spotsLeft = 6,
            totalSpots = 25,
            isBooked = false
        ),
        GymFitnessClass(
            id = "c3",
            title = "Smart Cross Funcional",
            instructor = "Prof. Thiago Ramos",
            time = "20:00 - 20:45",
            durationMinutes = 45,
            room = "Área Funcional",
            spotsLeft = 0,
            totalSpots = 12,
            isBooked = false
        ),
        GymFitnessClass(
            id = "c4",
            title = "Pilates Solo & Postura",
            instructor = "Profª. Beatriz Silva",
            time = "07:30 - 08:15",
            durationMinutes = 45,
            room = "Sala Coletiva 2",
            spotsLeft = 8,
            totalSpots = 20,
            isBooked = false
        )
    )

    val mockGoVideos = listOf(
        GymFitnessVideoWorkout(
            id = "v1",
            title = "HIIT Queima Extrema de Gordura",
            category = "HIIT & Queima",
            duration = "22 min",
            intensity = "Avançado",
            caloriesBurned = "~310 kcal",
            trainer = "Rodrigo Sangion"
        ),
        GymFitnessVideoWorkout(
            id = "v2",
            title = "Treino de Pernas & Glúteos Sem Aparelho",
            category = "Musculação em Casa",
            duration = "30 min",
            intensity = "Intermediário",
            caloriesBurned = "~240 kcal",
            trainer = "Juliana Salimeni"
        ),
        GymFitnessVideoWorkout(
            id = "v3",
            title = "Alongamento e Mobilidade Noturna",
            category = "Alongamento & Bem-estar",
            duration = "15 min",
            intensity = "Iniciante",
            caloriesBurned = "~90 kcal",
            trainer = "Mariana Ferrão"
        ),
        GymFitnessVideoWorkout(
            id = "v4",
            title = "Core Blindado: Abdominal Intenso",
            category = "Core & Abdômen",
            duration = "18 min",
            intensity = "Intermediário",
            caloriesBurned = "~180 kcal",
            trainer = "Felipe Franco"
        )
    )

    val mockUser = GymFitnessUserProfile(
        name = "Gabriel do Carmo",
        membershipId = "SF-9843210",
        planTitle = "Plano Black",
        homeUnit = "Gym & Fitness - Paulista Bela Cintra",
        qrCodeData = "GYM_AUTH_TOKEN_78492049_GABRIEL",
        daysTrainedThisMonth = 14,
        monthlyGoal = 20,
        weeklyCheckins = listOf(true, true, true, true, false, true, false), // Seg a Sex treinou quase todos
        weightKg = 78.5,
        heightCm = 178
    )
}
