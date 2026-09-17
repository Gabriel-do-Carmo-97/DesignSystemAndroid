package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize

/**
 * Botão de rodapé fixo oficial do Laza (WgcBoutiqueBottomNavButton).
 * Ocupa a largura total na base da tela com fundo roxo primário (#9775FA) e tipografia em destaque.
 */
@Composable
fun WgcBoutiqueBottomNavButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(WgcCoreDsSize.s54.dp)
            .background(
                if (enabled) Color(WgcCoreDsColors.boutiquePrimary)
                else Color(WgcCoreDsColors.boutiquePrimary).copy(alpha = 0.5f)
            )
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaBottomNavButtonPreview() {
    WgcBoutiqueBottomNavButton(label = "Add to Cart")
}
