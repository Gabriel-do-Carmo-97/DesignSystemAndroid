package br.com.wgc.design_system.templates.screens.directmessaging

data class WhatsAppChat(val id: String, val name: String, val lastMessage: String, val time: String, val unreadCount: Int = 0)

object WhatsAppMockData {
    val sampleChats = listOf(
        WhatsAppChat("1", "Família Carmo ❤️", "Mãe: O almoço no domingo tá de pé?", "15:42", 3),
        WhatsAppChat("2", "Tech Lead Squad WGC", "Reunião de release aprovada!", "14:10", 0),
        WhatsAppChat("3", "Mariana", "Fechado! Te encontro lá!", "11:25", 1)
    )
}
