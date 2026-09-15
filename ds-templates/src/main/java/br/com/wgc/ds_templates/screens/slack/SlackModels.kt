package br.com.wgc.ds_templates.screens.slack

data class SlackChannel(val id: String, val name: String, val topic: String, val hasUnread: Boolean)

object SlackMockData {
    val sampleChannels = listOf(
        SlackChannel("1", "# design-system-core", "Discussões de tokens e componentes", true),
        SlackChannel("2", "# releases-android", "Deploy notifications e links de build", false),
        SlackChannel("3", "# random-coffee", "Conversas gerais do time", false)
    )
}
