package br.com.wgc.design_system.components.radio

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
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
class WgcRadioButtonTest {

    @get:Rule
    val composeRule = createComposeRule()

    private val radioLabel = "Opção 1"

    @Test
    fun wgcRadioButton_whenRendered_displaysLabel() {
        composeRule.setContent {
            WgcRadioButton(selected = false, label = radioLabel, onClick = {})
        }

        composeRule.onNodeWithText(radioLabel)
            .assertIsDisplayed()
            .assertTextEquals(radioLabel)
            .assertIsEnabled()
    }

    @Test
    fun wgcRadioButton_whenClicked_triggersOnClick() {
        val onClick = mockk<() -> Unit> {
            every { this@mockk.invoke() } just runs
        }

        composeRule.setContent {
            WgcRadioButton(selected = false, label = radioLabel, onClick = onClick)
        }

        composeRule.onNodeWithText(radioLabel)
            .performClick()

        verify(exactly = 1) { onClick() }
    }

    @Test
    fun wgcRadioButton_whenDisabled_isNotClickable() {
        val onClick = mockk<() -> Unit> {
            every { this@mockk.invoke() } just runs
        }

        composeRule.setContent {
            WgcRadioButton(selected = false, label = radioLabel, onClick = onClick, isEnabled = false)
        }

        composeRule.onNodeWithText(radioLabel)
            .assertIsNotEnabled()
            .performClick()

        verify(exactly = 0) { onClick() }
    }
}
