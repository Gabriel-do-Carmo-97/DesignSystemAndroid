package br.com.wgc.ds_templates.screens.register.address

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.wgc.ds_templates.screens.register.address.screen.RegisterAddressScreenTemplate
import br.com.wgc.ds_templates.screens.register.address.viewmodel.FakeRegisterAddressVIewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterAddressScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRegisterAddressScreenRenders() {
        composeTestRule.setContent {
            RegisterAddressScreenTemplate(viewModel = FakeRegisterAddressVIewModel())
        }

        composeTestRule.onNodeWithText("Continuar").assertIsDisplayed()
    }
}
