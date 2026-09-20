package br.com.wgc.design_system.templates.screens.languagelearning

data class DuolingoLesson(val id: String, val title: String, val level: Int, val isCompleted: Boolean, val xp: Int)

object LanguageLearningMockData {
    val sampleLessons = listOf(
        DuolingoLesson("1", "Saudações & Apresentações", 3, true, 25),
        DuolingoLesson("2", "No Restaurante • Pedindo Comida", 2, true, 20),
        DuolingoLesson("3", "Viagens & Direções", 1, false, 30),
        DuolingoLesson("4", "Família & Amigos", 0, false, 25)
    )
}
