package br.com.wgc.ds_templates.screens.audiostreaming

data class AudioStreamTrack(val id: String, val title: String, val artist: String, val duration: String)

object AudioStreamMockData {
    val sampleTracks = listOf(
        AudioStreamTrack("1", "Blinding Lights", "The Weeknd", "3:20"),
        AudioStreamTrack("2", "As It Was", "Harry Styles", "2:47"),
        AudioStreamTrack("3", "Flowers", "Miley Cyrus", "3:20")
    )
}
