package br.com.wgc.design_system_wgc.showcase

/**
 * Utilitário de DX para geração instantânea de snippets de código Kotlin a partir das configurações ativas no Showcase.
 */
object WgcCodeSnippetHelper {

    fun generateButtonSnippet(text: String, isEnabled: Boolean, isLoading: Boolean): String {
        return """
            WgcClassicButton(
                text = "$text",
                onClick = { /* ação */ },
                isEnabled = $isEnabled,
                isLoading = $isLoading
            )
        """.trimIndent()
    }

    fun generateAccordionSnippet(title: String, subtitle: String?): String {
        val subParam = if (subtitle != null) ",\n    subtitle = \"$subtitle\"" else ""
        return """
            var isExpanded by remember { mutableStateOf(false) }
            
            WgcAccordion(
                title = "$title"$subParam,
                isExpanded = isExpanded,
                onToggle = { isExpanded = !isExpanded }
            ) {
                Text(text = "Conteúdo expandido")
            }
        """.trimIndent()
    }
}
