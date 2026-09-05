package br.com.wgc.ds_templates.screens.home.fintech

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FintechHomeScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testFintechHomeScreenRenders() {
        composeTestRule.setContent {
            FintechHomeScreenTemplate(viewModel = FakeFintechHomeViewModel())
        }

        composeTestRule.onNodeWithText("Olá, Gabriel").assertIsDisplayed()
        composeTestRule.onNodeWithText("R$ 12.450,00").assertIsDisplayed()
        composeTestRule.onNodeWithText("Últimas Transações").assertIsDisplayed()
    }
}
