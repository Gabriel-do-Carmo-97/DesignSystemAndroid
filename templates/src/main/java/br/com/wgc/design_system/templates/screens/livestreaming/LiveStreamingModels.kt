package br.com.wgc.design_system.templates.screens.livestreaming

data class TwitchStreamer(val id: String, val streamer: String, val game: String, val viewers: String)

object LiveStreamingMockData {
    val sampleLive = listOf(
        TwitchStreamer("1", "Gaules", "Counter-Strike 2 • Major", "48.2K"),
        TwitchStreamer("2", "Alanzoka", "Resident Evil Requiem", "31.5K"),
        TwitchStreamer("3", "Cellbit", "Enigma do Medo", "22.8K")
    )
}
