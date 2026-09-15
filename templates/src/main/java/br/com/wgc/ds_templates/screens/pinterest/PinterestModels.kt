package br.com.wgc.ds_templates.screens.pinterest

data class PinterestPin(val id: String, val title: String, val author: String, val saves: Int)

object PinterestMockData {
    val samplePins = listOf(
        PinterestPin("1", "Design System Minimalista 2026", "UI Trends", 1420),
        PinterestPin("2", "Ideias para Home Office Moderno", "Decor Inspiration", 3890),
        PinterestPin("3", "Fotografia Urbana São Paulo", "Street Photography", 890)
    )
}
