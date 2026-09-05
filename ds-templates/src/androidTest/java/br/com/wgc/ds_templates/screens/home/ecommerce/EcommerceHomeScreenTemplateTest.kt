package br.com.wgc.ds_templates.screens.home.ecommerce

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EcommerceHomeScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testEcommerceHomeScreenRenders() {
        composeTestRule.setContent {
            EcommerceHomeScreenTemplate(viewModel = FakeEcommerceHomeViewModel())
        }

        composeTestRule.onNodeWithText("Wgc Store").assertIsDisplayed()
        composeTestRule.onNodeWithText("Produtos em Destaque").assertIsDisplayed()
    }
}
