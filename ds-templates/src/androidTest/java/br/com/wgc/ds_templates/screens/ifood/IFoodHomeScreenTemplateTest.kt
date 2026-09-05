package br.com.wgc.ds_templates.screens.ifood

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IFoodHomeScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testIFoodHomeScreenRenders() {
        composeTestRule.setContent {
            IFoodHomeScreenTemplate(viewModel = FakeIFoodHomeViewModel())
        }

        composeTestRule.onNodeWithText("Rua Augusta, 1000 - Consolação").assertIsDisplayed()
        composeTestRule.onNodeWithText("Lojas e Restaurantes").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ver Carrinho").assertIsDisplayed()
    }
}
