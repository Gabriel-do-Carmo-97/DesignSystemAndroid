package br.com.wgc.design_system.components.cards.carddetail

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigDecimal

@RunWith(AndroidJUnit4::class)
class ProductDetailCardTest {
    @get:Rule
    val createComposeRule = createComposeRule()

    /**
     * Verifica se o card exibe corretamente as informações essenciais e não expansíveis
     * na sua renderização inicial. Isso inclui o nome do produto, o preço e a imagem.
     */
    @Test
    fun whenRendered_displaysBasicInfoCorrectly() {
        val model = ProductDetailModel(
            image = "https://www.pexels.com/pt-br/foto/panorama-vista-paisagem-natureza-27986329/",
            imageDescription = "Paisagem",
            name = "Viagems",
            description = "Viagem para esse lugar",
            price = BigDecimal(149.99)
        )

        createComposeRule.setContent {
            ProductDetailCard(
                productDetailModel = model,
            )
        }
        val node = createComposeRule.onNodeWithText("Viagems")
        node.assertIsDisplayed()
        node.onChild().assertTextEquals("R\$ 149,99")
            .assertIsDisplayed()
        createComposeRule.onNodeWithContentDescription("Paisagem")
            .assertIsDisplayed()
    }

    /**
     * Verifica se a descrição do produto está inicialmente recolhida (colapsada),
     * mostrando apenas um número limitado de linhas e terminando com reticências para textos longos.
     */
    @Test
    fun withLongDescription_whenRendered_descriptionIsCollapsed() {
        // Passo 1: Configurar a regra de teste do Compose.
        // Passo 2: Definir um `ProductDetailModel` com uma string de descrição muito longa.
        // Passo 3: Renderizar o `ProductDetailCard` com este modelo.
        // Passo 4: Encontrar o nó de texto da descrição usando `onNodeWithText`.
        // Passo 5: Usar `assertIsDisplayed` para confirmar que ele está na tela.
        // Passo 6: Obter o resultado do layout do texto a partir da semântica do nó (`fetchSemanticsNode().layoutInfo`).
        // Passo 7: Afirmar que `isTextTruncated` é verdadeiro (true), o que confirma que as reticências (...) estão sendo exibidas.
    }

    /**
     * Simula um clique do usuário no card e verifica se o texto da descrição
     * se expande para mostrar seu conteúdo completo.
     */
    @Test
    fun whenCardIsClicked_descriptionExpands() {
        // Passo 1: Configurar a regra de teste do Compose.
        // Passo 2: Definir um `ProductDetailModel` com uma descrição longa.
        // Passo 3: Renderizar o `ProductDetailCard`.
        // Passo 4: Encontrar o nó principal do card. Você pode usar uma `testTag` ou encontrá-lo por um de seus filhos, como o nome do produto ou a descrição da imagem.
        // Passo 5: Executar uma ação de clique nesse nó usando `performClick()`.
        // Passo 6: Encontrar novamente o nó de texto da descrição usando `onNodeWithText`.
        // Passo 7: Obter o resultado do layout do seu texto (`fetchSemanticsNode().layoutInfo`).
        // Passo 8: Afirmar que `isTextTruncated` agora é falso (false).
    }

    /**
     * Simula dois cliques do usuário no card e verifica se o texto da descrição
     * retorna ao seu estado original recolhido (colapsado).
     */
    @Test
    fun whenCardIsClickedTwice_descriptionCollapsesAgain() {
        // Passo 1: Configurar a regra de teste do Compose com um modelo que tenha uma descrição longa.
        // Passo 2: Renderizar o `ProductDetailCard`.
        // Passo 3: Encontrar o nó principal do card.
        // Passo 4: Executar um clique usando `performClick()`.
        // Passo 5: Executar um segundo clique usando `performClick()`.
        // Passo 6: Encontrar o nó de texto da descrição.
        // Passo 7: Obter o resultado do seu layout de texto.
        // Passo 8: Afirmar que `isTextTruncated` é verdadeiro (true) novamente.
    }

    /**
     * Verifica que, quando um `ProductDetailModel` é fornecido com uma descrição nula ou vazia,
     * o campo de texto da descrição não é renderizado na árvore de componentes.
     */
    @Test
    fun withNullDescription_whenRendered_descriptionNodeDoesNotExist() {
        // Passo 1: Configurar a regra de teste do Compose.
        // Passo 2: Definir um `ProductDetailModel` com `description = null`. Use também um nome de produto único.
        // Passo 3: Renderizar o `ProductDetailCard`.
        // Passo 4: Afirmar que os nós do nome do produto e do preço *estão* visíveis, para garantir que o card foi renderizado.
        // Passo 5: Tentar encontrar um nó que conteria o texto da descrição. Como o texto é nulo, você não pode procurá-lo diretamente.
        // Passo 6: Uma maneira mais simples: Use `onNodeWithText` com o texto da descrição longa de outro teste e chame `assertDoesNotExist()`. Isso prova que aquele texto não está na tela.
    }
}