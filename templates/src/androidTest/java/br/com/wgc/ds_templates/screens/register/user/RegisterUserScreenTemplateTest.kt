package br.com.wgc.ds_templates.screens.register.user

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.wgc.ds_templates.screens.register.user.screen.RegisterUserScreenTemplate
import br.com.wgc.ds_templates.screens.register.user.viewmodel.FakeUserViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterUserScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRegisterUserScreenRenders() {
        composeTestRule.setContent {
            RegisterUserScreenTemplate(viewModel = FakeUserViewModel())
        }

        composeTestRule.onNodeWithText("Continuar").assertIsDisplayed()
    }
}
