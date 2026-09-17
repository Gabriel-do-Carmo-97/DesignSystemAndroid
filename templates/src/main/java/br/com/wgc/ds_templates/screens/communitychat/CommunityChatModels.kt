package br.com.wgc.ds_templates.screens.communitychat

data class DiscordServer(val id: String, val name: String, val channelsCount: Int, val activeUsers: Int)

object CommunityChatMockData {
    val sampleServers = listOf(
        DiscordServer("1", "WGC Design System Hub", 14, 120),
        DiscordServer("2", "Comunidade Kotlin BR", 25, 480),
        DiscordServer("3", "Devs da Madrugada", 10, 85)
    )
}
