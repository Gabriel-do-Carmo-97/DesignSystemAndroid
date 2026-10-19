package br.com.wgc.design_system.components.sections

import androidx.compose.ui.graphics.Color
import br.com.wgc.design_system.core.theme.WgcCoreDsColors

data class WgcCircularCategoryItem(
    val id: String,
    val name: String,
    val initials: String,
    val backgroundColor: Color = Color(WgcCoreDsColors.gray100)
)
