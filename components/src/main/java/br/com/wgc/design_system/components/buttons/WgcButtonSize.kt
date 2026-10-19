package br.com.wgc.design_system.components.buttons

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Tamanhos padronizados para o WgcButton.
 * 
 * Esta enum define os tamanhos pré-configurados seguindo os tokens de design:
 * - [Small]: Botão compacto para espaços limitados (altura 36dp)
 * - [Medium]: Tamanho padrão para maioria dos casos (altura 56dp)
 * - [Large]: Botão destacado para ações importantes (altura 64dp)
 * 
 * @property minHeight Altura mínima do botão em dp
 * @property horizontalPadding Espaçamento horizontal interno em dp
 * @property fontSize Tamanho da fonte do texto em sp
 * @property indicatorSize Tamanho do indicador de carregamento em dp
 */
enum class WgcButtonSize(
    val minHeight: Dp,
    val horizontalPadding: Dp,
    val fontSize: TextUnit,
    val indicatorSize: Dp
) {
    /**
     * Botão compacto para espaços limitados.
     * Altura: 36dp, Fonte: 12sp
     */
    Small(
        minHeight = 36.dp,
        horizontalPadding = WgcCoreDsSpacing.SM12.dp,
        fontSize = 12.sp,
        indicatorSize = 16.dp
    ),
    
    /**
     * Tamanho padrão para maioria dos casos.
     * Altura: 56dp, Fonte: 14sp
     */
    Medium(
        minHeight = 56.dp,
        horizontalPadding = WgcCoreDsSpacing.MD16.dp,
        fontSize = 14.sp,
        indicatorSize = 24.dp
    ),
    
    /**
     * Botão destacado para ações importantes.
     * Altura: 64dp, Fonte: 16sp
     */
    Large(
        minHeight = 64.dp,
        horizontalPadding = WgcCoreDsSpacing.LG24.dp,
        fontSize = 16.sp,
        indicatorSize = 28.dp
    )
}
