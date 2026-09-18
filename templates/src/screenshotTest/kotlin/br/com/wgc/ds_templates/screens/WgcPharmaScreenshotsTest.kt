package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcPharmacyChainFactory
import br.com.wgc.ds_templates.factories.WgcPharmacyChainScreen
import br.com.wgc.ds_templates.factories.WgcCarePharmacyFactory
import br.com.wgc.ds_templates.factories.WgcCarePharmacyScreen
import br.com.wgc.ds_templates.factories.WgcPopularPharmacyFactory
import br.com.wgc.ds_templates.factories.WgcPopularPharmacyScreen

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
