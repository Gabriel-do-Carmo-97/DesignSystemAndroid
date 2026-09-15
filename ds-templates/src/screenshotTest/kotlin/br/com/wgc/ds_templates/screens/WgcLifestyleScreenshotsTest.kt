package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcEducationFactory
import br.com.wgc.ds_templates.factories.WgcEducationScreen
import br.com.wgc.ds_templates.factories.WgcMessagingFactory
import br.com.wgc.ds_templates.factories.WgcMessagingScreen
import br.com.wgc.ds_templates.factories.WgcMobilityFactory
import br.com.wgc.ds_templates.factories.WgcMobilityScreen
import br.com.wgc.ds_templates.factories.WgcStreamingFactory
import br.com.wgc.ds_templates.factories.WgcStreamingScreen
import br.com.wgc.ds_templates.factories.WgcTravelFactory
import br.com.wgc.ds_templates.factories.WgcTravelScreen

class WgcLifestyleScreenshotsTest {

    @Preview(name = "Mobilidade - 99 Screen", showBackground = true)
    @Composable
    fun mobilityScreenPreview() {
        WgcMobilityFactory(screen = WgcMobilityScreen.NINETY_NINE)
    }

    @Preview(name = "Viagem - Airbnb Screen", showBackground = true)
    @Composable
    fun travelScreenPreview() {
        WgcTravelFactory(screen = WgcTravelScreen.AIRBNB)
    }

    @Preview(name = "Streaming - Spotify Screen", showBackground = true)
    @Composable
    fun streamingScreenPreview() {
        WgcStreamingFactory(screen = WgcStreamingScreen.SPOTIFY)
    }

    @Preview(name = "Educação - Duolingo Screen", showBackground = true)
    @Composable
    fun educationScreenPreview() {
        WgcEducationFactory(screen = WgcEducationScreen.DUOLINGO)
    }

    @Preview(name = "Mensageria - WhatsApp Screen", showBackground = true)
    @Composable
    fun messagingScreenPreview() {
        WgcMessagingFactory(screen = WgcMessagingScreen.WHATSAPP)
    }
}
