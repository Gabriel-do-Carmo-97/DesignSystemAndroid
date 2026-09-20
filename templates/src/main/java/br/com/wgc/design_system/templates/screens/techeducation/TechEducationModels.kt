package br.com.wgc.design_system.templates.screens.techeducation

data class AluraCourse(val id: String, val title: String, val track: String, val durationHours: Int, val progressPercent: Int)

object TechEducationMockData {
    val sampleCourses = listOf(
        AluraCourse("1", "Kotlin Coroutines & Flow: Assincronismo no Android", "Mobile Android", 10, 65),
        AluraCourse("2", "Jetpack Compose: Construindo UIs Modernas", "Mobile Android", 12, 100),
        AluraCourse("3", "Clean Architecture com Kotlin Multiplatform", "Arquitetura", 14, 20)
    )
}
