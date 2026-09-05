package br.com.wgc.ds_templates.screens.resetpassword

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.wgc.ds_templates.screens.resetpassword.screen.ResetPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.resetpassword.viewmodel.FakeResetPasswordViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ResetPasswordTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testResetPasswordScreenRenders() {
        composeTestRule.setContent {
            ResetPasswordScreenTemplate(viewModel = FakeResetPasswordViewModel())
        }

        composeTestRule.onNodeWithText("Recuperar Senha").assertIsDisplayed()
    }
}
