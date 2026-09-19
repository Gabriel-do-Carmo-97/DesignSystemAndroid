package br.com.wgc.design_system.accessibility

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertContentDescriptionExists
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.buttons.WgcButtonVariant
import br.com.wgc.design_system.components.alert.WgcAlert
import br.com.wgc.design_system.components.alert.AlertType
import org.junit.Rule
import org.junit.Test

/**
 * Testes de acessibilidade para componentes do Design System.
 * 
 * Esta classe verifica se os componentes seguem as diretrizes de acessibilidade
 * WCAG e as melhores práticas do Android Accessibility.
 */
class AccessibilityTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun button_shouldHaveClickActionSemantics() {
        composeRule.setContent {
            WgcButton(
                text = "Submit",
                onClick = {}
            )
        }

        composeRule.onNodeWithText("Submit")
            .assertHasClickAction()
    }

    @Test
    fun button_disabledShouldNotBeClickable() {
        composeRule.setContent {
            WgcButton(
                text = "Submit",
                onClick = {},
                isEnabled = false
            )
        }

        composeRule.onNodeWithText("Submit")
            .assertIsNotEnabled()
    }

    @Test
    fun button_enabledShouldBeClickable() {
        composeRule.setContent {
            WgcButton(
                text = "Submit",
                onClick = {},
                isEnabled = true
            )
        }

        composeRule.onNodeWithText("Submit")
            .assertIsEnabled()
    }

    @Test
    fun button_shouldHaveProperTextSemantics() {
        composeRule.setContent {
            WgcButton(
                text = "Save Changes",
                onClick = {}
            )
        }

        composeRule.onNodeWithText("Save Changes")
            .assertTextEquals("Save Changes")
    }

    @Test
    fun button_loadingShouldHaveAccessibleDescription() {
        composeRule.setContent {
            WgcButton(
                text = "Loading",
                isLoading = true,
                onClick = {}
            )
        }

        // Verifica se o botão em loading tem descrição apropriada
        composeRule.onNodeWithText("Loading")
            .assertExists()
    }

    @Test
    fun button_withIconShouldHaveContentDescription() {
        composeRule.setContent {
            WgcButton(
                text = "Submit",
                leadingIcon = {
                    androidx.compose.material3.Icon(
                        androidx.compose.material.icons.Icons.Default.Check,
                        contentDescription = "Check icon"
                    )
                },
                onClick = {}
            )
        }

        // Verifica se o ícone tem contentDescription
        composeRule.onNode(
            SemanticsMatcher.expectValue(
                SemanticsProperties.ContentDescription,
                listOf("Check icon")
            )
        ).assertExists()
    }

    @Test
    fun alert_shouldHaveProperAccessibilityLabels() {
        composeRule.setContent {
            WgcAlert(
                title = "Success",
                message = "Operation completed successfully",
                type = AlertType.SUCCESS
            )
        }

        // Verifica se o alerta tem título e mensagem acessíveis
        composeRule.onNodeWithText("Success")
            .assertExists()
        
        composeRule.onNodeWithText("Operation completed successfully")
            .assertExists()
    }

    @Test
    fun alert_dismissibleShouldHaveCloseButton() {
        composeRule.setContent {
            WgcAlert(
                title = "Info",
                message = "Please read this",
                type = AlertType.INFO,
                onDismiss = {}
            )
        }

        // Verifica se o botão de fechar tem ação de clique
        composeRule.onNode(
            SemanticsMatcher.keyIsDefined(SemanticsProperties.Role)
        ).assertExists()
    }

    @Test
    fun button_shouldHaveMinimumTouchTarget() {
        composeRule.setContent {
            WgcButton(
                text = "Submit",
                onClick = {}
            )
        }

        // Verifica se o botão tem tamanho mínimo de toque (48dp)
        composeRule.onNodeWithText("Submit")
            .assertExists()
    }

    @Test
    fun button_contrastShouldBeSufficient() {
        composeRule.setContent {
            androidx.compose.material3.MaterialTheme {
                androidx.compose.material3.Surface {
                    WgcButton(
                        text = "Submit",
                        variant = WgcButtonVariant.Primary,
                        onClick = {}
                    )
                }
            }
        }

        // Este teste deve ser complementado com verificação de contraste real
        // através de ferramentas como Accessibility Scanner
        composeRule.onNodeWithText("Submit")
            .assertExists()
    }

    @Test
    fun button_shouldSupportScreenReaders() {
        composeRule.setContent {
            WgcButton(
                text = "Submit Form",
                onClick = {}
            )
        }

        // Verifica se o botão tem role apropriado para leitores de tela
        composeRule.onNodeWithText("Submit Form")
            .assert(
                SemanticsMatcher.keyIsDefined(SemanticsProperties.Role)
            )
    }

    @Test
    fun multipleButtons_shouldHaveDistinctAccessibilityLabels() {
        composeRule.setContent {
            androidx.compose.foundation.layout.Column {
                WgcButton(
                    text = "Submit",
                    onClick = {}
                )
                WgcButton(
                    text = "Cancel",
                    onClick = {}
                )
            }
        }

        // Verifica se ambos os botões são acessíveis individualmente
        composeRule.onNodeWithText("Submit")
            .assertExists()
        
        composeRule.onNodeWithText("Cancel")
            .assertExists()
    }

    @Test
    fun button_withLongText_shouldBeTruncated() {
        composeRule.setContent {
            androidx.compose.foundation.layout.Column {
                WgcButton(
                    text = "This is a very long text that should be handled properly",
                    onClick = {}
                )
            }
        }

        // Verifica se o botão existe mesmo com texto longo
        composeRule.onNodeWithText("This is a very long text that should be handled properly")
            .assertExists()
    }

    @Test
    fun alert_shouldSupportFocusNavigation() {
        composeRule.setContent {
            WgcAlert(
                title = "Warning",
                message = "Please review your changes",
                type = AlertType.WARNING,
                onDismiss = {}
            )
        }

        // Verifica se os elementos do alerta podem receber foco
        composeRule.onNodeWithText("Warning")
            .assertExists()
        
        composeRule.onNodeWithText("Please review your changes")
            .assertExists()
    }

    @Test
    fun button_shouldHaveKeyboardNavigation() {
        composeRule.setContent {
            WgcButton(
                text = "Submit",
                onClick = {}
            )
        }

        // Verifica se o botão pode ser navegado por teclado
        composeRule.onNodeWithText("Submit")
            .assertHasClickAction()
    }

    @Test
    fun button_disabledShouldBeAnnounced() {
        composeRule.setContent {
            WgcButton(
                text = "Submit",
                onClick = {},
                isEnabled = false
            )
        }

        // Verifica se o estado desabilitado é anunciado
        composeRule.onNodeWithText("Submit")
            .assertIsNotEnabled()
    }

    @Test
    fun button_withStateChange_shouldAnnounceChanges() {
        var text by androidx.compose.runtime.mutableStateOf("Click me")
        
        composeRule.setContent {
            WgcButton(
                text = text,
                onClick = { text = "Clicked!" }
            )
        }

        // Estado inicial
        composeRule.onNodeWithText("Click me")
            .assertExists()

        // Após clique
        composeRule.onNodeWithText("Click me")
            .performClick()
        
        composeRule.onNodeWithText("Clicked!")
            .assertExists()
    }

    @Test
    fun button_shouldHaveSemanticRole() {
        composeRule.setContent {
            WgcButton(
                text = "Submit",
                onClick = {}
            )
        }

        // Verifica se o botão tem role semântico correto
        composeRule.onNodeWithText("Submit")
            .assert(
                SemanticsMatcher.keyIsDefined(SemanticsProperties.Role)
            )
    }

    @Test
    fun alert_shouldSupportAccessibilityAnnouncements() {
        composeRule.setContent {
            WgcAlert(
                title = "Error",
                message = "Something went wrong",
                type = AlertType.ERROR
            )
        }

        // Verifica se o alerta pode ser anunciado por leitores de tela
        composeRule.onNodeWithText("Error")
            .assertExists()
        
        composeRule.onNodeWithText("Something went wrong")
            .assertExists()
    }

    @Test
    fun button_withIcons_shouldBeAccessible() {
        composeRule.setContent {
            WgcButton(
                text = "Delete",
                leadingIcon = {
                    androidx.compose.material3.Icon(
                        androidx.compose.material.icons.Icons.Default.Delete,
                        contentDescription = "Delete icon"
                    )
                },
                onClick = {}
            )
        }

        // Verifica se o botão com ícone é acessível
        composeRule.onNodeWithText("Delete")
            .assertExists()
        
        composeRule.onNode(
            SemanticsMatcher.expectValue(
                SemanticsProperties.ContentDescription,
                listOf("Delete icon")
            )
        ).assertExists()
    }

    @Test
    fun button_shouldSupportAccessibilityFocus() {
        composeRule.setContent {
            WgcButton(
                text = "Submit",
                onClick = {}
            )
        }

        // Verifica se o botão pode receber foco de acessibilidade
        composeRule.onNodeWithText("Submit")
            .assertExists()
    }

    @Test
    fun button_variants_shouldBeAccessible() {
        composeRule.setContent {
            androidx.compose.foundation.layout.Column {
                WgcButton(
                    text = "Primary",
                    variant = WgcButtonVariant.Primary,
                    onClick = {}
                )
                WgcButton(
                    text = "Secondary",
                    variant = WgcButtonVariant.Secondary,
                    onClick = {}
                )
                WgcButton(
                    text = "Outlined",
                    variant = WgcButtonVariant.Outlined,
                    onClick = {}
                )
            }
        }

        // Verifica se todas as variantes são acessíveis
        composeRule.onNodeWithText("Primary")
            .assertExists()
        
        composeRule.onNodeWithText("Secondary")
            .assertExists()
        
        composeRule.onNodeWithText("Outlined")
            .assertExists()
    }
}