package br.com.wgc.ds_templates.screens.communitychat

data class CommunityChatServerItem(val id: String, val name: String, val channelsCount: Int, val activeUsers: Int)

object CommunityChatMockData {
    val sampleServers = listOf(
        CommunityChatServerItem("1", "WGC Design System Hub", 14, 120),
        CommunityChatServerItem("2", "Comunidade Kotlin BR", 25, 480),
        CommunityChatServerItem("3", "Devs da Madrugada", 10, 85)
    )
}
