package br.com.wgc.design_system.components.alert

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WgcAlertTest {

    @get:Rule
    val composeRule = createComposeRule()

    private val alertTitle = "Atenção"
    private val alertMessage = "Mensagem de teste do alerta."

    @Test
    fun wgcAlert_whenRendered_displaysTitleAndMessage() {
        composeRule.setContent {
            WgcAlert(
                title = alertTitle,
                message = alertMessage,
                type = AlertType.WARNING
            )
        }

        composeRule.onNodeWithText(alertTitle).assertIsDisplayed()
        composeRule.onNodeWithText(alertMessage).assertIsDisplayed()
    }

    @Test
    fun wgcAlert_whenDismissClicked_triggersOnDismiss() {
        val onDismiss = mockk<() -> Unit> {
            every { this@mockk.invoke() } just runs
        }

        composeRule.setContent {
            WgcAlert(
                title = alertTitle,
                message = alertMessage,
                type = AlertType.SUCCESS,
                onDismiss = onDismiss
            )
        }

        composeRule.onNodeWithContentDescription("Fechar alerta")
            .assertIsDisplayed()
            .performClick()

        verify(exactly = 1) { onDismiss() }
    }
}
