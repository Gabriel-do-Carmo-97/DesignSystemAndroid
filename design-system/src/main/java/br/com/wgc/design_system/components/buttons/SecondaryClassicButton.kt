package br.com.wgc.design_system.components.buttons.secondarybutton

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondaryClassicButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    textButton: String = "Button",
    isEnabled: Boolean = true
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        onClick = { onClick() },
        enabled = isEnabled,
        shape = RoundedCornerShape(15),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
            contentColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.12f),
            disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        ),
        border = BorderStroke(
            width = 1.5.dp,
            color = if (isEnabled) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
        )
    ) {
        Text(text = textButton, fontSize = 14.sp)
    }
}

@Preview(showBackground = true, name = "Only Component")
@Composable
private fun SecondaryClassicButtonPreview() = SecondaryClassicButton()


@Preview(showSystemUi = true, showBackground = true, name = "Component and SystemUi")
@Composable
private fun SecondaryClassicButtonPreview2() = SecondaryClassicButton()
