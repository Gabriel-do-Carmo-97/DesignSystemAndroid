package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.categories.WgcEducationFactory
import br.com.wgc.design_system.factories.categories.WgcEducationScreen
import br.com.wgc.design_system.factories.categories.WgcMessagingFactory
import br.com.wgc.design_system.factories.categories.WgcMessagingScreen
import br.com.wgc.design_system.factories.categories.WgcMobilityFactory
import br.com.wgc.design_system.factories.categories.WgcMobilityScreen
import br.com.wgc.design_system.factories.categories.WgcStreamingFactory
import br.com.wgc.design_system.factories.categories.WgcStreamingScreen
import br.com.wgc.design_system.factories.categories.WgcTravelFactory
import br.com.wgc.design_system.factories.categories.WgcTravelScreen

class WgcLifestyleScreenshotsTest {

    @Preview(name = "Mobilidade - 99 Screen", showBackground = true)
    @Composable
    fun mobilityScreenPreview() {
        WgcMobilityFactory(screen = WgcMobilityScreen.URBAN)
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
