package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcPharmacyChainFactory
import br.com.wgc.design_system.templates.factories.WgcPharmacyChainScreen
import br.com.wgc.design_system.templates.factories.WgcCarePharmacyFactory
import br.com.wgc.design_system.templates.factories.WgcCarePharmacyScreen
import br.com.wgc.design_system.templates.factories.WgcPopularPharmacyFactory
import br.com.wgc.design_system.templates.factories.WgcPopularPharmacyScreen

class WgcPharmaScreenshotsTest {

    @Preview(name = "Pharmacy Chain - Home Screen", showBackground = true)
    @Composable
    fun pharmacyChainHomeScreenPreview() {
        WgcPharmacyChainFactory(screen = WgcPharmacyChainScreen.HOME)
    }

    @Preview(name = "Care Pharmacy - Home Screen", showBackground = true)
    @Composable
    fun carePharmacyHomeScreenPreview() {
        WgcCarePharmacyFactory(screen = WgcCarePharmacyScreen.HOME)
    }

    @Preview(name = "Popular Pharmacy - Home Screen", showBackground = true)
    @Composable
    fun popularPharmacyHomeScreenPreview() {
        WgcPopularPharmacyFactory(screen = WgcPopularPharmacyScreen.HOME)
    }
}
