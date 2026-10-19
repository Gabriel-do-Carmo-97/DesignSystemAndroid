package br.com.wgc.design_system.components.navigation

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Item de menu universal para fábricas de navegação.
 *
 * @param id Identificador único do item
 * @param label Rótulo textual
 * @param icon Ícone visual
 * @param badgeCount Contagem opcional para notificação/carrinho
 * @param isProminent Se verdadeiro, eleva o ícone em formato FAB na barra estilo e-commerce
 * @param onClick Ação executada ao clicar no item
 */
data class WgcMenuItem(
    val id: String = "",
    val label: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
    val isProminent: Boolean = false,
    val onClick: () -> Unit = {}
)
