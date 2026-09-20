package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcEducationFactory
import br.com.wgc.design_system.templates.factories.WgcEducationScreen
import br.com.wgc.design_system.templates.factories.WgcMessagingFactory
import br.com.wgc.design_system.templates.factories.WgcMessagingScreen
import br.com.wgc.design_system.templates.factories.WgcMobilityFactory
import br.com.wgc.design_system.templates.factories.WgcMobilityScreen
import br.com.wgc.design_system.templates.factories.WgcStreamingFactory
import br.com.wgc.design_system.templates.factories.WgcStreamingScreen
import br.com.wgc.design_system.templates.factories.WgcTravelFactory
import br.com.wgc.design_system.templates.factories.WgcTravelScreen

class WgcLifestyleScreenshotsTest {

    @Preview(name = "Mobilidade - 99 Screen", showBackground = true)
    @Composable
    fun mobilityScreenPreview() {
        WgcMobilityFactory(screen = WgcMobilityScreen.NINETY_NINE)
    }

    @Preview(name = "Viagem - Hospedagem Screen", showBackground = true)
    @Composable
    fun travelScreenPreview() {
        WgcTravelFactory(screen = WgcTravelScreen.LODGING)
    }

    @Preview(name = "Streaming - Áudio Streaming Screen", showBackground = true)
    @Composable
    fun streamingScreenPreview() {
        WgcStreamingFactory(screen = WgcStreamingScreen.AUDIO)
    }

    @Preview(name = "Educação - Idiomas Screen", showBackground = true)
    @Composable
    fun educationScreenPreview() {
        WgcEducationFactory(screen = WgcEducationScreen.LANGUAGE)
    }

    @Preview(name = "Mensageria - Direct Screen", showBackground = true)
    @Composable
    fun messagingScreenPreview() {
        WgcMessagingFactory(screen = WgcMessagingScreen.DIRECT)
    }
}
