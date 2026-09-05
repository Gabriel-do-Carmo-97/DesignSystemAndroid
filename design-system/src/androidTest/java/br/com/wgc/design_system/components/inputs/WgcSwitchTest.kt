package br.com.wgc.design_system.components.inputs

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
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
class WgcSwitchTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun wgcSwitch_whenRendered_isDisplayed() {
        composeRule.setContent {
            WgcSwitch(checked = false, onCheckedChange = {})
        }
        composeRule.onNode(hasClickAction())
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    @Test
    fun wgcSwitch_whenClicked_triggersOnCheckedChange() {
        val onCheckedChange = mockk<(Boolean) -> Unit> {
            every { this@mockk.invoke(any()) } just runs
        }

        composeRule.setContent {
            WgcSwitch(checked = false, onCheckedChange = onCheckedChange)
        }

        composeRule.onNode(hasClickAction())
            .performClick()

        verify(exactly = 1) { onCheckedChange(true) }
    }

    @Test
    fun wgcSwitch_whenDisabled_cannotBeClicked() {
        val onCheckedChange = mockk<(Boolean) -> Unit> {
            every { this@mockk.invoke(any()) } just runs
        }

        composeRule.setContent {
            WgcSwitch(checked = false, onCheckedChange = onCheckedChange, isEnabled = false)
        }

        composeRule.onNode(hasClickAction())
            .assertIsNotEnabled()
            .performClick()

        verify(exactly = 0) { onCheckedChange(any()) }
    }
}
