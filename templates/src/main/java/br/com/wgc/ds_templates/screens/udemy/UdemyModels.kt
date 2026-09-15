package br.com.wgc.ds_templates.screens.udemy

data class UdemyCourse(val id: String, val title: String, val instructor: String, val rating: Double, val price: Double)

object UdemyMockData {
    val sampleCourses = listOf(
        UdemyCourse("1", "Android 15 & Jetpack Compose do Zero ao Avançado", "Jamilton Damasceno", 4.9, 39.90),
        UdemyCourse("2", "Microsserviços em Spring Boot e Docker", "Nélio Alves", 4.95, 44.90),
        UdemyCourse("3", "Figma Design System Masterclass", "Danilo Amorim", 4.85, 29.90)
    )
}
