package br.com.wgc.ds_templates.screens.register.car

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.wgc.ds_templates.screens.register.car.screen.RegisterCarScreenTemplate
import br.com.wgc.ds_templates.screens.register.car.viewmodel.FakeRegisterCarViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterCarScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRegisterCarScreenRenders() {
        composeTestRule.setContent {
            RegisterCarScreenTemplate(viewModel = FakeRegisterCarViewModel())
        }

        composeTestRule.onNodeWithText("Continuar").assertIsDisplayed()
    }
}
