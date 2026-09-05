package br.com.wgc.ds_templates.screens.map

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RealtimeLocationMapScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRealtimeLocationMapScreenRenders() {
        composeTestRule.setContent {
            RealtimeLocationMapScreenTemplate(viewModel = FakeRealtimeLocationViewModel())
        }

        composeTestRule.onNodeWithText("Entregador a 5 min de distância").assertIsDisplayed()
        composeTestRule.onNodeWithText("Entrar em Contato").assertIsDisplayed()
    }
}
