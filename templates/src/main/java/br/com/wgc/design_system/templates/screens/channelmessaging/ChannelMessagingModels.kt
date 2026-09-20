package br.com.wgc.design_system.templates.screens.channelmessaging

data class TelegramChannel(val id: String, val name: String, val subscribers: String, val unread: Boolean)

object ChannelMessagingMockData {
    val sampleChannels = listOf(
        TelegramChannel("1", "Android Developers BR", "12.4k inscritos", true),
        TelegramChannel("2", "Notícias Tech em Tempo Real", "84.1k inscritos", false),
        TelegramChannel("3", "Mensagens Salvas (Cloud)", "Privado", false)
    )
}
