package br.com.wgc.ds_templates

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.wgc.ds_templates.screens.login.screen.LoginScreenTemplate
import br.com.wgc.ds_templates.screens.login.viewmodel.FakeLoginViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginScreenRendersSuccessfully() {
        composeTestRule.setContent {
            LoginScreenTemplate(viewModel = FakeLoginViewModel())
        }

        composeTestRule.onNodeWithText("Login").assertIsDisplayed()
        composeTestRule.onNodeWithText("Entrar").assertIsDisplayed()
    }
}
