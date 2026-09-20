package br.com.wgc.design_system.templates.screens.marketplacescreen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MarketplaceHomeScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMarketplaceHomeScreenRenders() {
        composeTestRule.setContent {
            WgcMarketplaceHomeScreenTemplate(viewModel = FakeMarketplaceHomeViewModel())
        }

        composeTestRule.onNodeWithText("Enviar para Gabriel - Rua Augusta 1000").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ofertas do Dia ⚡").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ver todas").assertIsDisplayed()
    }
}
