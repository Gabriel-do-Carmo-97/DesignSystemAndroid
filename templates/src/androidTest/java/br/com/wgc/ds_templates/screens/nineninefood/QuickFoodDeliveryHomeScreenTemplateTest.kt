package br.com.wgc.ds_templates.screens.quickfooddelivery

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QuickFoodDeliveryHomeScreenTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testQuickFoodDeliveryHomeScreenRenders() {
        composeTestRule.setContent {
            WgcQuickFoodDeliveryHomeScreenTemplate(viewModel = FakeQuickFoodDeliveryHomeViewModel())
        }

        composeTestRule.onNodeWithText("Restaurantes em Destaque").assertIsDisplayed()
    }
}
