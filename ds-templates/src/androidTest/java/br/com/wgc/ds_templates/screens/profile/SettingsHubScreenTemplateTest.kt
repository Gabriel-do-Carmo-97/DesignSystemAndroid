package br.com.wgc.ds_templates.screens.profile

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SettingsHubScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSettingsHubScreenRenders() {
        composeTestRule.setContent {
            SettingsHubScreenTemplate(viewModel = FakeSettingsHubViewModel())
        }

        composeTestRule.onNodeWithText("Gabriel do Carmo").assertIsDisplayed()
        composeTestRule.onNodeWithText("Preferências").assertIsDisplayed()
        composeTestRule.onNodeWithText("Sair da Conta").assertIsDisplayed()
    }
}
