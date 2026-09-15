package br.com.wgc.ds_templates.screens.mercadolivre

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MercadoLivreHomeScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMercadoLivreHomeScreenRenders() {
        composeTestRule.setContent {
            MercadoLivreHomeScreenTemplate(viewModel = FakeMercadoLivreHomeViewModel())
        }

        composeTestRule.onNodeWithText("Enviar para Gabriel - Rua Augusta 1000").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ofertas do Dia ⚡").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ver todas").assertIsDisplayed()
    }
}
