package br.com.wgc.design_system.components.chip

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
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
class WgcChipTest {

    @get:Rule
    val composeRule = createComposeRule()

    private val chipLabel = "Filtro Ativo"

    @Test
    fun wgcChip_whenRendered_displaysLabel() {
        composeRule.setContent {
            WgcChip(label = chipLabel, selected = true, onClick = {})
        }

        composeRule.onNodeWithText(chipLabel)
            .assertIsDisplayed()
            .assertTextEquals(chipLabel)
            .assertIsEnabled()
    }

    @Test
    fun wgcChip_whenClicked_triggersOnClick() {
        val onClick = mockk<() -> Unit> {
            every { this@mockk.invoke() } just runs
        }

        composeRule.setContent {
            WgcChip(label = chipLabel, selected = false, onClick = onClick)
        }

        composeRule.onNodeWithText(chipLabel)
            .performClick()

        verify(exactly = 1) { onClick() }
    }
}
