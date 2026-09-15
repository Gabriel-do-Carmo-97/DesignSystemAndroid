package br.com.wgc.ds_templates.screens.spotify

data class SpotifyTrack(val id: String, val title: String, val artist: String, val duration: String)

object SpotifyMockData {
    val sampleTracks = listOf(
        SpotifyTrack("1", "Blinding Lights", "The Weeknd", "3:20"),
        SpotifyTrack("2", "As It Was", "Harry Styles", "2:47"),
        SpotifyTrack("3", "Flowers", "Miley Cyrus", "3:20")
    )
}
