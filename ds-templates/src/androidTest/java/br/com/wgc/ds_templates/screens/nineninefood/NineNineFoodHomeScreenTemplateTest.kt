package br.com.wgc.ds_templates.screens.nineninefood

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NineNineFoodHomeScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testNineNineFoodHomeScreenRenders() {
        composeTestRule.setContent {
            NineNineFoodHomeScreenTemplate(viewModel = FakeNineNineFoodHomeViewModel())
        }

        composeTestRule.onNodeWithText("99Food • Av. Paulista, 1000 - Bela Vista").assertIsDisplayed()
        composeTestRule.onNodeWithText("Restaurantes em Destaque na 99Food").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ver Sacola 99Food").assertIsDisplayed()
    }
}
