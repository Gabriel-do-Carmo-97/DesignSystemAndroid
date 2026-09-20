package br.com.wgc.design_system.templates.screens.gamingstore

data class SteamGame(val id: String, val title: String, val discount: String, val price: Double)

object GamingStoreMockData {
    val sampleGames = listOf(
        SteamGame("1", "Cyberpunk 2077: Phantom Liberty", "-50%", 99.90),
        SteamGame("2", "Elden Ring: Shadow of the Erdtree", "-20%", 159.90),
        SteamGame("3", "Counter-Strike 2", "Grátis", 0.0)
    )
}
