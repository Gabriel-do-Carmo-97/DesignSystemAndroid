package br.com.wgc.design_system.components.buttons

import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
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

class ClassicButtonTest {
    @get:Rule
    val createComposeRule = createComposeRule()

    private val buttonText: String = "Secondary Button"

    /**
     * Testa se o botão é exibido corretamente na tela
     * com o texto fornecido.
     */
    @Test
    fun classicButton_whenRendered_isDisplayed() {
        createComposeRule.setContent {
            ClassicButton(textButton = buttonText)
        }
        createComposeRule.onNodeWithText(buttonText)
            .assertIsDisplayed()
            .assertTextEquals(buttonText)
            .assertHeightIsEqualTo(56.dp)
    }

    /**
     * Testa se o botão está habilitado por padrão e se a função
     * de clique é chamada quando ele é pressionado.
     */
    @Test
    fun classicButton_whenEnabled_isClickable() {
        val isClicked: () -> Unit = mockk {
            every { this@mockk.invoke() } just runs
        }
        createComposeRule.setContent {
            ClassicButton(textButton = buttonText, onClick = isClicked)
        }
        createComposeRule.onNodeWithText(buttonText)
            .assertIsEnabled()
            .performClick()
        verify(exactly = 1) { isClicked() }
    }


    /**
     * Testa se o botão é exibido no estado desabilitado
     * quando o parâmetro `enabled` é `false`.
     */
    @Test
    fun classicButton_whenDisabled_isNotClickable() {
        val isClicked: () -> Unit = mockk {
            every { this@mockk.invoke() } just runs
        }
        createComposeRule.setContent {
            ClassicButton(
                textButton = buttonText,
                onClick = isClicked,
                isEnabled = false
            )
        }
        createComposeRule.onNodeWithText(buttonText)
            .assertIsNotEnabled()
            .performClick()
        verify(exactly = 0) { isClicked() }

    }
}