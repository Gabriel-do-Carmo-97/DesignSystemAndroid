@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.components.previews

/**
 * Anotação para vincular um Composable ao seu componente correspondente no Figma.
 * Utilizada por ferramentas de inspeção e auditoria visual.
 *
 * @param figmaNodeId Identificador do nó no Figma (ex: "123:4567")
 * @param figmaUrl URL canônica para o frame no Figma
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class WgcFigmaDoc(
    val figmaNodeId: String,
    val figmaUrl: String = ""
)
