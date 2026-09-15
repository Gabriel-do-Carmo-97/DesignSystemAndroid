package br.com.wgc.ds_templates.screens.cart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StandardCartScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testStandardCartScreenRenders() {
        composeTestRule.setContent {
            StandardCartScreenTemplate(viewModel = FakeStandardCartViewModel())
        }

        composeTestRule.onNodeWithText("Meu Carrinho").assertIsDisplayed()
        composeTestRule.onNodeWithText("Finalizar Compra").assertIsDisplayed()
    }
}
