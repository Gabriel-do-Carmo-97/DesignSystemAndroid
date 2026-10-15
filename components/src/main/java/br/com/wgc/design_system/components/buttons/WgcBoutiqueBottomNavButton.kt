package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors

@Composable
fun WgcBoutiqueBottomNavButton(
    text: String = "",
    label: String = text,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val displayText = text.ifEmpty { label }
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(WgcCoreDsColors.purple8),
            contentColor = Color.White
        )
    ) {
        Text(
            text = displayText,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcBoutiqueBottomNavButtonPreview() {
    WgcBoutiqueBottomNavButton(
        text = "Add to Cart",
        onClick = {}
    )
}
