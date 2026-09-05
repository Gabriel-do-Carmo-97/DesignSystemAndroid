package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius

/**
 * Botão Secundário do Design System (WgcSecondaryClassicButton).
 */
@Composable
fun WgcSecondaryClassicButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true,
    textButton: String = "Button"
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .semantics { role = Role.Button },
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.primary,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        enabled = isEnabled,
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        content = {
            Text(text = textButton, fontSize = 14.sp)
        },
    )
}

@Deprecated("Utilize WgcSecondaryClassicButton para manter a padronização", ReplaceWith("WgcSecondaryClassicButton(modifier, onClick, isEnabled, textButton)"))
@Composable
fun SecondaryClassicButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true,
    textButton: String = "Button"
) {
    WgcSecondaryClassicButton(modifier, onClick, isEnabled, textButton)
}

@Preview(showBackground = true)
@Composable
private fun SecondaryClassicButtonPreview() = WgcSecondaryClassicButton()
