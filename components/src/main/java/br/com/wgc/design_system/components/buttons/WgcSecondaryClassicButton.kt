package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import br.com.wgc.design_system.commons.WgcDevicePreviews

/**
 * Botão Secundário do Design System (WgcSecondaryClassicButton).
 */
@Composable
fun WgcSecondaryClassicButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    textButton: String = "Button"
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .semantics { role = Role.Button },
        onClick = { if (!isLoading) onClick() },
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.primary,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        enabled = isEnabled && !isLoading,
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        content = {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), color = MaterialTheme.colorScheme.primary, strokeWidth = 2.dp)
            } else {
                Text(text = textButton, fontSize = 14.sp)
            }
        },
    )
}

@WgcDevicePreviews
@Preview(showBackground = true, name = "Default - Enabled")
@Composable
private fun SecondaryClassicButtonDefaultPreview() = WgcSecondaryClassicButton(
    isEnabled = true
)

@WgcDevicePreviews
@Preview(showBackground = true, name = "Disabled State")
@Composable
private fun SecondaryClassicButtonDisabledPreview() = WgcSecondaryClassicButton(
    isEnabled = false
)

@WgcDevicePreviews
@Preview(showBackground = true, name = "Loading State")
@Composable
private fun SecondaryClassicButtonLoadingPreview() = WgcSecondaryClassicButton(
    isLoading = true
)