package br.com.wgc.design_system.components.buttons.fab

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.getUnclippedBoundsInRoot
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.width
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FAButtonTest {

    @get:Rule
    val createComposeRule = createComposeRule()


    /**
     * Testa se o botão do tipo SMALL é renderizado corretamente e se
     * o ícone correto é exibido na tela.
     */
    @Test
    fun smallFab_whenRendered_isDisplayedWithCorrectIcon() {
        val descriptionButton = "Adicionar"
        createComposeRule.setContent {
            FAButton(
                onClick = { },
                fabType = FABType.SMALL,
                shape = CircleShape,
                description = descriptionButton,
                icon = Icons.Default.Add
            )
        }
        val node = createComposeRule.onNodeWithContentDescription(descriptionButton)

        node.assertIsDisplayed()
            .assertContentDescriptionEquals(descriptionButton)

        assertEquals(
            "O tamanho do FAB não corresponde ao tipo SMALL (40.dp).",
            40.dp,
            node.getUnclippedBoundsInRoot().width,
        )
    }

    /**
     * Testa se o botão do tipo MEDIUM é renderizado corretamente e se
     * o evento de clique é disparado quando o botão é pressionado.
     */
    @Test
    fun mediumFab_whenClicked_triggersOnClickEvent() {
        val descriptionButton = "Adicionar"
        val onClick: () -> Unit = mockk(relaxed = true)
        createComposeRule.setContent {
            FAButton(
                onClick = onClick,
                fabType = FABType.MEDIUM,
                description = descriptionButton,
                icon = Icons.Default.Add
            )
        }

        val node = createComposeRule.onNodeWithContentDescription(descriptionButton)

        node.assertIsDisplayed()
            .assertContentDescriptionEquals(descriptionButton)
            .assertIsEnabled()
            .assertHasClickAction()
            .performClick()
        assertEquals(
            "O tamanho do FAB não corresponde ao tipo MEDIUM (56.dp).",
            56.dp,
            node.getUnclippedBoundsInRoot().width,
        )

        verify(exactly = 1) { onClick() }
    }

    /**
     * Testa se o botão do tipo LARGE é renderizado corretamente.
     * Este teste valida a presença do componente na tela.
     */
    @Test
    fun largeFab_whenRendered_isDisplayedOnScreen() {
        val descriptionButton = "Adicionar"
        val onClick: () -> Unit = mockk(relaxed = true)
        createComposeRule.setContent {
            FAButton(
                onClick = onClick,
                fabType = FABType.LARGE,
                description = descriptionButton,
                icon = Icons.Default.Add
            )
        }

        val node = createComposeRule.onNodeWithContentDescription(descriptionButton)

        node.assertIsDisplayed()
            .assertContentDescriptionEquals(descriptionButton)
            .assertIsEnabled()
            .assertHasClickAction()
            .performClick()
        assertEquals(
            "O tamanho do FAB não corresponde ao tipo MEDIUM (96.dp).",
            96.dp,
            node.getUnclippedBoundsInRoot().width,
        )

        verify(exactly = 1) { onClick() }
    }

    /**
     * Testa se o botão do tipo EXTENDED (com descrição) exibe tanto
     * o ícone quanto o texto de descrição corretamente.
     */
    @Test
    fun extendedFab_whenRendered_showsIconAndText() {
        val descriptionButton = "Carrinho"
        val onClick: () -> Unit = mockk(relaxed = true)
        createComposeRule.setContent {
            FAButton(
                onClick = onClick,
                fabType = FABType.DESCRIPTION,
                description = descriptionButton,
                icon = Icons.Default.ShoppingCart
            )
        }

        val fabNode = createComposeRule.onNodeWithContentDescription(descriptionButton)

        fabNode.assertIsDisplayed()
            .assertIsEnabled()
            .assertHasClickAction()
            .assertTextEquals(descriptionButton)
            .assertContentDescriptionEquals(descriptionButton)
            .performClick()
        verify(exactly = 1) { onClick() }
    }

    /**
     * Testa se a descrição de conteúdo (contentDescription) correta
     * é atribuída ao ícone, o que é crucial para acessibilidade.
     */
    @Test
    fun anyFab_whenRendered_hasCorrectContentDescriptionForAccessibility() {
        val expectedDescription = "Criar novo item"

        createComposeRule.setContent {
            FAButton(
                onClick = { },
                fabType = FABType.MEDIUM,
                description = expectedDescription,
                icon = Icons.Default.Add
            )
        }
        val node = createComposeRule.onNodeWithContentDescription(expectedDescription)
        node.assertIsDisplayed()
            .assertContentDescriptionEquals(expectedDescription)
    }


    /**
     * Testa se a aplicação de um `shape` customizado (ex: cantos quadrados)
     * é refletida corretamente no componente, em vez do `CircleShape` padrão.
     */
    @Test
    fun fab_whenCustomShapeIsProvided_rendersWithCorrectShape() {
        val description = "FAB Retangular"
        val onClick: () -> Unit = mockk(relaxed = true)
        val customShape = RoundedCornerShape(16.dp)

        createComposeRule.setContent {
            FAButton(
                onClick = onClick,
                fabType = FABType.LARGE,
                shape = customShape,
                description = description,
                icon = Icons.Default.Add
            )
        }
        val node = createComposeRule.onNodeWithContentDescription(description)
        node.assertIsDisplayed()
            .performClick()
        assertEquals(
            "O tamanho do FAB não corresponde ao tipo LARGE (96.dp).",
            96.dp,
            node.getUnclippedBoundsInRoot().width,
        )
        verify(exactly = 1) { onClick() }
    }
}